package com.tencent.thumbplayer.tcmedia.b;

import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public class h extends d implements ITPMediaTrackClip, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f48996a;

    /* renamed from: b  reason: collision with root package name */
    private int f48997b;

    /* renamed from: c  reason: collision with root package name */
    private long f48998c;

    /* renamed from: d  reason: collision with root package name */
    private long f48999d;

    /* renamed from: e  reason: collision with root package name */
    private String f49000e;

    /* renamed from: f  reason: collision with root package name */
    private long f49001f;

    /* renamed from: g  reason: collision with root package name */
    private long f49002g;

    private h() {
    }

    public h(String str, int i11) {
        this(str, i11, 0, -1);
    }

    public h(String str, int i11, long j11, long j12) {
        if (!TextUtils.isEmpty(str)) {
            this.f48996a = i11;
            this.f49000e = str;
            this.f48998c = j11;
            this.f48999d = j12;
            if (j11 < 0) {
                this.f48998c = 0;
            }
            if (j12 <= 0) {
                this.f48999d = getOriginalDurationMs();
            }
            this.f48997b = f.a(this.f48996a);
            return;
        }
        throw new IllegalArgumentException("TPMediaCompositionTrackClip : clipPath empty");
    }

    public void a(String str) {
        this.f49000e = str;
    }

    public ITPMediaTrackClip clone(int i11) {
        if (i11 != 3 && i11 != 2 && i11 != 1) {
            return null;
        }
        h hVar = new h();
        hVar.f48996a = i11;
        hVar.f48997b = f.a(this.f48996a);
        hVar.f48998c = this.f48998c;
        hVar.f48999d = this.f48999d;
        hVar.f49000e = this.f49000e;
        return hVar;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f48997b == hVar.getClipId() && this.f48996a == hVar.getMediaType();
    }

    public int getClipId() {
        return this.f48997b;
    }

    public long getEndTimeMs() {
        return this.f48999d;
    }

    public String getFilePath() {
        return this.f49000e;
    }

    public int getMediaType() {
        return this.f48996a;
    }

    public long getOriginalDurationMs() {
        return this.f49002g;
    }

    public long getStartPositionMs() {
        return this.f49001f;
    }

    public long getStartTimeMs() {
        return this.f48998c;
    }

    public String getUrl() {
        return this.f49000e;
    }

    public void setCutTimeRange(long j11, long j12) {
        if (j11 >= getOriginalDurationMs()) {
            throw new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
        } else if (j12 <= getOriginalDurationMs()) {
            if (j11 < 0) {
                j11 = 0;
            }
            if (j12 <= 0) {
                j12 = getOriginalDurationMs();
            }
            if (j11 < j12) {
                this.f48998c = j11;
                this.f48999d = j12;
                return;
            }
            throw new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
        } else {
            throw new IllegalArgumentException("setCutTimeRange: Start time is greater than duration");
        }
    }

    public void setOriginalDurationMs(long j11) {
        this.f49002g = j11;
    }

    public void setStartPositionMs(long j11) {
        this.f49001f = j11;
    }
}
