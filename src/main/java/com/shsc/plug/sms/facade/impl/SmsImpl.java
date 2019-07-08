package com.shsc.plug.sms.facade.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonResponse;
import com.shsc.plug.ckeck.SmsParamCheck;
import com.shsc.plug.client.SmsClient;
import com.shsc.plug.exception.ParamException;
import com.shsc.plug.sms.facade.Sms;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @className SMS
 * @author fangxs
 * @date 2019/6/19 13:52
 * @description
 **/
@Component(value = "smsImpl")
public class SmsImpl implements Sms {

    private final Logger logger = LoggerFactory.getLogger(SmsImpl.class);

    private final SmsClient smsClient;


    public SmsImpl( @Autowired SmsClient smsClient) {
        this.smsClient = smsClient;
    }

    @Override
    public CommonResponse sendSms(String phoneNumbers, String signName, String templateCode, String templateParam) {
        logger.info("调用短信接口,电话为{}，短信签名为{}，模板code为{}，模板参数为{}",phoneNumbers,templateCode,templateParam);
        CommonResponse commonResponse = new CommonResponse();
        JSONObject jsonObject = new JSONObject();
        try {
            SmsParamCheck.sendSmsCheck(phoneNumbers,signName,templateCode, templateParam);
        } catch (ParamException e) {
            logger.error(e.getMessage());
            commonResponse.setHttpStatus(200);
            jsonObject.put("Message",e.getMessage());
            jsonObject.put("Code",500);
            commonResponse.setData(JSON.toJSONString(jsonObject));
            return commonResponse;
        }
        commonResponse = smsClient.sendSms(phoneNumbers, signName, templateCode, templateParam);
        if( commonResponse == null ){
            commonResponse = new CommonResponse();
            jsonObject.put("Message","调用阿里云短信失败");
            jsonObject.put("Code",500);
            // 设置响应值
            commonResponse.setHttpStatus(200);
            commonResponse.setData(JSON.toJSONString(jsonObject));
        }
        return commonResponse;
    }

    @Override
    public CommonResponse sendBatchSms(String phoneNumberJson, String signNameJson, String templateCode, String templateParamJson) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            SmsParamCheck.sendBatchSmsCheck(phoneNumberJson,signNameJson,templateCode, templateParamJson);
        } catch (ParamException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
            commonResponse.setHttpStatus(500);
            commonResponse.setData(e.getMessage());
            return commonResponse;
        }
        commonResponse = smsClient.sendBatchSms(phoneNumberJson, signNameJson, templateCode, templateParamJson);
        if( commonResponse == null ){
            commonResponse = new CommonResponse();
            commonResponse.setHttpStatus(500);
            commonResponse.setData("调用阿里云短信失败");
        }

        return commonResponse;
    }
}
