package com.huobi.finance.ui;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.huobi.finance.presenter.HtExchangeHistoryPresenter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import pro.huobi.R;

public class HtExchangeHistoryActivity extends BaseActivity<HtExchangeHistoryPresenter, HtExchangeHistoryPresenter.a> implements HtExchangeHistoryPresenter.a {

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f46574b;

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshLayout f46575c;

    /* renamed from: d  reason: collision with root package name */
    public LoadingLayout f46576d;

    /* renamed from: Xf */
    public HtExchangeHistoryPresenter createPresenter() {
        return new HtExchangeHistoryPresenter();
    }

    public RecyclerView Y0() {
        return this.f46574b;
    }

    /* renamed from: Yf */
    public HtExchangeHistoryPresenter.a getUI() {
        return this;
    }

    public void addEvent() {
    }

    public LoadingLayout f6() {
        return this.f46576d;
    }

    public int getContentView() {
        return R.layout.activity_ht_exchange_history;
    }

    public void initView() {
        removeWinBg();
        RecyclerView recyclerView = (RecyclerView) this.viewFinder.b(R.id.rcv_history);
        this.f46574b = recyclerView;
        recyclerView.setLayoutManager(new StableLinearLayoutManager(this));
        this.f46575c = (SmartRefreshLayout) this.viewFinder.b(R.id.refresh_layout);
        this.f46576d = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        setToolBar((Toolbar) this.viewFinder.b(R.id.toolbar), getResources().getString(R.string.currency_stable_exchange_record), true);
    }

    public SmartRefreshLayout t2() {
        return this.f46575c;
    }
}
