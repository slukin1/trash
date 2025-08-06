package ql;

import android.view.View;
import com.huobi.homemarket.handler.AbsMarketViewHandler;
import ml.b;
import v9.c;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsMarketViewHandler f60026b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f60027c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f60028d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f60029e;

    public /* synthetic */ f(AbsMarketViewHandler absMarketViewHandler, c cVar, b bVar, int i11) {
        this.f60026b = absMarketViewHandler;
        this.f60027c = cVar;
        this.f60028d = bVar;
        this.f60029e = i11;
    }

    public final void onClick(View view) {
        this.f60026b.H(this.f60027c, this.f60028d, this.f60029e, view);
    }
}
