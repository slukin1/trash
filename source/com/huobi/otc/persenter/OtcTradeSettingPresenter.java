package com.huobi.otc.persenter;

import android.content.Intent;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.uc.retrofit.UcRetrofit;
import com.hbg.lib.network.uc.retrofit.bean.UcAuthorizationBean;
import com.hbg.lib.network.uc.retrofit.service.UserCenterService;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.otc.utils.OtcPayMethodUtil;
import i6.i;
import java.util.Map;
import jp.k0;
import jp.l;
import q6.d;
import qp.s;
import qp.t;
import qp.u;
import rx.Observable;
import u6.g;

public class OtcTradeSettingPresenter extends ActivityPresenter<b> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f79152a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f79153b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f79154c;

    public class a extends BaseSubscriber<UserKycInfoNew> {
        public a() {
        }

        public void onAfter() {
            super.onAfter();
            ((b) OtcTradeSettingPresenter.this.getUI()).ta(OtcTradeSettingPresenter.this.f79153b, OtcTradeSettingPresenter.this.f79154c);
        }
    }

    public interface b extends g {
        boolean hasNext();

        void ta(boolean z11, boolean z12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W() {
        getActivity().finish();
    }

    public static /* synthetic */ Observable X(Map map, String str, UcAuthorizationBean ucAuthorizationBean) {
        if (ucAuthorizationBean != null) {
            map.put("authToken", ucAuthorizationBean.getAuthToken());
            map.put("ucPass", str);
        }
        return l.L(map);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(Boolean bool) {
        HuobiToastUtil.s(R$string.otc_trade_setting_success);
        if (this.f79152a) {
            if (!OtcModuleConfig.a().D()) {
                k0.k(getActivity());
                V();
            } else if (OtcModuleConfig.a().j() == 2) {
                k0.k(getActivity());
                V();
            } else {
                OtcPayMethodUtil.f(getActivity());
            }
        } else if (this.f79153b) {
            V();
            if (((b) getUI()).hasNext()) {
                OtcPayMethodUtil.f(getActivity());
            }
        } else {
            V();
        }
    }

    public final void V() {
        i.b().g(new s(this), 10);
    }

    /* renamed from: Z */
    public void onUIReady(BaseCoreActivity baseCoreActivity, b bVar) {
        super.onUIReady(baseCoreActivity, bVar);
        Intent intent = baseCoreActivity.getIntent();
        this.f79152a = intent.getBooleanExtra("trade_by_paymethod", false);
        this.f79153b = intent.getBooleanExtra("trade_by_otc_ads", false);
        this.f79154c = intent.getBooleanExtra("trade_by_otc_is_china", false);
        a0();
    }

    public final void a0() {
        OtcPayMethodUtil.b(true, (g) getUI()).subscribe(new a());
    }

    public void b0(Map<String, Object> map, String str) {
        ((UserCenterService) UcRetrofit.request(UserCenterService.class)).getAuthorization("ASSET_PASSWORD_CHECK").compose(UcRetrofit.h()).flatMap(new u(map, str)).compose(RxJavaHelper.t((g) getUI())).subscribe(d.c((g) getUI(), new t(this)));
    }
}
