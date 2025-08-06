package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.source.applicant.b;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f34071a;

    /* renamed from: b  reason: collision with root package name */
    public final b f34072b;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.domain.DeleteDocumentImagesUseCase", f = "DeleteDocumentImagesUseCase.kt", l = {17}, m = "invoke-gIAlu-s")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34073a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34074b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34075c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34076d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f34077e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d f34078f;

        /* renamed from: g  reason: collision with root package name */
        public int f34079g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, c<? super a> cVar) {
            super(cVar);
            this.f34078f = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34077e = obj;
            this.f34079g |= Integer.MIN_VALUE;
            Object a11 = this.f34078f.a((List<String>) null, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public d(com.sumsub.sns.internal.core.data.source.common.a aVar, b bVar) {
        this.f34071a = aVar;
        this.f34072b = bVar;
    }

    public final b a() {
        return this.f34072b;
    }

    public final com.sumsub.sns.internal.core.data.source.common.a b() {
        return this.f34071a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0058 A[Catch:{ Exception -> 0x0083 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.List<java.lang.String> r8, kotlin.coroutines.c<? super kotlin.Result<? extends java.util.List<java.lang.String>>> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.domain.d.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.domain.d$a r0 = (com.sumsub.sns.internal.domain.d.a) r0
            int r1 = r0.f34079g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34079g = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.domain.d$a r0 = new com.sumsub.sns.internal.domain.d$a
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f34077e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34079g
            r3 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r8 = r0.f34076d
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.f34075c
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r4 = r0.f34074b
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r0.f34073a
            com.sumsub.sns.internal.domain.d r5 = (com.sumsub.sns.internal.domain.d) r5
            kotlin.k.b(r9)     // Catch:{ Exception -> 0x0039 }
            goto L_0x0077
        L_0x0039:
            r8 = move-exception
            goto L_0x0089
        L_0x003b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0043:
            kotlin.k.b(r9)
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x0087 }
            r9.<init>()     // Catch:{ Exception -> 0x0087 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ Exception -> 0x0087 }
            r2 = r8
            r4 = r9
            r8 = r7
        L_0x0052:
            boolean r9 = r2.hasNext()     // Catch:{ Exception -> 0x0083 }
            if (r9 == 0) goto L_0x007c
            java.lang.Object r9 = r2.next()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0083 }
            com.sumsub.sns.internal.core.data.source.applicant.b r5 = r8.f34072b     // Catch:{ Exception -> 0x0083 }
            int r6 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x0083 }
            r0.f34073a = r8     // Catch:{ Exception -> 0x0083 }
            r0.f34074b = r4     // Catch:{ Exception -> 0x0083 }
            r0.f34075c = r2     // Catch:{ Exception -> 0x0083 }
            r0.f34076d = r9     // Catch:{ Exception -> 0x0083 }
            r0.f34079g = r3     // Catch:{ Exception -> 0x0083 }
            java.lang.Object r5 = r5.a((int) r6, (kotlin.coroutines.c<? super kotlin.Unit>) r0)     // Catch:{ Exception -> 0x0083 }
            if (r5 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r5 = r8
            r8 = r9
        L_0x0077:
            r4.add(r8)     // Catch:{ Exception -> 0x0039 }
            r8 = r5
            goto L_0x0052
        L_0x007c:
            kotlin.Result$a r9 = kotlin.Result.Companion     // Catch:{ Exception -> 0x0083 }
            java.lang.Object r8 = kotlin.Result.m3072constructorimpl(r4)     // Catch:{ Exception -> 0x0083 }
            return r8
        L_0x0083:
            r9 = move-exception
            r5 = r8
            r8 = r9
            goto L_0x0089
        L_0x0087:
            r8 = move-exception
            r5 = r7
        L_0x0089:
            kotlin.Result$a r9 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r9 = r5.f34071a
            java.lang.Exception r8 = com.sumsub.sns.internal.core.domain.base.d.a(r9, r8)
            java.lang.Object r8 = kotlin.k.a(r8)
            java.lang.Object r8 = kotlin.Result.m3072constructorimpl(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.d.a(java.util.List, kotlin.coroutines.c):java.lang.Object");
    }
}
