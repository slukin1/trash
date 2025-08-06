package com.sumsub.sentry;

import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.d0;
import kotlinx.serialization.internal.h1;
import kotlinx.serialization.internal.q1;
import kotlinx.serialization.internal.r0;
import kotlinx.serialization.internal.v1;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 22\u00020\u0001:\u0002\b\rBg\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\"¢\u0006\u0004\b)\u0010*B\u0011\b\u0010\u0012\u0006\u0010+\u001a\u00020\u0000¢\u0006\u0004\b)\u0010,B{\b\u0017\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010\u001e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0001\u0010!\u001a\u0004\u0018\u00010\t\u0012\u0016\b\u0001\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\"\u0012\b\u00100\u001a\u0004\u0018\u00010/¢\u0006\u0004\b)\u00101J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001R*\u0010\u0011\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\b\u0010\n\u0012\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\n\u0012\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0012\u0010\fR\"\u0010\u0017\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\n\u0012\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0015\u0010\fR*\u0010\u001b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\n\u0012\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u000b\u0010\u000eR*\u0010\u001e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u0019\u0010\n\u0012\u0004\b\u001d\u0010\u0010\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u0018\u0010\u000eR*\u0010!\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u001f\u0010\n\u0012\u0004\b \u0010\u0010\u001a\u0004\b\b\u0010\f\"\u0004\b\b\u0010\u000eR6\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\"8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\u001c\u0010#\u0012\u0004\b'\u0010\u0010\u001a\u0004\b$\u0010%\"\u0004\b\b\u0010&¨\u00063"}, d2 = {"Lcom/sumsub/sentry/a;", "", "self", "Lkotlinx/serialization/encoding/b;", "output", "Lkotlinx/serialization/descriptors/f;", "serialDesc", "", "a", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "getAppIdentifier$annotations", "()V", "appIdentifier", "k", "getDeviceAppHash$annotations", "deviceAppHash", "i", "getBuildType$annotations", "buildType", "d", "e", "getAppName$annotations", "appName", "g", "getAppVersion$annotations", "appVersion", "f", "getAppBuild$annotations", "appBuild", "", "Ljava/util/Map;", "m", "()Ljava/util/Map;", "(Ljava/util/Map;)V", "getPermissions$annotations", "permissions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "app", "(Lcom/sumsub/sentry/a;)V", "", "seen1", "Lkotlinx/serialization/internal/q1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/q1;)V", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@f
public final class a {
    public static final b Companion = new b((r) null);

    /* renamed from: h  reason: collision with root package name */
    public static final String f30241h = "app";

    /* renamed from: a  reason: collision with root package name */
    public String f30242a;

    /* renamed from: b  reason: collision with root package name */
    public final String f30243b;

    /* renamed from: c  reason: collision with root package name */
    public final String f30244c;

    /* renamed from: d  reason: collision with root package name */
    public String f30245d;

    /* renamed from: e  reason: collision with root package name */
    public String f30246e;

    /* renamed from: f  reason: collision with root package name */
    public String f30247f;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f30248g;

    /* renamed from: com.sumsub.sentry.a$a  reason: collision with other inner class name */
    public static final class C0268a implements d0<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0268a f30249a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ kotlinx.serialization.descriptors.f f30250b;

