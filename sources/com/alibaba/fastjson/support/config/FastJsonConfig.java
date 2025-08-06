package com.alibaba.fastjson.support.config;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import h2.p;
import java.nio.charset.Charset;

public class FastJsonConfig {

    /* renamed from: a  reason: collision with root package name */
    public Charset f14338a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    public SerializeConfig f14339b = SerializeConfig.d();

    /* renamed from: c  reason: collision with root package name */
    public ParserConfig f14340c = new ParserConfig();

    /* renamed from: d  reason: collision with root package name */
    public SerializerFeature[] f14341d = new SerializerFeature[0];

    /* renamed from: e  reason: collision with root package name */
    public p[] f14342e = new p[0];

    /* renamed from: f  reason: collision with root package name */
    public Feature[] f14343f = new Feature[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f14344g = true;
}
