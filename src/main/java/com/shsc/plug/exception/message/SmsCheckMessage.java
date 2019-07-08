package com.shsc.plug.exception.message;

import com.shsc.plug.exception.IErrorDefine;

/**
 * @className SmsCheckMessage
 * @author fangxs
 * @date 2019/6/19 14:32
 * @description
 **/
public enum SmsCheckMessage implements IErrorDefine {
    /**
     * 检查电话号码是否为空
     */
    PHONE_NUMBERS_NULL("PHONE_NUMBERS_NULL","电话号码不能为空"),
    /**
     * 检查短信签名是否为空
     */
    SIGN_NAME_NULL("SIGN_NAME_NULL","短信签名不能为空"),
    /**
     * 检查模板code是否为空
     */
    TEMPLATE_CODE_NULL("TEMPLATE_CODE_NULL","模板code不能为空"),
    /**
     * 检查模板参数是否为空
     */
    TEMPLATE_PARAM_NULL("TEMPLATE_PARAM_NULL","模板参数不能为空"),

    ;

    private String code;
    private String message;

    SmsCheckMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
