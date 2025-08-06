package fj;

import android.view.View;
import com.huobi.contract.viewhandler.LinearSwapMarketNewHandler;
import com.huobi.homemarket.bean.MarketLinearSwapPriceItem;
import v9.c;

public final /* synthetic */ class t implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketLinearSwapPriceItem f54642b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54643c;

    public /* synthetic */ t(MarketLinearSwapPriceItem marketLinearSwapPriceItem, c cVar) {
        this.f54642b = marketLinearSwapPriceItem;
        this.f54643c = cVar;
    }

    public final boolean onLongClick(View view) {
        return LinearSwapMarketNewHandler.f0(this.f54642b, this.f54643c, view);
    }
}
