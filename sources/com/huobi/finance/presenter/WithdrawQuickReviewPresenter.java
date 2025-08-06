package com.huobi.finance.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.finance.api.FinanceService;
import com.huobi.utils.k0;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import tq.p;
import u6.g;

public class WithdrawQuickReviewPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f45792a;

    public class a extends d<Boolean> {
        public a(g gVar) {
            super(gVar);
        }

        /* renamed from: f */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (bool.booleanValue()) {
                ((b) WithdrawQuickReviewPresenter.this.getUI()).w9();
            } else {
                ((b) WithdrawQuickReviewPresenter.this.getUI()).Ud();
            }
        }
    }

    public interface b extends g {
        void Ud();

        void w9();
    }

    /* renamed from: Q */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        EventBus.d().p(this);
        this.f45792a = getActivity().getIntent().getStringExtra("WITHDRAW_ADDRESS_ID");
    }

    public void R(String str) {
        ((FinanceService) p.W(FinanceService.class)).withdrawVerifyIdentity(MapParamsBuilder.c().a("withdraw-id", this.f45792a).a("card-no", str).b()).compose(p.a0()).compose(RxJavaHelper.t((g) getUI())).subscribe(new a((g) getUI()));
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.d().r(this);
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void tokenError(mo.a aVar) {
        getActivity().startActivity(k0.h(getActivity()));
        getActivity().finish();
    }
}
