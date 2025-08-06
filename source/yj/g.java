package yj;

import android.view.View;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f61747b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f61748c;

    public /* synthetic */ g(View view, View view2) {
        this.f61747b = view;
        this.f61748c = view2;
    }

    public final void run() {
        this.f61747b.scrollTo(this.f61748c.getLeft(), this.f61748c.getTop());
    }
}
