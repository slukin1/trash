package com.jumio.core.models;

import com.fluttercandies.photo_manager.core.entity.a;
import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import com.jumio.core.provider.IproovProvider;
import java.util.Date;
import jumio.core.o;
import jumio.core.o1;
import jumio.core.p1;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONException;
import org.json.JSONObject;

@PersistWith("SettingsModel")
public final class SettingsModel implements StaticModel, IproovProvider {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final long f39373a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f39374b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f39375c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f39376d;

    /* renamed from: e  reason: collision with root package name */
    public final String f39377e;

    /* renamed from: f  reason: collision with root package name */
    public final String f39378f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f39379g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f39380h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f39381i;

    /* renamed from: j  reason: collision with root package name */
    public final int f39382j;

    /* renamed from: k  reason: collision with root package name */
    public final String f39383k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f39384l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f39385m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f39386n;

    /* renamed from: o  reason: collision with root package name */
    public final int f39387o;

    /* renamed from: p  reason: collision with root package name */
    public final int f39388p;

    /* renamed from: q  reason: collision with root package name */
    public final int f39389q;

    /* renamed from: r  reason: collision with root package name */
    public final int f39390r;

    /* renamed from: s  reason: collision with root package name */
    public final int f39391s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f39392t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f39393u;

    /* renamed from: v  reason: collision with root package name */
    public final String f39394v;

