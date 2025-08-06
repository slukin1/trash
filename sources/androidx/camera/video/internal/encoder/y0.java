package androidx.camera.video.internal.encoder;

import android.media.MediaCodec;
import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class y0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f6288b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaCodec.CodecException f6289c;

    public /* synthetic */ y0(EncoderImpl.e eVar, MediaCodec.CodecException codecException) {
        this.f6288b = eVar;
        this.f6289c = codecException;
    }

    public final void run() {
        this.f6288b.l(this.f6289c);
    }
}
