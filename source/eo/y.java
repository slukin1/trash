package eo;

import android.widget.RadioGroup;
import com.huobi.main.trade.ui.TradeDialogFragment;
import i6.r;

public final /* synthetic */ class y implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeDialogFragment f54397b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f54398c;

    public /* synthetic */ y(TradeDialogFragment tradeDialogFragment, r rVar) {
        this.f54397b = tradeDialogFragment;
        this.f54398c = rVar;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
        this.f54397b.di(this.f54398c, radioGroup, i11);
    }
}
