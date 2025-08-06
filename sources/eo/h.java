package eo;

import android.widget.RadioButton;
import com.huobi.main.trade.ui.TradeCompareDialogFragment;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeCompareDialogFragment f54375b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RadioButton f54376c;

    public /* synthetic */ h(TradeCompareDialogFragment tradeCompareDialogFragment, RadioButton radioButton) {
        this.f54375b = tradeCompareDialogFragment;
        this.f54376c = radioButton;
    }

    public final void run() {
        this.f54375b.Uh(this.f54376c);
    }
}
