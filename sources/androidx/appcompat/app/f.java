package androidx.appcompat.app;

import androidx.appcompat.app.g;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g.a f3927b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f3928c;

    public /* synthetic */ f(g.a aVar, Runnable runnable) {
        this.f3927b = aVar;
        this.f3928c = runnable;
    }

    public final void run() {
        this.f3927b.b(this.f3928c);
    }
}
