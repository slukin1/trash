package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.x0;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class b1 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x0.c f5022a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f5023b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5024c;

    public /* synthetic */ b1(x0.c cVar, List list, int i11) {
        this.f5022a = cVar;
        this.f5023b = list;
        this.f5024c = i11;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f5022a.m(this.f5023b, this.f5024c, (TotalCaptureResult) obj);
    }
}
