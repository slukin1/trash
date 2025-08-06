package com.tencent.thumbplayer.tcmedia.b;

import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrackClip;
import java.io.Serializable;

public class a extends d implements ITPMediaTrackClip, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f48974a;

    /* renamed from: b  reason: collision with root package name */
    private int f48975b;

    /* renamed from: c  reason: collision with root package name */
    private long f48976c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f48977d = 0;

    /* renamed from: e  reason: collision with root package name */
    private long f48978e;

    public a(int i11) {
        this.f48974a = i11;
        this.f48975b = f.a(i11);
    }

    public ITPMediaTrackClip clone(int i11) {
        if (i11 != 3 && i11 != 2 && i11 != 1) {
            return null;
        }
        a aVar = new a(i11);
        aVar.f48975b = f.a(i11);
        aVar.f48976c = this.f48976c;
        aVar.f48977d = this.f48977d;
        return aVar;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f48975b == aVar.getClipId() && this.f48974a == aVar.getMediaType();
    }

    public int getClipId() {
        return this.f48975b;
    }

    public long getEndTimeMs() {
        return this.f48977d;
    }

    public String getFilePath() {
        return null;
    }

    public int getMediaType() {
        return this.f48974a;
    }

    public long getOriginalDurationMs() {
        return this.f48977d - this.f48976c;
    }

    public long getStartPositionMs() {
        return this.f48978e;
    }

    public long getStartTimeMs() {
        return this.f48976c;
    }

    public String getUrl() {
        return null;
    }

    public void setCutTimeRange(long j11, long j12) {
        if (j11 < 0) {
            j11 = 0;
        }
        if (j11 < j12) {
            this.f48976c = j11;
            this.f48977d = j12;
            return;
        }
        throw new IllegalArgumentException("setCutTimeRange: Start time is greater than end time");
    }

    public void setOriginalDurationMs(long j11) {
    }

    public void setStartPositionMs(long j11) {
        this.f48978e = j11;
    }
}
