package com.shsc.plug.mail;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * @author fangxs
 * @className Mail
 * @date 2019/6/22 18:50
 * @description
 **/
public interface MailEnvelopeMessage {

    /**
     *创建信封包含发件人
     * @param session  会话
     * @param sendMail  发件人邮箱
     * @return MimeMessage
     * @description 创建信封包含发件人
     */
    MimeMessage createMailEnvelope(Session session, String sendMail);
    /**
     * 创建信封包含发件人和编码格式
     * @param session  会话
     * @param sendMail  发件人邮箱
     * @param sendMailPersonal 发件人昵称
     * @param  c 编码格式
     * @return MimeMessage
     * @description 创建信封包含发件人和编码格式
     */
    MimeMessage createMailEnvelope(Session session, String sendMail, String sendMailPersonal,String c);
    /**
     * 创建信封包含发件人和收件人
     * @param session  会话
     * @param sendMail  发件人邮箱
     * @param  receiveMail 收件人信息
     * @return MimeMessage
     * @description 创建信封包含发件人和收件人
     */
    MimeMessage createMailEnvelope(Session session, String sendMail,String receiveMail);

    /**
     *   创建信封包含发件人和收件人
     * @param session  会话
     * @param sendMail  发件人邮箱
     * @param sendMailPersonal  发件人昵称
     * @param  receiveMail 收件人邮箱
     * @param receiveMailPersonal 收件人昵称
     * @param  c 编码格式
     * @return MimeMessage
     * @description 创建信封包含发件人和收件人
     */
    MimeMessage createMailEnvelope(Session session, String sendMail,String sendMailPersonal,String receiveMail, String receiveMailPersonal,String c) ;

    /**
     * 添加收件人
     * @param recipientType 发送类型(普通发送，抄送，密送)
     * @param receiveMail 收件人邮件
     * @exception MessagingException
     */
    void addRecipient(String recipientType,String receiveMail) throws MessagingException;

    /**
     * 添加收件人
     * @param recipientType 发送类型(普通发送，抄送，密送)
     * @param receiveMail 收件人邮件
     * @param receiveMailPersonal 收件人昵称
     * @param c 编码格式
     * @exception MessagingException
     */
    void addRecipient(String  recipientType, String receiveMail, String receiveMailPersonal, String c) throws MessagingException;

    /**
     * 批量添加收件人
     * 默认昵称取邮箱名(譬如，zhangsan@163.com,昵称取zhangsan),字符默认utf8
     * @param recipientType 发送类型(普通发送，抄送，密送)
     * @param receiveMailList 收件人邮件
     * @exception MessagingException
     */
    void patchAddRecipient(String recipientType, List<String> receiveMailList) throws MessagingException;

    /**
     * 添加主题
     * @param subject 主题
     */
    void setSubject(String subject) throws MessagingException, UnsupportedEncodingException;

    /**
     * 添加主题
     * @param subject 主题
     * @param charset 字符
     */
    void setSubject(String subject, String charset) throws MessagingException, UnsupportedEncodingException;

    /**
     * 设置邮件内容
     * @param mimeMultipart 附件内容
     */
    void setContent(MimeMultipart mimeMultipart);

    /**
     * 设置发送时间
     * @param date 时间
     */
    void setSendDate(Date date) throws MessagingException;

    /**
     * 保存最后的文件
     */
    void saveChanges() throws MessagingException;


}
