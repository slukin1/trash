package com.huobi.finance.presenter;

import al.w;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import u6.g;

public class CurrencyFromCCOrderDetailPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public CurrencyFromCCFinanceRecordInfo f45537a;

    public interface a extends g {
        void hh(CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T() {
        this.f45537a.setState(String.valueOf(6));
        ((a) getUI()).hh(this.f45537a);
    }

    public void R() {
        CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo = this.f45537a;
        String orderCode = currencyFromCCFinanceRecordInfo != null ? currencyFromCCFinanceRecordInfo.getOrderCode() : null;
        if (!TextUtils.isEmpty(orderCode)) {
            w.d(orderCode, (g) getUI(), new r3(this));
        }
    }

    public void S() {
        BaseCoreActivity activity = getActivity();
        w.l(activity, this.f45537a);
        activity.finish();
    }

    /* renamed from: U */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        EventBus.d().p(this);
        this.f45537a = (CurrencyFromCCFinanceRecordInfo) getActivity().getIntent().getSerializableExtra("currency_from_cc_finance_record_item");
        ((a) getUI()).hh(this.f45537a);
    }

    public void onDestroy() {
        EventBus.d().r(this);
        super.onDestroy();
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        c.i().m(getActivity(), (kn.a) null);
        getActivity().finish();
    }
}
