package androidx.camera.video.internal.encoder;

import android.media.MediaFormat;
import androidx.camera.video.internal.encoder.EncoderImpl;

public final /* synthetic */ class z0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EncoderImpl.e f6291b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MediaFormat f6292c;

    public /* synthetic */ z0(EncoderImpl.e eVar, MediaFormat mediaFormat) {
        this.f6291b = eVar;
        this.f6292c = mediaFormat;
    }

    public final void run() {
        this.f6291b.r(this.f6292c);
    }
}
