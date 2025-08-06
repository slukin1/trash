package fj;

import android.view.View;
import com.huobi.contract.viewhandler.LinearSwapCollectionMarketNewHandler;
import com.huobi.homemarket.bean.MarketLinearSwapPriceItem;
import v9.c;

public final /* synthetic */ class r implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketLinearSwapPriceItem f54636b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54637c;

    public /* synthetic */ r(MarketLinearSwapPriceItem marketLinearSwapPriceItem, c cVar) {
        this.f54636b = marketLinearSwapPriceItem;
        this.f54637c = cVar;
    }

    public final boolean onLongClick(View view) {
        return LinearSwapCollectionMarketNewHandler.f0(this.f54636b, this.f54637c, view);
    }
}
