package com.shsc.plug.exception;/**
 * @auther fangxs
 * @date 2019/6/19 14:51
 * @description:
 */

/**
 * @className Error
 * @author fangxs
 * @date 2019/6/19 14:51
 * @description
 **/
public class Error  implements  IErrorDefine {

    private String code;

    private String message;

    public Error() {
    }

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
