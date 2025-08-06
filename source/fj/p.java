package fj;

import android.view.View;
import com.huobi.contract.viewhandler.IndexMarketNewHandler;
import com.huobi.homemarket.bean.MarketIndexPriceItem;
import v9.c;

public final /* synthetic */ class p implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketIndexPriceItem f54630b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54631c;

    public /* synthetic */ p(MarketIndexPriceItem marketIndexPriceItem, c cVar) {
        this.f54630b = marketIndexPriceItem;
        this.f54631c = cVar;
    }

    public final boolean onLongClick(View view) {
        return IndexMarketNewHandler.d0(this.f54630b, this.f54631c, view);
    }
}
