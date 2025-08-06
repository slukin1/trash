package com.sumsub.sns.internal.videoident.videoident.domain;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.source.applicant.e;
import java.io.InputStream;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f37094a;

    /* renamed from: b  reason: collision with root package name */
    public final e f37095b;

    /* renamed from: c  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f37096c;

    @d(c = "com.sumsub.sns.internal.videoident.videoident.domain.UploadFileFromStreamUseCase", f = "UploadFileFromStreamUseCase.kt", l = {29, 30, 33}, m = "invoke-hUnOzRk")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f37097a;

        /* renamed from: b  reason: collision with root package name */
        public Object f37098b;

        /* renamed from: c  reason: collision with root package name */
        public Object f37099c;

        /* renamed from: d  reason: collision with root package name */
        public Object f37100d;

        /* renamed from: e  reason: collision with root package name */
        public Object f37101e;

        /* renamed from: f  reason: collision with root package name */
        public Object f37102f;

        /* renamed from: g  reason: collision with root package name */
        public Object f37103g;

        /* renamed from: h  reason: collision with root package name */
        public /* synthetic */ Object f37104h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f37105i;

        /* renamed from: j  reason: collision with root package name */
        public int f37106j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, c<? super a> cVar) {
            super(cVar);
            this.f37105i = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f37104h = obj;
            this.f37106j |= Integer.MIN_VALUE;
            Object a11 = this.f37105i.a((DocumentType) null, (String) null, (IdentitySide) null, (String) null, (InputStream) null, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public b(com.sumsub.sns.internal.core.data.source.common.a aVar, e eVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        this.f37094a = aVar;
        this.f37095b = eVar;
        this.f37096c = bVar;
    }

    public final e a() {
        return this.f37095b;
    }

    public final com.sumsub.sns.internal.core.data.source.common.a b() {
        return this.f37094a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f1 A[SYNTHETIC, Splitter:B:42:0x00f1] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0155 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x015c A[Catch:{ Exception -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0163 A[Catch:{ Exception -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0115 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.model.DocumentType r20, java.lang.String r21, com.sumsub.sns.internal.core.data.model.IdentitySide r22, java.lang.String r23, java.io.InputStream r24, kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.core.data.model.remote.k>> r25) {
        /*
            r19 = this;
            r1 = r19
            r0 = r25
            boolean r2 = r0 instanceof com.sumsub.sns.internal.videoident.videoident.domain.b.a
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.sumsub.sns.internal.videoident.videoident.domain.b$a r2 = (com.sumsub.sns.internal.videoident.videoident.domain.b.a) r2
            int r3 = r2.f37106j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f37106j = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.videoident.videoident.domain.b$a r2 = new com.sumsub.sns.internal.videoident.videoident.domain.b$a
            r2.<init>(r1, r0)
        L_0x001c:
            r11 = r2
            java.lang.Object r0 = r11.f37104h
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r11.f37106j
            r9 = 3
            r10 = 2
            r14 = 1
            r15 = 0
            if (r3 == 0) goto L_0x0092
            if (r3 == r14) goto L_0x006d
            if (r3 == r10) goto L_0x0045
            if (r3 != r9) goto L_0x003d
            java.lang.Object r2 = r11.f37097a
            com.sumsub.sns.internal.videoident.videoident.domain.b r2 = (com.sumsub.sns.internal.videoident.videoident.domain.b) r2
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x003a }
            goto L_0x0158
        L_0x003a:
            r0 = move-exception
            goto L_0x017d
        L_0x003d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0045:
            java.lang.Object r3 = r11.f37103g
            com.sumsub.sns.internal.core.data.model.g r3 = (com.sumsub.sns.internal.core.data.model.g) r3
            java.lang.Object r4 = r11.f37102f
            java.io.InputStream r4 = (java.io.InputStream) r4
            java.lang.Object r5 = r11.f37101e
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r11.f37100d
            com.sumsub.sns.internal.core.data.model.IdentitySide r6 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r6
            java.lang.Object r7 = r11.f37099c
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r11.f37098b
            com.sumsub.sns.internal.core.data.model.DocumentType r8 = (com.sumsub.sns.internal.core.data.model.DocumentType) r8
            java.lang.Object r10 = r11.f37097a
            com.sumsub.sns.internal.videoident.videoident.domain.b r10 = (com.sumsub.sns.internal.videoident.videoident.domain.b) r10
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x006a }
            r13 = r10
            r10 = r8
            r8 = r6
            r6 = r4
            goto L_0x00e3
        L_0x006a:
            r0 = move-exception
            goto L_0x017e
        L_0x006d:
            java.lang.Object r3 = r11.f37102f
            java.io.InputStream r3 = (java.io.InputStream) r3
            java.lang.Object r4 = r11.f37101e
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r11.f37100d
            com.sumsub.sns.internal.core.data.model.IdentitySide r5 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r5
            java.lang.Object r6 = r11.f37099c
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r11.f37098b
            com.sumsub.sns.internal.core.data.model.DocumentType r7 = (com.sumsub.sns.internal.core.data.model.DocumentType) r7
            java.lang.Object r8 = r11.f37097a
            com.sumsub.sns.internal.videoident.videoident.domain.b r8 = (com.sumsub.sns.internal.videoident.videoident.domain.b) r8
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x008e }
            r9 = r3
            r13 = r5
            r12 = r6
            r3 = r0
            r0 = r7
            goto L_0x00be
        L_0x008e:
            r0 = move-exception
            r2 = r8
            goto L_0x017d
        L_0x0092:
            kotlin.k.b(r0)
            com.sumsub.sns.internal.core.data.source.dynamic.b r3 = r1.f37096c     // Catch:{ Exception -> 0x017b }
            r4 = 0
            r5 = 0
            r7 = 3
            r8 = 0
            r11.f37097a = r1     // Catch:{ Exception -> 0x017b }
            r0 = r20
            r11.f37098b = r0     // Catch:{ Exception -> 0x017b }
            r12 = r21
            r11.f37099c = r12     // Catch:{ Exception -> 0x017b }
            r13 = r22
            r11.f37100d = r13     // Catch:{ Exception -> 0x017b }
            r6 = r23
            r11.f37101e = r6     // Catch:{ Exception -> 0x017b }
            r9 = r24
            r11.f37102f = r9     // Catch:{ Exception -> 0x017b }
            r11.f37106j = r14     // Catch:{ Exception -> 0x017b }
            r6 = r11
            java.lang.Object r3 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x017b }
            if (r3 != r2) goto L_0x00bb
            return r2
        L_0x00bb:
            r4 = r23
            r8 = r1
        L_0x00be:
            com.sumsub.sns.internal.core.data.model.g r3 = (com.sumsub.sns.internal.core.data.model.g) r3     // Catch:{ Exception -> 0x008e }
            com.sumsub.sns.internal.core.data.source.dynamic.b r5 = r8.f37096c     // Catch:{ Exception -> 0x008e }
            r11.f37097a = r8     // Catch:{ Exception -> 0x008e }
            r11.f37098b = r0     // Catch:{ Exception -> 0x008e }
            r11.f37099c = r12     // Catch:{ Exception -> 0x008e }
            r11.f37100d = r13     // Catch:{ Exception -> 0x008e }
            r11.f37101e = r4     // Catch:{ Exception -> 0x008e }
            r11.f37102f = r9     // Catch:{ Exception -> 0x008e }
            r11.f37103g = r3     // Catch:{ Exception -> 0x008e }
            r11.f37106j = r10     // Catch:{ Exception -> 0x008e }
            java.lang.Object r5 = r5.c((boolean) r14, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.t>>) r11)     // Catch:{ Exception -> 0x008e }
            if (r5 != r2) goto L_0x00d9
            return r2
        L_0x00d9:
            r10 = r0
            r0 = r5
            r6 = r9
            r7 = r12
            r5 = r4
            r18 = r13
            r13 = r8
            r8 = r18
        L_0x00e3:
            com.sumsub.sns.internal.core.data.source.dynamic.e r0 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r0     // Catch:{ Exception -> 0x0175 }
            java.lang.Object r0 = r0.e()     // Catch:{ Exception -> 0x0175 }
            com.sumsub.sns.internal.core.data.model.t r0 = (com.sumsub.sns.internal.core.data.model.t) r0     // Catch:{ Exception -> 0x0175 }
            java.util.List r0 = r0.d()     // Catch:{ Exception -> 0x0175 }
            if (r5 != 0) goto L_0x012e
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x012b }
        L_0x00f5:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x012b }
            if (r4 == 0) goto L_0x0116
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x012b }
            r5 = r4
            com.sumsub.sns.internal.core.data.model.Document r5 = (com.sumsub.sns.internal.core.data.model.Document) r5     // Catch:{ Exception -> 0x012b }
            java.lang.String r5 = r5.getCountry()     // Catch:{ Exception -> 0x012b }
            if (r5 == 0) goto L_0x0111
            int r5 = r5.length()     // Catch:{ Exception -> 0x012b }
            if (r5 != 0) goto L_0x010f
            goto L_0x0111
        L_0x010f:
            r5 = 0
            goto L_0x0112
        L_0x0111:
            r5 = r14
        L_0x0112:
            r5 = r5 ^ r14
            if (r5 == 0) goto L_0x00f5
            goto L_0x0117
        L_0x0116:
            r4 = r15
        L_0x0117:
            com.sumsub.sns.internal.core.data.model.Document r4 = (com.sumsub.sns.internal.core.data.model.Document) r4     // Catch:{ Exception -> 0x012b }
            if (r4 == 0) goto L_0x0121
            java.lang.String r0 = r4.getCountry()     // Catch:{ Exception -> 0x012b }
            if (r0 != 0) goto L_0x0129
        L_0x0121:
            java.lang.String r0 = r3.u()     // Catch:{ Exception -> 0x012b }
            if (r0 != 0) goto L_0x0129
            java.lang.String r0 = "ATA"
        L_0x0129:
            r5 = r0
            goto L_0x012e
        L_0x012b:
            r0 = move-exception
            r2 = r13
            goto L_0x017d
        L_0x012e:
            com.sumsub.sns.internal.core.data.source.applicant.e r0 = r13.f37095b     // Catch:{ Exception -> 0x0175 }
            java.lang.String r4 = r3.B()     // Catch:{ Exception -> 0x0175 }
            r9 = 0
            r12 = 32
            r16 = 0
            r11.f37097a = r13     // Catch:{ Exception -> 0x0175 }
            r11.f37098b = r15     // Catch:{ Exception -> 0x0175 }
            r11.f37099c = r15     // Catch:{ Exception -> 0x0175 }
            r11.f37100d = r15     // Catch:{ Exception -> 0x0175 }
            r11.f37101e = r15     // Catch:{ Exception -> 0x0175 }
            r11.f37102f = r15     // Catch:{ Exception -> 0x0175 }
            r11.f37103g = r15     // Catch:{ Exception -> 0x0175 }
            r3 = 3
            r11.f37106j = r3     // Catch:{ Exception -> 0x0175 }
            r3 = r0
            r17 = r13
            r13 = r16
            java.lang.Object r0 = com.sumsub.sns.internal.core.data.source.applicant.i.b(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x0173 }
            if (r0 != r2) goto L_0x0156
            return r2
        L_0x0156:
            r2 = r17
        L_0x0158:
            com.sumsub.sns.internal.core.data.model.remote.k r0 = (com.sumsub.sns.internal.core.data.model.remote.k) r0     // Catch:{ Exception -> 0x003a }
            if (r0 == 0) goto L_0x0163
            kotlin.Result$a r3 = kotlin.Result.Companion     // Catch:{ Exception -> 0x003a }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ Exception -> 0x003a }
            return r0
        L_0x0163:
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ Exception -> 0x003a }
            com.sumsub.sns.core.data.model.SNSException$Unknown r0 = new com.sumsub.sns.core.data.model.SNSException$Unknown     // Catch:{ Exception -> 0x003a }
            r0.<init>(r15, r14, r15)     // Catch:{ Exception -> 0x003a }
            java.lang.Object r0 = kotlin.k.a(r0)     // Catch:{ Exception -> 0x003a }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ Exception -> 0x003a }
            return r0
        L_0x0173:
            r0 = move-exception
            goto L_0x0178
        L_0x0175:
            r0 = move-exception
            r17 = r13
        L_0x0178:
            r2 = r17
            goto L_0x017d
        L_0x017b:
            r0 = move-exception
            r2 = r1
        L_0x017d:
            r10 = r2
        L_0x017e:
            kotlin.Result$a r2 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r2 = r10.f37094a
            java.lang.Exception r0 = com.sumsub.sns.internal.core.domain.base.d.a(r2, r0)
            java.lang.Object r0 = kotlin.k.a(r0)
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.videoident.domain.b.a(com.sumsub.sns.internal.core.data.model.DocumentType, java.lang.String, com.sumsub.sns.internal.core.data.model.IdentitySide, java.lang.String, java.io.InputStream, kotlin.coroutines.c):java.lang.Object");
    }
}
