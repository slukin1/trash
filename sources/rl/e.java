package rl;

import android.widget.PopupWindow;
import com.huobi.homemarket.helper.MarketContentGuideHelper;

public final /* synthetic */ class e implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketContentGuideHelper f25732b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25733c;

    public /* synthetic */ e(MarketContentGuideHelper marketContentGuideHelper, String str) {
        this.f25732b = marketContentGuideHelper;
        this.f25733c = str;
    }

    public final void onDismiss() {
        this.f25732b.lambda$showFreshItemGuide$2(this.f25733c);
    }
}
