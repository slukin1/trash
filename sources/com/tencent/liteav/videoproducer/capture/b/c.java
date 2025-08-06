package com.tencent.liteav.videoproducer.capture.b;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import com.tencent.liteav.videoproducer.capture.b.a;

final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final a.AnonymousClass4 f22596a;

    /* renamed from: b  reason: collision with root package name */
    private final TotalCaptureResult f22597b;

    /* renamed from: c  reason: collision with root package name */
    private final CaptureRequest f22598c;

    private c(a.AnonymousClass4 r12, TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
        this.f22596a = r12;
        this.f22597b = totalCaptureResult;
        this.f22598c = captureRequest;
    }

    public static Runnable a(a.AnonymousClass4 r12, TotalCaptureResult totalCaptureResult, CaptureRequest captureRequest) {
        return new c(r12, totalCaptureResult, captureRequest);
    }

    public final void run() {
        a.AnonymousClass4.a(this.f22596a, this.f22597b, this.f22598c);
    }
}
