package com.tencent.thumbplayer.tcmedia.api.composition;

public interface ITPMediaTrackClip extends ITPMediaAsset {
    ITPMediaTrackClip clone(int i11);

    int getClipId();

    long getEndTimeMs();

    String getFilePath();

    long getOriginalDurationMs();

    long getStartPositionMs();

    long getStartTimeMs();

    void setCutTimeRange(long j11, long j12);

    void setOriginalDurationMs(long j11);

    void setStartPositionMs(long j11);
}
