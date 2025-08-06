package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import h2.p;
import java.nio.charset.Charset;
import org.springframework.web.servlet.view.AbstractView;

public class FastJsonJsonView extends AbstractView {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public Charset f14365a = Charset.forName("UTF-8");
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public SerializerFeature[] f14366b = new SerializerFeature[0];
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public p[] f14367c = new p[0];

    /* renamed from: d  reason: collision with root package name */
    public boolean f14368d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14369e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f14370f = false;

    /* renamed from: g  reason: collision with root package name */
    public FastJsonConfig f14371g = new FastJsonConfig();

    public FastJsonJsonView() {
        setContentType("application/json;charset=UTF-8");
        setExposePathVariables(false);
    }
}
