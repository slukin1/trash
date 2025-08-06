package au;

import android.animation.ValueAnimator;
import com.huobi.tradingbot.ui.ContractGridActivity;

public final /* synthetic */ class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractGridActivity f12218b;

    public /* synthetic */ h(ContractGridActivity contractGridActivity) {
        this.f12218b = contractGridActivity;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        ContractGridActivity.gi(this.f12218b, valueAnimator);
    }
}
