package com.shsc.plug.bean;

/**
 * @author fangxs
 * @className MessageResponse
 * @date 2019/6/25 21:08
 * @description
 **/
public class MessageResponse {

    private boolean status;
    private String message;


    public MessageResponse() {
    }

    public MessageResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
