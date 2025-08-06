package com.tencent.liteav.videoproducer.capture.b;

import android.hardware.camera2.CaptureRequest;
import com.tencent.liteav.videoproducer.capture.b.a;

final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a.AnonymousClass4 f22599a;

    /* renamed from: b  reason: collision with root package name */
    private final CaptureRequest f22600b;

    private d(a.AnonymousClass4 r12, CaptureRequest captureRequest) {
        this.f22599a = r12;
        this.f22600b = captureRequest;
    }

    public static Runnable a(a.AnonymousClass4 r12, CaptureRequest captureRequest) {
        return new d(r12, captureRequest);
    }

    public final void run() {
        a.AnonymousClass4.a(this.f22599a, this.f22600b);
    }
}
