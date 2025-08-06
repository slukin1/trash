package com.sumsub.sns.internal.core.data.model.remote.response;

import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.model.remote.m;
import com.sumsub.sns.internal.core.data.model.remote.response.c;
import com.sumsub.sns.internal.core.data.model.remote.response.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 -2\u00020\u0001:\u0002\b\rB7\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b'\u0010(BM\b\u0017\u0012\u0006\u0010)\u001a\u00020\u0015\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0001\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\n\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b'\u0010,J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\nHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J9\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR.\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u001f\u0012\u0004\b\"\u0010\u001e\u001a\u0004\b \u0010!R\"\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010#\u0012\u0004\b&\u0010\u001e\u001a\u0004\b$\u0010%¨\u0006."}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/f;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "Lcom/sumsub/sns/internal/core/data/model/remote/response/c;", "", "Lcom/sumsub/sns/internal/core/data/model/DocumentType;", "Lcom/sumsub/sns/internal/core/data/model/remote/m;", "b", "Lcom/sumsub/sns/internal/core/data/model/remote/response/h;", "c", "inspectionReview", "requiredIdDocsStatus", "workflowStatus", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/sumsub/sns/internal/core/data/model/remote/response/c;", "d", "()Lcom/sumsub/sns/internal/core/data/model/remote/response/c;", "getInspectionReview$annotations", "()V", "Ljava/util/Map;", "f", "()Ljava/util/Map;", "getRequiredIdDocsStatus$annotations", "Lcom/sumsub/sns/internal/core/data/model/remote/response/h;", "h", "()Lcom/sumsub/sns/internal/core/data/model/remote/response/h;", "getWorkflowStatus$annotations", "<init>", "(Lcom/sumsub/sns/internal/core/data/model/remote/response/c;Ljava/util/Map;Lcom/sumsub/sns/internal/core/data/model/remote/response/h;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILcom/sumsub/sns/internal/core/data/model/remote/response/c;Ljava/util/Map;Lcom/sumsub/sns/internal/core/data/model/remote/response/h;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@kotlinx.serialization.f
public final class f {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final c f32896a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<DocumentType, m> f32897b;

    /* renamed from: c  reason: collision with root package name */
    public final h f32898c;

    public static final class a implements d0<f> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32899a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32900b;

        static {
            a aVar = new a();
            f32899a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.RequiredIdDocsStatusResponse", aVar, 3);
            pluginGeneratedSerialDescriptor.k("inspectionReview", true);
            pluginGeneratedSerialDescriptor.k("requiredIdDocsStatus", true);
            pluginGeneratedSerialDescriptor.k("workflowStatus", true);
            f32900b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.response.f deserialize(kotlinx.serialization.encoding.c r14) {
            /*
                r13 = this;
                kotlinx.serialization.descriptors.f r0 = r13.getDescriptor()
                kotlinx.serialization.encoding.a r14 = r14.b(r0)
                boolean r1 = r14.k()
                r2 = 0
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0034
                com.sumsub.sns.internal.core.data.model.remote.response.c$a r1 = com.sumsub.sns.internal.core.data.model.remote.response.c.a.f32810a
                java.lang.Object r1 = r14.j(r0, r4, r1, r2)
                kotlinx.serialization.internal.r0 r4 = new kotlinx.serialization.internal.r0
                com.sumsub.sns.internal.core.data.model.DocumentType$a$a r6 = com.sumsub.sns.internal.core.data.model.DocumentType.a.C0330a.f32359a
                com.sumsub.sns.internal.core.data.model.remote.m$a r7 = com.sumsub.sns.internal.core.data.model.remote.m.a.f32788a
                kotlinx.serialization.b r7 = h10.a.u(r7)
                r4.<init>(r6, r7)
                java.lang.Object r4 = r14.p(r0, r5, r4, r2)
                com.sumsub.sns.internal.core.data.model.remote.response.h$a r5 = com.sumsub.sns.internal.core.data.model.remote.response.h.a.f32914a
                java.lang.Object r2 = r14.j(r0, r3, r5, r2)
                r3 = 7
                r12 = r4
                r4 = r3
                r3 = r12
                goto L_0x0079
            L_0x0034:
                r1 = r2
                r6 = r1
                r7 = r4
                r8 = r5
            L_0x0038:
                if (r8 == 0) goto L_0x0075
                int r9 = r14.w(r0)
                r10 = -1
                if (r9 == r10) goto L_0x0073
                if (r9 == 0) goto L_0x006a
                if (r9 == r5) goto L_0x0056
                if (r9 != r3) goto L_0x0050
                com.sumsub.sns.internal.core.data.model.remote.response.h$a r9 = com.sumsub.sns.internal.core.data.model.remote.response.h.a.f32914a
                java.lang.Object r6 = r14.j(r0, r3, r9, r6)
                r7 = r7 | 4
                goto L_0x0038
            L_0x0050:
                kotlinx.serialization.UnknownFieldException r14 = new kotlinx.serialization.UnknownFieldException
                r14.<init>((int) r9)
                throw r14
            L_0x0056:
                kotlinx.serialization.internal.r0 r9 = new kotlinx.serialization.internal.r0
                com.sumsub.sns.internal.core.data.model.DocumentType$a$a r10 = com.sumsub.sns.internal.core.data.model.DocumentType.a.C0330a.f32359a
                com.sumsub.sns.internal.core.data.model.remote.m$a r11 = com.sumsub.sns.internal.core.data.model.remote.m.a.f32788a
                kotlinx.serialization.b r11 = h10.a.u(r11)
                r9.<init>(r10, r11)
                java.lang.Object r1 = r14.p(r0, r5, r9, r1)
                r7 = r7 | 2
                goto L_0x0038
            L_0x006a:
                com.sumsub.sns.internal.core.data.model.remote.response.c$a r9 = com.sumsub.sns.internal.core.data.model.remote.response.c.a.f32810a
                java.lang.Object r2 = r14.j(r0, r4, r9, r2)
                r7 = r7 | 1
                goto L_0x0038
            L_0x0073:
                r8 = r4
                goto L_0x0038
            L_0x0075:
                r3 = r1
                r1 = r2
                r2 = r6
                r4 = r7
            L_0x0079:
                r14.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.response.f r14 = new com.sumsub.sns.internal.core.data.model.remote.response.f
                r5 = r1
                com.sumsub.sns.internal.core.data.model.remote.response.c r5 = (com.sumsub.sns.internal.core.data.model.remote.response.c) r5
                r6 = r3
                java.util.Map r6 = (java.util.Map) r6
                r7 = r2
                com.sumsub.sns.internal.core.data.model.remote.response.h r7 = (com.sumsub.sns.internal.core.data.model.remote.response.h) r7
                r8 = 0
                r3 = r14
                r3.<init>((int) r4, (com.sumsub.sns.internal.core.data.model.remote.response.c) r5, (java.util.Map) r6, (com.sumsub.sns.internal.core.data.model.remote.response.h) r7, (kotlinx.serialization.internal.q1) r8)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.f.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.f");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            return new kotlinx.serialization.b[]{h10.a.u(c.a.f32810a), new r0(DocumentType.a.C0330a.f32359a, h10.a.u(m.a.f32788a)), h10.a.u(h.a.f32914a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32900b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, f fVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            f.a(fVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<f> serializer() {
            return a.f32899a;
        }

        public b() {
        }
    }

    public f() {
        this((c) null, (Map) null, (h) null, 7, (r) null);
    }

    public static /* synthetic */ void e() {
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public final c a() {
        return this.f32896a;
    }

    public final Map<DocumentType, m> b() {
        return this.f32897b;
    }

    public final h c() {
        return this.f32898c;
    }

    public final c d() {
        return this.f32896a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return x.b(this.f32896a, fVar.f32896a) && x.b(this.f32897b, fVar.f32897b) && x.b(this.f32898c, fVar.f32898c);
    }

    public final Map<DocumentType, m> f() {
        return this.f32897b;
    }

    public final h h() {
        return this.f32898c;
    }

    public int hashCode() {
        c cVar = this.f32896a;
        int i11 = 0;
        int hashCode = (((cVar == null ? 0 : cVar.hashCode()) * 31) + this.f32897b.hashCode()) * 31;
        h hVar = this.f32898c;
        if (hVar != null) {
            i11 = hVar.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "RequiredIdDocsStatusResponse(inspectionReview=" + this.f32896a + ", requiredIdDocsStatus=" + this.f32897b + ", workflowStatus=" + this.f32898c + ')';
    }

    public /* synthetic */ f(int i11, c cVar, Map map, h hVar, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f32899a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32896a = null;
        } else {
            this.f32896a = cVar;
        }
        if ((i11 & 2) == 0) {
            this.f32897b = MapsKt__MapsKt.h();
        } else {
            this.f32897b = map;
        }
        if ((i11 & 4) == 0) {
            this.f32898c = null;
        } else {
            this.f32898c = hVar;
        }
    }

    public final f a(c cVar, Map<DocumentType, m> map, h hVar) {
        return new f(cVar, map, hVar);
    }

    public static /* synthetic */ f a(f fVar, c cVar, Map<DocumentType, m> map, h hVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cVar = fVar.f32896a;
        }
        if ((i11 & 2) != 0) {
            map = fVar.f32897b;
        }
        if ((i11 & 4) != 0) {
            hVar = fVar.f32898c;
        }
        return fVar.a(cVar, map, hVar);
    }

    public static final void a(f fVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar2) {
        boolean z11 = false;
        if (bVar.q(fVar2, 0) || fVar.f32896a != null) {
            bVar.y(fVar2, 0, c.a.f32810a, fVar.f32896a);
        }
        if (bVar.q(fVar2, 1) || !x.b(fVar.f32897b, MapsKt__MapsKt.h())) {
            bVar.F(fVar2, 1, new r0(DocumentType.a.C0330a.f32359a, h10.a.u(m.a.f32788a)), fVar.f32897b);
        }
        if (bVar.q(fVar2, 2) || fVar.f32898c != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar2, 2, h.a.f32914a, fVar.f32898c);
        }
    }

    public f(c cVar, Map<DocumentType, m> map, h hVar) {
        this.f32896a = cVar;
        this.f32897b = map;
        this.f32898c = hVar;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(c cVar, Map map, h hVar, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : cVar, (i11 & 2) != 0 ? MapsKt__MapsKt.h() : map, (i11 & 4) != 0 ? null : hVar);
    }
}
