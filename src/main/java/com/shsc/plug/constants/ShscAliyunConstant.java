package com.shsc.plug.constants;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @className ShscAliyunConstant
 * @author fangxs
 * @date 2019/6/18 14:17
 * @description
 **/
@Component(value = "shscAliyunConstant")
@ConfigurationProperties(prefix = "aliyunsms")
public class ShscAliyunConstant {

    /**
     * 阿里云访问id
     */
    private String accessKeyId;
    /**
     * 阿里云访问秘钥
     */
    private String accessKeySecret;
    /**
     * 阿里云短信签名
     */
    private String signName;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }
}
