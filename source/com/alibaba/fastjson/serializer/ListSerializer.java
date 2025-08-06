package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import com.iproov.sdk.bridge.OptionsBridge;
import h2.k;
import h2.n;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.HttpUrl;

public final class ListSerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final ListSerializer f14286a = new ListSerializer();

    /* JADX INFO: finally extract failed */
    public final void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        char c11;
        int i12;
        Object obj3;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj4 = obj;
        boolean n11 = jSONSerializer2.f14277k.n(SerializerFeature.WriteClassName);
        SerializeWriter serializeWriter = jSONSerializer2.f14277k;
        Type G = n11 ? TypeUtils.G(type) : null;
        if (obj4 == null) {
            serializeWriter.J(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj4;
        if (list.size() == 0) {
            serializeWriter.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        n nVar = jSONSerializer2.f14283q;
        jSONSerializer2.B(nVar, obj4, obj2, 0);
        try {
            char c12 = ',';
            char c13 = ']';
            if (serializeWriter.n(SerializerFeature.PrettyFormat)) {
                serializeWriter.append('[');
                jSONSerializer.x();
                int i13 = 0;
                for (Object next : list) {
                    if (i13 != 0) {
                        serializeWriter.append(c12);
                    }
                    jSONSerializer.A();
                    if (next == null) {
                        jSONSerializer2.f14277k.H();
                    } else if (jSONSerializer2.r(next)) {
                        jSONSerializer2.H(next);
                    } else {
                        k v11 = jSONSerializer2.v(next.getClass());
                        n nVar2 = r1;
                        n nVar3 = new n(nVar, obj, obj2, 0, 0);
                        jSONSerializer2.f14283q = nVar2;
                        v11.c(jSONSerializer, next, Integer.valueOf(i13), G, 0);
                    }
                    i13++;
                    c12 = ',';
                }
                jSONSerializer.s();
                jSONSerializer.A();
                serializeWriter.append(']');
                jSONSerializer2.f14283q = nVar;
                return;
            }
            serializeWriter.append('[');
            int size = list.size();
            int i14 = 0;
            while (i14 < size) {
                Object obj5 = list.get(i14);
                if (i14 != 0) {
                    c11 = ',';
                    serializeWriter.append(',');
                } else {
                    c11 = ',';
                }
                if (obj5 == null) {
                    serializeWriter.append(OptionsBridge.NULL_VALUE);
                } else {
                    Class<?> cls = obj5.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.E(((Integer) obj5).intValue());
                    } else if (cls == Long.class) {
                        long longValue = ((Long) obj5).longValue();
                        if (n11) {
                            serializeWriter.G(longValue);
                            serializeWriter.write(76);
                        } else {
                            serializeWriter.G(longValue);
                        }
                    } else {
                        if ((SerializerFeature.DisableCircularReferenceDetect.mask & i11) != 0) {
                            char c14 = c11;
                            i12 = i14;
                            jSONSerializer2.v(obj5.getClass()).c(jSONSerializer, obj5, Integer.valueOf(i14), G, i11);
                        } else {
                            char c15 = c11;
                            i12 = i14;
                            if (!serializeWriter.f14327i) {
                                obj3 = obj5;
                                n nVar4 = r1;
                                n nVar5 = new n(nVar, obj, obj2, 0, 0);
                                jSONSerializer2.f14283q = nVar4;
                            } else {
                                obj3 = obj5;
                            }
                            if (jSONSerializer2.r(obj3)) {
                                jSONSerializer2.H(obj3);
                            } else {
                                jSONSerializer2.v(obj3.getClass()).c(jSONSerializer, obj3, Integer.valueOf(i12), G, 0);
                            }
                        }
                        i14 = i12 + 1;
                        Object obj6 = obj;
                        c13 = ']';
                    }
                }
                char c16 = c11;
                i12 = i14;
                i14 = i12 + 1;
                Object obj62 = obj;
                c13 = ']';
            }
            serializeWriter.append(c13);
            jSONSerializer2.f14283q = nVar;
        } catch (Throwable th2) {
            jSONSerializer2.f14283q = nVar;
            throw th2;
        }
    }
}
