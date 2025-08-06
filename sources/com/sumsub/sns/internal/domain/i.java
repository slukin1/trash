package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.source.applicant.e;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import com.sumsub.sns.internal.core.data.source.applicant.remote.y;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.x;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final e f34132a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f34133b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final w f34134a;

        /* renamed from: b  reason: collision with root package name */
        public final y f34135b;

        public a(w wVar, y yVar) {
            this.f34134a = wVar;
            this.f34135b = yVar;
        }

        public final w a() {
            return this.f34134a;
        }

        public final y b() {
            return this.f34135b;
        }

        public final w c() {
            return this.f34134a;
        }

        public final y d() {
            return this.f34135b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f34134a, aVar.f34134a) && x.b(this.f34135b, aVar.f34135b);
        }

        public int hashCode() {
            int hashCode = this.f34134a.hashCode() * 31;
            y yVar = this.f34135b;
            return hashCode + (yVar == null ? 0 : yVar.hashCode());
        }

        public String toString() {
            return "QuestionnaireInfo(questionnaireResponse=" + this.f34134a + ", questionnaireSubmitModel=" + this.f34135b + ')';
        }

        public final a a(w wVar, y yVar) {
            return new a(wVar, yVar);
        }

        public static /* synthetic */ a a(a aVar, w wVar, y yVar, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                wVar = aVar.f34134a;
            }
            if ((i11 & 2) != 0) {
                yVar = aVar.f34135b;
            }
            return aVar.a(wVar, yVar);
        }
    }

    @d(c = "com.sumsub.sns.internal.domain.RequestQuestionnaireUseCase", f = "RequestQuestionnaireUseCase.kt", l = {25, 27}, m = "invoke-gIAlu-s")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34136a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34137b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f34138c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f34139d;

        /* renamed from: e  reason: collision with root package name */
        public int f34140e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(i iVar, c<? super b> cVar) {
            super(cVar);
            this.f34139d = iVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34138c = obj;
            this.f34140e |= Integer.MIN_VALUE;
            Object a11 = this.f34139d.a((String) null, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public i(e eVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        this.f34132a = eVar;
        this.f34133b = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071 A[Catch:{ Exception -> 0x008c }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072 A[Catch:{ Exception -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r7, kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.domain.i.a>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.domain.i.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.domain.i$b r0 = (com.sumsub.sns.internal.domain.i.b) r0
            int r1 = r0.f34140e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34140e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.domain.i$b r0 = new com.sumsub.sns.internal.domain.i$b
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f34138c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34140e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0048
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r7 = r0.f34137b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r0 = r0.f34136a
            com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0
            kotlin.k.b(r8)     // Catch:{ Exception -> 0x008c }
            goto L_0x0075
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            java.lang.Object r7 = r0.f34137b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r2 = r0.f34136a
            com.sumsub.sns.internal.domain.i r2 = (com.sumsub.sns.internal.domain.i) r2
            kotlin.k.b(r8)     // Catch:{ Exception -> 0x008c }
            goto L_0x005d
        L_0x0048:
            kotlin.k.b(r8)
            com.sumsub.sns.internal.core.data.source.dynamic.b r8 = r6.f34133b     // Catch:{ Exception -> 0x008c }
            r2 = 0
            r5 = 0
            r0.f34136a = r6     // Catch:{ Exception -> 0x008c }
            r0.f34137b = r7     // Catch:{ Exception -> 0x008c }
            r0.f34140e = r4     // Catch:{ Exception -> 0x008c }
            java.lang.Object r8 = com.sumsub.sns.internal.core.data.source.dynamic.h.d(r8, r2, r0, r4, r5)     // Catch:{ Exception -> 0x008c }
            if (r8 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r2 = r6
        L_0x005d:
            com.sumsub.sns.internal.core.data.model.g r8 = (com.sumsub.sns.internal.core.data.model.g) r8     // Catch:{ Exception -> 0x008c }
            java.lang.String r4 = r8.B()     // Catch:{ Exception -> 0x008c }
            com.sumsub.sns.internal.core.data.source.applicant.e r2 = r2.f34132a     // Catch:{ Exception -> 0x008c }
            r0.f34136a = r8     // Catch:{ Exception -> 0x008c }
            r0.f34137b = r4     // Catch:{ Exception -> 0x008c }
            r0.f34140e = r3     // Catch:{ Exception -> 0x008c }
            java.lang.Object r7 = r2.g(r7, r0)     // Catch:{ Exception -> 0x008c }
            if (r7 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r0 = r8
            r8 = r7
            r7 = r4
        L_0x0075:
            com.sumsub.sns.internal.core.data.source.applicant.remote.w r8 = (com.sumsub.sns.internal.core.data.source.applicant.remote.w) r8     // Catch:{ Exception -> 0x008c }
            kotlin.Result$a r1 = kotlin.Result.Companion     // Catch:{ Exception -> 0x008c }
            com.sumsub.sns.internal.domain.i$a r1 = new com.sumsub.sns.internal.domain.i$a     // Catch:{ Exception -> 0x008c }
            com.sumsub.sns.internal.core.data.source.applicant.remote.y r2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.y     // Catch:{ Exception -> 0x008c }
            java.util.List r0 = r0.H()     // Catch:{ Exception -> 0x008c }
            r2.<init>(r7, r0)     // Catch:{ Exception -> 0x008c }
            r1.<init>(r8, r2)     // Catch:{ Exception -> 0x008c }
            java.lang.Object r7 = kotlin.Result.m3072constructorimpl(r1)     // Catch:{ Exception -> 0x008c }
            goto L_0x0097
        L_0x008c:
            r7 = move-exception
            kotlin.Result$a r8 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.k.a(r7)
            java.lang.Object r7 = kotlin.Result.m3072constructorimpl(r7)
        L_0x0097:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.i.a(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public i(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.h(), aVar.p());
    }
}
