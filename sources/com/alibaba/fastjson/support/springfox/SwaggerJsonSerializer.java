package com.alibaba.fastjson.support.springfox;

import com.alibaba.fastjson.serializer.JSONSerializer;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import springfox.documentation.spring.web.json.Json;

public class SwaggerJsonSerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final SwaggerJsonSerializer f14379a = new SwaggerJsonSerializer();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        jSONSerializer.w().write(((Json) obj).value());
    }
}
