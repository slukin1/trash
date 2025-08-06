package fj;

import android.view.View;
import com.huobi.contract.viewhandler.LinearSwapCollectionMarketNewHandler;
import com.huobi.homemarket.bean.MarketLinearSwapPriceItem;
import v9.c;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapCollectionMarketNewHandler f54632b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54633c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketLinearSwapPriceItem f54634d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54635e;

    public /* synthetic */ q(LinearSwapCollectionMarketNewHandler linearSwapCollectionMarketNewHandler, c cVar, MarketLinearSwapPriceItem marketLinearSwapPriceItem, int i11) {
        this.f54632b = linearSwapCollectionMarketNewHandler;
        this.f54633c = cVar;
        this.f54634d = marketLinearSwapPriceItem;
        this.f54635e = i11;
    }

    public final void onClick(View view) {
        this.f54632b.e0(this.f54633c, this.f54634d, this.f54635e, view);
    }
}
