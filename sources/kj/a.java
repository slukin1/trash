package kj;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.data.ExchangeModuleCallbackImpl;
import com.huobi.main.trade.ui.TradeDialogFragment;

public final /* synthetic */ class a implements TradeDialogFragment.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExchangeModuleCallbackImpl f56578a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ wc.a f56579b;

    public /* synthetic */ a(ExchangeModuleCallbackImpl exchangeModuleCallbackImpl, wc.a aVar) {
        this.f56578a = exchangeModuleCallbackImpl;
        this.f56579b = aVar;
    }

    public final void a(TradeType tradeType, s9.a aVar) {
        this.f56578a.s(this.f56579b, tradeType, aVar);
    }
}
