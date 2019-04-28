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

    private static String accessKeyId;
    private static String accessKeySecret;
    private static String backetName;


    public void setAccessKeyId(String accessKeyId) {
        OSSClientConstants.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        OSSClientConstants.accessKeySecret = accessKeySecret;
    }

    public void setBacketName(String backetName) {
        OSSClientConstants.backetName = backetName;
    }

    /**
     * 阿里云API的外网域名
     */
    public static final String ENDPOINT = "oss-cn-beijing.aliyuncs.com";

    /**
     * 阿里云API的密钥Access Key ID
     */
    public static final String ACCESS_KEY_ID = accessKeyId;
    /**
     * 阿里云API的密钥Access Key Secret
     */
    public static final String ACCESS_KEY_SECRET = accessKeySecret;

    /**
     * 阿里云API的bucket名称
     */
    public static final String BACKET_NAME = backetName;

    /**
     * 阿里云API的文件夹名称
     */
    public static final String FOLDER = "public/";

}
