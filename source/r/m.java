package r;

import android.hardware.camera2.CameraDevice;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import p.l;
import r.o;

public final /* synthetic */ class m implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ o.b f70497a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CameraDevice f70498b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l f70499c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f70500d;

    public /* synthetic */ m(o.b bVar, CameraDevice cameraDevice, l lVar, List list) {
        this.f70497a = bVar;
        this.f70498b = cameraDevice;
        this.f70499c = lVar;
        this.f70500d = list;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f70497a.a(this.f70498b, this.f70499c, this.f70500d);
    }
}
