package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

public final /* synthetic */ class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentTransitionImpl f9712b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f9713c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Rect f9714d;

    public /* synthetic */ e(FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        this.f9712b = fragmentTransitionImpl;
        this.f9713c = view;
        this.f9714d = rect;
    }

    public final void run() {
        DefaultSpecialEffectsController.M(this.f9712b, this.f9713c, this.f9714d);
    }
}
