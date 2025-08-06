package pf;

import android.view.View;
import android.widget.TextView;
import com.hbg.module.market.widget.bean.MarketWidgetSymbolItem;
import com.hbg.module.market.widget.viewhandler.MarketWidgetSymbolItemHandler;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSymbolItem.a f53025b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f53026c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f53027d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ MarketWidgetSymbolItem f53028e;

    public /* synthetic */ e(MarketWidgetSymbolItem.a aVar, View view, TextView textView, MarketWidgetSymbolItem marketWidgetSymbolItem) {
        this.f53025b = aVar;
        this.f53026c = view;
        this.f53027d = textView;
        this.f53028e = marketWidgetSymbolItem;
    }

    public final void onClick(View view) {
        MarketWidgetSymbolItemHandler.m(this.f53025b, this.f53026c, this.f53027d, this.f53028e, view);
    }
}
