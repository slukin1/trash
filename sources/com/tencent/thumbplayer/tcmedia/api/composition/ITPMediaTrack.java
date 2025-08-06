package com.tencent.thumbplayer.tcmedia.api.composition;

import java.util.List;

public interface ITPMediaTrack extends ITPMediaAsset {
    int addTrackClip(ITPMediaTrackClip iTPMediaTrackClip);

    List<ITPMediaTrackClip> getAllTrackClips();

    long getTimelineDurationMs();

    ITPMediaTrackClip getTrackClip(int i11);

    int getTrackId();

    int insertTrackClip(ITPMediaTrackClip iTPMediaTrackClip, int i11);

    void removeAllTrackClips();

    boolean removeTrackClip(ITPMediaTrackClip iTPMediaTrackClip);

    boolean swapTrackClip(int i11, int i12);
}
