package com.jumio.core.models;

import com.fluttercandies.photo_manager.core.entity.a;
import com.google.common.math.DoubleMath;
import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.core.model.StaticModel;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import jumio.core.p1;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

@PersistWith("LivenessSettingsModel")
public final class LivenessSettingsModel implements StaticModel {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final long f39320a;

    /* renamed from: b  reason: collision with root package name */
    public final long f39321b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39322c;

    /* renamed from: d  reason: collision with root package name */
    public final long f39323d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f39324e;

    /* renamed from: f  reason: collision with root package name */
    public final int f39325f;

    /* renamed from: g  reason: collision with root package name */
    public final double f39326g;

    /* renamed from: h  reason: collision with root package name */
    public final double f39327h;

    /* renamed from: i  reason: collision with root package name */
    public final double f39328i;

    /* renamed from: j  reason: collision with root package name */
    public final int f39329j;

    /* renamed from: k  reason: collision with root package name */
    public final int f39330k;

    /* renamed from: l  reason: collision with root package name */
    public final int f39331l;

    /* renamed from: m  reason: collision with root package name */
    public final int f39332m;

    /* renamed from: n  reason: collision with root package name */
    public final long f39333n;

    /* renamed from: o  reason: collision with root package name */
    public final long f39334o;

    /* renamed from: p  reason: collision with root package name */
    public final int f39335p;

    /* renamed from: q  reason: collision with root package name */
    public final int f39336q;

    /* renamed from: r  reason: collision with root package name */
    public final double f39337r;

    /* renamed from: s  reason: collision with root package name */
    public final long f39338s;

    /* renamed from: t  reason: collision with root package name */
    public final double f39339t;

    /* renamed from: u  reason: collision with root package name */
    public final int f39340u;

    /* renamed from: v  reason: collision with root package name */
    public final boolean f39341v;

    /* renamed from: w  reason: collision with root package name */
    public final int f39342w;

    /* renamed from: x  reason: collision with root package name */
    public final int f39343x;

    /* renamed from: y  reason: collision with root package name */
    public final int f39344y;

