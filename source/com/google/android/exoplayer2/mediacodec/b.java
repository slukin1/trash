package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MediaCodec f65933b;

    public /* synthetic */ b(MediaCodec mediaCodec) {
        this.f65933b = mediaCodec;
    }

    public final void run() {
        this.f65933b.start();
    }
}
