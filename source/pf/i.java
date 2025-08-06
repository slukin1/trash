package pf;

import android.view.View;
import android.widget.TextView;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.hbg.module.market.widget.viewhandler.MarketWidgetSymbolItemHandler;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSymbolItemHandler f53034b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f53035c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSymbolItem f53036d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ View f53037e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ View f53038f;

    public /* synthetic */ i(MarketWidgetSymbolItemHandler marketWidgetSymbolItemHandler, TextView textView, MarketWidgetSymbolItem marketWidgetSymbolItem, View view, View view2) {
        this.f53034b = marketWidgetSymbolItemHandler;
        this.f53035c = textView;
        this.f53036d = marketWidgetSymbolItem;
        this.f53037e = view;
        this.f53038f = view2;
    }

    public final void run() {
        this.f53034b.n(this.f53035c, this.f53036d, this.f53037e, this.f53038f);
    }
}
