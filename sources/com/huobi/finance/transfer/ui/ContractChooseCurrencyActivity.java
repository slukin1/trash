package com.huobi.finance.transfer.ui;

import android.app.Activity;
import android.content.Intent;
import com.huobi.contract.entity.ContractCoinInfo;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import java.util.List;
import rx.Observable;

public class ContractChooseCurrencyActivity extends TransferChooseCurrencyActivity<ContractCoinInfo> {
    public static void yj(Activity activity, String str, boolean z11) {
        Intent intent = new Intent(activity, ContractChooseCurrencyActivity.class);
        intent.putExtra("transfer_coin_select", str);
        intent.putExtra("JUST_SELECT_CURRENCY", z11);
        TransferChooseCurrencyActivity.startForResult(activity, intent, 1001);
    }

    public static void zj(Activity activity, boolean z11) {
        yj(activity, (String) null, z11);
    }

    public String getAccount() {
        return "4";
    }

    public Observable<List<ContractCoinInfo>> sj() {
        return ContractCurrencyUtils.f(true, "0");
    }

    /* renamed from: xj */
    public String rj(ContractCoinInfo contractCoinInfo) {
        return contractCoinInfo.getSymbol();
    }
}
