package ql;

import android.view.View;
import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import com.huobi.homemarket.handler.MarketViewHandler;

public final /* synthetic */ class q implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketSymbolPriceItem f60054b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f60055c;

    public /* synthetic */ q(MarketSymbolPriceItem marketSymbolPriceItem, View view) {
        this.f60054b = marketSymbolPriceItem;
        this.f60055c = view;
    }

    public final boolean onLongClick(View view) {
        return MarketViewHandler.i0(this.f60054b, this.f60055c, view);
    }
}
