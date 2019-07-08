package com.shsc.plug.bean;

/**
 * @author fangxs
 * @className MailBaseMessage
 * @date 2019/6/24 16:44
 * @description
 **/
public class MailBaseMessage {
    /**
     * 发人件的邮箱
     */
    private String email;
    /**
     * 发人件的邮箱昵称
     */
    private String emailPersonal;
    /**
     * 编码格式
     */
    private String charCode;

    MailBaseMessage() {
    }

    public MailBaseMessage(String email, String emailPersonal, String charCode) {
        this.email = email;
        this.emailPersonal = emailPersonal;
        this.charCode = charCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailPersonal() {
        return emailPersonal;
    }

    public void setEmailPersonal(String emailPersonal) {
        this.emailPersonal = emailPersonal;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }
}
