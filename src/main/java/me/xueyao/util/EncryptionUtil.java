package me.xueyao.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 加密工具类
 * @author: Simon.Xue
 * @date: 2019/3/25 9:28
 */
public class EncryptionUtil {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6'
            , '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 加密
     * @param algorithm  算法名称
     * @param body  要加密的字符串
     * @return  加密后的字符串
     */
    public static String encrypt(String algorithm, String body) {
        if (null == algorithm || null == body) {
            return null;
        }
        try {
            MessageDigest digest = MessageDigest.getInstance(algorithm);
            digest.update(body.getBytes());
            return getFormatText(digest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 字节数组转换成字符串
     * @param bytes
     * @return
     */
    private static String getFormatText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder sb = new StringBuilder(len * 2);
        //把密文转换成十六进制的字符串形式
        for (int i = 0; i < len; i++) {
            sb.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            sb.append(HEX_DIGITS[(bytes[i] & 0x0f)]);
        }
        return sb.toString();
    }
}
