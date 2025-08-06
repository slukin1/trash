package com.google.android.exoplayer2.video;

@Deprecated
public interface VideoListener {
    void onRenderedFirstFrame();

    void onSurfaceSizeChanged(int i11, int i12);

    @Deprecated
    void onVideoSizeChanged(int i11, int i12, int i13, float f11);

    void onVideoSizeChanged(VideoSize videoSize);
}
