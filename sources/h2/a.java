package h2;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.iproov.sdk.bridge.OptionsBridge;
import java.io.IOException;
import java.lang.reflect.Type;

public class a implements k {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f15899a;

    /* renamed from: b  reason: collision with root package name */
    public final k f15900b;

    public a(Class<?> cls, k kVar) {
        this.f15899a = cls;
        this.f15900b = kVar;
    }

    public final void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        n nVar = jSONSerializer.f14283q;
        jSONSerializer.B(nVar, obj, obj2, 0);
        try {
            serializeWriter.append('[');
            for (int i12 = 0; i12 < length; i12++) {
                if (i12 != 0) {
                    serializeWriter.append(',');
                }
                Object obj3 = objArr[i12];
                if (obj3 == null) {
                    if (!serializeWriter.n(SerializerFeature.WriteNullStringAsEmpty) || !(obj instanceof String[])) {
                        serializeWriter.append(OptionsBridge.NULL_VALUE);
                    } else {
                        serializeWriter.K("");
                    }
                } else if (obj3.getClass() == this.f15899a) {
                    this.f15900b.c(jSONSerializer, obj3, Integer.valueOf(i12), (Type) null, 0);
                } else {
                    jSONSerializer.v(obj3.getClass()).c(jSONSerializer, obj3, Integer.valueOf(i12), (Type) null, 0);
                }
            }
            serializeWriter.append(']');
        } finally {
            jSONSerializer.f14283q = nVar;
        }
    }
}
