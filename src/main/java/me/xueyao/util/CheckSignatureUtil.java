package me.xueyao.util;

import me.xueyao.config.WeiXinConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author: Simon.Xue
 * @date: 2019/3/27 16:42
 */
@Configuration
public class CheckSignatureUtil {

    private final Logger logger = LoggerFactory.getLogger(CheckSignatureUtil.class);
    @Autowired
    private WeiXinConfig weiXinConfig;

    /**
     * 微信检查签名
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public  boolean checkSignature(String signature,String timestamp, String nonce) {
        String[] str = {timestamp, nonce, weiXinConfig.getToken()};
        Arrays.sort(str);
        StringBuffer sb = new StringBuffer();
        for (String s : str) {
            sb.append(s);
        }

        String encryptStr = EncryptionUtil.encrypt("SHA1", sb.toString());
        if (signature.equalsIgnoreCase(encryptStr)) {
            logger.info("请求头匹配成功，encryptStr = {}", encryptStr);
            return true;
        }
        return false;
    }
}
