package com.tencent.thumbplayer.tcmedia.api.richmedia;

import com.tencent.thumbplayer.tcmedia.api.TPTimeRange;

public interface ITPRichMediaAsyncRequester {
    void cancelRequest(int i11);

    TPRichMediaFeature[] getFeatures();

    void prepareAsync();

    void release();

    int requestFeatureDataAsyncAtTimeMs(int i11, long j11);

    int requestFeatureDataAsyncAtTimeMsArray(int i11, long[] jArr);

    int requestFeatureDataAsyncAtTimeRange(int i11, TPTimeRange tPTimeRange);

    int requestFeatureDataAsyncAtTimeRanges(int i11, TPTimeRange[] tPTimeRangeArr);

    void setRequesterListener(ITPRichMediaAsyncRequesterListener iTPRichMediaAsyncRequesterListener);

    void setRichMediaSource(String str);
}
