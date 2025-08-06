package com.huobi.index.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.TokenBindInfo;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.utils.t0;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import u6.g;
import yl.r;

public class ScanLoginSuccessPresenter extends ActivityPresenter<b> {

    public class a extends EasySubscriber<TokenBindInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(TokenBindInfo tokenBindInfo) {
            super.onNext(tokenBindInfo);
            ScanLoginSuccessPresenter.this.getActivity().finish();
        }

        public void onAfter() {
            super.onAfter();
            ((b) ScanLoginSuccessPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if ("69001".equals(aPIStatusErrorException.getErrCode())) {
                ScanLoginSuccessPresenter.this.getActivity().finish();
            }
        }

        public void onStart() {
            super.onStart();
            ((b) ScanLoginSuccessPresenter.this.getUI()).showProgressDialog();
        }
    }

    public interface b extends g {
    }

    /* renamed from: S */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
    }

    public void T() {
        v7.b.a().R(t0.a(), 2, r.c()).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        if (getUI() != null && getActivity() != null && ((b) getUI()).isCanBeSeen()) {
            c.i().d(getActivity(), (kn.a) null);
            getActivity().finish();
        }
    }
}
