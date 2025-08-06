package com.jumio.core.util;

import d10.l;
import kotlin.Unit;

public final class StringUtilKt {
    public static final void isNotNullOrEmpty(String str, l<? super String, Unit> lVar) {
        boolean z11 = false;
        if (str != null) {
            if (str.length() > 0) {
                z11 = true;
            }
        }
        if (z11) {
            lVar.invoke(str);
        }
    }
}
