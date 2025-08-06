package androidx.camera.camera2.internal;

import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class i implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f5149a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f5150b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f5151c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f5152d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f5153e;

    public /* synthetic */ i(u uVar, List list, int i11, int i12, int i13) {
        this.f5149a = uVar;
        this.f5150b = list;
        this.f5151c = i11;
        this.f5152d = i12;
        this.f5153e = i13;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f5149a.M(this.f5150b, this.f5151c, this.f5152d, this.f5153e, (Void) obj);
    }
}
