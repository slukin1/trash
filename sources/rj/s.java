package rj;

import android.content.Context;
import com.huobi.edgeengine.node.trace.TraceMap;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f25697b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f25698c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TraceMap f25699d;

    public /* synthetic */ s(x xVar, Context context, TraceMap traceMap) {
        this.f25697b = xVar;
        this.f25698c = context;
        this.f25699d = traceMap;
    }

    public final void run() {
        this.f25697b.k(this.f25698c, this.f25699d);
    }
}
