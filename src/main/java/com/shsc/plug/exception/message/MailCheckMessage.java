package com.shsc.plug.exception.message;

import com.shsc.plug.exception.IErrorDefine;

/**
 * @author fangxs
 * @className MailCheckMessage
 * @date 2019/6/24 15:41
 * @description
 **/
public enum MailCheckMessage implements IErrorDefine {

    /**
     * 发件人账号不能为空
     */
    SEND_ACCOUNT_NULL("SEND_ACCOUNT_NULL","发件人账号为空"),
    /**
     * 发件人密码不能为空
     */
    SEND_PASSWORD_NULL("SEND_PASSWORD_NULL","发件人密码为空"),

    /**
     * 收件人账号不能为空
     */
    RECIPIENT_ACCOUNT_NULL("RECIPIENT_ACCOUNT_NULL","收件人账号为空"),
    /**
     * 邮件内容不能为空
     */
    MAIL_CONTENT_NULL("MAIL_CONTENT_NULL","邮件内容为空"),

    ;


    private String code;
    private String message;

    MailCheckMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
