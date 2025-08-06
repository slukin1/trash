package com.sumsub.sns.internal.core.data.model.remote.response;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 +2\u00020\u0001:\u0002\b\nB7\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b%\u0010&BK\b\u0017\u0012\u0006\u0010'\u001a\u00020\u0015\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\f\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b%\u0010*J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ@\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\b\u0010\u0013J\t\u0010\u0014\u001a\u00020\tHÖ\u0001J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\n\u0010\u0019\u0012\u0004\b\u001f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001bR\"\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u0012\u0004\b!\u0010\u001d\u001a\u0004\b \u0010\u001bR\"\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\"\u0012\u0004\b$\u0010\u001d\u001a\u0004\b#\u0010\u000e¨\u0006,"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/h;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "b", "c", "", "d", "()Ljava/lang/Boolean;", "workflowId", "runId", "runStatus", "levelChangePossible", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/sumsub/sns/internal/core/data/model/remote/response/h;", "toString", "", "hashCode", "other", "equals", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "getWorkflowId$annotations", "()V", "g", "getRunId$annotations", "i", "getRunStatus$annotations", "Ljava/lang/Boolean;", "e", "getLevelChangePossible$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class h {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32910a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32911b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32912c;

    /* renamed from: d  reason: collision with root package name */
    public final Boolean f32913d;

    public static final class a implements d0<h> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32914a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32915b;

        static {
            a aVar = new a();
            f32914a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.WorkflowStatus", aVar, 4);
            pluginGeneratedSerialDescriptor.k("workflowId", true);
            pluginGeneratedSerialDescriptor.k("runId", true);
            pluginGeneratedSerialDescriptor.k("runStatus", true);
            pluginGeneratedSerialDescriptor.k("levelChangePossible", true);
            f32915b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.response.h deserialize(kotlinx.serialization.encoding.c r14) {
            /*
                r13 = this;
                kotlinx.serialization.descriptors.f r0 = r13.getDescriptor()
                kotlinx.serialization.encoding.a r14 = r14.b(r0)
                boolean r1 = r14.k()
                r2 = 3
                r3 = 2
                r4 = 0
                r5 = 0
                r6 = 1
                if (r1 == 0) goto L_0x002b
                kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r5 = r14.j(r0, r5, r1, r4)
                java.lang.Object r6 = r14.j(r0, r6, r1, r4)
                java.lang.Object r1 = r14.j(r0, r3, r1, r4)
                kotlinx.serialization.internal.h r3 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r2 = r14.j(r0, r2, r3, r4)
                r3 = 15
                r4 = r3
                goto L_0x0072
            L_0x002b:
                r7 = r4
                r8 = r7
                r9 = r8
                r1 = r5
                r10 = r6
            L_0x0030:
                if (r10 == 0) goto L_0x006d
                int r11 = r14.w(r0)
                r12 = -1
                if (r11 == r12) goto L_0x006b
                if (r11 == 0) goto L_0x0062
                if (r11 == r6) goto L_0x0059
                if (r11 == r3) goto L_0x0050
                if (r11 != r2) goto L_0x004a
                kotlinx.serialization.internal.h r11 = kotlinx.serialization.internal.h.f57720a
                java.lang.Object r9 = r14.j(r0, r2, r11, r9)
                r1 = r1 | 8
                goto L_0x0030
            L_0x004a:
                kotlinx.serialization.UnknownFieldException r14 = new kotlinx.serialization.UnknownFieldException
                r14.<init>((int) r11)
                throw r14
            L_0x0050:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r14.j(r0, r3, r11, r8)
                r1 = r1 | 4
                goto L_0x0030
            L_0x0059:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r14.j(r0, r6, r11, r7)
                r1 = r1 | 2
                goto L_0x0030
            L_0x0062:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r4 = r14.j(r0, r5, r11, r4)
                r1 = r1 | 1
                goto L_0x0030
            L_0x006b:
                r10 = r5
                goto L_0x0030
            L_0x006d:
                r5 = r4
                r6 = r7
                r2 = r9
                r4 = r1
                r1 = r8
            L_0x0072:
                r14.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.response.h r14 = new com.sumsub.sns.internal.core.data.model.remote.response.h
                java.lang.String r5 = (java.lang.String) r5
                java.lang.String r6 = (java.lang.String) r6
                r7 = r1
                java.lang.String r7 = (java.lang.String) r7
                r8 = r2
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                r9 = 0
                r3 = r14
                r3.<init>((int) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.Boolean) r8, (kotlinx.serialization.internal.q1) r9)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.h.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.h");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(kotlinx.serialization.internal.h.f57720a)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32915b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, h hVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            h.a(hVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<h> serializer() {
            return a.f32914a;
        }

        public b() {
        }
    }

    public h() {
        this((String) null, (String) null, (String) null, (Boolean) null, 15, (r) null);
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void l() {
    }

    public final String a() {
        return this.f32910a;
    }

    public final String b() {
        return this.f32911b;
    }

    public final String c() {
        return this.f32912c;
    }

    public final Boolean d() {
        return this.f32913d;
    }

    public final Boolean e() {
        return this.f32913d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return x.b(this.f32910a, hVar.f32910a) && x.b(this.f32911b, hVar.f32911b) && x.b(this.f32912c, hVar.f32912c) && x.b(this.f32913d, hVar.f32913d);
    }

    public final String g() {
        return this.f32911b;
    }

    public int hashCode() {
        String str = this.f32910a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f32911b;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f32912c;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.f32913d;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode3 + i11;
    }

    public final String i() {
        return this.f32912c;
    }

    public final String k() {
        return this.f32910a;
    }

    public String toString() {
        return "WorkflowStatus(workflowId=" + this.f32910a + ", runId=" + this.f32911b + ", runStatus=" + this.f32912c + ", levelChangePossible=" + this.f32913d + ')';
    }

    public /* synthetic */ h(int i11, String str, String str2, String str3, Boolean bool, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f32914a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32910a = null;
        } else {
            this.f32910a = str;
        }
        if ((i11 & 2) == 0) {
            this.f32911b = null;
        } else {
            this.f32911b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f32912c = null;
        } else {
            this.f32912c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f32913d = null;
        } else {
            this.f32913d = bool;
        }
    }

    public final h a(String str, String str2, String str3, Boolean bool) {
        return new h(str, str2, str3, bool);
    }

    public h(String str, String str2, String str3, Boolean bool) {
        this.f32910a = str;
        this.f32911b = str2;
        this.f32912c = str3;
        this.f32913d = bool;
    }

    public static /* synthetic */ h a(h hVar, String str, String str2, String str3, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = hVar.f32910a;
        }
        if ((i11 & 2) != 0) {
            str2 = hVar.f32911b;
        }
        if ((i11 & 4) != 0) {
            str3 = hVar.f32912c;
        }
        if ((i11 & 8) != 0) {
            bool = hVar.f32913d;
        }
        return hVar.a(str, str2, str3, bool);
    }

    public static final void a(h hVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || hVar.f32910a != null) {
            bVar.y(fVar, 0, v1.f57779a, hVar.f32910a);
        }
        if (bVar.q(fVar, 1) || hVar.f32911b != null) {
            bVar.y(fVar, 1, v1.f57779a, hVar.f32911b);
        }
        if (bVar.q(fVar, 2) || hVar.f32912c != null) {
            bVar.y(fVar, 2, v1.f57779a, hVar.f32912c);
        }
        if (bVar.q(fVar, 3) || hVar.f32913d != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 3, kotlinx.serialization.internal.h.f57720a, hVar.f32913d);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(String str, String str2, String str3, Boolean bool, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : bool);
    }
}
