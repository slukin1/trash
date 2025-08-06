package wj;

import com.huobi.edgeengine.node.trace.ArrayListener;
import com.huobi.edgeengine.node.trace.TraceMap;

public final /* synthetic */ class a implements TraceMap.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ArrayListener f61357a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayListener.a f61358b;

    public /* synthetic */ a(ArrayListener arrayListener, ArrayListener.a aVar) {
        this.f61357a = arrayListener;
        this.f61358b = aVar;
    }

    public final void destroy() {
        this.f61357a.k(this.f61358b);
    }
}
