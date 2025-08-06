package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.util.TypeUtils;
import f2.a;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionalCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static OptionalCodec f14219a = new OptionalCodec();

    public int b() {
        return 12;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        if (obj == null) {
            jSONSerializer.G();
        } else if (obj instanceof Optional) {
            Optional optional = (Optional) obj;
            jSONSerializer.E(optional.isPresent() ? optional.get() : null);
        } else if (obj instanceof OptionalDouble) {
            OptionalDouble optionalDouble = (OptionalDouble) obj;
            if (optionalDouble.isPresent()) {
                jSONSerializer.E(Double.valueOf(optionalDouble.getAsDouble()));
            } else {
                jSONSerializer.G();
            }
        } else if (obj instanceof OptionalInt) {
            OptionalInt optionalInt = (OptionalInt) obj;
            if (optionalInt.isPresent()) {
                jSONSerializer.f14277k.E(optionalInt.getAsInt());
            } else {
                jSONSerializer.G();
            }
        } else if (obj instanceof OptionalLong) {
            OptionalLong optionalLong = (OptionalLong) obj;
            if (optionalLong.isPresent()) {
                jSONSerializer.f14277k.G(optionalLong.getAsLong());
            } else {
                jSONSerializer.G();
            }
        } else {
            throw new JSONException("not support optional : " + obj.getClass());
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        if (type == OptionalInt.class) {
            Integer q11 = TypeUtils.q(aVar.K(Integer.class));
            if (q11 == null) {
                return OptionalInt.empty();
            }
            return OptionalInt.of(q11.intValue());
        } else if (type == OptionalLong.class) {
            Long t11 = TypeUtils.t(aVar.K(Long.class));
            if (t11 == null) {
                return OptionalLong.empty();
            }
            return OptionalLong.of(t11.longValue());
        } else if (type == OptionalDouble.class) {
            Double n11 = TypeUtils.n(aVar.K(Double.class));
            if (n11 == null) {
                return OptionalDouble.empty();
            }
            return OptionalDouble.of(n11.doubleValue());
        } else {
            Object L = aVar.L(TypeUtils.a0(type));
            if (L == null) {
                return Optional.empty();
            }
            return Optional.of(L);
        }
    }
}
