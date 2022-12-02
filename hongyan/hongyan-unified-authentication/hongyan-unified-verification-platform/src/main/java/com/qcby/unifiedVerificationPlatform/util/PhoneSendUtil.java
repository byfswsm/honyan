package com.qcby.unifiedVerificationPlatform.util;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PhoneSendUtil {


    public static void sendMsg(String phoneNumber) {
        try {
            String code = CodeUtil.getCode();

            //放入map中
            CodeUtil.getLoginCodeMap().put(phoneNumber, code);

            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential("AKIDvgBQP8ZjcNr3yby4tQhhyyhAMGtGMAhy", "0kCNHuGLDo8BxSfbFdkZ7OO7ZlgKl0yf");
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {phoneNumber};
            req.setPhoneNumberSet(phoneNumberSet1);
            req.setSmsSdkAppId("1400580390");
            req.setSignName("yenanren");
            req.setTemplateId("1152673");

            String[] templateParams = {code, "2"};
            req.setTemplateParamSet(templateParams);
            // 返回的resp是一个SendSmsResponse的实例，与请求对象对应
            SendSmsResponse resp = client.SendSms(req);
            // 输出json格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(resp));

            //得到手机号或者邮箱之后,设置两分钟自动删除Map表中验证码数据
//            CodeUtil.delayDeleteUserCode(phoneNumber);====>更改为注解删除phone
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }


}