package rl;

import android.content.DialogInterface;
import android.widget.PopupWindow;
import com.huobi.homemarket.helper.MarketContentGuideHelper;

public final /* synthetic */ class d implements PopupWindow.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketContentGuideHelper f25730b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnDismissListener f25731c;

    public /* synthetic */ d(MarketContentGuideHelper marketContentGuideHelper, DialogInterface.OnDismissListener onDismissListener) {
        this.f25730b = marketContentGuideHelper;
        this.f25731c = onDismissListener;
    }

    public final void onDismiss() {
        this.f25730b.lambda$showMarketStareGuide$4(this.f25731c);
    }
}
