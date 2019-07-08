package com.shsc.plug.util;

import com.shsc.plug.bean.MailContent;
import com.shsc.plug.bean.RecipientMailMessage;
import com.shsc.plug.bean.SendMailMessage;
import com.shsc.plug.ckeck.MailParamCheck;
import com.shsc.plug.exception.ParamException;
import com.shsc.plug.mail.impl.MailSendImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.MessagingException;
import java.util.List;

/**
 * @author fangxs
 * @className MailUtil
 * @date 2019/6/22 20:18
 * @description
 **/

public class MailUtil {

    private static final Logger logger = LoggerFactory.getLogger(MailUtil.class);

    private static MailSendImpl mailSendImpl = SpringUtil.getBean("mailSendImpl", MailSendImpl.class);

    /**
     * 发送邮件,一个收件人
     * @param sendMailMessage 发件人信息
     * @param recipientMailMessage 单个收件人信息
     * @param mailContent 邮件信息
     * @return Boolean 是否发送成功
     */
    public static Boolean  sendMail(SendMailMessage sendMailMessage, RecipientMailMessage recipientMailMessage,  MailContent mailContent){
        try {
            MailParamCheck.sendMailCheck(sendMailMessage,recipientMailMessage,mailContent);
            mailSendImpl.sendMail(sendMailMessage,recipientMailMessage,mailContent);
        } catch (ParamException | MessagingException e) {
            e.printStackTrace();
            logger.error("发送邮件失败，result{}",e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 发送邮件,多个个收件人
     * @param sendMailMessage 发件人信息
     * @param recipientMailMessageList 多个收件人
     * @param mailContent 邮件信息
     * @return  Boolean 是否发送成功
     */
    public static Boolean sendMail(SendMailMessage sendMailMessage, List<RecipientMailMessage> recipientMailMessageList, MailContent mailContent){
        try {
            MailParamCheck.sendMailCheck(sendMailMessage,recipientMailMessageList,mailContent);

            mailSendImpl.sendMail(sendMailMessage,recipientMailMessageList,mailContent);

        } catch (ParamException | MessagingException e) {
            e.printStackTrace();
            logger.error("发送邮件失败，result{}",e.getMessage());
            return false;
        }
        return true;
    }
    /**
     *  发送单个收件人，多个抄送人
     * @param sendMailMessage 发件人信息
     * @param recipientMailMessage 单个收件人信息
     * @param recipientMailMessageList 抄送（包含密送）信息
     * @param mailContent 邮件信息
     * @exception MessagingException
     * @return  Boolean
     */
    public static Boolean sendMail(SendMailMessage sendMailMessage, RecipientMailMessage recipientMailMessage, List<RecipientMailMessage> recipientMailMessageList, MailContent mailContent){
        try {
            MailParamCheck.sendMailCheck(sendMailMessage,recipientMailMessage,recipientMailMessageList,mailContent);

            mailSendImpl.sendMail(sendMailMessage,recipientMailMessage,recipientMailMessageList,mailContent);

        } catch (ParamException | MessagingException e) {
            e.printStackTrace();
            logger.error("发送邮件失败，result{}",e.getMessage());
            return false;
        }
        return true;

    }
    /**
     * 多个收件人，多个抄送人
     * @param sendMailMessage  发件人信息
     * @param recipientMailMessageList 多个收件人
     * @param recipientMailMessageBCList 抄送（包含密送）信息
     * @param mailContent 邮件信息
     * @return boolean
     * @exception  MessagingException 异常
     */
    public static Boolean sendMail(SendMailMessage sendMailMessage, List<RecipientMailMessage> recipientMailMessageList, List<RecipientMailMessage> recipientMailMessageBCList, MailContent mailContent){
        try {
            MailParamCheck.sendMailCheck(sendMailMessage,recipientMailMessageList,recipientMailMessageBCList,mailContent);
            mailSendImpl.sendMail(sendMailMessage,recipientMailMessageList,recipientMailMessageBCList,mailContent);
        } catch (MessagingException | ParamException e) {
            e.printStackTrace();
            logger.error("发送邮件失败，result{}",e.getMessage());
            return false;
        }
        return true;
    }

}
