package vl;

import android.view.View;
import com.huobi.homemarket.bean.MarketOptionItem;
import vl.f;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.e f61072b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MarketOptionItem f61073c;

    public /* synthetic */ g(f.e eVar, MarketOptionItem marketOptionItem) {
        this.f61072b = eVar;
        this.f61073c = marketOptionItem;
    }

    public final void onClick(View view) {
        this.f61072b.k(this.f61073c, view);
    }
}
