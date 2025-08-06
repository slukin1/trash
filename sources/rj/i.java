package rj;

import vj.a;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f25682b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f25683c;

    public /* synthetic */ i(a aVar, Object obj) {
        this.f25682b = aVar;
        this.f25683c = obj;
    }

    public final void run() {
        this.f25682b.onCallback(this.f25683c);
    }
}
