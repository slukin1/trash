package ql;

import android.view.View;
import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import com.huobi.homemarket.handler.MarketViewHandler;
import v9.c;

public final /* synthetic */ class p implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketViewHandler f60050b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f60051c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketSymbolPriceItem f60052d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f60053e;

    public /* synthetic */ p(MarketViewHandler marketViewHandler, c cVar, MarketSymbolPriceItem marketSymbolPriceItem, int i11) {
        this.f60050b = marketViewHandler;
        this.f60051c = cVar;
        this.f60052d = marketSymbolPriceItem;
        this.f60053e = i11;
    }

    public final void onClick(View view) {
        this.f60050b.h0(this.f60051c, this.f60052d, this.f60053e, view);
    }
}
