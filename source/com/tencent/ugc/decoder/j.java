package com.tencent.ugc.decoder;

import android.graphics.SurfaceTexture;

final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodecOutputOESTextureDecoder f50344a;

    /* renamed from: b  reason: collision with root package name */
    private final SurfaceTexture f50345b;

    private j(MediaCodecOutputOESTextureDecoder mediaCodecOutputOESTextureDecoder, SurfaceTexture surfaceTexture) {
        this.f50344a = mediaCodecOutputOESTextureDecoder;
        this.f50345b = surfaceTexture;
    }

    public static Runnable a(MediaCodecOutputOESTextureDecoder mediaCodecOutputOESTextureDecoder, SurfaceTexture surfaceTexture) {
        return new j(mediaCodecOutputOESTextureDecoder, surfaceTexture);
    }

    public final void run() {
        MediaCodecOutputOESTextureDecoder.lambda$onFrameAvailable$0(this.f50344a, this.f50345b);
    }
}
