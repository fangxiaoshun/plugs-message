package com.shsc.plug.mail;

import com.shsc.plug.bean.MailContent;
import com.shsc.plug.bean.RecipientMailMessage;
import com.shsc.plug.bean.SendMailMessage;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author fangxs
 * @className MailSend
 * @date 2019/6/24 16:16
 * @description
 **/
public interface MailSendClient{


    /**
     * 发送邮件,一个收件人
     * @param sendMailMessage 发件人信息
     * @param recipientMailMessage 单个收件人信息
     * @param message 邮件信息
     * @return Boolean 是否发送成功
     */
    Boolean sendMail(SendMailMessage sendMailMessage, RecipientMailMessage recipientMailMessage,MailContent mailContent) throws MessagingException;

    /**
     * 发送邮件,多个个收件人
     * @param sendMailMessage 发件人信息
     * @param recipientMailMessageList 多个收件人
     * @param message 邮件信息
     * @return  Boolean 是否发送成功
     */
    Boolean sendMail(SendMailMessage sendMailMessage, List<RecipientMailMessage> recipientMailMessageList, MailContent mailContent) throws MessagingException;

    /**
     *  发送单个收件人，多个抄送人
     * @param sendMailMessage 发件人信息
     * @param recipientMailMessage 单个收件人信息
     * @param recipientMailMessageList 抄送（包含密送）信息
     * @param mailContent 邮件信息
     * @exception  MessagingException
     * @return  Boolean
     */
    Boolean sendMail(SendMailMessage sendMailMessage, RecipientMailMessage recipientMailMessage,List<RecipientMailMessage> recipientMailMessageList,MailContent mailContent) throws MessagingException;

    /**
     * 多个收件人，多个抄送人
     * @param sendMailMessage  发件人信息
     * @param recipientMailMessageList 多个收件人
     * @param recipientMailMessageBCList 抄送（包含密送）信息
     * @param mailContent 邮件信息
     * @return boolean
     * @exception  MessagingException 异常
     */
    Boolean sendMail(SendMailMessage sendMailMessage, List<RecipientMailMessage> recipientMailMessageList, List<RecipientMailMessage> recipientMailMessageBCList, MailContent mailContent) throws MessagingException;
}
