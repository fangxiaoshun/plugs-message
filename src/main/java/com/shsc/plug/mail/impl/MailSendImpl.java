package com.shsc.plug.mail.impl;

import com.shsc.plug.bean.MailContent;
import com.shsc.plug.bean.RecipientMailMessage;
import com.shsc.plug.bean.SendMailMessage;
import com.shsc.plug.mail.MailSendClient;
import com.shsc.plug.mailenum.MailContentType;
import com.shsc.plug.mailenum.SMTPEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author fangxs
 * @className MailSendInfo
 * @date 2019/6/24 20:18
 * @description
 **/
@Component
public class MailSendImpl implements MailSendClient {
    @Autowired
    MailEnvelopeMessageImpl mailEnvelopeMessageImpl;
    @Autowired
    MailContentMessageImpl mailContentMessageImpl;
    @Override
    public Boolean sendMail(SendMailMessage sendMailMessage, RecipientMailMessage recipientMailMessage,  MailContent mailContent) throws MessagingException {
        List<RecipientMailMessage> recipientMailMessageList = new ArrayList<>();
        recipientMailMessageList.add(recipientMailMessage);
        return sendMail(sendMailMessage, recipientMailMessageList, mailContent);
    }
    @Override
    public Boolean sendMail(SendMailMessage sendMailMessage, List<RecipientMailMessage> recipientMailMessageList,  MailContent mailContent) throws MessagingException {
        return sendMail(sendMailMessage,recipientMailMessageList,null,mailContent);
    }

    @Override
    public Boolean sendMail(SendMailMessage sendMailMessage, RecipientMailMessage recipientMailMessage, List<RecipientMailMessage> recipientMailMessageBCList, MailContent mailContent) throws MessagingException {
        List<RecipientMailMessage> recipientMailMessageList = new ArrayList<RecipientMailMessage>();
        recipientMailMessageList.add(recipientMailMessage);
        return sendMail(sendMailMessage,recipientMailMessageList,recipientMailMessageBCList,mailContent);
    }



    @Override
    public Boolean sendMail(SendMailMessage sendMailMessage, List<RecipientMailMessage> recipientMailMessageList, List<RecipientMailMessage> recipientMailMessageBCList, MailContent mailContent) throws MessagingException {
        try {
            String emailName = sendMailMessage.getEmail();
            String password = sendMailMessage.getPassword();
            String charCode = sendMailMessage.getCharCode();
            String emailSendPersonal = sendMailMessage.getEmailPersonal();
            boolean ssl = sendMailMessage.isSSL();
            //1、获取邮箱的stmp地址
            int indexOf = emailName.substring(emailName.indexOf("@") + 1).indexOf(".");
            String smtpCode = emailName.substring(emailName.indexOf("@") + 1).substring(0, indexOf);
            SMTPEnum smtpEnum = SMTPEnum.getSMTPEnum(smtpCode);
            // 参数配置
            Properties props = new Properties();
            props.setProperty("mail.transport.protocol", "smtp");
            props.setProperty("mail.smtp.host", smtpEnum.getSmtpHost());
            props.setProperty("mail.smtp.auth", "true");
            // 判断是否开启加密传输
            if(ssl){
                Integer sslPort = smtpEnum.getSslPort();
                if(sslPort != null) {
                    props.setProperty("mail.smtp.ssl.enable", String.valueOf(true));
                    props.setProperty("mail.smtp.port", String.valueOf(sslPort));
                    props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    props.setProperty("mail.smtp.socketFactory.fallback", "false");
                    props.setProperty("mail.smtp.socketFactory.port", String.valueOf(sslPort));

                }
            }
            // 创建会话对象
            Session session = Session.getInstance(props);
            mailEnvelopeMessageImpl.createMailEnvelope(session, emailName, emailSendPersonal, charCode );
            // 添加直接发送人
            if(recipientMailMessageList != null && recipientMailMessageList.size() >0 ){
                for (RecipientMailMessage recipientMailMessage: recipientMailMessageList) {
                    String email = recipientMailMessage.getEmail();
                    String emailPersonal = recipientMailMessage.getEmailPersonal();
                    String charCode1 = recipientMailMessage.getCharCode();
                    String recipientType = recipientMailMessage.getRecipientType();
                    mailEnvelopeMessageImpl.addRecipient(recipientType,email,emailPersonal,charCode1);
                }
            }
            // 添加抄送（包括密送）人
            if(recipientMailMessageBCList != null && recipientMailMessageBCList.size() >0 ){
                for (RecipientMailMessage recipientMailMessage: recipientMailMessageBCList) {
                    String email = recipientMailMessage.getEmail();
                    String emailPersonal = recipientMailMessage.getEmailPersonal();
                    String charCode1 = recipientMailMessage.getCharCode();
                    String recipientType = recipientMailMessage.getRecipientType();
                    mailEnvelopeMessageImpl.addRecipient(recipientType,email,emailPersonal,charCode1);
                }
            }
            // 添加主题
            mailEnvelopeMessageImpl.setSubject(mailContent.getSubject(),mailContent.getCharCode());
            // 添加内容
            String context = mailContent.getContext();
            String contentType = mailContent.getContentType();
            String charCode1 = mailContent.getCharCode();

            MimeBodyPart textBodyPart = mailContentMessageImpl.createMimeBodyPart(context, contentType, charCode1);
            //添加附件
            // 组合数据为一个节点
            MimeMultipart mm = new MimeMultipart();
            // 正文需要放到第一位
            mm.addBodyPart(textBodyPart);
            // 其次才是添加附件
            List<File> fileList = mailContent.getFileList();
            if(fileList != null && fileList.size() > 0){
                for (File file:fileList) {
                    MimeBodyPart attMimeBodyPart = mailContentMessageImpl.createAttMimeBodyPart(file);
                    mm.addBodyPart(attMimeBodyPart);
                }
                // 混合类型
                mm.setSubType("mixed");
            }
            MimeMessage mimeMessage = mailEnvelopeMessageImpl.getMimeMessage();
            if(fileList != null && fileList.size() > 0){
                mimeMessage.setContent(mm);
            }else{
                // 单个内容发送
                if(StringUtils.isBlank(charCode1)){  charCode1 ="UTF-8";  }
                if(StringUtils.isBlank(contentType)){  contentType =MailContentType.TEXT.getContentCode(); }
                mimeMessage.setContent(context, MailContentType.getContentType(contentType)+";charset="+charCode1);
            }
            //设置发件时间
            Date sentDate = mailContent.getSentDate();
            mailEnvelopeMessageImpl.setSendDate(sentDate !=null ? sentDate : new Date());
            //封闭信封
            mailEnvelopeMessageImpl.saveChanges();
            //开始发送
            Transport transport = session.getTransport();
            transport.connect(emailName, password);
            transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            // 7. 关闭连接
            transport.close();
            return true;
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
