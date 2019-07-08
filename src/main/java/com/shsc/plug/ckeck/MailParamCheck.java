package com.shsc.plug.ckeck;

import com.shsc.plug.bean.MailContent;
import com.shsc.plug.bean.RecipientMailMessage;
import com.shsc.plug.bean.SendMailMessage;
import com.shsc.plug.exception.ParamException;
import com.shsc.plug.exception.message.MailCheckMessage;
import org.apache.commons.lang3.StringUtils;

import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * @author fangxs
 * @className MailParamCheck
 * @date 2019/6/24 15:41
 * @description
 **/
public class MailParamCheck {
    public static void sendMailCheck(SendMailMessage sendMailMessage, RecipientMailMessage recipientMailMessage, MailContent mailContent) throws ParamException {
        if(sendMailMessage == null){
            throw new ParamException(MailCheckMessage.SEND_ACCOUNT_NULL);
        }else{
            String email = sendMailMessage.getEmail();
            String password = sendMailMessage.getPassword();

            if(StringUtils.isBlank(email)){
                throw new ParamException(MailCheckMessage.SEND_ACCOUNT_NULL);
            }
            if(StringUtils.isBlank(password)){
                throw new ParamException(MailCheckMessage.SEND_PASSWORD_NULL);
            }
        }

        if(recipientMailMessage == null ){
            throw new ParamException(MailCheckMessage.RECIPIENT_ACCOUNT_NULL);
        }
        if(mailContent ==null){
            throw new ParamException(MailCheckMessage.MAIL_CONTENT_NULL);
        }
    }

    public static void sendMailCheck(SendMailMessage sendMailMessage, List<RecipientMailMessage> recipientMailMessageList, MailContent mailContent) throws ParamException {
        if(sendMailMessage == null){
            throw new ParamException(MailCheckMessage.SEND_ACCOUNT_NULL);
        }else{
            String email = sendMailMessage.getEmail();
            String password = sendMailMessage.getPassword();

            if(StringUtils.isBlank(email)){
                throw new ParamException(MailCheckMessage.SEND_ACCOUNT_NULL);
            }
            if(StringUtils.isBlank(password)){
                throw new ParamException(MailCheckMessage.SEND_PASSWORD_NULL);
            }
        }
        if(recipientMailMessageList == null ||  recipientMailMessageList.size() == 0){
            throw new ParamException(MailCheckMessage.RECIPIENT_ACCOUNT_NULL);
        }
        if(mailContent ==null){
            throw new ParamException(MailCheckMessage.MAIL_CONTENT_NULL);
        }

    }

    public static void sendMailCheck(SendMailMessage sendMailMessage, RecipientMailMessage recipientMailMessage,List<RecipientMailMessage> recipientMailMessageList,MailContent mailContent) throws ParamException {
        if(sendMailMessage == null){
            throw new ParamException(MailCheckMessage.SEND_ACCOUNT_NULL);
        }else{
            String email = sendMailMessage.getEmail();
            String password = sendMailMessage.getPassword();

            if(StringUtils.isBlank(email)){
                throw new ParamException(MailCheckMessage.SEND_ACCOUNT_NULL);
            }
            if(StringUtils.isBlank(password)){
                throw new ParamException(MailCheckMessage.SEND_PASSWORD_NULL);
            }
        }
        if(recipientMailMessage == null ){
            throw new ParamException(MailCheckMessage.RECIPIENT_ACCOUNT_NULL);
        }
        if(mailContent ==null){
            throw new ParamException(MailCheckMessage.MAIL_CONTENT_NULL);
        }
    }
    public static void sendMailCheck(SendMailMessage sendMailMessage, List<RecipientMailMessage> recipientMailMessageList, List<RecipientMailMessage> recipientMailMessageBCList, MailContent mailContent) throws ParamException {
        if(sendMailMessage == null){
            throw new ParamException(MailCheckMessage.SEND_ACCOUNT_NULL);
        }else{
            String email = sendMailMessage.getEmail();
            String password = sendMailMessage.getPassword();

            if(StringUtils.isBlank(email)){
                throw new ParamException(MailCheckMessage.SEND_ACCOUNT_NULL);
            }
            if(StringUtils.isBlank(password)){
                throw new ParamException(MailCheckMessage.SEND_PASSWORD_NULL);
            }
        }

        if(recipientMailMessageList == null ||  recipientMailMessageList.size() == 0){
            throw new ParamException(MailCheckMessage.RECIPIENT_ACCOUNT_NULL);
        }
        if(mailContent ==null){
            throw new ParamException(MailCheckMessage.MAIL_CONTENT_NULL);
        }
    }
}
