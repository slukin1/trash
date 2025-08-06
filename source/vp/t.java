package vp;

import android.animation.ValueAnimator;
import android.view.View;
import com.huobi.otc.widget.LiteOrderCollapsingCard;

public final /* synthetic */ class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f61178b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f61179c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61180d;

    public /* synthetic */ t(View view, int i11, int i12) {
        this.f61178b = view;
        this.f61179c = i11;
        this.f61180d = i12;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        LiteOrderCollapsingCard.f(this.f61178b, this.f61179c, this.f61180d, valueAnimator);
    }
}
