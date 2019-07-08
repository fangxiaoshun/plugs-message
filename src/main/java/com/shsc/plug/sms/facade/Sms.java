package com.shsc.plug.sms.facade;

import com.aliyuncs.CommonResponse;

/**
 * @author fangxs
 * @date 2019/6/19 11:31
 * @description:
 */

public interface Sms {

    /**
     * 接口描述：短信发送接口，支持在一次请求中向多个不同的手机号码发送同样内容的短信
     * 如果您需要在一次请求中分别向多个不同的手机号码发送不同签名和模版内容的短信，请使用SendBatchSms接口。
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
    public CommonResponse sendSms(String phoneNumbers, String signName, String templateCode, String templateParam);


    /**
     * 接口描述： 接口是短信批量发送接口，支持在一次请求中分别向多个不同的手机号码发送不同签名的短信。手机号码等参数均为JSON格式，字段个数相同，一一对应，短信服务根据字段在JSON中的顺序判断发往指定手机号码的签名。
     * 如果您需要往多个手机号码中发送同样签名的短信，请使用SendSms接口实现。
     *
     * @param phoneNumberJson  接收短信的手机号码，JSON数组格式。
     * 手机号码格式：
     * 国内短信：11位手机号码，例如15900000000。
     * 国际/港澳台消息：国际区号+号码，例如85200000000。
     * 说明 验证码类型短信，建议使用接口SendSms单独发送。
     * @param signNameJson  短信签名名称，JSON数组格式。
     * 说明 必须是已添加、并通过审核的短信签名；且短信签名的个数必须与手机号码的个数相同、内容一一对应。
     * @param templateCode 短信模板CODE。
     * 说明 必须是已添加、并通过审核的模板CODE；且发送国际/港澳台消息时，请使用国际/港澳台短信模版。
     * @param templateParamJson  短信模板变量对应的实际值，JSON格式。
     * 说明 如果JSON中需要带换行符，请参照标准的JSON协议处理；且模板变量值的个数必须与手机号码、签名的个数相同、内容一一对应，表示向指定手机号码中发对应签名的短信，且短信模板中的变量参数替换为对应的值。
     * @return
     */
    public CommonResponse sendBatchSms(String phoneNumberJson,String signNameJson,String templateCode,String templateParamJson);

}