        static {
            C0268a aVar = new C0268a();
            f30249a = aVar;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sumsub.sentry.App", aVar, 7);
            pluginGeneratedSerialDescriptor.k("app_identifier", true);
            pluginGeneratedSerialDescriptor.k("device_app_hash", true);
            pluginGeneratedSerialDescriptor.k("build_type", true);
            pluginGeneratedSerialDescriptor.k("app_name", true);
            pluginGeneratedSerialDescriptor.k(Constants.EXTRA_KEY_APP_VERSION, true);
            pluginGeneratedSerialDescriptor.k("app_build", true);
            pluginGeneratedSerialDescriptor.k("permissions", true);
            f30250b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0081, code lost:
            r7 = 2;
            r15 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00ac, code lost:
            r3 = 6;
            r15 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
            r15 = r15;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x004a, code lost:
            r15 = r15;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.sumsub.sentry.a deserialize(kotlinx.serialization.encoding.c r18) {
            /*
                r17 = this;
                kotlinx.serialization.descriptors.f r0 = r17.getDescriptor()
                r1 = r18
                kotlinx.serialization.encoding.a r1 = r1.b(r0)
                boolean r2 = r1.k()
                r3 = 6
                r4 = 5
                r5 = 3
                r6 = 4
                r7 = 2
                r8 = 0
                r9 = 1
                r10 = 0
                if (r2 == 0) goto L_0x0041
                kotlinx.serialization.internal.v1 r2 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r8 = r1.j(r0, r8, r2, r10)
                java.lang.Object r9 = r1.j(r0, r9, r2, r10)
                java.lang.Object r7 = r1.j(r0, r7, r2, r10)
                java.lang.Object r5 = r1.j(r0, r5, r2, r10)
                java.lang.Object r6 = r1.j(r0, r6, r2, r10)
                java.lang.Object r4 = r1.j(r0, r4, r2, r10)
                kotlinx.serialization.internal.r0 r11 = new kotlinx.serialization.internal.r0
                r11.<init>(r2, r2)
                java.lang.Object r2 = r1.j(r0, r3, r11, r10)
                r3 = 127(0x7f, float:1.78E-43)
                r15 = r4
                r4 = r3
                goto L_0x00b6
            L_0x0041:
                r2 = r8
                r16 = r9
                r8 = r10
                r11 = r8
                r12 = r11
                r13 = r12
                r14 = r13
                r15 = r14
            L_0x004a:
                if (r16 == 0) goto L_0x00af
                int r9 = r1.w(r0)
                switch(r9) {
                    case -1: goto L_0x00a9;
                    case 0: goto L_0x009c;
                    case 1: goto L_0x008e;
                    case 2: goto L_0x0083;
                    case 3: goto L_0x0079;
                    case 4: goto L_0x0070;
                    case 5: goto L_0x0067;
                    case 6: goto L_0x0059;
                    default: goto L_0x0053;
                }
            L_0x0053:
                kotlinx.serialization.UnknownFieldException r0 = new kotlinx.serialization.UnknownFieldException
                r0.<init>((int) r9)
                throw r0
            L_0x0059:
                kotlinx.serialization.internal.r0 r9 = new kotlinx.serialization.internal.r0
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                r9.<init>(r7, r7)
                java.lang.Object r8 = r1.j(r0, r3, r9, r8)
                r2 = r2 | 64
                goto L_0x0081
            L_0x0067:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r15 = r1.j(r0, r4, r7, r15)
                r2 = r2 | 32
                goto L_0x0081
            L_0x0070:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r14 = r1.j(r0, r6, r7, r14)
                r2 = r2 | 16
                goto L_0x0081
            L_0x0079:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                java.lang.Object r13 = r1.j(r0, r5, r7, r13)
                r2 = r2 | 8
            L_0x0081:
                r7 = 2
                goto L_0x00ad
            L_0x0083:
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                r9 = 2
                java.lang.Object r12 = r1.j(r0, r9, r7, r12)
                r2 = r2 | 4
                r7 = r9
                goto L_0x00ad
            L_0x008e:
                r9 = r7
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                r3 = 1
                java.lang.Object r11 = r1.j(r0, r3, r7, r11)
                r2 = r2 | 2
                r7 = r9
                r9 = r3
                r3 = 6
                goto L_0x004a
            L_0x009c:
                r9 = r7
                r3 = 1
                kotlinx.serialization.internal.v1 r7 = kotlinx.serialization.internal.v1.f57779a
                r3 = 0
                java.lang.Object r10 = r1.j(r0, r3, r7, r10)
                r2 = r2 | 1
                r7 = r9
                goto L_0x00ac
            L_0x00a9:
                r3 = 0
                r16 = r3
            L_0x00ac:
                r3 = 6
            L_0x00ad:
                r9 = 1
                goto L_0x004a
            L_0x00af:
                r4 = r2
                r2 = r8
                r8 = r10
                r9 = r11
                r7 = r12
                r5 = r13
                r6 = r14
            L_0x00b6:
                r1.c(r0)
                com.sumsub.sentry.a r0 = new com.sumsub.sentry.a
                r1 = r8
                java.lang.String r1 = (java.lang.String) r1
                r8 = r9
                java.lang.String r8 = (java.lang.String) r8
                java.lang.String r7 = (java.lang.String) r7
                r9 = r5
                java.lang.String r9 = (java.lang.String) r9
                r10 = r6
                java.lang.String r10 = (java.lang.String) r10
                r11 = r15
                java.lang.String r11 = (java.lang.String) r11
                java.util.Map r2 = (java.util.Map) r2
                r12 = 0
                r3 = r0
                r5 = r1
                r6 = r8
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r2
                r3.<init>((int) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (java.util.Map) r11, (kotlinx.serialization.internal.q1) r12)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.a.C0268a.deserialize(kotlinx.serialization.encoding.c):com.sumsub.sentry.a");
        }

        public kotlinx.serialization.b<?>[] childSerializers() {
            v1 v1Var = v1.f57779a;
            return new kotlinx.serialization.b[]{h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(v1Var), h10.a.u(new r0(v1Var, v1Var))};
        }

        public kotlinx.serialization.descriptors.f getDescriptor() {
            return f30250b;
        }

        public kotlinx.serialization.b<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }

        /* renamed from: a */
        public void serialize(d dVar, a aVar) {
            kotlinx.serialization.descriptors.f descriptor = getDescriptor();
            kotlinx.serialization.encoding.b b11 = dVar.b(descriptor);
            a.a(aVar, b11, descriptor);
            b11.c(descriptor);
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final kotlinx.serialization.b<a> serializer() {
            return C0268a.f30249a;
        }

        public b() {
        }
    }

    public a() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (Map) null, 127, (r) null);
    }

