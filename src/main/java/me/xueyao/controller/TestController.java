package me.xueyao.controller;

import com.alibaba.fastjson.JSONObject;
import me.xueyao.common.BaseResponse;
import me.xueyao.config.WeiXinConfig;
import me.xueyao.constant.ResponseStatus;
import me.xueyao.entity.WeiXinToken;
import me.xueyao.util.EncryptionUtil;
import me.xueyao.util.HttpClientUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author: Simon.Xue
 * @date: 2019/3/22 17:47
 */
@RestController
@RequestMapping("/wx")
public class TestController {
    private final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private WeiXinConfig weiXinConfig;
    @GetMapping("/check")
    public String checkWxMsg(HttpServletRequest request) {
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
            return null;
        }

        String[] str = {timestamp, nonce, weiXinConfig.getToken()};

        Arrays.sort(str);

        StringBuffer sb = new StringBuffer();
        for (String s : str) {
            sb.append(s);
        }

        String encryptStr = EncryptionUtil.encrypt("SHA1", sb.toString());
        if (signature.equalsIgnoreCase(encryptStr)) {
            logger.info("请求头匹配成功，encryptStr = {}", encryptStr);
            return echostr;
        }

        logger.warn("请求头匹配失败");
        return null;
    }

    @GetMapping("/token")
    public BaseResponse getWeiXinToken() {
        logger.info("开始获取微信access_token");
        BaseResponse response = new BaseResponse(ResponseStatus.SUCCESS);
        String url = weiXinConfig.getTokenUrl().replaceAll("APPID", weiXinConfig.getAppId())
                .replaceAll("APPSECRET", weiXinConfig.getAppSecret());
        logger.info("url = {}", url);
        String result = HttpClientUtils.sendGetData(url);
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
}
