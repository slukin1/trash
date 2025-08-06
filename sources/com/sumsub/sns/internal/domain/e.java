package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.g;
import java.util.List;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.x;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f34080a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f34081b;

    /* renamed from: c  reason: collision with root package name */
    public final String f34082c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final g f34083a;

        /* renamed from: b  reason: collision with root package name */
        public final List<Document> f34084b;

        public a(g gVar, List<Document> list) {
            this.f34083a = gVar;
            this.f34084b = list;
        }

        public final g a() {
            return this.f34083a;
        }

        public final List<Document> b() {
            return this.f34084b;
        }

        public final g c() {
            return this.f34083a;
        }

        public final List<Document> d() {
            return this.f34084b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f34083a, aVar.f34083a) && x.b(this.f34084b, aVar.f34084b);
        }

        public int hashCode() {
            return (this.f34083a.hashCode() * 31) + this.f34084b.hashCode();
        }

        public String toString() {
            return "SNSApplicantData(applicant=" + this.f34083a + ", documents=" + this.f34084b + ')';
        }

        public final a a(g gVar, List<Document> list) {
            return new a(gVar, list);
        }

        public static /* synthetic */ a a(a aVar, g gVar, List<Document> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                gVar = aVar.f34083a;
            }
            if ((i11 & 2) != 0) {
                list = aVar.f34084b;
            }
            return aVar.a(gVar, list);
        }
    }

    @d(c = "com.sumsub.sns.internal.domain.GetApplicantDataAndUpdateStatusIfNeededUseCase", f = "GetApplicantDataAndUpdateStatusIfNeededUseCase.kt", l = {33, 34, 37, 40, 44, 49, 57}, m = "invoke-0E7RQCE")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34085a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34086b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34087c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34088d;

        /* renamed from: e  reason: collision with root package name */
        public Object f34089e;

        /* renamed from: f  reason: collision with root package name */
        public Object f34090f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f34091g;

        /* renamed from: h  reason: collision with root package name */
        public /* synthetic */ Object f34092h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ e f34093i;

        /* renamed from: j  reason: collision with root package name */
        public int f34094j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e eVar, c<? super b> cVar) {
            super(cVar);
            this.f34093i = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34092h = obj;
            this.f34094j |= Integer.MIN_VALUE;
            Object a11 = this.f34093i.a(false, (com.sumsub.sns.internal.core.data.source.applicant.b) null, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public e(com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, String str) {
        this.f34080a = aVar;
        this.f34081b = bVar;
        this.f34082c = "GetApplUptStat_" + str;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v20, resolved type: com.sumsub.sns.internal.domain.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v26, resolved type: com.sumsub.sns.internal.domain.e} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0224, code lost:
        if (r11 == false) goto L_0x0280;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0226, code lost:
        com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, com.sumsub.sns.internal.domain.f.f34095a, r7.f34082c + ": setting to 'pending'", (java.lang.Throwable) null, 4, (java.lang.Object) null);
        r3.f34085a = r7;
        r3.f34086b = r5;
        r3.f34087c = r4;
        r3.f34088d = null;
        r3.f34094j = 7;
        r2 = r6.b(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0255, code lost:
        if (r2 != r10) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0257, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0258, code lost:
        r0 = r4;
        r4 = r5;
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0261, code lost:
        if (((java.lang.Boolean) r2).booleanValue() == false) goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0263, code lost:
        r4.a(com.sumsub.sns.internal.core.data.model.g.d.a(r4.J(), (java.lang.Integer) null, com.sumsub.sns.internal.core.data.model.ReviewStatusType.Pending, (java.lang.Integer) null, (java.lang.String) null, (com.sumsub.sns.internal.core.data.model.g.d.a) null, (java.lang.Long) null, (java.lang.Long) null, (java.lang.String) null, com.tencent.thumbplayer.tcmedia.core.player.ITPNativePlayerMessageCallback.INFO_LONG1_DRM_FATAL_ERROR, (java.lang.Object) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x027a, code lost:
        r7 = r3;
        r5 = r4;
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:?, code lost:
        r0 = com.sumsub.sns.internal.core.data.model.k.a(r5, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0284, code lost:
        if (r0 == null) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0286, code lost:
        r7.f34080a.a(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x028b, code lost:
        com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, com.sumsub.sns.internal.domain.f.f34095a, r7.f34082c + ": finished", (java.lang.Throwable) null, 4, (java.lang.Object) null);
        r0 = kotlin.Result.Companion;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02b4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x02b5, code lost:
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x02b8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x02ba, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x02bb, code lost:
        r17 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x02bd, code lost:
        r7 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        return kotlin.Result.m3072constructorimpl(new com.sumsub.sns.internal.domain.e.a(r5, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005c, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b1, code lost:
        r14 = r4;
        r15 = r5;
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r2 = (com.sumsub.sns.internal.core.data.model.g) r2;
        r6 = r5.f34081b;
        r3.f34085a = r5;
        r3.f34086b = r4;
        r3.f34087c = r2;
        r3.f34094j = 2;
        r0 = r6.c(r0, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.t>>) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0107, code lost:
        if (r0 != r10) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0109, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010a, code lost:
        r7 = r5;
        r5 = r4;
        r4 = r2;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        r0 = ((com.sumsub.sns.internal.core.data.model.t) ((com.sumsub.sns.internal.core.data.source.dynamic.e) r2).e()).d();
        com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, com.sumsub.sns.internal.domain.f.f34095a, r7.f34082c + ": running with applicant=" + com.sumsub.sns.internal.core.common.i.a((java.lang.Object) r4), (java.lang.Throwable) null, 4, (java.lang.Object) null);
        r2 = r7.f34080a;
        r3.f34085a = r7;
        r3.f34086b = r5;
        r3.f34087c = r4;
        r3.f34088d = r0;
        r3.f34094j = 3;
        r2 = r2.c(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0152, code lost:
        if (r2 != r10) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0154, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        r2 = ((java.util.Locale) r2).getLanguage();
        r4 = r9.f34081b;
        r3.f34085a = r9;
        r3.f34086b = r15;
        r3.f34087c = r14;
        r3.f34088d = r0;
        r3.f34089e = r2;
        r3.f34090f = r2;
        r3.f34094j = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0171, code lost:
        r17 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r4 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r4, (java.lang.String) null, false, r3, 3, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017a, code lost:
        if (r4 != r10) goto L_0x017d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017c, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017d, code lost:
        r5 = r0;
        r0 = r2;
        r6 = r0;
        r2 = r4;
        r4 = r14;
        r7 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x018e, code lost:
        if (kotlin.text.StringsKt__StringsJVMKt.w(r0, ((com.sumsub.sns.internal.core.data.model.g) r2).E(), true) != false) goto L_0x01ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0190, code lost:
        r3.f34085a = r7;
        r3.f34086b = r15;
        r3.f34087c = r4;
        r3.f34088d = r5;
        r3.f34089e = null;
        r3.f34090f = null;
        r3.f34094j = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a3, code lost:
        if (r15.a(r6, (kotlin.coroutines.c<? super kotlin.Unit>) r3) != r10) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a5, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01a6, code lost:
        r0 = r5;
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01a8, code lost:
        r6 = r5;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ab, code lost:
        r6 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01ac, code lost:
        r0 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r5, new com.sumsub.sns.internal.core.data.model.m(r4));
        r2 = kotlin.jvm.internal.x.b(r4.L(), com.sumsub.sns.core.data.model.FlowActionType.FaceEnrollment.INSTANCE.getValue());
        r5 = r7.f34081b;
        r3.f34085a = r7;
        r3.f34086b = r6;
        r3.f34087c = r4;
        r3.f34088d = r0;
        r3.f34089e = null;
        r3.f34090f = null;
        r3.f34091g = r2;
        r3.f34094j = 6;
        r5 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r5, false, r3, 1, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01da, code lost:
        if (r5 != r10) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01dc, code lost:
        return r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01dd, code lost:
        r20 = r4;
        r4 = r0;
        r0 = r2;
        r2 = r5;
        r5 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01ec, code lost:
        if (((com.sumsub.sns.internal.core.data.model.e) r2).y() == com.sumsub.sns.core.data.model.FlowType.Module) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ee, code lost:
        if (r0 != false) goto L_0x01f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01f0, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01f2, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01f9, code lost:
        if (r5.K() != com.sumsub.sns.internal.core.data.model.ReviewStatusType.Init) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01fd, code lost:
        if ((r4 instanceof java.util.Collection) == false) goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0203, code lost:
        if (r4.isEmpty() == false) goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0206, code lost:
        r2 = r4.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x020e, code lost:
        if (r2.hasNext() == false) goto L_0x021e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x021a, code lost:
        if (((com.sumsub.sns.internal.core.data.model.Document) r2.next()).isSubmitted() != false) goto L_0x020a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x021c, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x021e, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x021f, code lost:
        if (r2 == false) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0221, code lost:
        if (r0 == false) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0223, code lost:
        r11 = true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(boolean r22, com.sumsub.sns.internal.core.data.source.applicant.b r23, kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.domain.e.a>> r24) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            r2 = r24
            boolean r3 = r2 instanceof com.sumsub.sns.internal.domain.e.b
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.sumsub.sns.internal.domain.e$b r3 = (com.sumsub.sns.internal.domain.e.b) r3
            int r4 = r3.f34094j
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f34094j = r4
            goto L_0x001e
        L_0x0019:
            com.sumsub.sns.internal.domain.e$b r3 = new com.sumsub.sns.internal.domain.e$b
            r3.<init>(r1, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f34092h
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r4 = r3.f34094j
            r11 = 0
            r12 = 0
            r13 = 1
            switch(r4) {
                case 0: goto L_0x00df;
                case 1: goto L_0x00cd;
                case 2: goto L_0x00b6;
                case 3: goto L_0x009d;
                case 4: goto L_0x0075;
                case 5: goto L_0x005f;
                case 6: goto L_0x0045;
                case 7: goto L_0x0034;
                default: goto L_0x002c;
            }
        L_0x002c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0034:
            java.lang.Object r0 = r3.f34087c
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r4 = r3.f34086b
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4
            java.lang.Object r3 = r3.f34085a
            com.sumsub.sns.internal.domain.e r3 = (com.sumsub.sns.internal.domain.e) r3
            kotlin.k.b(r2)     // Catch:{ Exception -> 0x027e }
            goto L_0x025b
        L_0x0045:
            boolean r0 = r3.f34091g
            java.lang.Object r4 = r3.f34088d
            java.util.List r4 = (java.util.List) r4
            java.lang.Object r5 = r3.f34087c
            com.sumsub.sns.internal.core.data.model.g r5 = (com.sumsub.sns.internal.core.data.model.g) r5
            java.lang.Object r6 = r3.f34086b
            com.sumsub.sns.internal.core.data.source.applicant.b r6 = (com.sumsub.sns.internal.core.data.source.applicant.b) r6
            java.lang.Object r7 = r3.f34085a
            com.sumsub.sns.internal.domain.e r7 = (com.sumsub.sns.internal.domain.e) r7
            kotlin.k.b(r2)     // Catch:{ Exception -> 0x005c }
            goto L_0x01e4
        L_0x005c:
            r0 = move-exception
            goto L_0x02c2
        L_0x005f:
            java.lang.Object r0 = r3.f34088d
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r4 = r3.f34087c
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4
            java.lang.Object r5 = r3.f34086b
            com.sumsub.sns.internal.core.data.source.applicant.b r5 = (com.sumsub.sns.internal.core.data.source.applicant.b) r5
            java.lang.Object r6 = r3.f34085a
            r7 = r6
            com.sumsub.sns.internal.domain.e r7 = (com.sumsub.sns.internal.domain.e) r7
            kotlin.k.b(r2)     // Catch:{ Exception -> 0x005c }
            goto L_0x01a8
        L_0x0075:
            java.lang.Object r0 = r3.f34090f
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r4 = r3.f34089e
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r3.f34088d
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r3.f34087c
            com.sumsub.sns.internal.core.data.model.g r6 = (com.sumsub.sns.internal.core.data.model.g) r6
            java.lang.Object r7 = r3.f34086b
            com.sumsub.sns.internal.core.data.source.applicant.b r7 = (com.sumsub.sns.internal.core.data.source.applicant.b) r7
            java.lang.Object r8 = r3.f34085a
            com.sumsub.sns.internal.domain.e r8 = (com.sumsub.sns.internal.domain.e) r8
            kotlin.k.b(r2)     // Catch:{ Exception -> 0x0099 }
            r15 = r7
            r7 = r8
            r20 = r6
            r6 = r4
            r4 = r20
            goto L_0x0184
        L_0x0099:
            r0 = move-exception
            r7 = r8
            goto L_0x02c2
        L_0x009d:
            java.lang.Object r0 = r3.f34088d
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r4 = r3.f34087c
            com.sumsub.sns.internal.core.data.model.g r4 = (com.sumsub.sns.internal.core.data.model.g) r4
            java.lang.Object r5 = r3.f34086b
            com.sumsub.sns.internal.core.data.source.applicant.b r5 = (com.sumsub.sns.internal.core.data.source.applicant.b) r5
            java.lang.Object r6 = r3.f34085a
            r7 = r6
            com.sumsub.sns.internal.domain.e r7 = (com.sumsub.sns.internal.domain.e) r7
            kotlin.k.b(r2)     // Catch:{ Exception -> 0x005c }
        L_0x00b1:
            r14 = r4
            r15 = r5
            r9 = r7
            goto L_0x0155
        L_0x00b6:
            java.lang.Object r0 = r3.f34087c
            com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0
            java.lang.Object r4 = r3.f34086b
            com.sumsub.sns.internal.core.data.source.applicant.b r4 = (com.sumsub.sns.internal.core.data.source.applicant.b) r4
            java.lang.Object r5 = r3.f34085a
            com.sumsub.sns.internal.domain.e r5 = (com.sumsub.sns.internal.domain.e) r5
            kotlin.k.b(r2)     // Catch:{ Exception -> 0x00c9 }
            r7 = r5
            r5 = r4
            r4 = r0
            goto L_0x010e
        L_0x00c9:
            r0 = move-exception
            r3 = r5
            goto L_0x02b6
        L_0x00cd:
            boolean r0 = r3.f34091g
            java.lang.Object r4 = r3.f34086b
            com.sumsub.sns.internal.core.data.source.applicant.b r4 = (com.sumsub.sns.internal.core.data.source.applicant.b) r4
            java.lang.Object r5 = r3.f34085a
            com.sumsub.sns.internal.domain.e r5 = (com.sumsub.sns.internal.domain.e) r5
            kotlin.k.b(r2)     // Catch:{ Exception -> 0x00db }
            goto L_0x00f6
        L_0x00db:
            r0 = move-exception
            r7 = r5
            goto L_0x02c2
        L_0x00df:
            kotlin.k.b(r2)
            com.sumsub.sns.internal.core.data.source.dynamic.b r2 = r1.f34081b     // Catch:{ Exception -> 0x02c0 }
            r3.f34085a = r1     // Catch:{ Exception -> 0x02c0 }
            r4 = r23
            r3.f34086b = r4     // Catch:{ Exception -> 0x02c0 }
            r3.f34091g = r0     // Catch:{ Exception -> 0x02c0 }
            r3.f34094j = r13     // Catch:{ Exception -> 0x02c0 }
            java.lang.Object r2 = r2.e(r0, r3)     // Catch:{ Exception -> 0x02c0 }
            if (r2 != r10) goto L_0x00f5
            return r10
        L_0x00f5:
            r5 = r1
        L_0x00f6:
            com.sumsub.sns.internal.core.data.model.g r2 = (com.sumsub.sns.internal.core.data.model.g) r2     // Catch:{ Exception -> 0x00db }
            com.sumsub.sns.internal.core.data.source.dynamic.b r6 = r5.f34081b     // Catch:{ Exception -> 0x00db }
            r3.f34085a = r5     // Catch:{ Exception -> 0x00db }
            r3.f34086b = r4     // Catch:{ Exception -> 0x00db }
            r3.f34087c = r2     // Catch:{ Exception -> 0x00db }
            r7 = 2
            r3.f34094j = r7     // Catch:{ Exception -> 0x00db }
            java.lang.Object r0 = r6.c((boolean) r0, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<com.sumsub.sns.internal.core.data.model.t>>) r3)     // Catch:{ Exception -> 0x00db }
            if (r0 != r10) goto L_0x010a
            return r10
        L_0x010a:
            r7 = r5
            r5 = r4
            r4 = r2
            r2 = r0
        L_0x010e:
            com.sumsub.sns.internal.core.data.source.dynamic.e r2 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r2     // Catch:{ Exception -> 0x005c }
            java.lang.Object r0 = r2.e()     // Catch:{ Exception -> 0x005c }
            com.sumsub.sns.internal.core.data.model.t r0 = (com.sumsub.sns.internal.core.data.model.t) r0     // Catch:{ Exception -> 0x005c }
            java.util.List r0 = r0.d()     // Catch:{ Exception -> 0x005c }
            com.sumsub.sns.core.c r14 = com.sumsub.sns.core.c.f30748a     // Catch:{ Exception -> 0x005c }
            java.lang.String r15 = "GetApplicantDataAndUpdateStatusIfNeededUseCase"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005c }
            r2.<init>()     // Catch:{ Exception -> 0x005c }
            java.lang.String r6 = r7.f34082c     // Catch:{ Exception -> 0x005c }
            r2.append(r6)     // Catch:{ Exception -> 0x005c }
            java.lang.String r6 = ": running with applicant="
            r2.append(r6)     // Catch:{ Exception -> 0x005c }
            java.lang.String r6 = com.sumsub.sns.internal.core.common.i.a((java.lang.Object) r4)     // Catch:{ Exception -> 0x005c }
            r2.append(r6)     // Catch:{ Exception -> 0x005c }
            java.lang.String r16 = r2.toString()     // Catch:{ Exception -> 0x005c }
            r17 = 0
            r18 = 4
            r19 = 0
            com.sumsub.sns.core.c.b(r14, r15, r16, r17, r18, r19)     // Catch:{ Exception -> 0x005c }
            com.sumsub.sns.internal.core.data.source.common.a r2 = r7.f34080a     // Catch:{ Exception -> 0x005c }
            r3.f34085a = r7     // Catch:{ Exception -> 0x005c }
            r3.f34086b = r5     // Catch:{ Exception -> 0x005c }
            r3.f34087c = r4     // Catch:{ Exception -> 0x005c }
            r3.f34088d = r0     // Catch:{ Exception -> 0x005c }
            r6 = 3
            r3.f34094j = r6     // Catch:{ Exception -> 0x005c }
            java.lang.Object r2 = r2.c(r3)     // Catch:{ Exception -> 0x005c }
            if (r2 != r10) goto L_0x00b1
            return r10
        L_0x0155:
            java.util.Locale r2 = (java.util.Locale) r2     // Catch:{ Exception -> 0x02ba }
            java.lang.String r2 = r2.getLanguage()     // Catch:{ Exception -> 0x02ba }
            com.sumsub.sns.internal.core.data.source.dynamic.b r4 = r9.f34081b     // Catch:{ Exception -> 0x02ba }
            r5 = 0
            r6 = 0
            r8 = 3
            r16 = 0
            r3.f34085a = r9     // Catch:{ Exception -> 0x02ba }
            r3.f34086b = r15     // Catch:{ Exception -> 0x02ba }
            r3.f34087c = r14     // Catch:{ Exception -> 0x02ba }
            r3.f34088d = r0     // Catch:{ Exception -> 0x02ba }
            r3.f34089e = r2     // Catch:{ Exception -> 0x02ba }
            r3.f34090f = r2     // Catch:{ Exception -> 0x02ba }
            r7 = 4
            r3.f34094j = r7     // Catch:{ Exception -> 0x02ba }
            r7 = r3
            r17 = r9
            r9 = r16
            java.lang.Object r4 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x02b8 }
            if (r4 != r10) goto L_0x017d
            return r10
        L_0x017d:
            r5 = r0
            r0 = r2
            r6 = r0
            r2 = r4
            r4 = r14
            r7 = r17
        L_0x0184:
            com.sumsub.sns.internal.core.data.model.g r2 = (com.sumsub.sns.internal.core.data.model.g) r2     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = r2.E()     // Catch:{ Exception -> 0x005c }
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.w(r0, r2, r13)     // Catch:{ Exception -> 0x005c }
            if (r0 != 0) goto L_0x01ab
            r3.f34085a = r7     // Catch:{ Exception -> 0x005c }
            r3.f34086b = r15     // Catch:{ Exception -> 0x005c }
            r3.f34087c = r4     // Catch:{ Exception -> 0x005c }
            r3.f34088d = r5     // Catch:{ Exception -> 0x005c }
            r3.f34089e = r12     // Catch:{ Exception -> 0x005c }
            r3.f34090f = r12     // Catch:{ Exception -> 0x005c }
            r0 = 5
            r3.f34094j = r0     // Catch:{ Exception -> 0x005c }
            java.lang.Object r0 = r15.a((java.lang.String) r6, (kotlin.coroutines.c<? super kotlin.Unit>) r3)     // Catch:{ Exception -> 0x005c }
            if (r0 != r10) goto L_0x01a6
            return r10
        L_0x01a6:
            r0 = r5
            r5 = r15
        L_0x01a8:
            r6 = r5
            r5 = r0
            goto L_0x01ac
        L_0x01ab:
            r6 = r15
        L_0x01ac:
            com.sumsub.sns.internal.core.data.model.m r0 = new com.sumsub.sns.internal.core.data.model.m     // Catch:{ Exception -> 0x005c }
            r0.<init>(r4)     // Catch:{ Exception -> 0x005c }
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r5, r0)     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = r4.L()     // Catch:{ Exception -> 0x005c }
            com.sumsub.sns.core.data.model.FlowActionType$FaceEnrollment r5 = com.sumsub.sns.core.data.model.FlowActionType.FaceEnrollment.INSTANCE     // Catch:{ Exception -> 0x005c }
            java.lang.String r5 = r5.getValue()     // Catch:{ Exception -> 0x005c }
            boolean r2 = kotlin.jvm.internal.x.b(r2, r5)     // Catch:{ Exception -> 0x005c }
            com.sumsub.sns.internal.core.data.source.dynamic.b r5 = r7.f34081b     // Catch:{ Exception -> 0x005c }
            r3.f34085a = r7     // Catch:{ Exception -> 0x005c }
            r3.f34086b = r6     // Catch:{ Exception -> 0x005c }
            r3.f34087c = r4     // Catch:{ Exception -> 0x005c }
            r3.f34088d = r0     // Catch:{ Exception -> 0x005c }
            r3.f34089e = r12     // Catch:{ Exception -> 0x005c }
            r3.f34090f = r12     // Catch:{ Exception -> 0x005c }
            r3.f34091g = r2     // Catch:{ Exception -> 0x005c }
            r8 = 6
            r3.f34094j = r8     // Catch:{ Exception -> 0x005c }
            java.lang.Object r5 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r5, r11, r3, r13, r12)     // Catch:{ Exception -> 0x005c }
            if (r5 != r10) goto L_0x01dd
            return r10
        L_0x01dd:
            r20 = r4
            r4 = r0
            r0 = r2
            r2 = r5
            r5 = r20
        L_0x01e4:
            com.sumsub.sns.internal.core.data.model.e r2 = (com.sumsub.sns.internal.core.data.model.e) r2     // Catch:{ Exception -> 0x02b4 }
            com.sumsub.sns.core.data.model.FlowType r2 = r2.y()     // Catch:{ Exception -> 0x02b4 }
            com.sumsub.sns.core.data.model.FlowType r8 = com.sumsub.sns.core.data.model.FlowType.Module     // Catch:{ Exception -> 0x02b4 }
            if (r2 == r8) goto L_0x01f2
            if (r0 != 0) goto L_0x01f2
            r0 = r13
            goto L_0x01f3
        L_0x01f2:
            r0 = r11
        L_0x01f3:
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r2 = r5.K()     // Catch:{ Exception -> 0x02b4 }
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r8 = com.sumsub.sns.internal.core.data.model.ReviewStatusType.Init     // Catch:{ Exception -> 0x02b4 }
            if (r2 != r8) goto L_0x0224
            boolean r2 = r4 instanceof java.util.Collection     // Catch:{ Exception -> 0x02b4 }
            if (r2 == 0) goto L_0x0206
            boolean r2 = r4.isEmpty()     // Catch:{ Exception -> 0x02b4 }
            if (r2 == 0) goto L_0x0206
            goto L_0x021e
        L_0x0206:
            java.util.Iterator r2 = r4.iterator()     // Catch:{ Exception -> 0x02b4 }
        L_0x020a:
            boolean r8 = r2.hasNext()     // Catch:{ Exception -> 0x02b4 }
            if (r8 == 0) goto L_0x021e
            java.lang.Object r8 = r2.next()     // Catch:{ Exception -> 0x02b4 }
            com.sumsub.sns.internal.core.data.model.Document r8 = (com.sumsub.sns.internal.core.data.model.Document) r8     // Catch:{ Exception -> 0x02b4 }
            boolean r8 = r8.isSubmitted()     // Catch:{ Exception -> 0x02b4 }
            if (r8 != 0) goto L_0x020a
            r2 = r11
            goto L_0x021f
        L_0x021e:
            r2 = r13
        L_0x021f:
            if (r2 == 0) goto L_0x0224
            if (r0 == 0) goto L_0x0224
            r11 = r13
        L_0x0224:
            if (r11 == 0) goto L_0x0280
            com.sumsub.sns.core.c r13 = com.sumsub.sns.core.c.f30748a     // Catch:{ Exception -> 0x02b4 }
            java.lang.String r14 = "GetApplicantDataAndUpdateStatusIfNeededUseCase"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b4 }
            r0.<init>()     // Catch:{ Exception -> 0x02b4 }
            java.lang.String r2 = r7.f34082c     // Catch:{ Exception -> 0x02b4 }
            r0.append(r2)     // Catch:{ Exception -> 0x02b4 }
            java.lang.String r2 = ": setting to 'pending'"
            r0.append(r2)     // Catch:{ Exception -> 0x02b4 }
            java.lang.String r15 = r0.toString()     // Catch:{ Exception -> 0x02b4 }
            r16 = 0
            r17 = 4
            r18 = 0
            com.sumsub.sns.core.c.b(r13, r14, r15, r16, r17, r18)     // Catch:{ Exception -> 0x02b4 }
            r3.f34085a = r7     // Catch:{ Exception -> 0x02b4 }
            r3.f34086b = r5     // Catch:{ Exception -> 0x02b4 }
            r3.f34087c = r4     // Catch:{ Exception -> 0x02b4 }
            r3.f34088d = r12     // Catch:{ Exception -> 0x02b4 }
            r0 = 7
            r3.f34094j = r0     // Catch:{ Exception -> 0x02b4 }
            java.lang.Object r2 = r6.b(r3)     // Catch:{ Exception -> 0x02b4 }
            if (r2 != r10) goto L_0x0258
            return r10
        L_0x0258:
            r0 = r4
            r4 = r5
            r3 = r7
        L_0x025b:
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x027e }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x027e }
            if (r2 == 0) goto L_0x027a
            com.sumsub.sns.internal.core.data.model.g$d r5 = r4.J()     // Catch:{ Exception -> 0x027e }
            r6 = 0
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r7 = com.sumsub.sns.internal.core.data.model.ReviewStatusType.Pending     // Catch:{ Exception -> 0x027e }
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 253(0xfd, float:3.55E-43)
            r15 = 0
            com.sumsub.sns.internal.core.data.model.g$d r2 = com.sumsub.sns.internal.core.data.model.g.d.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x027e }
            r4.a((com.sumsub.sns.internal.core.data.model.g.d) r2)     // Catch:{ Exception -> 0x027e }
        L_0x027a:
            r7 = r3
            r5 = r4
            r4 = r0
            goto L_0x0280
        L_0x027e:
            r0 = move-exception
            goto L_0x02b6
        L_0x0280:
            com.sumsub.sns.core.data.model.SNSSDKState r0 = com.sumsub.sns.internal.core.data.model.k.a(r5, r4)     // Catch:{ Exception -> 0x005c }
            if (r0 == 0) goto L_0x028b
            com.sumsub.sns.internal.core.data.source.common.a r2 = r7.f34080a     // Catch:{ Exception -> 0x005c }
            r2.a((com.sumsub.sns.core.data.model.SNSSDKState) r0)     // Catch:{ Exception -> 0x005c }
        L_0x028b:
            com.sumsub.sns.core.c r8 = com.sumsub.sns.core.c.f30748a     // Catch:{ Exception -> 0x005c }
            java.lang.String r9 = "GetApplicantDataAndUpdateStatusIfNeededUseCase"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005c }
            r0.<init>()     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = r7.f34082c     // Catch:{ Exception -> 0x005c }
            r0.append(r2)     // Catch:{ Exception -> 0x005c }
            java.lang.String r2 = ": finished"
            r0.append(r2)     // Catch:{ Exception -> 0x005c }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x005c }
            r11 = 0
            r12 = 4
            r13 = 0
            com.sumsub.sns.core.c.b(r8, r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x005c }
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ Exception -> 0x005c }
            com.sumsub.sns.internal.domain.e$a r0 = new com.sumsub.sns.internal.domain.e$a     // Catch:{ Exception -> 0x005c }
            r0.<init>(r5, r4)     // Catch:{ Exception -> 0x005c }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ Exception -> 0x005c }
            goto L_0x02ec
        L_0x02b4:
            r0 = move-exception
            r3 = r7
        L_0x02b6:
            r7 = r3
            goto L_0x02c2
        L_0x02b8:
            r0 = move-exception
            goto L_0x02bd
        L_0x02ba:
            r0 = move-exception
            r17 = r9
        L_0x02bd:
            r7 = r17
            goto L_0x02c2
        L_0x02c0:
            r0 = move-exception
            r7 = r1
        L_0x02c2:
            com.sumsub.sns.core.c r2 = com.sumsub.sns.core.c.f30748a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r7.f34082c
            r3.append(r4)
            java.lang.String r4 = ": finished with error"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "GetApplicantDataAndUpdateStatusIfNeededUseCase"
            r2.a(r4, r3, r0)
            kotlin.Result$a r2 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r2 = r7.f34080a
            java.lang.Exception r0 = com.sumsub.sns.internal.core.domain.base.d.a(r2, r0)
            java.lang.Object r0 = kotlin.k.a(r0)
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)
        L_0x02ec:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.e.a(boolean, com.sumsub.sns.internal.core.data.source.applicant.b, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(e eVar, boolean z11, com.sumsub.sns.internal.core.data.source.applicant.b bVar, c cVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return eVar.a(z11, bVar, cVar);
    }
}