    /* renamed from: z  reason: collision with root package name */
    public final int f39345z;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final LivenessSettingsModel fromJson(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            return new LivenessSettingsModel(jSONObject2.optLong("frameRateThreshold", 15), jSONObject2.optLong("samplingTimeInMs", 1000), jSONObject2.optInt("violationLimit", 3), jSONObject2.optLong("modelInitTimeoutInMs", 5000), jSONObject2.optBoolean("manualCaptureAllowed", true), jSONObject2.optInt("retries", 3), jSONObject2.optDouble("minNearFarRatio", 1.1d), jSONObject2.optDouble("tooNearThreshold", 0.95d), jSONObject2.optDouble("tooFarThreshold", 0.25d), jSONObject2.optInt("nearImages", 2), jSONObject2.optInt("farImages", 2), jSONObject2.optInt("initialImages", 1), jSONObject2.optInt("transitionImages", 2), jSONObject2.optLong("minTimePerDistanceInMs", 1000), jSONObject2.optLong("maxConsecutiveImageTimespanInMs", 100), jSONObject2.optInt("imageResolutionWidth", 720), jSONObject2.optInt("imageResolutionHeight", 1080), jSONObject2.optDouble("imageCompression", 0.8d), jSONObject2.optLong("minPhysicalMemory", 1073741824), jSONObject2.optDouble("maxFaceCenterDifference", 0.2d), jSONObject2.optInt("fallbackTimeInS", 30), jSONObject2.optBoolean("userFallbackAllowed", true), jSONObject2.optInt("minimumPseudoPitch", 105), jSONObject2.optInt("maximumPseudoPitch", DoubleMath.MAX_FACTORIAL), jSONObject2.optInt("minimumPseudoYaw", 65), jSONObject2.optInt("maximumPseudoYaw", 135));
        }
    }

    public LivenessSettingsModel() {
        this(0, 0, 0, 0, false, 0, 0.0d, 0.0d, 0.0d, 0, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0.0d, 0, false, 0, 0, 0, 0, 67108863, (r) null);
    }

    public LivenessSettingsModel(long j11, long j12, int i11, long j13, boolean z11, int i12, double d11, double d12, double d13, int i13, int i14, int i15, int i16, long j14, long j15, int i17, int i18, double d14, long j16, double d15, int i19, boolean z12, int i21, int i22, int i23, int i24) {
        this.f39320a = j11;
        this.f39321b = j12;
        this.f39322c = i11;
        this.f39323d = j13;
        this.f39324e = z11;
        this.f39325f = i12;
        this.f39326g = d11;
        this.f39327h = d12;
        this.f39328i = d13;
        this.f39329j = i13;
        this.f39330k = i14;
        this.f39331l = i15;
        this.f39332m = i16;
        this.f39333n = j14;
        this.f39334o = j15;
        this.f39335p = i17;
        this.f39336q = i18;
        this.f39337r = d14;
        this.f39338s = j16;
        this.f39339t = d15;
        this.f39340u = i19;
        this.f39341v = z12;
        this.f39342w = i21;
        this.f39343x = i22;
        this.f39344y = i23;
        this.f39345z = i24;
        Log.v("LivenessSettingsModel", toString());
    }

    public static /* synthetic */ LivenessSettingsModel copy$default(LivenessSettingsModel livenessSettingsModel, long j11, long j12, int i11, long j13, boolean z11, int i12, double d11, double d12, double d13, int i13, int i14, int i15, int i16, long j14, long j15, int i17, int i18, double d14, long j16, double d15, int i19, boolean z12, int i21, int i22, int i23, int i24, int i25, Object obj) {
        LivenessSettingsModel livenessSettingsModel2 = livenessSettingsModel;
        int i26 = i25;
        long j17 = (i26 & 1) != 0 ? livenessSettingsModel2.f39320a : j11;
        long j18 = (i26 & 2) != 0 ? livenessSettingsModel2.f39321b : j12;
        int i27 = (i26 & 4) != 0 ? livenessSettingsModel2.f39322c : i11;
        long j19 = (i26 & 8) != 0 ? livenessSettingsModel2.f39323d : j13;
        boolean z13 = (i26 & 16) != 0 ? livenessSettingsModel2.f39324e : z11;
        int i28 = (i26 & 32) != 0 ? livenessSettingsModel2.f39325f : i12;
        double d16 = (i26 & 64) != 0 ? livenessSettingsModel2.f39326g : d11;
        double d17 = (i26 & 128) != 0 ? livenessSettingsModel2.f39327h : d12;
        double d18 = (i26 & 256) != 0 ? livenessSettingsModel2.f39328i : d13;
        return livenessSettingsModel.copy(j17, j18, i27, j19, z13, i28, d16, d17, d18, (i26 & 512) != 0 ? livenessSettingsModel2.f39329j : i13, (i26 & 1024) != 0 ? livenessSettingsModel2.f39330k : i14, (i26 & 2048) != 0 ? livenessSettingsModel2.f39331l : i15, (i26 & 4096) != 0 ? livenessSettingsModel2.f39332m : i16, (i26 & 8192) != 0 ? livenessSettingsModel2.f39333n : j14, (i26 & 16384) != 0 ? livenessSettingsModel2.f39334o : j15, (32768 & i26) != 0 ? livenessSettingsModel2.f39335p : i17, (i26 & 65536) != 0 ? livenessSettingsModel2.f39336q : i18, (i26 & 131072) != 0 ? livenessSettingsModel2.f39337r : d14, (i26 & 262144) != 0 ? livenessSettingsModel2.f39338s : j16, (i26 & 524288) != 0 ? livenessSettingsModel2.f39339t : d15, (i26 & 1048576) != 0 ? livenessSettingsModel2.f39340u : i19, (2097152 & i26) != 0 ? livenessSettingsModel2.f39341v : z12, (i26 & 4194304) != 0 ? livenessSettingsModel2.f39342w : i21, (i26 & 8388608) != 0 ? livenessSettingsModel2.f39343x : i22, (i26 & 16777216) != 0 ? livenessSettingsModel2.f39344y : i23, (i26 & TPMediaCodecProfileLevel.HEVCHighTierLevel62) != 0 ? livenessSettingsModel2.f39345z : i24);
    }

    public final long component1() {
        return this.f39320a;
    }

    public final int component10() {
        return this.f39329j;
    }

    public final int component11() {
        return this.f39330k;
    }

    public final int component12() {
        return this.f39331l;
    }

    public final int component13() {
        return this.f39332m;
    }

    public final long component14() {
        return this.f39333n;
    }

    public final long component15() {
        return this.f39334o;
    }

    public final int component16() {
        return this.f39335p;
    }

    public final int component17() {
        return this.f39336q;
    }

    public final double component18() {
        return this.f39337r;
    }

    public final long component19() {
        return this.f39338s;
    }

    public final long component2() {
        return this.f39321b;
    }

    public final double component20() {
        return this.f39339t;
    }

    public final int component21() {
        return this.f39340u;
    }

    public final boolean component22() {
        return this.f39341v;
    }

    public final int component23() {
        return this.f39342w;
    }

    public final int component24() {
        return this.f39343x;
    }

    public final int component25() {
        return this.f39344y;
    }

    public final int component26() {
        return this.f39345z;
    }

    public final int component3() {
        return this.f39322c;
    }

    public final long component4() {
        return this.f39323d;
    }

    public final boolean component5() {
        return this.f39324e;
    }

    public final int component6() {
        return this.f39325f;
    }

    public final double component7() {
        return this.f39326g;
    }

    public final double component8() {
        return this.f39327h;
    }

    public final double component9() {
        return this.f39328i;
    }

    public final LivenessSettingsModel copy(long j11, long j12, int i11, long j13, boolean z11, int i12, double d11, double d12, double d13, int i13, int i14, int i15, int i16, long j14, long j15, int i17, int i18, double d14, long j16, double d15, int i19, boolean z12, int i21, int i22, int i23, int i24) {
        return new LivenessSettingsModel(j11, j12, i11, j13, z11, i12, d11, d12, d13, i13, i14, i15, i16, j14, j15, i17, i18, d14, j16, d15, i19, z12, i21, i22, i23, i24);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivenessSettingsModel)) {
            return false;
        }
        LivenessSettingsModel livenessSettingsModel = (LivenessSettingsModel) obj;
        return this.f39320a == livenessSettingsModel.f39320a && this.f39321b == livenessSettingsModel.f39321b && this.f39322c == livenessSettingsModel.f39322c && this.f39323d == livenessSettingsModel.f39323d && this.f39324e == livenessSettingsModel.f39324e && this.f39325f == livenessSettingsModel.f39325f && Double.compare(this.f39326g, livenessSettingsModel.f39326g) == 0 && Double.compare(this.f39327h, livenessSettingsModel.f39327h) == 0 && Double.compare(this.f39328i, livenessSettingsModel.f39328i) == 0 && this.f39329j == livenessSettingsModel.f39329j && this.f39330k == livenessSettingsModel.f39330k && this.f39331l == livenessSettingsModel.f39331l && this.f39332m == livenessSettingsModel.f39332m && this.f39333n == livenessSettingsModel.f39333n && this.f39334o == livenessSettingsModel.f39334o && this.f39335p == livenessSettingsModel.f39335p && this.f39336q == livenessSettingsModel.f39336q && Double.compare(this.f39337r, livenessSettingsModel.f39337r) == 0 && this.f39338s == livenessSettingsModel.f39338s && Double.compare(this.f39339t, livenessSettingsModel.f39339t) == 0 && this.f39340u == livenessSettingsModel.f39340u && this.f39341v == livenessSettingsModel.f39341v && this.f39342w == livenessSettingsModel.f39342w && this.f39343x == livenessSettingsModel.f39343x && this.f39344y == livenessSettingsModel.f39344y && this.f39345z == livenessSettingsModel.f39345z;
    }

    public final int getFallbackTimeInS() {
        return this.f39340u;
    }

    public final int getFarImages() {
        return this.f39330k;
    }

    public final long getFrameRateThreshold() {
        return this.f39320a;
    }

    public final double getImageCompression() {
        return this.f39337r;
    }

    public final int getImageResolutionHeight() {
        return this.f39336q;
    }

    public final int getImageResolutionWidth() {
        return this.f39335p;
    }

    public final int getInitialImages() {
        return this.f39331l;
    }

    public final boolean getManualCaptureAllowed() {
        return this.f39324e;
    }

    public final long getMaxConsecutiveImageTimespanInMs() {
        return this.f39334o;
    }

    public final double getMaxFaceCenterDifference() {
        return this.f39339t;
    }

    public final int getMaximumPitch() {
        return this.f39343x;
    }

    public final int getMaximumYaw() {
        return this.f39345z;
    }

    public final double getMinNearFarRatio() {
        return this.f39326g;
    }

    public final long getMinPhysicalMemory() {
        return this.f39338s;
    }

    public final long getMinTimePerDistanceInMs() {
        return this.f39333n;
    }

    public final int getMinimumPitch() {
        return this.f39342w;
    }

    public final int getMinimumYaw() {
        return this.f39344y;
    }

    public final long getModelInitTimeoutInMs() {
        return this.f39323d;
    }

    public final int getNearImages() {
        return this.f39329j;
    }

    public final int getRetries() {
        return this.f39325f;
    }

    public final long getSamplingTimeInMs() {
        return this.f39321b;
    }

    public final double getTooFarThreshold() {
        return this.f39328i;
    }

    public final double getTooNearThreshold() {
        return this.f39327h;
    }

    public final int getTransitionImages() {
        return this.f39332m;
    }

    public final boolean getUserFallbackAllowed() {
        return this.f39341v;
    }

    public final int getViolationLimit() {
        return this.f39322c;
    }

    public int hashCode() {
        int a11 = (a.a(this.f39323d) + p1.a(this.f39322c, (a.a(this.f39321b) + (a.a(this.f39320a) * 31)) * 31, 31)) * 31;
        boolean z11 = this.f39324e;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int a12 = p1.a(this.f39325f, (a11 + (z11 ? 1 : 0)) * 31, 31);
        int a13 = Double.doubleToLongBits(this.f39327h);
        int a14 = p1.a(this.f39332m, p1.a(this.f39331l, p1.a(this.f39330k, p1.a(this.f39329j, (Double.doubleToLongBits(this.f39328i) + ((a13 + ((Double.doubleToLongBits(this.f39326g) + a12) * 31)) * 31)) * 31, 31), 31), 31), 31);
        int a15 = p1.a(this.f39336q, p1.a(this.f39335p, (a.a(this.f39334o) + ((a.a(this.f39333n) + a14) * 31)) * 31, 31), 31);
        int a16 = a.a(this.f39338s);
        int a17 = p1.a(this.f39340u, (Double.doubleToLongBits(this.f39339t) + ((a16 + ((Double.doubleToLongBits(this.f39337r) + a15) * 31)) * 31)) * 31, 31);
        boolean z13 = this.f39341v;
        if (!z13) {
            z12 = z13;
        }
        return this.f39345z + p1.a(this.f39344y, p1.a(this.f39343x, p1.a(this.f39342w, (a17 + (z12 ? 1 : 0)) * 31, 31), 31), 31);
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("frameRateThreshold", this.f39320a);
        jSONObject.put("samplingTimeInMs", this.f39321b);
        jSONObject.put("violationLimit", this.f39322c);
        jSONObject.put("modelInitTimeoutInMs", this.f39323d);
        jSONObject.put("manualCaptureAllowed", this.f39324e);
        jSONObject.put("retries", this.f39325f);
        jSONObject.put("minNearFarRatio", this.f39326g);
        jSONObject.put("tooNearThreshold", this.f39327h);
        jSONObject.put("tooFarThreshold", this.f39328i);
        jSONObject.put("nearImages", this.f39329j);
        jSONObject.put("farImages", this.f39330k);
        jSONObject.put("initialImages", this.f39331l);
        jSONObject.put("transitionImages", this.f39332m);
        jSONObject.put("minTimePerDistanceInMs", this.f39333n);
        jSONObject.put("maxConsecutiveImageTimespanInMs", this.f39334o);
        jSONObject.put("imageResolutionWidth", this.f39335p);
        jSONObject.put("imageResolutionHeight", this.f39336q);
        jSONObject.put("imageCompression", this.f39337r);
        jSONObject.put("minPhysicalMemory", this.f39338s);
        jSONObject.put("maxFaceCenterDifference", this.f39339t);
        jSONObject.put("fallbackTimeInS", this.f39340u);
        jSONObject.put("minimumPseudoPitch", this.f39342w);
        jSONObject.put("maximumPseudoPitch", this.f39343x);
        jSONObject.put("minimumPseudoYaw", this.f39344y);
        jSONObject.put("maximumPseudoYaw", this.f39345z);
        return jSONObject;
    }

    public String toString() {
        long j11 = this.f39320a;
        long j12 = this.f39321b;
        int i11 = this.f39322c;
        long j13 = this.f39323d;
        boolean z11 = this.f39324e;
        int i12 = this.f39325f;
        double d11 = this.f39326g;
        double d12 = this.f39327h;
        double d13 = this.f39328i;
        int i13 = this.f39329j;
        int i14 = this.f39330k;
        int i15 = this.f39331l;
        int i16 = i13;
        int i17 = this.f39332m;
        long j14 = this.f39333n;
        long j15 = this.f39334o;
        int i18 = this.f39335p;
        int i19 = this.f39336q;
        double d14 = this.f39337r;
        long j16 = this.f39338s;
        double d15 = this.f39339t;
        int i21 = this.f39340u;
        boolean z12 = this.f39341v;
        int i22 = this.f39342w;
        int i23 = this.f39343x;
        int i24 = this.f39344y;
        int i25 = this.f39345z;
        return "LivenessSettingsModel(frameRateThreshold=" + j11 + ", samplingTimeInMs=" + j12 + ", violationLimit=" + i11 + ", modelInitTimeoutInMs=" + j13 + ", manualCaptureAllowed=" + z11 + ", retries=" + i12 + ", minNearFarRatio=" + d11 + ", tooNearThreshold=" + d12 + ", tooFarThreshold=" + d13 + ", nearImages=" + i16 + ", farImages=" + i14 + ", initialImages=" + i15 + ", transitionImages=" + i17 + ", minTimePerDistanceInMs=" + j14 + ", maxConsecutiveImageTimespanInMs=" + j15 + ", imageResolutionWidth=" + i18 + ", imageResolutionHeight=" + i19 + ", imageCompression=" + d14 + ", minPhysicalMemory=" + j16 + ", maxFaceCenterDifference=" + d15 + ", fallbackTimeInS=" + i21 + ", userFallbackAllowed=" + z12 + ", minimumPitch=" + i22 + ", maximumPitch=" + i23 + ", minimumYaw=" + i24 + ", maximumYaw=" + i25 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LivenessSettingsModel(long r38, long r40, int r42, long r43, boolean r45, int r46, double r47, double r49, double r51, int r53, int r54, int r55, int r56, long r57, long r59, int r61, int r62, double r63, long r65, double r67, int r69, boolean r70, int r71, int r72, int r73, int r74, int r75, kotlin.jvm.internal.r r76) {
        /*
            r37 = this;
            r0 = r75
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 15
            goto L_0x000b
        L_0x0009:
            r1 = r38
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0012
            r6 = 1000(0x3e8, double:4.94E-321)
            goto L_0x0014
        L_0x0012:
            r6 = r40
        L_0x0014:
            r3 = r0 & 4
            r8 = 3
            if (r3 == 0) goto L_0x001b
            r3 = r8
            goto L_0x001d
        L_0x001b:
            r3 = r42
        L_0x001d:
            r9 = r0 & 8
            if (r9 == 0) goto L_0x0024
            r9 = 5000(0x1388, double:2.4703E-320)
            goto L_0x0026
        L_0x0024:
            r9 = r43
        L_0x0026:
            r11 = r0 & 16
            if (r11 == 0) goto L_0x002c
            r11 = 1
            goto L_0x002e
        L_0x002c:
            r11 = r45
        L_0x002e:
            r13 = r0 & 32
            if (r13 == 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r8 = r46
        L_0x0035:
            r13 = r0 & 64
            if (r13 == 0) goto L_0x003f
            r13 = 4607632778762754458(0x3ff199999999999a, double:1.1)
            goto L_0x0041
        L_0x003f:
            r13 = r47
        L_0x0041:
            r15 = r0 & 128(0x80, float:1.794E-43)
            if (r15 == 0) goto L_0x004b
            r15 = 4606732058837280358(0x3fee666666666666, double:0.95)
            goto L_0x004d
        L_0x004b:
            r15 = r49
        L_0x004d:
            r4 = r0 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x0054
            r4 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            goto L_0x0056
        L_0x0054:
            r4 = r51
        L_0x0056:
            r12 = r0 & 512(0x200, float:7.175E-43)
            r17 = 2
            if (r12 == 0) goto L_0x005f
            r12 = r17
            goto L_0x0061
        L_0x005f:
            r12 = r53
        L_0x0061:
            r76 = r12
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x006a
            r12 = r17
            goto L_0x006c
        L_0x006a:
            r12 = r54
        L_0x006c:
            r18 = r12
            r12 = r0 & 2048(0x800, float:2.87E-42)
            if (r12 == 0) goto L_0x0074
            r12 = 1
            goto L_0x0076
        L_0x0074:
            r12 = r55
        L_0x0076:
            r19 = r12
            r12 = r0 & 4096(0x1000, float:5.74E-42)
            if (r12 == 0) goto L_0x007d
            goto L_0x007f
        L_0x007d:
            r17 = r56
        L_0x007f:
            r12 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r12 == 0) goto L_0x0086
            r20 = 1000(0x3e8, double:4.94E-321)
            goto L_0x0088
        L_0x0086:
            r20 = r57
        L_0x0088:
            r12 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x008f
            r22 = 100
            goto L_0x0091
        L_0x008f:
            r22 = r59
        L_0x0091:
            r12 = 32768(0x8000, float:4.5918E-41)
            r12 = r12 & r0
            if (r12 == 0) goto L_0x009a
            r12 = 720(0x2d0, float:1.009E-42)
            goto L_0x009c
        L_0x009a:
            r12 = r61
        L_0x009c:
            r24 = 65536(0x10000, float:9.18355E-41)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00a5
            r24 = 1080(0x438, float:1.513E-42)
            goto L_0x00a7
        L_0x00a5:
            r24 = r62
        L_0x00a7:
            r25 = 131072(0x20000, float:1.83671E-40)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00b3
            r25 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            goto L_0x00b5
        L_0x00b3:
            r25 = r63
        L_0x00b5:
            r27 = 262144(0x40000, float:3.67342E-40)
            r27 = r0 & r27
            if (r27 == 0) goto L_0x00bf
            r27 = 1073741824(0x40000000, double:5.304989477E-315)
            goto L_0x00c1
        L_0x00bf:
            r27 = r65
        L_0x00c1:
            r29 = 524288(0x80000, float:7.34684E-40)
            r29 = r0 & r29
            if (r29 == 0) goto L_0x00cd
            r29 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            goto L_0x00cf
        L_0x00cd:
            r29 = r67
        L_0x00cf:
            r31 = 1048576(0x100000, float:1.469368E-39)
            r31 = r0 & r31
            if (r31 == 0) goto L_0x00d8
            r31 = 30
            goto L_0x00da
        L_0x00d8:
            r31 = r69
        L_0x00da:
            r32 = 2097152(0x200000, float:2.938736E-39)
            r32 = r0 & r32
            if (r32 == 0) goto L_0x00e3
            r32 = 1
            goto L_0x00e5
        L_0x00e3:
            r32 = r70
        L_0x00e5:
            r33 = 4194304(0x400000, float:5.877472E-39)
            r33 = r0 & r33
            if (r33 == 0) goto L_0x00ee
            r33 = 105(0x69, float:1.47E-43)
            goto L_0x00f0
        L_0x00ee:
            r33 = r71
        L_0x00f0:
            r34 = 8388608(0x800000, float:1.17549435E-38)
            r34 = r0 & r34
            if (r34 == 0) goto L_0x00f9
            r34 = 170(0xaa, float:2.38E-43)
            goto L_0x00fb
        L_0x00f9:
            r34 = r72
        L_0x00fb:
            r35 = 16777216(0x1000000, float:2.3509887E-38)
            r35 = r0 & r35
            if (r35 == 0) goto L_0x0104
            r35 = 65
            goto L_0x0106
        L_0x0104:
            r35 = r73
        L_0x0106:
            r36 = 33554432(0x2000000, float:9.403955E-38)
            r0 = r0 & r36
            if (r0 == 0) goto L_0x010f
            r0 = 135(0x87, float:1.89E-43)
            goto L_0x0111
        L_0x010f:
            r0 = r74
        L_0x0111:
            r38 = r37
            r39 = r1
            r41 = r6
            r43 = r3
            r44 = r9
            r46 = r11
            r47 = r8
            r48 = r13
            r50 = r15
            r52 = r4
            r54 = r76
            r55 = r18
            r56 = r19
            r57 = r17
            r58 = r20
            r60 = r22
            r62 = r12
            r63 = r24
            r64 = r25
            r66 = r27
            r68 = r29
            r70 = r31
            r71 = r32
            r72 = r33
            r73 = r34
            r74 = r35
            r75 = r0
            r38.<init>(r39, r41, r43, r44, r46, r47, r48, r50, r52, r54, r55, r56, r57, r58, r60, r62, r63, r64, r66, r68, r70, r71, r72, r73, r74, r75)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.LivenessSettingsModel.<init>(long, long, int, long, boolean, int, double, double, double, int, int, int, int, long, long, int, int, double, long, double, int, boolean, int, int, int, int, int, kotlin.jvm.internal.r):void");
    }
}
