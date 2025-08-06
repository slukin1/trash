package gp;

import android.view.View;
import gp.g;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f54858b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f54859c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ g.f f54860d;

    public /* synthetic */ f(g gVar, View view, g.f fVar) {
        this.f54858b = gVar;
        this.f54859c = view;
        this.f54860d = fVar;
    }

    public final void run() {
        this.f54858b.t(this.f54859c, this.f54860d);
    }
}
