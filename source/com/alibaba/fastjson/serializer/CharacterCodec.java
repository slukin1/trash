package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import f2.a;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;

public class CharacterCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static final CharacterCodec f14262a = new CharacterCodec();

    public int b() {
        return 4;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        Character ch2 = (Character) obj;
        if (ch2 == null) {
            serializeWriter.K("");
        } else if (ch2.charValue() == 0) {
            serializeWriter.K("\u0000");
        } else {
            serializeWriter.K(ch2.toString());
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        Object z11 = aVar.z();
        if (z11 == null) {
            return null;
        }
        return TypeUtils.l(z11);
    }
}
