package ql;

import android.view.View;
import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import com.huobi.homemarket.handler.MarketViewHandler;
import v9.c;

public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketViewHandler f60046b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f60047c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketSymbolPriceItem f60048d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f60049e;

    public /* synthetic */ o(MarketViewHandler marketViewHandler, c cVar, MarketSymbolPriceItem marketSymbolPriceItem, int i11) {
        this.f60046b = marketViewHandler;
        this.f60047c = cVar;
        this.f60048d = marketSymbolPriceItem;
        this.f60049e = i11;
    }

    public final void onClick(View view) {
        this.f60046b.j0(this.f60047c, this.f60048d, this.f60049e, view);
    }
}
