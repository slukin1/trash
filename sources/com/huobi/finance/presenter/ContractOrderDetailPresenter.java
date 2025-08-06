package com.huobi.finance.presenter;

import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.huobi.finance.bean.ContractRecordItem;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rn.c;
import u6.g;

public class ContractOrderDetailPresenter extends ActivityPresenter<a> {

    /* renamed from: a  reason: collision with root package name */
    public ContractRecordItem f45517a;

    public interface a extends g {
        void V7(ContractRecordItem contractRecordItem);
    }

    /* renamed from: Q */
    public void onUIReady(BaseCoreActivity baseCoreActivity, a aVar) {
        super.onUIReady(baseCoreActivity, aVar);
        EventBus.d().p(this);
        this.f45517a = (ContractRecordItem) getActivity().getIntent().getSerializableExtra("finance_record_item");
        ((a) getUI()).V7(this.f45517a);
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
