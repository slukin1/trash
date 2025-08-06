package vp;

import android.animation.ValueAnimator;
import android.view.View;
import com.huobi.otc.widget.LiteOrderPaymentCollapsingCard;

public final /* synthetic */ class w implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f61186b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61187c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61188d;

    public /* synthetic */ w(View view, int i11, int i12) {
        this.f61186b = view;
        this.f61187c = i11;
        this.f61188d = i12;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        LiteOrderPaymentCollapsingCard.f(this.f61186b, this.f61187c, this.f61188d, valueAnimator);
    }
}
