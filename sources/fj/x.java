package fj;

import android.view.View;
import com.huobi.contract.viewhandler.SwapMarketNewHandler;
import com.huobi.homemarket.bean.MarketSwapPriceItem;
import v9.c;

public final /* synthetic */ class x implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapMarketNewHandler f54651b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54652c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketSwapPriceItem f54653d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54654e;

    public /* synthetic */ x(SwapMarketNewHandler swapMarketNewHandler, c cVar, MarketSwapPriceItem marketSwapPriceItem, int i11) {
        this.f54651b = swapMarketNewHandler;
        this.f54652c = cVar;
        this.f54653d = marketSwapPriceItem;
        this.f54654e = i11;
    }

    public final void onClick(View view) {
        this.f54651b.d0(this.f54652c, this.f54653d, this.f54654e, view);
    }
}
