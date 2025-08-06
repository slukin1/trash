package com.huobi.finance.presenter;

import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.network.pro.core.bean.RiskActionData;
import com.huobi.finance.api.FinanceService;
import java.util.HashMap;
import rx.Observable;
import tq.p;

public class AddAddrRiskPresenter extends UnifyRiskPresenter {

    /* renamed from: f  reason: collision with root package name */
    public String f45457f;

    public Observable<StringStatusResponse<RiskActionData>> c0() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("address-id", this.f45457f);
        return ((FinanceService) p.W(FinanceService.class)).getWithdrawAddressStatus(hashMap);
    }

    public void q0(BaseCoreActivity baseCoreActivity) {
        String stringExtra = getActivity().getIntent().getStringExtra("address-id");
        this.f45457f = stringExtra;
        if (StringUtils.p(stringExtra)) {
            getActivity().finish();
        }
    }
}
