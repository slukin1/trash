package ql;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.huobi.homemarket.handler.AbsMarketViewHandler;

public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f60012b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60013c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f60014d;

    public /* synthetic */ a(ViewGroup.LayoutParams layoutParams, int i11, View view) {
        this.f60012b = layoutParams;
        this.f60013c = i11;
        this.f60014d = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        AbsMarketViewHandler.C(this.f60012b, this.f60013c, this.f60014d, valueAnimator);
    }
}
