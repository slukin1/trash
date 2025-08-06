package com.huobi.otc.persenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.facebook.appevents.UserDataStore;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.UserBillingAddressBean;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.ui.OtcCardManagerActivity;
import java.util.HashMap;
import java.util.Map;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import q6.d;
import u6.g;

public class AddNewAddressPresenter extends ActivityPresenter<c> {

    public class a extends d<Object> {
        public a(g gVar) {
            super(gVar);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
            if (AddNewAddressPresenter.this.getUI() != null) {
                ((c) AddNewAddressPresenter.this.getUI()).A5();
            }
        }
    }

    public class b extends RequestCallback1<OTCStatusExtendResponse<MktRuleBean>> {
        public b() {
        }

        /* renamed from: a */
        public void onRequestSuccess(OTCStatusExtendResponse<MktRuleBean> oTCStatusExtendResponse) {
            if (oTCStatusExtendResponse != null && oTCStatusExtendResponse.isSuccess() && oTCStatusExtendResponse.getData() != null) {
                ((c) AddNewAddressPresenter.this.getUI()).W(oTCStatusExtendResponse.getData());
            }
        }
    }

    public interface c extends g {
        void A5();

        void W(MktRuleBean mktRuleBean);
    }

    public void Q(Map<String, Object> map) {
        s8.a.a().bindCardMktRule(map).d(new b());
    }

    /* renamed from: R */
    public void onUIReady(BaseCoreActivity baseCoreActivity, c cVar) {
        super.onUIReady(baseCoreActivity, cVar);
        HashMap hashMap = new HashMap();
        hashMap.put("factor", new MapParamsBuilder().a("appPageId", "21").b());
        Q(hashMap);
    }

    public void S(UserBillingAddressBean userBillingAddressBean) {
        HashMap hashMap = new HashMap();
        hashMap.put("cardId", Long.valueOf(userBillingAddressBean.getCardId()));
        hashMap.put("addressLine1", userBillingAddressBean.getAddressLine1());
        hashMap.put("addressLine2", userBillingAddressBean.getAddressLine2());
        hashMap.put("city", userBillingAddressBean.getCity());
        hashMap.put("state", userBillingAddressBean.getState());
        hashMap.put("zip", userBillingAddressBean.getZip());
        hashMap.put(UserDataStore.COUNTRY, userBillingAddressBean.getCountry());
        v7.b.a().updateBillingAddress(hashMap).b().compose(RxJavaHelper.t((g) getUI())).subscribe(new a((g) getUI()));
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (TextUtils.isEmpty(proTokenUpdate.getProToken()) && getUI() != null && ((c) getUI()).isAlive()) {
            Intent M = OtcModuleConfig.a().M(getActivity());
            OtcModuleConfig.a().l(getActivity(), M, M);
            Activity f11 = oa.a.g().f(OtcCardManagerActivity.class);
            if (f11 != null) {
                f11.finish();
            }
            getActivity().finish();
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((c) getUI()).isAlive()) {
            Intent M = OtcModuleConfig.a().M(getActivity());
            OtcModuleConfig.a().l(getActivity(), M, M);
            if (getActivity() != null) {
                getActivity().finish();
            }
        }
    }
}
