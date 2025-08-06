package fj;

import android.view.View;
import com.huobi.contract.viewhandler.ContractMarketNewHandler;
import com.huobi.homemarket.bean.MarketContractSymbolPriceItem;
import v9.c;

public final /* synthetic */ class g implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketContractSymbolPriceItem f54616b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54617c;

    public /* synthetic */ g(MarketContractSymbolPriceItem marketContractSymbolPriceItem, c cVar) {
        this.f54616b = marketContractSymbolPriceItem;
        this.f54617c = cVar;
    }

    public final boolean onLongClick(View view) {
        return ContractMarketNewHandler.e0(this.f54616b, this.f54617c, view);
    }
}
