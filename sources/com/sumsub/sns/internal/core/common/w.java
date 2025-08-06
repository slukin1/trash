package com.sumsub.sns.internal.core.common;

import com.sumsub.sns.internal.core.data.source.dynamic.b;

public final class w {
    public static final CharSequence a(b.c cVar, String... strArr) {
        if (cVar == null) {
            return "";
        }
        for (String a11 : strArr) {
            String a12 = cVar.a(a11);
            if (!(a12 == null || StringsKt__StringsJVMKt.z(a12))) {
                return a12;
            }
        }
        return "";
    }
}
