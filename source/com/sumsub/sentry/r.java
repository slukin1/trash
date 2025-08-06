package com.sumsub.sentry;

import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import kotlin.Metadata;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.m0;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 #2\u00020\u0001:\u0002\b\u0010B7\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001d\u0010\u001eBK\b\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u000f\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\u001d\u0010\"J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R\"\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\b\u0010\n\u0012\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000bR\"\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u0018\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u0012\u0004\b\u0017\u0010\r\u001a\u0004\b\u0016\u0010\u0013R\"\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001a\u0010\u0013¨\u0006$"}, d2 = {"Lcom/sumsub/sentry/r;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "()Ljava/lang/String;", "getSdkName$annotations", "()V", "sdkName", "", "b", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "getVersionMajor$annotations", "versionMajor", "e", "getVersionMinor$annotations", "versionMinor", "d", "g", "getVersionPatchlevel$annotations", "versionPatchlevel", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class r {
    public static final b Companion = new b((kotlin.jvm.internal.r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f30484a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f30485b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f30486c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f30487d;

    public static final class a implements d0<r> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f30488a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30489b;

        static {
            a aVar = new a();
            f30488a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.SdkInfo", aVar, 4);
            pluginGeneratedSerialDescriptor.k(HianalyticsBaseData.SDK_NAME, true);
            pluginGeneratedSerialDescriptor.k("version_major", true);
            pluginGeneratedSerialDescriptor.k("version_minor", true);
            pluginGeneratedSerialDescriptor.k("version_patchlevel", true);
            f30489b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.r deserialize(kotlinx.serialization.encoding.c r14) {
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
                java.lang.Object r1 = r14.j(r0, r5, r1, r4)
                kotlinx.serialization.internal.m0 r5 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r6 = r14.j(r0, r6, r5, r4)
                java.lang.Object r3 = r14.j(r0, r3, r5, r4)
                java.lang.Object r2 = r14.j(r0, r2, r5, r4)
                r4 = 15
                r5 = r4
                goto L_0x0072
            L_0x002b:
                r1 = r4
                r7 = r1
                r8 = r7
                r9 = r8
                r4 = r5
                r10 = r6
            L_0x0031:
                if (r10 == 0) goto L_0x006e
                int r11 = r14.w(r0)
                r12 = -1
                if (r11 == r12) goto L_0x006c
                if (r11 == 0) goto L_0x0063
                if (r11 == r6) goto L_0x005a
                if (r11 == r3) goto L_0x0051
                if (r11 != r2) goto L_0x004b
                kotlinx.serialization.internal.m0 r11 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r9 = r14.j(r0, r2, r11, r9)
                r4 = r4 | 8
                goto L_0x0031
            L_0x004b:
                kotlinx.serialization.UnknownFieldException r14 = new kotlinx.serialization.UnknownFieldException
                r14.<init>((int) r11)
                throw r14
            L_0x0051:
                kotlinx.serialization.internal.m0 r11 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r8 = r14.j(r0, r3, r11, r8)
                r4 = r4 | 4
                goto L_0x0031
            L_0x005a:
                kotlinx.serialization.internal.m0 r11 = kotlinx.serialization.internal.m0.f57742a
                java.lang.Object r7 = r14.j(r0, r6, r11, r7)
                r4 = r4 | 2
                goto L_0x0031
            L_0x0063:
                kotlinx.serialization.internal.v1 r11 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r1 = r14.j(r0, r5, r11, r1)
                r4 = r4 | 1
                goto L_0x0031
            L_0x006c:
                r10 = r5
                goto L_0x0031
            L_0x006e:
                r5 = r4
                r6 = r7
                r3 = r8
                r2 = r9
            L_0x0072:
                r14.c(r0)
                com.sumsub.sentry.r r14 = new com.sumsub.sentry.r
                r0 = r1
                java.lang.String r0 = (java.lang.String) r0
                r7 = r6
                java.lang.Integer r7 = (java.lang.Integer) r7
                r8 = r3
                java.lang.Integer r8 = (java.lang.Integer) r8
                r9 = r2
                java.lang.Integer r9 = (java.lang.Integer) r9
                r10 = 0
                r4 = r14
                r6 = r0
                r4.<init>((int) r5, (java.lang.String) r6, (java.lang.Integer) r7, (java.lang.Integer) r8, (java.lang.Integer) r9, (kotlinx.serialization.internal.q1) r10)
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.r.a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.r");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            m0 m0Var = m0.f57742a;
            return new kotlinx.serialization.b[]{h10.a.u(v1.f57779a), h10.a.u(m0Var), h10.a.u(m0Var), h10.a.u(m0Var)};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30489b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, r rVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            r.a(rVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.r rVar) {
            this();
        }

        public final kotlinx.serialization.b<r> serializer() {
            return a.f30488a;
        }

        public b() {
        }
    }

    public r() {
        this((String) null, (Integer) null, (Integer) null, (Integer) null, 15, (kotlin.jvm.internal.r) null);
    }

    public static final void a(r rVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || rVar.f30484a != null) {
            bVar.y(fVar, 0, v1.f57779a, rVar.f30484a);
        }
        if (bVar.q(fVar, 1) || rVar.f30485b != null) {
            bVar.y(fVar, 1, m0.f57742a, rVar.f30485b);
        }
        if (bVar.q(fVar, 2) || rVar.f30486c != null) {
            bVar.y(fVar, 2, m0.f57742a, rVar.f30486c);
        }
        if (bVar.q(fVar, 3) || rVar.f30487d != null) {
            z11 = true;
        }
        if (z11) {
            bVar.y(fVar, 3, m0.f57742a, rVar.f30487d);
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

    public final Integer c() {
        return this.f30485b;
    }

    public final Integer e() {
        return this.f30486c;
    }

    public final Integer g() {
        return this.f30487d;
    }

    public /* synthetic */ r(int i11, String str, Integer num, Integer num2, Integer num3, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, a.f30488a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30484a = null;
        } else {
            this.f30484a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30485b = null;
        } else {
            this.f30485b = num;
        }
        if ((i11 & 4) == 0) {
            this.f30486c = null;
        } else {
            this.f30486c = num2;
        }
        if ((i11 & 8) == 0) {
            this.f30487d = null;
        } else {
            this.f30487d = num3;
        }
    }

    public final String a() {
        return this.f30484a;
    }

    public r(String str, Integer num, Integer num2, Integer num3) {
        this.f30484a = str;
        this.f30485b = num;
        this.f30486c = num2;
        this.f30487d = num3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(String str, Integer num, Integer num2, Integer num3, int i11, kotlin.jvm.internal.r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? null : num2, (i11 & 8) != 0 ? null : num3);
    }
}
