package vl;

import android.view.View;
import com.huobi.homemarket.bean.MarketOptionItem;
import vl.f;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f.e f61078b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MarketOptionItem f61079c;

    public /* synthetic */ j(f.e eVar, MarketOptionItem marketOptionItem) {
        this.f61078b = eVar;
        this.f61079c = marketOptionItem;
    }

    public final void onClick(View view) {
        this.f61078b.m(this.f61079c, view);
    }
}
