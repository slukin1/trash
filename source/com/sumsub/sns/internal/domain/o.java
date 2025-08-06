package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.camera.photo.presentation.document.DocCapture;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.IdentitySide;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.n;
import com.sumsub.sns.internal.core.data.model.remote.k;
import com.sumsub.sns.internal.core.data.source.applicant.h;
import com.sumsub.sns.internal.core.data.source.applicant.remote.utils.a;
import com.sumsub.sns.internal.domain.n;
import d10.l;
import d10.p;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.v0;

public final class o extends n<a> {

    /* renamed from: e  reason: collision with root package name */
    public l<? super Integer, Unit> f34184e;

    /* renamed from: f  reason: collision with root package name */
    public Map<n, Integer> f34185f;

    public static final class a extends n.a {

        /* renamed from: d  reason: collision with root package name */
        public final List<com.sumsub.sns.internal.core.data.model.n> f34186d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f34187e;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(Document document, String str, List list, boolean z11, boolean z12, int i11, r rVar) {
            this(document, str, list, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? false : z12);
        }

        public final List<com.sumsub.sns.internal.core.data.model.n> d() {
            return this.f34186d;
        }

        public final boolean e() {
            return this.f34187e;
        }

        public a(Document document, String str, List<com.sumsub.sns.internal.core.data.model.n> list, boolean z11, boolean z12) {
            super(document, str, z11);
            this.f34186d = list;
            this.f34187e = z12;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.domain.UploadDocumentImagesUseCase", f = "UploadDocumentImagesUseCase.kt", l = {93}, m = "syncUpload")
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34190a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34191b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34192c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34193d;

        /* renamed from: e  reason: collision with root package name */
        public Object f34194e;

        /* renamed from: f  reason: collision with root package name */
        public Object f34195f;

        /* renamed from: g  reason: collision with root package name */
        public /* synthetic */ Object f34196g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ o f34197h;

        /* renamed from: i  reason: collision with root package name */
        public int f34198i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(o oVar, kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
            this.f34197h = oVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34196g = obj;
            this.f34198i |= Integer.MIN_VALUE;
            return this.f34197h.a((a) null, (g) null, (String) null, (kotlin.coroutines.c<? super List<k>>) this);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.domain.UploadDocumentImagesUseCase$upload$3", f = "UploadDocumentImagesUseCase.kt", l = {79}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super List<? extends k>>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34199a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f34200b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f34201c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ o f34202d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f34203e;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.domain.UploadDocumentImagesUseCase$upload$3$2$1", f = "UploadDocumentImagesUseCase.kt", l = {65}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super k>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f34204a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ o f34205b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f34206c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ com.sumsub.sns.internal.core.data.model.n f34207d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f34208e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(o oVar, String str, com.sumsub.sns.internal.core.data.model.n nVar, a aVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f34205b = oVar;
                this.f34206c = str;
                this.f34207d = nVar;
                this.f34208e = aVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super k> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f34205b, this.f34206c, this.f34207d, this.f34208e, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f34204a;
                boolean z11 = true;
                if (i11 == 0) {
                    kotlin.k.b(obj);
                    com.sumsub.sns.internal.core.data.source.applicant.b b11 = this.f34205b.b();
                    String str = this.f34206c;
                    File m11 = this.f34207d.m();
                    String p11 = this.f34207d.p();
                    IdentitySide o11 = this.f34207d.o();
                    DocumentType type = this.f34208e.b().getType();
                    b a11 = this.f34205b.a(this.f34207d);
                    this.f34204a = 1;
                    obj = h.a(b11, str, m11, p11, o11, (Map) null, type, a11, this, 16, (Object) null);
                    if (obj == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    kotlin.k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                com.sumsub.sns.internal.core.data.model.n nVar = this.f34207d;
                k kVar = (k) obj;
                if (kVar == null || !kVar.l()) {
                    z11 = false;
                }
                if (z11) {
                    com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
                    com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "Fast-fail for " + nVar, (Throwable) null, 4, (Object) null);
                    com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "response: " + kVar, (Throwable) null, 4, (Object) null);
                }
                return obj;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, o oVar, String str, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f34201c = aVar;
            this.f34202d = oVar;
            this.f34203e = str;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super List<k>> cVar) {
            return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            d dVar = new d(this.f34201c, this.f34202d, this.f34203e, cVar);
            dVar.f34200b = obj;
            return dVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f34199a;
            if (i11 == 0) {
                kotlin.k.b(obj);
                h0 h0Var = (h0) this.f34200b;
                List<com.sumsub.sns.internal.core.data.model.n> d12 = this.f34201c.d();
                ArrayList<com.sumsub.sns.internal.core.data.model.n> arrayList = new ArrayList<>();
                for (T next : d12) {
                    if (!((com.sumsub.sns.internal.core.data.model.n) next).n()) {
                        arrayList.add(next);
                    }
                }
                o oVar = this.f34202d;
                String str = this.f34203e;
                a aVar = this.f34201c;
                ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList, 10));
                for (com.sumsub.sns.internal.core.data.model.n aVar2 : arrayList) {
                    a aVar3 = aVar;
                    ArrayList arrayList3 = arrayList2;
                    arrayList3.add(i.b(h0Var, v0.b(), (CoroutineStart) null, new a(oVar, str, aVar2, aVar3, (kotlin.coroutines.c<? super a>) null), 2, (Object) null));
                    arrayList2 = arrayList3;
                    aVar = aVar3;
                }
                this.f34199a = 1;
                Object a11 = AwaitKt.a(arrayList2, this);
                return a11 == d11 ? d11 : a11;
            } else if (i11 == 1) {
                kotlin.k.b(obj);
                return obj;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public o(com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.applicant.b bVar, com.sumsub.sns.internal.core.data.source.settings.b bVar2, com.sumsub.sns.internal.core.data.source.dynamic.b bVar3) {
        super(aVar, bVar, bVar2, bVar3);
        this.f34185f = new LinkedHashMap();
    }

    public final l<Integer, Unit> e() {
        return this.f34184e;
    }

    public static final class b implements a.C0361a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ com.sumsub.sns.internal.core.data.model.n f34188a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ o f34189b;

        public b(com.sumsub.sns.internal.core.data.model.n nVar, o oVar) {
            this.f34188a = nVar;
            this.f34189b = oVar;
        }

        public void a(int i11) {
            com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, b() + ", uploaded progress=" + i11, (Throwable) null, 4, (Object) null);
            this.f34189b.a(this.f34188a, i11);
        }

        public final String b() {
            return this.f34188a.p() + ", side=" + this.f34188a.o();
        }

        public void a() {
            com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, b() + ", upload finished", (Throwable) null, 4, (Object) null);
            this.f34189b.a(this.f34188a, 100);
        }
    }

