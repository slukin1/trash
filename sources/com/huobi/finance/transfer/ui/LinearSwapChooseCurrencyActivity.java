package com.huobi.finance.transfer.ui;

import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.linear.swap.controller.LinearSwapProductInfoController;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import com.xiaomi.mipush.sdk.Constants;
import java.util.List;
import rx.Observable;

public class LinearSwapChooseCurrencyActivity extends TransferChooseCurrencyActivity<String> {
    public static void yj(Activity activity, String str) {
        Intent intent = new Intent(activity, LinearSwapChooseCurrencyActivity.class);
        intent.putExtra("transfer_coin_select", str);
        intent.putExtra("from_choose_currency", true);
        TransferChooseCurrencyActivity.startForResult(activity, intent, 1001);
    }

    public String getAccount() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP;
    }

    public Observable<List<String>> sj() {
        return LinearSwapProductInfoController.o().t(false).compose(RxJavaHelper.t(this));
    }

    public void wj(String str) {
        Intent intent = new Intent();
        String str2 = (String) qj(str);
        SymbolCurrencyEntity symbolCurrencyEntity = new SymbolCurrencyEntity();
        symbolCurrencyEntity.setBaseCurrency(str2);
        symbolCurrencyEntity.setQuoteCurrency(str2);
        symbolCurrencyEntity.setName(str2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
        intent.putExtra("coin", symbolCurrencyEntity);
        intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
        intent.putExtra("IS_FROM", getIntent().getBooleanExtra("IS_FROM", false));
        intent.putExtra("from_choose_currency", getIntent().getBooleanExtra("from_choose_currency", false));
        setResult(-1, intent);
        finish();
    }

    /* renamed from: xj */
    public String rj(String str) {
        return str;
    }
}
