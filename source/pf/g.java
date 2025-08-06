package pf;

import android.view.View;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.hbg.module.market.widget.viewhandler.MarketWidgetSymbolItemHandler;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSymbolItem f53031b;

    public /* synthetic */ g(MarketWidgetSymbolItem marketWidgetSymbolItem) {
        this.f53031b = marketWidgetSymbolItem;
    }

    public final void onClick(View view) {
        MarketWidgetSymbolItemHandler.i(this.f53031b, view);
    }
}
