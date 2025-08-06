package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.util.IOUtils;
import java.nio.charset.Charset;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;

public class FastJsonpHttpMessageConverter4 extends AbstractGenericHttpMessageConverter<Object> {

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f14372b;

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f14373c;

    /* renamed from: a  reason: collision with root package name */
    public FastJsonConfig f14374a = new FastJsonConfig();

    static {
        Charset charset = IOUtils.f14402b;
        f14372b = "/**/".getBytes(charset);
        f14373c = ");".getBytes(charset);
    }

    public FastJsonpHttpMessageConverter4() {
        super(MediaType.ALL);
    }
}
