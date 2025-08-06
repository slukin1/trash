package ql;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.MarketPlateDetail;
import com.huobi.homemarket.handler.MarketDetailPlateHandler;
import v9.c;

public final /* synthetic */ class l implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketDetailPlateHandler f60039b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f60040c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketPlateDetail.CurrencyItem f60041d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f60042e;

    public /* synthetic */ l(MarketDetailPlateHandler marketDetailPlateHandler, c cVar, MarketPlateDetail.CurrencyItem currencyItem, int i11) {
        this.f60039b = marketDetailPlateHandler;
        this.f60040c = cVar;
        this.f60041d = currencyItem;
        this.f60042e = i11;
    }

    public final void onClick(View view) {
        this.f60039b.lambda$handleView$0(this.f60040c, this.f60041d, this.f60042e, view);
    }
}
