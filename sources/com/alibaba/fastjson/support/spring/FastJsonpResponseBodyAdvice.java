package com.alibaba.fastjson.support.spring;

import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.regex.Pattern;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class FastJsonpResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f14375b = Pattern.compile("[0-9A-Za-z_\\.]*");

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f14376c = {TUIConstants.TUIChat.CALL_BACK, "jsonp"};

    /* renamed from: a  reason: collision with root package name */
    public final String[] f14377a = f14376c;
}
