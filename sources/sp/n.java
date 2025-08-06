package sp;

import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.otc.ui.CouponActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ky.j;
import ny.a;

public final /* synthetic */ class n implements a {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponActivity f26050b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f26051c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EasyRecyclerView f26052d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f26053e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ LoadingLayout f26054f;

    public /* synthetic */ n(CouponActivity couponActivity, int i11, EasyRecyclerView easyRecyclerView, SmartRefreshLayout smartRefreshLayout, LoadingLayout loadingLayout) {
        this.f26050b = couponActivity;
        this.f26051c = i11;
        this.f26052d = easyRecyclerView;
        this.f26053e = smartRefreshLayout;
        this.f26054f = loadingLayout;
    }

    public final void P8(j jVar) {
        this.f26050b.Ah(this.f26051c, this.f26052d, this.f26053e, this.f26054f, jVar);
    }
}
