package eo;

import android.view.View;
import com.huobi.main.trade.ui.TradeCompareDialogFragment;

public final /* synthetic */ class f implements View.OnScrollChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TradeCompareDialogFragment f54372a;

    public /* synthetic */ f(TradeCompareDialogFragment tradeCompareDialogFragment) {
        this.f54372a = tradeCompareDialogFragment;
    }

    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
        this.f54372a.Wh(view, i11, i12, i13, i14);
    }
}
