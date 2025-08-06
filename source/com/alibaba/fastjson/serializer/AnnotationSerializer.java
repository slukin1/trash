package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import h2.k;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;
import sun.reflect.annotation.AnnotationType;

public class AnnotationSerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static AnnotationSerializer f14250a = new AnnotationSerializer();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        Class[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            Map members = AnnotationType.getInstance(interfaces[0]).members();
            JSONObject jSONObject = new JSONObject(members.size());
            Object obj3 = null;
            for (Map.Entry entry : members.entrySet()) {
                try {
                    obj3 = ((Method) entry.getValue()).invoke(obj, new Object[0]);
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
                jSONObject.put((String) entry.getKey(), JSON.toJSON(obj3));
            }
            jSONSerializer.E(jSONObject);
        }
    }
}
