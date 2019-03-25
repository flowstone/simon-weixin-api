package me.xueyao.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import me.xueyao.common.BaseResponse;
import me.xueyao.config.WeiXinConfig;
import me.xueyao.constant.ResponseStatus;
import me.xueyao.entity.UserInfo;
import me.xueyao.entity.UserToken;
import me.xueyao.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author: Simon.Xue
 * @date: 2019/3/25 12:56
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private WeiXinConfig weiXinConfig;

    /**
     * 用户授权
     * @return
     */
    @GetMapping("/auth")
    public String siteAuth() {
        logger.info("用户开始同意授权");
        //BaseResponse response = new BaseResponse(ResponseStatus.SUCCESS);
        //设置回调路径
        String redirectUri = "http://flowstone.iask.in/login/getUserInfo";
        String encode = "";
        try {
            //路径编码
            encode = URLEncoder.encode(redirectUri, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String url = weiXinConfig.getLoginUrl().replaceAll("APPID", weiXinConfig.getAppId())
                .replaceAll("REDIRECT_URI", encode)
                .replaceAll("SCOPE", "snsapi_base");
        logger.info("url = {}", url);
        String result = HttpClientUtils.sendGetData(url);
        //response.setData(result);
        logger.info("result = {}", result);
        return result;
    }

    /**
     * 获取用户access_token
     * @param code
     * @return
     */
    @GetMapping("/getUserInfo")
    public BaseResponse getUserInfo(@RequestParam("code") String code) {
        logger.info("获得用户code = {}", code);
        BaseResponse response = new BaseResponse(ResponseStatus.SUCCESS);
        String accessTokenUrl = weiXinConfig.getAccessToken().replaceAll("APPID", weiXinConfig.getAppId())
                .replaceAll("SECRET", weiXinConfig.getAppSecret())
                .replaceAll("CODE", code);
        String result = HttpClientUtils.sendGetData(accessTokenUrl);
        UserToken userToken = JSONObject.parseObject(result, UserToken.class);
        if (StringUtils.isEmpty(userToken.getAccessToken())) {
            logger.warn("获得用户Token失败，{}", JSONObject.toJSONString(userToken));
            response.setCode(userToken.getErrcode());
            response.setMsg(userToken.getErrmsg());
            return response;
        }
        logger.info("获得用户Token成功，Token = {}", result);

        //获取用户信息 需要授权(用户)
        String getUserInfoUrl = weiXinConfig.getPullUserInfo().replaceAll("ACCESS_TOKEN", userToken.getAccessToken())
                .replaceAll("OPENID", userToken.getOpenid());
        String userInfoStr = HttpClientUtils.sendGetData(getUserInfoUrl);
        UserInfo userInfo = JSONObject.parseObject(userInfoStr, UserInfo.class);
        if (StringUtils.isEmpty(userInfo.getOpenid())) {
            logger.warn("获得用户信息失败，userInfo = {}", JSONObject.toJSONString(userInfo));
            response.setCode(userInfo.getErrcode());
            response.setMsg(userInfo.getErrmsg());
            return response;
        }
        logger.info("获得用户信息成功，userInfo = {}", JSONObject.toJSONString(userInfo));
        response.setMsg("获得用户信息成功");
        response.setData(userInfo);
        return response;
    }

}
