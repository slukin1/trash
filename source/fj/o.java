package fj;

import android.view.View;
import com.huobi.contract.viewhandler.IndexMarketNewHandler;
import com.huobi.homemarket.bean.MarketIndexPriceItem;
import v9.c;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexMarketNewHandler f54626b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54627c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketIndexPriceItem f54628d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54629e;

    public /* synthetic */ o(IndexMarketNewHandler indexMarketNewHandler, c cVar, MarketIndexPriceItem marketIndexPriceItem, int i11) {
        this.f54626b = indexMarketNewHandler;
        this.f54627c = cVar;
        this.f54628d = marketIndexPriceItem;
        this.f54629e = i11;
    }

    public final void onClick(View view) {
        this.f54626b.c0(this.f54627c, this.f54628d, this.f54629e, view);
    }
}
