package com.sumsub.sns.internal.core.data.source.applicant;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a;
import java.io.File;
import java.util.Map;
import kotlin.coroutines.c;

public final /* synthetic */ class h {
    public static /* synthetic */ Object a(b bVar, String str, File file, String str2, IdentitySide identitySide, Map map, DocumentType documentType, a.C0361a aVar, c cVar, int i11, Object obj) {
        if (obj == null) {
            return bVar.a(str, file, str2, (i11 & 8) != 0 ? null : identitySide, (i11 & 16) != 0 ? MapsKt__MapsKt.h() : map, (i11 & 32) != 0 ? null : documentType, aVar, cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
    }
}
