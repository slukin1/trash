package com.sumsub.sns.internal.ml.autocapture;

import android.util.Size;
import io.flutter.plugins.firebase.crashlytics.Constants;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

public final class a {

    /* renamed from: m  reason: collision with root package name */
    public static final b f34920m = new b((r) null);

    /* renamed from: n  reason: collision with root package name */
    public static final int f34921n = 1920;

    /* renamed from: o  reason: collision with root package name */
    public static final int f34922o = 1080;

    /* renamed from: p  reason: collision with root package name */
    public static final long f34923p = 1500;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f34924a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f34925b;

    /* renamed from: c  reason: collision with root package name */
    public final long f34926c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f34927d;

    /* renamed from: e  reason: collision with root package name */
    public final long f34928e;

    /* renamed from: f  reason: collision with root package name */
    public final float f34929f;

    /* renamed from: g  reason: collision with root package name */
    public final float f34930g;

    /* renamed from: h  reason: collision with root package name */
    public final float f34931h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f34932i;

    /* renamed from: j  reason: collision with root package name */
    public final C0405a f34933j;

    /* renamed from: k  reason: collision with root package name */
    public final Size f34934k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f34935l;

    /* renamed from: com.sumsub.sns.internal.ml.autocapture.a$a  reason: collision with other inner class name */
    public static final class C0405a extends c {

        /* renamed from: d  reason: collision with root package name */
        public final String f34936d;

        /* renamed from: e  reason: collision with root package name */
        public final float f34937e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f34938f;

        /* renamed from: g  reason: collision with root package name */
        public final Size f34939g;

        /* renamed from: h  reason: collision with root package name */
        public final int f34940h;

        public C0405a() {
            this((String) null, 0.0f, false, (Size) null, 0, 31, (r) null);
        }

        public final C0405a a(String str, float f11, boolean z11, Size size, int i11) {
            return new C0405a(str, f11, z11, size, i11);
        }

        public String b() {
            return this.f34936d;
        }

        public float c() {
            return this.f34937e;
        }

        public final String d() {
            return b();
        }

