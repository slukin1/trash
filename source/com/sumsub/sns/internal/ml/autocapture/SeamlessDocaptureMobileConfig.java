package com.sumsub.sns.internal.ml.autocapture;

import com.sumsub.sns.internal.log.b;
import com.sumsub.sns.internal.log.c;
import com.sumsub.sns.internal.util.DataUnit;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

public final class SeamlessDocaptureMobileConfig {

    /* renamed from: f  reason: collision with root package name */
    public static final a f34911f = new a((r) null);

    /* renamed from: g  reason: collision with root package name */
    public static final int f34912g = ((int) DataUnit.MEGABYTES.toBytes(2));

    /* renamed from: h  reason: collision with root package name */
    public static final int f34913h = ((int) TimeUnit.MINUTES.toSeconds(1));

    /* renamed from: i  reason: collision with root package name */
    public static final int f34914i = 30;

    /* renamed from: a  reason: collision with root package name */
    public final int f34915a;

    /* renamed from: b  reason: collision with root package name */
    public final int f34916b;

    /* renamed from: c  reason: collision with root package name */
    public final VideoQuality f34917c;

    /* renamed from: d  reason: collision with root package name */
    public final VideoQuality f34918d;

    /* renamed from: e  reason: collision with root package name */
    public final int f34919e;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/internal/ml/autocapture/SeamlessDocaptureMobileConfig$VideoQuality;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "UHD", "FHD", "HD", "SD", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
    public enum VideoQuality {
        UHD("UHD"),
        FHD("FHD"),
        HD("HD"),
        SD("SD");
        
        public static final a Companion = null;
        private final String value;

        public static final class a {
            public /* synthetic */ a(r rVar) {
                this();
            }

            public final VideoQuality a(String str) {
                for (VideoQuality videoQuality : VideoQuality.values()) {
                    if (x.b(videoQuality.getValue(), str)) {
                        return videoQuality;
                    }
                }
                return null;
            }

            public a() {
            }
        }

        /* access modifiers changed from: public */
        static {
            Companion = new a((r) null);
        }

        private VideoQuality(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final SeamlessDocaptureMobileConfig a() {
            String f11 = com.sumsub.sns.internal.ff.a.f34215a.v().f();
            if (f11 == null) {
                return new SeamlessDocaptureMobileConfig(0, 0, (VideoQuality) null, (VideoQuality) null, 0, 31, (r) null);
            }
            try {
                JSONObject jSONObject = new JSONObject(f11).getJSONObject("android");
                int optInt = jSONObject.optInt("videoBitrate", c());
                int optInt2 = jSONObject.optInt("maxRecordedDurationSec", b());
                VideoQuality a11 = c.a(jSONObject.optString("videoQuality"));
                if (a11 == null) {
                    a11 = VideoQuality.HD;
                }
                VideoQuality videoQuality = a11;
                VideoQuality a12 = c.a(jSONObject.optString("videoFallbackQuality"));
                if (a12 == null) {
                    a12 = VideoQuality.SD;
                }
                return new SeamlessDocaptureMobileConfig(optInt, optInt2, videoQuality, a12, jSONObject.optInt("maxRecordedFileSizeMB", 30));
            } catch (Exception e11) {
                b.b(com.sumsub.sns.internal.log.a.f34862a, c.a(a.f34920m), "Failed to parse seamlessDocaptureMobileConfig FF", e11);
                return new SeamlessDocaptureMobileConfig(0, 0, (VideoQuality) null, (VideoQuality) null, 0, 31, (r) null);
            }
        }

        public final int b() {
            return SeamlessDocaptureMobileConfig.f34913h;
        }

        public final int c() {
            return SeamlessDocaptureMobileConfig.f34912g;
        }

        public a() {
        }
    }

    public SeamlessDocaptureMobileConfig() {
        this(0, 0, (VideoQuality) null, (VideoQuality) null, 0, 31, (r) null);
    }

