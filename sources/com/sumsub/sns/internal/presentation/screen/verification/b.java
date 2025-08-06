package com.sumsub.sns.internal.presentation.screen.verification;

import androidx.lifecycle.m0;
import com.sumsub.sns.core.data.listener.SNSEvent;
import com.sumsub.sns.core.data.listener.SNSEventHandler;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.data.model.ApplicantStatus;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.ReviewStatusType;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v1;

public final class b extends com.sumsub.sns.core.presentation.base.a<d> {
    public static final long A = 3000;
    public static final String B = "SNSApplicantStatusViewModel";

    /* renamed from: y  reason: collision with root package name */
    public static final a f36338y = new a((r) null);

    /* renamed from: z  reason: collision with root package name */
    public static final int f36339z = 3;

    /* renamed from: q  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f36340q;

    /* renamed from: r  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.domain.p f36341r;

    /* renamed from: s  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f36342s;

    /* renamed from: t  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.applicant.b f36343t;

    /* renamed from: u  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.extensions.a f36344u;

    /* renamed from: v  reason: collision with root package name */
    public com.sumsub.sns.internal.core.data.model.g f36345v;

    /* renamed from: w  reason: collision with root package name */
    public List<Document> f36346w;

    /* renamed from: x  reason: collision with root package name */
    public ApplicantStatus f36347x;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public a() {
        }
    }

    /* renamed from: com.sumsub.sns.internal.presentation.screen.verification.b$b  reason: collision with other inner class name */
    public static final class C0486b implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final String f36348a;

        public C0486b(String str) {
            this.f36348a = str;
        }

        public final String a() {
            return this.f36348a;
        }

        public final String b() {
            return this.f36348a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0486b) && x.b(this.f36348a, ((C0486b) obj).f36348a);
        }

        public int hashCode() {
            return this.f36348a.hashCode();
        }

        public String toString() {
            return "ShowAgreementEvent(text=" + this.f36348a + ')';
        }

        public final C0486b a(String str) {
            return new C0486b(str);
        }

        public static /* synthetic */ C0486b a(C0486b bVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = bVar.f36348a;
            }
            return bVar.a(str);
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36349a;

        static {
            int[] iArr = new int[ReviewStatusType.values().length];
            iArr[ReviewStatusType.Completed.ordinal()] = 1;
            iArr[ReviewStatusType.Queued.ordinal()] = 2;
            iArr[ReviewStatusType.Pending.ordinal()] = 3;
            f36349a = iArr;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel", f = "SNSApplicantStatusViewModel.kt", l = {364, 365, 367, 377, 378, 379}, m = "buildVideoIdentState")
    public static final class d extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36350a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36351b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36352c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36353d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36354e;

        /* renamed from: f  reason: collision with root package name */
        public /* synthetic */ Object f36355f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f36356g;

        /* renamed from: h  reason: collision with root package name */
        public int f36357h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, kotlin.coroutines.c<? super d> cVar) {
            super(cVar);
            this.f36356g = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36355f = obj;
            this.f36357h |= Integer.MIN_VALUE;
            return this.f36356g.e(this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel", f = "SNSApplicantStatusViewModel.kt", l = {113, 116}, m = "checkDocuments")
    public static final class e extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36358a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36359b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f36360c;

        /* renamed from: d  reason: collision with root package name */
        public int f36361d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b bVar, kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
            this.f36360c = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36359b = obj;
            this.f36361d |= Integer.MIN_VALUE;
            return this.f36360c.a((com.sumsub.sns.internal.core.data.model.e) null, (com.sumsub.sns.internal.core.data.model.g) null, (List<Document>) null, this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel", f = "SNSApplicantStatusViewModel.kt", l = {344, 345}, m = "createVideoIdentificationViewItem")
    public static final class f extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36362a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36363b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36364c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f36365d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f36366e;

        /* renamed from: f  reason: collision with root package name */
        public int f36367f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(b bVar, kotlin.coroutines.c<? super f> cVar) {
            super(cVar);
            this.f36366e = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36365d = obj;
            this.f36367f |= Integer.MIN_VALUE;
            return this.f36366e.a((List<Document>) null, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.base.adapter.c>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel$onContinueClicked$1", f = "SNSApplicantStatusViewModel.kt", l = {526, 527, 528}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36368a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36369b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.data.model.g f36370c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(b bVar, com.sumsub.sns.internal.core.data.model.g gVar, kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
            this.f36369b = bVar;
            this.f36370c = gVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((g) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.f36369b, this.f36370c, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x007e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r11.f36368a
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x002a
                if (r1 == r4) goto L_0x0026
                if (r1 == r3) goto L_0x0022
                if (r1 != r2) goto L_0x001a
                kotlin.k.b(r12)
                kotlin.Result r12 = (kotlin.Result) r12
                r12.m3081unboximpl()
                goto L_0x0081
            L_0x001a:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r0)
                throw r12
            L_0x0022:
                kotlin.k.b(r12)
                goto L_0x004b
            L_0x0026:
                kotlin.k.b(r12)
                goto L_0x0038
            L_0x002a:
                kotlin.k.b(r12)
                com.sumsub.sns.internal.presentation.screen.verification.b r12 = r11.f36369b
                r11.f36368a = r4
                java.lang.Object r12 = r12.f(r11)
                if (r12 != r0) goto L_0x0038
                return r0
            L_0x0038:
                java.lang.Boolean r12 = (java.lang.Boolean) r12
                boolean r12 = r12.booleanValue()
                if (r12 != 0) goto L_0x0081
                com.sumsub.sns.internal.presentation.screen.verification.b r12 = r11.f36369b
                r11.f36368a = r3
                java.lang.Object r12 = r12.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r11)
                if (r12 != r0) goto L_0x004b
                return r0
            L_0x004b:
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r12 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12
                java.util.List r12 = r12.c()
                if (r12 == 0) goto L_0x007e
                java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r12)
                com.sumsub.sns.internal.core.data.model.d r12 = (com.sumsub.sns.internal.core.data.model.d) r12
                if (r12 == 0) goto L_0x007e
                com.sumsub.sns.internal.core.data.model.b r6 = r12.c()
                if (r6 != 0) goto L_0x0062
                goto L_0x007e
            L_0x0062:
                com.sumsub.sns.internal.presentation.screen.verification.b r12 = r11.f36369b
                com.sumsub.sns.internal.core.domain.p r3 = r12.f36341r
                com.sumsub.sns.internal.presentation.screen.verification.b r12 = r11.f36369b
                com.sumsub.sns.internal.core.data.source.applicant.b r4 = r12.f36343t
                com.sumsub.sns.internal.core.data.model.g r5 = r11.f36370c
                r11.f36368a = r2
                r7 = 0
                r9 = 8
                r10 = 0
                r8 = r11
                java.lang.Object r12 = com.sumsub.sns.internal.core.domain.p.a(r3, r4, r5, r6, r7, r8, r9, r10)
                if (r12 != r0) goto L_0x0081
                return r0
            L_0x007e:
                kotlin.Unit r12 = kotlin.Unit.f56620a
                return r12
            L_0x0081:
                kotlin.Unit r12 = kotlin.Unit.f56620a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.g.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final class h extends Lambda implements d10.l<Document, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final h f36371a = new h();

        public h() {
            super(1);
        }

        /* renamed from: a */
        public final CharSequence invoke(Document document) {
            return document.getType().c();
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel$onPrepare$2", f = "SNSApplicantStatusViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class i extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36372a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b f36373b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel$onPrepare$2$1", f = "SNSApplicantStatusViewModel.kt", l = {83, 84}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements d10.p<b.a, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f36374a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ Object f36375b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ b f36376c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f36376c = bVar;
            }

            /* renamed from: a */
            public final Object invoke(b.a aVar, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                a aVar = new a(this.f36376c, cVar);
                aVar.f36375b = obj;
                return aVar;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v7, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.sumsub.sns.internal.core.data.source.dynamic.b$a} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                    int r1 = r11.f36374a
                    r2 = 2
                    r3 = 1
                    r4 = 0
                    if (r1 == 0) goto L_0x0024
                    if (r1 == r3) goto L_0x001c
                    if (r1 != r2) goto L_0x0014
                    kotlin.k.b(r12)
                    goto L_0x00ad
                L_0x0014:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L_0x001c:
                    java.lang.Object r1 = r11.f36375b
                    com.sumsub.sns.internal.core.data.source.dynamic.b$a r1 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r1
                    kotlin.k.b(r12)
                    goto L_0x006b
                L_0x0024:
                    kotlin.k.b(r12)
                    java.lang.Object r12 = r11.f36375b
                    r1 = r12
                    com.sumsub.sns.internal.core.data.source.dynamic.b$a r1 = (com.sumsub.sns.internal.core.data.source.dynamic.b.a) r1
                    com.sumsub.sns.core.c r5 = com.sumsub.sns.core.c.f30748a
                    r8 = 0
                    r9 = 4
                    r10 = 0
                    java.lang.String r6 = "SNSApplicantStatusViewModel"
                    java.lang.String r7 = "Data repo updated"
                    com.sumsub.sns.core.c.b(r5, r6, r7, r8, r9, r10)
                    if (r1 == 0) goto L_0x003f
                    java.lang.Throwable r12 = r1.k()
                    goto L_0x0040
                L_0x003f:
                    r12 = r4
                L_0x0040:
                    if (r12 == 0) goto L_0x0054
                    com.sumsub.sns.internal.presentation.screen.verification.b r0 = r11.f36376c
                    com.sumsub.sns.core.presentation.base.a$l r0 = r0.c()
                    boolean r0 = r0 instanceof com.sumsub.sns.internal.presentation.screen.verification.d.c
                    if (r0 == 0) goto L_0x0051
                    com.sumsub.sns.internal.presentation.screen.verification.b r0 = r11.f36376c
                    r0.b((java.lang.Throwable) r12)
                L_0x0051:
                    kotlin.Unit r12 = kotlin.Unit.f56620a
                    return r12
                L_0x0054:
                    if (r1 != 0) goto L_0x0059
                    kotlin.Unit r12 = kotlin.Unit.f56620a
                    return r12
                L_0x0059:
                    com.sumsub.sns.internal.presentation.screen.verification.b r12 = r11.f36376c
                    com.sumsub.sns.internal.core.data.source.dynamic.b r12 = r12.f36342s
                    r11.f36375b = r1
                    r11.f36374a = r3
                    r5 = 0
                    java.lang.Object r12 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r12, r5, r11, r3, r4)
                    if (r12 != r0) goto L_0x006b
                    return r0
                L_0x006b:
                    com.sumsub.sns.internal.core.data.source.dynamic.e r12 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r12
                    java.lang.Object r12 = r12.d()
                    com.sumsub.sns.internal.core.data.model.g r12 = (com.sumsub.sns.internal.core.data.model.g) r12
                    com.sumsub.sns.internal.presentation.screen.verification.b r3 = r11.f36376c
                    com.sumsub.sns.internal.core.data.source.dynamic.e r5 = r1.i()
                    java.lang.Object r5 = r5.d()
                    com.sumsub.sns.internal.core.data.model.e r5 = (com.sumsub.sns.internal.core.data.model.e) r5
                    com.sumsub.sns.internal.core.data.source.dynamic.e r1 = r1.j()
                    java.lang.Object r1 = r1.d()
                    com.sumsub.sns.internal.core.data.model.t r1 = (com.sumsub.sns.internal.core.data.model.t) r1
                    if (r1 == 0) goto L_0x00a1
                    java.util.List r1 = r1.d()
                    if (r1 == 0) goto L_0x00a1
                    if (r12 == 0) goto L_0x00a2
                    com.sumsub.sns.internal.core.data.model.m r6 = new com.sumsub.sns.internal.core.data.model.m
                    r6.<init>(r12)
                    java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r1, r6)
                    if (r6 != 0) goto L_0x009f
                    goto L_0x00a2
                L_0x009f:
                    r1 = r6
                    goto L_0x00a2
                L_0x00a1:
                    r1 = r4
                L_0x00a2:
                    r11.f36375b = r4
                    r11.f36374a = r2
                    java.lang.Object r12 = r3.a(r5, r12, r1, r11)
                    if (r12 != r0) goto L_0x00ad
                    return r0
                L_0x00ad:
                    kotlin.Unit r12 = kotlin.Unit.f56620a
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.i.a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(b bVar, kotlin.coroutines.c<? super i> cVar) {
            super(2, cVar);
            this.f36373b = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((i) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new i(this.f36373b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36372a == 0) {
                kotlin.k.b(obj);
                b0.b(this.f36373b.f36342s.b(), m0.a(this.f36373b), new a(this.f36373b, (kotlin.coroutines.c<? super a>) null));
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel$onTermsLinksClicked$1", f = "SNSApplicantStatusViewModel.kt", l = {487, 488, 497, 498}, m = "invokeSuspend")
    public static final class j extends SuspendLambda implements d10.p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36377a;

        /* renamed from: b  reason: collision with root package name */
        public int f36378b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f36379c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f36380d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(String str, b bVar, kotlin.coroutines.c<? super j> cVar) {
            super(2, cVar);
            this.f36379c = str;
            this.f36380d = bVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((j) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new j(this.f36379c, this.f36380d, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:43:0x008a A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x008b A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x0092 A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0094 A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x0097 A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:51:0x00a3 A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x00f5 A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x010c A[Catch:{ Exception -> 0x003d }, RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x010d A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x0113 A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x0114 A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:90:0x011d A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x011f A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x0122 A[Catch:{ Exception -> 0x003d }] */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x0128 A[Catch:{ Exception -> 0x003d }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r9.f36378b
                r2 = 4
                r3 = 3
                r4 = 2
                java.lang.String r5 = ""
                r6 = 0
                r7 = 1
                if (r1 == 0) goto L_0x0040
                if (r1 == r7) goto L_0x0039
                if (r1 == r4) goto L_0x0031
                if (r1 == r3) goto L_0x0028
                if (r1 != r2) goto L_0x0020
                java.lang.Object r0 = r9.f36377a
                java.lang.String r0 = (java.lang.String) r0
                kotlin.k.b(r10)     // Catch:{ Exception -> 0x003d }
                goto L_0x010f
            L_0x0020:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x0028:
                java.lang.Object r1 = r9.f36377a
                com.sumsub.sns.internal.core.data.model.b r1 = (com.sumsub.sns.internal.core.data.model.b) r1
                kotlin.k.b(r10)     // Catch:{ Exception -> 0x003d }
                goto L_0x00f1
            L_0x0031:
                java.lang.Object r0 = r9.f36377a
                java.lang.String r0 = (java.lang.String) r0
                kotlin.k.b(r10)     // Catch:{ Exception -> 0x003d }
                goto L_0x0086
            L_0x0039:
                kotlin.k.b(r10)     // Catch:{ Exception -> 0x003d }
                goto L_0x0070
            L_0x003d:
                r10 = move-exception
                goto L_0x0156
            L_0x0040:
                kotlin.k.b(r10)
                java.lang.String r10 = r9.f36379c     // Catch:{ Exception -> 0x003d }
                int r1 = r10.hashCode()     // Catch:{ Exception -> 0x003d }
                r8 = -1854767153(0xffffffff91727fcf, float:-1.9129818E-28)
                if (r1 == r8) goto L_0x013e
                r8 = 3584(0xe00, float:5.022E-42)
                if (r1 == r8) goto L_0x00b5
                r2 = 102678(0x19116, float:1.43883E-40)
                if (r1 == r2) goto L_0x0059
                goto L_0x014e
            L_0x0059:
                java.lang.String r1 = "gtc"
                boolean r10 = r10.equals(r1)     // Catch:{ Exception -> 0x003d }
                if (r10 != 0) goto L_0x0063
                goto L_0x014e
            L_0x0063:
                com.sumsub.sns.internal.presentation.screen.verification.b r10 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                java.lang.String r1 = "sns_tos_GTC_html"
                r9.f36378b = r7     // Catch:{ Exception -> 0x003d }
                java.lang.Object r10 = r10.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r9)     // Catch:{ Exception -> 0x003d }
                if (r10 != r0) goto L_0x0070
                return r0
            L_0x0070:
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x003d }
                if (r10 != 0) goto L_0x0075
                r10 = r5
            L_0x0075:
                com.sumsub.sns.internal.presentation.screen.verification.b r1 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                java.lang.String r2 = "sns_tos_GTC_url"
                r9.f36377a = r10     // Catch:{ Exception -> 0x003d }
                r9.f36378b = r4     // Catch:{ Exception -> 0x003d }
                java.lang.Object r1 = r1.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r9)     // Catch:{ Exception -> 0x003d }
                if (r1 != r0) goto L_0x0084
                return r0
            L_0x0084:
                r0 = r10
                r10 = r1
            L_0x0086:
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x003d }
                if (r10 != 0) goto L_0x008b
                goto L_0x008c
            L_0x008b:
                r5 = r10
            L_0x008c:
                int r10 = r0.length()     // Catch:{ Exception -> 0x003d }
                if (r10 <= 0) goto L_0x0094
                r10 = r7
                goto L_0x0095
            L_0x0094:
                r10 = r6
            L_0x0095:
                if (r10 == 0) goto L_0x00a3
                com.sumsub.sns.internal.presentation.screen.verification.b r10 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                com.sumsub.sns.internal.presentation.screen.verification.b$b r1 = new com.sumsub.sns.internal.presentation.screen.verification.b$b     // Catch:{ Exception -> 0x003d }
                r1.<init>(r0)     // Catch:{ Exception -> 0x003d }
                r10.a((com.sumsub.sns.core.presentation.base.a.j) r1)     // Catch:{ Exception -> 0x003d }
                goto L_0x016e
            L_0x00a3:
                int r10 = r5.length()     // Catch:{ Exception -> 0x003d }
                if (r10 <= 0) goto L_0x00ab
                r10 = r7
                goto L_0x00ac
            L_0x00ab:
                r10 = r6
            L_0x00ac:
                if (r10 == 0) goto L_0x016e
                com.sumsub.sns.internal.presentation.screen.verification.b r10 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                r10.a((java.lang.String) r5)     // Catch:{ Exception -> 0x003d }
                goto L_0x016e
            L_0x00b5:
                java.lang.String r1 = "pp"
                boolean r10 = r10.equals(r1)     // Catch:{ Exception -> 0x003d }
                if (r10 != 0) goto L_0x00bf
                goto L_0x014e
            L_0x00bf:
                com.sumsub.sns.internal.presentation.screen.verification.b r10 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r10 = r10.h()     // Catch:{ Exception -> 0x003d }
                java.util.List r10 = r10.c()     // Catch:{ Exception -> 0x003d }
                if (r10 == 0) goto L_0x00d8
                java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r10)     // Catch:{ Exception -> 0x003d }
                com.sumsub.sns.internal.core.data.model.d r10 = (com.sumsub.sns.internal.core.data.model.d) r10     // Catch:{ Exception -> 0x003d }
                if (r10 == 0) goto L_0x00d8
                com.sumsub.sns.internal.core.data.model.b r10 = r10.c()     // Catch:{ Exception -> 0x003d }
                goto L_0x00d9
            L_0x00d8:
                r10 = 0
            L_0x00d9:
                r1 = r10
                if (r1 == 0) goto L_0x00e2
                java.lang.String r10 = r1.g()     // Catch:{ Exception -> 0x003d }
                if (r10 != 0) goto L_0x00f6
            L_0x00e2:
                com.sumsub.sns.internal.presentation.screen.verification.b r10 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                java.lang.String r4 = "sns_tos_PP_html"
                r9.f36377a = r1     // Catch:{ Exception -> 0x003d }
                r9.f36378b = r3     // Catch:{ Exception -> 0x003d }
                java.lang.Object r10 = r10.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r9)     // Catch:{ Exception -> 0x003d }
                if (r10 != r0) goto L_0x00f1
                return r0
            L_0x00f1:
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x003d }
                if (r10 != 0) goto L_0x00f6
                r10 = r5
            L_0x00f6:
                if (r1 == 0) goto L_0x00fe
                java.lang.String r1 = r1.k()     // Catch:{ Exception -> 0x003d }
                if (r1 != 0) goto L_0x0117
            L_0x00fe:
                com.sumsub.sns.internal.presentation.screen.verification.b r1 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                java.lang.String r3 = "sns_tos_PP_url"
                r9.f36377a = r10     // Catch:{ Exception -> 0x003d }
                r9.f36378b = r2     // Catch:{ Exception -> 0x003d }
                java.lang.Object r1 = r1.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r9)     // Catch:{ Exception -> 0x003d }
                if (r1 != r0) goto L_0x010d
                return r0
            L_0x010d:
                r0 = r10
                r10 = r1
            L_0x010f:
                java.lang.String r10 = (java.lang.String) r10     // Catch:{ Exception -> 0x003d }
                if (r10 != 0) goto L_0x0114
                goto L_0x0115
            L_0x0114:
                r5 = r10
            L_0x0115:
                r10 = r0
                r1 = r5
            L_0x0117:
                int r0 = r1.length()     // Catch:{ Exception -> 0x003d }
                if (r0 <= 0) goto L_0x011f
                r0 = r7
                goto L_0x0120
            L_0x011f:
                r0 = r6
            L_0x0120:
                if (r0 == 0) goto L_0x0128
                com.sumsub.sns.internal.presentation.screen.verification.b r10 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                r10.a((java.lang.String) r1)     // Catch:{ Exception -> 0x003d }
                goto L_0x016e
            L_0x0128:
                int r0 = r10.length()     // Catch:{ Exception -> 0x003d }
                if (r0 <= 0) goto L_0x0130
                r0 = r7
                goto L_0x0131
            L_0x0130:
                r0 = r6
            L_0x0131:
                if (r0 == 0) goto L_0x016e
                com.sumsub.sns.internal.presentation.screen.verification.b r0 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                com.sumsub.sns.internal.presentation.screen.verification.b$b r1 = new com.sumsub.sns.internal.presentation.screen.verification.b$b     // Catch:{ Exception -> 0x003d }
                r1.<init>(r10)     // Catch:{ Exception -> 0x003d }
                r0.a((com.sumsub.sns.core.presentation.base.a.j) r1)     // Catch:{ Exception -> 0x003d }
                goto L_0x016e
            L_0x013e:
                java.lang.String r0 = "support"
                boolean r10 = r10.equals(r0)     // Catch:{ Exception -> 0x003d }
                if (r10 == 0) goto L_0x014e
                com.sumsub.sns.internal.presentation.screen.verification.b r10 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                com.sumsub.sns.core.presentation.base.a$p r0 = com.sumsub.sns.core.presentation.base.a.p.f30864a     // Catch:{ Exception -> 0x003d }
                r10.a((com.sumsub.sns.core.presentation.base.a.j) r0)     // Catch:{ Exception -> 0x003d }
                goto L_0x016e
            L_0x014e:
                com.sumsub.sns.internal.presentation.screen.verification.b r10 = r9.f36380d     // Catch:{ Exception -> 0x003d }
                java.lang.String r0 = r9.f36379c     // Catch:{ Exception -> 0x003d }
                r10.a((java.lang.String) r0)     // Catch:{ Exception -> 0x003d }
                goto L_0x016e
            L_0x0156:
                com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a
                com.sumsub.sns.internal.log.LoggerType[] r1 = new com.sumsub.sns.internal.log.LoggerType[r7]
                com.sumsub.sns.internal.log.LoggerType r2 = com.sumsub.sns.internal.log.LoggerType.KIBANA
                r1[r6] = r2
                com.sumsub.log.logger.Logger r0 = r0.a((com.sumsub.sns.internal.log.LoggerType[]) r1)
                java.lang.String r1 = "SNSApplicantStatusViewModel"
                java.lang.String r2 = "An error when a user clicks on terms links..."
                r0.e(r1, r2, r10)
                com.sumsub.sns.core.c r0 = com.sumsub.sns.core.c.f30748a
                r0.a(r1, r2, r10)
            L_0x016e:
                kotlin.Unit r10 = kotlin.Unit.f56620a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.j.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel$showInitialStatus$2", f = "SNSApplicantStatusViewModel.kt", l = {444, 447, 448, 449, 450, 452, 457}, m = "invokeSuspend")
    public static final class k extends SuspendLambda implements d10.p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36381a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36382b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36383c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36384d;

        /* renamed from: e  reason: collision with root package name */
        public int f36385e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.presentation.helper.b f36386f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f36387g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(com.sumsub.sns.internal.core.presentation.helper.b bVar, b bVar2, kotlin.coroutines.c<? super k> cVar) {
            super(2, cVar);
            this.f36386f = bVar;
            this.f36387g = bVar2;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((k) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new k(this.f36386f, this.f36387g, cVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x009e, code lost:
            r2 = (java.lang.CharSequence) r2;
            r3 = r0.f36387g;
            r0.f36381a = r2;
            r0.f36385e = 3;
            r3 = com.sumsub.sns.internal.presentation.screen.verification.b.a(r3, "sns_status_INITIAL_subtitle", (kotlin.coroutines.c) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ad, code lost:
            if (r3 != r1) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00af, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b0, code lost:
            r3 = (java.lang.CharSequence) r3;
            r4 = r0.f36387g;
            r0.f36381a = r2;
            r0.f36382b = r3;
            r0.f36385e = 4;
            r4 = com.sumsub.sns.internal.presentation.screen.verification.b.c(r4, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bf, code lost:
            if (r4 != r1) goto L_0x00c2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c1, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c2, code lost:
            r17 = r3;
            r3 = r2;
            r2 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cd, code lost:
            if (((java.lang.Boolean) r4).booleanValue() == false) goto L_0x00ea;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00cf, code lost:
            r4 = r0.f36387g;
            r0.f36381a = r3;
            r0.f36382b = r2;
            r0.f36385e = 5;
            r4 = com.sumsub.sns.internal.presentation.screen.verification.b.a(r4, "sns_status_INITIAL_footerHtml_noAgreement", (kotlin.coroutines.c) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00de, code lost:
            if (r4 != r1) goto L_0x00e1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e0, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e1, code lost:
            r4 = (java.lang.String) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e3, code lost:
            r17 = r3;
            r3 = r2;
            r2 = r4;
            r4 = r17;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ea, code lost:
            r4 = r0.f36387g;
            r0.f36381a = r3;
            r0.f36382b = r2;
            r0.f36385e = 6;
            r4 = com.sumsub.sns.internal.presentation.screen.verification.b.a(r4, "sns_status_INITIAL_footerHtml", (kotlin.coroutines.c) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00f9, code lost:
            if (r4 != r1) goto L_0x00fc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fb, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00fc, code lost:
            r4 = (java.lang.String) r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ff, code lost:
            r5 = com.sumsub.sns.internal.presentation.screen.verification.b.a(r0.f36387g, (java.util.List) r0.f36386f.e(), r0.f36386f.d());
            r6 = r0.f36387g;
            r15 = r0.f36386f;
            r14 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r5, 10));
            r5 = r5.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0128, code lost:
            if (r5.hasNext() == false) goto L_0x014e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x012a, code lost:
            r19 = r5;
            r5 = r14;
            r5.add(com.sumsub.sns.internal.core.presentation.helper.a.a(com.sumsub.sns.internal.presentation.screen.verification.b.d(r6), (com.sumsub.sns.internal.core.data.model.Document) r5.next(), com.sumsub.sns.internal.core.data.model.ApplicantStatus.None, false, r15, (java.lang.String) null, 40, (java.lang.Object) null));
            r14 = r5;
            r5 = r19;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x014e, code lost:
            r5 = r14;
            r6 = r0.f36387g;
            r0.f36381a = r4;
            r0.f36382b = r3;
            r0.f36383c = r2;
            r0.f36384d = r5;
            r0.f36385e = 7;
            r6 = com.sumsub.sns.internal.presentation.screen.verification.b.a(r6, "sns_status_INITIAL_action_continue", (kotlin.coroutines.c) r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0162, code lost:
            if (r6 != r1) goto L_0x0165;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0164, code lost:
            return r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0165, code lost:
            r10 = r2;
            r9 = r3;
            r8 = r4;
            r11 = r5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
            return new com.sumsub.sns.internal.presentation.screen.verification.d.b(r8, r9, r10, r11, (java.lang.CharSequence) r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return (com.sumsub.sns.internal.presentation.screen.verification.d) r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f36385e
                switch(r2) {
                    case 0: goto L_0x0071;
                    case 1: goto L_0x006b;
                    case 2: goto L_0x0065;
                    case 3: goto L_0x005b;
                    case 4: goto L_0x004c;
                    case 5: goto L_0x003d;
                    case 6: goto L_0x002e;
                    case 7: goto L_0x0013;
                    default: goto L_0x000b;
                }
            L_0x000b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0013:
                java.lang.Object r1 = r0.f36384d
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r2 = r0.f36383c
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r0.f36382b
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r0.f36381a
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                kotlin.k.b(r19)
                r6 = r19
                r11 = r1
                r10 = r2
                r9 = r3
                r8 = r4
                goto L_0x0169
            L_0x002e:
                java.lang.Object r2 = r0.f36382b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r0.f36381a
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                kotlin.k.b(r19)
                r4 = r19
                goto L_0x00fc
            L_0x003d:
                java.lang.Object r2 = r0.f36382b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r0.f36381a
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                kotlin.k.b(r19)
                r4 = r19
                goto L_0x00e1
            L_0x004c:
                java.lang.Object r2 = r0.f36382b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r0.f36381a
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                kotlin.k.b(r19)
                r4 = r19
                goto L_0x00c7
            L_0x005b:
                java.lang.Object r2 = r0.f36381a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                kotlin.k.b(r19)
                r3 = r19
                goto L_0x00b0
            L_0x0065:
                kotlin.k.b(r19)
                r2 = r19
                goto L_0x009e
            L_0x006b:
                kotlin.k.b(r19)
                r2 = r19
                goto L_0x008c
            L_0x0071:
                kotlin.k.b(r19)
                com.sumsub.sns.internal.core.presentation.helper.b r2 = r0.f36386f
                com.sumsub.sns.internal.core.data.model.g r2 = r2.d()
                boolean r2 = r2.A()
                if (r2 == 0) goto L_0x0090
                com.sumsub.sns.internal.presentation.screen.verification.b r2 = r0.f36387g
                r3 = 1
                r0.f36385e = r3
                java.lang.Object r2 = r2.e(r0)
                if (r2 != r1) goto L_0x008c
                return r1
            L_0x008c:
                com.sumsub.sns.internal.presentation.screen.verification.d r2 = (com.sumsub.sns.internal.presentation.screen.verification.d) r2
                goto L_0x0172
            L_0x0090:
                com.sumsub.sns.internal.presentation.screen.verification.b r2 = r0.f36387g
                r3 = 2
                r0.f36385e = r3
                java.lang.String r3 = "sns_status_INITIAL_title"
                java.lang.Object r2 = r2.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r2 != r1) goto L_0x009e
                return r1
            L_0x009e:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                com.sumsub.sns.internal.presentation.screen.verification.b r3 = r0.f36387g
                r0.f36381a = r2
                r4 = 3
                r0.f36385e = r4
                java.lang.String r4 = "sns_status_INITIAL_subtitle"
                java.lang.Object r3 = r3.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r3 != r1) goto L_0x00b0
                return r1
            L_0x00b0:
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                com.sumsub.sns.internal.presentation.screen.verification.b r4 = r0.f36387g
                r0.f36381a = r2
                r0.f36382b = r3
                r5 = 4
                r0.f36385e = r5
                java.lang.Object r4 = r4.f(r0)
                if (r4 != r1) goto L_0x00c2
                return r1
            L_0x00c2:
                r17 = r3
                r3 = r2
                r2 = r17
            L_0x00c7:
                java.lang.Boolean r4 = (java.lang.Boolean) r4
                boolean r4 = r4.booleanValue()
                if (r4 == 0) goto L_0x00ea
                com.sumsub.sns.internal.presentation.screen.verification.b r4 = r0.f36387g
                r0.f36381a = r3
                r0.f36382b = r2
                r5 = 5
                r0.f36385e = r5
                java.lang.String r5 = "sns_status_INITIAL_footerHtml_noAgreement"
                java.lang.Object r4 = r4.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r4 != r1) goto L_0x00e1
                return r1
            L_0x00e1:
                java.lang.String r4 = (java.lang.String) r4
            L_0x00e3:
                r17 = r3
                r3 = r2
                r2 = r4
                r4 = r17
                goto L_0x00ff
            L_0x00ea:
                com.sumsub.sns.internal.presentation.screen.verification.b r4 = r0.f36387g
                r0.f36381a = r3
                r0.f36382b = r2
                r5 = 6
                r0.f36385e = r5
                java.lang.String r5 = "sns_status_INITIAL_footerHtml"
                java.lang.Object r4 = r4.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r4 != r1) goto L_0x00fc
                return r1
            L_0x00fc:
                java.lang.String r4 = (java.lang.String) r4
                goto L_0x00e3
            L_0x00ff:
                com.sumsub.sns.internal.presentation.screen.verification.b r5 = r0.f36387g
                com.sumsub.sns.internal.core.presentation.helper.b r6 = r0.f36386f
                java.util.List r6 = r6.e()
                com.sumsub.sns.internal.core.presentation.helper.b r7 = r0.f36386f
                com.sumsub.sns.internal.core.data.model.g r7 = r7.d()
                java.util.List r5 = r5.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r6, (com.sumsub.sns.internal.core.data.model.g) r7)
                com.sumsub.sns.internal.presentation.screen.verification.b r6 = r0.f36387g
                com.sumsub.sns.internal.core.presentation.helper.b r15 = r0.f36386f
                java.util.ArrayList r14 = new java.util.ArrayList
                r7 = 10
                int r7 = kotlin.collections.CollectionsKt__IterablesKt.u(r5, r7)
                r14.<init>(r7)
                java.util.Iterator r5 = r5.iterator()
            L_0x0124:
                boolean r7 = r5.hasNext()
                if (r7 == 0) goto L_0x014e
                java.lang.Object r7 = r5.next()
                r8 = r7
                com.sumsub.sns.internal.core.data.model.Document r8 = (com.sumsub.sns.internal.core.data.model.Document) r8
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r7 = r6.h()
                com.sumsub.sns.internal.core.data.model.ApplicantStatus r9 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.None
                r10 = 0
                r12 = 0
                r13 = 40
                r16 = 0
                r11 = r15
                r19 = r5
                r5 = r14
                r14 = r16
                com.sumsub.sns.internal.core.presentation.base.adapter.c r7 = com.sumsub.sns.internal.core.presentation.helper.a.a(r7, r8, r9, r10, r11, r12, r13, r14)
                r5.add(r7)
                r14 = r5
                r5 = r19
                goto L_0x0124
            L_0x014e:
                r5 = r14
                com.sumsub.sns.internal.presentation.screen.verification.b r6 = r0.f36387g
                r0.f36381a = r4
                r0.f36382b = r3
                r0.f36383c = r2
                r0.f36384d = r5
                r7 = 7
                r0.f36385e = r7
                java.lang.String r7 = "sns_status_INITIAL_action_continue"
                java.lang.Object r6 = r6.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r6 != r1) goto L_0x0165
                return r1
            L_0x0165:
                r10 = r2
                r9 = r3
                r8 = r4
                r11 = r5
            L_0x0169:
                r12 = r6
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                com.sumsub.sns.internal.presentation.screen.verification.d$b r2 = new com.sumsub.sns.internal.presentation.screen.verification.d$b
                r7 = r2
                r7.<init>(r8, r9, r10, r11, r12)
            L_0x0172:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.k.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel", f = "SNSApplicantStatusViewModel.kt", l = {192, 196, 200, 207, 211, 220, 224, 228, 232, 233, 234, 273, 298, 299, 300, 308, 309, 310}, m = "showReviewedStatus")
    public static final class l extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36388a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36389b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36390c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36391d;

        /* renamed from: e  reason: collision with root package name */
        public Object f36392e;

        /* renamed from: f  reason: collision with root package name */
        public Object f36393f;

        /* renamed from: g  reason: collision with root package name */
        public Object f36394g;

        /* renamed from: h  reason: collision with root package name */
        public Object f36395h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f36396i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ b f36397j;

        /* renamed from: k  reason: collision with root package name */
        public int f36398k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(b bVar, kotlin.coroutines.c<? super l> cVar) {
            super(cVar);
            this.f36397j = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36396i = obj;
            this.f36398k |= Integer.MIN_VALUE;
            return this.f36397j.b((com.sumsub.sns.internal.core.presentation.helper.b) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel$showReviewedStatus$2", f = "SNSApplicantStatusViewModel.kt", l = {}, m = "invokeSuspend")
    public static final class m extends SuspendLambda implements d10.p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f36399a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f36400b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(d dVar, kotlin.coroutines.c<? super m> cVar) {
            super(2, cVar);
            this.f36400b = dVar;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((m) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new m(this.f36400b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f36399a == 0) {
                kotlin.k.b(obj);
                return this.f36400b;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel$showReviewingStatus$1", f = "SNSApplicantStatusViewModel.kt", l = {406, 409, 410, 411}, m = "invokeSuspend")
    public static final class n extends SuspendLambda implements d10.p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36401a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36402b;

        /* renamed from: c  reason: collision with root package name */
        public int f36403c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ b f36404d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.presentation.helper.b f36405e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(b bVar, com.sumsub.sns.internal.core.presentation.helper.b bVar2, kotlin.coroutines.c<? super n> cVar) {
            super(2, cVar);
            this.f36404d = bVar;
            this.f36405e = bVar2;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((n) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new n(this.f36404d, this.f36405e, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:23:0x007e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0091 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00c2 A[LOOP:0: B:29:0x00bc->B:31:0x00c2, LOOP_END] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f36403c
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r2 == 0) goto L_0x0045
                if (r2 == r6) goto L_0x003f
                if (r2 == r5) goto L_0x0039
                if (r2 == r4) goto L_0x002f
                if (r2 != r3) goto L_0x0027
                java.lang.Object r1 = r0.f36402b
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                java.lang.Object r2 = r0.f36401a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                kotlin.k.b(r17)
                r3 = r17
                r6 = r1
                r5 = r2
                goto L_0x0094
            L_0x0027:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x002f:
                java.lang.Object r2 = r0.f36401a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                kotlin.k.b(r17)
                r4 = r17
                goto L_0x007f
            L_0x0039:
                kotlin.k.b(r17)
                r2 = r17
                goto L_0x006e
            L_0x003f:
                kotlin.k.b(r17)
                r2 = r17
                goto L_0x005d
            L_0x0045:
                kotlin.k.b(r17)
                com.sumsub.sns.internal.presentation.screen.verification.b r2 = r0.f36404d
                com.sumsub.sns.internal.core.presentation.helper.b r7 = r0.f36405e
                boolean r2 = r2.a((com.sumsub.sns.internal.core.presentation.helper.b) r7)
                if (r2 == 0) goto L_0x0061
                com.sumsub.sns.internal.presentation.screen.verification.b r2 = r0.f36404d
                r0.f36403c = r6
                java.lang.Object r2 = r2.e(r0)
                if (r2 != r1) goto L_0x005d
                return r1
            L_0x005d:
                com.sumsub.sns.internal.presentation.screen.verification.d r2 = (com.sumsub.sns.internal.presentation.screen.verification.d) r2
                goto L_0x00e6
            L_0x0061:
                com.sumsub.sns.internal.presentation.screen.verification.b r2 = r0.f36404d
                r0.f36403c = r5
                java.lang.String r5 = "sns_status_PENDING_title"
                java.lang.Object r2 = r2.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r2 != r1) goto L_0x006e
                return r1
            L_0x006e:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                com.sumsub.sns.internal.presentation.screen.verification.b r5 = r0.f36404d
                r0.f36401a = r2
                r0.f36403c = r4
                java.lang.String r4 = "sns_status_PENDING_subtitle"
                java.lang.Object r4 = r5.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r4 != r1) goto L_0x007f
                return r1
            L_0x007f:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                com.sumsub.sns.internal.presentation.screen.verification.b r5 = r0.f36404d
                r0.f36401a = r2
                r0.f36402b = r4
                r0.f36403c = r3
                java.lang.String r3 = "sns_status_PENDING_footerHtml"
                java.lang.Object r3 = r5.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r3 != r1) goto L_0x0092
                return r1
            L_0x0092:
                r5 = r2
                r6 = r4
            L_0x0094:
                r7 = r3
                java.lang.CharSequence r7 = (java.lang.CharSequence) r7
                com.sumsub.sns.internal.presentation.screen.verification.b r1 = r0.f36404d
                com.sumsub.sns.internal.core.presentation.helper.b r2 = r0.f36405e
                java.util.List r2 = r2.e()
                com.sumsub.sns.internal.core.presentation.helper.b r3 = r0.f36405e
                com.sumsub.sns.internal.core.data.model.g r3 = r3.d()
                java.util.List r1 = r1.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r2, (com.sumsub.sns.internal.core.data.model.g) r3)
                com.sumsub.sns.internal.presentation.screen.verification.b r2 = r0.f36404d
                com.sumsub.sns.internal.core.presentation.helper.b r3 = r0.f36405e
                java.util.ArrayList r4 = new java.util.ArrayList
                r8 = 10
                int r8 = kotlin.collections.CollectionsKt__IterablesKt.u(r1, r8)
                r4.<init>(r8)
                java.util.Iterator r1 = r1.iterator()
            L_0x00bc:
                boolean r8 = r1.hasNext()
                if (r8 == 0) goto L_0x00dd
                java.lang.Object r8 = r1.next()
                r9 = r8
                com.sumsub.sns.internal.core.data.model.Document r9 = (com.sumsub.sns.internal.core.data.model.Document) r9
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r8 = r2.h()
                com.sumsub.sns.internal.core.data.model.ApplicantStatus r10 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewing
                r11 = 0
                r13 = 0
                r14 = 40
                r15 = 0
                r12 = r3
                com.sumsub.sns.internal.core.presentation.base.adapter.c r8 = com.sumsub.sns.internal.core.presentation.helper.a.a(r8, r9, r10, r11, r12, r13, r14, r15)
                r4.add(r8)
                goto L_0x00bc
            L_0x00dd:
                com.sumsub.sns.internal.presentation.screen.verification.d$b r2 = new com.sumsub.sns.internal.presentation.screen.verification.d$b
                r9 = 0
                r1 = r4
                r4 = r2
                r8 = r1
                r4.<init>(r5, r6, r7, r8, r9)
            L_0x00e6:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.n.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel$showSubmittingStatus$1", f = "SNSApplicantStatusViewModel.kt", l = {425, 428, 429, 430, 434}, m = "invokeSuspend")
    public static final class o extends SuspendLambda implements d10.p<d, kotlin.coroutines.c<? super d>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f36406a;

        /* renamed from: b  reason: collision with root package name */
        public Object f36407b;

        /* renamed from: c  reason: collision with root package name */
        public Object f36408c;

        /* renamed from: d  reason: collision with root package name */
        public Object f36409d;

        /* renamed from: e  reason: collision with root package name */
        public int f36410e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.presentation.helper.b f36411f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f36412g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(com.sumsub.sns.internal.core.presentation.helper.b bVar, b bVar2, kotlin.coroutines.c<? super o> cVar) {
            super(2, cVar);
            this.f36411f = bVar;
            this.f36412g = bVar2;
        }

        /* renamed from: a */
        public final Object invoke(d dVar, kotlin.coroutines.c<? super d> cVar) {
            return ((o) create(dVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new o(this.f36411f, this.f36412g, cVar);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00ad A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00e0 A[LOOP:0: B:29:0x00da->B:31:0x00e0, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x011d A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:35:0x011e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r20) {
            /*
                r19 = this;
                r0 = r19
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r2 = r0.f36410e
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                if (r2 == 0) goto L_0x0062
                if (r2 == r7) goto L_0x005b
                if (r2 == r6) goto L_0x0055
                if (r2 == r5) goto L_0x004b
                if (r2 == r4) goto L_0x003c
                if (r2 != r3) goto L_0x0034
                java.lang.Object r1 = r0.f36409d
                java.util.List r1 = (java.util.List) r1
                java.lang.Object r2 = r0.f36408c
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r3 = r0.f36407b
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                java.lang.Object r4 = r0.f36406a
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                kotlin.k.b(r20)
                r6 = r20
                r11 = r1
                r10 = r2
                r9 = r3
                r8 = r4
                goto L_0x0122
            L_0x0034:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x003c:
                java.lang.Object r2 = r0.f36407b
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                java.lang.Object r4 = r0.f36406a
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                kotlin.k.b(r20)
                r5 = r4
                r4 = r20
                goto L_0x00b3
            L_0x004b:
                java.lang.Object r2 = r0.f36406a
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                kotlin.k.b(r20)
                r5 = r20
                goto L_0x009b
            L_0x0055:
                kotlin.k.b(r20)
                r2 = r20
                goto L_0x008a
            L_0x005b:
                kotlin.k.b(r20)
                r2 = r20
                goto L_0x0137
            L_0x0062:
                kotlin.k.b(r20)
                com.sumsub.sns.internal.core.presentation.helper.b r2 = r0.f36411f
                com.sumsub.sns.internal.core.data.model.g r2 = r2.d()
                boolean r2 = r2.A()
                if (r2 != 0) goto L_0x012c
                com.sumsub.sns.internal.presentation.screen.verification.b r2 = r0.f36412g
                com.sumsub.sns.internal.core.presentation.helper.b r8 = r0.f36411f
                boolean r2 = r2.b((com.sumsub.sns.internal.core.presentation.helper.b) r8)
                if (r2 == 0) goto L_0x007d
                goto L_0x012c
            L_0x007d:
                com.sumsub.sns.internal.presentation.screen.verification.b r2 = r0.f36412g
                r0.f36410e = r6
                java.lang.String r6 = "sns_status_INCOMPLETE_title"
                java.lang.Object r2 = r2.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r2 != r1) goto L_0x008a
                return r1
            L_0x008a:
                java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                com.sumsub.sns.internal.presentation.screen.verification.b r6 = r0.f36412g
                r0.f36406a = r2
                r0.f36410e = r5
                java.lang.String r5 = "sns_status_INCOMPLETE_subtitle"
                java.lang.Object r5 = r6.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r5 != r1) goto L_0x009b
                return r1
            L_0x009b:
                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                com.sumsub.sns.internal.presentation.screen.verification.b r6 = r0.f36412g
                r0.f36406a = r2
                r0.f36407b = r5
                r0.f36410e = r4
                java.lang.String r4 = "sns_status_INCOMPLETE_footerHtml"
                java.lang.Object r4 = r6.a((java.lang.String) r4, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r4 != r1) goto L_0x00ae
                return r1
            L_0x00ae:
                r18 = r5
                r5 = r2
                r2 = r18
            L_0x00b3:
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                com.sumsub.sns.internal.presentation.screen.verification.b r6 = r0.f36412g
                com.sumsub.sns.internal.core.presentation.helper.b r7 = r0.f36411f
                java.util.List r7 = r7.e()
                com.sumsub.sns.internal.core.presentation.helper.b r8 = r0.f36411f
                com.sumsub.sns.internal.core.data.model.g r8 = r8.d()
                java.util.List r6 = r6.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r7, (com.sumsub.sns.internal.core.data.model.g) r8)
                com.sumsub.sns.internal.presentation.screen.verification.b r7 = r0.f36412g
                com.sumsub.sns.internal.core.presentation.helper.b r15 = r0.f36411f
                java.util.ArrayList r14 = new java.util.ArrayList
                r8 = 10
                int r8 = kotlin.collections.CollectionsKt__IterablesKt.u(r6, r8)
                r14.<init>(r8)
                java.util.Iterator r6 = r6.iterator()
            L_0x00da:
                boolean r8 = r6.hasNext()
                if (r8 == 0) goto L_0x0107
                java.lang.Object r8 = r6.next()
                r9 = r8
                com.sumsub.sns.internal.core.data.model.Document r9 = (com.sumsub.sns.internal.core.data.model.Document) r9
                com.sumsub.sns.internal.core.data.source.dynamic.b$c r8 = r7.h()
                com.sumsub.sns.internal.core.data.model.ApplicantStatus r10 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Submitting
                r11 = 0
                r13 = 0
                r16 = 40
                r17 = 0
                r12 = r15
                r3 = r14
                r14 = r16
                r16 = r15
                r15 = r17
                com.sumsub.sns.internal.core.presentation.base.adapter.c r8 = com.sumsub.sns.internal.core.presentation.helper.a.a(r8, r9, r10, r11, r12, r13, r14, r15)
                r3.add(r8)
                r14 = r3
                r15 = r16
                r3 = 5
                goto L_0x00da
            L_0x0107:
                r3 = r14
                com.sumsub.sns.internal.presentation.screen.verification.b r6 = r0.f36412g
                r0.f36406a = r5
                r0.f36407b = r2
                r0.f36408c = r4
                r0.f36409d = r3
                r7 = 5
                r0.f36410e = r7
                java.lang.String r7 = "sns_status_INITIAL_action_continue"
                java.lang.Object r6 = r6.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r0)
                if (r6 != r1) goto L_0x011e
                return r1
            L_0x011e:
                r9 = r2
                r11 = r3
                r10 = r4
                r8 = r5
            L_0x0122:
                r12 = r6
                java.lang.CharSequence r12 = (java.lang.CharSequence) r12
                com.sumsub.sns.internal.presentation.screen.verification.d$b r1 = new com.sumsub.sns.internal.presentation.screen.verification.d$b
                r7 = r1
                r7.<init>(r8, r9, r10, r11, r12)
                goto L_0x013a
            L_0x012c:
                com.sumsub.sns.internal.presentation.screen.verification.b r2 = r0.f36412g
                r0.f36410e = r7
                java.lang.Object r2 = r2.e(r0)
                if (r2 != r1) goto L_0x0137
                return r1
            L_0x0137:
                r1 = r2
                com.sumsub.sns.internal.presentation.screen.verification.d r1 = (com.sumsub.sns.internal.presentation.screen.verification.d) r1
            L_0x013a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.verification.SNSApplicantStatusViewModel", f = "SNSApplicantStatusViewModel.kt", l = {464, 466}, m = "skipAgreementSigning")
    public static final class p extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f36413a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f36414b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f36415c;

        /* renamed from: d  reason: collision with root package name */
        public int f36416d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(b bVar, kotlin.coroutines.c<? super p> cVar) {
            super(cVar);
            this.f36415c = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f36414b = obj;
            this.f36416d |= Integer.MIN_VALUE;
            return this.f36415c.f(this);
        }
    }

    public b(com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.domain.p pVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, com.sumsub.sns.internal.core.data.source.applicant.b bVar2, com.sumsub.sns.internal.core.data.source.extensions.a aVar2) {
        super(aVar, bVar);
        this.f36340q = aVar;
        this.f36341r = pVar;
        this.f36342s = bVar;
        this.f36343t = bVar2;
        this.f36344u = aVar2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0093, code lost:
        if ((r12 <= 1 || r12 == 0) == false) goto L_0x0096;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object f(kotlin.coroutines.c<? super java.lang.Boolean> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.presentation.screen.verification.b.p
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.presentation.screen.verification.b$p r0 = (com.sumsub.sns.internal.presentation.screen.verification.b.p) r0
            int r1 = r0.f36416d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36416d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.verification.b$p r0 = new com.sumsub.sns.internal.presentation.screen.verification.b$p
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f36414b
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r0.f36416d
            r8 = 2
            r9 = 0
            r10 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r10) goto L_0x0035
            if (r1 != r8) goto L_0x002d
            kotlin.k.b(r12)
            goto L_0x007d
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0035:
            java.lang.Object r1 = r0.f36413a
            com.sumsub.sns.internal.presentation.screen.verification.b r1 = (com.sumsub.sns.internal.presentation.screen.verification.b) r1
            kotlin.k.b(r12)
            goto L_0x005f
        L_0x003d:
            kotlin.k.b(r12)
            com.sumsub.sns.internal.ff.a r12 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r12 = r12.x()
            boolean r12 = r12.g()
            if (r12 != 0) goto L_0x0095
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r11.f36342s
            r0.f36413a = r11
            r0.f36416d = r10
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r4 = r0
            java.lang.Object r12 = com.sumsub.sns.internal.core.data.source.dynamic.h.g(r1, r2, r3, r4, r5, r6)
            if (r12 != r7) goto L_0x005e
            return r7
        L_0x005e:
            r1 = r11
        L_0x005f:
            com.sumsub.sns.internal.core.data.source.dynamic.e r12 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r12
            java.lang.Object r12 = r12.d()
            com.sumsub.sns.internal.core.data.model.g r12 = (com.sumsub.sns.internal.core.data.model.g) r12
            r2 = 0
            if (r12 == 0) goto L_0x006f
            com.sumsub.sns.internal.core.data.model.b r12 = r12.r()
            goto L_0x0070
        L_0x006f:
            r12 = r2
        L_0x0070:
            if (r12 != 0) goto L_0x0095
            r0.f36413a = r2
            r0.f36416d = r8
            java.lang.Object r12 = r1.c((kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.b.c>) r0)
            if (r12 != r7) goto L_0x007d
            return r7
        L_0x007d:
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r12 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r12
            java.util.List r12 = r12.c()
            if (r12 == 0) goto L_0x008a
            int r12 = r12.size()
            goto L_0x008b
        L_0x008a:
            r12 = r9
        L_0x008b:
            if (r12 > r10) goto L_0x0092
            if (r12 != 0) goto L_0x0090
            goto L_0x0092
        L_0x0090:
            r12 = r9
            goto L_0x0093
        L_0x0092:
            r12 = r10
        L_0x0093:
            if (r12 == 0) goto L_0x0096
        L_0x0095:
            r9 = r10
        L_0x0096:
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.a.a(r9)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.f(kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: p */
    public d e() {
        return d.f36418f.a();
    }

    public final void q() {
        ApplicantStatus applicantStatus = this.f36347x;
        if (applicantStatus != null) {
            if (applicantStatus == ApplicantStatus.Submitting) {
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (q) new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
                return;
            }
            SNSEventHandler eventHandler = e0.f32018a.getEventHandler();
            if (eventHandler != null) {
                eventHandler.onEvent(SNSEvent.UserStartedVerification.INSTANCE);
            }
            com.sumsub.sns.internal.core.data.model.g gVar = this.f36345v;
            if (gVar != null) {
                com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, (q) new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
                n1 unused = kotlinx.coroutines.i.d(m0.a(this), v1.f57574b, (CoroutineStart) null, new g(this, gVar, (kotlin.coroutines.c<? super g>) null), 2, (Object) null);
            }
        }
    }

    public Object d(kotlin.coroutines.c<? super Unit> cVar) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new i(this, (kotlin.coroutines.c<? super i>) null), 3, (Object) null);
        return Unit.f56620a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d5, code lost:
        if (((java.lang.Boolean) r14).booleanValue() == false) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00d7, code lost:
        r0.f36350a = r4;
        r0.f36351b = r2;
        r0.f36357h = 2;
        r14 = r4.a("sns_status_VIDEO_IDENT_footerHtml_noAgreement", (kotlin.coroutines.c<? super java.lang.String>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00e4, code lost:
        if (r14 != r1) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e6, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00e7, code lost:
        r14 = (java.lang.String) r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ea, code lost:
        r0.f36350a = r4;
        r0.f36351b = r2;
        r0.f36357h = 3;
        r14 = r4.a("sns_status_VIDEO_IDENT_footerHtml", (kotlin.coroutines.c<? super java.lang.String>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f7, code lost:
        if (r14 != r1) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f9, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fa, code lost:
        r14 = (java.lang.String) r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fc, code lost:
        r5 = r2.c();
        r2 = r2.a();
        r6 = com.sumsub.sns.internal.ff.a.f34215a.s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x010e, code lost:
        if (r6.g() == false) goto L_0x0111;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0111, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0112, code lost:
        if (r6 == null) goto L_0x0172;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0114, code lost:
        r0.f36350a = r4;
        r0.f36351b = r5;
        r0.f36352c = r14;
        r0.f36353d = r2;
        r0.f36357h = 4;
        r3 = r4.a("sns_alert_aboutToExitVerification", (kotlin.coroutines.c<? super java.lang.String>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0125, code lost:
        if (r3 != r1) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0127, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0128, code lost:
        r6 = r4;
        r4 = r5;
        r12 = r3;
        r3 = r14;
        r14 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x012d, code lost:
        r14 = (java.lang.CharSequence) r14;
        r0.f36350a = r6;
        r0.f36351b = r14;
        r0.f36352c = r4;
        r0.f36353d = r3;
        r0.f36354e = r2;
        r0.f36357h = 5;
        r5 = r6.a("sns_alert_action_confirm", (kotlin.coroutines.c<? super java.lang.String>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0142, code lost:
        if (r5 != r1) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0144, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0145, code lost:
        r12 = r5;
        r5 = r14;
        r14 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0148, code lost:
        r14 = (java.lang.CharSequence) r14;
        r0.f36350a = r5;
        r0.f36351b = r14;
        r0.f36352c = r4;
        r0.f36353d = r3;
        r0.f36354e = r2;
        r0.f36357h = 6;
        r0 = r6.a("sns_alert_action_cancel", (kotlin.coroutines.c<? super java.lang.String>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x015d, code lost:
        if (r0 != r1) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x015f, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0160, code lost:
        r1 = r2;
        r2 = r3;
        r3 = r4;
        r4 = r14;
        r14 = r0;
        r0 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0166, code lost:
        r5 = new com.sumsub.sns.internal.presentation.screen.verification.a(r0, r4, (java.lang.CharSequence) r14);
        r14 = r2;
        r2 = r1;
        r12 = r5;
        r5 = r3;
        r3 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0177, code lost:
        return new com.sumsub.sns.internal.presentation.screen.verification.d.e(r5, r14, r2, r3);
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object e(kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.verification.d.e> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.sumsub.sns.internal.presentation.screen.verification.b.d
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.sumsub.sns.internal.presentation.screen.verification.b$d r0 = (com.sumsub.sns.internal.presentation.screen.verification.b.d) r0
            int r1 = r0.f36357h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36357h = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.verification.b$d r0 = new com.sumsub.sns.internal.presentation.screen.verification.b$d
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f36355f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36357h
            r3 = 0
            switch(r2) {
                case 0: goto L_0x0099;
                case 1: goto L_0x008d;
                case 2: goto L_0x0081;
                case 3: goto L_0x0074;
                case 4: goto L_0x005e;
                case 5: goto L_0x0045;
                case 6: goto L_0x002c;
                default: goto L_0x0024;
            }
        L_0x0024:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x002c:
            java.lang.Object r1 = r0.f36354e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r2 = r0.f36353d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r3 = r0.f36352c
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r4 = r0.f36351b
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r0 = r0.f36350a
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            kotlin.k.b(r14)
            goto L_0x0166
        L_0x0045:
            java.lang.Object r2 = r0.f36354e
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r3 = r0.f36353d
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.Object r4 = r0.f36352c
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r0.f36351b
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r6 = r0.f36350a
            com.sumsub.sns.internal.presentation.screen.verification.b r6 = (com.sumsub.sns.internal.presentation.screen.verification.b) r6
            kotlin.k.b(r14)
            goto L_0x0148
        L_0x005e:
            java.lang.Object r2 = r0.f36353d
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.Object r3 = r0.f36352c
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            java.lang.Object r4 = r0.f36351b
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r0.f36350a
            com.sumsub.sns.internal.presentation.screen.verification.b r5 = (com.sumsub.sns.internal.presentation.screen.verification.b) r5
            kotlin.k.b(r14)
            r6 = r5
            goto L_0x012d
        L_0x0074:
            java.lang.Object r2 = r0.f36351b
            com.sumsub.sns.internal.core.presentation.intro.b r2 = (com.sumsub.sns.internal.core.presentation.intro.b) r2
            java.lang.Object r4 = r0.f36350a
            com.sumsub.sns.internal.presentation.screen.verification.b r4 = (com.sumsub.sns.internal.presentation.screen.verification.b) r4
            kotlin.k.b(r14)
            goto L_0x00fa
        L_0x0081:
            java.lang.Object r2 = r0.f36351b
            com.sumsub.sns.internal.core.presentation.intro.b r2 = (com.sumsub.sns.internal.core.presentation.intro.b) r2
            java.lang.Object r4 = r0.f36350a
            com.sumsub.sns.internal.presentation.screen.verification.b r4 = (com.sumsub.sns.internal.presentation.screen.verification.b) r4
            kotlin.k.b(r14)
            goto L_0x00e7
        L_0x008d:
            java.lang.Object r2 = r0.f36351b
            com.sumsub.sns.internal.core.presentation.intro.b r2 = (com.sumsub.sns.internal.core.presentation.intro.b) r2
            java.lang.Object r4 = r0.f36350a
            com.sumsub.sns.internal.presentation.screen.verification.b r4 = (com.sumsub.sns.internal.presentation.screen.verification.b) r4
            kotlin.k.b(r14)
            goto L_0x00cf
        L_0x0099:
            kotlin.k.b(r14)
            com.sumsub.sns.internal.core.presentation.intro.b r14 = new com.sumsub.sns.internal.core.presentation.intro.b
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r6 = r13.h()
            com.sumsub.sns.internal.core.data.model.e r2 = r13.d()
            if (r2 == 0) goto L_0x00ae
            java.util.Map r2 = r2.C()
            r7 = r2
            goto L_0x00af
        L_0x00ae:
            r7 = r3
        L_0x00af:
            com.sumsub.sns.internal.core.presentation.intro.IntroScene r2 = com.sumsub.sns.internal.core.presentation.intro.IntroScene.VIDEO_IDENT
            java.lang.String r10 = r2.getSceneName()
            r9 = 0
            r11 = 1
            java.lang.String r8 = "VIDEO_IDENT"
            r5 = r14
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.f36350a = r13
            r0.f36351b = r14
            r2 = 1
            r0.f36357h = r2
            java.lang.Object r2 = r13.f(r0)
            if (r2 != r1) goto L_0x00cb
            return r1
        L_0x00cb:
            r4 = r13
            r12 = r2
            r2 = r14
            r14 = r12
        L_0x00cf:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x00ea
            r0.f36350a = r4
            r0.f36351b = r2
            r14 = 2
            r0.f36357h = r14
            java.lang.String r14 = "sns_status_VIDEO_IDENT_footerHtml_noAgreement"
            java.lang.Object r14 = r4.a((java.lang.String) r14, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r14 != r1) goto L_0x00e7
            return r1
        L_0x00e7:
            java.lang.String r14 = (java.lang.String) r14
            goto L_0x00fc
        L_0x00ea:
            r0.f36350a = r4
            r0.f36351b = r2
            r14 = 3
            r0.f36357h = r14
            java.lang.String r14 = "sns_status_VIDEO_IDENT_footerHtml"
            java.lang.Object r14 = r4.a((java.lang.String) r14, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r14 != r1) goto L_0x00fa
            return r1
        L_0x00fa:
            java.lang.String r14 = (java.lang.String) r14
        L_0x00fc:
            java.util.Map r5 = r2.c()
            java.lang.String r2 = r2.a()
            com.sumsub.sns.internal.ff.a r6 = com.sumsub.sns.internal.ff.a.f34215a
            com.sumsub.sns.internal.ff.core.a r6 = r6.s()
            boolean r7 = r6.g()
            if (r7 == 0) goto L_0x0111
            goto L_0x0112
        L_0x0111:
            r6 = r3
        L_0x0112:
            if (r6 == 0) goto L_0x0172
            r0.f36350a = r4
            r0.f36351b = r5
            r0.f36352c = r14
            r0.f36353d = r2
            r3 = 4
            r0.f36357h = r3
            java.lang.String r3 = "sns_alert_aboutToExitVerification"
            java.lang.Object r3 = r4.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r3 != r1) goto L_0x0128
            return r1
        L_0x0128:
            r6 = r4
            r4 = r5
            r12 = r3
            r3 = r14
            r14 = r12
        L_0x012d:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r0.f36350a = r6
            r0.f36351b = r14
            r0.f36352c = r4
            r0.f36353d = r3
            r0.f36354e = r2
            r5 = 5
            r0.f36357h = r5
            java.lang.String r5 = "sns_alert_action_confirm"
            java.lang.Object r5 = r6.a((java.lang.String) r5, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r5 != r1) goto L_0x0145
            return r1
        L_0x0145:
            r12 = r5
            r5 = r14
            r14 = r12
        L_0x0148:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            r0.f36350a = r5
            r0.f36351b = r14
            r0.f36352c = r4
            r0.f36353d = r3
            r0.f36354e = r2
            r7 = 6
            r0.f36357h = r7
            java.lang.String r7 = "sns_alert_action_cancel"
            java.lang.Object r0 = r6.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x0160
            return r1
        L_0x0160:
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r14
            r14 = r0
            r0 = r5
        L_0x0166:
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            com.sumsub.sns.internal.presentation.screen.verification.a r5 = new com.sumsub.sns.internal.presentation.screen.verification.a
            r5.<init>(r0, r4, r14)
            r14 = r2
            r2 = r1
            r12 = r5
            r5 = r3
            r3 = r12
        L_0x0172:
            com.sumsub.sns.internal.presentation.screen.verification.d$e r0 = new com.sumsub.sns.internal.presentation.screen.verification.d$e
            r0.<init>(r5, r14, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.e(kotlin.coroutines.c):java.lang.Object");
    }

    public final void c(com.sumsub.sns.internal.core.presentation.helper.b bVar) {
        b(false);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new n(this, bVar, (kotlin.coroutines.c<? super n>) null), 1, (Object) null);
    }

    public final void d(com.sumsub.sns.internal.core.presentation.helper.b bVar) {
        b(false);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new o(bVar, this, (kotlin.coroutines.c<? super o>) null), 1, (Object) null);
    }

    public final void b(Throwable th2) {
        com.sumsub.sns.core.c.f30748a.a(B, "Error when getting data...", th2);
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) this, th2, DocumentType.f32355j, (Object) null, 4, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02be, code lost:
        if (r1 == null) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02c4, code lost:
        if (r1.length() != 0) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02c6, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02c8, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02ca, code lost:
        if ((!r6) == false) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02cd, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02ce, code lost:
        if (r1 == null) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02d0, code lost:
        r1 = r5.f36344u.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02d6, code lost:
        if (r1 == null) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02d9, code lost:
        r3.f36388a = r5;
        r3.f36389b = r2;
        r3.f36398k = 7;
        r1 = r5.a("sns_status_REJECT_subtitle", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02e4, code lost:
        if (r1 != r4) goto L_0x02e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02e6, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x02e7, code lost:
        r26 = r2;
        r2 = r1;
        r1 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02ec, code lost:
        r2 = (java.lang.String) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02ee, code lost:
        if (r2 == null) goto L_0x02fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02f0, code lost:
        r26 = r5.f36344u.a(r2);
        r2 = r1;
        r1 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x02fc, code lost:
        r2 = r1;
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02fe, code lost:
        r7 = new com.sumsub.sns.internal.core.presentation.base.adapter.f(r2, r1, com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED);
        r3.f36388a = r5;
        r3.f36389b = r7;
        r3.f36398k = 8;
        r2 = r5.a("sns_status_REJECT_footerHtml", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0311, code lost:
        if (r2 != r4) goto L_0x0314;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0313, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0314, code lost:
        r3 = r5;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0316, code lost:
        r4 = new com.sumsub.sns.internal.presentation.screen.verification.d.C0487d(r1, (java.lang.CharSequence) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0336, code lost:
        r2 = (java.lang.CharSequence) r2;
        r3.f36388a = r8;
        r3.f36389b = r1;
        r3.f36390c = r5;
        r3.f36391d = r2;
        r3.f36398k = 10;
        r6 = r8.a("sns_status_REJECT_subtitle", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0346, code lost:
        if (r6 != r4) goto L_0x0349;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0348, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0349, code lost:
        r7 = r1;
        r1 = r2;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x034c, code lost:
        r2 = (java.lang.CharSequence) r2;
        r3.f36388a = r8;
        r3.f36389b = r7;
        r3.f36390c = r5;
        r3.f36391d = r1;
        r3.f36392e = r2;
        r3.f36398k = 11;
        r6 = r8.a("sns_status_REJECT_footerHtml", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0360, code lost:
        if (r6 != r4) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0362, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0363, code lost:
        r16 = r1;
        r17 = r2;
        r10 = r5;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0369, code lost:
        r15 = new com.sumsub.sns.internal.presentation.screen.verification.d.b(r16, r17, (java.lang.CharSequence) r2, kotlin.collections.CollectionsKt__CollectionsKt.k(), (java.lang.CharSequence) null);
        r1 = r8.a(r7.e(), r10);
        r2 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r1, 10));
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0392, code lost:
        if (r1.hasNext() == false) goto L_0x03b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0394, code lost:
        r2.add(com.sumsub.sns.internal.core.presentation.helper.a.a(r8.h(), (com.sumsub.sns.internal.core.data.model.Document) r1.next(), com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewed, true, r7, (java.lang.String) null, 32, (java.lang.Object) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x03b4, code lost:
        r1 = new java.util.ArrayList();
        r6 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x03c1, code lost:
        if (r6.hasNext() == false) goto L_0x03ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03c3, code lost:
        r7 = r6.next();
        r9 = (com.sumsub.sns.internal.core.presentation.base.adapter.c) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x03d2, code lost:
        if (r10.I().k() == false) goto L_0x03f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x03d4, code lost:
        r15 = r10.I().j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x03dc, code lost:
        if (r15 == null) goto L_0x03f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x03de, code lost:
        r9 = r15.contains(r9.j().c().getType().c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x03f3, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x03f4, code lost:
        if (r9 != false) goto L_0x03f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x03f6, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x03f8, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x03f9, code lost:
        if (r9 == false) goto L_0x03bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x03fb, code lost:
        r1.add(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0404, code lost:
        if ((!r1.isEmpty()) == false) goto L_0x04b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x040a, code lost:
        if (r1.isEmpty() == false) goto L_0x040d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x040d, code lost:
        r6 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0415, code lost:
        if (r6.hasNext() == false) goto L_0x042e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x042a, code lost:
        if ((!((com.sumsub.sns.internal.core.presentation.base.adapter.c) r6.next()).j().c().isApproved()) == false) goto L_0x0411;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x042c, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x042e, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x042f, code lost:
        if (r6 == false) goto L_0x04b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0435, code lost:
        if (r1.isEmpty() == false) goto L_0x0438;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x0438, code lost:
        r6 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0440, code lost:
        if (r6.hasNext() == false) goto L_0x0457;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x044e, code lost:
        if (((com.sumsub.sns.internal.core.presentation.base.adapter.c) r6.next()).g() != com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED) goto L_0x0452;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0450, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0452, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0453, code lost:
        if (r7 != false) goto L_0x043c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x0455, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0457, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0458, code lost:
        if (r6 == false) goto L_0x04b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x045e, code lost:
        if (r1.isEmpty() == false) goto L_0x0461;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0461, code lost:
        r6 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0469, code lost:
        if (r6.hasNext() == false) goto L_0x04ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x046b, code lost:
        r7 = (com.sumsub.sns.internal.core.presentation.base.adapter.c) r6.next();
        r9 = r7.j().c().getReview();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x047d, code lost:
        if (r9 == null) goto L_0x0484;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x047f, code lost:
        r9 = r9.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x0484, code lost:
        r9 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0485, code lost:
        if (r9 == null) goto L_0x0490;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x048b, code lost:
        if (r9.length() != 0) goto L_0x048e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x048e, code lost:
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x0490, code lost:
        r9 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0491, code lost:
        if (r9 != false) goto L_0x04a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x04a3, code lost:
        if (r7.j().c().getType().d() == false) goto L_0x04a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x04a6, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x04a8, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x04a9, code lost:
        if (r7 != false) goto L_0x0465;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x04ab, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04ad, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x04ae, code lost:
        if (r6 == false) goto L_0x04b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x04b0, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04b2, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04b3, code lost:
        if (r6 == false) goto L_0x04b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x04b6, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04b7, code lost:
        if (r1 == null) goto L_0x0533;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x04b9, code lost:
        r6 = new java.util.ArrayList();
        r7 = r2.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x04c6, code lost:
        if (r7.hasNext() == false) goto L_0x04da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x04c8, code lost:
        r9 = r7.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x04d4, code lost:
        if ((!r1.contains((com.sumsub.sns.internal.core.presentation.base.adapter.c) r9)) == false) goto L_0x04c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x04d6, code lost:
        r6.add(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04da, code lost:
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r6);
        r7 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r1, 10));
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x04ef, code lost:
        if (r1.hasNext() == false) goto L_0x0503;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x04f1, code lost:
        r7.add(((com.sumsub.sns.internal.core.presentation.base.adapter.c) r1.next()).j().c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x0503, code lost:
        r3.f36388a = r8;
        r3.f36389b = r10;
        r3.f36390c = r15;
        r3.f36391d = r15;
        r3.f36392e = r6;
        r3.f36393f = r15;
        r3.f36394g = r6;
        r3.f36395h = r2;
        r3.f36398k = 12;
        r1 = r8.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r7, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.base.adapter.c>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x051b, code lost:
        if (r1 != r4) goto L_0x051e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x051d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x051e, code lost:
        r9 = r15;
        r4 = r6;
        r7 = r4;
        r3 = r8;
        r8 = r9;
        r26 = r2;
        r2 = r1;
        r1 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0528, code lost:
        r4.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x052b, code lost:
        if (r7 == null) goto L_0x052f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x052d, code lost:
        r4 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x052f, code lost:
        r2 = r1;
        r1 = r5;
        r5 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x0533, code lost:
        r1 = r15;
        r3 = r8;
        r8 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:226:0x0536, code lost:
        r7 = r2;
        r4 = r5;
        r5 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0539, code lost:
        r5.a((java.util.List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a>) r7);
        r1 = r10.J().o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0544, code lost:
        if (r1 == null) goto L_0x06a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x0546, code lost:
        r1 = r1.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:230:0x054a, code lost:
        if (r1 == null) goto L_0x06a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x054c, code lost:
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r8.b());
        r2.add(0, new com.sumsub.sns.internal.core.presentation.base.adapter.d(r1));
        r1 = kotlin.Unit.f56620a;
        r8.a((java.util.List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x0599, code lost:
        r2 = (java.lang.CharSequence) r2;
        r3.f36388a = r9;
        r3.f36389b = r1;
        r3.f36390c = r5;
        r3.f36391d = r2;
        r3.f36398k = 14;
        r6 = r9.a("sns_status_APPROVED_subtitle", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x05ab, code lost:
        if (r6 != r4) goto L_0x05ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x05ad, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x05ae, code lost:
        r8 = r1;
        r1 = r2;
        r2 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x05b1, code lost:
        r2 = (java.lang.CharSequence) r2;
        r3.f36388a = r9;
        r3.f36389b = r8;
        r3.f36390c = r5;
        r3.f36391d = r1;
        r3.f36392e = r2;
        r3.f36398k = 15;
        r3 = r9.a("sns_status_APPROVED_footerHtml", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x05c5, code lost:
        if (r3 != r4) goto L_0x05c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x05c7, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x05c8, code lost:
        r4 = r1;
        r7 = r8;
        r8 = r5;
        r26 = r3;
        r3 = r2;
        r2 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:254:0x05d0, code lost:
        r1 = new com.sumsub.sns.internal.presentation.screen.verification.d.b(r4, r3, (java.lang.CharSequence) r2, kotlin.collections.CollectionsKt__CollectionsKt.k(), (java.lang.CharSequence) null);
        r1 = r7;
        r5 = r8;
        r3 = r9;
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:269:0x061c, code lost:
        r2 = (java.lang.CharSequence) r2;
        r3.f36388a = r7;
        r3.f36389b = r1;
        r3.f36390c = r5;
        r3.f36391d = r2;
        r3.f36398k = 17;
        r6 = r7.a("sns_status_REJECT_subtitle", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:270:0x062e, code lost:
        if (r6 != r4) goto L_0x0631;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:271:0x0630, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0631, code lost:
        r26 = r6;
        r6 = r1;
        r1 = r2;
        r2 = r26;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:273:0x0637, code lost:
        r2 = (java.lang.CharSequence) r2;
        r3.f36388a = r7;
        r3.f36389b = r6;
        r3.f36390c = r5;
        r3.f36391d = r1;
        r3.f36392e = r2;
        r3.f36398k = 18;
        r3 = r7.a("sns_status_REJECT_footerHtml", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:274:0x064b, code lost:
        if (r3 != r4) goto L_0x064e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:275:0x064d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x064e, code lost:
        r16 = r1;
        r17 = r2;
        r2 = r3;
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:277:0x0654, code lost:
        r4 = new com.sumsub.sns.internal.presentation.screen.verification.d.b(r16, r17, (java.lang.CharSequence) r2, kotlin.collections.CollectionsKt__CollectionsKt.k(), (java.lang.CharSequence) null);
        r1 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:279:0x066f, code lost:
        r2 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.u(r5, 10));
        r5 = r5.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:281:0x0680, code lost:
        if (r5.hasNext() == false) goto L_0x06a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x0682, code lost:
        r2.add(com.sumsub.sns.internal.core.presentation.helper.a.a(r3.h(), (com.sumsub.sns.internal.core.data.model.Document) r5.next(), com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewed, false, r1, (java.lang.String) null, 40, (java.lang.Object) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x06a2, code lost:
        r4.a((java.util.List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a>) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:285:0x06a7, code lost:
        if ((r4 instanceof com.sumsub.sns.internal.presentation.screen.verification.d.C0487d) == false) goto L_0x0706;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:286:0x06a9, code lost:
        r1 = r4.b();
        r2 = new java.util.ArrayList();
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x06ba, code lost:
        if (r1.hasNext() == false) goto L_0x06c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x06bc, code lost:
        r5 = r1.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x06c2, code lost:
        if ((r5 instanceof com.sumsub.sns.internal.core.presentation.base.adapter.f) == false) goto L_0x06b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:291:0x06c4, code lost:
        r2.add(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x06c8, code lost:
        r1 = (com.sumsub.sns.internal.core.presentation.base.adapter.f) kotlin.collections.CollectionsKt___CollectionsKt.c0(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:293:0x06ce, code lost:
        if (r1 == null) goto L_0x06d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:294:0x06d0, code lost:
        r1 = r1.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:295:0x06d5, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x06d6, code lost:
        r2 = com.sumsub.sns.internal.core.common.e0.f32018a.getAutoCloseOnApproveTimeout();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x06dc, code lost:
        if (r2 == null) goto L_0x06e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x06de, code lost:
        r6 = r2.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:299:0x06e3, code lost:
        r6 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:301:0x06e6, code lost:
        if (r1 != com.sumsub.sns.internal.core.widget.SNSStepState.APPROVED) goto L_0x0706;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:302:0x06e8, code lost:
        if (r6 <= 0) goto L_0x0706;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x06ea, code lost:
        com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r3, (com.sumsub.sns.internal.core.common.q) new com.sumsub.sns.internal.core.common.q.d((com.sumsub.sns.core.data.model.SNSCompletionResult) null, 1, (kotlin.jvm.internal.r) null), (java.lang.Object) null, kotlin.coroutines.jvm.internal.a.d(java.util.concurrent.TimeUnit.SECONDS.toMillis((long) r6)), 2, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x0706, code lost:
        com.sumsub.sns.core.presentation.base.a.a(r3, false, new com.sumsub.sns.internal.presentation.screen.verification.b.m(r4, (kotlin.coroutines.c<? super com.sumsub.sns.internal.presentation.screen.verification.b.m>) null), 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x0710, code lost:
        return kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01cd, code lost:
        r3.f36388a = r1;
        r3.f36398k = 2;
        r2 = r1.a("sns_status_APPROVED_subtitle", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x01d6, code lost:
        if (r2 != r4) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x01d8, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01d9, code lost:
        r2 = (java.lang.String) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x01db, code lost:
        if (r2 == null) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x01dd, code lost:
        r2 = r1.f36344u.a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01e4, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01e5, code lost:
        r8 = new com.sumsub.sns.internal.core.presentation.base.adapter.f(r2, (java.lang.CharSequence) null, com.sumsub.sns.internal.core.widget.SNSStepState.APPROVED);
        r3.f36388a = r1;
        r3.f36389b = r8;
        r3.f36398k = 3;
        r2 = r1.a("sns_status_APPROVED_footerHtml", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01f6, code lost:
        if (r2 != r4) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01f8, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01f9, code lost:
        r3 = r1;
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01fb, code lost:
        r4 = new com.sumsub.sns.internal.presentation.screen.verification.d.C0487d(r1, (java.lang.CharSequence) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0220, code lost:
        r2 = (java.lang.String) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0222, code lost:
        if (r2 == null) goto L_0x022b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0224, code lost:
        r2 = r5.f36344u.a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x022b, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x022c, code lost:
        r1 = r1.J().o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0234, code lost:
        if (r1 == null) goto L_0x0243;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0236, code lost:
        r1 = r1.g();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x023a, code lost:
        if (r1 == null) goto L_0x0243;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x023c, code lost:
        r1 = r5.f36344u.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0243, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0244, code lost:
        r8 = new com.sumsub.sns.internal.core.presentation.base.adapter.f(r2, r1, com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED);
        r3.f36388a = r5;
        r3.f36389b = r8;
        r3.f36398k = 5;
        r2 = r5.a("sns_status_FINAL_REJECT_footerHtml", (kotlin.coroutines.c<? super java.lang.String>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0258, code lost:
        if (r2 != r4) goto L_0x025b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x025a, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x025b, code lost:
        r3 = r5;
        r1 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x025d, code lost:
        r4 = new com.sumsub.sns.internal.presentation.screen.verification.d.C0487d(r1, (java.lang.CharSequence) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02a4, code lost:
        r2 = (java.lang.String) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02a6, code lost:
        if (r2 == null) goto L_0x02af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02a8, code lost:
        r2 = r5.f36344u.a(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02af, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02b0, code lost:
        r1 = r1.J().o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02b8, code lost:
        if (r1 == null) goto L_0x02d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02ba, code lost:
        r1 = r1.g();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x015c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0585  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x05e8  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0037  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(com.sumsub.sns.internal.core.presentation.helper.b r28, kotlin.coroutines.c<? super kotlin.Unit> r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            boolean r3 = r2 instanceof com.sumsub.sns.internal.presentation.screen.verification.b.l
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.presentation.screen.verification.b$l r3 = (com.sumsub.sns.internal.presentation.screen.verification.b.l) r3
            int r4 = r3.f36398k
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f36398k = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.presentation.screen.verification.b$l r3 = new com.sumsub.sns.internal.presentation.screen.verification.b$l
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f36396i
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r3.f36398k
            r6 = 3
            java.lang.String r7 = "sns_status_APPROVED_footerHtml"
            java.lang.String r8 = "sns_status_APPROVED_subtitle"
            java.lang.String r9 = "sns_status_REJECT_footerHtml"
            java.lang.String r10 = "sns_status_REJECT_subtitle"
            r11 = 10
            r12 = 0
            r13 = 0
            r14 = 1
            switch(r5) {
                case 0: goto L_0x01a0;
                case 1: goto L_0x0198;
                case 2: goto L_0x0190;
                case 3: goto L_0x0183;
                case 4: goto L_0x0176;
                case 5: goto L_0x0169;
                case 6: goto L_0x015c;
                case 7: goto L_0x014f;
                case 8: goto L_0x0142;
                case 9: goto L_0x012b;
                case 10: goto L_0x0116;
                case 11: goto L_0x00f6;
                case 12: goto L_0x00d1;
                case 13: goto L_0x00bb;
                case 14: goto L_0x00a6;
                case 15: goto L_0x008a;
                case 16: goto L_0x0074;
                case 17: goto L_0x005d;
                case 18: goto L_0x003f;
                default: goto L_0x0037;
            }
        L_0x0037:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003f:
            java.lang.Object r1 = r3.f36392e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r4 = r3.f36391d
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r5 = r3.f36390c
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r7 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.helper.b r7 = (com.sumsub.sns.internal.core.presentation.helper.b) r7
            java.lang.Object r3 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r3 = (com.sumsub.sns.internal.presentation.screen.verification.b) r3
            kotlin.k.b(r2)
            r17 = r1
            r16 = r4
            r6 = r7
            goto L_0x0654
        L_0x005d:
            java.lang.Object r1 = r3.f36391d
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r5 = r3.f36390c
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r7 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.helper.b r7 = (com.sumsub.sns.internal.core.presentation.helper.b) r7
            java.lang.Object r8 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r8 = (com.sumsub.sns.internal.presentation.screen.verification.b) r8
            kotlin.k.b(r2)
            r6 = r7
            r7 = r8
            goto L_0x0637
        L_0x0074:
            java.lang.Object r1 = r3.f36390c
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.helper.b r5 = (com.sumsub.sns.internal.core.presentation.helper.b) r5
            java.lang.Object r7 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r7 = (com.sumsub.sns.internal.presentation.screen.verification.b) r7
            kotlin.k.b(r2)
            r26 = r5
            r5 = r1
            r1 = r26
            goto L_0x061c
        L_0x008a:
            java.lang.Object r1 = r3.f36392e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r4 = r3.f36391d
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            java.lang.Object r5 = r3.f36390c
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r7 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.helper.b r7 = (com.sumsub.sns.internal.core.presentation.helper.b) r7
            java.lang.Object r3 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r3 = (com.sumsub.sns.internal.presentation.screen.verification.b) r3
            kotlin.k.b(r2)
            r9 = r3
            r8 = r5
            r3 = r1
            goto L_0x05d0
        L_0x00a6:
            java.lang.Object r1 = r3.f36391d
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r5 = r3.f36390c
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r8 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.helper.b r8 = (com.sumsub.sns.internal.core.presentation.helper.b) r8
            java.lang.Object r9 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r9 = (com.sumsub.sns.internal.presentation.screen.verification.b) r9
            kotlin.k.b(r2)
            goto L_0x05b1
        L_0x00bb:
            java.lang.Object r1 = r3.f36390c
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.helper.b r5 = (com.sumsub.sns.internal.core.presentation.helper.b) r5
            java.lang.Object r9 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r9 = (com.sumsub.sns.internal.presentation.screen.verification.b) r9
            kotlin.k.b(r2)
            r26 = r5
            r5 = r1
            r1 = r26
            goto L_0x0599
        L_0x00d1:
            java.lang.Object r1 = r3.f36395h
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r4 = r3.f36394g
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r3.f36393f
            com.sumsub.sns.internal.presentation.screen.verification.d$b r5 = (com.sumsub.sns.internal.presentation.screen.verification.d.b) r5
            java.lang.Object r7 = r3.f36392e
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r8 = r3.f36391d
            com.sumsub.sns.internal.presentation.screen.verification.d$b r8 = (com.sumsub.sns.internal.presentation.screen.verification.d.b) r8
            java.lang.Object r9 = r3.f36390c
            com.sumsub.sns.internal.presentation.screen.verification.d$b r9 = (com.sumsub.sns.internal.presentation.screen.verification.d.b) r9
            java.lang.Object r10 = r3.f36389b
            com.sumsub.sns.internal.core.data.model.g r10 = (com.sumsub.sns.internal.core.data.model.g) r10
            java.lang.Object r3 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r3 = (com.sumsub.sns.internal.presentation.screen.verification.b) r3
            kotlin.k.b(r2)
            goto L_0x0528
        L_0x00f6:
            java.lang.Object r1 = r3.f36392e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r5 = r3.f36391d
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.lang.Object r7 = r3.f36390c
            com.sumsub.sns.internal.core.data.model.g r7 = (com.sumsub.sns.internal.core.data.model.g) r7
            java.lang.Object r8 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.helper.b r8 = (com.sumsub.sns.internal.core.presentation.helper.b) r8
            java.lang.Object r9 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r9 = (com.sumsub.sns.internal.presentation.screen.verification.b) r9
            kotlin.k.b(r2)
            r17 = r1
            r16 = r5
            r10 = r7
            r7 = r8
            r8 = r9
            goto L_0x0369
        L_0x0116:
            java.lang.Object r1 = r3.f36391d
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r5 = r3.f36390c
            com.sumsub.sns.internal.core.data.model.g r5 = (com.sumsub.sns.internal.core.data.model.g) r5
            java.lang.Object r7 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.helper.b r7 = (com.sumsub.sns.internal.core.presentation.helper.b) r7
            java.lang.Object r8 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r8 = (com.sumsub.sns.internal.presentation.screen.verification.b) r8
            kotlin.k.b(r2)
            goto L_0x034c
        L_0x012b:
            java.lang.Object r1 = r3.f36390c
            com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
            java.lang.Object r5 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.helper.b r5 = (com.sumsub.sns.internal.core.presentation.helper.b) r5
            java.lang.Object r7 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r7 = (com.sumsub.sns.internal.presentation.screen.verification.b) r7
            kotlin.k.b(r2)
            r8 = r7
            r26 = r5
            r5 = r1
            r1 = r26
            goto L_0x0336
        L_0x0142:
            java.lang.Object r1 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.base.adapter.f r1 = (com.sumsub.sns.internal.core.presentation.base.adapter.f) r1
            java.lang.Object r3 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r3 = (com.sumsub.sns.internal.presentation.screen.verification.b) r3
            kotlin.k.b(r2)
            goto L_0x0316
        L_0x014f:
            java.lang.Object r1 = r3.f36389b
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            java.lang.Object r5 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r5 = (com.sumsub.sns.internal.presentation.screen.verification.b) r5
            kotlin.k.b(r2)
            goto L_0x02ec
        L_0x015c:
            java.lang.Object r1 = r3.f36389b
            com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
            java.lang.Object r5 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r5 = (com.sumsub.sns.internal.presentation.screen.verification.b) r5
            kotlin.k.b(r2)
            goto L_0x02a4
        L_0x0169:
            java.lang.Object r1 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.base.adapter.f r1 = (com.sumsub.sns.internal.core.presentation.base.adapter.f) r1
            java.lang.Object r3 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r3 = (com.sumsub.sns.internal.presentation.screen.verification.b) r3
            kotlin.k.b(r2)
            goto L_0x025d
        L_0x0176:
            java.lang.Object r1 = r3.f36389b
            com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
            java.lang.Object r5 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r5 = (com.sumsub.sns.internal.presentation.screen.verification.b) r5
            kotlin.k.b(r2)
            goto L_0x0220
        L_0x0183:
            java.lang.Object r1 = r3.f36389b
            com.sumsub.sns.internal.core.presentation.base.adapter.f r1 = (com.sumsub.sns.internal.core.presentation.base.adapter.f) r1
            java.lang.Object r3 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r3 = (com.sumsub.sns.internal.presentation.screen.verification.b) r3
            kotlin.k.b(r2)
            goto L_0x01fb
        L_0x0190:
            java.lang.Object r1 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r1 = (com.sumsub.sns.internal.presentation.screen.verification.b) r1
            kotlin.k.b(r2)
            goto L_0x01d9
        L_0x0198:
            java.lang.Object r1 = r3.f36388a
            com.sumsub.sns.internal.presentation.screen.verification.b r1 = (com.sumsub.sns.internal.presentation.screen.verification.b) r1
            kotlin.k.b(r2)
            goto L_0x01cd
        L_0x01a0:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.core.data.model.g r2 = r0.f36345v
            if (r2 != 0) goto L_0x01aa
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x01aa:
            java.util.List<com.sumsub.sns.internal.core.data.model.Document> r5 = r0.f36346w
            if (r5 != 0) goto L_0x01b1
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        L_0x01b1:
            boolean r15 = r2.M()
            if (r15 == 0) goto L_0x0204
            com.sumsub.sns.core.presentation.base.a$l r1 = r27.c()
            boolean r1 = r1 instanceof com.sumsub.sns.internal.presentation.screen.verification.d.c
            if (r1 != 0) goto L_0x01cc
            r3.f36388a = r0
            r3.f36398k = r14
            r1 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.b(r1, r3)
            if (r1 != r4) goto L_0x01cc
            return r4
        L_0x01cc:
            r1 = r0
        L_0x01cd:
            r3.f36388a = r1
            r2 = 2
            r3.f36398k = r2
            java.lang.Object r2 = r1.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x01d9
            return r4
        L_0x01d9:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x01e4
            com.sumsub.sns.internal.core.data.source.extensions.a r5 = r1.f36344u
            android.text.Spanned r2 = r5.a(r2)
            goto L_0x01e5
        L_0x01e4:
            r2 = r12
        L_0x01e5:
            com.sumsub.sns.internal.core.widget.SNSStepState r5 = com.sumsub.sns.internal.core.widget.SNSStepState.APPROVED
            com.sumsub.sns.internal.core.presentation.base.adapter.f r8 = new com.sumsub.sns.internal.core.presentation.base.adapter.f
            r8.<init>(r2, r12, r5)
            r3.f36388a = r1
            r3.f36389b = r8
            r3.f36398k = r6
            java.lang.Object r2 = r1.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x01f9
            return r4
        L_0x01f9:
            r3 = r1
            r1 = r8
        L_0x01fb:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.sumsub.sns.internal.presentation.screen.verification.d$d r4 = new com.sumsub.sns.internal.presentation.screen.verification.d$d
            r4.<init>(r1, r2)
            goto L_0x06a5
        L_0x0204:
            boolean r15 = r2.O()
            if (r15 == 0) goto L_0x0266
            r3.f36388a = r0
            r3.f36389b = r2
            r1 = 4
            r3.f36398k = r1
            java.lang.String r1 = "sns_status_FINAL_REJECT_subtitle"
            java.lang.Object r1 = r0.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r1 != r4) goto L_0x021a
            return r4
        L_0x021a:
            r5 = r0
            r26 = r2
            r2 = r1
            r1 = r26
        L_0x0220:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x022b
            com.sumsub.sns.internal.core.data.source.extensions.a r7 = r5.f36344u
            android.text.Spanned r2 = r7.a(r2)
            goto L_0x022c
        L_0x022b:
            r2 = r12
        L_0x022c:
            com.sumsub.sns.internal.core.data.model.g$d r1 = r1.J()
            com.sumsub.sns.internal.core.data.model.g$d$a r1 = r1.o()
            if (r1 == 0) goto L_0x0243
            java.lang.String r1 = r1.g()
            if (r1 == 0) goto L_0x0243
            com.sumsub.sns.internal.core.data.source.extensions.a r7 = r5.f36344u
            android.text.Spanned r1 = r7.a(r1)
            goto L_0x0244
        L_0x0243:
            r1 = r12
        L_0x0244:
            com.sumsub.sns.internal.core.widget.SNSStepState r7 = com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED
            com.sumsub.sns.internal.core.presentation.base.adapter.f r8 = new com.sumsub.sns.internal.core.presentation.base.adapter.f
            r8.<init>(r2, r1, r7)
            r3.f36388a = r5
            r3.f36389b = r8
            r1 = 5
            r3.f36398k = r1
            java.lang.String r1 = "sns_status_FINAL_REJECT_footerHtml"
            java.lang.Object r2 = r5.a((java.lang.String) r1, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x025b
            return r4
        L_0x025b:
            r3 = r5
            r1 = r8
        L_0x025d:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.sumsub.sns.internal.presentation.screen.verification.d$d r4 = new com.sumsub.sns.internal.presentation.screen.verification.d$d
            r4.<init>(r1, r2)
            goto L_0x06a5
        L_0x0266:
            boolean r15 = r2.P()
            java.lang.String r6 = "sns_status_REJECT_title"
            if (r15 == 0) goto L_0x0563
            boolean r7 = r5.isEmpty()
            if (r7 == 0) goto L_0x0275
            goto L_0x028d
        L_0x0275:
            java.util.Iterator r5 = r5.iterator()
        L_0x0279:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x028d
            java.lang.Object r7 = r5.next()
            com.sumsub.sns.internal.core.data.model.Document r7 = (com.sumsub.sns.internal.core.data.model.Document) r7
            boolean r7 = r7.isApproved()
            if (r7 != 0) goto L_0x0279
            r5 = r13
            goto L_0x028e
        L_0x028d:
            r5 = r14
        L_0x028e:
            if (r5 == 0) goto L_0x031f
            r3.f36388a = r0
            r3.f36389b = r2
            r1 = 6
            r3.f36398k = r1
            java.lang.Object r1 = r0.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r1 != r4) goto L_0x029e
            return r4
        L_0x029e:
            r5 = r0
            r26 = r2
            r2 = r1
            r1 = r26
        L_0x02a4:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x02af
            com.sumsub.sns.internal.core.data.source.extensions.a r6 = r5.f36344u
            android.text.Spanned r2 = r6.a(r2)
            goto L_0x02b0
        L_0x02af:
            r2 = r12
        L_0x02b0:
            com.sumsub.sns.internal.core.data.model.g$d r1 = r1.J()
            com.sumsub.sns.internal.core.data.model.g$d$a r1 = r1.o()
            if (r1 == 0) goto L_0x02d9
            java.lang.String r1 = r1.g()
            if (r1 == 0) goto L_0x02d9
            int r6 = r1.length()
            if (r6 != 0) goto L_0x02c8
            r6 = r14
            goto L_0x02c9
        L_0x02c8:
            r6 = r13
        L_0x02c9:
            r6 = r6 ^ r14
            if (r6 == 0) goto L_0x02cd
            goto L_0x02ce
        L_0x02cd:
            r1 = r12
        L_0x02ce:
            if (r1 == 0) goto L_0x02d9
            com.sumsub.sns.internal.core.data.source.extensions.a r6 = r5.f36344u
            android.text.Spanned r1 = r6.a(r1)
            if (r1 == 0) goto L_0x02d9
            goto L_0x02fe
        L_0x02d9:
            r3.f36388a = r5
            r3.f36389b = r2
            r1 = 7
            r3.f36398k = r1
            java.lang.Object r1 = r5.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r1 != r4) goto L_0x02e7
            return r4
        L_0x02e7:
            r26 = r2
            r2 = r1
            r1 = r26
        L_0x02ec:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 == 0) goto L_0x02fc
            com.sumsub.sns.internal.core.data.source.extensions.a r6 = r5.f36344u
            android.text.Spanned r2 = r6.a(r2)
            r26 = r2
            r2 = r1
            r1 = r26
            goto L_0x02fe
        L_0x02fc:
            r2 = r1
            r1 = r12
        L_0x02fe:
            com.sumsub.sns.internal.core.widget.SNSStepState r6 = com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED
            com.sumsub.sns.internal.core.presentation.base.adapter.f r7 = new com.sumsub.sns.internal.core.presentation.base.adapter.f
            r7.<init>(r2, r1, r6)
            r3.f36388a = r5
            r3.f36389b = r7
            r1 = 8
            r3.f36398k = r1
            java.lang.Object r2 = r5.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x0314
            return r4
        L_0x0314:
            r3 = r5
            r1 = r7
        L_0x0316:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            com.sumsub.sns.internal.presentation.screen.verification.d$d r4 = new com.sumsub.sns.internal.presentation.screen.verification.d$d
            r4.<init>(r1, r2)
            goto L_0x06a5
        L_0x031f:
            r3.f36388a = r0
            r3.f36389b = r1
            r3.f36390c = r2
            r5 = 9
            r3.f36398k = r5
            java.lang.Object r5 = r0.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r5 != r4) goto L_0x0330
            return r4
        L_0x0330:
            r8 = r0
            r26 = r5
            r5 = r2
            r2 = r26
        L_0x0336:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.f36388a = r8
            r3.f36389b = r1
            r3.f36390c = r5
            r3.f36391d = r2
            r3.f36398k = r11
            java.lang.Object r6 = r8.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r6 != r4) goto L_0x0349
            return r4
        L_0x0349:
            r7 = r1
            r1 = r2
            r2 = r6
        L_0x034c:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.f36388a = r8
            r3.f36389b = r7
            r3.f36390c = r5
            r3.f36391d = r1
            r3.f36392e = r2
            r6 = 11
            r3.f36398k = r6
            java.lang.Object r6 = r8.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r6 != r4) goto L_0x0363
            return r4
        L_0x0363:
            r16 = r1
            r17 = r2
            r10 = r5
            r2 = r6
        L_0x0369:
            r18 = r2
            java.lang.CharSequence r18 = (java.lang.CharSequence) r18
            java.util.List r19 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            com.sumsub.sns.internal.presentation.screen.verification.d$b r5 = new com.sumsub.sns.internal.presentation.screen.verification.d$b
            r20 = 0
            r15 = r5
            r15.<init>(r16, r17, r18, r19, r20)
            java.util.List r1 = r7.e()
            java.util.List r1 = r8.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r1, (com.sumsub.sns.internal.core.data.model.g) r10)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.u(r1, r11)
            r2.<init>(r6)
            java.util.Iterator r1 = r1.iterator()
        L_0x038e:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x03b4
            java.lang.Object r6 = r1.next()
            r19 = r6
            com.sumsub.sns.internal.core.data.model.Document r19 = (com.sumsub.sns.internal.core.data.model.Document) r19
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r18 = r8.h()
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r20 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewed
            r21 = 1
            r23 = 0
            r24 = 32
            r25 = 0
            r22 = r7
            com.sumsub.sns.internal.core.presentation.base.adapter.c r6 = com.sumsub.sns.internal.core.presentation.helper.a.a(r18, r19, r20, r21, r22, r23, r24, r25)
            r2.add(r6)
            goto L_0x038e
        L_0x03b4:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r6 = r2.iterator()
        L_0x03bd:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x03ff
            java.lang.Object r7 = r6.next()
            r9 = r7
            com.sumsub.sns.internal.core.presentation.base.adapter.c r9 = (com.sumsub.sns.internal.core.presentation.base.adapter.c) r9
            com.sumsub.sns.internal.core.data.model.g$c r15 = r10.I()
            boolean r15 = r15.k()
            if (r15 == 0) goto L_0x03f8
            com.sumsub.sns.internal.core.data.model.g$c r15 = r10.I()
            java.util.List r15 = r15.j()
            if (r15 == 0) goto L_0x03f3
            com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo r9 = r9.j()
            com.sumsub.sns.internal.core.data.model.Document r9 = r9.c()
            com.sumsub.sns.internal.core.data.model.DocumentType r9 = r9.getType()
            java.lang.String r9 = r9.c()
            boolean r9 = r15.contains(r9)
            goto L_0x03f4
        L_0x03f3:
            r9 = r13
        L_0x03f4:
            if (r9 != 0) goto L_0x03f8
            r9 = r14
            goto L_0x03f9
        L_0x03f8:
            r9 = r13
        L_0x03f9:
            if (r9 == 0) goto L_0x03bd
            r1.add(r7)
            goto L_0x03bd
        L_0x03ff:
            boolean r6 = r1.isEmpty()
            r6 = r6 ^ r14
            if (r6 == 0) goto L_0x04b2
            boolean r6 = r1.isEmpty()
            if (r6 == 0) goto L_0x040d
            goto L_0x042e
        L_0x040d:
            java.util.Iterator r6 = r1.iterator()
        L_0x0411:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x042e
            java.lang.Object r7 = r6.next()
            com.sumsub.sns.internal.core.presentation.base.adapter.c r7 = (com.sumsub.sns.internal.core.presentation.base.adapter.c) r7
            com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo r7 = r7.j()
            com.sumsub.sns.internal.core.data.model.Document r7 = r7.c()
            boolean r7 = r7.isApproved()
            r7 = r7 ^ r14
            if (r7 == 0) goto L_0x0411
            r6 = r14
            goto L_0x042f
        L_0x042e:
            r6 = r13
        L_0x042f:
            if (r6 == 0) goto L_0x04b2
            boolean r6 = r1.isEmpty()
            if (r6 == 0) goto L_0x0438
            goto L_0x0457
        L_0x0438:
            java.util.Iterator r6 = r1.iterator()
        L_0x043c:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0457
            java.lang.Object r7 = r6.next()
            com.sumsub.sns.internal.core.presentation.base.adapter.c r7 = (com.sumsub.sns.internal.core.presentation.base.adapter.c) r7
            com.sumsub.sns.internal.core.widget.SNSStepState r7 = r7.g()
            com.sumsub.sns.internal.core.widget.SNSStepState r9 = com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED
            if (r7 != r9) goto L_0x0452
            r7 = r14
            goto L_0x0453
        L_0x0452:
            r7 = r13
        L_0x0453:
            if (r7 != 0) goto L_0x043c
            r6 = r13
            goto L_0x0458
        L_0x0457:
            r6 = r14
        L_0x0458:
            if (r6 == 0) goto L_0x04b2
            boolean r6 = r1.isEmpty()
            if (r6 == 0) goto L_0x0461
            goto L_0x04ad
        L_0x0461:
            java.util.Iterator r6 = r1.iterator()
        L_0x0465:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x04ad
            java.lang.Object r7 = r6.next()
            com.sumsub.sns.internal.core.presentation.base.adapter.c r7 = (com.sumsub.sns.internal.core.presentation.base.adapter.c) r7
            com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo r9 = r7.j()
            com.sumsub.sns.internal.core.data.model.Document r9 = r9.c()
            com.sumsub.sns.internal.core.data.model.Document$b$b r9 = r9.getReview()
            if (r9 == 0) goto L_0x0484
            java.lang.String r9 = r9.g()
            goto L_0x0485
        L_0x0484:
            r9 = r12
        L_0x0485:
            if (r9 == 0) goto L_0x0490
            int r9 = r9.length()
            if (r9 != 0) goto L_0x048e
            goto L_0x0490
        L_0x048e:
            r9 = r13
            goto L_0x0491
        L_0x0490:
            r9 = r14
        L_0x0491:
            if (r9 != 0) goto L_0x04a8
            com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo r7 = r7.j()
            com.sumsub.sns.internal.core.data.model.Document r7 = r7.c()
            com.sumsub.sns.internal.core.data.model.DocumentType r7 = r7.getType()
            boolean r7 = r7.d()
            if (r7 == 0) goto L_0x04a6
            goto L_0x04a8
        L_0x04a6:
            r7 = r13
            goto L_0x04a9
        L_0x04a8:
            r7 = r14
        L_0x04a9:
            if (r7 != 0) goto L_0x0465
            r6 = r13
            goto L_0x04ae
        L_0x04ad:
            r6 = r14
        L_0x04ae:
            if (r6 == 0) goto L_0x04b2
            r6 = r14
            goto L_0x04b3
        L_0x04b2:
            r6 = r13
        L_0x04b3:
            if (r6 == 0) goto L_0x04b6
            goto L_0x04b7
        L_0x04b6:
            r1 = r12
        L_0x04b7:
            if (r1 == 0) goto L_0x0533
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r7 = r2.iterator()
        L_0x04c2:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x04da
            java.lang.Object r9 = r7.next()
            r15 = r9
            com.sumsub.sns.internal.core.presentation.base.adapter.c r15 = (com.sumsub.sns.internal.core.presentation.base.adapter.c) r15
            boolean r15 = r1.contains(r15)
            r15 = r15 ^ r14
            if (r15 == 0) goto L_0x04c2
            r6.add(r9)
            goto L_0x04c2
        L_0x04da:
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r6)
            java.util.ArrayList r7 = new java.util.ArrayList
            int r9 = kotlin.collections.CollectionsKt__IterablesKt.u(r1, r11)
            r7.<init>(r9)
            java.util.Iterator r1 = r1.iterator()
        L_0x04eb:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L_0x0503
            java.lang.Object r9 = r1.next()
            com.sumsub.sns.internal.core.presentation.base.adapter.c r9 = (com.sumsub.sns.internal.core.presentation.base.adapter.c) r9
            com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo r9 = r9.j()
            com.sumsub.sns.internal.core.data.model.Document r9 = r9.c()
            r7.add(r9)
            goto L_0x04eb
        L_0x0503:
            r3.f36388a = r8
            r3.f36389b = r10
            r3.f36390c = r5
            r3.f36391d = r5
            r3.f36392e = r6
            r3.f36393f = r5
            r3.f36394g = r6
            r3.f36395h = r2
            r1 = 12
            r3.f36398k = r1
            java.lang.Object r1 = r8.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r7, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.base.adapter.c>) r3)
            if (r1 != r4) goto L_0x051e
            return r4
        L_0x051e:
            r9 = r5
            r4 = r6
            r7 = r4
            r3 = r8
            r8 = r9
            r26 = r2
            r2 = r1
            r1 = r26
        L_0x0528:
            r4.add(r2)
            if (r7 == 0) goto L_0x052f
            r4 = r9
            goto L_0x0539
        L_0x052f:
            r2 = r1
            r1 = r5
            r5 = r9
            goto L_0x0536
        L_0x0533:
            r1 = r5
            r3 = r8
            r8 = r1
        L_0x0536:
            r7 = r2
            r4 = r5
            r5 = r1
        L_0x0539:
            r5.a((java.util.List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a>) r7)
            com.sumsub.sns.internal.core.data.model.g$d r1 = r10.J()
            com.sumsub.sns.internal.core.data.model.g$d$a r1 = r1.o()
            if (r1 == 0) goto L_0x06a5
            java.lang.String r1 = r1.g()
            if (r1 == 0) goto L_0x06a5
            java.util.List r2 = r8.b()
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.L0(r2)
            com.sumsub.sns.internal.core.presentation.base.adapter.d r5 = new com.sumsub.sns.internal.core.presentation.base.adapter.d
            r5.<init>(r1)
            r2.add(r13, r5)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            r8.a((java.util.List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a>) r2)
            goto L_0x06a5
        L_0x0563:
            boolean r2 = r5.isEmpty()
            if (r2 == 0) goto L_0x056a
            goto L_0x0582
        L_0x056a:
            java.util.Iterator r2 = r5.iterator()
        L_0x056e:
            boolean r15 = r2.hasNext()
            if (r15 == 0) goto L_0x0582
            java.lang.Object r15 = r2.next()
            com.sumsub.sns.internal.core.data.model.Document r15 = (com.sumsub.sns.internal.core.data.model.Document) r15
            boolean r15 = r15.isApproved()
            if (r15 != 0) goto L_0x056e
            r2 = r13
            goto L_0x0583
        L_0x0582:
            r2 = r14
        L_0x0583:
            if (r2 == 0) goto L_0x05e8
            r3.f36388a = r0
            r3.f36389b = r1
            r3.f36390c = r5
            r2 = 13
            r3.f36398k = r2
            java.lang.String r2 = "sns_status_APPROVED_title"
            java.lang.Object r2 = r0.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x0598
            return r4
        L_0x0598:
            r9 = r0
        L_0x0599:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.f36388a = r9
            r3.f36389b = r1
            r3.f36390c = r5
            r3.f36391d = r2
            r6 = 14
            r3.f36398k = r6
            java.lang.Object r6 = r9.a((java.lang.String) r8, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r6 != r4) goto L_0x05ae
            return r4
        L_0x05ae:
            r8 = r1
            r1 = r2
            r2 = r6
        L_0x05b1:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.f36388a = r9
            r3.f36389b = r8
            r3.f36390c = r5
            r3.f36391d = r1
            r3.f36392e = r2
            r6 = 15
            r3.f36398k = r6
            java.lang.Object r3 = r9.a((java.lang.String) r7, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r3 != r4) goto L_0x05c8
            return r4
        L_0x05c8:
            r4 = r1
            r7 = r8
            r8 = r5
            r26 = r3
            r3 = r2
            r2 = r26
        L_0x05d0:
            r5 = r2
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            com.sumsub.sns.internal.presentation.screen.verification.d$b r10 = new com.sumsub.sns.internal.presentation.screen.verification.d$b
            r15 = 0
            r1 = r10
            r2 = r4
            r4 = r5
            r5 = r6
            r6 = r15
            r1.<init>(r2, r3, r4, r5, r6)
            r1 = r7
            r5 = r8
            r3 = r9
            r4 = r10
            goto L_0x066f
        L_0x05e8:
            boolean r2 = r5.isEmpty()
            if (r2 == 0) goto L_0x05ef
            goto L_0x0607
        L_0x05ef:
            java.util.Iterator r2 = r5.iterator()
        L_0x05f3:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x0607
            java.lang.Object r7 = r2.next()
            com.sumsub.sns.internal.core.data.model.Document r7 = (com.sumsub.sns.internal.core.data.model.Document) r7
            boolean r7 = r7.isRejected()
            if (r7 == 0) goto L_0x05f3
            r2 = r14
            goto L_0x0608
        L_0x0607:
            r2 = r13
        L_0x0608:
            if (r2 == 0) goto L_0x0667
            r3.f36388a = r0
            r3.f36389b = r1
            r3.f36390c = r5
            r2 = 16
            r3.f36398k = r2
            java.lang.Object r2 = r0.a((java.lang.String) r6, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r2 != r4) goto L_0x061b
            return r4
        L_0x061b:
            r7 = r0
        L_0x061c:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.f36388a = r7
            r3.f36389b = r1
            r3.f36390c = r5
            r3.f36391d = r2
            r6 = 17
            r3.f36398k = r6
            java.lang.Object r6 = r7.a((java.lang.String) r10, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r6 != r4) goto L_0x0631
            return r4
        L_0x0631:
            r26 = r6
            r6 = r1
            r1 = r2
            r2 = r26
        L_0x0637:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.f36388a = r7
            r3.f36389b = r6
            r3.f36390c = r5
            r3.f36391d = r1
            r3.f36392e = r2
            r8 = 18
            r3.f36398k = r8
            java.lang.Object r3 = r7.a((java.lang.String) r9, (kotlin.coroutines.c<? super java.lang.String>) r3)
            if (r3 != r4) goto L_0x064e
            return r4
        L_0x064e:
            r16 = r1
            r17 = r2
            r2 = r3
            r3 = r7
        L_0x0654:
            r18 = r2
            java.lang.CharSequence r18 = (java.lang.CharSequence) r18
            java.util.List r19 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            com.sumsub.sns.internal.presentation.screen.verification.d$b r1 = new com.sumsub.sns.internal.presentation.screen.verification.d$b
            r20 = 0
            r15 = r1
            r15.<init>(r16, r17, r18, r19, r20)
            r4 = r1
            r1 = r6
            goto L_0x066f
        L_0x0667:
            com.sumsub.sns.internal.presentation.screen.verification.d$a r2 = com.sumsub.sns.internal.presentation.screen.verification.d.f36418f
            com.sumsub.sns.internal.presentation.screen.verification.d r2 = r2.a()
            r3 = r0
            r4 = r2
        L_0x066f:
            java.util.ArrayList r2 = new java.util.ArrayList
            int r6 = kotlin.collections.CollectionsKt__IterablesKt.u(r5, r11)
            r2.<init>(r6)
            java.util.Iterator r5 = r5.iterator()
        L_0x067c:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x06a2
            java.lang.Object r6 = r5.next()
            r16 = r6
            com.sumsub.sns.internal.core.data.model.Document r16 = (com.sumsub.sns.internal.core.data.model.Document) r16
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r15 = r3.h()
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r17 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewed
            r18 = 0
            r20 = 0
            r21 = 40
            r22 = 0
            r19 = r1
            com.sumsub.sns.internal.core.presentation.base.adapter.c r6 = com.sumsub.sns.internal.core.presentation.helper.a.a(r15, r16, r17, r18, r19, r20, r21, r22)
            r2.add(r6)
            goto L_0x067c
        L_0x06a2:
            r4.a((java.util.List<? extends com.sumsub.sns.internal.core.presentation.base.adapter.a>) r2)
        L_0x06a5:
            boolean r1 = r4 instanceof com.sumsub.sns.internal.presentation.screen.verification.d.C0487d
            if (r1 == 0) goto L_0x0706
            java.util.List r1 = r4.b()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x06b6:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x06c8
            java.lang.Object r5 = r1.next()
            boolean r6 = r5 instanceof com.sumsub.sns.internal.core.presentation.base.adapter.f
            if (r6 == 0) goto L_0x06b6
            r2.add(r5)
            goto L_0x06b6
        L_0x06c8:
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r2)
            com.sumsub.sns.internal.core.presentation.base.adapter.f r1 = (com.sumsub.sns.internal.core.presentation.base.adapter.f) r1
            if (r1 == 0) goto L_0x06d5
            com.sumsub.sns.internal.core.widget.SNSStepState r1 = r1.g()
            goto L_0x06d6
        L_0x06d5:
            r1 = r12
        L_0x06d6:
            com.sumsub.sns.internal.core.common.e0 r2 = com.sumsub.sns.internal.core.common.e0.f32018a
            java.lang.Integer r2 = r2.getAutoCloseOnApproveTimeout()
            if (r2 == 0) goto L_0x06e3
            int r6 = r2.intValue()
            goto L_0x06e4
        L_0x06e3:
            r6 = 3
        L_0x06e4:
            com.sumsub.sns.internal.core.widget.SNSStepState r2 = com.sumsub.sns.internal.core.widget.SNSStepState.APPROVED
            if (r1 != r2) goto L_0x0706
            if (r6 <= 0) goto L_0x0706
            com.sumsub.sns.internal.core.common.q$d r1 = new com.sumsub.sns.internal.core.common.q$d
            r1.<init>(r12, r14, r12)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS
            long r5 = (long) r6
            long r5 = r2.toMillis(r5)
            java.lang.Long r18 = kotlin.coroutines.jvm.internal.a.d(r5)
            r17 = 0
            r19 = 2
            r20 = 0
            r15 = r3
            r16 = r1
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r15, (com.sumsub.sns.internal.core.common.q) r16, (java.lang.Object) r17, (java.lang.Long) r18, (int) r19, (java.lang.Object) r20)
        L_0x0706:
            com.sumsub.sns.internal.presentation.screen.verification.b$m r1 = new com.sumsub.sns.internal.presentation.screen.verification.b$m
            r1.<init>(r4, r12)
            com.sumsub.sns.core.presentation.base.a.a(r3, r13, r1, r14, r12)
            kotlin.Unit r1 = kotlin.Unit.f56620a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.b(com.sumsub.sns.internal.core.presentation.helper.b, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.model.e r12, com.sumsub.sns.internal.core.data.model.g r13, java.util.List<com.sumsub.sns.internal.core.data.model.Document> r14, kotlin.coroutines.c<? super kotlin.Unit> r15) {
        /*
            r11 = this;
            boolean r0 = r15 instanceof com.sumsub.sns.internal.presentation.screen.verification.b.e
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.sumsub.sns.internal.presentation.screen.verification.b$e r0 = (com.sumsub.sns.internal.presentation.screen.verification.b.e) r0
            int r1 = r0.f36361d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36361d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.verification.b$e r0 = new com.sumsub.sns.internal.presentation.screen.verification.b$e
            r0.<init>(r11, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f36359b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36361d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 == r4) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            goto L_0x0031
        L_0x0029:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0031:
            java.lang.Object r12 = r0.f36358a
            com.sumsub.sns.internal.core.presentation.helper.b r12 = (com.sumsub.sns.internal.core.presentation.helper.b) r12
            kotlin.k.b(r15)
            goto L_0x00f6
        L_0x003a:
            kotlin.k.b(r15)
            r15 = 0
            if (r14 == 0) goto L_0x0057
            if (r13 == 0) goto L_0x0047
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r2 = r13.K()
            goto L_0x0048
        L_0x0047:
            r2 = r15
        L_0x0048:
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r5 = com.sumsub.sns.internal.core.data.model.ReviewStatusType.Completed
            if (r2 != r5) goto L_0x0057
            com.sumsub.sns.core.data.model.SNSSDKState r2 = com.sumsub.sns.internal.core.data.model.k.a(r13, r14)
            if (r2 == 0) goto L_0x0057
            com.sumsub.sns.internal.core.data.source.common.a r5 = r11.f36340q
            r5.a((com.sumsub.sns.core.data.model.SNSSDKState) r2)
        L_0x0057:
            com.sumsub.sns.internal.core.presentation.helper.b r12 = r11.a((com.sumsub.sns.internal.core.data.model.e) r12, (com.sumsub.sns.internal.core.data.model.g) r13, (java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r14)
            if (r12 == 0) goto L_0x00f6
            r11.f36345v = r13
            r11.f36346w = r14
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r14 = r12.f()
            r11.f36347x = r14
            com.sumsub.sns.core.c r5 = com.sumsub.sns.core.c.f30748a
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r2 = "showApplicantStatus status="
            r14.append(r2)
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r2 = r12.f()
            r14.append(r2)
            java.lang.String r2 = " docs="
            r14.append(r2)
            java.util.List r2 = r12.e()
            r14.append(r2)
            java.lang.String r7 = r14.toString()
            r8 = 0
            r9 = 4
            r10 = 0
            java.lang.String r6 = "SNSApplicantStatusViewModel"
            com.sumsub.sns.core.c.b(r5, r6, r7, r8, r9, r10)
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r14 = r12.f()
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r2 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.None
            if (r14 != r2) goto L_0x00a5
            r0.f36358a = r12
            r0.f36361d = r4
            java.lang.Object r12 = r11.a((com.sumsub.sns.internal.core.presentation.helper.b) r12, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r12 != r1) goto L_0x00f6
            return r1
        L_0x00a5:
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r14 = r12.f()
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r2 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Submitting
            if (r14 != r2) goto L_0x00b1
            r11.d((com.sumsub.sns.internal.core.presentation.helper.b) r12)
            goto L_0x00f6
        L_0x00b1:
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r14 = r12.f()
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r2 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewing
            if (r14 != r2) goto L_0x00bd
            r11.c((com.sumsub.sns.internal.core.presentation.helper.b) r12)
            goto L_0x00f6
        L_0x00bd:
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r14 = r12.f()
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r2 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewed
            if (r14 != r2) goto L_0x00d0
            r0.f36358a = r12
            r0.f36361d = r3
            java.lang.Object r12 = r11.b((com.sumsub.sns.internal.core.presentation.helper.b) r12, (kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r12 != r1) goto L_0x00f6
            return r1
        L_0x00d0:
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r12 = r12.f()
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r14 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Skip
            if (r12 != r14) goto L_0x00f3
            if (r13 == 0) goto L_0x00e2
            boolean r12 = r13.A()
            if (r12 != 0) goto L_0x00e2
            r12 = r4
            goto L_0x00e3
        L_0x00e2:
            r12 = 0
        L_0x00e3:
            if (r12 == 0) goto L_0x00f3
            com.sumsub.sns.internal.core.common.q$d r6 = new com.sumsub.sns.internal.core.common.q$d
            r6.<init>(r15, r4, r15)
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r11
            com.sumsub.sns.core.presentation.base.a.a((com.sumsub.sns.core.presentation.base.a) r5, (com.sumsub.sns.internal.core.common.q) r6, (java.lang.Object) r7, (java.lang.Long) r8, (int) r9, (java.lang.Object) r10)
            goto L_0x00f6
        L_0x00f3:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        L_0x00f6:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.a(com.sumsub.sns.internal.core.data.model.e, com.sumsub.sns.internal.core.data.model.g, java.util.List, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(b bVar, com.sumsub.sns.internal.core.data.model.e eVar, com.sumsub.sns.internal.core.data.model.g gVar, List list, kotlin.coroutines.c cVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            eVar = null;
        }
        if ((i11 & 2) != 0) {
            gVar = null;
        }
        if ((i11 & 4) != 0) {
            list = null;
        }
        return bVar.a(eVar, gVar, list, cVar);
    }

    public static /* synthetic */ com.sumsub.sns.internal.core.presentation.helper.b a(b bVar, com.sumsub.sns.internal.core.data.model.e eVar, com.sumsub.sns.internal.core.data.model.g gVar, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            eVar = null;
        }
        if ((i11 & 2) != 0) {
            gVar = null;
        }
        if ((i11 & 4) != 0) {
            list = null;
        }
        return bVar.a(eVar, gVar, (List<Document>) list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.sns.internal.core.presentation.helper.b a(com.sumsub.sns.internal.core.data.model.e r13, com.sumsub.sns.internal.core.data.model.g r14, java.util.List<com.sumsub.sns.internal.core.data.model.Document> r15) {
        /*
            r12 = this;
            r0 = 0
            if (r13 == 0) goto L_0x01ac
            if (r14 == 0) goto L_0x01ac
            r1 = 0
            r2 = 1
            if (r15 == 0) goto L_0x0012
            boolean r3 = r15.isEmpty()
            if (r3 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r3 = r1
            goto L_0x0013
        L_0x0012:
            r3 = r2
        L_0x0013:
            if (r3 == 0) goto L_0x0017
            goto L_0x01ac
        L_0x0017:
            com.sumsub.sns.core.c r3 = com.sumsub.sns.core.c.f30748a
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "On Load Data Success for applicant: "
            r4.append(r5)
            java.lang.String r5 = r14.B()
            r4.append(r5)
            java.lang.String r6 = r4.toString()
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r5 = "SNSApplicantStatusViewModel"
            r4 = r3
            com.sumsub.sns.core.c.b(r4, r5, r6, r7, r8, r9)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Review status: "
            r4.append(r5)
            com.sumsub.sns.internal.core.data.model.g$d r5 = r14.J()
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r5 = r5.p()
            r4.append(r5)
            java.lang.String r5 = " result="
            r4.append(r5)
            com.sumsub.sns.internal.core.data.model.g$d r5 = r14.J()
            com.sumsub.sns.internal.core.data.model.g$d$a r5 = r5.o()
            r4.append(r5)
            java.lang.String r6 = r4.toString()
            java.lang.String r5 = "SNSApplicantStatusViewModel"
            r4 = r3
            com.sumsub.sns.core.c.b(r4, r5, r6, r7, r8, r9)
            com.sumsub.sns.internal.core.data.model.g$d r3 = r14.J()
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r3 = r3.p()
            int[] r4 = com.sumsub.sns.internal.presentation.screen.verification.b.c.f36349a
            int r3 = r3.ordinal()
            r3 = r4[r3]
            if (r3 == r2) goto L_0x010c
            r0 = 2
            if (r3 == r0) goto L_0x00f8
            r0 = 3
            if (r3 == r0) goto L_0x00f8
            boolean r13 = r15 instanceof java.util.Collection
            if (r13 == 0) goto L_0x0089
            boolean r0 = r15.isEmpty()
            if (r0 == 0) goto L_0x0089
            goto L_0x00a2
        L_0x0089:
            java.util.Iterator r0 = r15.iterator()
        L_0x008d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00a2
            java.lang.Object r3 = r0.next()
            com.sumsub.sns.internal.core.data.model.Document r3 = (com.sumsub.sns.internal.core.data.model.Document) r3
            boolean r3 = r3.isSubmitted()
            r3 = r3 ^ r2
            if (r3 != 0) goto L_0x008d
            r0 = r1
            goto L_0x00a3
        L_0x00a2:
            r0 = r2
        L_0x00a3:
            if (r0 == 0) goto L_0x00a9
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.None
            goto L_0x0172
        L_0x00a9:
            if (r13 == 0) goto L_0x00b2
            boolean r0 = r15.isEmpty()
            if (r0 == 0) goto L_0x00b2
            goto L_0x00cb
        L_0x00b2:
            java.util.Iterator r0 = r15.iterator()
        L_0x00b6:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00cb
            java.lang.Object r3 = r0.next()
            com.sumsub.sns.internal.core.data.model.Document r3 = (com.sumsub.sns.internal.core.data.model.Document) r3
            boolean r3 = r3.isSubmitted()
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x00b6
            r0 = r2
            goto L_0x00cc
        L_0x00cb:
            r0 = r1
        L_0x00cc:
            if (r0 == 0) goto L_0x00f4
            if (r13 == 0) goto L_0x00d7
            boolean r13 = r15.isEmpty()
            if (r13 == 0) goto L_0x00d7
            goto L_0x00ee
        L_0x00d7:
            java.util.Iterator r13 = r15.iterator()
        L_0x00db:
            boolean r0 = r13.hasNext()
            if (r0 == 0) goto L_0x00ee
            java.lang.Object r0 = r13.next()
            com.sumsub.sns.internal.core.data.model.Document r0 = (com.sumsub.sns.internal.core.data.model.Document) r0
            boolean r0 = r0.isSubmitted()
            if (r0 == 0) goto L_0x00db
            r1 = r2
        L_0x00ee:
            if (r1 == 0) goto L_0x00f4
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Submitting
            goto L_0x0172
        L_0x00f4:
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewing
            goto L_0x0172
        L_0x00f8:
            boolean r13 = com.sumsub.sns.internal.core.data.model.f.d(r13)
            if (r13 == 0) goto L_0x0108
            boolean r13 = r14.A()
            if (r13 != 0) goto L_0x0108
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Skip
            goto L_0x0172
        L_0x0108:
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewing
            goto L_0x0172
        L_0x010c:
            com.sumsub.sns.internal.core.data.model.g$d r3 = r14.J()
            com.sumsub.sns.internal.core.data.model.g$d$a r3 = r3.o()
            if (r3 == 0) goto L_0x011b
            com.sumsub.sns.internal.core.data.model.ReviewAnswerType r3 = r3.i()
            goto L_0x011c
        L_0x011b:
            r3 = r0
        L_0x011c:
            com.sumsub.sns.internal.core.data.model.ReviewAnswerType r4 = com.sumsub.sns.internal.core.data.model.ReviewAnswerType.Green
            if (r3 == r4) goto L_0x0167
            com.sumsub.sns.internal.core.data.model.g$d r3 = r14.J()
            com.sumsub.sns.internal.core.data.model.g$d$a r3 = r3.o()
            if (r3 == 0) goto L_0x012e
            com.sumsub.sns.internal.core.data.model.ReviewRejectType r0 = r3.j()
        L_0x012e:
            com.sumsub.sns.internal.core.data.model.ReviewRejectType r3 = com.sumsub.sns.internal.core.data.model.ReviewRejectType.Final
            if (r0 != r3) goto L_0x0133
            goto L_0x0167
        L_0x0133:
            boolean r0 = r15 instanceof java.util.Collection
            if (r0 == 0) goto L_0x013e
            boolean r0 = r15.isEmpty()
            if (r0 == 0) goto L_0x013e
            goto L_0x0155
        L_0x013e:
            java.util.Iterator r0 = r15.iterator()
        L_0x0142:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0155
            java.lang.Object r3 = r0.next()
            com.sumsub.sns.internal.core.data.model.Document r3 = (com.sumsub.sns.internal.core.data.model.Document) r3
            boolean r3 = r3.isReviewing()
            if (r3 != 0) goto L_0x0142
            goto L_0x0156
        L_0x0155:
            r1 = r2
        L_0x0156:
            if (r1 == 0) goto L_0x015b
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewing
            goto L_0x0172
        L_0x015b:
            boolean r13 = com.sumsub.sns.internal.core.data.model.f.h(r13)
            if (r13 == 0) goto L_0x0164
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Skip
            goto L_0x0172
        L_0x0164:
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewed
            goto L_0x0172
        L_0x0167:
            boolean r13 = com.sumsub.sns.internal.core.data.model.f.b(r13)
            if (r13 == 0) goto L_0x0170
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Skip
            goto L_0x0172
        L_0x0170:
            com.sumsub.sns.internal.core.data.model.ApplicantStatus r13 = com.sumsub.sns.internal.core.data.model.ApplicantStatus.Reviewed
        L_0x0172:
            com.sumsub.sns.core.c r0 = com.sumsub.sns.core.c.f30748a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Show screen for the following documents: "
            r1.append(r2)
            com.sumsub.sns.internal.presentation.screen.verification.b$h r9 = com.sumsub.sns.internal.presentation.screen.verification.b.h.f36371a
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 31
            r11 = 0
            r3 = r15
            java.lang.String r2 = kotlin.collections.CollectionsKt___CollectionsKt.k0(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1.append(r2)
            java.lang.String r2 = ". Status: "
            r1.append(r2)
            java.lang.String r2 = r13.name()
            r1.append(r2)
            java.lang.String r2 = r1.toString()
            r3 = 0
            r4 = 4
            java.lang.String r1 = "SNSApplicantStatusViewModel"
            com.sumsub.sns.core.c.b(r0, r1, r2, r3, r4, r5)
            com.sumsub.sns.internal.core.presentation.helper.b r0 = new com.sumsub.sns.internal.core.presentation.helper.b
            r0.<init>(r13, r14, r15)
        L_0x01ac:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.a(com.sumsub.sns.internal.core.data.model.e, com.sumsub.sns.internal.core.data.model.g, java.util.List):com.sumsub.sns.internal.core.presentation.helper.b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.List<com.sumsub.sns.internal.core.data.model.Document> r11, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.presentation.base.adapter.c> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.presentation.screen.verification.b.f
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.presentation.screen.verification.b$f r0 = (com.sumsub.sns.internal.presentation.screen.verification.b.f) r0
            int r1 = r0.f36367f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f36367f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.verification.b$f r0 = new com.sumsub.sns.internal.presentation.screen.verification.b$f
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f36365d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f36367f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0055
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r11 = r0.f36364c
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.Object r1 = r0.f36363b
            com.sumsub.sns.internal.core.widget.SNSStepState r1 = (com.sumsub.sns.internal.core.widget.SNSStepState) r1
            java.lang.Object r0 = r0.f36362a
            java.util.List r0 = (java.util.List) r0
            kotlin.k.b(r12)
            r5 = r11
            r4 = r1
            goto L_0x008a
        L_0x003a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0042:
            java.lang.Object r11 = r0.f36364c
            com.sumsub.sns.internal.core.widget.SNSStepState r11 = (com.sumsub.sns.internal.core.widget.SNSStepState) r11
            java.lang.Object r2 = r0.f36363b
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r4 = r0.f36362a
            com.sumsub.sns.internal.presentation.screen.verification.b r4 = (com.sumsub.sns.internal.presentation.screen.verification.b) r4
            kotlin.k.b(r12)
            r9 = r2
            r2 = r11
            r11 = r9
            goto L_0x006f
        L_0x0055:
            kotlin.k.b(r12)
            com.sumsub.sns.internal.core.widget.SNSStepState r12 = com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED
            r0.f36362a = r10
            r0.f36363b = r11
            r0.f36364c = r12
            r0.f36367f = r4
            java.lang.String r2 = "sns_step_VIDEO_IDENT_title"
            java.lang.Object r2 = r10.a((java.lang.String) r2, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r2 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r4 = r10
            r9 = r2
            r2 = r12
            r12 = r9
        L_0x006f:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 != 0) goto L_0x0075
            java.lang.String r12 = ""
        L_0x0075:
            r0.f36362a = r11
            r0.f36363b = r2
            r0.f36364c = r12
            r0.f36367f = r3
            java.lang.String r3 = "sns_iddoc_status_notSubmitted"
            java.lang.Object r0 = r4.a((java.lang.String) r3, (kotlin.coroutines.c<? super java.lang.String>) r0)
            if (r0 != r1) goto L_0x0086
            return r1
        L_0x0086:
            r5 = r12
            r12 = r0
            r4 = r2
            r0 = r11
        L_0x008a:
            r6 = r12
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo r8 = new com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo
            com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo$Type r11 = com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo.Type.VIDEO_IDENTIFICATION
            java.lang.Object r12 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r0)
            com.sumsub.sns.internal.core.data.model.Document r12 = (com.sumsub.sns.internal.core.data.model.Document) r12
            r8.<init>(r11, r12)
            com.sumsub.sns.internal.core.presentation.base.adapter.c r11 = new com.sumsub.sns.internal.core.presentation.base.adapter.c
            r7 = 1
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.verification.b.a(java.util.List, kotlin.coroutines.c):java.lang.Object");
    }

    public final boolean a(com.sumsub.sns.internal.core.presentation.helper.b bVar) {
        List<Document> e11 = bVar.e();
        ArrayList<Document> arrayList = new ArrayList<>();
        Iterator<T> it2 = e11.iterator();
        while (true) {
            boolean z11 = false;
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            Document document = (Document) next;
            if (bVar.d().I().k()) {
                List<String> j11 = bVar.d().I().j();
                if (!(j11 != null && j11.contains(document.getType().c()))) {
                    z11 = true;
                }
            }
            if (z11) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (Document isSubmitted : arrayList) {
            if (!isSubmitted.isSubmitted()) {
                return true;
            }
        }
        return false;
    }

    public final Object a(com.sumsub.sns.internal.core.presentation.helper.b bVar, kotlin.coroutines.c<? super Unit> cVar) {
        b(false);
        com.sumsub.sns.core.presentation.base.a.a(this, false, new k(bVar, this, (kotlin.coroutines.c<? super k>) null), 1, (Object) null);
        return Unit.f56620a;
    }

    public final void a(Document document) {
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        com.sumsub.sns.core.c.b(cVar, B, "onDocumentClick: " + document, (Throwable) null, 4, (Object) null);
        a((a.j) new a.m(document));
    }

    public final List<Document> a(List<Document> list, com.sumsub.sns.internal.core.data.model.g gVar) {
        ArrayList arrayList = new ArrayList();
        Document document = null;
        for (Document next : list) {
            if (!gVar.a(next.getType().c())) {
                arrayList.add(next);
            } else if (document == null) {
                document = new Document(new DocumentType(DocumentType.f32356k), next.getResult());
            } else {
                if (!next.isRejected()) {
                    boolean z11 = false;
                    if (!(document.isReviewing()) || next.isReviewing()) {
                        if (document.isApproved()) {
                            z11 = true;
                        }
                        if (z11) {
                            if (next.isApproved()) {
                            }
                        }
                    }
                }
                document = Document.copy$default(document, (DocumentType) null, next.getResult(), 1, (Object) null);
            }
        }
        if (document != null) {
            arrayList.add(document);
        }
        return arrayList;
    }

    public final boolean b(com.sumsub.sns.internal.core.presentation.helper.b bVar) {
        boolean z11;
        if (!bVar.d().I().k()) {
            return false;
        }
        List<Document> e11 = bVar.e();
        ArrayList arrayList = new ArrayList();
        for (T next : e11) {
            Document document = (Document) next;
            List<String> j11 = bVar.d().I().j();
            if (j11 != null && j11.contains(document.getType().c())) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (!((Document) it2.next()).isSubmitted()) {
                        z11 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z11 = true;
        if (z11) {
            return true;
        }
        return false;
    }

    public final void b(String str) {
        n1 unused = kotlinx.coroutines.i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new j(str, this, (kotlin.coroutines.c<? super j>) null), 3, (Object) null);
    }
}
