package com.huobi.finance.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.huobi.finance.presenter.OneOffAddressHistoryPresenter;
import com.huobi.view.rv.CommonVerticalDividerItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import pro.huobi.R;

public class OneOffAddressHistoryActivity extends BaseActivity<OneOffAddressHistoryPresenter, OneOffAddressHistoryPresenter.b> implements OneOffAddressHistoryPresenter.b {

    /* renamed from: b  reason: collision with root package name */
    public SmartRefreshLayout f46679b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f46680c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f46681d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f46682e;

    /* renamed from: f  reason: collision with root package name */
    public CoordinatorLayout f46683f;

    /* renamed from: g  reason: collision with root package name */
    public Toolbar f46684g;

    /* renamed from: Xf */
    public OneOffAddressHistoryPresenter createPresenter() {
        return new OneOffAddressHistoryPresenter();
    }

    public RecyclerView Y0() {
        return this.f46680c;
    }

    /* renamed from: Yf */
    public OneOffAddressHistoryPresenter.b getUI() {
        return this;
    }

    public void addEvent() {
    }

    public LoadingLayout f6() {
        return this.f46681d;
    }

    public int getContentView() {
        return R.layout.activity_one_off_address_history;
    }

    public void initView() {
        removeWinBg();
        RecyclerView recyclerView = (RecyclerView) this.viewFinder.b(R.id.hisory_order_rv);
        this.f46680c = recyclerView;
        recyclerView.addItemDecoration(new CommonVerticalDividerItemDecoration(ContextCompat.getDrawable(this, R.color.global_item_bg), ContextCompat.getDrawable(this, R.drawable.divider_with_left_margin), PixelUtils.a(10.0f), PixelUtils.a(0.5f), false));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f46682e = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.f46680c.setLayoutManager(this.f46682e);
        this.f46679b = (SmartRefreshLayout) this.viewFinder.b(R.id.tradePtrFrame);
        this.f46681d = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.f46684g = (Toolbar) this.viewFinder.b(R.id.toolbar);
        this.f46683f = (CoordinatorLayout) this.viewFinder.b(R.id.cl_root);
        setToolBar(this.f46684g, getString(R.string.currency_deposit_one_off_address_history_title), true);
    }

    public SmartRefreshLayout t2() {
        return this.f46679b;
    }
}
