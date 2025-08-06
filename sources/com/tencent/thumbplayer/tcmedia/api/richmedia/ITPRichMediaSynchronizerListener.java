package com.tencent.thumbplayer.tcmedia.api.richmedia;

public interface ITPRichMediaSynchronizerListener {
    void onDeselectFeatureSuccess(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i11);

    void onRichMediaError(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i11);

    void onRichMediaFeatureData(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i11, TPRichMediaFeatureData tPRichMediaFeatureData);

    void onRichMediaFeatureFailure(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i11, int i12);

    void onRichMediaInfo(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i11, long j11, long j12, long j13, Object obj);

    void onRichMediaPrepared(ITPRichMediaSynchronizer iTPRichMediaSynchronizer);

    void onSelectFeatureSuccess(ITPRichMediaSynchronizer iTPRichMediaSynchronizer, int i11);
}
