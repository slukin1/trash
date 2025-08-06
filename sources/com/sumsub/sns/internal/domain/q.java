package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.model.remote.k;
import com.sumsub.sns.internal.domain.n;
import java.io.File;
import java.util.List;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;

public final class q extends n<a> {

    public static final class a extends n.a {

        /* renamed from: d  reason: collision with root package name */
        public final File f34210d;

        /* renamed from: e  reason: collision with root package name */
        public final String f34211e;

        public a(Document document, File file, String str) {
            super(document, (String) null, true, 2, (r) null);
            this.f34210d = file;
            this.f34211e = str;
        }

        public final File d() {
            return this.f34210d;
        }

        public final String e() {
            return this.f34211e;
        }
    }

    @d(c = "com.sumsub.sns.internal.domain.UploadDocumentVideoSelfieUseCase", f = "UploadDocumentVideoSelfieUseCase.kt", l = {46}, m = "upload")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f34212a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ q f34213b;

        /* renamed from: c  reason: collision with root package name */
        public int f34214c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(q qVar, c<? super b> cVar) {
            super(cVar);
            this.f34213b = qVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34212a = obj;
            this.f34214c |= Integer.MIN_VALUE;
            return this.f34213b.b((a) null, (g) null, (String) null, (c<? super List<k>>) this);
        }
    }

    public q(com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.applicant.b bVar, com.sumsub.sns.internal.core.data.source.settings.b bVar2, com.sumsub.sns.internal.core.data.source.dynamic.b bVar3) {
        super(aVar, bVar, bVar2, bVar3);
    }

    public q(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.n(), aVar.g(), aVar.F(), aVar.p());
    }

    public Object a(a aVar, g gVar, String str, c<? super List<k>> cVar) {
        throw new UnsupportedOperationException("Not yet implemented and never will");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(com.sumsub.sns.internal.domain.q.a r15, com.sumsub.sns.internal.core.data.model.g r16, java.lang.String r17, kotlin.coroutines.c<? super java.util.List<com.sumsub.sns.internal.core.data.model.remote.k>> r18) {
        /*
            r14 = this;
            r0 = r18
            boolean r1 = r0 instanceof com.sumsub.sns.internal.domain.q.b
            if (r1 == 0) goto L_0x0016
            r1 = r0
            com.sumsub.sns.internal.domain.q$b r1 = (com.sumsub.sns.internal.domain.q.b) r1
            int r2 = r1.f34214c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0016
            int r2 = r2 - r3
            r1.f34214c = r2
            r2 = r14
            goto L_0x001c
        L_0x0016:
            com.sumsub.sns.internal.domain.q$b r1 = new com.sumsub.sns.internal.domain.q$b
            r2 = r14
            r1.<init>(r14, r0)
        L_0x001c:
            r11 = r1
            java.lang.Object r0 = r11.f34212a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r11.f34214c
            r4 = 1
            if (r3 == 0) goto L_0x0036
            if (r3 != r4) goto L_0x002e
            kotlin.k.b(r0)
            goto L_0x0087
        L_0x002e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0036:
            kotlin.k.b(r0)
            com.sumsub.sns.internal.core.data.model.Document r0 = r15.b()
            com.sumsub.sns.internal.core.data.model.DocumentType r0 = r0.getType()
            r3 = r16
            java.util.List r0 = r3.b(r0)
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r0)
            com.sumsub.sns.internal.core.data.model.q r0 = (com.sumsub.sns.internal.core.data.model.q) r0
            if (r0 == 0) goto L_0x0055
            java.lang.String r0 = r0.b()
            if (r0 != 0) goto L_0x005b
        L_0x0055:
            com.sumsub.sns.internal.core.data.model.q$g r0 = com.sumsub.sns.internal.core.data.model.q.g.f32693f
            java.lang.String r0 = r0.b()
        L_0x005b:
            r6 = r0
            java.lang.String r0 = r15.e()
            java.lang.String r0 = com.sumsub.sns.internal.core.common.i.a((java.lang.String) r0)
            java.lang.String r3 = "X-Video-Selfie-Phrase"
            kotlin.Pair r0 = kotlin.l.a(r3, r0)
            java.util.Map r8 = kotlin.collections.MapsKt__MapsJVMKt.e(r0)
            com.sumsub.sns.internal.core.data.source.applicant.b r3 = r14.b()
            java.io.File r5 = r15.d()
            r11.f34214c = r4
            r7 = 0
            r9 = 0
            r10 = 0
            r12 = 40
            r13 = 0
            r4 = r17
            java.lang.Object r0 = com.sumsub.sns.internal.core.data.source.applicant.h.a(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            if (r0 != r1) goto L_0x0087
            return r1
        L_0x0087:
            java.util.List r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.q.b(com.sumsub.sns.internal.domain.q$a, com.sumsub.sns.internal.core.data.model.g, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
