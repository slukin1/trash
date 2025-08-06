package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.remote.k;
import com.sumsub.sns.internal.domain.n.a;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;

public abstract class n<P extends a> extends com.sumsub.sns.internal.core.domain.base.b<List<? extends k>, P> {

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.applicant.b f34166b;

    /* renamed from: c  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.settings.b f34167c;

    /* renamed from: d  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f34168d;

    @d(c = "com.sumsub.sns.internal.domain.UploadBaseDocumentDataUseCase", f = "UploadBaseDocumentDataUseCase.kt", l = {54}, m = "preProcessDocuments$suspendImpl")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34172a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34173b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f34174c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ n<P> f34175d;

        /* renamed from: e  reason: collision with root package name */
        public int f34176e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(n<P> nVar, kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
            this.f34175d = nVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34174c = obj;
            this.f34176e |= Integer.MIN_VALUE;
            return n.a((n) this.f34175d, (List) null, (a) null, (kotlin.coroutines.c) this);
        }
    }

    @d(c = "com.sumsub.sns.internal.domain.UploadBaseDocumentDataUseCase", f = "UploadBaseDocumentDataUseCase.kt", l = {26, 27, 33, 35, 37, 45}, m = "run$suspendImpl")
    public static final class c extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34177a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34178b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34179c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34180d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f34181e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ n<P> f34182f;

        /* renamed from: g  reason: collision with root package name */
        public int f34183g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(n<P> nVar, kotlin.coroutines.c<? super c> cVar) {
            super(cVar);
            this.f34182f = nVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34181e = obj;
            this.f34183g |= Integer.MIN_VALUE;
            return n.a((n) this.f34182f, (a) null, (kotlin.coroutines.c) this);
        }
    }

    public n(com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.applicant.b bVar, com.sumsub.sns.internal.core.data.source.settings.b bVar2, com.sumsub.sns.internal.core.data.source.dynamic.b bVar3) {
        super(aVar);
        this.f34166b = bVar;
        this.f34167c = bVar2;
        this.f34168d = bVar3;
    }

    public abstract Object a(P p11, g gVar, String str, kotlin.coroutines.c<? super List<k>> cVar);

    public Object a(List<Document> list, P p11, kotlin.coroutines.c<? super Unit> cVar) {
        return a(this, (List) list, (a) p11, (kotlin.coroutines.c) cVar);
    }

    public abstract Object b(P p11, g gVar, String str, kotlin.coroutines.c<? super List<k>> cVar);

    public final com.sumsub.sns.internal.core.data.source.dynamic.b c() {
        return this.f34168d;
    }

    public final com.sumsub.sns.internal.core.data.source.settings.b d() {
        return this.f34167c;
    }

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public final Document f34169a;

        /* renamed from: b  reason: collision with root package name */
        public final String f34170b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f34171c;

        public a(Document document, String str, boolean z11) {
            this.f34169a = document;
            this.f34170b = str;
            this.f34171c = z11;
        }

        public final String a() {
            return this.f34170b;
        }

        public final Document b() {
            return this.f34169a;
        }

        public final boolean c() {
            return this.f34171c;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(Document document, String str, boolean z11, int i11, r rVar) {
            this(document, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? false : z11);
        }
    }

    /* renamed from: a */
    public Object b(P p11, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.domain.model.a<? extends Exception, ? extends List<k>>> cVar) {
        return a(this, (a) p11, (kotlin.coroutines.c) cVar);
    }

    public final com.sumsub.sns.internal.core.data.source.applicant.b b() {
        return this.f34166b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v8, resolved type: com.sumsub.sns.internal.domain.n$a} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: com.sumsub.sns.internal.domain.n} */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0097, code lost:
        r13 = (com.sumsub.sns.internal.core.data.model.g) r13;
        r1 = r11.f34168d;
        r0.f34177a = r11;
        r0.f34178b = r12;
        r0.f34179c = r13;
        r0.f34183g = 2;
        r1 = r1.c(true, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.t>>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a8, code lost:
        if (r1 != r7) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00aa, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        r10 = r1;
        r1 = r12;
        r12 = r13;
        r13 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00af, code lost:
        r13 = ((com.sumsub.sns.internal.core.data.model.t) ((com.sumsub.sns.internal.core.data.source.dynamic.e) r13).e()).d();
        r2 = r1.a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00bf, code lost:
        if (r2 != null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00c1, code lost:
        r2 = r13.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c9, code lost:
        if (r2.hasNext() == false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cb, code lost:
        r3 = r2.next();
        r4 = r3.getCountry();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d6, code lost:
        if (r4 == null) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00dc, code lost:
        if (r4.length() != 0) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00df, code lost:
        r4 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e1, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e3, code lost:
        if ((!r4) == false) goto L_0x00c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e7, code lost:
        r3 = (com.sumsub.sns.internal.core.data.model.Document) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e9, code lost:
        if (r3 == null) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00eb, code lost:
        r2 = r3.getCountry();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00ef, code lost:
        if (r2 != null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f1, code lost:
        r2 = r12.u();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00f5, code lost:
        if (r2 != null) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00f7, code lost:
        r2 = com.sumsub.sns.internal.core.common.n0.f32118f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00f9, code lost:
        r0.f34177a = r11;
        r0.f34178b = r1;
        r0.f34179c = r12;
        r0.f34180d = r2;
        r0.f34183g = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0108, code lost:
        if (r11.a(r13, r1, (kotlin.coroutines.c<? super kotlin.Unit>) r0) != r7) goto L_0x010b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x010a, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010f, code lost:
        if (r1.c() == false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0111, code lost:
        r0.f34177a = r11;
        r0.f34178b = null;
        r0.f34179c = null;
        r0.f34180d = null;
        r0.f34183g = 4;
        r13 = r11.b(r1, r12, r2, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0120, code lost:
        if (r13 != r7) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0122, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0123, code lost:
        r13 = (java.util.List) r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0126, code lost:
        r0.f34177a = r11;
        r0.f34178b = null;
        r0.f34179c = null;
        r0.f34180d = null;
        r0.f34183g = 5;
        r13 = r11.a(r1, r12, r2, (kotlin.coroutines.c<? super java.util.List<com.sumsub.sns.internal.core.data.model.remote.k>>) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0135, code lost:
        if (r13 != r7) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0137, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0138, code lost:
        r13 = (java.util.List) r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x013f, code lost:
        return new com.sumsub.sns.internal.core.domain.model.a.b(r13);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a(com.sumsub.sns.internal.domain.n r11, com.sumsub.sns.internal.domain.n.a r12, kotlin.coroutines.c r13) {
        /*
            boolean r0 = r13 instanceof com.sumsub.sns.internal.domain.n.c
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.sumsub.sns.internal.domain.n$c r0 = (com.sumsub.sns.internal.domain.n.c) r0
            int r1 = r0.f34183g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34183g = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.domain.n$c r0 = new com.sumsub.sns.internal.domain.n$c
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.f34181e
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r0.f34183g
            r8 = 1
            r9 = 0
            switch(r1) {
                case 0: goto L_0x0080;
                case 1: goto L_0x0073;
                case 2: goto L_0x005c;
                case 3: goto L_0x0044;
                case 4: goto L_0x003b;
                case 5: goto L_0x0032;
                case 6: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x002d:
            kotlin.k.b(r13)
            goto L_0x0155
        L_0x0032:
            java.lang.Object r11 = r0.f34177a
            com.sumsub.sns.internal.domain.n r11 = (com.sumsub.sns.internal.domain.n) r11
            kotlin.k.b(r13)     // Catch:{ Exception -> 0x0140 }
            goto L_0x0138
        L_0x003b:
            java.lang.Object r11 = r0.f34177a
            com.sumsub.sns.internal.domain.n r11 = (com.sumsub.sns.internal.domain.n) r11
            kotlin.k.b(r13)     // Catch:{ Exception -> 0x0140 }
            goto L_0x0123
        L_0x0044:
            java.lang.Object r11 = r0.f34180d
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r0.f34179c
            com.sumsub.sns.internal.core.data.model.g r12 = (com.sumsub.sns.internal.core.data.model.g) r12
            java.lang.Object r1 = r0.f34178b
            com.sumsub.sns.internal.domain.n$a r1 = (com.sumsub.sns.internal.domain.n.a) r1
            java.lang.Object r2 = r0.f34177a
            com.sumsub.sns.internal.domain.n r2 = (com.sumsub.sns.internal.domain.n) r2
            kotlin.k.b(r13)     // Catch:{ Exception -> 0x0070 }
            r10 = r2
            r2 = r11
            r11 = r10
            goto L_0x010b
        L_0x005c:
            java.lang.Object r11 = r0.f34179c
            com.sumsub.sns.internal.core.data.model.g r11 = (com.sumsub.sns.internal.core.data.model.g) r11
            java.lang.Object r12 = r0.f34178b
            com.sumsub.sns.internal.domain.n$a r12 = (com.sumsub.sns.internal.domain.n.a) r12
            java.lang.Object r1 = r0.f34177a
            r2 = r1
            com.sumsub.sns.internal.domain.n r2 = (com.sumsub.sns.internal.domain.n) r2
            kotlin.k.b(r13)     // Catch:{ Exception -> 0x0070 }
            r1 = r12
            r12 = r11
            r11 = r2
            goto L_0x00af
        L_0x0070:
            r11 = move-exception
            goto L_0x0143
        L_0x0073:
            java.lang.Object r11 = r0.f34178b
            r12 = r11
            com.sumsub.sns.internal.domain.n$a r12 = (com.sumsub.sns.internal.domain.n.a) r12
            java.lang.Object r11 = r0.f34177a
            com.sumsub.sns.internal.domain.n r11 = (com.sumsub.sns.internal.domain.n) r11
            kotlin.k.b(r13)     // Catch:{ Exception -> 0x0140 }
            goto L_0x0097
        L_0x0080:
            kotlin.k.b(r13)
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r11.f34168d     // Catch:{ Exception -> 0x0140 }
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r0.f34177a = r11     // Catch:{ Exception -> 0x0140 }
            r0.f34178b = r12     // Catch:{ Exception -> 0x0140 }
            r0.f34183g = r8     // Catch:{ Exception -> 0x0140 }
            r4 = r0
            java.lang.Object r13 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0140 }
            if (r13 != r7) goto L_0x0097
            return r7
        L_0x0097:
            com.sumsub.sns.internal.core.data.model.g r13 = (com.sumsub.sns.internal.core.data.model.g) r13     // Catch:{ Exception -> 0x0140 }
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r11.f34168d     // Catch:{ Exception -> 0x0140 }
            r0.f34177a = r11     // Catch:{ Exception -> 0x0140 }
            r0.f34178b = r12     // Catch:{ Exception -> 0x0140 }
            r0.f34179c = r13     // Catch:{ Exception -> 0x0140 }
            r2 = 2
            r0.f34183g = r2     // Catch:{ Exception -> 0x0140 }
            java.lang.Object r1 = r1.c((boolean) r8, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.t>>) r0)     // Catch:{ Exception -> 0x0140 }
            if (r1 != r7) goto L_0x00ab
            return r7
        L_0x00ab:
            r10 = r1
            r1 = r12
            r12 = r13
            r13 = r10
        L_0x00af:
            com.sumsub.sns.internal.core.data.source.dynamic.e r13 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r13     // Catch:{ Exception -> 0x0140 }
            java.lang.Object r13 = r13.e()     // Catch:{ Exception -> 0x0140 }
            com.sumsub.sns.internal.core.data.model.t r13 = (com.sumsub.sns.internal.core.data.model.t) r13     // Catch:{ Exception -> 0x0140 }
            java.util.List r13 = r13.d()     // Catch:{ Exception -> 0x0140 }
            java.lang.String r2 = r1.a()     // Catch:{ Exception -> 0x0140 }
            if (r2 != 0) goto L_0x00f9
            java.util.Iterator r2 = r13.iterator()     // Catch:{ Exception -> 0x0140 }
        L_0x00c5:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0140 }
            if (r3 == 0) goto L_0x00e6
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0140 }
            r4 = r3
            com.sumsub.sns.internal.core.data.model.Document r4 = (com.sumsub.sns.internal.core.data.model.Document) r4     // Catch:{ Exception -> 0x0140 }
            java.lang.String r4 = r4.getCountry()     // Catch:{ Exception -> 0x0140 }
            if (r4 == 0) goto L_0x00e1
            int r4 = r4.length()     // Catch:{ Exception -> 0x0140 }
            if (r4 != 0) goto L_0x00df
            goto L_0x00e1
        L_0x00df:
            r4 = 0
            goto L_0x00e2
        L_0x00e1:
            r4 = r8
        L_0x00e2:
            r4 = r4 ^ r8
            if (r4 == 0) goto L_0x00c5
            goto L_0x00e7
        L_0x00e6:
            r3 = r9
        L_0x00e7:
            com.sumsub.sns.internal.core.data.model.Document r3 = (com.sumsub.sns.internal.core.data.model.Document) r3     // Catch:{ Exception -> 0x0140 }
            if (r3 == 0) goto L_0x00f1
            java.lang.String r2 = r3.getCountry()     // Catch:{ Exception -> 0x0140 }
            if (r2 != 0) goto L_0x00f9
        L_0x00f1:
            java.lang.String r2 = r12.u()     // Catch:{ Exception -> 0x0140 }
            if (r2 != 0) goto L_0x00f9
            java.lang.String r2 = "ATA"
        L_0x00f9:
            r0.f34177a = r11     // Catch:{ Exception -> 0x0140 }
            r0.f34178b = r1     // Catch:{ Exception -> 0x0140 }
            r0.f34179c = r12     // Catch:{ Exception -> 0x0140 }
            r0.f34180d = r2     // Catch:{ Exception -> 0x0140 }
            r3 = 3
            r0.f34183g = r3     // Catch:{ Exception -> 0x0140 }
            java.lang.Object r13 = r11.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r13, r1, (kotlin.coroutines.c<? super kotlin.Unit>) r0)     // Catch:{ Exception -> 0x0140 }
            if (r13 != r7) goto L_0x010b
            return r7
        L_0x010b:
            boolean r13 = r1.c()     // Catch:{ Exception -> 0x0140 }
            if (r13 == 0) goto L_0x0126
            r0.f34177a = r11     // Catch:{ Exception -> 0x0140 }
            r0.f34178b = r9     // Catch:{ Exception -> 0x0140 }
            r0.f34179c = r9     // Catch:{ Exception -> 0x0140 }
            r0.f34180d = r9     // Catch:{ Exception -> 0x0140 }
            r13 = 4
            r0.f34183g = r13     // Catch:{ Exception -> 0x0140 }
            java.lang.Object r13 = r11.b(r1, r12, r2, r0)     // Catch:{ Exception -> 0x0140 }
            if (r13 != r7) goto L_0x0123
            return r7
        L_0x0123:
            java.util.List r13 = (java.util.List) r13     // Catch:{ Exception -> 0x0140 }
            goto L_0x013a
        L_0x0126:
            r0.f34177a = r11     // Catch:{ Exception -> 0x0140 }
            r0.f34178b = r9     // Catch:{ Exception -> 0x0140 }
            r0.f34179c = r9     // Catch:{ Exception -> 0x0140 }
            r0.f34180d = r9     // Catch:{ Exception -> 0x0140 }
            r13 = 5
            r0.f34183g = r13     // Catch:{ Exception -> 0x0140 }
            java.lang.Object r13 = r11.a(r1, (com.sumsub.sns.internal.core.data.model.g) r12, (java.lang.String) r2, (kotlin.coroutines.c<? super java.util.List<com.sumsub.sns.internal.core.data.model.remote.k>>) r0)     // Catch:{ Exception -> 0x0140 }
            if (r13 != r7) goto L_0x0138
            return r7
        L_0x0138:
            java.util.List r13 = (java.util.List) r13     // Catch:{ Exception -> 0x0140 }
        L_0x013a:
            com.sumsub.sns.internal.core.domain.model.a$b r12 = new com.sumsub.sns.internal.core.domain.model.a$b     // Catch:{ Exception -> 0x0140 }
            r12.<init>(r13)     // Catch:{ Exception -> 0x0140 }
            return r12
        L_0x0140:
            r12 = move-exception
            r2 = r11
            r11 = r12
        L_0x0143:
            r0.f34177a = r9
            r0.f34178b = r9
            r0.f34179c = r9
            r0.f34180d = r9
            r12 = 6
            r0.f34183g = r12
            java.lang.Object r13 = r2.a((java.lang.Exception) r11, (kotlin.coroutines.c<? super java.lang.Exception>) r0)
            if (r13 != r7) goto L_0x0155
            return r7
        L_0x0155:
            com.sumsub.sns.internal.core.domain.model.a$a r11 = new com.sumsub.sns.internal.core.domain.model.a$a
            r11.<init>(r13)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.n.a(com.sumsub.sns.internal.domain.n, com.sumsub.sns.internal.domain.n$a, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0084 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ad A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a(com.sumsub.sns.internal.domain.n r6, java.util.List r7, com.sumsub.sns.internal.domain.n.a r8, kotlin.coroutines.c r9) {
        /*
            boolean r0 = r9 instanceof com.sumsub.sns.internal.domain.n.b
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.domain.n$b r0 = (com.sumsub.sns.internal.domain.n.b) r0
            int r1 = r0.f34176e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34176e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.domain.n$b r0 = new com.sumsub.sns.internal.domain.n$b
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f34174c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34176e
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r6 = r0.f34173b
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r0.f34172a
            com.sumsub.sns.internal.domain.n r7 = (com.sumsub.sns.internal.domain.n) r7
            kotlin.k.b(r9)     // Catch:{ all -> 0x0031 }
            goto L_0x007e
        L_0x0031:
            r6 = move-exception
            goto L_0x009d
        L_0x0033:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003b:
            kotlin.k.b(r9)
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00a1 }
        L_0x0042:
            boolean r9 = r7.hasNext()     // Catch:{ all -> 0x00a1 }
            if (r9 == 0) goto L_0x0062
            java.lang.Object r9 = r7.next()     // Catch:{ all -> 0x00a1 }
            r2 = r9
            com.sumsub.sns.internal.core.data.model.Document r2 = (com.sumsub.sns.internal.core.data.model.Document) r2     // Catch:{ all -> 0x00a1 }
            com.sumsub.sns.internal.core.data.model.DocumentType r2 = r2.getType()     // Catch:{ all -> 0x00a1 }
            com.sumsub.sns.internal.core.data.model.Document r4 = r8.b()     // Catch:{ all -> 0x00a1 }
            com.sumsub.sns.internal.core.data.model.DocumentType r4 = r4.getType()     // Catch:{ all -> 0x00a1 }
            boolean r2 = kotlin.jvm.internal.x.b(r2, r4)     // Catch:{ all -> 0x00a1 }
            if (r2 == 0) goto L_0x0042
            goto L_0x0063
        L_0x0062:
            r9 = 0
        L_0x0063:
            com.sumsub.sns.internal.core.data.model.Document r9 = (com.sumsub.sns.internal.core.data.model.Document) r9     // Catch:{ all -> 0x00a1 }
            if (r9 == 0) goto L_0x0073
            com.sumsub.sns.internal.core.data.model.Document$b r7 = r9.getResult()     // Catch:{ all -> 0x00a1 }
            if (r7 == 0) goto L_0x0073
            java.util.List r7 = r7.h()     // Catch:{ all -> 0x00a1 }
            if (r7 != 0) goto L_0x0077
        L_0x0073:
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.k()     // Catch:{ all -> 0x00a1 }
        L_0x0077:
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00a1 }
            r5 = r7
            r7 = r6
            r6 = r5
        L_0x007e:
            boolean r8 = r6.hasNext()     // Catch:{ all -> 0x0031 }
            if (r8 == 0) goto L_0x00ad
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0031 }
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ all -> 0x0031 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0031 }
            com.sumsub.sns.internal.core.data.source.applicant.b r9 = r7.f34166b     // Catch:{ all -> 0x0031 }
            r0.f34172a = r7     // Catch:{ all -> 0x0031 }
            r0.f34173b = r6     // Catch:{ all -> 0x0031 }
            r0.f34176e = r3     // Catch:{ all -> 0x0031 }
            java.lang.Object r8 = r9.a((int) r8, (kotlin.coroutines.c<? super kotlin.Unit>) r0)     // Catch:{ all -> 0x0031 }
            if (r8 != r1) goto L_0x007e
            return r1
        L_0x009d:
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x00a2
        L_0x00a1:
            r7 = move-exception
        L_0x00a2:
            com.sumsub.sns.internal.log.a r8 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r6 = com.sumsub.sns.internal.log.c.a(r6)
            java.lang.String r9 = "Pre process error"
            r8.e(r6, r9, r7)
        L_0x00ad:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.n.a(com.sumsub.sns.internal.domain.n, java.util.List, com.sumsub.sns.internal.domain.n$a, kotlin.coroutines.c):java.lang.Object");
    }
}
