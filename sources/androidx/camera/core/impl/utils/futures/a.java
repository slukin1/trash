package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class a implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ListenableFuture f5591a;

    public /* synthetic */ a(ListenableFuture listenableFuture) {
        this.f5591a = listenableFuture;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return Futures.propagateTransform(false, this.f5591a, Futures.IDENTITY_FUNCTION, aVar, CameraXExecutors.directExecutor());
    }
}
