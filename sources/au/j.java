package au;

import android.animation.ValueAnimator;
import com.huobi.tradingbot.ui.ContractGridActivity;

public final /* synthetic */ class j implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractGridActivity f12220b;

    public /* synthetic */ j(ContractGridActivity contractGridActivity) {
        this.f12220b = contractGridActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ContractGridActivity.bi(this.f12220b, valueAnimator);
    }
}
