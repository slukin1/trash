package com.sumsub.sns.internal.core.data.source.applicant;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.remote.e;
import com.sumsub.sns.internal.core.data.model.remote.k;
import com.sumsub.sns.internal.core.data.source.applicant.remote.a0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.b;
import com.sumsub.sns.internal.core.data.source.applicant.remote.b0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.d0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.e0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.g;
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

public final class f implements e {

    /* renamed from: a  reason: collision with root package name */
    public final a f33040a;

    public f(a aVar) {
        this.f33040a = aVar;
    }

    public Object a(String str, String str2, File file, String str3, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, c<? super k> cVar) {
        return this.f33040a.a(str, str2, file, str3, identitySide, map, documentType, (a.C0361a) null, cVar);
    }

    public Object b(String str, c<? super g> cVar) {
        return this.f33040a.b(str, cVar);
    }

    public Object c(String str, c<? super h0> cVar) {
        return this.f33040a.c(str, cVar);
    }

    public Object d(String str, c<? super d0> cVar) {
        return this.f33040a.d(str, cVar);
    }

    public Object e(String str, c<? super Map<String, ? extends Object>> cVar) {
        return this.f33040a.e(str, cVar);
    }

    public Object g(String str, c<? super w> cVar) {
        return this.f33040a.g(str, cVar);
    }

    public Object a(String str, String str2, c<? super Unit> cVar) {
        Object a11 = this.f33040a.a(str, str2, cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }

    public Object a(String str, String str2, InputStream inputStream, String str3, IdentitySide identitySide, Map<String, String> map, DocumentType documentType, c<? super k> cVar) {
        return this.f33040a.a(str, str2, inputStream, str3, identitySide, map, documentType, cVar);
    }

    public Object a(String str, int i11, c<? super Unit> cVar) {
        Object a11 = this.f33040a.a(str, i11, cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }

    public Object a(String str, c<? super Boolean> cVar) {
        return this.f33040a.a(str, cVar);
    }

    public Object a(String str, Map<String, ? extends Object> map, List<String> list, c<? super g.a> cVar) {
        return this.f33040a.a(str, map, list, cVar);
    }

    public Object a(String str, String str2, String str3, List<e> list, List<String> list2, c<? super com.sumsub.sns.internal.core.data.model.g> cVar) {
        return this.f33040a.a(str, str2, str3, list, list2, cVar);
    }

    public Object a(String str, a0 a0Var, c<? super b0> cVar) {
        return this.f33040a.a(str, a0Var, cVar);
    }

    public Object a(String str, String str2, String str3, c<? super b0> cVar) {
        return this.f33040a.a(str, str2, str3, cVar);
    }

    public Object a(y yVar, c<? super w> cVar) {
        return this.f33040a.a(yVar, cVar);
    }

    public Object a(u uVar, c<? super w> cVar) {
        return this.f33040a.a(uVar, cVar);
    }

    public Object a(String str, String str2, String str3, String str4, List<String> list, c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.g> cVar) {
        return this.f33040a.a(str, str2, str3, str4, list, cVar);
    }

    public Object a(c<? super List<n>> cVar) {
        return this.f33040a.a(cVar);
    }

    public Object a(String str, byte[] bArr, c<? super Map<String, ? extends Object>> cVar) {
        return this.f33040a.a(str, bArr, cVar);
    }

    public Object a(String str, b bVar, c<? super e0> cVar) {
        return this.f33040a.a(str, bVar, cVar);
    }

    public Object a(String str, String str2, com.sumsub.sns.internal.core.data.source.applicant.remote.a aVar, c<? super e0> cVar) {
        return this.f33040a.a(str, str2, aVar, cVar);
    }
}
