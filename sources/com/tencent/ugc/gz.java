package com.tencent.ugc;

import com.tencent.ugc.videoprocessor.VideoProcessManager;

final /* synthetic */ class gz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoProcessManager f50587a;

    private gz(VideoProcessManager videoProcessManager) {
        this.f50587a = videoProcessManager;
    }

    public static Runnable a(VideoProcessManager videoProcessManager) {
        return new gz(videoProcessManager);
    }

    public final void run() {
        this.f50587a.initialize();
    }
}
