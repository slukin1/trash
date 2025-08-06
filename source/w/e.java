package w;

import androidx.camera.core.CameraX;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class e implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CameraX f61218a;

    public /* synthetic */ e(CameraX cameraX) {
        this.f61218a = cameraX;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f61218a.getInitializeFuture();
    }
}
