package ql;

import android.view.View;
import com.huobi.homemarket.handler.AbsMarketViewHandler;
import ml.b;
import v9.c;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsMarketViewHandler f60023b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f60024c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ b f60025d;

    public /* synthetic */ e(AbsMarketViewHandler absMarketViewHandler, c cVar, b bVar) {
        this.f60023b = absMarketViewHandler;
        this.f60024c = cVar;
        this.f60025d = bVar;
    }

    public final void onClick(View view) {
        this.f60023b.F(this.f60024c, this.f60025d, view);
    }
}