    public final SeamlessDocaptureMobileConfig a(int i11, int i12, VideoQuality videoQuality, VideoQuality videoQuality2, int i13) {
        return new SeamlessDocaptureMobileConfig(i11, i12, videoQuality, videoQuality2, i13);
    }

    public final int c() {
        return this.f34915a;
    }

    public final int d() {
        return this.f34916b;
    }

    public final VideoQuality e() {
        return this.f34917c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SeamlessDocaptureMobileConfig)) {
            return false;
        }
        SeamlessDocaptureMobileConfig seamlessDocaptureMobileConfig = (SeamlessDocaptureMobileConfig) obj;
        return this.f34915a == seamlessDocaptureMobileConfig.f34915a && this.f34916b == seamlessDocaptureMobileConfig.f34916b && this.f34917c == seamlessDocaptureMobileConfig.f34917c && this.f34918d == seamlessDocaptureMobileConfig.f34918d && this.f34919e == seamlessDocaptureMobileConfig.f34919e;
    }

    public final VideoQuality f() {
        return this.f34918d;
    }

    public final int g() {
        return this.f34919e;
    }

    public final int h() {
        return this.f34916b;
    }

    public int hashCode() {
        return (((((((this.f34915a * 31) + this.f34916b) * 31) + this.f34917c.hashCode()) * 31) + this.f34918d.hashCode()) * 31) + this.f34919e;
    }

    public final int i() {
        return this.f34919e;
    }

    public final int j() {
        return this.f34915a;
    }

    public final VideoQuality k() {
        return this.f34918d;
    }

    public final VideoQuality l() {
        return this.f34917c;
    }

    public String toString() {
        return "SeamlessDocaptureMobileConfig(videoBitrate=" + this.f34915a + ", maxRecordedDurationSec=" + this.f34916b + ", videoQuality=" + this.f34917c + ", videoFallbackQuality=" + this.f34918d + ", maxRecordedFileSizeMB=" + this.f34919e + ')';
    }

    public SeamlessDocaptureMobileConfig(int i11, int i12, VideoQuality videoQuality, VideoQuality videoQuality2, int i13) {
        this.f34915a = i11;
        this.f34916b = i12;
        this.f34917c = videoQuality;
        this.f34918d = videoQuality2;
        this.f34919e = i13;
    }

    public static /* synthetic */ SeamlessDocaptureMobileConfig a(SeamlessDocaptureMobileConfig seamlessDocaptureMobileConfig, int i11, int i12, VideoQuality videoQuality, VideoQuality videoQuality2, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = seamlessDocaptureMobileConfig.f34915a;
        }
        if ((i14 & 2) != 0) {
            i12 = seamlessDocaptureMobileConfig.f34916b;
        }
        int i15 = i12;
        if ((i14 & 4) != 0) {
            videoQuality = seamlessDocaptureMobileConfig.f34917c;
        }
        VideoQuality videoQuality3 = videoQuality;
        if ((i14 & 8) != 0) {
            videoQuality2 = seamlessDocaptureMobileConfig.f34918d;
        }
        VideoQuality videoQuality4 = videoQuality2;
        if ((i14 & 16) != 0) {
            i13 = seamlessDocaptureMobileConfig.f34919e;
        }
        return seamlessDocaptureMobileConfig.a(i11, i15, videoQuality3, videoQuality4, i13);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SeamlessDocaptureMobileConfig(int r4, int r5, com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig.VideoQuality r6, com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig.VideoQuality r7, int r8, int r9, kotlin.jvm.internal.r r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x0006
            int r4 = f34912g
        L_0x0006:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x000c
            int r5 = f34913h
        L_0x000c:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x0013
            com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig$VideoQuality r6 = com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig.VideoQuality.HD
        L_0x0013:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x001a
            com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig$VideoQuality r7 = com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig.VideoQuality.SD
        L_0x001a:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0021
            r8 = 30
        L_0x0021:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig.<init>(int, int, com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig$VideoQuality, com.sumsub.sns.internal.ml.autocapture.SeamlessDocaptureMobileConfig$VideoQuality, int, int, kotlin.jvm.internal.r):void");
    }
}
