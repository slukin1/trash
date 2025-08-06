package com.sumsub.sentry;

import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \"2\u00020\u0001:\u0002\b\u000fB7\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u001b\u0010\u001cBK\b\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001a\u001a\u0004\u0018\u00010\t\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b\u001b\u0010!J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000bR*\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u000f\u0010\n\u0012\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\b\u0010\u0011R\"\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\n\u0012\u0004\b\u0015\u0010\r\u001a\u0004\b\u0014\u0010\u000bR\"\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010\n\u0012\u0004\b\u0019\u0010\r\u001a\u0004\b\u0018\u0010\u000b¨\u0006#"}, d2 = {"Lcom/sumsub/sentry/q0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "()Ljava/lang/String;", "getEmail$annotations", "()V", "email", "b", "c", "(Ljava/lang/String;)V", "getId$annotations", "id", "g", "getUsername$annotations", "username", "d", "e", "getIpAddress$annotations", "ipAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class q0 {
    public static final b Companion = new b((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f30478a;

    /* renamed from: b  reason: collision with root package name */
    public String f30479b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30480c;

    /* renamed from: d  reason: collision with root package name */
    public final String f30481d;

    public static final class a implements d0<q0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30482a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30483b;

        static {
            a aVar = new a();
            f30482a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.User", aVar, 4);
            pluginGeneratedSerialDescriptor.k("email", true);
            pluginGeneratedSerialDescriptor.k("id", true);
            pluginGeneratedSerialDescriptor.k("username", true);
            pluginGeneratedSerialDescriptor.k("ip_address", true);
            f30483b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.q0 deserialize(kotlinx.serialization.encoding.c r14) {
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
                if (r1 == 0) goto L_0x002a
                kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r5 = r14.j(r0, r5, r1, r4)
                java.lang.Object r6 = r14.j(r0, r6, r1, r4)
                java.lang.Object r3 = r14.j(r0, r3, r1, r4)
                java.lang.Object r1 = r14.j(r0, r2, r1, r4)
                r2 = 15
                r8 = r3
                r3 = r2
                goto L_0x0070
            L_0x002a:
                r7 = r4
                r8 = r7
                r9 = r8
                r1 = r5
                r10 = r6
            L_0x002f:
                if (r10 == 0) goto L_0x006c
                int r11 = r14.w(r0)
                r12 = -1
                if (r11 == r12) goto L_0x006a
                if (r11 == 0) goto L_0x0061
                if (r11 == r6) goto L_0x0058
                if (r11 == r3) goto L_0x004f
                if (r11 != r2) goto L_0x0049
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r9 = r14.j(r0, r2, r11, r9)
                r1 = r1 | 8
                goto L_0x002f
            L_0x0049:
                kotlinx.serialization.UnknownFieldException r14 = new kotlinx.serialization.UnknownFieldException
                r14.<init>((int) r11)
                throw r14
            L_0x004f:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r14.j(r0, r3, r11, r8)
                r1 = r1 | 4
                goto L_0x002f
            L_0x0058:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r14.j(r0, r6, r11, r7)
                r1 = r1 | 2
                goto L_0x002f
            L_0x0061:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r4 = r14.j(r0, r5, r11, r4)
                r1 = r1 | 1
                goto L_0x002f
            L_0x006a:
                r10 = r5
                goto L_0x002f
            L_0x006c:
                r3 = r1
                r5 = r4
                r6 = r7
                r1 = r9
            L_0x0070:
                r14.c(r0)
                com.sumsub.sentry.q0 r14 = new com.sumsub.sentry.q0
                r4 = r5
                java.lang.String r4 = (java.lang.String) r4
                r5 = r6
                java.lang.String r5 = (java.lang.String) r5
                r6 = r8
                java.lang.String r6 = (java.lang.String) r6
                r7 = r1
                java.lang.String r7 = (java.lang.String) r7
                r8 = 0
                r2 = r14
                r2.<init>((int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (kotlinx.serialization.internal.q1) r8)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.q0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.q0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30483b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, q0 q0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            q0.a(q0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<q0> serializer() {
            return a.f30482a;
        }

        public b() {
        }
    }

    public q0() {
        this((String) null, (String) null, (String) null, (String) null, 15, (r) null);
    }

    public static final void a(q0 q0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || q0Var.f30478a != null) {
            bVar.y(fVar, 0, v1.f57779a, q0Var.f30478a);
        }
        if (bVar.q(fVar, 1) || q0Var.f30479b != null) {
            bVar.y(fVar, 1, v1.f57779a, q0Var.f30479b);
        }
        if (bVar.q(fVar, 2) || q0Var.f30480c != null) {
            bVar.y(fVar, 2, v1.f57779a, q0Var.f30480c);
        }
        if (bVar.q(fVar, 3) || q0Var.f30481d != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 3, v1.f57779a, q0Var.f30481d);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public static /* synthetic */ void h() {
    }

    public final String c() {
        return this.f30479b;
    }

    public final String e() {
        return this.f30481d;
    }

    public final String g() {
        return this.f30480c;
    }

    public /* synthetic */ q0(int i11, String str, String str2, String str3, String str4, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30482a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30478a = null;
        } else {
            this.f30478a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30479b = null;
        } else {
            this.f30479b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f30480c = null;
        } else {
            this.f30480c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f30481d = null;
        } else {
            this.f30481d = str4;
        }
    }

    public final String a() {
        return this.f30478a;
    }

    public q0(String str, String str2, String str3, String str4) {
        this.f30478a = str;
        this.f30479b = str2;
        this.f30480c = str3;
        this.f30481d = str4;
    }

    public final void a(String str) {
        this.f30479b = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q0(String str, String str2, String str3, String str4, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4);
    }
}
