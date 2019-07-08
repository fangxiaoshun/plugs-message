package com.shsc.plug.mailenum;

/**
 * @author fangxs
 */

public enum SMTPEnum {

    /**
     * 阿里云邮箱
     */
    ALIYUN("aliyun","smtp.aliyun.com",465,25),
    /**
     * 谷歌邮箱
     */
    GOOGLE("gmail","smtp.gmail.com",587,null),
    /**
     * 新浪邮箱
     */
    SINA("sina","smtp.sina.com.cn",null,25),
    /**
     * Tom邮箱
     */
    TOM("tom","smtp.tom.com",null,25),
    /**
     * 网易163邮箱
     */
    W163("163","smtp.163.com",465,25),
    /**
     * 海底捞邮箱
     */
    HDL("haidilao","mail.haidilao.com",465,25),
    /**
     * 蜀海邮箱
     */
    SHSC("shuhaisc","mail.shuhaisc.com",465,25),
    /**
     * qq邮箱
     */
    QQ("qq","smtp.qq.com",465,25),

    ;

    /**
     * smtpCode
     */
    private String smtpCode;
    /**
     * smtp协议主机域名
     */
    private String smtpHost;
    /**
     * ssl加密协议端口
     */
    private Integer sslPort;
    /**
     * 非加密端口
     */
    private Integer port;

    SMTPEnum(String smtpCode,String smtpHost, Integer sslPort, Integer port) {
        this.smtpCode = smtpCode;
        this.smtpHost = smtpHost;
        this.sslPort = sslPort;
        this.port = port;
    }

    public String getSmtpCode() {
        return smtpCode;
    }

    public void setSmtpCode(String smtpCode) {
        this.smtpCode = smtpCode;
    }

    public String getSmtpHost() {
        return smtpHost;
    }

    public void setSmtpHost(String smtpHost) {
        this.smtpHost = smtpHost;
    }

    public Integer getSslPort() {
        return sslPort;
    }

    public void setSslPort(Integer sslPort) {
        this.sslPort = sslPort;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public static SMTPEnum getSMTPEnum(String smtpCode){
        for (SMTPEnum item: SMTPEnum.values()) {
            if (item.getSmtpCode().equalsIgnoreCase(smtpCode)) {
                return item;
            }
        }
        return null;
    }
}
