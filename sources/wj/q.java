package wj;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.huobi.edgeengine.node.trace.a;

public final /* synthetic */ class q implements JavaCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f61368a;

    public /* synthetic */ q(a aVar) {
        this.f61368a = aVar;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        return this.f61368a.u(v8Object, v8Array);
    }
}
