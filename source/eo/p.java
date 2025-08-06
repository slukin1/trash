package eo;

import android.widget.RadioButton;
import com.huobi.main.trade.ui.TradeDialogFragment;

public final /* synthetic */ class p implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeDialogFragment f54384b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ RadioButton f54385c;

    public /* synthetic */ p(TradeDialogFragment tradeDialogFragment, RadioButton radioButton) {
        this.f54384b = tradeDialogFragment;
        this.f54385c = radioButton;
    }

    public final void run() {
        this.f54384b.ci(this.f54385c);
    }
}
