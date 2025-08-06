package androidx.camera.core;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class d implements RejectedExecutionHandler {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ d f5502a = new d();

    public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        Logger.e(CameraExecutor.TAG, "A rejected execution occurred in CameraExecutor!");
    }
}
