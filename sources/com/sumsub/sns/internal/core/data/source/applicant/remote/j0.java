package com.sumsub.sns.internal.core.data.source.applicant.remote;

import java.util.Map;
import kotlin.coroutines.c;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public final /* synthetic */ class j0 {
    public static /* synthetic */ Object a(c cVar, String str, MultipartBody.Part part, RequestBody requestBody, Map map, String str2, c cVar2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 16) != 0) {
                str2 = null;
            }
            return cVar.b(str, part, requestBody, map, str2, cVar2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadImageForAction");
    }

    public static /* synthetic */ Object b(c cVar, String str, MultipartBody.Part part, RequestBody requestBody, Map map, String str2, c cVar2, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 16) != 0) {
                str2 = null;
            }
            return cVar.a(str, part, requestBody, map, str2, cVar2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: uploadImage");
    }
}
