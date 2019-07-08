package com.shsc.plug.ckeck;

import com.shsc.plug.exception.ParamException;
import com.shsc.plug.exception.message.SmsCheckMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @className SmsParamCheck
 * @author fangxs
 * @date 2019/6/19 13:59
 * @description
 **/
@Component
public class SmsParamCheck {

    public static void sendSmsCheck(String phoneNumbers, String signName, String templateCode, String templateParam) throws ParamException{
        if(StringUtils.isBlank(phoneNumbers)){
            throw new ParamException(SmsCheckMessage.PHONE_NUMBERS_NULL);
        }
        if(StringUtils.isBlank(signName)){
            throw new ParamException(SmsCheckMessage.SIGN_NAME_NULL);
        }
        if(StringUtils.isBlank(templateCode)){
            throw new ParamException(SmsCheckMessage.TEMPLATE_CODE_NULL);
        }
        if(StringUtils.isBlank(templateParam)){
            throw new ParamException(SmsCheckMessage.TEMPLATE_PARAM_NULL);
        }

    }
    public static void sendBatchSmsCheck(String phoneNumberJson, String signNameJson, String templateCode, String templateParamJson) throws ParamException{
        if(StringUtils.isBlank(phoneNumberJson)){
            throw new ParamException(SmsCheckMessage.PHONE_NUMBERS_NULL);
        }
        if(StringUtils.isBlank(signNameJson)){
            throw new ParamException(SmsCheckMessage.SIGN_NAME_NULL);
        }
        if(StringUtils.isBlank(templateCode)){
            throw new ParamException(SmsCheckMessage.TEMPLATE_CODE_NULL);
        }
        if(StringUtils.isBlank(templateParamJson)){
            throw new ParamException(SmsCheckMessage.TEMPLATE_PARAM_NULL);
        }
    }

}
