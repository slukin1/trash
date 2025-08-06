package sq;

import android.view.View;
import com.huobi.quicktrade.trade.ui.QuickTradeVerticalBaseFragment;

public final /* synthetic */ class o implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickTradeVerticalBaseFragment f26136b;

    public /* synthetic */ o(QuickTradeVerticalBaseFragment quickTradeVerticalBaseFragment) {
        this.f26136b = quickTradeVerticalBaseFragment;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f26136b.Ai(view, z11);
    }
}
