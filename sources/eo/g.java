package eo;

import android.widget.RadioGroup;
import com.huobi.main.trade.ui.TradeCompareDialogFragment;
import i6.r;

public final /* synthetic */ class g implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeCompareDialogFragment f54373b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ r f54374c;

    public /* synthetic */ g(TradeCompareDialogFragment tradeCompareDialogFragment, r rVar) {
        this.f54373b = tradeCompareDialogFragment;
        this.f54374c = rVar;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
        this.f54373b.Vh(this.f54374c, radioGroup, i11);
    }
}
