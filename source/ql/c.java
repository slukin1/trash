package ql;

import android.view.View;
import com.huobi.homemarket.handler.AbsMarketViewHandler;
import ml.b;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsMarketViewHandler f60017b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v9.c f60018c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f60019d;

    public /* synthetic */ c(AbsMarketViewHandler absMarketViewHandler, v9.c cVar, b bVar) {
        this.f60017b = absMarketViewHandler;
        this.f60018c = cVar;
        this.f60019d = bVar;
    }

    public final void onClick(View view) {
        this.f60017b.G(this.f60018c, this.f60019d, view);
    }
}
