package sp;

import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.otc.ui.CouponActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ky.j;
import ny.c;

public final /* synthetic */ class o implements c {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponActivity f26058b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f26059c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadingLayout f26060d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f26061e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ EasyRecyclerView f26062f;

    public /* synthetic */ o(CouponActivity couponActivity, int i11, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, EasyRecyclerView easyRecyclerView) {
        this.f26058b = couponActivity;
        this.f26059c = i11;
        this.f26060d = loadingLayout;
        this.f26061e = smartRefreshLayout;
        this.f26062f = easyRecyclerView;
    }

    public final void bf(j jVar) {
        this.f26058b.zh(this.f26059c, this.f26060d, this.f26061e, this.f26062f, jVar);
    }
}
