package rj;

import com.huobi.edgeengine.node.trace.ArrayListener;
import java.util.List;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayListener.a f25676b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f25677c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f25678d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ List f25679e;

    public /* synthetic */ g(ArrayListener.a aVar, int i11, List list, List list2) {
        this.f25676b = aVar;
        this.f25677c = i11;
        this.f25678d = list;
        this.f25679e = list2;
    }

    public final void run() {
        this.f25676b.a(this.f25677c, this.f25678d, this.f25679e);
    }
}
