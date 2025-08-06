package com.sumsub.sns.internal.core.data.source.applicant;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.source.applicant.remote.a0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.b0;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a;
import com.sumsub.sns.internal.core.data.source.applicant.remote.w;
import java.io.File;
import java.io.InputStream;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Lambda;

public final class c implements b {

    /* renamed from: a  reason: collision with root package name */
    public final a f32965a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f32966b;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {235}, m = "acquireActionId")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f32967a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f32968b;

        /* renamed from: c  reason: collision with root package name */
        public int f32969c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, kotlin.coroutines.c<? super a> cVar2) {
            super(cVar2);
            this.f32968b = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32967a = obj;
            this.f32969c |= Integer.MIN_VALUE;
            return this.f32968b.d(this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {239}, m = "acquireApplicantId")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f32970a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f32971b;

        /* renamed from: c  reason: collision with root package name */
        public int f32972c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, kotlin.coroutines.c<? super b> cVar2) {
            super(cVar2);
            this.f32971b = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32970a = obj;
            this.f32972c |= Integer.MIN_VALUE;
            return this.f32971b.e(this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {30, 32, 38}, m = "acquireQuestionnaireId")
    /* renamed from: com.sumsub.sns.internal.core.data.source.applicant.c$c  reason: collision with other inner class name */
    public static final class C0356c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f32973a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f32974b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f32975c;

        /* renamed from: d  reason: collision with root package name */
        public int f32976d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0356c(c cVar, kotlin.coroutines.c<? super C0356c> cVar2) {
            super(cVar2);
            this.f32975c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32974b = obj;
            this.f32976d |= Integer.MIN_VALUE;
            return this.f32975c.c(this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {183, 191}, m = "buildFileUrlProvider")
    public static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f32977a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f32978b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f32979c;

        /* renamed from: d  reason: collision with root package name */
        public int f32980d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c cVar, kotlin.coroutines.c<? super d> cVar2) {
            super(cVar2);
            this.f32979c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32978b = obj;
            this.f32980d |= Integer.MIN_VALUE;
            return this.f32979c.a(this);
        }
    }

    public static final class e implements d10.l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f32981a;

        public e(String str) {
            this.f32981a = str;
        }

        /* renamed from: a */
        public String invoke(String str) {
            return "resources/applicantActions/" + this.f32981a + "/images/" + str + "?preview=true";
        }
    }

    public static final class f implements d10.l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f32982a;

        public f(String str) {
            this.f32982a = str;
        }

        /* renamed from: a */
        public String invoke(String str) {
            return "resources/applicants/" + this.f32982a + "/resources/" + str + "?preview=true";
        }
    }

    public static final class g extends Lambda implements d10.l<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final g f32983a = new g();

        public g() {
            super(1);
        }

        /* renamed from: a */
        public final String invoke(String str) {
            return str;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {97, 98, 104, 105}, m = "deleteImage")
    public static final class h extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f32984a;

        /* renamed from: b  reason: collision with root package name */
        public int f32985b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f32986c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f32987d;

        /* renamed from: e  reason: collision with root package name */
        public int f32988e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(c cVar, kotlin.coroutines.c<? super h> cVar2) {
            super(cVar2);
            this.f32987d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32986c = obj;
            this.f32988e |= Integer.MIN_VALUE;
            return this.f32987d.a(0, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {70, 71, 74, 75}, m = "postAgreement")
    public static final class i extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f32989a;

        /* renamed from: b  reason: collision with root package name */
        public Object f32990b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f32991c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f32992d;

        /* renamed from: e  reason: collision with root package name */
        public int f32993e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(c cVar, kotlin.coroutines.c<? super i> cVar2) {
            super(cVar2);
            this.f32992d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32991c = obj;
            this.f32993e |= Integer.MIN_VALUE;
            return this.f32992d.a((com.sumsub.sns.internal.core.data.model.b) null, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {201, 202, 208, 209}, m = "requestCode")
    public static final class j extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f32994a;

        /* renamed from: b  reason: collision with root package name */
        public Object f32995b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f32996c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f32997d;

        /* renamed from: e  reason: collision with root package name */
        public int f32998e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(c cVar, kotlin.coroutines.c<? super j> cVar2) {
            super(cVar2);
            this.f32997d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f32996c = obj;
            this.f32998e |= Integer.MIN_VALUE;
            return this.f32997d.a((a0) null, (kotlin.coroutines.c<? super b0>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {61, 62}, m = "setApplicantLanguage")
    public static final class k extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f32999a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33000b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33001c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33002d;

        /* renamed from: e  reason: collision with root package name */
        public int f33003e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(c cVar, kotlin.coroutines.c<? super k> cVar2) {
            super(cVar2);
            this.f33002d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33001c = obj;
            this.f33003e |= Integer.MIN_VALUE;
            return this.f33002d.a((String) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {45, 46, 47, 53, 54}, m = "setPending")
    public static final class l extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33004a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33005b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ c f33006c;

        /* renamed from: d  reason: collision with root package name */
        public int f33007d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(c cVar, kotlin.coroutines.c<? super l> cVar2) {
            super(cVar2);
            this.f33006c = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33005b = obj;
            this.f33007d |= Integer.MIN_VALUE;
            return this.f33006c.b(this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {80, 81, 91}, m = "submitQuestionnaire")
    public static final class m extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33008a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33009b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33010c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ c f33011d;

        /* renamed from: e  reason: collision with root package name */
        public int f33012e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(c cVar, kotlin.coroutines.c<? super m> cVar2) {
            super(cVar2);
            this.f33011d = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33010c = obj;
            this.f33012e |= Integer.MIN_VALUE;
            return this.f33011d.a((u) null, (kotlin.coroutines.c<? super w>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {120, 121, 132, 133}, m = "uploadFile")
    public static final class n extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33013a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33014b;

        /* renamed from: c  reason: collision with root package name */
        public Object f33015c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33016d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33017e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33018f;

        /* renamed from: g  reason: collision with root package name */
        public Object f33019g;

        /* renamed from: h  reason: collision with root package name */
        public /* synthetic */ Object f33020h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ c f33021i;

        /* renamed from: j  reason: collision with root package name */
        public int f33022j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(c cVar, kotlin.coroutines.c<? super n> cVar2) {
            super(cVar2);
            this.f33021i = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33020h = obj;
            this.f33022j |= Integer.MIN_VALUE;
            return this.f33021i.a((String) null, (InputStream) null, (String) null, (IdentitySide) null, (Map<String, String>) null, (DocumentType) null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {154, 155, 167, 168}, m = "uploadFile")
    public static final class o extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33023a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33024b;

        /* renamed from: c  reason: collision with root package name */
        public Object f33025c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33026d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33027e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33028f;

        /* renamed from: g  reason: collision with root package name */
        public Object f33029g;

        /* renamed from: h  reason: collision with root package name */
        public Object f33030h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f33031i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ c f33032j;

        /* renamed from: k  reason: collision with root package name */
        public int f33033k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(c cVar, kotlin.coroutines.c<? super o> cVar2) {
            super(cVar2);
            this.f33032j = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33031i = obj;
            this.f33033k |= Integer.MIN_VALUE;
            return this.f33032j.a((String) null, (File) null, (String) null, (IdentitySide) null, (Map<String, String>) null, (DocumentType) null, (a.C0361a) null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.applicant.ApplicantProxyRepositoryImpl", f = "ApplicantProxyRepositoryImpl.kt", l = {217, 218, 225, 226}, m = "verifyCode")
    public static final class p extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33034a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33035b;

        /* renamed from: c  reason: collision with root package name */
        public Object f33036c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f33037d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f33038e;

        /* renamed from: f  reason: collision with root package name */
        public int f33039f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(c cVar, kotlin.coroutines.c<? super p> cVar2) {
            super(cVar2);
            this.f33038e = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33037d = obj;
            this.f33039f |= Integer.MIN_VALUE;
            return this.f33038e.a((String) null, (String) null, this);
        }
    }

    public c(a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        this.f32965a = aVar;
        this.f32966b = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0062 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object c(kotlin.coroutines.c<? super java.lang.String> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.C0356c
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.core.data.source.applicant.c$c r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.C0356c) r0
            int r1 = r0.f32976d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32976d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$c r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$c
            r0.<init>(r8, r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.f32974b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.f32976d
            r2 = 3
            r3 = 2
            r5 = 1
            r7 = 0
            if (r1 == 0) goto L_0x0046
            if (r1 == r5) goto L_0x003e
            if (r1 == r3) goto L_0x003a
            if (r1 != r2) goto L_0x0032
            kotlin.k.b(r9)
            goto L_0x00c6
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x003a:
            kotlin.k.b(r9)
            goto L_0x007c
        L_0x003e:
            java.lang.Object r1 = r4.f32973a
            com.sumsub.sns.internal.core.data.source.applicant.c r1 = (com.sumsub.sns.internal.core.data.source.applicant.c) r1
            kotlin.k.b(r9)
            goto L_0x0058
        L_0x0046:
            kotlin.k.b(r9)
            com.sumsub.sns.internal.core.data.source.dynamic.b r9 = r8.f32966b
            r4.f32973a = r8
            r4.f32976d = r5
            r1 = 0
            java.lang.Object r9 = com.sumsub.sns.internal.core.data.source.dynamic.h.h(r9, r1, r4, r5, r7)
            if (r9 != r0) goto L_0x0057
            return r0
        L_0x0057:
            r1 = r8
        L_0x0058:
            com.sumsub.sns.internal.core.data.source.dynamic.e r9 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r9
            java.lang.Object r9 = r9.d()
            com.sumsub.sns.internal.core.data.model.e r9 = (com.sumsub.sns.internal.core.data.model.e) r9
            if (r9 != 0) goto L_0x0063
            return r7
        L_0x0063:
            com.sumsub.sns.core.data.model.FlowType r9 = r9.y()
            com.sumsub.sns.core.data.model.FlowType r5 = com.sumsub.sns.core.data.model.FlowType.Actions
            if (r9 != r5) goto L_0x00b5
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r1.f32966b
            r4.f32973a = r7
            r4.f32976d = r3
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r9 = com.sumsub.sns.internal.core.data.source.dynamic.h.a(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x007c
            return r0
        L_0x007c:
            com.sumsub.sns.internal.core.data.source.dynamic.e r9 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r9
            java.lang.Object r9 = r9.d()
            com.sumsub.sns.internal.core.data.model.g r9 = (com.sumsub.sns.internal.core.data.model.g) r9
            if (r9 != 0) goto L_0x0087
            return r7
        L_0x0087:
            com.sumsub.sns.internal.core.data.model.g$c r9 = r9.I()
            java.util.List r9 = r9.g()
            java.util.Iterator r9 = r9.iterator()
        L_0x0093:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto L_0x00ab
            java.lang.Object r0 = r9.next()
            r1 = r0
            com.sumsub.sns.internal.core.data.model.g$c$a r1 = (com.sumsub.sns.internal.core.data.model.g.c.a) r1
            com.sumsub.sns.internal.core.data.model.DocumentType r1 = r1.m()
            boolean r1 = r1.j()
            if (r1 == 0) goto L_0x0093
            goto L_0x00ac
        L_0x00ab:
            r0 = r7
        L_0x00ac:
            com.sumsub.sns.internal.core.data.model.g$c$a r0 = (com.sumsub.sns.internal.core.data.model.g.c.a) r0
            if (r0 == 0) goto L_0x00b4
            java.lang.String r7 = r0.n()
        L_0x00b4:
            return r7
        L_0x00b5:
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r1.f32966b
            r4.f32973a = r7
            r4.f32976d = r2
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r9 = com.sumsub.sns.internal.core.data.source.dynamic.h.g(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x00c6
            return r0
        L_0x00c6:
            com.sumsub.sns.internal.core.data.source.dynamic.e r9 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r9
            java.lang.Object r9 = r9.d()
            com.sumsub.sns.internal.core.data.model.g r9 = (com.sumsub.sns.internal.core.data.model.g) r9
            if (r9 != 0) goto L_0x00d1
            return r7
        L_0x00d1:
            com.sumsub.sns.internal.core.data.model.DocumentType r0 = new com.sumsub.sns.internal.core.data.model.DocumentType
            java.lang.String r1 = "QUESTIONNAIRE"
            r0.<init>(r1)
            com.sumsub.sns.internal.core.data.model.g$c$a r9 = r9.a((com.sumsub.sns.internal.core.data.model.DocumentType) r0)
            if (r9 == 0) goto L_0x00e7
            java.lang.String r0 = r9.o()
            if (r0 != 0) goto L_0x00e5
            goto L_0x00e7
        L_0x00e5:
            r7 = r0
            goto L_0x00ed
        L_0x00e7:
            if (r9 == 0) goto L_0x00ed
            java.lang.String r7 = r9.n()
        L_0x00ed:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.c(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(kotlin.coroutines.c<? super java.lang.String> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.core.data.source.applicant.c$a r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.a) r0
            int r1 = r0.f32969c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32969c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$a r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$a
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f32967a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f32969c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r4) goto L_0x002a
            kotlin.k.b(r6)
            goto L_0x0041
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0032:
            kotlin.k.b(r6)
            com.sumsub.sns.internal.core.data.source.dynamic.b r6 = r5.f32966b
            r0.f32969c = r4
            r2 = 0
            java.lang.Object r6 = com.sumsub.sns.internal.core.data.source.dynamic.h.h(r6, r2, r0, r4, r3)
            if (r6 != r1) goto L_0x0041
            return r1
        L_0x0041:
            com.sumsub.sns.internal.core.data.source.dynamic.e r6 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r6
            java.lang.Object r6 = r6.d()
            com.sumsub.sns.internal.core.data.model.e r6 = (com.sumsub.sns.internal.core.data.model.e) r6
            if (r6 == 0) goto L_0x0055
            com.sumsub.sns.internal.core.data.model.e$a r6 = r6.r()
            if (r6 == 0) goto L_0x0055
            java.lang.String r3 = r6.c()
        L_0x0055:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.d(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super java.lang.String> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.core.data.source.applicant.c$b r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.b) r0
            int r1 = r0.f32972c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32972c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$b r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$b
            r0.<init>(r7, r8)
        L_0x0018:
            r4 = r0
            java.lang.Object r8 = r4.f32970a
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r4.f32972c
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.k.b(r8)
            goto L_0x0044
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0032:
            kotlin.k.b(r8)
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r7.f32966b
            r4.f32972c = r2
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            java.lang.Object r8 = com.sumsub.sns.internal.core.data.source.dynamic.h.g(r1, r2, r3, r4, r5, r6)
            if (r8 != r0) goto L_0x0044
            return r0
        L_0x0044:
            com.sumsub.sns.internal.core.data.source.dynamic.e r8 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r8
            java.lang.Object r8 = r8.d()
            com.sumsub.sns.internal.core.data.model.g r8 = (com.sumsub.sns.internal.core.data.model.g) r8
            if (r8 == 0) goto L_0x0053
            java.lang.String r8 = r8.B()
            goto L_0x0054
        L_0x0053:
            r8 = 0
        L_0x0054:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.e(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.k
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.data.source.applicant.c$k r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.k) r0
            int r1 = r0.f33003e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33003e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$k r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$k
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f33001c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33003e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r7)
            goto L_0x0065
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f33000b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r2 = r0.f32999a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r7)
            goto L_0x0051
        L_0x0040:
            kotlin.k.b(r7)
            r0.f32999a = r5
            r0.f33000b = r6
            r0.f33003e = r4
            java.lang.Object r7 = r5.e(r0)
            if (r7 != r1) goto L_0x0050
            return r1
        L_0x0050:
            r2 = r5
        L_0x0051:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0065
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r4 = 0
            r0.f32999a = r4
            r0.f33000b = r4
            r0.f33003e = r3
            java.lang.Object r6 = r2.a((java.lang.String) r7, (java.lang.String) r6, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r6 != r1) goto L_0x0065
            return r1
        L_0x0065:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.a(java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0091 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(kotlin.coroutines.c<? super java.lang.Boolean> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.l
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.core.data.source.applicant.c$l r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.l) r0
            int r1 = r0.f33007d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33007d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$l r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$l
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f33005b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33007d
            r3 = 0
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            if (r2 == 0) goto L_0x005f
            if (r2 == r8) goto L_0x0057
            if (r2 == r7) goto L_0x004f
            if (r2 == r6) goto L_0x0047
            if (r2 == r5) goto L_0x003f
            if (r2 != r4) goto L_0x0037
            kotlin.k.b(r10)
            goto L_0x00c2
        L_0x0037:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x003f:
            java.lang.Object r2 = r0.f33004a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r10)
            goto L_0x00b0
        L_0x0047:
            java.lang.Object r0 = r0.f33004a
            com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0
            kotlin.k.b(r10)
            goto L_0x0093
        L_0x004f:
            java.lang.Object r2 = r0.f33004a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r10)
            goto L_0x007f
        L_0x0057:
            java.lang.Object r2 = r0.f33004a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r10)
            goto L_0x006e
        L_0x005f:
            kotlin.k.b(r10)
            r0.f33004a = r9
            r0.f33007d = r8
            java.lang.Object r10 = r9.d(r0)
            if (r10 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r2 = r9
        L_0x006e:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x00a5
            com.sumsub.sns.internal.core.data.source.applicant.a r4 = r2.f32965a
            r0.f33004a = r2
            r0.f33007d = r7
            java.lang.Object r10 = r4.f(r10, r0)
            if (r10 != r1) goto L_0x007f
            return r1
        L_0x007f:
            com.sumsub.sns.internal.core.data.model.remote.response.d$c$d r10 = (com.sumsub.sns.internal.core.data.model.remote.response.d.c.C0351d) r10
            com.sumsub.sns.internal.core.data.model.g r10 = com.sumsub.sns.internal.core.data.model.remote.response.e.b(r10)
            com.sumsub.sns.internal.core.data.source.dynamic.b r2 = r2.f32966b
            r0.f33004a = r10
            r0.f33007d = r6
            java.lang.Object r0 = r2.b((com.sumsub.sns.internal.core.data.model.g) r10, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r0 != r1) goto L_0x0092
            return r1
        L_0x0092:
            r0 = r10
        L_0x0093:
            com.sumsub.sns.internal.core.data.model.g$d r10 = r0.J()
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r10 = r10.p()
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r0 = com.sumsub.sns.internal.core.data.model.ReviewStatusType.Pending
            if (r10 != r0) goto L_0x00a0
            r3 = r8
        L_0x00a0:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r10
        L_0x00a5:
            r0.f33004a = r2
            r0.f33007d = r5
            java.lang.Object r10 = r2.e(r0)
            if (r10 != r1) goto L_0x00b0
            return r1
        L_0x00b0:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x00c8
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r3 = 0
            r0.f33004a = r3
            r0.f33007d = r4
            java.lang.Object r10 = r2.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.Boolean>) r0)
            if (r10 != r1) goto L_0x00c2
            return r1
        L_0x00c2:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r3 = r10.booleanValue()
        L_0x00c8:
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.a.a(r3)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.b(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.sumsub.sns.internal.core.data.model.b r9, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.i
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.core.data.source.applicant.c$i r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.i) r0
            int r1 = r0.f32993e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32993e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$i r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$i
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f32991c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f32993e
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0057
            if (r2 == r6) goto L_0x004b
            if (r2 == r5) goto L_0x0047
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            kotlin.k.b(r10)
            goto L_0x009c
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003b:
            java.lang.Object r9 = r0.f32990b
            com.sumsub.sns.internal.core.data.model.b r9 = (com.sumsub.sns.internal.core.data.model.b) r9
            java.lang.Object r2 = r0.f32989a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r10)
            goto L_0x0089
        L_0x0047:
            kotlin.k.b(r10)
            goto L_0x007b
        L_0x004b:
            java.lang.Object r9 = r0.f32990b
            com.sumsub.sns.internal.core.data.model.b r9 = (com.sumsub.sns.internal.core.data.model.b) r9
            java.lang.Object r2 = r0.f32989a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r10)
            goto L_0x0068
        L_0x0057:
            kotlin.k.b(r10)
            r0.f32989a = r8
            r0.f32990b = r9
            r0.f32993e = r6
            java.lang.Object r10 = r8.d(r0)
            if (r10 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r2 = r8
        L_0x0068:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x007c
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r0.f32989a = r7
            r0.f32990b = r7
            r0.f32993e = r5
            java.lang.Object r10 = r2.b((java.lang.String) r10, (com.sumsub.sns.internal.core.data.model.b) r9, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) r0)
            if (r10 != r1) goto L_0x007b
            return r1
        L_0x007b:
            return r10
        L_0x007c:
            r0.f32989a = r2
            r0.f32990b = r9
            r0.f32993e = r4
            java.lang.Object r10 = r2.e(r0)
            if (r10 != r1) goto L_0x0089
            return r1
        L_0x0089:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x009f
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r0.f32989a = r7
            r0.f32990b = r7
            r0.f32993e = r3
            java.lang.Object r10 = r2.a((java.lang.String) r10, (com.sumsub.sns.internal.core.data.model.b) r9, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) r0)
            if (r10 != r1) goto L_0x009c
            return r1
        L_0x009c:
            r7 = r10
            com.sumsub.sns.internal.core.data.model.g r7 = (com.sumsub.sns.internal.core.data.model.g) r7
        L_0x009f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.a(com.sumsub.sns.internal.core.data.model.b, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.sumsub.sns.internal.core.data.source.applicant.remote.u r9, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.w> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.m
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.core.data.source.applicant.c$m r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.m) r0
            int r1 = r0.f33012e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33012e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$m r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$m
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f33010c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33012e
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r5) goto L_0x003b
            if (r2 == r4) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.k.b(r10)
            goto L_0x008a
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0037:
            kotlin.k.b(r10)
            goto L_0x007a
        L_0x003b:
            java.lang.Object r9 = r0.f33009b
            com.sumsub.sns.internal.core.data.source.applicant.remote.u r9 = (com.sumsub.sns.internal.core.data.source.applicant.remote.u) r9
            java.lang.Object r2 = r0.f33008a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r10)
            goto L_0x0058
        L_0x0047:
            kotlin.k.b(r10)
            r0.f33008a = r8
            r0.f33009b = r9
            r0.f33012e = r5
            java.lang.Object r10 = r8.d(r0)
            if (r10 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r2 = r8
        L_0x0058:
            java.lang.String r10 = (java.lang.String) r10
            r6 = 0
            if (r10 == 0) goto L_0x007b
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            com.sumsub.sns.internal.core.data.source.applicant.remote.y r3 = new com.sumsub.sns.internal.core.data.source.applicant.remote.y
            com.sumsub.sns.internal.core.data.source.applicant.remote.u[] r5 = new com.sumsub.sns.internal.core.data.source.applicant.remote.u[r5]
            r7 = 0
            r5[r7] = r9
            java.util.List r9 = kotlin.collections.CollectionsKt__CollectionsKt.p(r5)
            r3.<init>(r10, r9)
            r0.f33008a = r6
            r0.f33009b = r6
            r0.f33012e = r4
            java.lang.Object r10 = r2.a((com.sumsub.sns.internal.core.data.source.applicant.remote.y) r3, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.w>) r0)
            if (r10 != r1) goto L_0x007a
            return r1
        L_0x007a:
            return r10
        L_0x007b:
            com.sumsub.sns.internal.core.data.source.applicant.a r10 = r2.f32965a
            r0.f33008a = r6
            r0.f33009b = r6
            r0.f33012e = r3
            java.lang.Object r10 = r10.a((com.sumsub.sns.internal.core.data.source.applicant.remote.u) r9, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.w>) r0)
            if (r10 != r1) goto L_0x008a
            return r1
        L_0x008a:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.a(com.sumsub.sns.internal.core.data.source.applicant.remote.u, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(int r8, kotlin.coroutines.c<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.h
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.core.data.source.applicant.c$h r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.h) r0
            int r1 = r0.f32988e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32988e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$h r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$h
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f32986c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f32988e
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r6) goto L_0x004c
            if (r2 == r5) goto L_0x0048
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r8 = r0.f32984a
            java.lang.String r8 = (java.lang.String) r8
            kotlin.k.b(r9)
            goto L_0x009a
        L_0x0036:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003e:
            int r8 = r0.f32985b
            java.lang.Object r2 = r0.f32984a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r9)
            goto L_0x0089
        L_0x0048:
            kotlin.k.b(r9)
            goto L_0x0079
        L_0x004c:
            int r8 = r0.f32985b
            java.lang.Object r2 = r0.f32984a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r9)
            goto L_0x0067
        L_0x0056:
            kotlin.k.b(r9)
            r0.f32984a = r7
            r0.f32985b = r8
            r0.f32988e = r6
            java.lang.Object r9 = r7.d(r0)
            if (r9 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r7
        L_0x0067:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x007c
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r3 = 0
            r0.f32984a = r3
            r0.f32988e = r5
            java.lang.Object r8 = r2.b((java.lang.String) r9, (int) r8, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r8 != r1) goto L_0x0079
            return r1
        L_0x0079:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        L_0x007c:
            r0.f32984a = r2
            r0.f32985b = r8
            r0.f32988e = r4
            java.lang.Object r9 = r2.e(r0)
            if (r9 != r1) goto L_0x0089
            return r1
        L_0x0089:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x009a
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r0.f32984a = r9
            r0.f32988e = r3
            java.lang.Object r8 = r2.a((java.lang.String) r9, (int) r8, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r8 != r1) goto L_0x009a
            return r1
        L_0x009a:
            kotlin.Unit r8 = kotlin.Unit.f56620a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.a(int, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r18, java.io.InputStream r19, java.lang.String r20, com.sumsub.sns.internal.core.data.model.IdentitySide r21, java.util.Map<java.lang.String, java.lang.String> r22, com.sumsub.sns.internal.core.data.model.DocumentType r23, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.k> r24) {
        /*
            r17 = this;
            r0 = r17
            r1 = r24
            boolean r2 = r1 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.n
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.core.data.source.applicant.c$n r2 = (com.sumsub.sns.internal.core.data.source.applicant.c.n) r2
            int r3 = r2.f33022j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f33022j = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.data.source.applicant.c$n r2 = new com.sumsub.sns.internal.core.data.source.applicant.c$n
            r2.<init>(r0, r1)
        L_0x001c:
            r11 = r2
            java.lang.Object r1 = r11.f33020h
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r11.f33022j
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L_0x0098
            if (r3 == r7) goto L_0x0070
            if (r3 == r6) goto L_0x006b
            if (r3 == r5) goto L_0x0041
            if (r3 != r4) goto L_0x0039
            kotlin.k.b(r1)
            goto L_0x0125
        L_0x0039:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0041:
            java.lang.Object r3 = r11.f33019g
            com.sumsub.sns.internal.core.data.model.DocumentType r3 = (com.sumsub.sns.internal.core.data.model.DocumentType) r3
            java.lang.Object r5 = r11.f33018f
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r11.f33017e
            com.sumsub.sns.internal.core.data.model.IdentitySide r6 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r6
            java.lang.Object r7 = r11.f33016d
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r9 = r11.f33015c
            java.io.InputStream r9 = (java.io.InputStream) r9
            java.lang.Object r10 = r11.f33014b
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r12 = r11.f33013a
            com.sumsub.sns.internal.core.data.source.applicant.c r12 = (com.sumsub.sns.internal.core.data.source.applicant.c) r12
            kotlin.k.b(r1)
            r14 = r3
            r15 = r10
            r10 = r5
            r5 = r15
            r16 = r9
            r9 = r6
            r6 = r16
            goto L_0x0104
        L_0x006b:
            kotlin.k.b(r1)
            goto L_0x00e9
        L_0x0070:
            java.lang.Object r3 = r11.f33019g
            com.sumsub.sns.internal.core.data.model.DocumentType r3 = (com.sumsub.sns.internal.core.data.model.DocumentType) r3
            java.lang.Object r7 = r11.f33018f
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r9 = r11.f33017e
            com.sumsub.sns.internal.core.data.model.IdentitySide r9 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r9
            java.lang.Object r10 = r11.f33016d
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r12 = r11.f33015c
            java.io.InputStream r12 = (java.io.InputStream) r12
            java.lang.Object r13 = r11.f33014b
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r14 = r11.f33013a
            com.sumsub.sns.internal.core.data.source.applicant.c r14 = (com.sumsub.sns.internal.core.data.source.applicant.c) r14
            kotlin.k.b(r1)
            r15 = r14
            r14 = r3
            r3 = r15
            r16 = r10
            r10 = r7
            r7 = r16
            goto L_0x00c6
        L_0x0098:
            kotlin.k.b(r1)
            r11.f33013a = r0
            r1 = r18
            r11.f33014b = r1
            r3 = r19
            r11.f33015c = r3
            r9 = r20
            r11.f33016d = r9
            r10 = r21
            r11.f33017e = r10
            r12 = r22
            r11.f33018f = r12
            r13 = r23
            r11.f33019g = r13
            r11.f33022j = r7
            java.lang.Object r7 = r0.d(r11)
            if (r7 != r2) goto L_0x00be
            return r2
        L_0x00be:
            r14 = r13
            r13 = r1
            r1 = r7
            r7 = r9
            r9 = r10
            r10 = r12
            r12 = r3
            r3 = r0
        L_0x00c6:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x00ea
            com.sumsub.sns.internal.core.data.source.applicant.a r3 = r3.f32965a
            r11.f33013a = r8
            r11.f33014b = r8
            r11.f33015c = r8
            r11.f33016d = r8
            r11.f33017e = r8
            r11.f33018f = r8
            r11.f33019g = r8
            r11.f33022j = r6
            r4 = r1
            r5 = r13
            r6 = r12
            r8 = r9
            r9 = r10
            r10 = r14
            java.lang.Object r1 = r3.b(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r1 != r2) goto L_0x00e9
            return r2
        L_0x00e9:
            return r1
        L_0x00ea:
            r11.f33013a = r3
            r11.f33014b = r13
            r11.f33015c = r12
            r11.f33016d = r7
            r11.f33017e = r9
            r11.f33018f = r10
            r11.f33019g = r14
            r11.f33022j = r5
            java.lang.Object r1 = r3.e(r11)
            if (r1 != r2) goto L_0x0101
            return r2
        L_0x0101:
            r6 = r12
            r5 = r13
            r12 = r3
        L_0x0104:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0128
            com.sumsub.sns.internal.core.data.source.applicant.a r3 = r12.f32965a
            r11.f33013a = r8
            r11.f33014b = r8
            r11.f33015c = r8
            r11.f33016d = r8
            r11.f33017e = r8
            r11.f33018f = r8
            r11.f33019g = r8
            r11.f33022j = r4
            r4 = r1
            r8 = r9
            r9 = r10
            r10 = r14
            java.lang.Object r1 = r3.a(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r1 != r2) goto L_0x0125
            return r2
        L_0x0125:
            r8 = r1
            com.sumsub.sns.internal.core.data.model.remote.k r8 = (com.sumsub.sns.internal.core.data.model.remote.k) r8
        L_0x0128:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.a(java.lang.String, java.io.InputStream, java.lang.String, com.sumsub.sns.internal.core.data.model.IdentitySide, java.util.Map, com.sumsub.sns.internal.core.data.model.DocumentType, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r19, java.io.File r20, java.lang.String r21, com.sumsub.sns.internal.core.data.model.IdentitySide r22, java.util.Map<java.lang.String, java.lang.String> r23, com.sumsub.sns.internal.core.data.model.DocumentType r24, com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a.C0361a r25, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.remote.k> r26) {
        /*
            r18 = this;
            r0 = r18
            r1 = r26
            boolean r2 = r1 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.o
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.core.data.source.applicant.c$o r2 = (com.sumsub.sns.internal.core.data.source.applicant.c.o) r2
            int r3 = r2.f33033k
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f33033k = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.data.source.applicant.c$o r2 = new com.sumsub.sns.internal.core.data.source.applicant.c$o
            r2.<init>(r0, r1)
        L_0x001c:
            r12 = r2
            java.lang.Object r1 = r12.f33031i
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r12.f33033k
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r3 == 0) goto L_0x00a6
            if (r3 == r7) goto L_0x0078
            if (r3 == r6) goto L_0x0073
            if (r3 == r5) goto L_0x0041
            if (r3 != r4) goto L_0x0039
            kotlin.k.b(r1)
            goto L_0x013d
        L_0x0039:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0041:
            java.lang.Object r3 = r12.f33030h
            com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a$a r3 = (com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a.C0361a) r3
            java.lang.Object r5 = r12.f33029g
            com.sumsub.sns.internal.core.data.model.DocumentType r5 = (com.sumsub.sns.internal.core.data.model.DocumentType) r5
            java.lang.Object r6 = r12.f33028f
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r7 = r12.f33027e
            com.sumsub.sns.internal.core.data.model.IdentitySide r7 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r7
            java.lang.Object r9 = r12.f33026d
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r12.f33025c
            java.io.File r10 = (java.io.File) r10
            java.lang.Object r11 = r12.f33024b
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r13 = r12.f33023a
            com.sumsub.sns.internal.core.data.source.applicant.c r13 = (com.sumsub.sns.internal.core.data.source.applicant.c) r13
            kotlin.k.b(r1)
            r15 = r3
            r16 = r11
            r11 = r5
            r5 = r16
            r17 = r9
            r9 = r6
            r6 = r10
            r10 = r7
            r7 = r17
            goto L_0x011a
        L_0x0073:
            kotlin.k.b(r1)
            goto L_0x00fd
        L_0x0078:
            java.lang.Object r3 = r12.f33030h
            com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a$a r3 = (com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a.C0361a) r3
            java.lang.Object r7 = r12.f33029g
            com.sumsub.sns.internal.core.data.model.DocumentType r7 = (com.sumsub.sns.internal.core.data.model.DocumentType) r7
            java.lang.Object r9 = r12.f33028f
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r10 = r12.f33027e
            com.sumsub.sns.internal.core.data.model.IdentitySide r10 = (com.sumsub.sns.internal.core.data.model.IdentitySide) r10
            java.lang.Object r11 = r12.f33026d
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r13 = r12.f33025c
            java.io.File r13 = (java.io.File) r13
            java.lang.Object r14 = r12.f33024b
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r12.f33023a
            com.sumsub.sns.internal.core.data.source.applicant.c r15 = (com.sumsub.sns.internal.core.data.source.applicant.c) r15
            kotlin.k.b(r1)
            r16 = r15
            r15 = r3
            r3 = r16
            r17 = r11
            r11 = r7
            r7 = r17
            goto L_0x00d8
        L_0x00a6:
            kotlin.k.b(r1)
            r12.f33023a = r0
            r1 = r19
            r12.f33024b = r1
            r3 = r20
            r12.f33025c = r3
            r9 = r21
            r12.f33026d = r9
            r10 = r22
            r12.f33027e = r10
            r11 = r23
            r12.f33028f = r11
            r13 = r24
            r12.f33029g = r13
            r14 = r25
            r12.f33030h = r14
            r12.f33033k = r7
            java.lang.Object r7 = r0.d(r12)
            if (r7 != r2) goto L_0x00d0
            return r2
        L_0x00d0:
            r15 = r14
            r14 = r1
            r1 = r7
            r7 = r9
            r9 = r11
            r11 = r13
            r13 = r3
            r3 = r0
        L_0x00d8:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x00fe
            com.sumsub.sns.internal.core.data.source.applicant.a r3 = r3.f32965a
            r12.f33023a = r8
            r12.f33024b = r8
            r12.f33025c = r8
            r12.f33026d = r8
            r12.f33027e = r8
            r12.f33028f = r8
            r12.f33029g = r8
            r12.f33030h = r8
            r12.f33033k = r6
            r4 = r1
            r5 = r14
            r6 = r13
            r8 = r10
            r10 = r11
            r11 = r15
            java.lang.Object r1 = r3.b(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r1 != r2) goto L_0x00fd
            return r2
        L_0x00fd:
            return r1
        L_0x00fe:
            r12.f33023a = r3
            r12.f33024b = r14
            r12.f33025c = r13
            r12.f33026d = r7
            r12.f33027e = r10
            r12.f33028f = r9
            r12.f33029g = r11
            r12.f33030h = r15
            r12.f33033k = r5
            java.lang.Object r1 = r3.e(r12)
            if (r1 != r2) goto L_0x0117
            return r2
        L_0x0117:
            r6 = r13
            r5 = r14
            r13 = r3
        L_0x011a:
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x0140
            com.sumsub.sns.internal.core.data.source.applicant.a r3 = r13.f32965a
            r12.f33023a = r8
            r12.f33024b = r8
            r12.f33025c = r8
            r12.f33026d = r8
            r12.f33027e = r8
            r12.f33028f = r8
            r12.f33029g = r8
            r12.f33030h = r8
            r12.f33033k = r4
            r4 = r1
            r8 = r10
            r10 = r11
            r11 = r15
            java.lang.Object r1 = r3.a(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            if (r1 != r2) goto L_0x013d
            return r2
        L_0x013d:
            r8 = r1
            com.sumsub.sns.internal.core.data.model.remote.k r8 = (com.sumsub.sns.internal.core.data.model.remote.k) r8
        L_0x0140:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.a(java.lang.String, java.io.File, java.lang.String, com.sumsub.sns.internal.core.data.model.IdentitySide, java.util.Map, com.sumsub.sns.internal.core.data.model.DocumentType, com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a$a, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.coroutines.c<? super d10.l<? super java.lang.String, java.lang.String>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.d
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.core.data.source.applicant.c$d r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.d) r0
            int r1 = r0.f32980d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32980d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$d r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$d
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f32978b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f32980d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r6)
            goto L_0x0061
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r0.f32977a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r6)
            goto L_0x004b
        L_0x003c:
            kotlin.k.b(r6)
            r0.f32977a = r5
            r0.f32980d = r4
            java.lang.Object r6 = r5.d(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r2 = r5
        L_0x004b:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x0055
            com.sumsub.sns.internal.core.data.source.applicant.c$e r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$e
            r0.<init>(r6)
            return r0
        L_0x0055:
            r6 = 0
            r0.f32977a = r6
            r0.f32980d = r3
            java.lang.Object r6 = r2.e(r0)
            if (r6 != r1) goto L_0x0061
            return r1
        L_0x0061:
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x006b
            com.sumsub.sns.internal.core.data.source.applicant.c$f r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$f
            r0.<init>(r6)
            return r0
        L_0x006b:
            com.sumsub.sns.internal.core.data.source.applicant.c$g r6 = com.sumsub.sns.internal.core.data.source.applicant.c.g.f32983a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.a(kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.sumsub.sns.internal.core.data.source.applicant.remote.a0 r9, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.b0> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.j
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.core.data.source.applicant.c$j r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.j) r0
            int r1 = r0.f32998e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f32998e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$j r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$j
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f32996c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f32998e
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0057
            if (r2 == r6) goto L_0x004b
            if (r2 == r5) goto L_0x0047
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            kotlin.k.b(r10)
            goto L_0x009c
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003b:
            java.lang.Object r9 = r0.f32995b
            com.sumsub.sns.internal.core.data.source.applicant.remote.a0 r9 = (com.sumsub.sns.internal.core.data.source.applicant.remote.a0) r9
            java.lang.Object r2 = r0.f32994a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r10)
            goto L_0x0089
        L_0x0047:
            kotlin.k.b(r10)
            goto L_0x007b
        L_0x004b:
            java.lang.Object r9 = r0.f32995b
            com.sumsub.sns.internal.core.data.source.applicant.remote.a0 r9 = (com.sumsub.sns.internal.core.data.source.applicant.remote.a0) r9
            java.lang.Object r2 = r0.f32994a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r10)
            goto L_0x0068
        L_0x0057:
            kotlin.k.b(r10)
            r0.f32994a = r8
            r0.f32995b = r9
            r0.f32998e = r6
            java.lang.Object r10 = r8.d(r0)
            if (r10 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r2 = r8
        L_0x0068:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x007c
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r0.f32994a = r7
            r0.f32995b = r7
            r0.f32998e = r5
            java.lang.Object r10 = r2.b((java.lang.String) r10, (com.sumsub.sns.internal.core.data.source.applicant.remote.a0) r9, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.b0>) r0)
            if (r10 != r1) goto L_0x007b
            return r1
        L_0x007b:
            return r10
        L_0x007c:
            r0.f32994a = r2
            r0.f32995b = r9
            r0.f32998e = r4
            java.lang.Object r10 = r2.e(r0)
            if (r10 != r1) goto L_0x0089
            return r1
        L_0x0089:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 == 0) goto L_0x00a1
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r0.f32994a = r7
            r0.f32995b = r7
            r0.f32998e = r3
            java.lang.Object r10 = r2.a((java.lang.String) r10, (com.sumsub.sns.internal.core.data.source.applicant.remote.a0) r9, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.b0>) r0)
            if (r10 != r1) goto L_0x009c
            return r1
        L_0x009c:
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r10 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r10
            if (r10 == 0) goto L_0x00a1
            return r10
        L_0x00a1:
            com.sumsub.sns.core.data.model.SNSException$Unknown r9 = new com.sumsub.sns.core.data.model.SNSException$Unknown
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Applicant id missing"
            r10.<init>(r0)
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.a(com.sumsub.sns.internal.core.data.source.applicant.remote.a0, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.String r10, java.lang.String r11, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.b0> r12) {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.core.data.source.applicant.c.p
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.core.data.source.applicant.c$p r0 = (com.sumsub.sns.internal.core.data.source.applicant.c.p) r0
            int r1 = r0.f33039f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33039f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.applicant.c$p r0 = new com.sumsub.sns.internal.core.data.source.applicant.c$p
            r0.<init>(r9, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f33037d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33039f
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0061
            if (r2 == r6) goto L_0x0050
            if (r2 == r5) goto L_0x004c
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            kotlin.k.b(r12)
            goto L_0x00b1
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            java.lang.Object r10 = r0.f33036c
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r0.f33035b
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r2 = r0.f33034a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r12)
            goto L_0x009c
        L_0x004c:
            kotlin.k.b(r12)
            goto L_0x0089
        L_0x0050:
            java.lang.Object r10 = r0.f33036c
            r11 = r10
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r10 = r0.f33035b
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = r0.f33034a
            com.sumsub.sns.internal.core.data.source.applicant.c r2 = (com.sumsub.sns.internal.core.data.source.applicant.c) r2
            kotlin.k.b(r12)
            goto L_0x0074
        L_0x0061:
            kotlin.k.b(r12)
            r0.f33034a = r9
            r0.f33035b = r10
            r0.f33036c = r11
            r0.f33039f = r6
            java.lang.Object r12 = r9.d(r0)
            if (r12 != r1) goto L_0x0073
            return r1
        L_0x0073:
            r2 = r9
        L_0x0074:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x008a
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r0.f33034a = r7
            r0.f33035b = r7
            r0.f33036c = r7
            r0.f33039f = r5
            java.lang.Object r12 = r2.b(r12, r10, r11, r0)
            if (r12 != r1) goto L_0x0089
            return r1
        L_0x0089:
            return r12
        L_0x008a:
            r0.f33034a = r2
            r0.f33035b = r10
            r0.f33036c = r11
            r0.f33039f = r4
            java.lang.Object r12 = r2.e(r0)
            if (r12 != r1) goto L_0x0099
            return r1
        L_0x0099:
            r8 = r11
            r11 = r10
            r10 = r8
        L_0x009c:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 == 0) goto L_0x00b6
            com.sumsub.sns.internal.core.data.source.applicant.a r2 = r2.f32965a
            r0.f33034a = r7
            r0.f33035b = r7
            r0.f33036c = r7
            r0.f33039f = r3
            java.lang.Object r12 = r2.a((java.lang.String) r12, (java.lang.String) r11, (java.lang.String) r10, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.b0>) r0)
            if (r12 != r1) goto L_0x00b1
            return r1
        L_0x00b1:
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r12 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r12
            if (r12 == 0) goto L_0x00b6
            return r12
        L_0x00b6:
            com.sumsub.sns.core.data.model.SNSException$Unknown r10 = new com.sumsub.sns.core.data.model.SNSException$Unknown
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "Applicant id missing"
            r11.<init>(r12)
            r10.<init>(r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.c.a(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
