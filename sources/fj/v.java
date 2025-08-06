package fj;

import android.view.View;
import com.huobi.contract.viewhandler.SwapCollectionMarketNewHandler;
import com.huobi.homemarket.bean.MarketSwapPriceItem;
import v9.c;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SwapCollectionMarketNewHandler f54645b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54646c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketSwapPriceItem f54647d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54648e;

    public /* synthetic */ v(SwapCollectionMarketNewHandler swapCollectionMarketNewHandler, c cVar, MarketSwapPriceItem marketSwapPriceItem, int i11) {
        this.f54645b = swapCollectionMarketNewHandler;
        this.f54646c = cVar;
        this.f54647d = marketSwapPriceItem;
        this.f54648e = i11;
    }

    public final void onClick(View view) {
        this.f54645b.d0(this.f54646c, this.f54647d, this.f54648e, view);
    }
}
