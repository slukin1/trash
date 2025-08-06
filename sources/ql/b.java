package ql;

import android.view.View;
import com.huobi.homemarket.handler.AbsMarketViewHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsMarketViewHandler f60015b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ml.b f60016c;

    public /* synthetic */ b(AbsMarketViewHandler absMarketViewHandler, ml.b bVar) {
        this.f60015b = absMarketViewHandler;
        this.f60016c = bVar;
    }

    public final void onClick(View view) {
        this.f60015b.I(this.f60016c, view);
    }
}
