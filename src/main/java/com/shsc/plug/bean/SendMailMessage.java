package com.shsc.plug.bean;

/**
 * @author fangxs
 * @className SendMailMessage
 * @date 2019/6/24 16:57
 * @description
 **/
public class SendMailMessage extends MailBaseMessage {
    /**
     * 发人件的邮箱密码
     * 对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。
     */
    private String password;

    /**
     * 是否开启ssl加密传输
     */
    private boolean isSSL;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSSL() {
        return isSSL;
    }

    public void setSSL(boolean SSL) {
        isSSL = SSL;
    }
}