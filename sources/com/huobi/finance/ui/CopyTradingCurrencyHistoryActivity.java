package com.huobi.finance.ui;

import android.content.Intent;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.finance.presenter.CurrencyHistoryPresenter;
import com.tencent.android.tpush.common.Constants;

@Route(path = "/balance/copyTradingTransferRecord")
public class CopyTradingCurrencyHistoryActivity extends CurrencyHistoryActivity {
    /* renamed from: Pg */
    public CurrencyHistoryPresenter createPresenter() {
        Intent intent = getIntent();
        intent.putExtra(Constants.FLAG_ACCOUNT, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT);
        intent.putExtra("KEY_JUMP_FOR", "3");
        return new CurrencyHistoryPresenter();
    }
}
