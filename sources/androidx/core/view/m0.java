package androidx.core.view;

import android.animation.ValueAnimator;
import android.view.View;

public final /* synthetic */ class m0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ p0 f8658b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f8659c;

    public /* synthetic */ m0(p0 p0Var, View view) {
        this.f8658b = p0Var;
        this.f8659c = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f8658b.a(this.f8659c);
    }
}
