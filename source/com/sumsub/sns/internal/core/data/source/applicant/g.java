package com.sumsub.sns.internal.core.data.source.applicant;

import com.sumsub.sns.internal.core.b;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.d;

public final /* synthetic */ class g {
    public static Object a(a aVar, String str, int i11, c cVar) {
        return h(aVar, str, i11, cVar);
    }

    public static Object b(a aVar, String str, String str2, String str3, List list, List list2, c cVar) {
        return j(aVar, str, str2, str3, list, list2, cVar);
    }

    public static Object c(a aVar, String str, Map map, List list, c cVar) {
        return k(aVar, str, map, list, cVar);
    }

    public static Object d(a aVar, String str, c cVar) {
        return l(aVar, str, cVar);
    }

    public static d e(a aVar, b bVar) {
        throw new UnsupportedOperationException();
    }

    public static Object f(a aVar, String str, int i11, c cVar) {
        return m(aVar, str, i11, cVar);
    }

    public static Object g(a aVar, String str, c cVar) {
        return o(aVar, str, cVar);
    }

    public static /* synthetic */ Object h(a aVar, String str, int i11, c cVar) {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ Object i(a aVar, String str, String str2, File file, String str3, IdentitySide identitySide, Map map, DocumentType documentType, a.C0361a aVar2, c cVar, int i11, Object obj) {
        if (obj == null) {
            return aVar.a(str, str2, file, str3, (i11 & 16) != 0 ? null : identitySide, (i11 & 32) != 0 ? MapsKt__MapsKt.h() : map, (i11 & 64) != 0 ? null : documentType, aVar2, cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
    }

    public static /* synthetic */ Object j(a aVar, String str, String str2, String str3, List list, List list2, c cVar) {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ Object k(a aVar, String str, Map map, List list, c cVar) {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ Object l(a aVar, String str, c cVar) {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ Object m(a aVar, String str, int i11, c cVar) {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ Object n(a aVar, String str, String str2, File file, String str3, IdentitySide identitySide, Map map, DocumentType documentType, a.C0361a aVar2, c cVar, int i11, Object obj) {
        if (obj == null) {
            return aVar.b(str, str2, file, str3, (i11 & 16) != 0 ? null : identitySide, (i11 & 32) != 0 ? MapsKt__MapsKt.h() : map, (i11 & 64) != 0 ? null : documentType, aVar2, cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFileForAction");
    }

    public static /* synthetic */ Object o(a aVar, String str, c cVar) {
        throw new UnsupportedOperationException();
    }
}
