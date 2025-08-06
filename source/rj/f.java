package rj;

import com.huobi.edgeengine.node.trace.ArrayListener;
import java.util.List;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayListener.a f25672b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f25673c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f25674d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f25675e;

    public /* synthetic */ f(ArrayListener.a aVar, int i11, List list, List list2) {
        this.f25672b = aVar;
        this.f25673c = i11;
        this.f25674d = list;
        this.f25675e = list2;
    }

    public final void run() {
        this.f25672b.a(this.f25673c, this.f25674d, this.f25675e);
    }
}
