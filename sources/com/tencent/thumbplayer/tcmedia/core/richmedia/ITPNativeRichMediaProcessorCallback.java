package com.tencent.thumbplayer.tcmedia.core.richmedia;

public interface ITPNativeRichMediaProcessorCallback {
    void onDeselectFeatureSuccess(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11);

    void onRichMediaError(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11);

    void onRichMediaFeatureData(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11, TPNativeRichMediaFeatureData tPNativeRichMediaFeatureData);

    void onRichMediaFeatureFailure(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11, int i12);

    void onRichMediaInfo(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11, long j11, long j12, long j13, Object obj);

    void onRichMediaPrepared(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor);

    void onSelectFeatureSuccess(ITPNativeRichMediaProcessor iTPNativeRichMediaProcessor, int i11);
}
