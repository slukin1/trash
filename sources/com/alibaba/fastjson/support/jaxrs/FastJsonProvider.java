package com.alibaba.fastjson.support.jaxrs;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import h2.p;
import java.nio.charset.Charset;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Consumes({"*/*"})
@Produces({"*/*"})
@Provider
public class FastJsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public Charset f14345a = Charset.forName("UTF-8");
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public SerializerFeature[] f14346b = new SerializerFeature[0];
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public p[] f14347c = new p[0];

    /* renamed from: d  reason: collision with root package name */
    public FastJsonConfig f14348d = new FastJsonConfig();

    /* renamed from: e  reason: collision with root package name */
    public Class<?>[] f14349e = null;
}
