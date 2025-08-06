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

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 \u001f2\u00020\u0001:\u0002\b\u000fB+\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0016\u0010\u0017B\u0011\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0019B?\b\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u0016\u0010\u001eJ!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000bR\"\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u0012\u0004\b\u0011\u0010\r\u001a\u0004\b\u0010\u0010\u000bR\"\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010\n\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0013\u0010\u000b¨\u0006 "}, d2 = {"Lcom/sumsub/sentry/f0;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "()Ljava/lang/String;", "getName$annotations", "()V", "name", "b", "e", "getVersion$annotations", "version", "c", "getRawDescription$annotations", "rawDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "sentryRuntime", "(Lcom/sumsub/sentry/f0;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class f0 {
    public static final b Companion = new b((r) null);

    /* renamed from: d  reason: collision with root package name */
    public static final String f30340d = "runtime";

    /* renamed from: a  reason: collision with root package name */
    public final String f30341a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30342b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30343c;

    public static final class a implements d0<f0> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30344a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30345b;

        static {
            a aVar = new a();
            f30344a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SentryRuntime", aVar, 3);
            pluginGeneratedSerialDescriptor.k("name", true);
            pluginGeneratedSerialDescriptor.k("version", true);
            pluginGeneratedSerialDescriptor.k("raw_description", true);
            f30345b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.f0 deserialize(kotlinx.serialization.encoding.c r12) {
            /*
                r11 = this;
                kotlinx.serialization.descriptors.f r0 = r11.getDescriptor()
                kotlinx.serialization.encoding.a r12 = r12.b(r0)
                boolean r1 = r12.k()
                r2 = 0
                r3 = 2
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L_0x0023
                kotlinx.serialization.internal.v1 r1 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r4 = r12.j(r0, r4, r1, r2)
                java.lang.Object r5 = r12.j(r0, r5, r1, r2)
                java.lang.Object r1 = r12.j(r0, r3, r1, r2)
                r2 = 7
                r3 = r2
                goto L_0x005e
            L_0x0023:
                r1 = r2
                r6 = r1
                r7 = r6
                r2 = r4
                r8 = r5
            L_0x0028:
                if (r8 == 0) goto L_0x005a
                int r9 = r12.w(r0)
                r10 = -1
                if (r9 == r10) goto L_0x0058
                if (r9 == 0) goto L_0x004f
                if (r9 == r5) goto L_0x0046
                if (r9 != r3) goto L_0x0040
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r7 = r12.j(r0, r3, r9, r7)
                r2 = r2 | 4
                goto L_0x0028
            L_0x0040:
                kotlinx.serialization.UnknownFieldException r12 = new kotlinx.serialization.UnknownFieldException
                r12.<init>((int) r9)
                throw r12
            L_0x0046:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r6 = r12.j(r0, r5, r9, r6)
                r2 = r2 | 2
                goto L_0x0028
            L_0x004f:
                kotlinx.serialization.internal.v1 r9 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r1 = r12.j(r0, r4, r9, r1)
                r2 = r2 | 1
                goto L_0x0028
            L_0x0058:
                r8 = r4
                goto L_0x0028
            L_0x005a:
                r4 = r1
                r3 = r2
                r5 = r6
                r1 = r7
            L_0x005e:
                r12.c(r0)
                com.sumsub.sentry.f0 r12 = new com.sumsub.sentry.f0
                java.lang.String r4 = (java.lang.String) r4
                java.lang.String r5 = (java.lang.String) r5
                r6 = r1
                java.lang.String r6 = (java.lang.String) r6
                r7 = 0
                r2 = r12
                r2.<init>((int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (kotlinx.serialization.internal.q1) r7)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.f0.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.f0");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30345b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, f0 f0Var) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            f0.a(f0Var, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<f0> serializer() {
            return a.f30344a;
        }

        public b() {
        }
    }

    public f0() {
        this((String) null, (String) null, (String) null, 7, (r) null);
    }

    public static final void a(f0 f0Var, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || f0Var.f30341a != null) {
            bVar.y(fVar, 0, v1.f57779a, f0Var.f30341a);
        }
        if (bVar.q(fVar, 1) || f0Var.f30342b != null) {
            bVar.y(fVar, 1, v1.f57779a, f0Var.f30342b);
        }
        if (bVar.q(fVar, 2) || f0Var.f30343c != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 2, v1.f57779a, f0Var.f30343c);
        }
    }

    public static /* synthetic */ void b() {
    }

    public static /* synthetic */ void d() {
    }

    public static /* synthetic */ void f() {
    }

    public final String c() {
        return this.f30343c;
    }

    public final String e() {
        return this.f30342b;
    }

    public /* synthetic */ f0(int i11, String str, String str2, String str3, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30344a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30341a = null;
        } else {
            this.f30341a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30342b = null;
        } else {
            this.f30342b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f30343c = null;
        } else {
            this.f30343c = str3;
        }
    }

    public final String a() {
        return this.f30341a;
    }

    public f0(String str, String str2, String str3) {
        this.f30341a = str;
        this.f30342b = str2;
        this.f30343c = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f0(String str, String str2, String str3, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }

    public f0(f0 f0Var) {
        this(f0Var.f30341a, f0Var.f30342b, f0Var.f30343c);
    }
}
