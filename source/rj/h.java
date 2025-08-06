package rj;

import vj.a;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f25680b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f25681c;

    public /* synthetic */ h(a aVar, Object obj) {
        this.f25680b = aVar;
        this.f25681c = obj;
    }

    public final void run() {
        this.f25680b.onCallback(this.f25681c);
    }
}
