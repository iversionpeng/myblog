package com.zhy.utils;

import org.springframework.beans.factory.annotation.Value;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author: zhangocean
 * @Date: 2018/6/5 19:58
 * Describe: MD5加密工具
 */
public class MD5Util {

    private static String salt = "pengpengfei";


    public static String encode(String password) {
        password += salt;
        // 得到一个信息摘要器
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("md5");
            byte[] result;
            result = digest.digest(password.getBytes("utf-8"));
            // 把每一个byte 做一个与运算 0xff;
            StringBuilder ret = new StringBuilder(result.length * 2);
            final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
            for (int i = 0; i < result.length; i++) {
                ret.append(HEX_DIGITS[(result[i] >> 4) & 0x0f]);
                ret.append(HEX_DIGITS[result[i] & 0x0f]);
            }
            // 标准的md5加密后的结果
            return ret.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.print(encode("123456"));
    }

}
