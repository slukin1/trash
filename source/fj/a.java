package fj;

import android.view.View;
import com.huobi.contract.viewhandler.ContractCollectionMarketNewHandler;
import com.huobi.homemarket.bean.MarketContractSymbolPriceItem;
import v9.c;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractCollectionMarketNewHandler f54600b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54601c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketContractSymbolPriceItem f54602d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54603e;

    public /* synthetic */ a(ContractCollectionMarketNewHandler contractCollectionMarketNewHandler, c cVar, MarketContractSymbolPriceItem marketContractSymbolPriceItem, int i11) {
        this.f54600b = contractCollectionMarketNewHandler;
        this.f54601c = cVar;
        this.f54602d = marketContractSymbolPriceItem;
        this.f54603e = i11;
    }

    public final void onClick(View view) {
        this.f54600b.d0(this.f54601c, this.f54602d, this.f54603e, view);
    }
}
