package sp;

import android.view.View;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.huobi.otc.ui.CouponActivity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CouponActivity f26030b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f26031c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LoadingLayout f26032d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ SmartRefreshLayout f26033e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ EasyRecyclerView f26034f;

    public /* synthetic */ j(CouponActivity couponActivity, int i11, LoadingLayout loadingLayout, SmartRefreshLayout smartRefreshLayout, EasyRecyclerView easyRecyclerView) {
        this.f26030b = couponActivity;
        this.f26031c = i11;
        this.f26032d = loadingLayout;
        this.f26033e = smartRefreshLayout;
        this.f26034f = easyRecyclerView;
    }

    public final void onClick(View view) {
        this.f26030b.Bh(this.f26031c, this.f26032d, this.f26033e, this.f26034f, view);
    }
}
