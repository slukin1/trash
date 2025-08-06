package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;

public class FastJsonHttpMessageConverter4 extends AbstractGenericHttpMessageConverter<Object> {

    /* renamed from: a  reason: collision with root package name */
    public FastJsonConfig f14364a = new FastJsonConfig();

    public FastJsonHttpMessageConverter4() {
        super(MediaType.ALL);
    }
}
