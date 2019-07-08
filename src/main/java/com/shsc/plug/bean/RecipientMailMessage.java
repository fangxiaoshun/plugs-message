package com.shsc.plug.bean;

/**
 * @author fangxs
 * @className RecipientMailMessage
 * @date 2019/6/24 16:57
 * @description
 **/
public class RecipientMailMessage extends MailBaseMessage {
    /**
     * 收件人接收类型（TO,CC,BCC）
     */
    private String recipientType;

    public String getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(String recipientType) {
        this.recipientType = recipientType;
    }
}
