package com.sumsub.sns.internal.core.data.source.applicant;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.remote.k;
import com.sumsub.sns.internal.core.data.source.applicant.remote.a0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.b0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import d10.l;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.c;

public interface b {
    Object a(int i11, c<? super Unit> cVar);

    Object a(com.sumsub.sns.internal.core.data.model.b bVar, c<? super g> cVar);

    Object a(a0 a0Var, c<? super b0> cVar);

    Object a(u uVar, c<? super w> cVar);

    Object a(String str, File file, String str2, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, a.C0361a aVar, c<? super k> cVar);

    Object a(String str, InputStream inputStream, String str2, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, c<? super k> cVar);

    Object a(String str, String str2, c<? super b0> cVar);

    Object a(String str, c<? super Unit> cVar);

    Object a(c<? super l<? super String, String>> cVar);

    Object b(c<? super Boolean> cVar);

    Object c(c<? super String> cVar);
}
