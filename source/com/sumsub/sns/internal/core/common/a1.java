package com.sumsub.sns.internal.core.common;

import com.sumsub.sns.internal.core.data.model.remote.o;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.l;
import kotlin.text.Regex;

public final class a1 {

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Regex> f31966a = MapsKt__MapsKt.h();

    public static /* synthetic */ boolean a(a1 a1Var, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return a1Var.a(str, str2);
    }

    public final boolean a(String str, String str2) {
        Object obj;
        if (str2 == null || (obj = str2.toUpperCase(Locale.ROOT)) == null) {
            obj = Boolean.TRUE;
        }
        Regex regex = this.f31966a.get(obj);
        if (regex != null) {
            return regex.matches(str);
        }
        return true;
    }

    public final void a(Map<String, o> map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry next : map.entrySet()) {
            String d11 = ((o) next.getValue()).d();
            Pair a11 = d11 != null ? l.a(((String) next.getKey()).toUpperCase(Locale.ROOT), new Regex(d11)) : null;
            if (a11 != null) {
                arrayList.add(a11);
            }
        }
        this.f31966a = MapsKt__MapsKt.s(arrayList);
    }
}