    public Object b(a aVar, g gVar, String str, kotlin.coroutines.c<? super List<k>> cVar) {
        this.f34185f.clear();
        for (com.sumsub.sns.internal.core.data.model.n put : aVar.d()) {
            this.f34185f.put(put, kotlin.coroutines.jvm.internal.a.c(0));
        }
        return i0.g(new d(aVar, this, str, (kotlin.coroutines.c<? super d>) null), cVar);
    }

    public o(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.n(), aVar.g(), aVar.F(), aVar.p());
    }

    public final void a(l<? super Integer, Unit> lVar) {
        this.f34184e = lVar;
    }

    public Object a(List<Document> list, a aVar, kotlin.coroutines.c<? super Unit> cVar) {
        if (aVar.e()) {
            return Unit.f56620a;
        }
        Object a11 = super.a(list, aVar, cVar);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.sumsub.sns.internal.domain.o.a r26, com.sumsub.sns.internal.core.data.model.g r27, java.lang.String r28, kotlin.coroutines.c<? super java.util.List<com.sumsub.sns.internal.core.data.model.remote.k>> r29) {
        /*
            r25 = this;
            r0 = r25
            r1 = r29
            boolean r2 = r1 instanceof com.sumsub.sns.internal.domain.o.c
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.sumsub.sns.internal.domain.o$c r2 = (com.sumsub.sns.internal.domain.o.c) r2
            int r3 = r2.f34198i
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f34198i = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.domain.o$c r2 = new com.sumsub.sns.internal.domain.o$c
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.f34196g
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r2.f34198i
            r5 = 0
            r6 = 0
            r7 = 1
            if (r4 == 0) goto L_0x0057
            if (r4 != r7) goto L_0x004f
            java.lang.Object r4 = r2.f34195f
            com.sumsub.sns.internal.core.data.model.n r4 = (com.sumsub.sns.internal.core.data.model.n) r4
            java.lang.Object r8 = r2.f34194e
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r2.f34193d
            java.util.ArrayList r9 = (java.util.ArrayList) r9
            java.lang.Object r10 = r2.f34192c
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.f34191b
            com.sumsub.sns.internal.domain.o$a r11 = (com.sumsub.sns.internal.domain.o.a) r11
            java.lang.Object r12 = r2.f34190a
            com.sumsub.sns.internal.domain.o r12 = (com.sumsub.sns.internal.domain.o) r12
            kotlin.k.b(r1)
            r15 = r8
            r14 = r9
            r13 = r12
            r8 = r4
            r4 = r3
            r3 = r2
            r2 = r10
            goto L_0x0164
        L_0x004f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0057:
            kotlin.k.b(r1)
            java.util.Map<com.sumsub.sns.internal.core.data.model.n, java.lang.Integer> r1 = r0.f34185f
            r1.clear()
            java.util.List r1 = r26.d()
            java.util.Iterator r1 = r1.iterator()
        L_0x0067:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x007d
            java.lang.Object r4 = r1.next()
            com.sumsub.sns.internal.core.data.model.n r4 = (com.sumsub.sns.internal.core.data.model.n) r4
            java.util.Map<com.sumsub.sns.internal.core.data.model.n, java.lang.Integer> r8 = r0.f34185f
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.a.c(r6)
            r8.put(r4, r9)
            goto L_0x0067
        L_0x007d:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r4 = r26.d()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x008f:
            boolean r9 = r4.hasNext()
            if (r9 == 0) goto L_0x00a7
            java.lang.Object r9 = r4.next()
            r10 = r9
            com.sumsub.sns.internal.core.data.model.n r10 = (com.sumsub.sns.internal.core.data.model.n) r10
            boolean r10 = r10.n()
            r10 = r10 ^ r7
            if (r10 == 0) goto L_0x008f
            r8.add(r9)
            goto L_0x008f
        L_0x00a7:
            java.util.Iterator r4 = r8.iterator()
            r13 = r0
            r14 = r1
            r15 = r4
            r1 = r26
            r4 = r3
            r3 = r2
            r2 = r28
        L_0x00b4:
            boolean r8 = r15.hasNext()
            if (r8 == 0) goto L_0x01db
            java.lang.Object r8 = r15.next()
            r12 = r8
            com.sumsub.sns.internal.core.data.model.n r12 = (com.sumsub.sns.internal.core.data.model.n) r12
            com.sumsub.sns.internal.camera.photo.presentation.document.b r16 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "uploading "
            r8.append(r9)
            java.lang.String r9 = r12.p()
            r8.append(r9)
            java.lang.String r9 = ", side="
            r8.append(r9)
            com.sumsub.sns.internal.core.data.model.IdentitySide r9 = r12.o()
            r8.append(r9)
            java.lang.String r9 = " ..."
            r8.append(r9)
            java.lang.String r18 = r8.toString()
            r19 = 0
            r20 = 4
            r21 = 0
            java.lang.String r17 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r16, r17, r18, r19, r20, r21)
            com.sumsub.sns.internal.core.data.model.Document r8 = r1.b()
            com.sumsub.sns.internal.core.data.model.DocumentType r8 = r8.getType()
            java.lang.String r9 = r8.c()
            java.lang.String r10 = "IDENTITY_VIDEO"
            boolean r9 = kotlin.jvm.internal.x.b(r9, r10)
            r9 = r9 ^ r7
            if (r9 == 0) goto L_0x010a
            goto L_0x010b
        L_0x010a:
            r8 = r5
        L_0x010b:
            if (r8 != 0) goto L_0x0112
            com.sumsub.sns.internal.core.data.model.DocumentType r8 = new com.sumsub.sns.internal.core.data.model.DocumentType
            r8.<init>(r10)
        L_0x0112:
            r16 = r8
            com.sumsub.sns.internal.core.data.source.applicant.b r8 = r13.b()
            java.io.File r10 = r12.m()
            java.lang.String r11 = r12.p()
            com.sumsub.sns.internal.core.data.model.IdentitySide r17 = r12.o()
            com.sumsub.sns.internal.domain.o$b r18 = r13.a((com.sumsub.sns.internal.core.data.model.n) r12)
            r3.f34190a = r13
            r3.f34191b = r1
            r3.f34192c = r2
            r3.f34193d = r14
            r3.f34194e = r15
            r3.f34195f = r12
            r3.f34198i = r7
            r19 = 0
            r20 = 16
            r21 = 0
            r9 = r2
            r22 = r12
            r12 = r17
            r23 = r13
            r13 = r19
            r19 = r14
            r14 = r16
            r24 = r15
            r15 = r18
            r16 = r3
            r17 = r20
            r18 = r21
            java.lang.Object r8 = com.sumsub.sns.internal.core.data.source.applicant.h.a(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            if (r8 != r4) goto L_0x015a
            return r4
        L_0x015a:
            r11 = r1
            r1 = r8
            r14 = r19
            r8 = r22
            r13 = r23
            r15 = r24
        L_0x0164:
            com.sumsub.sns.internal.core.data.model.remote.k r1 = (com.sumsub.sns.internal.core.data.model.remote.k) r1
            com.sumsub.sns.internal.camera.photo.presentation.document.b r9 = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r12 = "uploaded doc="
            r10.append(r12)
            if (r1 == 0) goto L_0x0179
            java.lang.String r12 = r1.q()
            goto L_0x017a
        L_0x0179:
            r12 = r5
        L_0x017a:
            r10.append(r12)
            java.lang.String r18 = r10.toString()
            r19 = 0
            r20 = 4
            r21 = 0
            java.lang.String r17 = "DocCapture"
            r16 = r9
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r16, r17, r18, r19, r20, r21)
            r14.add(r1)
            if (r1 == 0) goto L_0x019b
            boolean r10 = r1.l()
            if (r10 != r7) goto L_0x019b
            r10 = r7
            goto L_0x019c
        L_0x019b:
            r10 = r6
        L_0x019c:
            if (r10 == 0) goto L_0x01d8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Fast-fail for "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r3 = ". Stopping upload ..."
            r2.append(r3)
            java.lang.String r18 = r2.toString()
            r19 = 0
            r20 = 4
            r21 = 0
            java.lang.String r17 = "DocCapture"
            r16 = r9
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r16, r17, r18, r19, r20, r21)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "response: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r18 = r2.toString()
            java.lang.String r17 = "DocCapture"
            com.sumsub.sns.internal.camera.photo.presentation.document.b.b(r16, r17, r18, r19, r20, r21)
            return r14
        L_0x01d8:
            r1 = r11
            goto L_0x00b4
        L_0x01db:
            r19 = r14
            return r19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.o.a(com.sumsub.sns.internal.domain.o$a, com.sumsub.sns.internal.core.data.model.g, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }

    public final b a(com.sumsub.sns.internal.core.data.model.n nVar) {
        return new b(nVar, this);
    }

    public final void a(com.sumsub.sns.internal.core.data.model.n nVar, int i11) {
        this.f34185f.put(nVar, Integer.valueOf(i11));
        int A0 = (int) ((((float) CollectionsKt___CollectionsKt.A0(this.f34185f.values())) / ((float) (this.f34185f.size() * 100))) * 100.0f);
        com.sumsub.sns.internal.camera.photo.presentation.document.b bVar = com.sumsub.sns.internal.camera.photo.presentation.document.b.f31751a;
        com.sumsub.sns.internal.camera.photo.presentation.document.b.b(bVar, DocCapture.f31492c, "total upload progress=" + A0, (Throwable) null, 4, (Object) null);
        l<? super Integer, Unit> lVar = this.f34184e;
        if (lVar != null) {
            lVar.invoke(Integer.valueOf(A0));
        }
    }
}
