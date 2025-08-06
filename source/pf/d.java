package pf;

import android.view.View;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.hbg.module.market.widget.viewhandler.MarketWidgetSymbolItemHandler;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSymbolItem.a f53024b;

    public /* synthetic */ d(MarketWidgetSymbolItem.a aVar) {
        this.f53024b = aVar;
    }

    public final void onClick(View view) {
        MarketWidgetSymbolItemHandler.l(this.f53024b, view);
    }
}
