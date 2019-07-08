package com.shsc.plug.mail.impl;

import com.shsc.plug.mailenum.MailRecipientTypeEnum;
import com.shsc.plug.mail.MailEnvelopeMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * @author fangxs
 * @className MailMessageImpl
 * @date 2019/6/22 21:02
 * @description
 **/
@Component
public class MailEnvelopeMessageImpl implements MailEnvelopeMessage {

    private final Logger logger = LoggerFactory.getLogger(MailEnvelopeMessageImpl.class);

    private final String CHAR_SET = "UTF-8";

    private MimeMessage mimeMessage;

    @Override
    public MimeMessage createMailEnvelope(Session session, String sendMail) {

        return createMailEnvelope(session, sendMail, null,CHAR_SET);
    }

    @Override
    public MimeMessage createMailEnvelope(Session session, String sendMail, String sendMailPersonal, String c) {
        // 创建邮件对象
        this.mimeMessage  = new MimeMessage(session);
        try {
            // From: 发件人
            String emailPersonal = sendMail.substring(0,sendMail.indexOf("@"));
            mimeMessage.setFrom(new InternetAddress(sendMail, StringUtils.isNotBlank(sendMailPersonal) ? sendMailPersonal : emailPersonal, StringUtils.isNotBlank(c) ? c : CHAR_SET));
            // mimeMessage.saveChanges();
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return mimeMessage;

    }

    @Override
    public MimeMessage createMailEnvelope(Session session, String sendMail, String receiveMail) {
        return createMailEnvelope(session,sendMail,null,receiveMail,null,CHAR_SET);
    }

    @Override
    public MimeMessage createMailEnvelope(Session session, String sendMail, String sendMailPersonal, String receiveMail, String receiveMailPersonal, String c) {

        // 创建邮件对象
        this.mimeMessage = new MimeMessage(session);

        try {
            // From: 发件人
            String emailPersonal1 = sendMail.substring(0,sendMail.indexOf("@"));
            mimeMessage.setFrom(new InternetAddress(sendMail, StringUtils.isNotBlank(sendMailPersonal) ? sendMailPersonal : emailPersonal1,  StringUtils.isNotBlank(c) ? c:CHAR_SET));
            // To: 收件人（可以增加多个收件人、抄送、密送）
            String emailPersonal2 = sendMail.substring(0,receiveMail.indexOf("@"));
            mimeMessage.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail,  StringUtils.isNotBlank(receiveMailPersonal) ? receiveMailPersonal : emailPersonal2,  StringUtils.isNotBlank(c) ? c:CHAR_SET));
            mimeMessage.saveChanges();
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return mimeMessage;

    }

    @Override
    public void addRecipient(String recipientType, String receiveMail) throws MessagingException {
        if(mimeMessage == null) {
            throw new MessagingException("mimeMessage 对象为空");
        }

        addRecipient(recipientType,receiveMail,null,null);


    }

    @Override
    public void addRecipient(String recipientType, String receiveMail, String receiveMailPersonal, String c) throws MessagingException {
        if(mimeMessage == null) {
            throw new MessagingException("mimeMessage 对象为空");
        }

        try {
            String emailPersonal = receiveMail.substring(0,receiveMail.indexOf("@"));
            this.mimeMessage.addRecipient(MailRecipientTypeEnum.getRecipientType(recipientType),
                    new InternetAddress(receiveMail, StringUtils.isNotBlank(receiveMailPersonal)?receiveMailPersonal:emailPersonal,StringUtils.isNotBlank(c)?c:"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void patchAddRecipient(String recipientType, List<String> receiveMailList) throws MessagingException {
        for (String receiveMail:receiveMailList) {
            addRecipient(recipientType,receiveMail);
        }
    }

    @Override
    public void setSubject(String subject) throws MessagingException, UnsupportedEncodingException {
        this.setSubject(subject,"UTF-8");
    }

    @Override
    public void setSubject(String subject, String charset) throws MessagingException, UnsupportedEncodingException {
        if(StringUtils.isBlank(charset)){
            charset = "UTF-8";
        }
        if(StringUtils.isBlank(subject)){
            subject="(无主题)";
        }
        this.mimeMessage.setSubject(subject,charset);
    }

    @Override
    public void setContent(MimeMultipart mimeMultipart) {

    }

    @Override
    public void setSendDate(Date date) throws MessagingException {
        this.mimeMessage.setSentDate(date);
    }

    @Override
    public void saveChanges() throws MessagingException {
        this.mimeMessage.saveChanges();
    }

    public MimeMessage getMimeMessage() {
        return mimeMessage;
    }

    public void setMimeMessage(MimeMessage mimeMessage) {
        this.mimeMessage = mimeMessage;
    }
}
