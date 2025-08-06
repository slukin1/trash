package fj;

import android.view.View;
import com.huobi.contract.viewhandler.SwapMarketNewHandler;
import com.huobi.homemarket.bean.MarketSwapPriceItem;
import v9.c;

public final /* synthetic */ class y implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketSwapPriceItem f54655b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54656c;

    public /* synthetic */ y(MarketSwapPriceItem marketSwapPriceItem, c cVar) {
        this.f54655b = marketSwapPriceItem;
        this.f54656c = cVar;
    }

    public final boolean onLongClick(View view) {
        return SwapMarketNewHandler.e0(this.f54655b, this.f54656c, view);
    }
}
