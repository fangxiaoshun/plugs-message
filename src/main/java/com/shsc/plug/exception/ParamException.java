package com.shsc.plug.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @className ParamException
 * @author fangxs
 * @date 2019/6/19 14:39
 * @description
 **/
public class ParamException extends Exception {
    private static final long serialVersionUID = -1650108283349728178L;

    private String code;
    private List<Error> errors;
    public ParamException(String code, String message) {
        super(message);
        this.setCode(code);
    }

    public ParamException(String code, String message, String extra) {
        super(message + "," + "[" + extra + "]");
        this.setCode(code);
    }

    public ParamException(IErrorDefine error) {
        this(error.getCode(), error.getMessage());
    }

    public ParamException(IErrorDefine error, String extra) {
        this(error.getCode(), error.getMessage(), extra);
    }

    public ParamException addErros(IErrorDefine error) {
        if (this.errors == null) {
            this.errors = new ArrayList<Error>();
        }

        Error item = new Error();
        item.setCode(error.getCode());
        item.setMessage(error.getMessage());
        this.errors.add(item);
        return this;
    }

    public ParamException addErros(IErrorDefine error, String extra) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }

        Error item = new Error();
        item.setCode(error.getCode());
        item.setMessage(error.getMessage() + "," + "[" + extra + "]");
        this.errors.add(item);
        return this;
    }

    public List<Error> getErros() {
        return this.errors;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
