package com.tencent.ugc.decoder;

import android.view.Surface;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodecHDRDecoder f50342a;

    /* renamed from: b  reason: collision with root package name */
    private final Surface f50343b;

    private i(MediaCodecHDRDecoder mediaCodecHDRDecoder, Surface surface) {
        this.f50342a = mediaCodecHDRDecoder;
        this.f50343b = surface;
    }

    public static Runnable a(MediaCodecHDRDecoder mediaCodecHDRDecoder, Surface surface) {
        return new i(mediaCodecHDRDecoder, surface);
    }

    public final void run() {
        this.f50342a.mOutputSurface = this.f50343b;
    }
}
