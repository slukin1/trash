package e0;

import androidx.camera.core.CameraInfo;
import androidx.camera.view.a;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;

public final /* synthetic */ class d implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f54234a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraInfo f54235b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f54236c;

    public /* synthetic */ d(a aVar, CameraInfo cameraInfo, List list) {
        this.f54234a = aVar;
        this.f54235b = cameraInfo;
        this.f54236c = list;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f54234a.h(this.f54235b, this.f54236c, aVar);
    }
}
