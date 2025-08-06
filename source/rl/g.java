package rl;

import android.content.DialogInterface;
import android.view.View;
import com.hbg.lib.core.ui.BaseFragment;
import com.huobi.homemarket.helper.MarketContentGuideHelper;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketContentGuideHelper f25737b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f25738c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ BaseFragment f25739d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnDismissListener f25740e;

    public /* synthetic */ g(MarketContentGuideHelper marketContentGuideHelper, View view, BaseFragment baseFragment, DialogInterface.OnDismissListener onDismissListener) {
        this.f25737b = marketContentGuideHelper;
        this.f25738c = view;
        this.f25739d = baseFragment;
        this.f25740e = onDismissListener;
    }

    public final void run() {
        this.f25737b.lambda$showMarketStareGuide$5(this.f25738c, this.f25739d, this.f25740e);
    }
}
