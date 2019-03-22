package me.xueyao.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


/**
 * @author: Simon.Xue
 * @date: 2019/3/22 14:41
 */
@Component
public class CheckUtil {
    private static final Logger logger = LoggerFactory.getLogger(CheckUtil.class);

    @Value("${weixin.token}")
    private String token;

    public boolean checkSignature(String signature, String timestamp, String nonce) {
        String[] arr = {signature, timestamp, nonce};
        Arrays.sort(arr);
        StringBuilder content = new StringBuilder();
        for (String s : arr) {
            content.append(s);
        }

        MessageDigest md;
        String tmpStr = null;

        try {
            md = MessageDigest.getInstance("SHA-1");
            byte[] digest = md.digest(content.toString().getBytes());
            tmpStr = byteToStr(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        logger.info("执行微信签名加密认证");
        content = null;
        return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
    }

    /**
     * 字节数组转换成字符串
     * @param byteArray
     * @return
     */
    private String byteToStr(byte[] byteArray) {
        StringBuilder strDigest = new StringBuilder();
        for (byte mByte : byteArray) {
            strDigest.append(byteToHexStr(mByte));
        }
        return strDigest.toString();
    }

    /**
     * 将字节转为十六进制字符串
     * @param mByte
     * @return
     */
    private String byteToHexStr(byte mByte) {
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];

        return new StringBuilder().append(tempArr).toString();
    }
}
