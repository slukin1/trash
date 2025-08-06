package vp;

import android.animation.ValueAnimator;
import android.view.View;
import com.huobi.otc.widget.LiteNewOrderCollapsingCard;

public final /* synthetic */ class o implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f61164b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61165c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61166d;

    public /* synthetic */ o(View view, int i11, int i12) {
        this.f61164b = view;
        this.f61165c = i11;
        this.f61166d = i12;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        LiteNewOrderCollapsingCard.f(this.f61164b, this.f61165c, this.f61166d, valueAnimator);
    }
}
