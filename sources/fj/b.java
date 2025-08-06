package fj;

import android.view.View;
import com.huobi.contract.viewhandler.ContractCollectionMarketNewHandler;
import com.huobi.homemarket.bean.MarketContractSymbolPriceItem;
import v9.c;

public final /* synthetic */ class b implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketContractSymbolPriceItem f54604b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54605c;

    public /* synthetic */ b(MarketContractSymbolPriceItem marketContractSymbolPriceItem, c cVar) {
        this.f54604b = marketContractSymbolPriceItem;
        this.f54605c = cVar;
    }

    public final boolean onLongClick(View view) {
        return ContractCollectionMarketNewHandler.e0(this.f54604b, this.f54605c, view);
    }
}
