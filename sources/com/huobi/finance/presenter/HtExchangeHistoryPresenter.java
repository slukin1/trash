package com.huobi.finance.presenter;

import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import u6.g;
import vk.q;
import wk.v0;

public class HtExchangeHistoryPresenter extends NeedLoginActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public SmartRefreshPageSplitter<q> f45564a;

    public interface a extends SmartRefreshPageSplitter.d {
    }

    /* renamed from: Q */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        SmartRefreshPageSplitter<q> k11 = new SmartRefreshPageSplitter.Builder().n(true).l(true).m(11).p(aVar).o(new v0((g) getUI())).k();
        this.f45564a = k11;
        k11.B();
    }
}
