package com.shsc.plug.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import java.io.File;
import java.io.UnsupportedEncodingException;

public interface MailContentMessage {
    /**
     *
     * 创建图片文件
     * @param file 文件
     * @exception MessagingException 异常
     * @return MimeBodyPart 信封内容部分
     */
    MimeBodyPart createAttMimeBodyPart(File file) throws MessagingException, UnsupportedEncodingException;

    /**
     *
     * 创建纯文本内容
     * @param text 纯文本内容
     * @return MimeBodyPart 信封内容部分
     * @exception MessagingException 异常
     */
    MimeBodyPart createTextMimeBodyPart(String text) throws MessagingException;

    /**
     *
     * 创建“节点”
     * @param text 文本内容
     * @param type 文本类型
     * @param c  字符编码
     * @return MimeBodyPart 信封内容部分
     */
    MimeBodyPart createMimeBodyPart(String text, String type,String c) throws MessagingException;
}
