package com.zhy.controller;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.zhy.component.PhoneRandomBuilder;
import com.zhy.constant.OSSClientConstants;
import com.zhy.model.User;
import com.zhy.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author: zhangocean
 * @Date: 2018/6/4 15:03
 * Describe: 注册获得手机验证码
 */
@Controller
public class GetPhoneCodeControl {

    @Autowired
    private UserService userService;

    @PostMapping("/getCode")
    @ResponseBody
    public int getAuthCode(HttpServletRequest request) {

        String phone = request.getParameter("phone");
        if (StringUtils.isBlank(phone)) {
            return 0;
        }
        User user = userService.findUsernameByPhone(phone);
        if (!Objects.isNull(user)) {
            return 2;
        }
        String sign = request.getParameter("sign");
        String trueMsgCode = PhoneRandomBuilder.randomBuilder();

        request.getSession().setAttribute("trueMsgCode", trueMsgCode);
        request.getSession().setAttribute("msgCodePhone", phone);

        //注册模板
        String msgCode;
        if ("register".equals(sign)) {
            msgCode = "SMS_164278716";
        }
        //改密码模板
        else {
            msgCode = "SMS_164269163";
        }

        CommonResponse sendSmsResponse;
        sendSmsResponse = sendSmsResponse(phone, trueMsgCode, msgCode);

        return 1;
    }

    public static CommonResponse sendSmsResponse(String phoneNumber, String code, String msgCode) {
        DefaultProfile profile = DefaultProfile.getProfile("default", OSSClientConstants.ACCESS_KEY_ID, OSSClientConstants.ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "菜鸟blog");
        request.putQueryParameter("TemplateCode", msgCode);
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        CommonResponse response = null;
        try {
            response = client.getCommonResponse(request);
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return response;
    }

}
