package eo;

import android.widget.CompoundButton;
import com.huobi.main.trade.ui.TradeDialogFragment;

public final /* synthetic */ class x implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeDialogFragment f54395b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54396c;

    public /* synthetic */ x(TradeDialogFragment tradeDialogFragment, String str) {
        this.f54395b = tradeDialogFragment;
        this.f54396c = str;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
        this.f54395b.ii(this.f54396c, compoundButton, z11);
    }
}
