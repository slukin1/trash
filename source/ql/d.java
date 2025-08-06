package ql;

import android.view.View;
import com.huobi.homemarket.handler.AbsMarketViewHandler;
import ml.b;
import v9.c;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsMarketViewHandler f60020b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f60021c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f60022d;

    public /* synthetic */ d(AbsMarketViewHandler absMarketViewHandler, c cVar, b bVar) {
        this.f60020b = absMarketViewHandler;
        this.f60021c = cVar;
        this.f60022d = bVar;
    }

    public final void onClick(View view) {
        this.f60020b.E(this.f60021c, this.f60022d, view);
    }
}
