package com.zhy.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhangocean
 * @Date: 2018/6/9 19:45
 * Describe: 阿里云连接密钥
 */
@Configuration
@ConfigurationProperties(prefix = "lp.oss")
public class OSSClientConstants {

    /**
     * 阿里云API的外网域名
     */
    public static final String ENDPOINT_INTERNAL = "oss-cn-beijing-internal.aliyuncs.com";
    public static final String ENDPOINT = "oss-cn-beijing.aliyuncs.com";
    /**
     * 阿里云API的密钥Access Key ID
     */
    public static String ACCESS_KEY_ID;
    /**
     * 阿里云API的密钥Access Key Secret
     */
    public static String ACCESS_KEY_SECRET;

    /**
     * 阿里云API的bucket名称
     */
    public static String BACKET_NAME;
    /**
     * 阿里云API的文件夹名称
     */
    public static final String FOLDER = "public/";


    public void setAccessKeyId(String accessKeyId) {
        OSSClientConstants.ACCESS_KEY_ID = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        OSSClientConstants.ACCESS_KEY_SECRET = accessKeySecret;
    }

    public void setBacketName(String backetName) {
        OSSClientConstants.BACKET_NAME = backetName;
    }


}
