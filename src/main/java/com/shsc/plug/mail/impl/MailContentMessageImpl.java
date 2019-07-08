package com.shsc.plug.mail.impl;


import com.shsc.plug.mail.MailContentMessage;
import com.shsc.plug.mailenum.MailContentType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author fangxs
 * @className MailContentMessageImpl
 * @date 2019/6/24 11:21
 * @description
 **/
@Component
public class MailContentMessageImpl  implements MailContentMessage {
    @Override
    public MimeBodyPart createAttMimeBodyPart(File file) throws MessagingException, UnsupportedEncodingException {
        MimeBodyPart attMimeBodyPart = new MimeBodyPart();
        DataHandler dh = new DataHandler(new FileDataSource(file));
        MimeUtility.encodeText(dh.getName());
        attMimeBodyPart.setFileName(MimeUtility.encodeText(dh.getName()));
        attMimeBodyPart.setDataHandler(dh);
        return attMimeBodyPart;
    }

    public MimeBodyPart createImageMimeBodyPart(File file) throws MessagingException, UnsupportedEncodingException {
        MimeBodyPart attMimeBodyPart = this.createAttMimeBodyPart(file);
        attMimeBodyPart.setContentID(new String(file.getName().getBytes(StandardCharsets.UTF_8)));
        return attMimeBodyPart;
    }

    @Override
    public MimeBodyPart createTextMimeBodyPart(String text) throws MessagingException {
        MimeBodyPart textMimeBodyPart = new MimeBodyPart();
        textMimeBodyPart.setContent(text,"text/html;charset=UTF-8");
        return textMimeBodyPart;
    }

    @Override
    public MimeBodyPart createMimeBodyPart(String text, String type,String c) throws MessagingException {
        MimeBodyPart textMimeBodyPart = new MimeBodyPart();
        if(StringUtils.isBlank(c)){
            c ="UTF-8";
        }
        if(StringUtils.isBlank(type)){
            type =MailContentType.TEXT.getContentCode();
        }
        textMimeBodyPart.setContent(text, MailContentType.getContentType(type)+";charset="+c);
        return textMimeBodyPart;
    }
}
