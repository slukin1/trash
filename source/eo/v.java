package eo;

import android.view.View;
import com.huobi.main.trade.ui.TradeDialogFragment;

public final /* synthetic */ class v implements View.OnScrollChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TradeDialogFragment f54391a;

    public /* synthetic */ v(TradeDialogFragment tradeDialogFragment) {
        this.f54391a = tradeDialogFragment;
    }

    public final void onScrollChange(View view, int i11, int i12, int i13, int i14) {
        this.f54391a.fi(view, i11, i12, i13, i14);
    }
}
