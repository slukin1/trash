package com.sumsub.sns.internal.presentation.screen.preview;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.m0;
import com.facebook.appevents.UserDataStore;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.q;
import com.sumsub.sns.internal.presentation.screen.preview.a.d;
import d10.p;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.reflect.l;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public abstract class a<S extends d> extends com.sumsub.sns.core.presentation.base.a<S> {
    public static final /* synthetic */ l<Object>[] A;
    public static final String B = "KEY_COUNTRY";
    public static final String C = "KEY_ID_DOC_TYPE";

    /* renamed from: z  reason: collision with root package name */
    public static final C0425a f35280z = new C0425a((r) null);

    /* renamed from: q  reason: collision with root package name */
    public final Document f35281q;

    /* renamed from: r  reason: collision with root package name */
    public final SavedStateHandle f35282r;

    /* renamed from: s  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f35283s;

    /* renamed from: t  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f35284t;

    /* renamed from: u  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.domain.d f35285u;

    /* renamed from: v  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35286v;

    /* renamed from: w  reason: collision with root package name */
    public Map<String, String> f35287w;

    /* renamed from: x  reason: collision with root package name */
    public Map<String, String> f35288x;

    /* renamed from: y  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.presentation.screen.base.a f35289y;

    /* renamed from: com.sumsub.sns.internal.presentation.screen.preview.a$a  reason: collision with other inner class name */
    public static final class C0425a {
        public /* synthetic */ C0425a(r rVar) {
            this();
        }

        public C0425a() {
        }
    }

    public static final class b implements a.j {

        /* renamed from: a  reason: collision with root package name */
        public final Document f35290a;

        public b(Document document) {
            this.f35290a = document;
        }

        public final Document a() {
            return this.f35290a;
        }

        public final Document b() {
            return this.f35290a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && x.b(this.f35290a, ((b) obj).f35290a);
        }

        public int hashCode() {
            return this.f35290a.hashCode();
        }

        public String toString() {
            return "DocumentUploaded(document=" + this.f35290a + ')';
        }

        public final b a(Document document) {
            return new b(document);
        }

        public static /* synthetic */ b a(b bVar, Document document, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                document = bVar.f35290a;
            }
            return bVar.a(document);
        }
    }

    public static class c {
    }

    public static class d implements a.l {
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.SNSBaseDocumentPreviewViewModel$launchIOWithProgress$1", f = "SNSBaseDocumentPreviewViewModel.kt", l = {83}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f35291a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a<S> f35292b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d10.l<kotlin.coroutines.c<? super Unit>, Object> f35293c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a<S> aVar, d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object> lVar, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f35292b = aVar;
            this.f35293c = lVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new e(this.f35292b, this.f35293c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f35291a;
            if (i11 == 0) {
                k.b(obj);
                a<S> aVar = this.f35292b;
                d10.l<kotlin.coroutines.c<? super Unit>, Object> lVar = this.f35293c;
                this.f35291a = 1;
                if (aVar.a((d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object>) lVar, (kotlin.coroutines.c<? super Unit>) this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.SNSBaseDocumentPreviewViewModel$onLoad$1", f = "SNSBaseDocumentPreviewViewModel.kt", l = {42, 48, 56}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f35294a;

        /* renamed from: b  reason: collision with root package name */
        public int f35295b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f35296c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ a<S> f35297d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(a<S> aVar, kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
            this.f35297d = aVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((f) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            f fVar = new f(this.f35297d, cVar);
            fVar.f35296c = obj;
            return fVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:36:0x00b7 A[Catch:{ all -> 0x0018 }] */
        /* JADX WARNING: Removed duplicated region for block: B:47:0x00f7 A[Catch:{ all -> 0x0018 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r10.f35295b
                r2 = 3
                r3 = 0
                r4 = 2
                r5 = 1
                r6 = 0
                if (r1 == 0) goto L_0x003e
                if (r1 == r5) goto L_0x0036
                if (r1 == r4) goto L_0x0023
                if (r1 != r2) goto L_0x001b
                kotlin.k.b(r11)     // Catch:{ all -> 0x0018 }
                goto L_0x0107
            L_0x0018:
                r11 = move-exception
                goto L_0x0102
            L_0x001b:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L_0x0023:
                java.lang.Object r1 = r10.f35294a
                com.sumsub.sns.internal.core.data.model.g r1 = (com.sumsub.sns.internal.core.data.model.g) r1
                java.lang.Object r5 = r10.f35296c
                kotlinx.coroutines.h0 r5 = (kotlinx.coroutines.h0) r5
                kotlin.k.b(r11)     // Catch:{ all -> 0x0018 }
                kotlin.Result r11 = (kotlin.Result) r11     // Catch:{ all -> 0x0018 }
                java.lang.Object r11 = r11.m3081unboximpl()     // Catch:{ all -> 0x0018 }
                goto L_0x00b1
            L_0x0036:
                java.lang.Object r1 = r10.f35296c
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                kotlin.k.b(r11)     // Catch:{ all -> 0x0018 }
                goto L_0x0063
            L_0x003e:
                kotlin.k.b(r11)
                java.lang.Object r11 = r10.f35296c
                kotlinx.coroutines.h0 r11 = (kotlinx.coroutines.h0) r11
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r1 = r10.f35297d     // Catch:{ all -> 0x0018 }
                r1.b((boolean) r5)     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r1 = r10.f35297d     // Catch:{ all -> 0x0018 }
                r1.c((boolean) r3)     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r1 = r10.f35297d     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r1.t()     // Catch:{ all -> 0x0018 }
                r10.f35296c = r11     // Catch:{ all -> 0x0018 }
                r10.f35295b = r5     // Catch:{ all -> 0x0018 }
                java.lang.Object r1 = com.sumsub.sns.internal.core.data.source.dynamic.h.i(r1, r3, r10, r5, r6)     // Catch:{ all -> 0x0018 }
                if (r1 != r0) goto L_0x0060
                return r0
            L_0x0060:
                r9 = r1
                r1 = r11
                r11 = r9
            L_0x0063:
                com.sumsub.sns.internal.core.data.source.dynamic.e r11 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r11     // Catch:{ all -> 0x0018 }
                java.lang.Object r11 = r11.e()     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.core.data.model.g r11 = (com.sumsub.sns.internal.core.data.model.g) r11     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r7 = r10.f35297d     // Catch:{ all -> 0x0018 }
                androidx.lifecycle.SavedStateHandle r7 = r7.x()     // Catch:{ all -> 0x0018 }
                java.lang.String r8 = "KEY_ID_DOC_TYPE"
                boolean r7 = r7.e(r8)     // Catch:{ all -> 0x0018 }
                if (r7 != 0) goto L_0x009a
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r7 = r10.f35297d     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.core.data.model.Document r8 = r7.u()     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.core.data.model.DocumentType r8 = r8.getType()     // Catch:{ all -> 0x0018 }
                java.util.List r8 = r11.b(r8)     // Catch:{ all -> 0x0018 }
                java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r8)     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.core.data.model.q r8 = (com.sumsub.sns.internal.core.data.model.q) r8     // Catch:{ all -> 0x0018 }
                if (r8 == 0) goto L_0x0095
                java.lang.String r8 = r8.b()     // Catch:{ all -> 0x0018 }
                if (r8 != 0) goto L_0x0097
            L_0x0095:
                java.lang.String r8 = "OTHER"
            L_0x0097:
                r7.c((java.lang.String) r8)     // Catch:{ all -> 0x0018 }
            L_0x009a:
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r7 = r10.f35297d     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.core.domain.d r7 = r7.f35285u     // Catch:{ all -> 0x0018 }
                r10.f35296c = r1     // Catch:{ all -> 0x0018 }
                r10.f35294a = r11     // Catch:{ all -> 0x0018 }
                r10.f35295b = r4     // Catch:{ all -> 0x0018 }
                java.lang.Object r5 = r7.a(r5, r10)     // Catch:{ all -> 0x0018 }
                if (r5 != r0) goto L_0x00ad
                return r0
            L_0x00ad:
                r9 = r1
                r1 = r11
                r11 = r5
                r5 = r9
            L_0x00b1:
                boolean r7 = kotlin.Result.m3078isFailureimpl(r11)     // Catch:{ all -> 0x0018 }
                if (r7 != 0) goto L_0x00e5
                boolean r7 = kotlin.Result.m3078isFailureimpl(r11)     // Catch:{ all -> 0x0018 }
                if (r7 == 0) goto L_0x00bf
                r7 = r6
                goto L_0x00c0
            L_0x00bf:
                r7 = r11
            L_0x00c0:
                if (r7 != 0) goto L_0x00c3
                goto L_0x00e5
            L_0x00c3:
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r5 = r10.f35297d     // Catch:{ all -> 0x0018 }
                kotlin.k.b(r11)     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.core.domain.e r11 = (com.sumsub.sns.internal.core.domain.e) r11     // Catch:{ all -> 0x0018 }
                r5.a((com.sumsub.sns.internal.core.domain.e) r11)     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r11 = r10.f35297d     // Catch:{ all -> 0x0018 }
                r11.b((boolean) r3)     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r11 = r10.f35297d     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.core.data.model.e r3 = r11.d()     // Catch:{ all -> 0x0018 }
                r10.f35296c = r6     // Catch:{ all -> 0x0018 }
                r10.f35294a = r6     // Catch:{ all -> 0x0018 }
                r10.f35295b = r2     // Catch:{ all -> 0x0018 }
                java.lang.Object r11 = r11.a(r1, r3, r10)     // Catch:{ all -> 0x0018 }
                if (r11 != r0) goto L_0x0107
                return r0
            L_0x00e5:
                java.lang.Throwable r11 = kotlin.Result.m3075exceptionOrNullimpl(r11)     // Catch:{ all -> 0x0018 }
                java.lang.Exception r11 = (java.lang.Exception) r11     // Catch:{ all -> 0x0018 }
                com.sumsub.sns.internal.log.a r0 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ all -> 0x0018 }
                java.lang.String r1 = com.sumsub.sns.internal.log.c.a(r5)     // Catch:{ all -> 0x0018 }
                java.lang.String r2 = r11.getMessage()     // Catch:{ all -> 0x0018 }
                if (r2 != 0) goto L_0x00f9
                java.lang.String r2 = ""
            L_0x00f9:
                r0.e(r1, r2, r11)     // Catch:{ all -> 0x0018 }
                java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0018 }
                r0.<init>(r11)     // Catch:{ all -> 0x0018 }
                throw r0     // Catch:{ all -> 0x0018 }
            L_0x0102:
                com.sumsub.sns.internal.presentation.screen.preview.a<S> r0 = r10.f35297d
                com.sumsub.sns.internal.presentation.screen.preview.a.a(r0, r11, r6, r4, r6)
            L_0x0107:
                kotlin.Unit r11 = kotlin.Unit.f56620a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.a.f.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.presentation.screen.preview.SNSBaseDocumentPreviewViewModel", f = "SNSBaseDocumentPreviewViewModel.kt", l = {77}, m = "withProgress")
    public static final class g extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f35298a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f35299b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a<S> f35300c;

        /* renamed from: d  reason: collision with root package name */
        public int f35301d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a<S> aVar, kotlin.coroutines.c<? super g> cVar) {
            super(cVar);
            this.f35300c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f35299b = obj;
            this.f35301d |= Integer.MIN_VALUE;
            return this.f35300c.a((d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object>) null, (kotlin.coroutines.c<? super Unit>) this);
        }
    }

    static {
        Class<a> cls = a.class;
        A = new l[]{Reflection.e(new MutablePropertyReference1Impl(cls, UserDataStore.COUNTRY, "getCountry()Ljava/lang/String;", 0)), Reflection.e(new MutablePropertyReference1Impl(cls, "idDocType", "getIdDocType()Ljava/lang/String;", 0))};
    }

    public a(Document document, SavedStateHandle savedStateHandle, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, com.sumsub.sns.internal.core.domain.d dVar) {
        super(aVar, bVar);
        this.f35281q = document;
        this.f35282r = savedStateHandle;
        this.f35283s = aVar;
        this.f35284t = bVar;
        this.f35285u = dVar;
        this.f35286v = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, B, null);
        this.f35289y = new com.sumsub.sns.internal.core.presentation.screen.base.a(savedStateHandle, C, q.f32684d);
    }

    public Object a(com.sumsub.sns.internal.core.data.model.g gVar, com.sumsub.sns.internal.core.data.model.e eVar, kotlin.coroutines.c<? super Unit> cVar) {
        return Unit.f56620a;
    }

    public final void c(String str) {
        this.f35289y.a(this, A[1], str);
    }

    public abstract void c(boolean z11);

    public void m() {
        n1 unused = i.d(m0.a(this), (CoroutineContext) null, (CoroutineStart) null, new f(this, (kotlin.coroutines.c<? super f>) null), 3, (Object) null);
    }

    public void p() {
    }

    public final com.sumsub.sns.internal.core.data.source.common.a q() {
        return this.f35283s;
    }

    public final Map<String, String> r() {
        return this.f35287w;
    }

    public final String s() {
        return (String) this.f35286v.a(this, A[0]);
    }

    public final com.sumsub.sns.internal.core.data.source.dynamic.b t() {
        return this.f35284t;
    }

    public final Document u() {
        return this.f35281q;
    }

    public final String v() {
        return (String) this.f35289y.a(this, A[1]);
    }

    public final Map<String, String> w() {
        return this.f35288x;
    }

    public final SavedStateHandle x() {
        return this.f35282r;
    }

    public void y() {
    }

    public void z() {
    }

    public final void b(String str) {
        this.f35286v.a(this, A[0], str);
    }

    public final void a(Map<String, String> map) {
        this.f35287w = map;
    }

    public final void b(Map<String, String> map) {
        this.f35288x = map;
    }

    public final void a(Document document) {
        a((a.j) new b(document));
        p();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(d10.l<? super kotlin.coroutines.c<? super kotlin.Unit>, ? extends java.lang.Object> r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.presentation.screen.preview.a.g
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.presentation.screen.preview.a$g r0 = (com.sumsub.sns.internal.presentation.screen.preview.a.g) r0
            int r1 = r0.f35301d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35301d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.presentation.screen.preview.a$g r0 = new com.sumsub.sns.internal.presentation.screen.preview.a$g
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f35299b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35301d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            java.lang.Object r6 = r0.f35298a
            com.sumsub.sns.internal.presentation.screen.preview.a r6 = (com.sumsub.sns.internal.presentation.screen.preview.a) r6
            kotlin.k.b(r7)
            goto L_0x004b
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.k.b(r7)
            r5.b((boolean) r4)
            r5.c((boolean) r3)
            r0.f35298a = r5
            r0.f35301d = r4
            java.lang.Object r6 = r6.invoke(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r6 = r5
        L_0x004b:
            r6.b((boolean) r3)
            r6.c((boolean) r4)
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.presentation.screen.preview.a.a(d10.l, kotlin.coroutines.c):java.lang.Object");
    }

    public final void a(d10.l<? super kotlin.coroutines.c<? super Unit>, ? extends Object> lVar) {
        n1 unused = i.d(m0.a(this), v0.b(), (CoroutineStart) null, new e(this, lVar, (kotlin.coroutines.c<? super e>) null), 2, (Object) null);
    }

    public void a(com.sumsub.sns.internal.core.domain.e eVar) {
        b(eVar.i());
        this.f35287w = eVar.l();
        this.f35288x = eVar.j();
    }

    public static /* synthetic */ void a(a aVar, Throwable th2, Object obj, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 2) != 0) {
                obj = null;
            }
            aVar.a(th2, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onDataError");
    }

    public final void a(Throwable th2, Object obj) {
        com.sumsub.sns.internal.log.a.f34862a.e(com.sumsub.sns.internal.log.c.a(this), "Exception while getting a data", th2);
        b(false);
        a(th2, this.f35281q.getType().c(), obj);
    }
}
