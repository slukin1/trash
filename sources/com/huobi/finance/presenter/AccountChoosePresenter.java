package com.huobi.finance.presenter;

import android.content.Intent;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.contract.helper.ContractUserInfoProvider;
import com.huobi.finance.bean.SymbolChooseEvent;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.controller.CTAccountController;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.tencent.android.tpush.common.Constants;
import i8.s;
import k20.h;
import m9.z;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import rx.Observable;
import tg.r;
import u6.g;

public class AccountChoosePresenter extends ActivityPresenter<c> {

    public class a extends d<Boolean> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            ((c) AccountChoosePresenter.this.getUI()).od(bool.booleanValue() && gj.d.n().G() && !r.x().X());
        }

        public void onError2(Throwable th2) {
            ((c) AccountChoosePresenter.this.getUI()).od(false);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            ((c) AccountChoosePresenter.this.getUI()).od(false);
        }
    }

    public class b extends BaseSubscriber<ContractUserInfo.UserBean> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(ContractUserInfo.UserBean userBean) {
            super.onNext(userBean);
            if (userBean != null) {
                ContractUserInfoProvider.i().z(userBean);
            }
        }
    }

    public interface c extends g {
        void od(boolean z11);
    }

    public void Q(String str, SymbolCurrencyEntity symbolCurrencyEntity) {
        Intent intent = new Intent();
        intent.putExtra(Constants.FLAG_ACCOUNT, str);
        if (symbolCurrencyEntity != null) {
            intent.putExtra("coin", symbolCurrencyEntity);
        }
        getActivity().setResult(-1, intent);
        getActivity().finish();
    }

    /* renamed from: R */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        EventBus.d().p(this);
    }

    public final void S() {
        ContractUserInfoProvider.i().p(false).compose(RxJavaHelper.t((g) getUI())).onErrorResumeNext(Observable.just(null)).subscribe(new b());
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 100 && i12 == 200 && getActivity() != null) {
            Intent intent2 = new Intent(getActivity(), UnifyTransferActivity.class);
            intent2.putExtra(Constants.FLAG_ACCOUNT, "4");
            intent2.setFlags(67108864);
            getActivity().startActivity(intent2);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    public void onResume() {
        super.onResume();
        S();
        z.p();
        s.l();
        CTAccountController.f45408b.a().c();
        r.x().S(true).compose(RxJavaHelper.t((g) getUI())).subscribe(new a((g) getUI()));
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onSymbolChoosed(SymbolChooseEvent symbolChooseEvent) {
        Q("3", symbolChooseEvent.f45390a);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        rn.c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
