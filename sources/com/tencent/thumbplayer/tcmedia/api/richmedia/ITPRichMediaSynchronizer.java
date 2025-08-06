package com.tencent.thumbplayer.tcmedia.api.richmedia;

public interface ITPRichMediaSynchronizer {
    void deselectFeatureAsync(int i11);

    TPRichMediaFeature[] getFeatures();

    void prepareAsync();

    void release();

    void reset();

    void selectFeatureAsync(int i11, TPRichMediaRequestExtraInfo tPRichMediaRequestExtraInfo);

    void setListener(ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener);

    void setRichMediaSource(String str);
}
