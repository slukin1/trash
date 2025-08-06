package com.sumsub.sns.internal.domain;

import android.nfc.tech.IsoDep;
import com.sumsub.sns.internal.core.data.source.applicant.e;
import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.v0;

public final class h {

    /* renamed from: c  reason: collision with root package name */
    public static final a f34116c = new a((r) null);
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final String f34117d = "ReadMRTDUseCase";

    /* renamed from: a  reason: collision with root package name */
    public final e f34118a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f34119b;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            public final Exception f34120a;

            public a(Exception exc) {
                super((r) null);
                this.f34120a = exc;
            }

            public final Exception a() {
                return this.f34120a;
            }

            public final Exception b() {
                return this.f34120a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && x.b(this.f34120a, ((a) obj).f34120a);
            }

            public int hashCode() {
                return this.f34120a.hashCode();
            }

            public String toString() {
                return "Error(e=" + this.f34120a + ')';
            }

            public final a a(Exception exc) {
                return new a(exc);
            }

            public static /* synthetic */ a a(a aVar, Exception exc, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    exc = aVar.f34120a;
                }
                return aVar.a(exc);
            }
        }

        /* renamed from: com.sumsub.sns.internal.domain.h$b$b  reason: collision with other inner class name */
        public static final class C0386b extends b {

            /* renamed from: a  reason: collision with root package name */
            public static final C0386b f34121a = new C0386b();

            public C0386b() {
                super((r) null);
            }
        }

        public /* synthetic */ b(r rVar) {
            this();
        }

        public b() {
        }
    }

    public static final class c extends Exception {
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.domain.ReadMRTDUseCase$invoke$2", f = "ReadMRTDUseCase.kt", l = {36, 46}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super b>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34122a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IsoDep f34123b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f34124c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ h f34125d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f34126e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l<Integer, Unit> f34127f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f34128g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f34129h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f34130i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ String f34131j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(IsoDep isoDep, String str, h hVar, String str2, l<? super Integer, Unit> lVar, String str3, String str4, String str5, String str6, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f34123b = isoDep;
            this.f34124c = str;
            this.f34125d = hVar;
            this.f34126e = str2;
            this.f34127f = lVar;
            this.f34128g = str3;
            this.f34129h = str4;
            this.f34130i = str5;
            this.f34131j = str6;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super b> cVar) {
            return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f34123b, this.f34124c, this.f34125d, this.f34126e, this.f34127f, this.f34128g, this.f34129h, this.f34130i, this.f34131j, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x008a A[Catch:{ Exception -> 0x00ab }] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x008b A[Catch:{ Exception -> 0x00ab }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r11.f34122a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                kotlin.k.b(r12)     // Catch:{ Exception -> 0x00ab }
                goto L_0x0082
            L_0x0012:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x001a:
                kotlin.k.b(r12)     // Catch:{ Exception -> 0x00ab }
                goto L_0x0041
            L_0x001e:
                kotlin.k.b(r12)
                com.sumsub.sns.internal.nfc.e r12 = new com.sumsub.sns.internal.nfc.e     // Catch:{ Exception -> 0x00ab }
                android.nfc.tech.IsoDep r1 = r11.f34123b     // Catch:{ Exception -> 0x00ab }
                java.lang.String r4 = r11.f34124c     // Catch:{ Exception -> 0x00ab }
                byte[] r4 = com.sumsub.sns.internal.core.common.z0.a((java.lang.String) r4)     // Catch:{ Exception -> 0x00ab }
                com.sumsub.sns.internal.domain.h r5 = r11.f34125d     // Catch:{ Exception -> 0x00ab }
                java.lang.String r6 = r11.f34126e     // Catch:{ Exception -> 0x00ab }
                com.sumsub.sns.internal.nfc.b r5 = r5.a((java.lang.String) r6)     // Catch:{ Exception -> 0x00ab }
                r12.<init>(r1, r4, r5)     // Catch:{ Exception -> 0x00ab }
                d10.l<java.lang.Integer, kotlin.Unit> r1 = r11.f34127f     // Catch:{ Exception -> 0x00ab }
                r11.f34122a = r3     // Catch:{ Exception -> 0x00ab }
                java.lang.Object r12 = r12.a((d10.l<? super java.lang.Integer, kotlin.Unit>) r1, (kotlin.coroutines.c<? super com.sumsub.sns.internal.nfc.NfcResult>) r11)     // Catch:{ Exception -> 0x00ab }
                if (r12 != r0) goto L_0x0041
                return r0
            L_0x0041:
                com.sumsub.sns.internal.nfc.NfcResult r12 = (com.sumsub.sns.internal.nfc.NfcResult) r12     // Catch:{ Exception -> 0x00ab }
                java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ Exception -> 0x00ab }
                r9.<init>()     // Catch:{ Exception -> 0x00ab }
                boolean r1 = r12 instanceof com.sumsub.sns.internal.nfc.NfcResult.a     // Catch:{ Exception -> 0x00ab }
                if (r1 == 0) goto L_0x00a0
                com.sumsub.sns.internal.nfc.NfcResult$a r12 = (com.sumsub.sns.internal.nfc.NfcResult.a) r12     // Catch:{ Exception -> 0x00ab }
                java.util.List r12 = r12.b()     // Catch:{ Exception -> 0x00ab }
                java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x00ab }
            L_0x0056:
                boolean r1 = r12.hasNext()     // Catch:{ Exception -> 0x00ab }
                if (r1 == 0) goto L_0x006a
                java.lang.Object r1 = r12.next()     // Catch:{ Exception -> 0x00ab }
                byte[] r1 = (byte[]) r1     // Catch:{ Exception -> 0x00ab }
                java.lang.String r1 = android.util.Base64.encodeToString(r1, r2)     // Catch:{ Exception -> 0x00ab }
                r9.add(r1)     // Catch:{ Exception -> 0x00ab }
                goto L_0x0056
            L_0x006a:
                com.sumsub.sns.internal.domain.h r12 = r11.f34125d     // Catch:{ Exception -> 0x00ab }
                com.sumsub.sns.internal.core.data.source.applicant.e r4 = r12.f34118a     // Catch:{ Exception -> 0x00ab }
                java.lang.String r5 = r11.f34128g     // Catch:{ Exception -> 0x00ab }
                java.lang.String r6 = r11.f34129h     // Catch:{ Exception -> 0x00ab }
                java.lang.String r7 = r11.f34130i     // Catch:{ Exception -> 0x00ab }
                java.lang.String r8 = r11.f34131j     // Catch:{ Exception -> 0x00ab }
                r11.f34122a = r2     // Catch:{ Exception -> 0x00ab }
                r10 = r11
                java.lang.Object r12 = r4.a((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.util.List<java.lang.String>) r9, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.g>) r10)     // Catch:{ Exception -> 0x00ab }
                if (r12 != r0) goto L_0x0082
                return r0
            L_0x0082:
                com.sumsub.sns.internal.core.data.source.applicant.remote.g r12 = (com.sumsub.sns.internal.core.data.source.applicant.remote.g) r12     // Catch:{ Exception -> 0x00ab }
                java.lang.Integer r12 = r12.k()     // Catch:{ Exception -> 0x00ab }
                if (r12 != 0) goto L_0x008b
                goto L_0x0094
            L_0x008b:
                int r12 = r12.intValue()     // Catch:{ Exception -> 0x00ab }
                if (r12 != r3) goto L_0x0094
                com.sumsub.sns.internal.domain.h$b$b r12 = com.sumsub.sns.internal.domain.h.b.C0386b.f34121a     // Catch:{ Exception -> 0x00ab }
                goto L_0x009f
            L_0x0094:
                com.sumsub.sns.internal.domain.h$b$a r12 = new com.sumsub.sns.internal.domain.h$b$a     // Catch:{ Exception -> 0x00ab }
                com.sumsub.sns.core.data.model.SNSException$Unknown r0 = new com.sumsub.sns.core.data.model.SNSException$Unknown     // Catch:{ Exception -> 0x00ab }
                r1 = 0
                r0.<init>(r1, r3, r1)     // Catch:{ Exception -> 0x00ab }
                r12.<init>(r0)     // Catch:{ Exception -> 0x00ab }
            L_0x009f:
                return r12
            L_0x00a0:
                com.sumsub.sns.internal.domain.h$b$a r12 = new com.sumsub.sns.internal.domain.h$b$a     // Catch:{ Exception -> 0x00ab }
                com.sumsub.sns.internal.domain.h$c r0 = new com.sumsub.sns.internal.domain.h$c     // Catch:{ Exception -> 0x00ab }
                r0.<init>()     // Catch:{ Exception -> 0x00ab }
                r12.<init>(r0)     // Catch:{ Exception -> 0x00ab }
                return r12
            L_0x00ab:
                r12 = move-exception
                com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
                java.lang.String r1 = r12.getMessage()
                if (r1 != 0) goto L_0x00b6
                java.lang.String r1 = ""
            L_0x00b6:
                java.lang.String r2 = "ReadMRTDUseCase"
                r0.e(r2, r1, r12)
                com.sumsub.sns.internal.domain.h$b$a r0 = new com.sumsub.sns.internal.domain.h$b$a
                com.sumsub.sns.internal.domain.h r1 = r11.f34125d
                com.sumsub.sns.internal.core.data.source.common.a r1 = r1.f34119b
                java.lang.Exception r12 = com.sumsub.sns.internal.core.domain.base.d.a(r1, r12)
                r0.<init>(r12)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.h.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public h(e eVar, com.sumsub.sns.internal.core.data.source.common.a aVar) {
        this.f34118a = eVar;
        this.f34119b = aVar;
    }

    public final Object a(String str, String str2, String str3, IsoDep isoDep, String str4, String str5, String str6, l<? super Integer, Unit> lVar, kotlin.coroutines.c<? super b> cVar) {
        return g.g(v0.b(), new d(isoDep, str4, this, str5, lVar, str, str6, str2, str3, (kotlin.coroutines.c<? super d>) null), cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        if (r7 == null) goto L_0x000d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.sns.internal.nfc.b a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 3
            r1 = 0
            r2 = 0
            if (r7 == 0) goto L_0x000d
            com.sumsub.sns.internal.nfc.e$b r3 = com.sumsub.sns.internal.nfc.e.f35153d     // Catch:{ Exception -> 0x0025 }
            java.util.List r7 = r3.a(r7)     // Catch:{ Exception -> 0x0025 }
            if (r7 != 0) goto L_0x0011
        L_0x000d:
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.k()     // Catch:{ Exception -> 0x0025 }
        L_0x0011:
            boolean r3 = r7.isEmpty()     // Catch:{ Exception -> 0x0025 }
            r4 = 1
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x001f
            com.sumsub.sns.internal.nfc.b r3 = new com.sumsub.sns.internal.nfc.b     // Catch:{ Exception -> 0x0025 }
            r3.<init>(r1, r7, r4, r2)     // Catch:{ Exception -> 0x0025 }
            goto L_0x0034
        L_0x001f:
            com.sumsub.sns.internal.nfc.b r3 = new com.sumsub.sns.internal.nfc.b     // Catch:{ Exception -> 0x0025 }
            r3.<init>(r1, r2, r0, r2)     // Catch:{ Exception -> 0x0025 }
            goto L_0x0034
        L_0x0025:
            r7 = move-exception
            com.sumsub.sns.internal.nfc.c r3 = com.sumsub.sns.internal.nfc.c.f35142a
            java.lang.String r4 = "ReadMRTDUseCase"
            java.lang.String r5 = "Failed to parse server config"
            r3.a(r4, r5, r7)
            com.sumsub.sns.internal.nfc.b r3 = new com.sumsub.sns.internal.nfc.b
            r3.<init>(r1, r2, r0, r2)
        L_0x0034:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.h.a(java.lang.String):com.sumsub.sns.internal.nfc.b");
    }
}
