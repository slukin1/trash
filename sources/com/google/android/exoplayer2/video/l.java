package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.video.VideoRendererEventListener;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher f66116b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f66117c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ long f66118d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ long f66119e;

    public /* synthetic */ l(VideoRendererEventListener.EventDispatcher eventDispatcher, String str, long j11, long j12) {
        this.f66116b = eventDispatcher;
        this.f66117c = str;
        this.f66118d = j11;
        this.f66119e = j12;
    }

    public final void run() {
        this.f66116b.lambda$decoderInitialized$1(this.f66117c, this.f66118d, this.f66119e);
    }
}
