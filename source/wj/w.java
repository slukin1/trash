package wj;

import com.huobi.edgeengine.node.trace.TraceListener;
import com.huobi.edgeengine.node.trace.TraceMap;
import vj.a;

public final /* synthetic */ class w implements TraceMap.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TraceListener f61373a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f61374b;

    public /* synthetic */ w(TraceListener traceListener, a aVar) {
        this.f61373a = traceListener;
        this.f61374b = aVar;
    }

    public final void destroy() {
        this.f61373a.f(this.f61374b);
    }
}
