package com.sumsub.sns.internal.core.data.source.applicant;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.remote.k;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import kotlin.coroutines.c;

public final /* synthetic */ class i {
    public static /* synthetic */ Object a(e eVar, String str, String str2, File file, String str3, IdentitySide identitySide, Map map, DocumentType documentType, c cVar, int i11, Object obj) {
        if (obj == null) {
            return eVar.a(str, str2, file, str3, (i11 & 16) != 0 ? null : identitySide, (Map<String, String>) (i11 & 32) != 0 ? MapsKt__MapsKt.h() : map, (i11 & 64) != 0 ? null : documentType, (c<? super k>) cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
    }

    public static /* synthetic */ Object b(e eVar, String str, String str2, InputStream inputStream, String str3, IdentitySide identitySide, Map map, DocumentType documentType, c cVar, int i11, Object obj) {
        if (obj == null) {
            return eVar.a(str, str2, inputStream, str3, identitySide, (Map<String, String>) (i11 & 32) != 0 ? MapsKt__MapsKt.h() : map, documentType, (c<? super k>) cVar);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadFile");
    }
}
