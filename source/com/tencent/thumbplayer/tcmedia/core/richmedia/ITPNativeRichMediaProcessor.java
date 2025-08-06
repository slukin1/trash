package com.tencent.thumbplayer.tcmedia.core.richmedia;

public interface ITPNativeRichMediaProcessor {
    void deselectFeatureAsync(int i11);

    TPNativeRichMediaFeatureData getCurrentPositionMsFeatureData(long j11, int[] iArr);

    TPNativeRichMediaFeature[] getFeatures();

    void prepareAsync();

    void release();

    void reset();

    void seek(long j11);

    void selectFeatureAsync(int i11, TPNativeRichMediaRequestExtraInfo tPNativeRichMediaRequestExtraInfo);

    void setInnerProcessorCallback(ITPNativeRichMediaInnerProcessorCallback iTPNativeRichMediaInnerProcessorCallback);

    void setPlaybackRate(float f11);

    void setProcessorCallback(ITPNativeRichMediaProcessorCallback iTPNativeRichMediaProcessorCallback);

    void setRichMediaSource(String str);
}
