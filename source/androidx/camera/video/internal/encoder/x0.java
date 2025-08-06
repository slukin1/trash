package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class x0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f6283b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaCodec.BufferInfo f6284c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MediaCodec f6285d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f6286e;

    public /* synthetic */ x0(EncoderImpl.e eVar, MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i11) {
        this.f6283b = eVar;
        this.f6284c = bufferInfo;
        this.f6285d = mediaCodec;
        this.f6286e = i11;
    }

    public final void run() {
        this.f6283b.o(this.f6284c, this.f6285d, this.f6286e);
    }
}
