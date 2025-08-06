package fj;

import android.view.View;
import com.huobi.contract.viewhandler.LinearSwapMarketNewHandler;
import com.huobi.homemarket.bean.MarketLinearSwapPriceItem;
import v9.c;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LinearSwapMarketNewHandler f54638b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f54639c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MarketLinearSwapPriceItem f54640d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54641e;

    public /* synthetic */ s(LinearSwapMarketNewHandler linearSwapMarketNewHandler, c cVar, MarketLinearSwapPriceItem marketLinearSwapPriceItem, int i11) {
        this.f54638b = linearSwapMarketNewHandler;
        this.f54639c = cVar;
        this.f54640d = marketLinearSwapPriceItem;
        this.f54641e = i11;
    }

    public final void onClick(View view) {
        this.f54638b.e0(this.f54639c, this.f54640d, this.f54641e, view);
    }
}
