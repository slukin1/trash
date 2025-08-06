package androidx.camera.core.processing;

import androidx.camera.core.ImageProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class p implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InternalImageProcessor f5681a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ImageProcessor.Request f5682b;

    public /* synthetic */ p(InternalImageProcessor internalImageProcessor, ImageProcessor.Request request) {
        this.f5681a = internalImageProcessor;
        this.f5682b = request;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5681a.lambda$safeProcess$1(this.f5682b, aVar);
    }
}
