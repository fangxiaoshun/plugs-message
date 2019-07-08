package com.shsc.plug.bean;

import javax.mail.internet.MimeBodyPart;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @author fangxs
 * @className MailContent
 * @date 2019/6/24 21:22
 * @description
 **/
public class MailContent {
    /**
     * 邮件内容
     */
    private String context;
    /**
     * 邮件类型，（HTML,TEXT）
     */
    private String contentType;
    /**
     * 邮件主题
     */
    private String subject;
    /**
     * 编码格式
     */
    private String charCode;
    /**
     * 邮件发送日期
     */
    private Date sentDate;

    /**
     * 附件
     */
    private List<File> fileList;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }


    public List<File> getFileList() {
        return fileList;
    }

    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }
}
