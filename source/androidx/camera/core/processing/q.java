package androidx.camera.core.processing;

import androidx.camera.core.ImageProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ InternalImageProcessor f5683b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageProcessor.Request f5684c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f5685d;

    public /* synthetic */ q(InternalImageProcessor internalImageProcessor, ImageProcessor.Request request, CallbackToFutureAdapter.a aVar) {
        this.f5683b = internalImageProcessor;
        this.f5684c = request;
        this.f5685d = aVar;
    }

    public final void run() {
        this.f5683b.lambda$safeProcess$0(this.f5684c, this.f5685d);
    }
}
