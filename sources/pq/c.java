package pq;

import android.widget.RadioGroup;
import com.huobi.quicktrade.order.ui.QuickTradeOrderBaseFragment;

public final /* synthetic */ class c implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickTradeOrderBaseFragment f53209b;

    public /* synthetic */ c(QuickTradeOrderBaseFragment quickTradeOrderBaseFragment) {
        this.f53209b = quickTradeOrderBaseFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int i11) {
        this.f53209b.Jh(radioGroup, i11);
    }
}
