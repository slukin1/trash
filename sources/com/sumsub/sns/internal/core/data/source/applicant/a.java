package com.sumsub.sns.internal.core.data.source.applicant;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.SNSMessage;
import com.sumsub.sns.internal.core.data.model.b;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.remote.e;
import com.sumsub.sns.internal.core.data.model.remote.k;
import com.sumsub.sns.internal.core.data.model.remote.response.d;
import com.sumsub.sns.internal.core.data.source.applicant.remote.a0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.b0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.d0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.e0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.h0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.n;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import com.sumsub.sns.internal.core.data.source.applicant.remote.y;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlinx.coroutines.flow.d;

public interface a {
    Object a(u uVar, c<? super w> cVar);

    Object a(y yVar, c<? super w> cVar);

    Object a(String str, int i11, c<? super Unit> cVar);

    Object a(String str, b bVar, c<? super g> cVar);

    Object a(String str, a0 a0Var, c<? super b0> cVar);

    Object a(String str, com.sumsub.sns.internal.core.data.source.applicant.remote.b bVar, c<? super e0> cVar);

    Object a(String str, String str2, com.sumsub.sns.internal.core.data.source.applicant.remote.a aVar, c<? super e0> cVar);

    Object a(String str, String str2, File file, String str3, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, a.C0361a aVar, c<? super k> cVar);

    Object a(String str, String str2, InputStream inputStream, String str3, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, c<? super k> cVar);

    Object a(String str, String str2, String str3, String str4, List<String> list, c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.g> cVar);

    Object a(String str, String str2, String str3, List<e> list, List<String> list2, c<? super g> cVar);

    Object a(String str, String str2, String str3, c<? super b0> cVar);

    Object a(String str, String str2, c<? super Unit> cVar);

    Object a(String str, Map<String, ? extends Object> map, List<String> list, c<? super g.a> cVar);

    Object a(String str, c<? super Boolean> cVar);

    Object a(String str, byte[] bArr, c<? super Map<String, ? extends Object>> cVar);

    Object a(c<? super List<n>> cVar);

    d<SNSMessage.ServerMessage> a(com.sumsub.sns.internal.core.b<String> bVar);

    Object b(y yVar, c<? super w> cVar);

    Object b(String str, int i11, c<? super Unit> cVar);

    Object b(String str, b bVar, c<? super g> cVar);

    Object b(String str, a0 a0Var, c<? super b0> cVar);

    Object b(String str, String str2, File file, String str3, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, a.C0361a aVar, c<? super k> cVar);

    Object b(String str, String str2, InputStream inputStream, String str3, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, c<? super k> cVar);

    Object b(String str, String str2, String str3, c<? super b0> cVar);

    Object b(String str, String str2, c<? super Unit> cVar);

    Object b(String str, c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.g> cVar);

    Object c(String str, c<? super h0> cVar);

    Object d(String str, c<? super d0> cVar);

    Object e(String str, c<? super Map<String, ? extends Object>> cVar);

    Object f(String str, c<? super d.c.C0351d> cVar);

    Object g(String str, c<? super w> cVar);
}
