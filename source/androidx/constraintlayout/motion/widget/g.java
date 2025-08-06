package androidx.constraintlayout.motion.widget;

import android.view.View;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h f7759b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View[] f7760c;

    public /* synthetic */ g(h hVar, View[] viewArr) {
        this.f7759b = hVar;
        this.f7760c = viewArr;
    }

    public final void run() {
        this.f7759b.j(this.f7760c);
    }
}
