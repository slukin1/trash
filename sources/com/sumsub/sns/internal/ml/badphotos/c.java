package com.sumsub.sns.internal.ml.badphotos;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.sumsub.sns.internal.log.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {

    /* renamed from: h  reason: collision with root package name */
    public static final a f34958h = new a((r) null);

    /* renamed from: i  reason: collision with root package name */
    public static final String f34959i = "BadPhotosDetectorFeature";

    /* renamed from: a  reason: collision with root package name */
    public final String f34960a;

    /* renamed from: b  reason: collision with root package name */
    public final float f34961b;

    /* renamed from: c  reason: collision with root package name */
    public final float f34962c;

    /* renamed from: d  reason: collision with root package name */
    public final long f34963d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f34964e;

    /* renamed from: f  reason: collision with root package name */
    public final List<String> f34965f;

    /* renamed from: g  reason: collision with root package name */
    public final int f34966g;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final c a() {
            String f11 = com.sumsub.sns.internal.ff.a.f34215a.B().f();
            if (f11 == null) {
                return new c((String) null, 0.0f, 0.0f, 0, false, (List) null, 0, 127, (r) null);
            }
            try {
                JSONObject jSONObject = new JSONObject(f11).getJSONObject("android");
                JSONArray jSONArray = jSONObject.getJSONArray("allowed_steps");
                ArrayList arrayList = new ArrayList();
                int length = jSONArray.length();
                for (int i11 = 0; i11 < length; i11++) {
                    arrayList.add(jSONArray.getString(i11));
                }
                c cVar = new c(jSONObject.getString(DeviceRequestsHelper.DEVICE_INFO_MODEL), Float.parseFloat(jSONObject.getString("high_quality_threshold")), Float.parseFloat(jSONObject.getString("low_quality_threshold")), jSONObject.getLong("execution_timeout_ms"), jSONObject.getBoolean("allow_cache"), arrayList, jSONObject.getInt("max_blocked_attempts"));
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                com.sumsub.log.logger.a.a(aVar, c.f34959i, "Parsed FF: " + cVar, (Throwable) null, 4, (Object) null);
                return cVar;
            } catch (Throwable th2) {
                b.b(com.sumsub.sns.internal.log.a.f34862a, c.f34959i, "Failed to parse badPhotoDetectorConfig FF", th2);
                return new c((String) null, 0.0f, 0.0f, 0, false, (List) null, 0, 127, (r) null);
            }
        }

        public a() {
        }
    }

    public c() {
        this((String) null, 0.0f, 0.0f, 0, false, (List) null, 0, 127, (r) null);
    }

    public final String a() {
        return this.f34960a;
    }

    public final float b() {
        return this.f34961b;
    }

    public final float c() {
        return this.f34962c;
    }

    public final long d() {
        return this.f34963d;
    }

    public final boolean e() {
        return this.f34964e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return x.b(this.f34960a, cVar.f34960a) && x.b(Float.valueOf(this.f34961b), Float.valueOf(cVar.f34961b)) && x.b(Float.valueOf(this.f34962c), Float.valueOf(cVar.f34962c)) && this.f34963d == cVar.f34963d && this.f34964e == cVar.f34964e && x.b(this.f34965f, cVar.f34965f) && this.f34966g == cVar.f34966g;
    }

    public final List<String> f() {
        return this.f34965f;
    }

    public final int g() {
        return this.f34966g;
    }

    public final boolean h() {
        return this.f34964e;
    }

    public int hashCode() {
        int hashCode = ((((((this.f34960a.hashCode() * 31) + Float.floatToIntBits(this.f34961b)) * 31) + Float.floatToIntBits(this.f34962c)) * 31) + com.fluttercandies.photo_manager.core.entity.a.a(this.f34963d)) * 31;
        boolean z11 = this.f34964e;
        if (z11) {
            z11 = true;
        }
        return ((((hashCode + (z11 ? 1 : 0)) * 31) + this.f34965f.hashCode()) * 31) + this.f34966g;
    }

    public final List<String> i() {
        return this.f34965f;
    }

    public final long j() {
        return this.f34963d;
    }

    public final float k() {
        return this.f34961b;
    }

    public final float l() {
        return this.f34962c;
    }

    public final int m() {
        return this.f34966g;
    }

    public final String n() {
        return this.f34960a;
    }

    public String toString() {
        return "BadPhotosMobileConfig(model=" + this.f34960a + ", highQualityThreshold=" + this.f34961b + ", lowQualityThreshold=" + this.f34962c + ", executionTimeoutMs=" + this.f34963d + ", allowCache=" + this.f34964e + ", allowedSteps=" + this.f34965f + ", maxBlockedAttemptsCount=" + this.f34966g + ')';
    }

    public c(String str, float f11, float f12, long j11, boolean z11, List<String> list, int i11) {
        this.f34960a = str;
        this.f34961b = f11;
        this.f34962c = f12;
        this.f34963d = j11;
        this.f34964e = z11;
        this.f34965f = list;
        this.f34966g = i11;
    }

    public final c a(String str, float f11, float f12, long j11, boolean z11, List<String> list, int i11) {
        return new c(str, f11, f12, j11, z11, list, i11);
    }

    public static /* synthetic */ c a(c cVar, String str, float f11, float f12, long j11, boolean z11, List list, int i11, int i12, Object obj) {
        c cVar2 = cVar;
        return cVar.a((i12 & 1) != 0 ? cVar2.f34960a : str, (i12 & 2) != 0 ? cVar2.f34961b : f11, (i12 & 4) != 0 ? cVar2.f34962c : f12, (i12 & 8) != 0 ? cVar2.f34963d : j11, (i12 & 16) != 0 ? cVar2.f34964e : z11, (i12 & 32) != 0 ? cVar2.f34965f : list, (i12 & 64) != 0 ? cVar2.f34966g : i11);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ c(java.lang.String r12, float r13, float r14, long r15, boolean r17, java.util.List r18, int r19, int r20, kotlin.jvm.internal.r r21) {
        /*
            r11 = this;
            r0 = r20 & 1
            if (r0 == 0) goto L_0x0007
            java.lang.String r0 = "unsatisfactory_photos_v2.tflite"
            goto L_0x0008
        L_0x0007:
            r0 = r12
        L_0x0008:
            r1 = r20 & 2
            if (r1 == 0) goto L_0x000f
            r1 = 1061158912(0x3f400000, float:0.75)
            goto L_0x0010
        L_0x000f:
            r1 = r13
        L_0x0010:
            r2 = r20 & 4
            if (r2 == 0) goto L_0x0018
            r2 = 1045220557(0x3e4ccccd, float:0.2)
            goto L_0x0019
        L_0x0018:
            r2 = r14
        L_0x0019:
            r3 = r20 & 8
            if (r3 == 0) goto L_0x0020
            r3 = 3000(0xbb8, double:1.482E-320)
            goto L_0x0021
        L_0x0020:
            r3 = r15
        L_0x0021:
            r5 = r20 & 16
            r6 = 1
            if (r5 == 0) goto L_0x0028
            r5 = r6
            goto L_0x002a
        L_0x0028:
            r5 = r17
        L_0x002a:
            r7 = r20 & 32
            if (r7 == 0) goto L_0x003f
            java.lang.String r7 = "IDENTITY"
            java.lang.String r8 = "IDENTITY2"
            java.lang.String r9 = "IDENTITY3"
            java.lang.String r10 = "IDENTITY4"
            java.lang.String[] r7 = new java.lang.String[]{r7, r8, r9, r10}
            java.util.List r7 = kotlin.collections.CollectionsKt__CollectionsKt.n(r7)
            goto L_0x0041
        L_0x003f:
            r7 = r18
        L_0x0041:
            r8 = r20 & 64
            if (r8 == 0) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r6 = r19
        L_0x0048:
            r12 = r11
            r13 = r0
            r14 = r1
            r15 = r2
            r16 = r3
            r18 = r5
            r19 = r7
            r20 = r6
            r12.<init>(r13, r14, r15, r16, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ml.badphotos.c.<init>(java.lang.String, float, float, long, boolean, java.util.List, int, int, kotlin.jvm.internal.r):void");
    }
}
