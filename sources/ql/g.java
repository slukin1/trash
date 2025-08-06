package ql;

import android.view.View;
import com.huobi.homemarket.handler.AbsMarketViewHandler;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbsMarketViewHandler f60030b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ View f60031c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f60032d;

    public /* synthetic */ g(AbsMarketViewHandler absMarketViewHandler, View view, int i11) {
        this.f60030b = absMarketViewHandler;
        this.f60031c = view;
        this.f60032d = i11;
    }

    public final void run() {
        this.f60030b.D(this.f60031c, this.f60032d);
    }
}
