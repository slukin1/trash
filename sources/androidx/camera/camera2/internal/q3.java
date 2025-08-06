package androidx.camera.camera2.internal;

import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public final /* synthetic */ class q3 implements AsyncFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v3 f5282a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f5283b;

    public /* synthetic */ q3(v3 v3Var, List list) {
        this.f5282a = v3Var;
        this.f5283b = list;
    }

    public final ListenableFuture apply(Object obj) {
        return this.f5282a.F(this.f5283b, (List) obj);
    }
}
