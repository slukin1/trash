package fj;

import android.view.View;
import com.huobi.contract.viewhandler.SwapCollectionMarketNewHandler;
import com.huobi.homemarket.bean.MarketSwapPriceItem;
import v9.c;

public final /* synthetic */ class w implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketSwapPriceItem f54649b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54650c;

    public /* synthetic */ w(MarketSwapPriceItem marketSwapPriceItem, c cVar) {
        this.f54649b = marketSwapPriceItem;
        this.f54650c = cVar;
    }

    public final boolean onLongClick(View view) {
        return SwapCollectionMarketNewHandler.e0(this.f54649b, this.f54650c, view);
    }
}