    /* renamed from: w  reason: collision with root package name */
    public final boolean f39395w;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final SettingsModel fromJson(JSONObject jSONObject) throws JSONException {
            int i11;
            boolean z11;
            String str;
            JSONObject jSONObject2 = jSONObject;
            JSONObject optJSONObject = jSONObject2.optJSONObject("configurations");
            Date a11 = o1.a(jSONObject2, "timestamp", "yyyy-MM-dd'T'HH:mm:ss.S'Z'");
            long time = a11 != null ? a11.getTime() : 0;
            boolean optBoolean = jSONObject2.optBoolean("brandingEnabled", true);
            boolean optBoolean2 = jSONObject2.optBoolean("returnImages", false);
            boolean optBoolean3 = jSONObject2.optBoolean("allowNfcImageExtraction", false);
            String optString = jSONObject2.optString("countryForIp", "");
            String optString2 = jSONObject2.optString("stateForIp", "");
            boolean optBoolean4 = jSONObject2.optBoolean("analyticsEnabled", false);
            boolean optBoolean5 = jSONObject2.optBoolean("additionalDataPoints", false);
            int j11 = RangesKt___RangesKt.j(jSONObject2.optInt("maxLivenessImages", 10), 0, 10);
            int optInt = jSONObject2.optInt("maxFileUploadSize", 3145728);
            boolean optBoolean6 = jSONObject2.optBoolean("dvFileUploadEnabled", false);
            boolean optBoolean7 = jSONObject2.optBoolean("nfcScanningMandatory", false);
            boolean optBoolean8 = jSONObject2.optBoolean("keyPinning", true);
            String optString3 = jSONObject2.optString("workflowDefinitionKey", "");
            int optInt2 = optJSONObject != null ? optJSONObject.optInt("iproovMaxAttempts", 0) : 0;
            boolean optBoolean9 = optJSONObject != null ? optJSONObject.optBoolean("instantFeedback", false) : false;
            int optInt3 = optJSONObject != null ? optJSONObject.optInt("maxRetries", 0) : 0;
            if (optJSONObject != null) {
                z11 = true;
                i11 = optJSONObject.optInt("nfcRetries", 1);
            } else {
                z11 = true;
                i11 = 1;
            }
            int i12 = 10000;
            if (optJSONObject != null) {
                i12 = optJSONObject.optInt("nfcTimeout", 10000);
            }
            int i13 = i12;
            boolean optBoolean10 = optJSONObject != null ? optJSONObject.optBoolean("automaticBarcodeExtraction", z11) : z11;
            boolean optBoolean11 = optJSONObject != null ? optJSONObject.optBoolean("useCamera1", false) : false;
            String optString4 = optJSONObject != null ? optJSONObject.optString("sardineClientId", "") : null;
            if (optString4 == null) {
                str = "";
            } else {
                str = optString4;
            }
            return new SettingsModel(time, optBoolean, optBoolean2, optBoolean3, optString, optString2, optBoolean5, true, optBoolean4, j11, str, optBoolean11, optBoolean8, optBoolean9, optInt3, optInt2, i11, i13, optInt, optBoolean6, optBoolean7, optString3, optBoolean10);
        }
    }

    public SettingsModel() {
        this(0, false, false, false, (String) null, (String) null, false, false, false, 0, (String) null, false, false, false, 0, 0, 0, 0, 0, false, false, (String) null, false, 8388607, (r) null);
    }

    public SettingsModel(long j11, boolean z11, boolean z12, boolean z13, String str, String str2, boolean z14, boolean z15, boolean z16, int i11, String str3, boolean z17, boolean z18, boolean z19, int i12, int i13, int i14, int i15, int i16, boolean z21, boolean z22, String str4, boolean z23) {
        this.f39373a = j11;
        this.f39374b = z11;
        this.f39375c = z12;
        this.f39376d = z13;
        this.f39377e = str;
        this.f39378f = str2;
        this.f39379g = z14;
        this.f39380h = z15;
        this.f39381i = z16;
        this.f39382j = i11;
        this.f39383k = str3;
        this.f39384l = z17;
        this.f39385m = z18;
        this.f39386n = z19;
        this.f39387o = i12;
        this.f39388p = i13;
        this.f39389q = i14;
        this.f39390r = i15;
        this.f39391s = i16;
        this.f39392t = z21;
        this.f39393u = z22;
        this.f39394v = str4;
        this.f39395w = z23;
    }

    public static /* synthetic */ SettingsModel copy$default(SettingsModel settingsModel, long j11, boolean z11, boolean z12, boolean z13, String str, String str2, boolean z14, boolean z15, boolean z16, int i11, String str3, boolean z17, boolean z18, boolean z19, int i12, int i13, int i14, int i15, int i16, boolean z21, boolean z22, String str4, boolean z23, int i17, Object obj) {
        SettingsModel settingsModel2 = settingsModel;
        int i18 = i17;
        return settingsModel.copy((i18 & 1) != 0 ? settingsModel2.f39373a : j11, (i18 & 2) != 0 ? settingsModel2.f39374b : z11, (i18 & 4) != 0 ? settingsModel2.f39375c : z12, (i18 & 8) != 0 ? settingsModel2.f39376d : z13, (i18 & 16) != 0 ? settingsModel2.f39377e : str, (i18 & 32) != 0 ? settingsModel2.f39378f : str2, (i18 & 64) != 0 ? settingsModel2.f39379g : z14, (i18 & 128) != 0 ? settingsModel2.f39380h : z15, (i18 & 256) != 0 ? settingsModel2.f39381i : z16, (i18 & 512) != 0 ? settingsModel2.f39382j : i11, (i18 & 1024) != 0 ? settingsModel2.f39383k : str3, (i18 & 2048) != 0 ? settingsModel2.f39384l : z17, (i18 & 4096) != 0 ? settingsModel2.f39385m : z18, (i18 & 8192) != 0 ? settingsModel2.f39386n : z19, (i18 & 16384) != 0 ? settingsModel2.f39387o : i12, (i18 & 32768) != 0 ? settingsModel2.f39388p : i13, (i18 & 65536) != 0 ? settingsModel2.f39389q : i14, (i18 & 131072) != 0 ? settingsModel2.f39390r : i15, (i18 & 262144) != 0 ? settingsModel2.f39391s : i16, (i18 & 524288) != 0 ? settingsModel2.f39392t : z21, (i18 & 1048576) != 0 ? settingsModel2.f39393u : z22, (i18 & 2097152) != 0 ? settingsModel2.f39394v : str4, (i18 & 4194304) != 0 ? settingsModel2.f39395w : z23);
    }

    public final long component1() {
        return this.f39373a;
    }

    public final int component10() {
        return this.f39382j;
    }

    public final String component11() {
        return this.f39383k;
    }

    public final boolean component12() {
        return this.f39384l;
    }

    public final boolean component13() {
        return this.f39385m;
    }

    public final boolean component14() {
        return this.f39386n;
    }

    public final int component15() {
        return this.f39387o;
    }

    public final int component16() {
        return this.f39388p;
    }

    public final int component17() {
        return this.f39389q;
    }

    public final int component18() {
        return this.f39390r;
    }

    public final int component19() {
        return this.f39391s;
    }

    public final boolean component2() {
        return this.f39374b;
    }

    public final boolean component20() {
        return this.f39392t;
    }

    public final boolean component21() {
        return this.f39393u;
    }

    public final String component22() {
        return this.f39394v;
    }

    public final boolean component23() {
        return this.f39395w;
    }

    public final boolean component3() {
        return this.f39375c;
    }

    public final boolean component4() {
        return this.f39376d;
    }

    public final String component5() {
        return this.f39377e;
    }

    public final String component6() {
        return this.f39378f;
    }

    public final boolean component7() {
        return this.f39379g;
    }

    public final boolean component8() {
        return this.f39380h;
    }

    public final boolean component9() {
        return this.f39381i;
    }

    public final SettingsModel copy(long j11, boolean z11, boolean z12, boolean z13, String str, String str2, boolean z14, boolean z15, boolean z16, int i11, String str3, boolean z17, boolean z18, boolean z19, int i12, int i13, int i14, int i15, int i16, boolean z21, boolean z22, String str4, boolean z23) {
        return new SettingsModel(j11, z11, z12, z13, str, str2, z14, z15, z16, i11, str3, z17, z18, z19, i12, i13, i14, i15, i16, z21, z22, str4, z23);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettingsModel)) {
            return false;
        }
        SettingsModel settingsModel = (SettingsModel) obj;
        return this.f39373a == settingsModel.f39373a && this.f39374b == settingsModel.f39374b && this.f39375c == settingsModel.f39375c && this.f39376d == settingsModel.f39376d && x.b(this.f39377e, settingsModel.f39377e) && x.b(this.f39378f, settingsModel.f39378f) && this.f39379g == settingsModel.f39379g && this.f39380h == settingsModel.f39380h && this.f39381i == settingsModel.f39381i && this.f39382j == settingsModel.f39382j && x.b(this.f39383k, settingsModel.f39383k) && this.f39384l == settingsModel.f39384l && this.f39385m == settingsModel.f39385m && this.f39386n == settingsModel.f39386n && this.f39387o == settingsModel.f39387o && this.f39388p == settingsModel.f39388p && this.f39389q == settingsModel.f39389q && this.f39390r == settingsModel.f39390r && this.f39391s == settingsModel.f39391s && this.f39392t == settingsModel.f39392t && this.f39393u == settingsModel.f39393u && x.b(this.f39394v, settingsModel.f39394v) && this.f39395w == settingsModel.f39395w;
    }

    public final boolean getAutomaticBarcodeExtraction() {
        return this.f39395w;
    }

    public final int getAutomationMaxRetries() {
        return this.f39387o;
    }

    public final String getCountryForIp() {
        return this.f39377e;
    }

    public final boolean getDownloadNfcImage() {
        return this.f39376d;
    }

    public final boolean getDvFileUploadEnabled() {
        return this.f39392t;
    }

    public int getIproovMaxAttempts() {
        return this.f39388p;
    }

    public final boolean getKeyPinningEnabled() {
        return this.f39385m;
    }

    public final int getMaxFileUploadSize() {
        return this.f39391s;
    }

    public final int getMaxLivenessImages() {
        return this.f39382j;
    }

    public final boolean getNfcMandatory() {
        return this.f39393u;
    }

    public final int getNfcRetries() {
        return this.f39389q;
    }

    public final int getNfcTimeout() {
        return this.f39390r;
    }

    public final boolean getReturnImages() {
        return this.f39375c;
    }

    public final String getSardineClientId() {
        return this.f39383k;
    }

    public final long getServerTimestamp() {
        return this.f39373a;
    }

    public final String getStateForIp() {
        return this.f39378f;
    }

    public final boolean getUseCamera1() {
        return this.f39384l;
    }

    public final String getWorkflowDefinitionKey() {
        return this.f39394v;
    }

    public int hashCode() {
        int a11 = a.a(this.f39373a) * 31;
        boolean z11 = this.f39374b;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (a11 + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.f39375c;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.f39376d;
        if (z14) {
            z14 = true;
        }
        int a12 = o.a(this.f39378f, o.a(this.f39377e, (i12 + (z14 ? 1 : 0)) * 31, 31), 31);
        boolean z15 = this.f39379g;
        if (z15) {
            z15 = true;
        }
        int i13 = (a12 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.f39380h;
        if (z16) {
            z16 = true;
        }
        int i14 = (i13 + (z16 ? 1 : 0)) * 31;
        boolean z17 = this.f39381i;
        if (z17) {
            z17 = true;
        }
        int a13 = o.a(this.f39383k, p1.a(this.f39382j, (i14 + (z17 ? 1 : 0)) * 31, 31), 31);
        boolean z18 = this.f39384l;
        if (z18) {
            z18 = true;
        }
        int i15 = (a13 + (z18 ? 1 : 0)) * 31;
        boolean z19 = this.f39385m;
        if (z19) {
            z19 = true;
        }
        int i16 = (i15 + (z19 ? 1 : 0)) * 31;
        boolean z21 = this.f39386n;
        if (z21) {
            z21 = true;
        }
        int a14 = p1.a(this.f39391s, p1.a(this.f39390r, p1.a(this.f39389q, p1.a(this.f39388p, p1.a(this.f39387o, (i16 + (z21 ? 1 : 0)) * 31, 31), 31), 31), 31), 31);
        boolean z22 = this.f39392t;
        if (z22) {
            z22 = true;
        }
        int i17 = (a14 + (z22 ? 1 : 0)) * 31;
        boolean z23 = this.f39393u;
        if (z23) {
            z23 = true;
        }
        int a15 = o.a(this.f39394v, (i17 + (z23 ? 1 : 0)) * 31, 31);
        boolean z24 = this.f39395w;
        if (!z24) {
            z12 = z24;
        }
        return a15 + (z12 ? 1 : 0);
    }

    public final boolean isAdditionalDataPointsEnabled() {
        return this.f39379g;
    }

    public final boolean isAnalyticsEnabled() {
        return this.f39381i;
    }

    public final boolean isBrandingEnabled() {
        return this.f39374b;
    }

    public final boolean isInstantFeedbackEnabled() {
        return this.f39386n;
    }

    public final boolean isLoaded() {
        return this.f39380h;
    }

    public String toString() {
        long j11 = this.f39373a;
        boolean z11 = this.f39374b;
        boolean z12 = this.f39375c;
        boolean z13 = this.f39376d;
        String str = this.f39377e;
        String str2 = this.f39378f;
        boolean z14 = this.f39379g;
        boolean z15 = this.f39380h;
        boolean z16 = this.f39381i;
        int i11 = this.f39382j;
        String str3 = this.f39383k;
        boolean z17 = this.f39384l;
        boolean z18 = this.f39385m;
        boolean z19 = this.f39386n;
        int i12 = this.f39387o;
        int i13 = this.f39388p;
        int i14 = this.f39389q;
        int i15 = this.f39390r;
        int i16 = this.f39391s;
        boolean z21 = this.f39392t;
        boolean z22 = this.f39393u;
        String str4 = this.f39394v;
        boolean z23 = this.f39395w;
        return "SettingsModel(serverTimestamp=" + j11 + ", isBrandingEnabled=" + z11 + ", returnImages=" + z12 + ", downloadNfcImage=" + z13 + ", countryForIp=" + str + ", stateForIp=" + str2 + ", isAdditionalDataPointsEnabled=" + z14 + ", isLoaded=" + z15 + ", isAnalyticsEnabled=" + z16 + ", maxLivenessImages=" + i11 + ", sardineClientId=" + str3 + ", useCamera1=" + z17 + ", keyPinningEnabled=" + z18 + ", isInstantFeedbackEnabled=" + z19 + ", automationMaxRetries=" + i12 + ", iproovMaxAttempts=" + i13 + ", nfcRetries=" + i14 + ", nfcTimeout=" + i15 + ", maxFileUploadSize=" + i16 + ", dvFileUploadEnabled=" + z21 + ", nfcMandatory=" + z22 + ", workflowDefinitionKey=" + str4 + ", automaticBarcodeExtraction=" + z23 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SettingsModel(long r25, boolean r27, boolean r28, boolean r29, java.lang.String r30, java.lang.String r31, boolean r32, boolean r33, boolean r34, int r35, java.lang.String r36, boolean r37, boolean r38, boolean r39, int r40, int r41, int r42, int r43, int r44, boolean r45, boolean r46, java.lang.String r47, boolean r48, int r49, kotlin.jvm.internal.r r50) {
        /*
            r24 = this;
            r0 = r49
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0009
            r1 = 0
            goto L_0x000b
        L_0x0009:
            r1 = r25
        L_0x000b:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0011
            r3 = 1
            goto L_0x0013
        L_0x0011:
            r3 = r27
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = 0
            goto L_0x001b
        L_0x0019:
            r5 = r28
        L_0x001b:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0021
            r7 = 0
            goto L_0x0023
        L_0x0021:
            r7 = r29
        L_0x0023:
            r8 = r0 & 16
            java.lang.String r9 = ""
            if (r8 == 0) goto L_0x002b
            r8 = r9
            goto L_0x002d
        L_0x002b:
            r8 = r30
        L_0x002d:
            r10 = r0 & 32
            if (r10 == 0) goto L_0x0033
            r10 = r9
            goto L_0x0035
        L_0x0033:
            r10 = r31
        L_0x0035:
            r11 = r0 & 64
            if (r11 == 0) goto L_0x003b
            r11 = 0
            goto L_0x003d
        L_0x003b:
            r11 = r32
        L_0x003d:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0043
            r12 = 0
            goto L_0x0045
        L_0x0043:
            r12 = r33
        L_0x0045:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x004b
            r13 = 0
            goto L_0x004d
        L_0x004b:
            r13 = r34
        L_0x004d:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x0054
            r14 = 10
            goto L_0x0056
        L_0x0054:
            r14 = r35
        L_0x0056:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x005c
            r15 = r9
            goto L_0x005e
        L_0x005c:
            r15 = r36
        L_0x005e:
            r4 = r0 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0064
            r4 = 0
            goto L_0x0066
        L_0x0064:
            r4 = r37
        L_0x0066:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x006c
            r6 = 1
            goto L_0x006e
        L_0x006c:
            r6 = r38
        L_0x006e:
            r27 = r9
            r9 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r9 == 0) goto L_0x0076
            r9 = 0
            goto L_0x0078
        L_0x0076:
            r9 = r39
        L_0x0078:
            r50 = r9
            r9 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r9 == 0) goto L_0x0080
            r9 = 0
            goto L_0x0082
        L_0x0080:
            r9 = r40
        L_0x0082:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x008c
            r16 = 0
            goto L_0x008e
        L_0x008c:
            r16 = r41
        L_0x008e:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x0097
            r17 = 1
            goto L_0x0099
        L_0x0097:
            r17 = r42
        L_0x0099:
            r18 = 131072(0x20000, float:1.83671E-40)
            r18 = r0 & r18
            if (r18 == 0) goto L_0x00a2
            r18 = 10000(0x2710, float:1.4013E-41)
            goto L_0x00a4
        L_0x00a2:
            r18 = r43
        L_0x00a4:
            r19 = 262144(0x40000, float:3.67342E-40)
            r19 = r0 & r19
            if (r19 == 0) goto L_0x00ad
            r19 = 3145728(0x300000, float:4.408104E-39)
            goto L_0x00af
        L_0x00ad:
            r19 = r44
        L_0x00af:
            r20 = 524288(0x80000, float:7.34684E-40)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x00b8
            r20 = 0
            goto L_0x00ba
        L_0x00b8:
            r20 = r45
        L_0x00ba:
            r21 = 1048576(0x100000, float:1.469368E-39)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00c3
            r21 = 0
            goto L_0x00c5
        L_0x00c3:
            r21 = r46
        L_0x00c5:
            r22 = 2097152(0x200000, float:2.938736E-39)
            r22 = r0 & r22
            if (r22 == 0) goto L_0x00ce
            r22 = r27
            goto L_0x00d0
        L_0x00ce:
            r22 = r47
        L_0x00d0:
            r23 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r23
            if (r0 == 0) goto L_0x00d8
            r0 = 1
            goto L_0x00da
        L_0x00d8:
            r0 = r48
        L_0x00da:
            r25 = r24
            r26 = r1
            r28 = r3
            r29 = r5
            r30 = r7
            r31 = r8
            r32 = r10
            r33 = r11
            r34 = r12
            r35 = r13
            r36 = r14
            r37 = r15
            r38 = r4
            r39 = r6
            r40 = r50
            r41 = r9
            r42 = r16
            r43 = r17
            r44 = r18
            r45 = r19
            r46 = r20
            r47 = r21
            r48 = r22
            r49 = r0
            r25.<init>(r26, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.SettingsModel.<init>(long, boolean, boolean, boolean, java.lang.String, java.lang.String, boolean, boolean, boolean, int, java.lang.String, boolean, boolean, boolean, int, int, int, int, int, boolean, boolean, java.lang.String, boolean, int, kotlin.jvm.internal.r):void");
    }
}
