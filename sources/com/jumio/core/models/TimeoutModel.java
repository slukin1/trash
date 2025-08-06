package com.jumio.core.models;

import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.jumio.commons.PersistWith;
import com.jumio.core.cdn.CDNDownload;
import com.jumio.core.model.StaticModel;
import jumio.core.p1;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

@PersistWith("TimeoutModel")
public final class TimeoutModel implements StaticModel {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final int f39396a;

    /* renamed from: b  reason: collision with root package name */
    public final int f39397b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39398c;

    /* renamed from: d  reason: collision with root package name */
    public final int f39399d;

    /* renamed from: e  reason: collision with root package name */
    public final int f39400e;

    /* renamed from: f  reason: collision with root package name */
    public final int f39401f;

    /* renamed from: g  reason: collision with root package name */
    public final int f39402g;

    /* renamed from: h  reason: collision with root package name */
    public final int f39403h;

    /* renamed from: i  reason: collision with root package name */
    public final int f39404i;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final TimeoutModel fromJson(JSONObject jSONObject) {
            return new TimeoutModel(jSONObject.optInt("upload", 20000), jSONObject.optInt("usability", DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS), jSONObject.optInt("finalize", 10000), jSONObject.optInt("extractdata", 20000), jSONObject.optInt("analytics", 10000), jSONObject.optInt("reporting", 10000), jSONObject.optInt("iproovtoken", DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS), jSONObject.optInt("iproovvalidate", 10000), jSONObject.optInt("cdn", CDNDownload.DEFAULT_TIMEOUT));
        }
    }

    public TimeoutModel() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 511, (r) null);
    }

    public TimeoutModel(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.f39396a = i11;
        this.f39397b = i12;
        this.f39398c = i13;
        this.f39399d = i14;
        this.f39400e = i15;
        this.f39401f = i16;
        this.f39402g = i17;
        this.f39403h = i18;
        this.f39404i = i19;
    }

    public static /* synthetic */ TimeoutModel copy$default(TimeoutModel timeoutModel, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i21, Object obj) {
        TimeoutModel timeoutModel2 = timeoutModel;
        int i22 = i21;
        return timeoutModel.copy((i22 & 1) != 0 ? timeoutModel2.f39396a : i11, (i22 & 2) != 0 ? timeoutModel2.f39397b : i12, (i22 & 4) != 0 ? timeoutModel2.f39398c : i13, (i22 & 8) != 0 ? timeoutModel2.f39399d : i14, (i22 & 16) != 0 ? timeoutModel2.f39400e : i15, (i22 & 32) != 0 ? timeoutModel2.f39401f : i16, (i22 & 64) != 0 ? timeoutModel2.f39402g : i17, (i22 & 128) != 0 ? timeoutModel2.f39403h : i18, (i22 & 256) != 0 ? timeoutModel2.f39404i : i19);
    }

    public final int component1() {
        return this.f39396a;
    }

    public final int component2() {
        return this.f39397b;
    }

    public final int component3() {
        return this.f39398c;
    }

    public final int component4() {
        return this.f39399d;
    }

    public final int component5() {
        return this.f39400e;
    }

    public final int component6() {
        return this.f39401f;
    }

    public final int component7() {
        return this.f39402g;
    }

    public final int component8() {
        return this.f39403h;
    }

    public final int component9() {
        return this.f39404i;
    }

    public final TimeoutModel copy(int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        return new TimeoutModel(i11, i12, i13, i14, i15, i16, i17, i18, i19);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeoutModel)) {
            return false;
        }
        TimeoutModel timeoutModel = (TimeoutModel) obj;
        return this.f39396a == timeoutModel.f39396a && this.f39397b == timeoutModel.f39397b && this.f39398c == timeoutModel.f39398c && this.f39399d == timeoutModel.f39399d && this.f39400e == timeoutModel.f39400e && this.f39401f == timeoutModel.f39401f && this.f39402g == timeoutModel.f39402g && this.f39403h == timeoutModel.f39403h && this.f39404i == timeoutModel.f39404i;
    }

    public final int getAnalytics() {
        return this.f39400e;
    }

    public final int getCdn() {
        return this.f39404i;
    }

    public final int getExtractdata() {
        return this.f39399d;
    }

    public final int getFinalize() {
        return this.f39398c;
    }

    public final int getIproovtoken() {
        return this.f39402g;
    }

    public final int getIproovvalidate() {
        return this.f39403h;
    }

    public final int getReporting() {
        return this.f39401f;
    }

    public final int getUpload() {
        return this.f39396a;
    }

    public final int getUsability() {
        return this.f39397b;
    }

    public int hashCode() {
        return this.f39404i + p1.a(this.f39403h, p1.a(this.f39402g, p1.a(this.f39401f, p1.a(this.f39400e, p1.a(this.f39399d, p1.a(this.f39398c, p1.a(this.f39397b, this.f39396a * 31, 31), 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        int i11 = this.f39396a;
        int i12 = this.f39397b;
        int i13 = this.f39398c;
        int i14 = this.f39399d;
        int i15 = this.f39400e;
        int i16 = this.f39401f;
        int i17 = this.f39402g;
        int i18 = this.f39403h;
        int i19 = this.f39404i;
        return "TimeoutModel(upload=" + i11 + ", usability=" + i12 + ", finalize=" + i13 + ", extractdata=" + i14 + ", analytics=" + i15 + ", reporting=" + i16 + ", iproovtoken=" + i17 + ", iproovvalidate=" + i18 + ", cdn=" + i19 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TimeoutModel(int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, kotlin.jvm.internal.r r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 20000(0x4e20, float:2.8026E-41)
            if (r1 == 0) goto L_0x000a
            r1 = r2
            goto L_0x000b
        L_0x000a:
            r1 = r11
        L_0x000b:
            r3 = r0 & 2
            r4 = 15000(0x3a98, float:2.102E-41)
            if (r3 == 0) goto L_0x0013
            r3 = r4
            goto L_0x0014
        L_0x0013:
            r3 = r12
        L_0x0014:
            r5 = r0 & 4
            r6 = 10000(0x2710, float:1.4013E-41)
            if (r5 == 0) goto L_0x001c
            r5 = r6
            goto L_0x001d
        L_0x001c:
            r5 = r13
        L_0x001d:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r2 = r14
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = r6
            goto L_0x002a
        L_0x0029:
            r7 = r15
        L_0x002a:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0030
            r8 = r6
            goto L_0x0032
        L_0x0030:
            r8 = r16
        L_0x0032:
            r9 = r0 & 64
            if (r9 == 0) goto L_0x0037
            goto L_0x0039
        L_0x0037:
            r4 = r17
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r6 = r18
        L_0x0040:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0047
            r0 = 30000(0x7530, float:4.2039E-41)
            goto L_0x0049
        L_0x0047:
            r0 = r19
        L_0x0049:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r5
            r15 = r2
            r16 = r7
            r17 = r8
            r18 = r4
            r19 = r6
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.TimeoutModel.<init>(int, int, int, int, int, int, int, int, int, int, kotlin.jvm.internal.r):void");
    }
}
