package com.huobi.finance.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.huobi.finance.bean.OtcFinanceRecordItem;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import u6.g;

public class OtcCurrencyOrderDetailPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public OtcFinanceRecordItem f45634a;

    public interface a extends g {
        void Ig(OtcFinanceRecordItem otcFinanceRecordItem);
    }

    /* renamed from: Q */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        EventBus.d().p(this);
        this.f45634a = (OtcFinanceRecordItem) getActivity().getIntent().getSerializableExtra("otc_finance_record_item");
        ((a) getUI()).Ig(this.f45634a);
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
