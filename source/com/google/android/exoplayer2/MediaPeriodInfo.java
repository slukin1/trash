package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Util;

final class MediaPeriodInfo {
    public final long durationUs;
    public final long endPositionUs;

    /* renamed from: id  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f65678id;
    public final boolean isFinal;
    public final boolean isLastInTimelinePeriod;
    public final boolean isLastInTimelineWindow;
    public final long requestedContentPositionUs;
    public final long startPositionUs;

    public MediaPeriodInfo(MediaSource.MediaPeriodId mediaPeriodId, long j11, long j12, long j13, long j14, boolean z11, boolean z12, boolean z13) {
        this.f65678id = mediaPeriodId;
        this.startPositionUs = j11;
        this.requestedContentPositionUs = j12;
        this.endPositionUs = j13;
        this.durationUs = j14;
        this.isLastInTimelinePeriod = z11;
        this.isLastInTimelineWindow = z12;
        this.isFinal = z13;
    }

    public MediaPeriodInfo copyWithRequestedContentPositionUs(long j11) {
        if (j11 == this.requestedContentPositionUs) {
            return this;
        }
        return new MediaPeriodInfo(this.f65678id, this.startPositionUs, j11, this.endPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isLastInTimelineWindow, this.isFinal);
    }

    public MediaPeriodInfo copyWithStartPositionUs(long j11) {
        if (j11 == this.startPositionUs) {
            return this;
        }
        return new MediaPeriodInfo(this.f65678id, j11, this.requestedContentPositionUs, this.endPositionUs, this.durationUs, this.isLastInTimelinePeriod, this.isLastInTimelineWindow, this.isFinal);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaPeriodInfo.class != obj.getClass()) {
            return false;
        }
        MediaPeriodInfo mediaPeriodInfo = (MediaPeriodInfo) obj;
        if (this.startPositionUs == mediaPeriodInfo.startPositionUs && this.requestedContentPositionUs == mediaPeriodInfo.requestedContentPositionUs && this.endPositionUs == mediaPeriodInfo.endPositionUs && this.durationUs == mediaPeriodInfo.durationUs && this.isLastInTimelinePeriod == mediaPeriodInfo.isLastInTimelinePeriod && this.isLastInTimelineWindow == mediaPeriodInfo.isLastInTimelineWindow && this.isFinal == mediaPeriodInfo.isFinal && Util.areEqual(this.f65678id, mediaPeriodInfo.f65678id)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((527 + this.f65678id.hashCode()) * 31) + ((int) this.startPositionUs)) * 31) + ((int) this.requestedContentPositionUs)) * 31) + ((int) this.endPositionUs)) * 31) + ((int) this.durationUs)) * 31) + (this.isLastInTimelinePeriod ? 1 : 0)) * 31) + (this.isLastInTimelineWindow ? 1 : 0)) * 31) + (this.isFinal ? 1 : 0);
    }
}
