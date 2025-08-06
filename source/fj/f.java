package fj;

import android.view.View;
import com.huobi.contract.viewhandler.ContractMarketNewHandler;
import com.huobi.homemarket.bean.MarketContractSymbolPriceItem;
import v9.c;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ContractMarketNewHandler f54612b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54613c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketContractSymbolPriceItem f54614d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54615e;

    public /* synthetic */ f(ContractMarketNewHandler contractMarketNewHandler, c cVar, MarketContractSymbolPriceItem marketContractSymbolPriceItem, int i11) {
        this.f54612b = contractMarketNewHandler;
        this.f54613c = cVar;
        this.f54614d = marketContractSymbolPriceItem;
        this.f54615e = i11;
    }

    public final void onClick(View view) {
        this.f54612b.d0(this.f54613c, this.f54614d, this.f54615e, view);
    }
}
