package com.shsc.plug.mailenum;

/**
 * @author fangxs
 * @className MailContentType
 * @date 2019/6/24 21:30
 * @description
 **/
public enum MailContentType {
    /**
     * html格式的
     */
    HTML("HTML","text/html"),
    /**
     * text格式的
     */
    TEXT("TEXT","text/plain")
    ;

    private String contentCode;
    private String contentType;

    MailContentType(String contentCode, String contentType) {
        this.contentCode = contentCode;
        this.contentType = contentType;
    }

    public String getContentCode() {
        return contentCode;
    }

    public void setContentCode(String contentCode) {
        this.contentCode = contentCode;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public static String getContentType(String contentCode){
        for(MailContentType mailContentType :MailContentType.values()){
            if(mailContentType.getContentCode().equalsIgnoreCase(contentCode)){

                return mailContentType.getContentType();
            }
        }
        return null;
    }
}
