package me.xueyao.controller;

import com.alibaba.fastjson.JSONObject;
import me.xueyao.common.BaseResponse;
import me.xueyao.config.WeiXinConfig;
import me.xueyao.constant.ResponseStatus;
import me.xueyao.entity.UserInfo;
import me.xueyao.entity.UserToken;
import me.xueyao.entity.WeiXinToken;
import me.xueyao.util.CheckSignatureUtil;
import me.xueyao.util.HttpClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author: Simon.Xue
 * @date: 2019/3/25 12:56
 */
@RestController
@RequestMapping("/wx")
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private WeiXinConfig weiXinConfig;

    @Autowired
    private CheckSignatureUtil checkSignatureUtil;

    @GetMapping("/check")
    public void checkWxMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //微信加密签名
        String signature = request.getParameter("signature");
        //随机字符串
        String echostr = request.getParameter("echostr");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(echostr)
                || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(timestamp)
                || StringUtils.isEmpty(nonce)) {
            logger.warn("公众号请求头不能为空");
            return;
        }
        if (checkSignatureUtil.checkSignature(signature, timestamp, nonce)) {
            response.getWriter().write(echostr);
        }

    }

    @GetMapping("/token")
    public BaseResponse getWeiXinToken() {
        logger.info("开始获取微信access_token");
        BaseResponse response = new BaseResponse(ResponseStatus.SUCCESS);
        String url = weiXinConfig.getTokenUrl().replaceAll("APPID", weiXinConfig.getAppId())
                .replaceAll("APPSECRET", weiXinConfig.getAppSecret());
        logger.info("url = {}", url);
        String result = HttpClientUtil.sendGetData(url);
        WeiXinToken weiXinToken = JSONObject.parseObject(result, WeiXinToken.class);
        if (StringUtils.isEmpty(weiXinToken.getAccessToken())
                || StringUtils.isEmpty(weiXinToken.getExpiresIn())) {
            logger.warn("获取微信access_token失败");
            response.setCode(weiXinToken.getErrcode());
            response.setMsg(weiXinToken.getErrmsg());
            return response;
        }


        logger.info("获取微信access_token成功, {}", JSONObject.toJSONString(weiXinToken));
        response.setMsg("获取微信access_token成功");
        response.setData(result);
        return response;
    }
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
        String result = HttpClientUtil.sendGetData(url);
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
        String result = HttpClientUtil.sendGetData(accessTokenUrl);
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
        String userInfoStr = HttpClientUtil.sendGetData(getUserInfoUrl);
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
