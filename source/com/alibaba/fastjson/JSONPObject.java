package com.alibaba.fastjson;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import h2.g;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class JSONPObject implements g {

    /* renamed from: c  reason: collision with root package name */
    public static String f14086c = "/**/";

    /* renamed from: d  reason: collision with root package name */
    public static final int f14087d = SerializerFeature.BrowserSecure.mask;

    /* renamed from: a  reason: collision with root package name */
    public String f14088a;

    /* renamed from: b  reason: collision with root package name */
    public final List<Object> f14089b = new ArrayList();

    public JSONPObject() {
    }

    public void a(JSONSerializer jSONSerializer, Object obj, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        int i12 = f14087d;
        if ((i11 & i12) != 0 || serializeWriter.m(i12)) {
            serializeWriter.write(f14086c);
        }
        serializeWriter.write(this.f14088a);
        serializeWriter.write(40);
        for (int i13 = 0; i13 < this.f14089b.size(); i13++) {
            if (i13 != 0) {
                serializeWriter.write(44);
            }
            jSONSerializer.E(this.f14089b.get(i13));
        }
        serializeWriter.write(41);
    }

    public void b(Object obj) {
        this.f14089b.add(obj);
    }

    public String toString() {
        return JSON.toJSONString(this);
    }

    public JSONPObject(String str) {
        this.f14088a = str;
    }
}
