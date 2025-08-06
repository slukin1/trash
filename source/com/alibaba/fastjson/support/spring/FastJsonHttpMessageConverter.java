package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import h2.p;
import java.nio.charset.Charset;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.GenericHttpMessageConverter;

public class FastJsonHttpMessageConverter extends AbstractHttpMessageConverter<Object> implements GenericHttpMessageConverter<Object> {

    /* renamed from: a  reason: collision with root package name */
    public Charset f14360a = Charset.forName("UTF-8");
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public SerializerFeature[] f14361b = new SerializerFeature[0];
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public p[] f14362c = new p[0];

    /* renamed from: d  reason: collision with root package name */
    public FastJsonConfig f14363d = new FastJsonConfig();

    public FastJsonHttpMessageConverter() {
        super(MediaType.ALL);
    }
}
