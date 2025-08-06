package com.huobi.order.persenter;

import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.huobi.page.SmartRefreshPageSplitter;

public class OrderListFragmentPresenter extends BaseFragmentPresenter<a> {

    /* renamed from: c  reason: collision with root package name */
    public SmartRefreshPageSplitter f78114c;

    public interface a extends SmartRefreshPageSplitter.d {
        int N2();

        void T1();

        SmartRefreshPageSplitter.c Y4();

        SmartRefreshPageSplitter.b hf();
    }

    public int b0() {
        SmartRefreshPageSplitter smartRefreshPageSplitter = this.f78114c;
        if (smartRefreshPageSplitter == null || smartRefreshPageSplitter.q() == null) {
            return 0;
        }
        return this.f78114c.q().size();
    }

    /* renamed from: c0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        this.f78114c = new SmartRefreshPageSplitter.Builder().p(true).n(true).o(((a) getUI()).N2()).r(aVar).m(false).q(((a) getUI()).Y4()).l(((a) getUI()).hf()).k();
        aVar.T1();
    }

    public void d0() {
        SmartRefreshPageSplitter smartRefreshPageSplitter = this.f78114c;
        if (smartRefreshPageSplitter != null) {
            smartRefreshPageSplitter.F();
        }
    }

    public void f0(SmartRefreshPageSplitter.c cVar) {
        SmartRefreshPageSplitter smartRefreshPageSplitter = this.f78114c;
        if (smartRefreshPageSplitter != null) {
            smartRefreshPageSplitter.E(cVar);
        }
    }
}
