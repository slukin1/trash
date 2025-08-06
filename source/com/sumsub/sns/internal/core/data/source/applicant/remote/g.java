package com.sumsub.sns.internal.core.data.source.applicant.remote;

import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 +2\u00020\u0001:\u0002\b\fB7\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b%\u0010&BK\b\u0017\u0012\u0006\u0010'\u001a\u00020\t\u0012\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b%\u0010*J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\b\u0010\nJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0012\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\r\u0010\nJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003J@\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\b\u0010\u0013J\t\u0010\u0014\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0015\u001a\u00020\tHÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u000f\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001a\u0010\nR\"\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u001d\u0012\u0004\b \u0010\u001c\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0019\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b!\u0010\nR\"\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u001d\u0012\u0004\b$\u0010\u001c\u001a\u0004\b#\u0010\u001f¨\u0006,"}, d2 = {"Lcom/sumsub/sns/internal/core/data/source/applicant/remote/g;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "()Ljava/lang/Integer;", "", "b", "c", "d", "ok", "description", "code", "correlationId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/sumsub/sns/internal/core/data/source/applicant/remote/g;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Integer;", "k", "getOk$annotations", "()V", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "getDescription$annotations", "e", "getCode$annotations", "g", "getCorrelationId$annotations", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class g {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Integer f33149a;

    /* renamed from: b  reason: collision with root package name */
    public final String f33150b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f33151c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33152d;

    public static final class a implements d0<g> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f33153a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f33154b;

        static {
            a aVar = new a();
            f33153a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.source.applicant.remote.BasicResponse", aVar, 4);
            pluginGeneratedSerialDescriptor.k(BaseHbgResponse.STATUS_OK, true);
            pluginGeneratedSerialDescriptor.k("description", true);
            pluginGeneratedSerialDescriptor.k("code", true);
            pluginGeneratedSerialDescriptor.k("correlationId", true);
            f33154b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.source.applicant.remote.g deserialize(kotlinx.serialization.encoding.c r14) {
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
                kotlinx.serialization.internal.m0 r1 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r5 = r14.j(r0, r5, r1, r4)
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r6 = r14.j(r0, r6, r7, r4)
                java.lang.Object r1 = r14.j(r0, r3, r1, r4)
                java.lang.Object r2 = r14.j(r0, r2, r7, r4)
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
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r14.j(r0, r2, r11, r9)
                r1 = r1 | 8
                goto L_0x0030
            L_0x004a:
                kotlinx.serialization.UnknownFieldException r14 = new kotlinx.serialization.UnknownFieldException
                r14.<init>((int) r11)
                throw r14
            L_0x0050:
                kotlinx.serialization.internal.m0 r11 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r8 = r14.j(r0, r3, r11, r8)
                r1 = r1 | 4
                goto L_0x0030
            L_0x0059:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r14.j(r0, r6, r11, r7)
                r1 = r1 | 2
                goto L_0x0030
            L_0x0062:
                kotlinx.serialization.internal.m0 r11 = kotlinx.serialization.internal.m0.f57742a
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
                com.sumsub.sns.internal.core.data.source.applicant.remote.g r14 = new com.sumsub.sns.internal.core.data.source.applicant.remote.g
                java.lang.Integer r5 = (java.lang.Integer) r5
                java.lang.String r6 = (java.lang.String) r6
                r7 = r1
                java.lang.Integer r7 = (java.lang.Integer) r7
                r8 = r2
                java.lang.String r8 = (java.lang.String) r8
                r9 = 0
                r3 = r14
                r3.<init>((int) r4, (java.lang.Integer) r5, (java.lang.String) r6, (java.lang.Integer) r7, (java.lang.String) r8, (kotlinx.serialization.internal.q1) r9)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.applicant.remote.g.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.source.applicant.remote.g");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            m0 m0Var = m0.f57742a;
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(m0Var), h10.a.u(v1Var), h10.a.u(m0Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f33154b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, g gVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            g.a(gVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<g> serializer() {
            return a.f33153a;
        }

        public b() {
        }
    }

    public g() {
        this((Integer) null, (String) null, (Integer) null, (String) null, 15, (r) null);
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void l() {
    }

    public final Integer a() {
        return this.f33149a;
    }

    public final String b() {
        return this.f33150b;
    }

    public final Integer c() {
        return this.f33151c;
    }

    public final String d() {
        return this.f33152d;
    }

    public final Integer e() {
        return this.f33151c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return x.b(this.f33149a, gVar.f33149a) && x.b(this.f33150b, gVar.f33150b) && x.b(this.f33151c, gVar.f33151c) && x.b(this.f33152d, gVar.f33152d);
    }

    public final String g() {
        return this.f33152d;
    }

    public int hashCode() {
        Integer num = this.f33149a;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f33150b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.f33151c;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.f33152d;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode3 + i11;
    }

    public final String i() {
        return this.f33150b;
    }

    public final Integer k() {
        return this.f33149a;
    }

    public String toString() {
        return "BasicResponse(ok=" + this.f33149a + ", description=" + this.f33150b + ", code=" + this.f33151c + ", correlationId=" + this.f33152d + ')';
    }

    public /* synthetic */ g(int i11, Integer num, String str, Integer num2, String str2, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f33153a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f33149a = null;
        } else {
            this.f33149a = num;
        }
        if ((i11 & 2) == 0) {
            this.f33150b = null;
        } else {
            this.f33150b = str;
        }
        if ((i11 & 4) == 0) {
            this.f33151c = null;
        } else {
            this.f33151c = num2;
        }
        if ((i11 & 8) == 0) {
            this.f33152d = null;
        } else {
            this.f33152d = str2;
        }
    }

    public final g a(Integer num, String str, Integer num2, String str2) {
        return new g(num, str, num2, str2);
    }

    public g(Integer num, String str, Integer num2, String str2) {
        this.f33149a = num;
        this.f33150b = str;
        this.f33151c = num2;
        this.f33152d = str2;
    }

    public static /* synthetic */ g a(g gVar, Integer num, String str, Integer num2, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = gVar.f33149a;
        }
        if ((i11 & 2) != 0) {
            str = gVar.f33150b;
        }
        if ((i11 & 4) != 0) {
            num2 = gVar.f33151c;
        }
        if ((i11 & 8) != 0) {
            str2 = gVar.f33152d;
        }
        return gVar.a(num, str, num2, str2);
    }

    public static final void a(g gVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || gVar.f33149a != null) {
            bVar.y(fVar, 0, m0.f57742a, gVar.f33149a);
        }
        if (bVar.q(fVar, 1) || gVar.f33150b != null) {
            bVar.y(fVar, 1, v1.f57779a, gVar.f33150b);
        }
        if (bVar.q(fVar, 2) || gVar.f33151c != null) {
            bVar.y(fVar, 2, m0.f57742a, gVar.f33151c);
        }
        if (bVar.q(fVar, 3) || gVar.f33152d != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 3, v1.f57779a, gVar.f33152d);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(Integer num, String str, Integer num2, String str2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : num2, (i11 & 8) != 0 ? null : str2);
    }
}
