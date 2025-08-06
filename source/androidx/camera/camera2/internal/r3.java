package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.List;
import o.z;
import p.l;

public final /* synthetic */ class r3 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ v3 f5290a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f5291b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ z f5292c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l f5293d;

    public /* synthetic */ r3(v3 v3Var, List list, z zVar, l lVar) {
        this.f5290a = v3Var;
        this.f5291b = list;
        this.f5292c = zVar;
        this.f5293d = lVar;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5290a.E(this.f5291b, this.f5292c, this.f5293d, aVar);
    }
}
