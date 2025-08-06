package com.huobi.finance.presenter;

import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import u6.g;
import vk.x;
import wk.a1;

public class UsdtExchangeHistoryPresenter extends NeedLoginActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public SmartRefreshPageSplitter<x> f45762a;

    public interface a extends SmartRefreshPageSplitter.d {
    }

    /* renamed from: Q */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        SmartRefreshPageSplitter<x> k11 = new SmartRefreshPageSplitter.Builder().n(true).l(true).m(11).p(aVar).o(new a1((g) getUI())).k();
        this.f45762a = k11;
        k11.B();
    }
}
