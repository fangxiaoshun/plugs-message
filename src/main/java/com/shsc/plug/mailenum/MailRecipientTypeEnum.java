package com.shsc.plug.mailenum;


import javax.mail.Message;
import javax.mail.internet.MimeMessage;

/**
 * @author fangxs
 * @className MailEnum
 * @date 2019/6/23 17:27
 * @description
 **/
public enum  MailRecipientTypeEnum {


    /**
     * 直接发送
     */
    TO("TO",MimeMessage.RecipientType.TO),
    /**
     * 抄送
     */
    CC("CC",MimeMessage.RecipientType.CC),
    /**
     * 密送
     */
    BCC("BCC",MimeMessage.RecipientType.BCC),
    ;

    private String recipientCode;
    private Message.RecipientType recipientType;

    private MailRecipientTypeEnum(String recipientCode, Message.RecipientType recipientType) {
        this.recipientCode = recipientCode;
        this.recipientType = recipientType;
    }

    public String getRecipientCode() {
        return recipientCode;
    }

    public void setRecipientCode(String recipientCode) {
        this.recipientCode = recipientCode;
    }

    public Message.RecipientType getRecipientType() {
        return recipientType;
    }

    public void setRecipientType(Message.RecipientType recipientType) {
        this.recipientType = recipientType;
    }

    public static Message.RecipientType getRecipientType(String recipientCode) {
        for ( MailRecipientTypeEnum item :MailRecipientTypeEnum.values()) {
            if(item.getRecipientCode().equals(recipientCode)){
                return item.getRecipientType();
            }
        }
        return null;
    }
}
