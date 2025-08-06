package wj;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.huobi.edgeengine.node.trace.a;

public final /* synthetic */ class u implements JavaCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f61372a;

    public /* synthetic */ u(a aVar) {
        this.f61372a = aVar;
    }

    public final Object invoke(V8Object v8Object, V8Array v8Array) {
        return this.f61372a.s(v8Object, v8Array);
    }
}
