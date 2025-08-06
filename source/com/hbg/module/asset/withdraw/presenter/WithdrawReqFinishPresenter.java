package com.hbg.module.asset.withdraw.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.network.hbg.core.bean.IntegrationQuestionInfo;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import java.util.List;
import u6.g;

public class WithdrawReqFinishPresenter extends ActivityPresenter<b> {

    public class a extends q6.b<List<IntegrationQuestionInfo>> {
        public a(g gVar, boolean z11) {
            super(gVar, z11);
        }

        /* renamed from: a */
        public void onRequestSuccess(List<IntegrationQuestionInfo> list) {
            super.onRequestSuccess(list);
            ((b) WithdrawReqFinishPresenter.this.getUI()).G6(list);
        }
    }

    public interface b extends g {
        void G6(List<IntegrationQuestionInfo> list);
    }

    /* renamed from: Q */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        R();
    }

    public final void R() {
        v7.b.a().getIntegrationQuestionList().d(new a((g) getUI(), false));
    }

    public void S(List<Integer> list) {
        if (!list.isEmpty()) {
            v7.b.a().q(list).d((RequestCallback1) null);
        }
    }
}
