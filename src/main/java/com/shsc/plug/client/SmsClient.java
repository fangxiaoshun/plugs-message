package com.shsc.plug.client;/**
 * @auther fangxs
 * @date 2019/6/18 14:40
 * @description:
 */

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.shsc.plug.constants.ShscAliyunConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @className SmsClient
 * @author fangxs
 * @date 2019/6/18 14:40
 * @description
 **/

@Component
public class SmsClient {

    private final Logger logger = LoggerFactory.getLogger(SmsClient.class);

    /**
     * 产品域名,开发者无需替换
     */
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";

    /**
     * 地域ID
     */
    private static final String REGION_ID = "ch-hangzhou";

    private final ShscAliyunConstant shscAliyunConstant;

    public SmsClient( @Autowired ShscAliyunConstant shscAliyunConstant) {
        this.shscAliyunConstant = shscAliyunConstant;
    }


    /**
     *
     *
     * @param phoneNumbers  接收短信的手机号码。
     * 国内短信：11位手机号码，例如15951955195。
     * 国际/港澳台消息：国际区号+号码，例如85200000000。
     * 支持对多个手机号码发送短信，手机号码之间以英文逗号（,）分隔。上限为1000个手机号码。批量调用相对于单条调用及时性稍有延迟。
     * 说明 验证码类型短信，建议使用单独发送的方式
     * @param signName  短信签名名称。
     * @param templateCode  短信模板ID
     * @param templateParam  短信模板变量对应的实际值，JSON格式。
     * @return
     */
    public CommonResponse sendSms(String phoneNumbers, String signName,String templateCode, String templateParam){
        // 创建DefaultAcsClient实例并初始化
        DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, shscAliyunConstant.getAccessKeyId(), shscAliyunConstant.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);
        // 创建API请求并设置参数
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(DOMAIN);
        request.setVersion("2017-05-25");
        // 接口名称
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", REGION_ID);
        request.putQueryParameter("PhoneNumbers", phoneNumbers);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", templateParam);
        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        return response;
    }

    /**
     *
     * @param phoneNumberJson  接收短信的手机号码，JSON数组格式。
     * 手机号码格式：
     * 国内短信：11位手机号码，例如15900000000。
     * 国际/港澳台消息：国际区号+号码，例如85200000000。
     * 说明 验证码类型短信，建议使用接口SendSms单独发送。
     *
     * @param signNameJson  短信签名名称，JSON数组格式。
     * 说明 必须是已添加、并通过审核的短信签名；且短信签名的个数必须与手机号码的个数相同、内容一一对应。
     *
     * @param templateCode 短信模板CODE。
     * 说明 必须是已添加、并通过审核的模板CODE；且发送国际/港澳台消息时，请使用国际/港澳台短信模版。
     *
     * @param templateParamJson  短信模板变量对应的实际值，JSON格式。
     * 说明 如果JSON中需要带换行符，请参照标准的JSON协议处理；且模板变量值的个数必须与手机号码、签名的个数相同、内容一一对应，表示向指定手机号码中发对应签名的短信，且短信模板中的变量参数替换为对应的值。
     *
     * @return
     */
    public CommonResponse sendBatchSms(String phoneNumberJson,String signNameJson,String templateCode,String templateParamJson){
        DefaultProfile profile = DefaultProfile.getProfile(REGION_ID, shscAliyunConstant.getAccessKeyId(), shscAliyunConstant.getAccessKeySecret());
        IAcsClient client = new DefaultAcsClient(profile);
        // 创建API请求并设置参数
        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain(DOMAIN);
        request.setVersion("2017-05-25");

        request.setAction("SendBatchSms");
        request.putQueryParameter("PhoneNumberJson", phoneNumberJson);
        request.putQueryParameter("SignNameJson", signNameJson);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParamJson", templateParamJson);
        CommonResponse response = null ;
        try {
            response = client.getCommonResponse(request);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }


}
