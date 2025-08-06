package com.tencent.ugc.encoder;

import android.view.Surface;
import com.tencent.liteav.base.util.Size;
import com.tencent.ugc.encoder.VideoEncoderInterface;

final /* synthetic */ class t implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SurfaceInputVideoEncoder f50465a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoEncoderInterface.VideoEncoderListener f50466b;

    /* renamed from: c  reason: collision with root package name */
    private final Surface[] f50467c;

    /* renamed from: d  reason: collision with root package name */
    private final VideoEncodeParams f50468d;

    /* renamed from: e  reason: collision with root package name */
    private final Size[] f50469e;

    private t(SurfaceInputVideoEncoder surfaceInputVideoEncoder, VideoEncoderInterface.VideoEncoderListener videoEncoderListener, Surface[] surfaceArr, VideoEncodeParams videoEncodeParams, Size[] sizeArr) {
        this.f50465a = surfaceInputVideoEncoder;
        this.f50466b = videoEncoderListener;
        this.f50467c = surfaceArr;
        this.f50468d = videoEncodeParams;
        this.f50469e = sizeArr;
    }

    public static Runnable a(SurfaceInputVideoEncoder surfaceInputVideoEncoder, VideoEncoderInterface.VideoEncoderListener videoEncoderListener, Surface[] surfaceArr, VideoEncodeParams videoEncodeParams, Size[] sizeArr) {
        return new t(surfaceInputVideoEncoder, videoEncoderListener, surfaceArr, videoEncodeParams, sizeArr);
    }

    public final void run() {
        SurfaceInputVideoEncoder.lambda$start$1(this.f50465a, this.f50466b, this.f50467c, this.f50468d, this.f50469e);
    }
}
