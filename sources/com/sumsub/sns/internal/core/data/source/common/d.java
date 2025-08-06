package com.sumsub.sns.internal.core.data.source.common;

import com.sumsub.sns.internal.core.common.e0;
import kotlin.coroutines.c;

public final /* synthetic */ class d {
    public static Object a(a aVar, c cVar) {
        return e0.f32018a.getLocale();
    }

    public static /* synthetic */ Object b(a aVar, String str, boolean z11, c cVar, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                z11 = false;
            }
            return aVar.a(str, z11, cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getActionById");
    }
}
