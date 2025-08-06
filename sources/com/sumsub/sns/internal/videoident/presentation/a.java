package com.sumsub.sns.internal.videoident.presentation;

import android.os.Build;
import android.os.Bundle;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.source.applicant.remote.n;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import d10.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class a extends com.sumsub.sns.core.presentation.base.a<c> {

    /* renamed from: s  reason: collision with root package name */
    public static final C0499a f36644s = new C0499a((r) null);

    /* renamed from: t  reason: collision with root package name */
    public static final String f36645t = "languages";

    /* renamed from: u  reason: collision with root package name */
    public static final String f36646u = "lang";

    /* renamed from: v  reason: collision with root package name */
    public static final String f36647v = "sns_videoident_langSelector_title";

    /* renamed from: w  reason: collision with root package name */
    public static final String f36648w = "sns_videoident_langSelector_waitTime_prefix";

    /* renamed from: x  reason: collision with root package name */
    public static final String f36649x = "sns_videoident_langSelector_waitTime_text";

    /* renamed from: q  reason: collision with root package name */
    public final Bundle f36650q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f36651r;

    /* renamed from: com.sumsub.sns.internal.videoident.presentation.a$a  reason: collision with other inner class name */
    public static final class C0499a {
        public /* synthetic */ C0499a(r rVar) {
            this();
        }

        public C0499a() {
        }
    }

    public static final class b implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f36652a;

        /* renamed from: b  reason: collision with root package name */
        public final long f36653b;

        public b(String str, long j11) {
            this.f36652a = str;
            this.f36653b = j11;
        }

        public final String a() {
            return this.f36652a;
        }

        public final long b() {
            return this.f36653b;
        }

        public final String c() {
            return this.f36652a;
        }

        public final long d() {
            return this.f36653b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return x.b(this.f36652a, bVar.f36652a) && this.f36653b == bVar.f36653b;
        }

        public int hashCode() {
            return (this.f36652a.hashCode() * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f36653b);
        }

        public String toString() {
            return "FinishWithLanguage(language=" + this.f36652a + ", waitTimeSec=" + this.f36653b + ')';
        }

        public final b a(String str, long j11) {
            return new b(str, j11);
        }

        public static /* synthetic */ b a(b bVar, String str, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = bVar.f36652a;
            }
            if ((i11 & 2) != 0) {
                j11 = bVar.f36653b;
            }
            return bVar.a(str, j11);
        }
    }

    public static final class c extends SNSViewState {

        /* renamed from: a  reason: collision with root package name */
        public final String f36654a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f36655b;

        /* renamed from: com.sumsub.sns.internal.videoident.presentation.a$c$a  reason: collision with other inner class name */
        public static final class C0500a {

            /* renamed from: a  reason: collision with root package name */
            public final boolean f36656a;

            /* renamed from: b  reason: collision with root package name */
            public final String f36657b;

            public C0500a(boolean z11, String str) {
                this.f36656a = z11;
                this.f36657b = str;
            }

            public final boolean a() {
                return this.f36656a;
            }

            public final String b() {
                return this.f36657b;
            }

            public final boolean c() {
                return this.f36656a;
            }

            public final String d() {
                return this.f36657b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0500a)) {
                    return false;
                }
                C0500a aVar = (C0500a) obj;
                return this.f36656a == aVar.f36656a && x.b(this.f36657b, aVar.f36657b);
            }

            public int hashCode() {
                boolean z11 = this.f36656a;
                if (z11) {
                    z11 = true;
                }
                int i11 = (z11 ? 1 : 0) * true;
                String str = this.f36657b;
                return i11 + (str == null ? 0 : str.hashCode());
            }

            public String toString() {
                return "ButtonState(enabled=" + this.f36656a + ", text=" + this.f36657b + ')';
            }

            public final C0500a a(boolean z11, String str) {
                return new C0500a(z11, str);
            }

            public static /* synthetic */ C0500a a(C0500a aVar, boolean z11, String str, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    z11 = aVar.f36656a;
                }
                if ((i11 & 2) != 0) {
                    str = aVar.f36657b;
                }
                return aVar.a(z11, str);
            }
        }

        public static final class b {

            /* renamed from: a  reason: collision with root package name */
            public final String f36658a;

            /* renamed from: b  reason: collision with root package name */
            public final String f36659b;

            /* renamed from: c  reason: collision with root package name */
            public final String f36660c;

            /* renamed from: d  reason: collision with root package name */
            public final String f36661d;

            /* renamed from: e  reason: collision with root package name */
            public final Boolean f36662e;

            /* renamed from: f  reason: collision with root package name */
            public final long f36663f;

            public b(String str, String str2, String str3, String str4, Boolean bool, long j11) {
                this.f36658a = str;
                this.f36659b = str2;
                this.f36660c = str3;
                this.f36661d = str4;
                this.f36662e = bool;
                this.f36663f = j11;
            }

            public final String a() {
                return this.f36658a;
            }

            public final String b() {
                return this.f36659b;
            }

            public final String c() {
                return this.f36660c;
            }

            public final String d() {
                return this.f36661d;
            }

            public final Boolean e() {
                return this.f36662e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return x.b(this.f36658a, bVar.f36658a) && x.b(this.f36659b, bVar.f36659b) && x.b(this.f36660c, bVar.f36660c) && x.b(this.f36661d, bVar.f36661d) && x.b(this.f36662e, bVar.f36662e) && this.f36663f == bVar.f36663f;
            }

            public final long f() {
                return this.f36663f;
            }

            public final String g() {
                return this.f36658a;
            }

            public final Boolean h() {
                return this.f36662e;
            }

            public int hashCode() {
                String str = this.f36658a;
                int i11 = 0;
                int hashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f36659b;
                int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f36660c;
                int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f36661d;
                int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                Boolean bool = this.f36662e;
                if (bool != null) {
                    i11 = bool.hashCode();
                }
                return ((hashCode4 + i11) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f36663f);
            }

            public final String i() {
                return this.f36660c;
            }

            public final String j() {
                return this.f36661d;
            }

            public final String k() {
                return this.f36659b;
            }

            public final long l() {
                return this.f36663f;
            }

            public String toString() {
                return "Language(id=" + this.f36658a + ", title=" + this.f36659b + ", status=" + this.f36660c + ", time=" + this.f36661d + ", selected=" + this.f36662e + ", waitTimeSec=" + this.f36663f + ')';
            }

            public final b a(String str, String str2, String str3, String str4, Boolean bool, long j11) {
                return new b(str, str2, str3, str4, bool, j11);
            }

            public static /* synthetic */ b a(b bVar, String str, String str2, String str3, String str4, Boolean bool, long j11, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    str = bVar.f36658a;
                }
                if ((i11 & 2) != 0) {
                    str2 = bVar.f36659b;
                }
                String str5 = str2;
                if ((i11 & 4) != 0) {
                    str3 = bVar.f36660c;
                }
                String str6 = str3;
                if ((i11 & 8) != 0) {
                    str4 = bVar.f36661d;
                }
                String str7 = str4;
                if ((i11 & 16) != 0) {
                    bool = bVar.f36662e;
                }
                Boolean bool2 = bool;
                if ((i11 & 32) != 0) {
                    j11 = bVar.f36663f;
                }
                return bVar.a(str, str5, str6, str7, bool2, j11);
            }
        }

        public c(String str, List<b> list) {
            super((r) null);
            this.f36654a = str;
            this.f36655b = list;
        }

        public final String a() {
            return this.f36654a;
        }

        public final List<b> b() {
            return this.f36655b;
        }

        public final List<b> c() {
            return this.f36655b;
        }

        public final String d() {
            return this.f36654a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return x.b(this.f36654a, cVar.f36654a) && x.b(this.f36655b, cVar.f36655b);
        }

        public int hashCode() {
            String str = this.f36654a;
            return ((str == null ? 0 : str.hashCode()) * 31) + this.f36655b.hashCode();
        }

        public String toString() {
            return "ViewState(title=" + this.f36654a + ", languages=" + this.f36655b + ')';
        }

        public final c a(String str, List<b> list) {
            return new c(str, list);
        }

        public static /* synthetic */ c a(c cVar, String str, List<b> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = cVar.f36654a;
            }
            if ((i11 & 2) != 0) {
                list = cVar.f36655b;
            }
            return cVar.a(str, list);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.presentation.LanguageSelectionViewModel$updateViewState$1", f = "LanguageSelectionViewModel.kt", l = {51, 53, 59, 60}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<c, kotlin.coroutines.c<? super c>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36664a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36665b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36666c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36667d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36668e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36669f;

        /* renamed from: g  reason: collision with root package name */
        public Object f36670g;

        /* renamed from: h  reason: collision with root package name */
        public Object f36671h;

        /* renamed from: i  reason: collision with root package name */
        public Object f36672i;

        /* renamed from: j  reason: collision with root package name */
        public Object f36673j;

        /* renamed from: k  reason: collision with root package name */
        public Object f36674k;

        /* renamed from: l  reason: collision with root package name */
        public long f36675l;

        /* renamed from: m  reason: collision with root package name */
        public int f36676m;

        /* renamed from: n  reason: collision with root package name */
        public /* synthetic */ Object f36677n;

        /* renamed from: o  reason: collision with root package name */
        public final /* synthetic */ a f36678o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f36678o = aVar;
        }

        /* renamed from: a */
        public final Object invoke(c cVar, kotlin.coroutines.c<? super c> cVar2) {
            return ((d) create(cVar, cVar2)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            d dVar = new d(this.f36678o, cVar);
            dVar.f36677n = obj;
            return dVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x0147  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x01d9  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x01f1  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x01ff  */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0214  */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0219  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x022c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r29) {
            /*
                r28 = this;
                r0 = r28
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f36676m
                r5 = 4
                r6 = 3
                r7 = 2
                r9 = 1
                if (r2 == 0) goto L_0x00d6
                if (r2 == r9) goto L_0x00c3
                if (r2 == r7) goto L_0x00b1
                if (r2 == r6) goto L_0x0067
                if (r2 != r5) goto L_0x005f
                long r10 = r0.f36675l
                java.lang.Object r2 = r0.f36674k
                java.util.Collection r2 = (java.util.Collection) r2
                java.lang.Object r7 = r0.f36673j
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r12 = r0.f36672i
                com.sumsub.sns.internal.videoident.presentation.a$c r12 = (com.sumsub.sns.internal.videoident.presentation.a.c) r12
                java.lang.Object r13 = r0.f36671h
                java.lang.String r13 = (java.lang.String) r13
                java.lang.Object r14 = r0.f36670g
                java.lang.String r14 = (java.lang.String) r14
                java.lang.Object r15 = r0.f36669f
                java.lang.String r15 = (java.lang.String) r15
                java.lang.Object r3 = r0.f36668e
                com.sumsub.sns.internal.core.data.source.applicant.remote.n r3 = (com.sumsub.sns.internal.core.data.source.applicant.remote.n) r3
                java.lang.Object r4 = r0.f36667d
                java.util.Iterator r4 = (java.util.Iterator) r4
                java.lang.Object r5 = r0.f36666c
                java.util.Collection r5 = (java.util.Collection) r5
                java.lang.Object r6 = r0.f36665b
                com.sumsub.sns.internal.videoident.presentation.a r6 = (com.sumsub.sns.internal.videoident.presentation.a) r6
                java.lang.Object r9 = r0.f36664a
                java.util.Map r9 = (java.util.Map) r9
                java.lang.Object r8 = r0.f36677n
                java.lang.String r8 = (java.lang.String) r8
                kotlin.k.b(r29)
                r19 = r13
                r17 = r14
                r18 = r15
                r13 = r10
                r10 = r0
                r0 = r29
                r24 = r6
                r6 = r4
                r4 = r8
                r8 = r5
                r5 = r7
                r7 = r24
                goto L_0x01ed
            L_0x005f:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0067:
                long r2 = r0.f36675l
                java.lang.Object r4 = r0.f36673j
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r5 = r0.f36672i
                java.lang.String r5 = (java.lang.String) r5
                java.lang.Object r6 = r0.f36671h
                com.sumsub.sns.internal.videoident.presentation.a$c r6 = (com.sumsub.sns.internal.videoident.presentation.a.c) r6
                java.lang.Object r7 = r0.f36670g
                java.lang.String r7 = (java.lang.String) r7
                java.lang.Object r8 = r0.f36669f
                java.lang.String r8 = (java.lang.String) r8
                java.lang.Object r9 = r0.f36668e
                com.sumsub.sns.internal.core.data.source.applicant.remote.n r9 = (com.sumsub.sns.internal.core.data.source.applicant.remote.n) r9
                java.lang.Object r10 = r0.f36667d
                java.util.Iterator r10 = (java.util.Iterator) r10
                java.lang.Object r11 = r0.f36666c
                java.util.Collection r11 = (java.util.Collection) r11
                java.lang.Object r12 = r0.f36665b
                com.sumsub.sns.internal.videoident.presentation.a r12 = (com.sumsub.sns.internal.videoident.presentation.a) r12
                java.lang.Object r13 = r0.f36664a
                java.util.Map r13 = (java.util.Map) r13
                java.lang.Object r14 = r0.f36677n
                java.lang.String r14 = (java.lang.String) r14
                kotlin.k.b(r29)
                r15 = r29
                r24 = r9
                r9 = r0
                r0 = r8
                r8 = r14
                r14 = r7
                r7 = r5
                r5 = r11
                r25 = r2
                r2 = r4
                r3 = r24
                r4 = r10
                r10 = r25
                r27 = r12
                r12 = r6
                r6 = r27
                goto L_0x01af
            L_0x00b1:
                java.lang.Object r2 = r0.f36665b
                com.sumsub.sns.internal.videoident.presentation.a$c r2 = (com.sumsub.sns.internal.videoident.presentation.a.c) r2
                java.lang.Object r3 = r0.f36664a
                java.util.Map r3 = (java.util.Map) r3
                java.lang.Object r4 = r0.f36677n
                java.lang.String r4 = (java.lang.String) r4
                kotlin.k.b(r29)
                r5 = r29
                goto L_0x0127
            L_0x00c3:
                java.lang.Object r2 = r0.f36664a
                java.lang.String r2 = (java.lang.String) r2
                java.lang.Object r3 = r0.f36677n
                com.sumsub.sns.internal.videoident.presentation.a$c r3 = (com.sumsub.sns.internal.videoident.presentation.a.c) r3
                kotlin.k.b(r29)
                r4 = r29
                r24 = r3
                r3 = r2
                r2 = r24
                goto L_0x0109
            L_0x00d6:
                kotlin.k.b(r29)
                java.lang.Object r2 = r0.f36677n
                com.sumsub.sns.internal.videoident.presentation.a$c r2 = (com.sumsub.sns.internal.videoident.presentation.a.c) r2
                com.sumsub.sns.internal.videoident.presentation.a r3 = r0.f36678o
                java.lang.String r3 = r3.s()
                if (r3 != 0) goto L_0x00f3
                com.sumsub.sns.internal.videoident.presentation.a r3 = r0.f36678o
                android.os.Bundle r3 = r3.p()
                java.lang.String r4 = "lang"
                r5 = 0
                java.lang.String r3 = r3.getString(r4, r5)
                goto L_0x00f4
            L_0x00f3:
                r5 = 0
            L_0x00f4:
                com.sumsub.sns.internal.videoident.presentation.a r4 = r0.f36678o
                com.sumsub.sns.internal.core.data.source.dynamic.b r4 = r4.f36651r
                r0.f36677n = r2
                r0.f36664a = r3
                r6 = 1
                r0.f36676m = r6
                r8 = 0
                java.lang.Object r4 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r4, r8, r0, r6, r5)
                if (r4 != r1) goto L_0x0109
                return r1
            L_0x0109:
                com.sumsub.sns.internal.core.data.model.e r4 = (com.sumsub.sns.internal.core.data.model.e) r4
                java.util.Map r4 = com.sumsub.sns.internal.core.data.model.f.l(r4)
                com.sumsub.sns.internal.videoident.presentation.a r5 = r0.f36678o
                r0.f36677n = r3
                r0.f36664a = r4
                r0.f36665b = r2
                r0.f36676m = r7
                java.lang.String r6 = "sns_videoident_langSelector_title"
                java.lang.Object r5 = r5.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r5 != r1) goto L_0x0122
                return r1
            L_0x0122:
                r24 = r4
                r4 = r3
                r3 = r24
            L_0x0127:
                java.lang.String r5 = (java.lang.String) r5
                com.sumsub.sns.internal.videoident.presentation.a r6 = r0.f36678o
                java.util.List r6 = r6.q()
                com.sumsub.sns.internal.videoident.presentation.a r7 = r0.f36678o
                java.util.ArrayList r8 = new java.util.ArrayList
                r9 = 10
                int r9 = kotlin.collections.CollectionsKt__IterablesKt.u(r6, r9)
                r8.<init>(r9)
                java.util.Iterator r6 = r6.iterator()
                r9 = r0
            L_0x0141:
                boolean r10 = r6.hasNext()
                if (r10 == 0) goto L_0x022c
                java.lang.Object r10 = r6.next()
                com.sumsub.sns.internal.core.data.source.applicant.remote.n r10 = (com.sumsub.sns.internal.core.data.source.applicant.remote.n) r10
                java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.SECONDS
                java.lang.Long r12 = r10.h()
                if (r12 == 0) goto L_0x015a
                long r12 = r12.longValue()
                goto L_0x015c
            L_0x015a:
                r12 = 0
            L_0x015c:
                long r11 = r11.toMinutes(r12)
                r13 = 1
                long r11 = kotlin.ranges.RangesKt___RangesKt.e(r11, r13)
                java.lang.String r13 = r10.d()
                if (r3 == 0) goto L_0x0178
                java.lang.String r14 = r10.d()
                java.lang.Object r14 = r3.get(r14)
                java.lang.String r14 = (java.lang.String) r14
                if (r14 != 0) goto L_0x017c
            L_0x0178:
                java.lang.String r14 = r10.d()
            L_0x017c:
                r9.f36677n = r4
                r9.f36664a = r3
                r9.f36665b = r7
                r9.f36666c = r8
                r9.f36667d = r6
                r9.f36668e = r10
                r9.f36669f = r14
                r9.f36670g = r13
                r9.f36671h = r2
                r9.f36672i = r5
                r9.f36673j = r8
                r15 = 0
                r9.f36674k = r15
                r9.f36675l = r11
                r15 = 3
                r9.f36676m = r15
                java.lang.String r15 = "sns_videoident_langSelector_waitTime_prefix"
                java.lang.Object r15 = r7.a((java.lang.String) r15, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r15 != r1) goto L_0x01a3
                return r1
            L_0x01a3:
                r0 = r14
                r14 = r13
                r13 = r3
                r3 = r10
                r10 = r11
                r12 = r2
                r2 = r8
                r8 = r4
                r4 = r6
                r6 = r7
                r7 = r5
                r5 = r2
            L_0x01af:
                java.lang.String r15 = (java.lang.String) r15
                r9.f36677n = r8
                r9.f36664a = r13
                r9.f36665b = r6
                r9.f36666c = r5
                r9.f36667d = r4
                r9.f36668e = r3
                r9.f36669f = r0
                r9.f36670g = r14
                r9.f36671h = r15
                r9.f36672i = r12
                r9.f36673j = r7
                r9.f36674k = r2
                r9.f36675l = r10
                r29 = r0
                r0 = 4
                r9.f36676m = r0
                java.lang.String r0 = "sns_videoident_langSelector_waitTime_text"
                java.lang.Object r0 = r6.a((java.lang.String) r0, (kotlin.coroutines.c<? super java.lang.String>) r9)
                if (r0 != r1) goto L_0x01d9
                return r1
            L_0x01d9:
                r18 = r29
                r17 = r14
                r19 = r15
                r24 = r6
                r6 = r4
                r4 = r8
                r8 = r5
                r5 = r7
                r7 = r24
                r25 = r10
                r10 = r9
                r9 = r13
                r13 = r25
            L_0x01ed:
                java.lang.String r0 = (java.lang.String) r0
                if (r0 == 0) goto L_0x01ff
                java.lang.String r11 = java.lang.String.valueOf(r13)
                java.lang.String r13 = "{timeInMinutes}"
                r14 = 1
                java.lang.String r0 = kotlin.text.StringsKt__StringsJVMKt.E(r0, r13, r11, r14)
                r20 = r0
                goto L_0x0202
            L_0x01ff:
                r14 = 1
                r20 = 0
            L_0x0202:
                java.lang.String r0 = r3.d()
                boolean r0 = kotlin.jvm.internal.x.b(r0, r4)
                java.lang.Boolean r21 = kotlin.coroutines.jvm.internal.a.a(r0)
                java.lang.Long r0 = r3.h()
                if (r0 == 0) goto L_0x0219
                long r22 = r0.longValue()
                goto L_0x021b
            L_0x0219:
                r22 = 0
            L_0x021b:
                com.sumsub.sns.internal.videoident.presentation.a$c$b r0 = new com.sumsub.sns.internal.videoident.presentation.a$c$b
                r16 = r0
                r16.<init>(r17, r18, r19, r20, r21, r22)
                r2.add(r0)
                r0 = r28
                r3 = r9
                r9 = r10
                r2 = r12
                goto L_0x0141
            L_0x022c:
                java.util.List r8 = (java.util.List) r8
                com.sumsub.sns.internal.videoident.presentation.a$c r0 = r2.a(r5, r8)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.presentation.a.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public a(Bundle bundle, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar, bVar);
        this.f36650q = bundle;
        this.f36651r = bVar;
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        t();
        return Unit.f56620a;
    }

    public final Bundle p() {
        return this.f36650q;
    }

    public final List<n> q() {
        ArrayList arrayList;
        Bundle bundle = this.f36650q;
        if (Build.VERSION.SDK_INT >= 33) {
            arrayList = bundle.getParcelableArrayList(f36645t, n.class);
        } else {
            arrayList = bundle.getParcelableArrayList(f36645t);
        }
        return arrayList == null ? CollectionsKt__CollectionsKt.k() : arrayList;
    }

    /* renamed from: r */
    public c e() {
        return new c("", CollectionsKt__CollectionsKt.k());
    }

    public final String s() {
        return this.f36650q.getString("lang", (String) null);
    }

    public final void t() {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new d(this, (kotlin.coroutines.c<? super d>) null), 1, (Object) null);
    }

    public final void a(c.b bVar) {
        String g11 = bVar.g();
        if (g11 == null) {
            g11 = TUIThemeManager.LANGUAGE_EN;
        }
        a((a.j) new b(g11, bVar.l()));
    }
}
