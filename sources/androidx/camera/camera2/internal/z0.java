package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.x0;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class z0 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x0.c f5480a;

    public /* synthetic */ z0(x0.c cVar) {
        this.f5480a = cVar;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f5480a.l((Boolean) obj);
    }
}
