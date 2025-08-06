package com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd;

import android.nfc.tech.IsoDep;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.m0;
import com.sumsub.sns.core.data.model.SNSException;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.analytics.Action;
import com.sumsub.sns.internal.core.analytics.f;
import com.sumsub.sns.internal.core.analytics.o;
import com.sumsub.sns.internal.core.common.v0;
import com.sumsub.sns.internal.domain.h;
import d10.p;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class b extends com.sumsub.sns.core.presentation.base.a<a.C0478a> {
    public static final String A = "sns_mrtdscan_hint_prepare";
    public static final String B = "sns_mrtdscan_hint_prepare::%s";
    public static final String C = "sns_mrtdscan_action_skip";
    public static final String D = "sns_mrtdscan_action_retry";
    public static final String E = "sns_mrtdscan_hint_scanning";
    public static final String F = "sns_mrtdscan_reader_prompt";
    public static final String G = "sns_alert_action_cancel";
    public static final String H = "sns_general_dataSubmited";
    public static final String I = "sns_mrtdscan_reader_error";
    public static final String J = "numberOfAttempts";
    public static final String K = "attempt";
    public static final String L = "error";

    /* renamed from: u  reason: collision with root package name */
    public static final a f36143u = new a((r) null);

    /* renamed from: v  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f36144v;

    /* renamed from: w  reason: collision with root package name */
    public static final String f36145w = "sns_mrtdscan_title";

    /* renamed from: x  reason: collision with root package name */
    public static final String f36146x = "sns_mrtdscan_title::%s";

    /* renamed from: y  reason: collision with root package name */
    public static final String f36147y = "sns_mrtdscan_subtitle";

    /* renamed from: z  reason: collision with root package name */
    public static final String f36148z = "sns_mrtdscan_subtitle::%s";

    /* renamed from: q  reason: collision with root package name */
    public final h f36149q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f36150r;

    /* renamed from: s  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f36151s;

    /* renamed from: t  reason: collision with root package name */
    public int f36152t;

    public static final class a {

        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a  reason: collision with other inner class name */
        public static abstract class C0478a implements a.l {

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$a  reason: collision with other inner class name */
            public static final class C0479a extends C0478a {

                /* renamed from: a  reason: collision with root package name */
                public final CharSequence f36153a;

                public C0479a(CharSequence charSequence) {
                    super((r) null);
                    this.f36153a = charSequence;
                }

                public final CharSequence a() {
                    return this.f36153a;
                }

                public final CharSequence b() {
                    return this.f36153a;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return (obj instanceof C0479a) && x.b(this.f36153a, ((C0479a) obj).f36153a);
                }

                public int hashCode() {
                    CharSequence charSequence = this.f36153a;
                    if (charSequence == null) {
                        return 0;
                    }
                    return charSequence.hashCode();
                }

                public String toString() {
                    return "Complete(message=" + this.f36153a + ')';
                }

                public final C0479a a(CharSequence charSequence) {
                    return new C0479a(charSequence);
                }

                public static /* synthetic */ C0479a a(C0479a aVar, CharSequence charSequence, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        charSequence = aVar.f36153a;
                    }
                    return aVar.a(charSequence);
                }
            }

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$b  reason: collision with other inner class name */
            public static final class C0480b extends C0478a {

                /* renamed from: a  reason: collision with root package name */
                public final CharSequence f36154a;

                /* renamed from: b  reason: collision with root package name */
                public final CharSequence f36155b;

                /* renamed from: c  reason: collision with root package name */
                public final CharSequence f36156c;

                public C0480b(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
                    super((r) null);
                    this.f36154a = charSequence;
                    this.f36155b = charSequence2;
                    this.f36156c = charSequence3;
                }

                public final CharSequence a() {
                    return this.f36154a;
                }

                public final CharSequence b() {
                    return this.f36155b;
                }

                public final CharSequence c() {
                    return this.f36156c;
                }

                public final CharSequence d() {
                    return this.f36154a;
                }

                public final CharSequence e() {
                    return this.f36155b;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0480b)) {
                        return false;
                    }
                    C0480b bVar = (C0480b) obj;
                    return x.b(this.f36154a, bVar.f36154a) && x.b(this.f36155b, bVar.f36155b) && x.b(this.f36156c, bVar.f36156c);
                }

                public final CharSequence f() {
                    return this.f36156c;
                }

                public int hashCode() {
                    CharSequence charSequence = this.f36154a;
                    int i11 = 0;
                    int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
                    CharSequence charSequence2 = this.f36155b;
                    int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                    CharSequence charSequence3 = this.f36156c;
                    if (charSequence3 != null) {
                        i11 = charSequence3.hashCode();
                    }
                    return hashCode2 + i11;
                }

                public String toString() {
                    return "Error(message=" + this.f36154a + ", primaryButton=" + this.f36155b + ", secondaryButton=" + this.f36156c + ')';
                }

                public final C0480b a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
                    return new C0480b(charSequence, charSequence2, charSequence3);
                }

                public static /* synthetic */ C0480b a(C0480b bVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        charSequence = bVar.f36154a;
                    }
                    if ((i11 & 2) != 0) {
                        charSequence2 = bVar.f36155b;
                    }
                    if ((i11 & 4) != 0) {
                        charSequence3 = bVar.f36156c;
                    }
                    return bVar.a(charSequence, charSequence2, charSequence3);
                }
            }

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$c */
            public static final class c extends C0478a {

                /* renamed from: a  reason: collision with root package name */
                public static final c f36157a = new c();

                public c() {
                    super((r) null);
                }
            }

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$d */
            public static final class d extends C0478a {

                /* renamed from: a  reason: collision with root package name */
                public final CharSequence f36158a;

                /* renamed from: b  reason: collision with root package name */
                public final CharSequence f36159b;

                /* renamed from: c  reason: collision with root package name */
                public final CharSequence f36160c;

                /* renamed from: d  reason: collision with root package name */
                public final CharSequence f36161d;

                /* renamed from: e  reason: collision with root package name */
                public final CharSequence f36162e;

                public d(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
                    super((r) null);
                    this.f36158a = charSequence;
                    this.f36159b = charSequence2;
                    this.f36160c = charSequence3;
                    this.f36161d = charSequence4;
                    this.f36162e = charSequence5;
                }

                public final CharSequence a() {
                    return this.f36158a;
                }

                public final CharSequence b() {
                    return this.f36159b;
                }

                public final CharSequence c() {
                    return this.f36160c;
                }

                public final CharSequence d() {
                    return this.f36161d;
                }

                public final CharSequence e() {
                    return this.f36162e;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof d)) {
                        return false;
                    }
                    d dVar = (d) obj;
                    return x.b(this.f36158a, dVar.f36158a) && x.b(this.f36159b, dVar.f36159b) && x.b(this.f36160c, dVar.f36160c) && x.b(this.f36161d, dVar.f36161d) && x.b(this.f36162e, dVar.f36162e);
                }

                public final CharSequence f() {
                    return this.f36160c;
                }

                public final CharSequence g() {
                    return this.f36161d;
                }

                public final CharSequence h() {
                    return this.f36162e;
                }

                public int hashCode() {
                    CharSequence charSequence = this.f36158a;
                    int i11 = 0;
                    int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
                    CharSequence charSequence2 = this.f36159b;
                    int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                    CharSequence charSequence3 = this.f36160c;
                    int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
                    CharSequence charSequence4 = this.f36161d;
                    int hashCode4 = (hashCode3 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31;
                    CharSequence charSequence5 = this.f36162e;
                    if (charSequence5 != null) {
                        i11 = charSequence5.hashCode();
                    }
                    return hashCode4 + i11;
                }

                public final CharSequence i() {
                    return this.f36159b;
                }

                public final CharSequence j() {
                    return this.f36158a;
                }

                public String toString() {
                    return "Listening(title=" + this.f36158a + ", subtitle=" + this.f36159b + ", hint=" + this.f36160c + ", primaryButton=" + this.f36161d + ", secondaryButton=" + this.f36162e + ')';
                }

                public final d a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5) {
                    return new d(charSequence, charSequence2, charSequence3, charSequence4, charSequence5);
                }

                public static /* synthetic */ d a(d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i11, Object obj) {
                    if ((i11 & 1) != 0) {
                        charSequence = dVar.f36158a;
                    }
                    if ((i11 & 2) != 0) {
                        charSequence2 = dVar.f36159b;
                    }
                    CharSequence charSequence6 = charSequence2;
                    if ((i11 & 4) != 0) {
                        charSequence3 = dVar.f36160c;
                    }
                    CharSequence charSequence7 = charSequence3;
                    if ((i11 & 8) != 0) {
                        charSequence4 = dVar.f36161d;
                    }
                    CharSequence charSequence8 = charSequence4;
                    if ((i11 & 16) != 0) {
                        charSequence5 = dVar.f36162e;
                    }
                    return dVar.a(charSequence, charSequence6, charSequence7, charSequence8, charSequence5);
                }
            }

            /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$e */
            public static final class e extends C0478a {

                /* renamed from: a  reason: collision with root package name */
                public final CharSequence f36163a;

                /* renamed from: b  reason: collision with root package name */
                public final CharSequence f36164b;

                /* renamed from: c  reason: collision with root package name */
                public final CharSequence f36165c;

                /* renamed from: d  reason: collision with root package name */
                public final CharSequence f36166d;

                /* renamed from: e  reason: collision with root package name */
                public final CharSequence f36167e;

                /* renamed from: f  reason: collision with root package name */
                public final int f36168f;

                public e(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i11) {
                    super((r) null);
                    this.f36163a = charSequence;
                    this.f36164b = charSequence2;
                    this.f36165c = charSequence3;
                    this.f36166d = charSequence4;
                    this.f36167e = charSequence5;
                    this.f36168f = i11;
                }

                public final CharSequence a() {
                    return this.f36163a;
                }

                public final CharSequence b() {
                    return this.f36164b;
                }

                public final CharSequence c() {
                    return this.f36165c;
                }

                public final CharSequence d() {
                    return this.f36166d;
                }

                public final CharSequence e() {
                    return this.f36167e;
                }

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof e)) {
                        return false;
                    }
                    e eVar = (e) obj;
                    return x.b(this.f36163a, eVar.f36163a) && x.b(this.f36164b, eVar.f36164b) && x.b(this.f36165c, eVar.f36165c) && x.b(this.f36166d, eVar.f36166d) && x.b(this.f36167e, eVar.f36167e) && this.f36168f == eVar.f36168f;
                }

                public final int f() {
                    return this.f36168f;
                }

                public final CharSequence g() {
                    return this.f36165c;
                }

                public final CharSequence h() {
                    return this.f36166d;
                }

                public int hashCode() {
                    CharSequence charSequence = this.f36163a;
                    int i11 = 0;
                    int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
                    CharSequence charSequence2 = this.f36164b;
                    int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
                    CharSequence charSequence3 = this.f36165c;
                    int hashCode3 = (hashCode2 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
                    CharSequence charSequence4 = this.f36166d;
                    int hashCode4 = (hashCode3 + (charSequence4 == null ? 0 : charSequence4.hashCode())) * 31;
                    CharSequence charSequence5 = this.f36167e;
                    if (charSequence5 != null) {
                        i11 = charSequence5.hashCode();
                    }
                    return ((hashCode4 + i11) * 31) + this.f36168f;
                }

                public final int i() {
                    return this.f36168f;
                }

                public final CharSequence j() {
                    return this.f36167e;
                }

                public final CharSequence k() {
                    return this.f36164b;
                }

                public final CharSequence l() {
                    return this.f36163a;
                }

                public String toString() {
                    return "Reading(title=" + this.f36163a + ", subtitle=" + this.f36164b + ", hint=" + this.f36165c + ", primaryButton=" + this.f36166d + ", secondaryButton=" + this.f36167e + ", progress=" + this.f36168f + ')';
                }

                public final e a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i11) {
                    return new e(charSequence, charSequence2, charSequence3, charSequence4, charSequence5, i11);
                }

                public static /* synthetic */ e a(e eVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, int i11, int i12, Object obj) {
                    if ((i12 & 1) != 0) {
                        charSequence = eVar.f36163a;
                    }
                    if ((i12 & 2) != 0) {
                        charSequence2 = eVar.f36164b;
                    }
                    CharSequence charSequence6 = charSequence2;
                    if ((i12 & 4) != 0) {
                        charSequence3 = eVar.f36165c;
                    }
                    CharSequence charSequence7 = charSequence3;
                    if ((i12 & 8) != 0) {
                        charSequence4 = eVar.f36166d;
                    }
                    CharSequence charSequence8 = charSequence4;
                    if ((i12 & 16) != 0) {
                        charSequence5 = eVar.f36167e;
                    }
                    CharSequence charSequence9 = charSequence5;
                    if ((i12 & 32) != 0) {
                        i11 = eVar.f36168f;
                    }
                    return eVar.a(charSequence, charSequence6, charSequence7, charSequence8, charSequence9, i11);
                }
            }

            public /* synthetic */ C0478a(r rVar) {
                this();
            }

            public C0478a() {
            }
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.SNSMRTDReadViewModel", f = "SNSMRTDReadViewModel.kt", l = {41, 41}, m = "getStringValue")
    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$b  reason: collision with other inner class name */
    public static final class C0481b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36169a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36170b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f36171c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f36172d;

        /* renamed from: e  reason: collision with root package name */
        public int f36173e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0481b(b bVar, kotlin.coroutines.c<? super C0481b> cVar) {
            super(cVar);
            this.f36172d = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36171c = obj;
            this.f36173e |= Integer.MIN_VALUE;
            return this.f36172d.a((String) null, (String) null, (kotlin.coroutines.c<? super CharSequence>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.SNSMRTDReadViewModel$startListening$1", f = "SNSMRTDReadViewModel.kt", l = {47, 48, 49, 51}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<a.C0478a, kotlin.coroutines.c<? super a.C0478a>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36174a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36175b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36176c;

        /* renamed from: d  reason: collision with root package name */
        public int f36177d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f36178e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(b bVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f36178e = bVar;
        }

        /* renamed from: a */
        public final Object invoke(a.C0478a aVar, kotlin.coroutines.c<? super a.C0478a> cVar) {
            return ((c) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f36178e, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x006e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0083 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x009c A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x009d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r7.f36177d
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x0049
                if (r1 == r5) goto L_0x0045
                if (r1 == r4) goto L_0x003d
                if (r1 == r3) goto L_0x0031
                if (r1 != r2) goto L_0x0029
                java.lang.Object r0 = r7.f36176c
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r7.f36175b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r7.f36174a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                kotlin.k.b(r8)
                r3 = r0
                r6 = r2
            L_0x0025:
                r2 = r1
                r1 = r6
                goto L_0x00a1
            L_0x0029:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0031:
                java.lang.Object r1 = r7.f36175b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r3 = r7.f36174a
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                kotlin.k.b(r8)
                goto L_0x0088
            L_0x003d:
                java.lang.Object r1 = r7.f36174a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                kotlin.k.b(r8)
                goto L_0x006f
            L_0x0045:
                kotlin.k.b(r8)
                goto L_0x005b
            L_0x0049:
                kotlin.k.b(r8)
                com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r8 = r7.f36178e
                r7.f36177d = r5
                java.lang.String r1 = "sns_mrtdscan_title::%s"
                java.lang.String r5 = "sns_mrtdscan_title"
                java.lang.Object r8 = r8.a((java.lang.String) r1, (java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.CharSequence>) r7)
                if (r8 != r0) goto L_0x005b
                return r0
            L_0x005b:
                r1 = r8
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r8 = r7.f36178e
                r7.f36174a = r1
                r7.f36177d = r4
                java.lang.String r4 = "sns_mrtdscan_subtitle::%s"
                java.lang.String r5 = "sns_mrtdscan_subtitle"
                java.lang.Object r8 = r8.a((java.lang.String) r4, (java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.CharSequence>) r7)
                if (r8 != r0) goto L_0x006f
                return r0
            L_0x006f:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r4 = r7.f36178e
                r7.f36174a = r1
                r7.f36175b = r8
                r7.f36177d = r3
                java.lang.String r3 = "sns_mrtdscan_hint_prepare::%s"
                java.lang.String r5 = "sns_mrtdscan_hint_prepare"
                java.lang.Object r3 = r4.a((java.lang.String) r3, (java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.CharSequence>) r7)
                if (r3 != r0) goto L_0x0084
                return r0
            L_0x0084:
                r6 = r1
                r1 = r8
                r8 = r3
                r3 = r6
            L_0x0088:
                java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r4 = r7.f36178e
                r7.f36174a = r3
                r7.f36175b = r1
                r7.f36176c = r8
                r7.f36177d = r2
                java.lang.String r2 = "sns_mrtdscan_action_skip"
                java.lang.Object r2 = r4.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r7)
                if (r2 != r0) goto L_0x009d
                return r0
            L_0x009d:
                r6 = r3
                r3 = r8
                r8 = r2
                goto L_0x0025
            L_0x00a1:
                r5 = r8
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$d r8 = new com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$d
                r4 = 0
                r0 = r8
                r0.<init>(r1, r2, r3, r4, r5)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.SNSMRTDReadViewModel$startRead$1", f = "SNSMRTDReadViewModel.kt", l = {74, 76, 78}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<a.C0478a, kotlin.coroutines.c<? super a.C0478a>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36179a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36180b;

        /* renamed from: c  reason: collision with root package name */
        public int f36181c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f36182d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f36182d = bVar;
        }

        /* renamed from: a */
        public final Object invoke(a.C0478a aVar, kotlin.coroutines.c<? super a.C0478a> cVar) {
            return ((d) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f36182d, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r8.f36181c
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x0032
                if (r1 == r4) goto L_0x002e
                if (r1 == r3) goto L_0x0026
                if (r1 != r2) goto L_0x001e
                java.lang.Object r0 = r8.f36180b
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                java.lang.Object r1 = r8.f36179a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                kotlin.k.b(r9)
                r3 = r0
                goto L_0x006b
            L_0x001e:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0026:
                java.lang.Object r1 = r8.f36179a
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                kotlin.k.b(r9)
                goto L_0x0056
            L_0x002e:
                kotlin.k.b(r9)
                goto L_0x0042
            L_0x0032:
                kotlin.k.b(r9)
                com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r9 = r8.f36182d
                r8.f36181c = r4
                java.lang.String r1 = "sns_mrtdscan_hint_scanning"
                java.lang.Object r9 = r9.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r9 != r0) goto L_0x0042
                return r0
            L_0x0042:
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r1 = r8.f36182d
                r8.f36179a = r9
                r8.f36181c = r3
                java.lang.String r3 = "sns_mrtdscan_reader_prompt"
                java.lang.Object r1 = r1.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r1 != r0) goto L_0x0053
                return r0
            L_0x0053:
                r7 = r1
                r1 = r9
                r9 = r7
            L_0x0056:
                java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r3 = r8.f36182d
                r8.f36179a = r1
                r8.f36180b = r9
                r8.f36181c = r2
                java.lang.String r2 = "sns_alert_action_cancel"
                java.lang.Object r2 = r3.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r8)
                if (r2 != r0) goto L_0x0069
                return r0
            L_0x0069:
                r3 = r9
                r9 = r2
            L_0x006b:
                r5 = r9
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$e r9 = new com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$e
                r2 = 0
                r4 = 0
                r6 = 0
                r0 = r9
                r0.<init>(r1, r2, r3, r4, r5, r6)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.SNSMRTDReadViewModel$startRead$2", f = "SNSMRTDReadViewModel.kt", l = {84}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36183a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36184b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f36185c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f36186d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f36187e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ IsoDep f36188f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f36189g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f36190h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f36191i;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.SNSMRTDReadViewModel$startRead$2$1", f = "SNSMRTDReadViewModel.kt", l = {115}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<a.C0478a, kotlin.coroutines.c<? super a.C0478a>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36192a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f36193b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36193b = bVar;
            }

            /* renamed from: a */
            public final Object invoke(a.C0478a aVar, kotlin.coroutines.c<? super a.C0478a> cVar) {
                return ((a) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f36193b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f36192a;
                if (i11 == 0) {
                    k.b(obj);
                    b bVar = this.f36193b;
                    this.f36192a = 1;
                    obj = bVar.a(b.H, (kotlin.coroutines.c<? super String>) this);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return new a.C0478a.C0479a((CharSequence) obj);
            }
        }

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.SNSMRTDReadViewModel$startRead$2$2", f = "SNSMRTDReadViewModel.kt", l = {133, 134, 135}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$e$b  reason: collision with other inner class name */
        public static final class C0482b extends SuspendLambda implements p<a.C0478a, kotlin.coroutines.c<? super a.C0478a>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public Object f36194a;

            /* renamed from: b  reason: collision with root package name */
            public Object f36195b;

            /* renamed from: c  reason: collision with root package name */
            public int f36196c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ b f36197d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0482b(b bVar, kotlin.coroutines.c<? super C0482b> cVar) {
                super(2, cVar);
                this.f36197d = bVar;
            }

            /* renamed from: a */
            public final Object invoke(a.C0478a aVar, kotlin.coroutines.c<? super a.C0478a> cVar) {
                return ((C0482b) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new C0482b(this.f36197d, cVar);
            }

            /* JADX WARNING: Removed duplicated region for block: B:19:0x0067 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:20:0x0068  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r6.f36196c
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x0031
                    if (r1 == r4) goto L_0x002d
                    if (r1 == r3) goto L_0x0025
                    if (r1 != r2) goto L_0x001d
                    java.lang.Object r0 = r6.f36195b
                    java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                    java.lang.Object r1 = r6.f36194a
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    kotlin.k.b(r7)
                    goto L_0x006a
                L_0x001d:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L_0x0025:
                    java.lang.Object r1 = r6.f36194a
                    java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                    kotlin.k.b(r7)
                    goto L_0x0055
                L_0x002d:
                    kotlin.k.b(r7)
                    goto L_0x0041
                L_0x0031:
                    kotlin.k.b(r7)
                    com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r7 = r6.f36197d
                    r6.f36196c = r4
                    java.lang.String r1 = "sns_mrtdscan_reader_error"
                    java.lang.Object r7 = r7.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r6)
                    if (r7 != r0) goto L_0x0041
                    return r0
                L_0x0041:
                    java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                    com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r1 = r6.f36197d
                    r6.f36194a = r7
                    r6.f36196c = r3
                    java.lang.String r3 = "sns_mrtdscan_action_retry"
                    java.lang.Object r1 = r1.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r6)
                    if (r1 != r0) goto L_0x0052
                    return r0
                L_0x0052:
                    r5 = r1
                    r1 = r7
                    r7 = r5
                L_0x0055:
                    java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                    com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r3 = r6.f36197d
                    r6.f36194a = r1
                    r6.f36195b = r7
                    r6.f36196c = r2
                    java.lang.String r2 = "sns_mrtdscan_action_skip"
                    java.lang.Object r2 = r3.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r6)
                    if (r2 != r0) goto L_0x0068
                    return r0
                L_0x0068:
                    r0 = r7
                    r7 = r2
                L_0x006a:
                    java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                    com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$b r2 = new com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$b
                    r2.<init>(r1, r0, r7)
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.e.C0482b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public static final class c extends Lambda implements d10.l<Integer, Unit> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ b f36198a;

            @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.SNSMRTDReadViewModel$startRead$2$readingResult$1$1", f = "SNSMRTDReadViewModel.kt", l = {95, 97, 99}, m = "invokeSuspend")
            public static final class a extends SuspendLambda implements p<a.C0478a, kotlin.coroutines.c<? super a.C0478a>, Object> {

                /* renamed from: a  reason: collision with root package name */
                public Object f36199a;

                /* renamed from: b  reason: collision with root package name */
                public Object f36200b;

                /* renamed from: c  reason: collision with root package name */
                public int f36201c;

                /* renamed from: d  reason: collision with root package name */
                public final /* synthetic */ b f36202d;

                /* renamed from: e  reason: collision with root package name */
                public final /* synthetic */ int f36203e;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public a(b bVar, int i11, kotlin.coroutines.c<? super a> cVar) {
                    super(2, cVar);
                    this.f36202d = bVar;
                    this.f36203e = i11;
                }

                /* renamed from: a */
                public final Object invoke(a.C0478a aVar, kotlin.coroutines.c<? super a.C0478a> cVar) {
                    return ((a) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
                }

                public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    return new a(this.f36202d, this.f36203e, cVar);
                }

                /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[RETURN] */
                /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object invokeSuspend(java.lang.Object r9) {
                    /*
                        r8 = this;
                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                        int r1 = r8.f36201c
                        r2 = 3
                        r3 = 2
                        r4 = 1
                        if (r1 == 0) goto L_0x0032
                        if (r1 == r4) goto L_0x002e
                        if (r1 == r3) goto L_0x0026
                        if (r1 != r2) goto L_0x001e
                        java.lang.Object r0 = r8.f36200b
                        java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                        java.lang.Object r1 = r8.f36199a
                        java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                        kotlin.k.b(r9)
                        r3 = r0
                        goto L_0x006b
                    L_0x001e:
                        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                        r9.<init>(r0)
                        throw r9
                    L_0x0026:
                        java.lang.Object r1 = r8.f36199a
                        java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                        kotlin.k.b(r9)
                        goto L_0x0056
                    L_0x002e:
                        kotlin.k.b(r9)
                        goto L_0x0042
                    L_0x0032:
                        kotlin.k.b(r9)
                        com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r9 = r8.f36202d
                        r8.f36201c = r4
                        java.lang.String r1 = "sns_mrtdscan_hint_scanning"
                        java.lang.Object r9 = r9.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r8)
                        if (r9 != r0) goto L_0x0042
                        return r0
                    L_0x0042:
                        java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                        com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r1 = r8.f36202d
                        r8.f36199a = r9
                        r8.f36201c = r3
                        java.lang.String r3 = "sns_mrtdscan_reader_prompt"
                        java.lang.Object r1 = r1.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r8)
                        if (r1 != r0) goto L_0x0053
                        return r0
                    L_0x0053:
                        r7 = r1
                        r1 = r9
                        r9 = r7
                    L_0x0056:
                        java.lang.CharSequence r9 = (java.lang.CharSequence) r9
                        com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r3 = r8.f36202d
                        r8.f36199a = r1
                        r8.f36200b = r9
                        r8.f36201c = r2
                        java.lang.String r2 = "sns_alert_action_cancel"
                        java.lang.Object r2 = r3.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r8)
                        if (r2 != r0) goto L_0x0069
                        return r0
                    L_0x0069:
                        r3 = r9
                        r9 = r2
                    L_0x006b:
                        r5 = r9
                        java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                        int r6 = r8.f36203e
                        com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$e r9 = new com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$a$a$e
                        r2 = 0
                        r4 = 0
                        r0 = r9
                        r0.<init>(r1, r2, r3, r4, r5, r6)
                        return r9
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.e.c.a.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public c(b bVar) {
                super(1);
                this.f36198a = bVar;
            }

            public final void a(int i11) {
                b bVar = this.f36198a;
                com.sumsub.sns.core.presentation.base.a.a(bVar, false, new a(bVar, i11, (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a(((Number) obj).intValue());
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar, String str, String str2, String str3, IsoDep isoDep, String str4, String str5, String str6, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f36184b = bVar;
            this.f36185c = str;
            this.f36186d = str2;
            this.f36187e = str3;
            this.f36188f = isoDep;
            this.f36189g = str4;
            this.f36190h = str5;
            this.f36191i = str6;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new e(this.f36184b, this.f36185c, this.f36186d, this.f36187e, this.f36188f, this.f36189g, this.f36190h, this.f36191i, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f36183a;
            if (i11 == 0) {
                k.b(obj);
                h c11 = this.f36184b.f36149q;
                String str = this.f36185c;
                String str2 = this.f36186d;
                String str3 = this.f36187e;
                IsoDep isoDep = this.f36188f;
                String str4 = this.f36189g;
                String str5 = this.f36190h;
                String str6 = this.f36191i;
                c cVar = new c(this.f36184b);
                this.f36183a = 1;
                obj = c11.a(str, str2, str3, isoDep, str4, str5, str6, cVar, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            h.b bVar = (h.b) obj;
            if (x.b(bVar, h.b.C0386b.f34121a)) {
                o.a(f.a(0, 1, (Object) null).a(Action.NfcScan).e().a((Pair<String, ? extends Object>[]) new Pair[]{kotlin.l.a(b.J, kotlin.coroutines.jvm.internal.a.c(this.f36184b.f36152t))}), false, 1, (Object) null);
                b bVar2 = this.f36184b;
                com.sumsub.sns.core.presentation.base.a.a(bVar2, false, new a(bVar2, (kotlin.coroutines.c<? super a>) null), 1, (Object) null);
            } else if (bVar instanceof h.b.a) {
                h.b.a aVar = (h.b.a) bVar;
                o.a(f.a(0, 1, (Object) null).a(Action.NfcScan).d().a((Pair<String, ? extends Object>[]) new Pair[]{kotlin.l.a("attempt", kotlin.coroutines.jvm.internal.a.c(this.f36184b.f36152t)), kotlin.l.a("error", String.valueOf(aVar.b().getMessage()))}), false, 1, (Object) null);
                if (aVar.b() instanceof SNSException) {
                    com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this.f36184b, (Throwable) aVar.b(), this.f36184b.q(), (Object) null, 4, (Object) null);
                } else {
                    b bVar3 = this.f36184b;
                    com.sumsub.sns.core.presentation.base.a.a(bVar3, false, new C0482b(bVar3, (kotlin.coroutines.c<? super C0482b>) null), 1, (Object) null);
                }
            }
            return Unit.f56620a;
        }
    }

    static {
        Class<b> cls = b.class;
        f36144v = new l[]{Reflection.j(new PropertyReference1Impl(cls, "idDocType", "getIdDocType()Ljava/lang/String;", 0)), Reflection.j(new PropertyReference1Impl(cls, "idDocSetType", "getIdDocSetType()Ljava/lang/String;", 0))};
    }

    public b(SavedStateHandle savedStateHandle, h hVar, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar, bVar);
        this.f36149q = hVar;
        this.f36150r = v0.a(savedStateHandle, a.f36137c);
        this.f36151s = v0.a(savedStateHandle, a.f36138d);
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        s();
        return Unit.f56620a;
    }

    /* renamed from: p */
    public a.C0478a.c e() {
        return a.C0478a.c.f36157a;
    }

    public final String q() {
        return (String) this.f36151s.a(this, f36144v[1]);
    }

    public final String r() {
        return (String) this.f36150r.a(this, f36144v[0]);
    }

    public final void s() {
        com.sumsub.sns.core.presentation.base.a.a(this, false, new c(this, (kotlin.coroutines.c<? super c>) null), 1, (Object) null);
    }

    public void b(com.sumsub.sns.internal.core.data.model.o oVar) {
        super.b(oVar);
        s();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r7, java.lang.String r8, kotlin.coroutines.c<? super java.lang.CharSequence> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.C0481b
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$b r0 = (com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.C0481b) r0
            int r1 = r0.f36173e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36173e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$b r0 = new com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b$b
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f36171c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36173e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r9)
            goto L_0x0078
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            java.lang.Object r7 = r0.f36170b
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.f36169a
            com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b r7 = (com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b) r7
            kotlin.k.b(r9)
            goto L_0x0065
        L_0x0041:
            kotlin.k.b(r9)
            kotlin.jvm.internal.d0 r9 = kotlin.jvm.internal.d0.f56774a
            java.lang.Object[] r9 = new java.lang.Object[r4]
            java.lang.String r2 = r6.r()
            r5 = 0
            r9[r5] = r2
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r4)
            java.lang.String r7 = java.lang.String.format(r7, r9)
            r0.f36169a = r6
            r0.f36170b = r8
            r0.f36173e = r4
            java.lang.Object r9 = r6.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r7 = r6
        L_0x0065:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x006a
            goto L_0x007a
        L_0x006a:
            r9 = 0
            r0.f36169a = r9
            r0.f36170b = r9
            r0.f36173e = r3
            java.lang.Object r9 = r7.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r9 != r1) goto L_0x0078
            return r1
        L_0x0078:
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
        L_0x007a:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.photo.mrtd.b.a(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(String str, String str2, String str3, IsoDep isoDep, String str4, String str5, String str6) {
        this.f36152t++;
        o.a(f.a(0, 1, (Object) null).a(Action.NfcScan).l().a((Pair<String, ? extends Object>[]) new Pair[]{kotlin.l.a("attempt", Integer.valueOf(this.f36152t))}), false, 1, (Object) null);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new d(this, (kotlin.coroutines.c<? super d>) null), 1, (Object) null);
        n1 unused = i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new e(this, str, str2, str3, isoDep, str4, str5, str6, (kotlin.coroutines.c<? super e>) null), 3, (Object) null);
    }
}
