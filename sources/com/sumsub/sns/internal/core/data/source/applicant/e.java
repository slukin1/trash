package com.sumsub.sns.internal.core.data.source.applicant;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.remote.k;
import com.sumsub.sns.internal.core.data.source.applicant.remote.a;
import com.sumsub.sns.internal.core.data.source.applicant.remote.a0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.b;
import com.sumsub.sns.internal.core.data.source.applicant.remote.b0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.d0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.e0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.g;
import com.sumsub.sns.internal.core.data.source.applicant.remote.h0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.n;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import com.sumsub.sns.internal.core.data.source.applicant.remote.y;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.c;

public interface e {
    Object a(u uVar, c<? super w> cVar);

    Object a(y yVar, c<? super w> cVar);

    Object a(String str, int i11, c<? super Unit> cVar);

    Object a(String str, a0 a0Var, c<? super b0> cVar);

    Object a(String str, b bVar, c<? super e0> cVar);

    Object a(String str, String str2, a aVar, c<? super e0> cVar);

    Object a(String str, String str2, File file, String str3, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, c<? super k> cVar);

    Object a(String str, String str2, InputStream inputStream, String str3, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, c<? super k> cVar);

    Object a(String str, String str2, String str3, String str4, List<String> list, c<? super g> cVar);

    Object a(String str, String str2, String str3, List<com.sumsub.sns.internal.core.data.model.remote.e> list, List<String> list2, c<? super com.sumsub.sns.internal.core.data.model.g> cVar);

    Object a(String str, String str2, String str3, c<? super b0> cVar);

    Object a(String str, String str2, c<? super Unit> cVar);

    Object a(String str, Map<String, ? extends Object> map, List<String> list, c<? super g.a> cVar);

    Object a(String str, c<? super Boolean> cVar);

    Object a(String str, byte[] bArr, c<? super Map<String, ? extends Object>> cVar);

    Object a(c<? super List<n>> cVar);

    Object b(String str, c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.g> cVar);

    Object c(String str, c<? super h0> cVar);

    Object d(String str, c<? super d0> cVar);

    Object e(String str, c<? super Map<String, ? extends Object>> cVar);

    Object g(String str, c<? super w> cVar);
}
