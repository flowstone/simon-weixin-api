package me.xueyao.controller;

import me.xueyao.common.WeiXinUtils;
import me.xueyao.util.CheckUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Simon.Xue
 * @date: 2019/3/22 15:13
 */
@RestController
@RequestMapping(value = "/wechat")
public class WeixinCoreController {

    private static Logger logger = LoggerFactory.getLogger(WeixinCoreController.class);
    @Autowired
    private CheckUtil checkUtil;

    @GetMapping("/access")
    public String WeChatLogin(HttpServletRequest request) {
        logger.info("验证微信服务号信息开始");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        logger.info("signature = {}, timestamp = {}, nonce = {}, echostr = {}", signature, timestamp, nonce, echostr);
        if (checkUtil.checkSignature(signature, timestamp, nonce)) {
            logger.info("验证微信服务号结束");
            return echostr;
        } else {
            logger.warn("不是微信服务器发过来的请求，请小心！");
            return null;
        }
    }
}
