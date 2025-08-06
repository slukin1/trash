package sq;

import android.view.View;
import com.huobi.quicktrade.trade.ui.QuickTradeVerticalBaseFragment;

public final /* synthetic */ class p implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuickTradeVerticalBaseFragment f26137b;

    public /* synthetic */ p(QuickTradeVerticalBaseFragment quickTradeVerticalBaseFragment) {
        this.f26137b = quickTradeVerticalBaseFragment;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f26137b.yi(view, z11);
    }
}
