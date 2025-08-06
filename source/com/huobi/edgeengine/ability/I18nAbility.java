package com.huobi.edgeengine.ability;

import com.alibaba.fastjson.JSON;
import com.huobi.edgeengine.ability.AbilityFunction;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.r;
import rj.b;

public final class I18nAbility implements s {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43893a = new a((r) null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public void a(b bVar, Object obj, AbilityFunction.a aVar) {
        Object parse = JSON.parse(String.valueOf(obj));
        String str = null;
        if ((parse instanceof Map) && bVar != null) {
            Map map = (Map) parse;
            Object obj2 = map.get("key");
            if (obj2 != null) {
                str = obj2.toString();
            }
            String b11 = b(bVar, str, map.get("realValue"));
            if (aVar != null) {
                aVar.a(true, b11);
            }
        } else if (aVar != null) {
            aVar.a(false, (Object) null);
        }
    }

    public final String b(b bVar, String str, Object obj) {
        if (sd.a.c(str)) {
            return "";
        }
        String b11 = ek.a.f47514a.b(bVar, str);
        if (!(obj instanceof List)) {
            return b11;
        }
        Object[] array = ((Collection) obj).toArray(new Object[0]);
        d0 d0Var = d0.f56774a;
        Object[] copyOf = Arrays.copyOf(array, array.length);
        return String.format(b11, Arrays.copyOf(copyOf, copyOf.length));
    }
}
