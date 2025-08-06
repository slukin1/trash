package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;
import org.json.JSONObject;

@PersistWith("DataDogModel")
public final class DataDogModel implements StaticModel {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final String f39262a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39263b;

    /* renamed from: c  reason: collision with root package name */
    public final float f39264c;

    /* renamed from: d  reason: collision with root package name */
    public final long f39265d;

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashMap f39266e;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public static /* synthetic */ DataDogModel fromJson$default(Companion companion, JSONObject jSONObject, long j11, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                j11 = 0;
            }
            return companion.fromJson(jSONObject, j11);
        }

        public final DataDogModel fromJson(JSONObject jSONObject, long j11) {
            return new DataDogModel(jSONObject.optString("appId", ""), jSONObject.optString("clientId", ""), (float) jSONObject.optInt("sampleRate", 100), j11);
        }
    }

    public DataDogModel() {
        this((String) null, (String) null, 0.0f, 0, 15, (r) null);
    }

    public DataDogModel(String str, String str2, float f11, long j11) {
        this.f39262a = str;
        this.f39263b = str2;
        this.f39264c = f11;
        this.f39265d = j11;
        this.f39266e = new LinkedHashMap();
    }

    public final String getAppId() {
        return this.f39262a;
    }

    public final Map<String, String> getAttributes() {
        return this.f39266e;
    }

    public final String getClientId() {
        return this.f39263b;
    }

    public final float getSampleRate() {
        return this.f39264c;
    }

    public final long getTimestamp() {
        return this.f39265d;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DataDogModel(java.lang.String r3, java.lang.String r4, float r5, long r6, int r8, kotlin.jvm.internal.r r9) {
        /*
            r2 = this;
            r9 = r8 & 1
            java.lang.String r0 = ""
            if (r9 == 0) goto L_0x0008
            r9 = r0
            goto L_0x0009
        L_0x0008:
            r9 = r3
        L_0x0009:
            r3 = r8 & 2
            if (r3 == 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r0 = r4
        L_0x000f:
            r3 = r8 & 4
            if (r3 == 0) goto L_0x0015
            r5 = 1120403456(0x42c80000, float:100.0)
        L_0x0015:
            r1 = r5
            r3 = r8 & 8
            if (r3 == 0) goto L_0x001c
            r6 = 0
        L_0x001c:
            r7 = r6
            r3 = r2
            r4 = r9
            r5 = r0
            r6 = r1
            r3.<init>(r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.DataDogModel.<init>(java.lang.String, java.lang.String, float, long, int, kotlin.jvm.internal.r):void");
    }
}
