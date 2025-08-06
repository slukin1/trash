package rj;

import android.content.Context;
import com.huobi.edgeengine.node.trace.TraceMap;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f25694b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f25695c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TraceMap f25696d;

    public /* synthetic */ r(x xVar, Context context, TraceMap traceMap) {
        this.f25694b = xVar;
        this.f25695c = context;
        this.f25696d = traceMap;
    }

    public final void run() {
        this.f25694b.l(this.f25695c, this.f25696d);
    }
}
