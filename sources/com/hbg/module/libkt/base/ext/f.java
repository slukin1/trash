package com.hbg.module.libkt.base.ext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public final class f {
    public static final JsonElement c(Double d11, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive((Number) BigDecimal.valueOf(d11.doubleValue()));
    }

    public static final JsonElement d(Long l11, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive((Number) BigDecimal.valueOf(l11.longValue()));
    }

    public static final Gson e() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Double.TYPE, d.f24519a);
        gsonBuilder.registerTypeAdapter(Long.TYPE, e.f24520a);
        return gsonBuilder.create();
    }

    public static final String f(Object obj) {
        if (obj == null) {
            return null;
        }
        return e().toJson(obj);
    }
}