    public static final void a(a aVar, kotlinx.serialization.encoding.b bVar, kotlinx.serialization.descriptors.f fVar) {
        boolean z11 = false;
        if (bVar.q(fVar, 0) || aVar.f30242a != null) {
            bVar.y(fVar, 0, v1.f57779a, aVar.f30242a);
        }
        if (bVar.q(fVar, 1) || aVar.f30243b != null) {
            bVar.y(fVar, 1, v1.f57779a, aVar.f30243b);
        }
        if (bVar.q(fVar, 2) || aVar.f30244c != null) {
            bVar.y(fVar, 2, v1.f57779a, aVar.f30244c);
        }
        if (bVar.q(fVar, 3) || aVar.f30245d != null) {
            bVar.y(fVar, 3, v1.f57779a, aVar.f30245d);
        }
        if (bVar.q(fVar, 4) || aVar.f30246e != null) {
            bVar.y(fVar, 4, v1.f57779a, aVar.f30246e);
        }
        if (bVar.q(fVar, 5) || aVar.f30247f != null) {
            bVar.y(fVar, 5, v1.f57779a, aVar.f30247f);
        }
        if (bVar.q(fVar, 6) || aVar.f30248g != null) {
            z11 = true;
        }
        if (z11) {
            v1 v1Var = v1.f57779a;
            bVar.y(fVar, 6, new r0(v1Var, v1Var), aVar.f30248g);
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

    public static /* synthetic */ void j() {
    }

    public static /* synthetic */ void l() {
    }

    public static /* synthetic */ void n() {
    }

    public final void b(String str) {
        this.f30242a = str;
    }

    public final String c() {
        return this.f30242a;
    }

    public final void d(String str) {
        this.f30246e = str;
    }

    public final String e() {
        return this.f30245d;
    }

    public final String g() {
        return this.f30246e;
    }

    public final String i() {
        return this.f30244c;
    }

    public final String k() {
        return this.f30243b;
    }

    public final Map<String, String> m() {
        return this.f30248g;
    }

    public /* synthetic */ a(int i11, String str, String str2, String str3, String str4, String str5, String str6, Map map, q1 q1Var) {
        if ((i11 & 0) != 0) {
            h1.a(i11, 0, C0268a.f30249a.getDescriptor());
        }
        if ((i11 & 1) == 0) {
            this.f30242a = null;
        } else {
            this.f30242a = str;
        }
        if ((i11 & 2) == 0) {
            this.f30243b = null;
        } else {
            this.f30243b = str2;
        }
        if ((i11 & 4) == 0) {
            this.f30244c = null;
        } else {
            this.f30244c = str3;
        }
        if ((i11 & 8) == 0) {
            this.f30245d = null;
        } else {
            this.f30245d = str4;
        }
        if ((i11 & 16) == 0) {
            this.f30246e = null;
        } else {
            this.f30246e = str5;
        }
        if ((i11 & 32) == 0) {
            this.f30247f = null;
        } else {
            this.f30247f = str6;
        }
        if ((i11 & 64) == 0) {
            this.f30248g = null;
        } else {
            this.f30248g = map;
        }
    }

    public final String a() {
        return this.f30247f;
    }

    public final void c(String str) {
        this.f30245d = str;
    }

    public a(String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.f30242a = str;
        this.f30243b = str2;
        this.f30244c = str3;
        this.f30245d = str4;
        this.f30246e = str5;
        this.f30247f = str6;
        this.f30248g = map;
    }

    public final void a(String str) {
        this.f30247f = str;
    }

    public final void a(Map<String, String> map) {
        this.f30248g = map;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.util.Map r13, int r14, kotlin.jvm.internal.r r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.a.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, int, kotlin.jvm.internal.r):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(com.sumsub.sentry.a r9) {
        /*
            r8 = this;
            java.lang.String r6 = r9.f30247f
            java.lang.String r1 = r9.f30242a
            java.lang.String r4 = r9.f30245d
            java.lang.String r5 = r9.f30246e
            java.lang.String r3 = r9.f30244c
            java.lang.String r2 = r9.f30243b
            java.util.Map<java.lang.String, java.lang.String> r9 = r9.f30248g
            if (r9 == 0) goto L_0x0017
            java.util.concurrent.ConcurrentHashMap r0 = new java.util.concurrent.ConcurrentHashMap
            r0.<init>(r9)
            r7 = r0
            goto L_0x0019
        L_0x0017:
            r9 = 0
            r7 = r9
        L_0x0019:
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.a.<init>(com.sumsub.sentry.a):void");
    }
}
