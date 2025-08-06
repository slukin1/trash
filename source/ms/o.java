package ms;

import com.huobi.supermargin.ui.TradeVerticalSuperMarginFragment;

public final /* synthetic */ class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSuperMarginFragment f58265b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58266c;

    public /* synthetic */ o(TradeVerticalSuperMarginFragment tradeVerticalSuperMarginFragment, boolean z11) {
        this.f58265b = tradeVerticalSuperMarginFragment;
        this.f58266c = z11;
    }

    public final void run() {
        this.f58265b.pm(this.f58266c);
    }
}
