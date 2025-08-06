package com.huobi.share.presenter;

import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.huobi.invite.bean.InviterInfo;
import com.huobi.invite.helper.InviteReturnHelper;
import tg.r;
import u6.g;

public class ContentSharePresenter extends ActivityPresenter<b> {

    public class a extends EasySubscriber<InviterInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(InviterInfo inviterInfo) {
            super.onNext(inviterInfo);
            ((b) ContentSharePresenter.this.getUI()).A6(inviterInfo);
        }
    }

    public interface b extends g {
        void A6(InviterInfo inviterInfo);
    }

    public void Q() {
        if (r.x().F0()) {
            InviteReturnHelper.e().compose(RxJavaHelper.t((g) null)).subscribe(new a());
        }
    }

    /* renamed from: R */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Q();
    }
}
