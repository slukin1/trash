package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

@PersistWith("DocfinderSettingsModel")
public final class DocfinderSettingsModel implements StaticModel {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final long f39279a;

    /* renamed from: b  reason: collision with root package name */
    public final long f39280b;

    /* renamed from: c  reason: collision with root package name */
    public final int f39281c;

    /* renamed from: d  reason: collision with root package name */
    public final long f39282d;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final DocfinderSettingsModel fromJson(JSONObject jSONObject) {
            return new DocfinderSettingsModel(jSONObject.optLong("frameRateThreshold", 4), jSONObject.optLong("samplingTimeInMs", 1000000000), jSONObject.optInt("violationLimit", 3), jSONObject.optLong("modelInitTimeoutInMs", 5000));
        }
    }

    public DocfinderSettingsModel() {
        this(0, 0, 0, 0, 15, (r) null);
    }

    public DocfinderSettingsModel(long j11, long j12, int i11, long j13) {
        this.f39279a = j11;
        this.f39280b = j12;
        this.f39281c = i11;
        this.f39282d = j13;
    }

    public final long getDocFinderFrameRateThreshold() {
        return this.f39279a;
    }

    public final long getDocFinderModelInitTimeoutInMs() {
        return this.f39282d;
    }

    public final long getDocFinderSamplingTimeInMs() {
        return this.f39280b;
    }

    public final int getDocFinderViolationLimit() {
        return this.f39281c;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DocfinderSettingsModel(long r8, long r10, int r12, long r13, int r15, kotlin.jvm.internal.r r16) {
        /*
            r7 = this;
            r0 = r15 & 1
            if (r0 == 0) goto L_0x0007
            r0 = 4
            goto L_0x0008
        L_0x0007:
            r0 = r8
        L_0x0008:
            r2 = r15 & 2
            if (r2 == 0) goto L_0x0010
            r2 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            goto L_0x0011
        L_0x0010:
            r2 = r10
        L_0x0011:
            r4 = r15 & 4
            if (r4 == 0) goto L_0x0017
            r4 = 3
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r15 & 8
            if (r5 == 0) goto L_0x001f
            r5 = 5000(0x1388, double:2.4703E-320)
            goto L_0x0020
        L_0x001f:
            r5 = r13
        L_0x0020:
            r8 = r7
            r9 = r0
            r11 = r2
            r13 = r4
            r14 = r5
            r8.<init>(r9, r11, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.DocfinderSettingsModel.<init>(long, long, int, long, int, kotlin.jvm.internal.r):void");
    }
}
