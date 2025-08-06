package com.sumsub.sns.internal.core.data.model.remote.response;

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

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 /2\u00020\u0001:\u0002\b\u000bBC\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b)\u0010*BW\b\u0017\u0012\u0006\u0010+\u001a\u00020\n\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\n\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b)\u0010.J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\u000b\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000e\u0010\fJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0003JL\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\b\u0010\u0015J\t\u0010\u0016\u001a\u00020\tHÖ\u0001J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\u001b\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010 \u0012\u0004\b\"\u0010\u001f\u001a\u0004\b!\u0010\fR\"\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u001b\u0012\u0004\b$\u0010\u001f\u001a\u0004\b#\u0010\u001dR\"\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010 \u0012\u0004\b&\u0010\u001f\u001a\u0004\b%\u0010\fR\"\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u001b\u0012\u0004\b(\u0010\u001f\u001a\u0004\b'\u0010\u001d¨\u00060"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/remote/response/b;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "", "b", "()Ljava/lang/Integer;", "c", "d", "e", "description", "code", "correlationId", "errorCode", "errorName", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/sumsub/sns/internal/core/data/model/remote/response/b;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "getDescription$annotations", "()V", "Ljava/lang/Integer;", "f", "getCode$annotations", "h", "getCorrelationId$annotations", "l", "getErrorCode$annotations", "n", "getErrorName$annotations", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class b {
    public static final C0349b Companion = new C0349b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f32802a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f32803b;

    /* renamed from: c  reason: collision with root package name */
    public final String f32804c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f32805d;

    /* renamed from: e  reason: collision with root package name */
    public final String f32806e;

    public static final class a implements d0<b> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f32807a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f32808b;

        static {
            a aVar = new a();
            f32807a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sns.internal.core.data.model.remote.response.ApiErrorResponse", aVar, 5);
            pluginGeneratedSerialDescriptor.k("description", true);
            pluginGeneratedSerialDescriptor.k("code", true);
            pluginGeneratedSerialDescriptor.k("correlationId", true);
            pluginGeneratedSerialDescriptor.k("errorCode", true);
            pluginGeneratedSerialDescriptor.k("errorName", true);
            f32808b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sns.internal.core.data.model.remote.response.b deserialize(kotlinx.serialization.encoding.c r17) {
            /*
                r16 = this;
                kotlinx.serialization.descriptors.f r0 = r16.getDescriptor()
                r1 = r17
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 3
                r4 = 4
                r5 = 2
                r6 = 0
                r7 = 0
                r8 = 1
                if (r2 == 0) goto L_0x0034
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r6 = r1.j(r0, r6, r2, r7)
                kotlinx.serialization.internal.m0 r9 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r8 = r1.j(r0, r8, r9, r7)
                java.lang.Object r5 = r1.j(r0, r5, r2, r7)
                java.lang.Object r3 = r1.j(r0, r3, r9, r7)
                java.lang.Object r2 = r1.j(r0, r4, r2, r7)
                r4 = 31
                r10 = r5
                r5 = r4
                goto L_0x0087
            L_0x0034:
                r2 = r6
                r9 = r7
                r10 = r9
                r11 = r10
                r12 = r11
                r13 = r8
            L_0x003a:
                if (r13 == 0) goto L_0x0082
                int r14 = r1.w(r0)
                r15 = -1
                if (r14 == r15) goto L_0x0080
                if (r14 == 0) goto L_0x0077
                if (r14 == r8) goto L_0x006e
                if (r14 == r5) goto L_0x0065
                if (r14 == r3) goto L_0x005c
                if (r14 != r4) goto L_0x0056
                kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r12 = r1.j(r0, r4, r14, r12)
                r2 = r2 | 16
                goto L_0x003a
            L_0x0056:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r14)
                throw r0
            L_0x005c:
                kotlinx.serialization.internal.m0 r14 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r11 = r1.j(r0, r3, r14, r11)
                r2 = r2 | 8
                goto L_0x003a
            L_0x0065:
                kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r10 = r1.j(r0, r5, r14, r10)
                r2 = r2 | 4
                goto L_0x003a
            L_0x006e:
                kotlinx.serialization.internal.m0 r14 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r9 = r1.j(r0, r8, r14, r9)
                r2 = r2 | 2
                goto L_0x003a
            L_0x0077:
                kotlinx.serialization.internal.v1 r14 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r1.j(r0, r6, r14, r7)
                r2 = r2 | 1
                goto L_0x003a
            L_0x0080:
                r13 = r6
                goto L_0x003a
            L_0x0082:
                r5 = r2
                r6 = r7
                r8 = r9
                r3 = r11
                r2 = r12
            L_0x0087:
                r1.c(r0)
                com.sumsub.sns.internal.core.data.model.remote.response.b r0 = new com.sumsub.sns.internal.core.data.model.remote.response.b
                java.lang.String r6 = (java.lang.String) r6
                r7 = r8
                java.lang.Integer r7 = (java.lang.Integer) r7
                r8 = r10
                java.lang.String r8 = (java.lang.String) r8
                r9 = r3
                java.lang.Integer r9 = (java.lang.Integer) r9
                r10 = r2
                java.lang.String r10 = (java.lang.String) r10
                r11 = 0
                r4 = r0
                r4.<init>((int) r5, (java.lang.String) r6, (java.lang.Integer) r7, (java.lang.String) r8, (java.lang.Integer) r9, (java.lang.String) r10, (kotlinx.serialization.internal.q1) r11)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.b.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sns.internal.core.data.model.remote.response.b");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            m0 m0Var = m0.f57742a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(m0Var), h10.a.u(v1Var), h10.a.u(m0Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f32808b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, b bVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            b.a(bVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.data.model.remote.response.b$b  reason: collision with other inner class name */
    public static final class C0349b {
        public /* synthetic */ C0349b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<b> serializer() {
            return a.f32807a;
        }

        public C0349b() {
        }
    }

    public b() {
        this((String) null, (Integer) null, (String) null, (Integer) null, (String) null, 31, (r) null);
    }

    public static /* synthetic */ void g() {
    }

    public static /* synthetic */ void i() {
    }

    public static /* synthetic */ void k() {
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void o() {
    }

    public final String a() {
        return this.f32802a;
    }

    public final Integer b() {
        return this.f32803b;
    }

    public final String c() {
        return this.f32804c;
    }

    public final Integer d() {
        return this.f32805d;
    }

    public final String e() {
        return this.f32806e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f32802a, bVar.f32802a) && x.b(this.f32803b, bVar.f32803b) && x.b(this.f32804c, bVar.f32804c) && x.b(this.f32805d, bVar.f32805d) && x.b(this.f32806e, bVar.f32806e);
    }

    public final Integer f() {
        return this.f32803b;
    }

    public final String h() {
        return this.f32804c;
    }

    public int hashCode() {
        String str = this.f32802a;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.f32803b;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.f32804c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num2 = this.f32805d;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.f32806e;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode4 + i11;
    }

    public final String j() {
        return this.f32802a;
    }

    public final Integer l() {
        return this.f32805d;
    }

    public final String n() {
        return this.f32806e;
    }

    public String toString() {
        return "ApiErrorResponse(description=" + this.f32802a + ", code=" + this.f32803b + ", correlationId=" + this.f32804c + ", errorCode=" + this.f32805d + ", errorName=" + this.f32806e + ')';
    }

    public /* synthetic */ b(int i11, String str, Integer num, String str2, Integer num2, String str3, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f32807a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f32802a = null;
        } else {
            this.f32802a = str;
        }
        if ((i11 & 2) == 0) {
            this.f32803b = null;
        } else {
            this.f32803b = num;
        }
        if ((i11 & 4) == 0) {
            this.f32804c = null;
        } else {
            this.f32804c = str2;
        }
        if ((i11 & 8) == 0) {
            this.f32805d = null;
        } else {
            this.f32805d = num2;
        }
        if ((i11 & 16) == 0) {
            this.f32806e = null;
        } else {
            this.f32806e = str3;
        }
    }

    public final b a(String str, Integer num, String str2, Integer num2, String str3) {
        return new b(str, num, str2, num2, str3);
    }

    public b(String str, Integer num, String str2, Integer num2, String str3) {
        this.f32802a = str;
        this.f32803b = num;
        this.f32804c = str2;
        this.f32805d = num2;
        this.f32806e = str3;
    }

    public static /* synthetic */ b a(b bVar, String str, Integer num, String str2, Integer num2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bVar.f32802a;
        }
        if ((i11 & 2) != 0) {
            num = bVar.f32803b;
        }
        Integer num3 = num;
        if ((i11 & 4) != 0) {
            str2 = bVar.f32804c;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            num2 = bVar.f32805d;
        }
        Integer num4 = num2;
        if ((i11 & 16) != 0) {
            str3 = bVar.f32806e;
        }
        return bVar.a(str, num3, str4, num4, str3);
    }

    public static final void a(b bVar, kotlinx.serialization.encoding.b bVar2, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar2.q(fVar, 0) || bVar.f32802a != null) {
            bVar2.y(fVar, 0, v1.f57779a, bVar.f32802a);
        }
        if (bVar2.q(fVar, 1) || bVar.f32803b != null) {
            bVar2.y(fVar, 1, m0.f57742a, bVar.f32803b);
        }
        if (bVar2.q(fVar, 2) || bVar.f32804c != null) {
            bVar2.y(fVar, 2, v1.f57779a, bVar.f32804c);
        }
        if (bVar2.q(fVar, 3) || bVar.f32805d != null) {
            bVar2.y(fVar, 3, m0.f57742a, bVar.f32805d);
        }
        if (bVar2.q(fVar, 4) || bVar.f32806e != null) {
            z11 = true;
        }
        if (z11) {
            bVar2.y(fVar, 4, v1.f57779a, bVar.f32806e);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ b(java.lang.String r5, java.lang.Integer r6, java.lang.String r7, java.lang.Integer r8, java.lang.String r9, int r10, kotlin.jvm.internal.r r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.response.b.<init>(java.lang.String, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
