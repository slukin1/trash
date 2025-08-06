package com.huobi.newtrade.ui;

import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.ui.BaseFragment;
import com.huobi.newtrade.presenter.NewTradeBasePresenter;
import com.huobi.page.SmartRefreshHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import ky.j;
import ny.d;
import pro.huobi.R;
import ro.a;
import ro.l;

public abstract class NewTradeBaseFragment<P extends NewTradeBasePresenter<V>, V extends ro.a> extends BaseFragment<P, V> implements ro.a {

    /* renamed from: l  reason: collision with root package name */
    public NewTradeView f78063l;

    /* renamed from: m  reason: collision with root package name */
    public SmartRefreshLayout f78064m;

    /* renamed from: n  reason: collision with root package name */
    public SmartRefreshHeader f78065n;

    public class a implements d {
        public a() {
        }

        public void P8(j jVar) {
        }

        public void bf(j jVar) {
            if (!((ro.a) NewTradeBaseFragment.this.zh()).isCanBeSeen()) {
                NewTradeBaseFragment.this.y0(true);
            }
        }
    }

    public void Ah() {
        super.Ah();
        this.f78064m.e0(new a());
    }

    public void B(int i11) {
        this.f78063l.setSelectedTab(i11);
    }

    public void Je(qo.a aVar) {
        this.f78063l.setNewTradeViewController(aVar);
    }

    public l U6() {
        return this.f78063l;
    }

    public void initViews() {
        super.initViews();
        this.f78063l = (NewTradeView) this.f67460i.b(R.id.new_trade_view);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) this.f67460i.b(R.id.trade_refresh);
        this.f78064m = smartRefreshLayout;
        smartRefreshLayout.i(true);
        this.f78064m.g(false);
        this.f78064m.V(false);
        SmartRefreshHeader smartRefreshHeader = new SmartRefreshHeader(getActivity());
        this.f78065n = smartRefreshHeader;
        this.f78064m.j0(smartRefreshHeader);
    }

    public void y0(boolean z11) {
        this.f78065n.b(DateTimeUtils.h(DateTimeUtils.v(), "MM-dd HH:mm:ss"));
        if (z11) {
            this.f78064m.finishRefresh();
            this.f78064m.setNoMoreData(false);
            return;
        }
        this.f78064m.w();
    }
}