        public final float e() {
            return c();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0405a)) {
                return false;
            }
            C0405a aVar = (C0405a) obj;
            return x.b(b(), aVar.b()) && x.b(Float.valueOf(c()), Float.valueOf(aVar.c())) && a() == aVar.a() && x.b(this.f34939g, aVar.f34939g) && this.f34940h == aVar.f34940h;
        }

        public final boolean f() {
            return a();
        }

        public final Size g() {
            return this.f34939g;
        }

        public final int h() {
            return this.f34940h;
        }

        public int hashCode() {
            int hashCode = ((b().hashCode() * 31) + Float.floatToIntBits(c())) * 31;
            boolean a11 = a();
            if (a11) {
                a11 = true;
            }
            return ((((hashCode + (a11 ? 1 : 0)) * 31) + this.f34939g.hashCode()) * 31) + this.f34940h;
        }

        public final Size i() {
            return this.f34939g;
        }

        public final int j() {
            return this.f34940h;
        }

        public String toString() {
            return "AutoCaptureModel(name=" + b() + ", threshold=" + c() + ", allowCache=" + a() + ", inputSize=" + this.f34939g + ", outputSize=" + this.f34940h + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ C0405a(java.lang.String r4, float r5, boolean r6, android.util.Size r7, int r8, int r9, kotlin.jvm.internal.r r10) {
            /*
                r3 = this;
                r10 = r9 & 1
                if (r10 == 0) goto L_0x0006
                java.lang.String r4 = "model.tflite"
            L_0x0006:
                r10 = r9 & 2
                if (r10 == 0) goto L_0x000d
                r5 = 1050253722(0x3e99999a, float:0.3)
            L_0x000d:
                r10 = r5
                r5 = r9 & 4
                if (r5 == 0) goto L_0x0013
                r6 = 1
            L_0x0013:
                r0 = r6
                r5 = r9 & 8
                r6 = 0
                if (r5 == 0) goto L_0x001e
                android.util.Size r7 = new android.util.Size
                r7.<init>(r6, r6)
            L_0x001e:
                r1 = r7
                r5 = r9 & 16
                if (r5 == 0) goto L_0x0025
                r2 = r6
                goto L_0x0026
            L_0x0025:
                r2 = r8
            L_0x0026:
                r5 = r3
                r6 = r4
                r7 = r10
                r8 = r0
                r9 = r1
                r10 = r2
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ml.autocapture.a.C0405a.<init>(java.lang.String, float, boolean, android.util.Size, int, int, kotlin.jvm.internal.r):void");
        }

        public static /* synthetic */ C0405a a(C0405a aVar, String str, float f11, boolean z11, Size size, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                str = aVar.b();
            }
            if ((i12 & 2) != 0) {
                f11 = aVar.c();
            }
            float f12 = f11;
            if ((i12 & 4) != 0) {
                z11 = aVar.a();
            }
            boolean z12 = z11;
            if ((i12 & 8) != 0) {
                size = aVar.f34939g;
            }
            Size size2 = size;
            if ((i12 & 16) != 0) {
                i11 = aVar.f34940h;
            }
            return aVar.a(str, f12, z12, size2, i11);
        }

        public boolean a() {
            return this.f34938f;
        }

        public C0405a(String str, float f11, boolean z11, Size size, int i11) {
            super(str, f11, z11);
            this.f34936d = str;
            this.f34937e = f11;
            this.f34938f = z11;
            this.f34939g = size;
            this.f34940h = i11;
        }
    }

    public static final class b {
        public /* synthetic */ b(r rVar) {
            this();
        }

        public final a a() {
            Size size;
            Size size2;
            String f11 = com.sumsub.sns.internal.ff.a.f34215a.g().f();
            if (f11 == null) {
                return new a(false, false, 0, false, 0, 0.0f, 0.0f, 0.0f, false, (C0405a) null, (Size) null, false, 4095, (r) null);
            }
            try {
                JSONObject jSONObject = new JSONObject(f11).getJSONObject("android");
                JSONObject jSONObject2 = jSONObject.getJSONObject("autoCaptureModel");
                JSONObject optJSONObject = jSONObject2.optJSONObject("inputSize");
                if (optJSONObject != null) {
                    size = new Size(optJSONObject.optInt("width", b.f34945b), optJSONObject.optInt("height", b.f34944a));
                } else {
                    size = new Size(b.f34945b, b.f34944a);
                }
                C0405a aVar = new C0405a(jSONObject2.getString("name"), (float) jSONObject2.getDouble("threshold"), jSONObject2.getBoolean("allowCache"), size, jSONObject2.getInt("outputSize"));
                JSONObject optJSONObject2 = jSONObject.optJSONObject("frameSize");
                if (optJSONObject2 != null) {
                    size2 = new Size(optJSONObject2.getInt("height"), optJSONObject2.getInt("width"));
                } else {
                    size2 = new Size(1920, 1080);
                }
                return new a(jSONObject.optBoolean(Constants.ENABLED, true), jSONObject.optBoolean("showBounds", false), jSONObject.optLong("waitForBetterPhotoMs", a.f34923p), false, 4000, (float) jSONObject.getDouble("requiredFrameFillRatio"), (float) jSONObject.getDouble("requiredLargestSizeOffsetRatio"), (float) jSONObject.getDouble("frameAspectRatio"), false, aVar, size2, jSONObject.optBoolean("imageCaptureUseCaseEnabled", false));
            } catch (Throwable th2) {
                com.sumsub.sns.internal.log.b.b(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(a.f34920m), "Failed to parse documentAutocaptureConfig FF", th2);
                return new a(false, false, 0, false, 0, 0.0f, 0.0f, 0.0f, false, (C0405a) null, (Size) null, false, 4095, (r) null);
            }
        }

        public b() {
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final String f34941a;

        /* renamed from: b  reason: collision with root package name */
        public final float f34942b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f34943c;

        public c() {
            this((String) null, 0.0f, false, 7, (r) null);
        }

        public boolean a() {
            return this.f34943c;
        }

        public String b() {
            return this.f34941a;
        }

        public float c() {
            return this.f34942b;
        }

        public c(String str, float f11, boolean z11) {
            this.f34941a = str;
            this.f34942b = f11;
            this.f34943c = z11;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ c(String str, float f11, boolean z11, int i11, r rVar) {
            this((i11 & 1) != 0 ? "model.tflite" : str, (i11 & 2) != 0 ? 0.3f : f11, (i11 & 4) != 0 ? true : z11);
        }
    }

    public a() {
        this(false, false, 0, false, 0, 0.0f, 0.0f, 0.0f, false, (C0405a) null, (Size) null, false, 4095, (r) null);
    }

    public final boolean a() {
        return this.f34924a;
    }

    public final C0405a b() {
        return this.f34933j;
    }

    public final Size c() {
        return this.f34934k;
    }

    public final boolean d() {
        return this.f34935l;
    }

    public final boolean e() {
        return this.f34925b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f34924a == aVar.f34924a && this.f34925b == aVar.f34925b && this.f34926c == aVar.f34926c && this.f34927d == aVar.f34927d && this.f34928e == aVar.f34928e && x.b(Float.valueOf(this.f34929f), Float.valueOf(aVar.f34929f)) && x.b(Float.valueOf(this.f34930g), Float.valueOf(aVar.f34930g)) && x.b(Float.valueOf(this.f34931h), Float.valueOf(aVar.f34931h)) && this.f34932i == aVar.f34932i && x.b(this.f34933j, aVar.f34933j) && x.b(this.f34934k, aVar.f34934k) && this.f34935l == aVar.f34935l;
    }

    public final long f() {
        return this.f34926c;
    }

    public final boolean g() {
        return this.f34927d;
    }

    public final long h() {
        return this.f34928e;
    }

    public int hashCode() {
        boolean z11 = this.f34924a;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        boolean z13 = this.f34925b;
        if (z13) {
            z13 = true;
        }
        int a11 = (((i11 + (z13 ? 1 : 0)) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f34926c)) * 31;
        boolean z14 = this.f34927d;
        if (z14) {
            z14 = true;
        }
        int a12 = (((((((((a11 + (z14 ? 1 : 0)) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f34928e)) * 31) + Float.floatToIntBits(this.f34929f)) * 31) + Float.floatToIntBits(this.f34930g)) * 31) + Float.floatToIntBits(this.f34931h)) * 31;
        boolean z15 = this.f34932i;
        if (z15) {
            z15 = true;
        }
        int hashCode = (((a12 + (z15 ? 1 : 0)) * 31) + this.f34933j.hashCode()) * 31;
        Size size = this.f34934k;
        int hashCode2 = (hashCode + (size == null ? 0 : size.hashCode())) * 31;
        boolean z16 = this.f34935l;
        if (!z16) {
            z12 = z16;
        }
        return hashCode2 + (z12 ? 1 : 0);
    }

    public final float i() {
        return this.f34929f;
    }

    public final float j() {
        return this.f34930g;
    }

    public final float k() {
        return this.f34931h;
    }

    public final boolean l() {
        return this.f34932i;
    }

    public final C0405a m() {
        return this.f34933j;
    }

    public final boolean n() {
        return this.f34932i;
    }

    public final boolean o() {
        return this.f34927d;
    }

    public final boolean p() {
        return this.f34924a;
    }

    public final float q() {
        return this.f34931h;
    }

    public final Size r() {
        return this.f34934k;
    }

    public final boolean s() {
        return this.f34935l;
    }

    public final long t() {
        return this.f34928e;
    }

    public String toString() {
        return "DocumentAutocaptureMobileConfig(enabled=" + this.f34924a + ", showBounds=" + this.f34925b + ", waitForBetterPhotoMs=" + this.f34926c + ", enableInsideFrameAutoShot=" + this.f34927d + ", insideFrameAutoShotTimeoutMs=" + this.f34928e + ", requiredFrameFillRatio=" + this.f34929f + ", requiredLargestSizeOffsetRatio=" + this.f34930g + ", frameAspectRatio=" + this.f34931h + ", enableCropToFrame=" + this.f34932i + ", autoCaptureModel=" + this.f34933j + ", frameSize=" + this.f34934k + ", imageCaptureUseCaseEnabled=" + this.f34935l + ')';
    }

    public final float u() {
        return this.f34929f;
    }

    public final float v() {
        return this.f34930g;
    }

    public final boolean w() {
        return this.f34925b;
    }

    public final long x() {
        return this.f34926c;
    }

    public a(boolean z11, boolean z12, long j11, boolean z13, long j12, float f11, float f12, float f13, boolean z14, C0405a aVar, Size size, boolean z15) {
        this.f34924a = z11;
        this.f34925b = z12;
        this.f34926c = j11;
        this.f34927d = z13;
        this.f34928e = j12;
        this.f34929f = f11;
        this.f34930g = f12;
        this.f34931h = f13;
        this.f34932i = z14;
        this.f34933j = aVar;
        this.f34934k = size;
        this.f34935l = z15;
    }

    public final a a(boolean z11, boolean z12, long j11, boolean z13, long j12, float f11, float f12, float f13, boolean z14, C0405a aVar, Size size, boolean z15) {
        return new a(z11, z12, j11, z13, j12, f11, f12, f13, z14, aVar, size, z15);
    }

    public static /* synthetic */ a a(a aVar, boolean z11, boolean z12, long j11, boolean z13, long j12, float f11, float f12, float f13, boolean z14, C0405a aVar2, Size size, boolean z15, int i11, Object obj) {
        a aVar3 = aVar;
        int i12 = i11;
        return aVar.a((i12 & 1) != 0 ? aVar3.f34924a : z11, (i12 & 2) != 0 ? aVar3.f34925b : z12, (i12 & 4) != 0 ? aVar3.f34926c : j11, (i12 & 8) != 0 ? aVar3.f34927d : z13, (i12 & 16) != 0 ? aVar3.f34928e : j12, (i12 & 32) != 0 ? aVar3.f34929f : f11, (i12 & 64) != 0 ? aVar3.f34930g : f12, (i12 & 128) != 0 ? aVar3.f34931h : f13, (i12 & 256) != 0 ? aVar3.f34932i : z14, (i12 & 512) != 0 ? aVar3.f34933j : aVar2, (i12 & 1024) != 0 ? aVar3.f34934k : size, (i12 & 2048) != 0 ? aVar3.f34935l : z15);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ a(boolean r22, boolean r23, long r24, boolean r26, long r27, float r29, float r30, float r31, boolean r32, com.sumsub.sns.internal.ml.autocapture.a.C0405a r33, android.util.Size r34, boolean r35, int r36, kotlin.jvm.internal.r r37) {
        /*
            r21 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 1
            goto L_0x000a
        L_0x0008:
            r1 = r22
        L_0x000a:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0011
            r2 = r3
            goto L_0x0013
        L_0x0011:
            r2 = r23
        L_0x0013:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x001a
            r4 = 1500(0x5dc, double:7.41E-321)
            goto L_0x001c
        L_0x001a:
            r4 = r24
        L_0x001c:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0022
            r6 = r3
            goto L_0x0024
        L_0x0022:
            r6 = r26
        L_0x0024:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x002b
            r7 = 0
            goto L_0x002d
        L_0x002b:
            r7 = r27
        L_0x002d:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x0033
            r9 = 0
            goto L_0x0035
        L_0x0033:
            r9 = r29
        L_0x0035:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x003d
            r10 = 1036831949(0x3dcccccd, float:0.1)
            goto L_0x003f
        L_0x003d:
            r10 = r30
        L_0x003f:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0046
            r11 = 1071644672(0x3fe00000, float:1.75)
            goto L_0x0048
        L_0x0046:
            r11 = r31
        L_0x0048:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x004e
            r12 = r3
            goto L_0x0050
        L_0x004e:
            r12 = r32
        L_0x0050:
            r13 = r0 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x0076
            com.sumsub.sns.internal.ml.autocapture.a$a r13 = new com.sumsub.sns.internal.ml.autocapture.a$a
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 30
            r19 = 0
            java.lang.String r20 = "autocapture_v1.tflite"
            r22 = r13
            r23 = r20
            r24 = r14
            r25 = r15
            r26 = r16
            r27 = r17
            r28 = r18
            r29 = r19
            r22.<init>(r23, r24, r25, r26, r27, r28, r29)
            goto L_0x0078
        L_0x0076:
            r13 = r33
        L_0x0078:
            r14 = r0 & 1024(0x400, float:1.435E-42)
            if (r14 == 0) goto L_0x007e
            r14 = 0
            goto L_0x0080
        L_0x007e:
            r14 = r34
        L_0x0080:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0085
            goto L_0x0087
        L_0x0085:
            r3 = r35
        L_0x0087:
            r22 = r21
            r23 = r1
            r24 = r2
            r25 = r4
            r27 = r6
            r28 = r7
            r30 = r9
            r31 = r10
            r32 = r11
            r33 = r12
            r34 = r13
            r35 = r14
            r36 = r3
            r22.<init>(r23, r24, r25, r27, r28, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ml.autocapture.a.<init>(boolean, boolean, long, boolean, long, float, float, float, boolean, com.sumsub.sns.internal.ml.autocapture.a$a, android.util.Size, boolean, int, kotlin.jvm.internal.r):void");
    }
}
