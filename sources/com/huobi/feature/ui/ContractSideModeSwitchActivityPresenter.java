package com.huobi.feature.ui;

import android.util.Log;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPositionModeSwitchRespInfo;
import com.hbg.lib.network.retrofit.util.SPUtil;
import rx.Observer;
import u6.g;

public class ContractSideModeSwitchActivityPresenter extends ActivityPresenter<d> {

    public class a implements Observer<LinearSwapPositionModeSwitchRespInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapPositionModeSwitchRespInfo linearSwapPositionModeSwitchRespInfo) {
            Log.d("56789>", "testSwithPositionModeWhenQuan onNext " + linearSwapPositionModeSwitchRespInfo.toString());
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).dismissLoading();
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).dc(linearSwapPositionModeSwitchRespInfo.isSideSingleMode());
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            Log.d("56789>", "testSwithPositionModeWhenQuan onError " + th2.toString());
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).dismissLoading();
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).E9(th2);
        }
    }

    public class b implements Observer<LinearSwapPositionModeSwitchRespInfo> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapPositionModeSwitchRespInfo linearSwapPositionModeSwitchRespInfo) {
            Log.d("56789>", "testSwithPositionModeWhenQuan onNext " + linearSwapPositionModeSwitchRespInfo.toString());
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).dismissLoading();
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).dc(linearSwapPositionModeSwitchRespInfo.isSideSingleMode());
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            Log.d("56789>", "testSwithPositionModeWhenQuan onError " + th2.toString());
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).dismissLoading();
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).E9(th2);
        }
    }

    public class c implements Observer<LinearSwapPositionModeSwitchRespInfo> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapPositionModeSwitchRespInfo linearSwapPositionModeSwitchRespInfo) {
            Log.d("56789>", "testSwithPositionModeWhenZhu onNext " + linearSwapPositionModeSwitchRespInfo.toString());
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).dismissLoading();
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).dc(linearSwapPositionModeSwitchRespInfo.isSideSingleMode());
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            Log.d("56789>", "testSwithPositionModeWhenZhu onError " + th2.toString());
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).dismissLoading();
            ((d) ContractSideModeSwitchActivityPresenter.this.getUI()).E9(th2);
        }
    }

    public interface d extends g {
        void E9(Throwable th2);

        void dc(boolean z11);

        void dismissLoading();

        void showLoading();
    }

    public final void Q(boolean z11, boolean z12) {
        h8.a.a().k0(z11 ? FutureContractInfo.MARGIN_CROSS : FutureContractInfo.MARGIN_ISOLATED, z12 ? "single_side" : "dual_side").b().compose(RxJavaHelper.t((g) getUI())).subscribe(new a());
    }

    public void R(boolean z11, String str, boolean z12) {
        ((d) getUI()).showLoading();
        if (SPUtil.j()) {
            Q(z11, z12);
        } else {
            S(z11, str, z12);
        }
    }

    public final void S(boolean z11, String str, boolean z12) {
        if (z11) {
            h8.a.a().F(str, z12).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new b());
        } else {
            h8.a.a().p0(str, z12).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new c());
        }
    }
}
