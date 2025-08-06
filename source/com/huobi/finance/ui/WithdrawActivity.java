package com.huobi.finance.ui;

import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.huobi.kyc.util.KycProxy;
import u6.g;

public class WithdrawActivity extends AbsDwActivity {

    public class a extends BaseSubscriber<UserKycInfoNew> {
        public a() {
        }
    }

    public String Nh() {
        return "withdraw";
    }

    public void onResume() {
        super.onResume();
        if (KycProxy.l().p() != 2) {
            KycProxy.l().i(false).compose(RxJavaHelper.t((g) null)).subscribe(new a());
        }
    }
}
