package pf;

import android.view.View;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.hbg.module.market.widget.viewhandler.MarketWidgetSymbolItemHandler;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSymbolItem.a f53029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSymbolItem f53030c;

    public /* synthetic */ f(MarketWidgetSymbolItem.a aVar, MarketWidgetSymbolItem marketWidgetSymbolItem) {
        this.f53029b = aVar;
        this.f53030c = marketWidgetSymbolItem;
    }

    public final void onClick(View view) {
        MarketWidgetSymbolItemHandler.k(this.f53029b, this.f53030c, view);
    }
}
