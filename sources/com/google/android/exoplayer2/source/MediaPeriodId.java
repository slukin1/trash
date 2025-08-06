package com.google.android.exoplayer2.source;

public class MediaPeriodId {
    public final int adGroupIndex;
    public final int adIndexInAdGroup;
    public final int nextAdGroupIndex;
    public final Object periodUid;
    public final long windowSequenceNumber;

    public MediaPeriodId(Object obj) {
        this(obj, -1);
    }

    public MediaPeriodId copyWithPeriodUid(Object obj) {
        if (this.periodUid.equals(obj)) {
            return this;
        }
        return new MediaPeriodId(obj, this.adGroupIndex, this.adIndexInAdGroup, this.windowSequenceNumber, this.nextAdGroupIndex);
    }

    public MediaPeriodId copyWithWindowSequenceNumber(long j11) {
        if (this.windowSequenceNumber == j11) {
            return this;
        }
        return new MediaPeriodId(this.periodUid, this.adGroupIndex, this.adIndexInAdGroup, j11, this.nextAdGroupIndex);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaPeriodId)) {
            return false;
        }
        MediaPeriodId mediaPeriodId = (MediaPeriodId) obj;
        if (this.periodUid.equals(mediaPeriodId.periodUid) && this.adGroupIndex == mediaPeriodId.adGroupIndex && this.adIndexInAdGroup == mediaPeriodId.adIndexInAdGroup && this.windowSequenceNumber == mediaPeriodId.windowSequenceNumber && this.nextAdGroupIndex == mediaPeriodId.nextAdGroupIndex) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((527 + this.periodUid.hashCode()) * 31) + this.adGroupIndex) * 31) + this.adIndexInAdGroup) * 31) + ((int) this.windowSequenceNumber)) * 31) + this.nextAdGroupIndex;
    }

    public boolean isAd() {
        return this.adGroupIndex != -1;
    }

    public MediaPeriodId(Object obj, long j11) {
        this(obj, -1, -1, j11, -1);
    }

    public MediaPeriodId(Object obj, long j11, int i11) {
        this(obj, -1, -1, j11, i11);
    }

    public MediaPeriodId(Object obj, int i11, int i12, long j11) {
        this(obj, i11, i12, j11, -1);
    }

    public MediaPeriodId(MediaPeriodId mediaPeriodId) {
        this.periodUid = mediaPeriodId.periodUid;
        this.adGroupIndex = mediaPeriodId.adGroupIndex;
        this.adIndexInAdGroup = mediaPeriodId.adIndexInAdGroup;
        this.windowSequenceNumber = mediaPeriodId.windowSequenceNumber;
        this.nextAdGroupIndex = mediaPeriodId.nextAdGroupIndex;
    }

    private MediaPeriodId(Object obj, int i11, int i12, long j11, int i13) {
        this.periodUid = obj;
        this.adGroupIndex = i11;
        this.adIndexInAdGroup = i12;
        this.windowSequenceNumber = j11;
        this.nextAdGroupIndex = i13;
    }
}
