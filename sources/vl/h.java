package vl;

import android.view.View;
import com.huobi.homemarket.bean.MarketOptionItem;
import vl.f;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.e f61074b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MarketOptionItem f61075c;

    public /* synthetic */ h(f.e eVar, MarketOptionItem marketOptionItem) {
        this.f61074b = eVar;
        this.f61075c = marketOptionItem;
    }

    public final void onClick(View view) {
        this.f61074b.n(this.f61075c, view);
    }
}
