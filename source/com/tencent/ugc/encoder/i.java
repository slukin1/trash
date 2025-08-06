package com.tencent.ugc.encoder;

import android.media.MediaFormat;
import com.tencent.ugc.encoder.HardwareVideoEncoder;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoEncoder.AnonymousClass1 f50449a;

    /* renamed from: b  reason: collision with root package name */
    private final MediaFormat f50450b;

    private i(HardwareVideoEncoder.AnonymousClass1 r12, MediaFormat mediaFormat) {
        this.f50449a = r12;
        this.f50450b = mediaFormat;
    }

    public static Runnable a(HardwareVideoEncoder.AnonymousClass1 r12, MediaFormat mediaFormat) {
        return new i(r12, mediaFormat);
    }

    public final void run() {
        HardwareVideoEncoder.AnonymousClass1.a(this.f50449a, this.f50450b);
    }
}
