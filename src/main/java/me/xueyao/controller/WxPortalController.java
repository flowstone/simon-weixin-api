package me.xueyao.controller;

import com.alibaba.fastjson.JSONObject;
import me.xueyao.config.WeiXinConfig;
import me.xueyao.constant.WxConsts;
import me.xueyao.entity.WeiXinToken;
import me.xueyao.entity.message.request.InTextMessage;
import me.xueyao.util.CheckSignatureUtil;
import me.xueyao.util.HttpClientUtil;
import me.xueyao.util.MessageUtil;
import me.xueyao.util.ReplyMessageUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Map;

/**
 * @author: Simon.Xue
 * @date: 2019/3/25 12:56
 */
@RestController
@RequestMapping("/wx")
public class WxPortalController {
    private final Logger logger = LoggerFactory.getLogger(WxPortalController.class);

    @Autowired
    private WeiXinConfig weiXinConfig;

    @Autowired
    private CheckSignatureUtil checkSignatureUtil;

    /**
     * 微信认证接口
     * @param signature
     * @param echostr
     * @param timestamp
     * @param nonce
     * @return
     * @throws IOException
     */
    @GetMapping
    public String authGet(@RequestParam(name = "signature", required = false) String signature,
                           @RequestParam(name = "echostr", required = false) String echostr,
                           @RequestParam(name = "timestamp", required = false) String timestamp,
                           @RequestParam(name = "nonce", required = false) String nonce) throws IOException {

        logger.info("接收到来自微信服务器的认证消息：[signature = {}, echostr = {}, timestamp = {}, nonce = {}]",
                signature, echostr, timestamp, nonce);
        if (StringUtils.isEmpty(signature) || StringUtils.isEmpty(echostr)
                || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(timestamp)
                || StringUtils.isEmpty(nonce)) {
            logger.warn("请求参数非法，请核实!");
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }
        if (checkSignatureUtil.checkSignature(signature, timestamp, nonce)) {
            return echostr;
        }
        return "非法请求";
    }

    @PostMapping
    public String post(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String, String> map = MessageUtil.convertXMLToMap(request);
        logger.info("map = {}", JSONObject.toJSONString(map));
        String msgType = map.get("MsgType");
        String result = "";
        switch (msgType) {
            case WxConsts.XmlMsgType.TEXT:
                result = handleTextMessage(map);
                break;
            case WxConsts.XmlMsgType.IMAGE:
                result = handleImageMessage(map);
                break;
            case WxConsts.XmlMsgType.VOICE:
                result = handleVoiceMessage(map);
                break;
            case WxConsts.XmlMsgType.VIDEO:
                handleVideoMessage(map);
                break;
            case WxConsts.XmlMsgType.LOCATION:
                result = handleLocationMessage(map);
                break;
            case WxConsts.XmlMsgType.LINK:
                result = handleLinkMessage(map);
                break;
            default:
                logger.info("这是啥");
        }
        return result;
    }

    private String handleLinkMessage(Map<String, String> map) {
        return "";
    }

    private String handleLocationMessage(Map<String, String> map) {
        return "";
    }

    private String handleVideoMessage(Map<String, String> map) {
        return "";
    }

    private String handleVoiceMessage(Map<String, String> map) {
        return "";
    }

    private String handleImageMessage(Map<String, String> map) {
        return "";
    }

    private String handleTextMessage(Map<String, String> map) {
        InTextMessage inTextMessage = new InTextMessage();
        inTextMessage.setToUserName(map.get("FromUserName"));
        inTextMessage.setFromUserName(map.get("ToUserName"));
        inTextMessage.setCreateTime(new Date().getTime());
        inTextMessage.setContent(map.get("Content"));
        inTextMessage.setMsgType(map.get("MsgType"));
        return ReplyMessageUtil.sendTextMessage(inTextMessage);
        //return MessageUtil.convertObjectToXml(inTextMessage);
    }

    @GetMapping("/token")
    public String getWeiXinToken() {
        logger.info("开始获取微信access_token");
        String url = weiXinConfig.getTokenUrl().replaceAll("APPID", weiXinConfig.getAppId())
                .replaceAll("APPSECRET", weiXinConfig.getAppSecret());
        logger.info("url = {}", url);
        String result = HttpClientUtil.sendGetData(url);
        WeiXinToken weiXinToken = JSONObject.parseObject(result, WeiXinToken.class);
        if (StringUtils.isEmpty(weiXinToken.getAccessToken())
                || StringUtils.isEmpty(weiXinToken.getExpiresIn())) {
            logger.warn("获取微信access_token失败");
            return JSONObject.toJSONString(weiXinToken);
        }


        logger.info("获取微信access_token成功, {}", JSONObject.toJSONString(weiXinToken));
        return JSONObject.toJSONString(weiXinToken);
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
    /*@GetMapping("/getUserInfo")
    public String getUserInfo(@RequestParam("code") String code) {
        logger.info("获得用户code = {}", code);
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
    }*/

}
