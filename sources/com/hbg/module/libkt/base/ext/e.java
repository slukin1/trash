package com.hbg.module.libkt.base.ext;

import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public final /* synthetic */ class e implements JsonSerializer {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ e f24520a = new e();

    public final JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonSerializationContext) {
        return f.d((Long) obj, type, jsonSerializationContext);
    }
}
