package pf;

import android.view.MotionEvent;
import android.view.View;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.hbg.module.market.widget.viewhandler.MarketWidgetSymbolItemHandler;
import v9.c;

public final /* synthetic */ class h implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSymbolItem f53032b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f53033c;

    public /* synthetic */ h(MarketWidgetSymbolItem marketWidgetSymbolItem, c cVar) {
        this.f53032b = marketWidgetSymbolItem;
        this.f53033c = cVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return MarketWidgetSymbolItemHandler.j(this.f53032b, this.f53033c, view, motionEvent);
    }
}
