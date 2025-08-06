package com.huobi.finance.transfer.ui;

import ad.i;
import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import com.huobi.supermargin.bean.MarginCurrency;
import d7.k;
import java.util.List;
import ks.d;
import rx.Observable;
import yk.e;

public class SuperMarginChooseCurrencyActivity extends TransferChooseCurrencyActivity<MarginCurrency> {
    public static void Aj(Activity activity, boolean z11) {
        Bj(activity, z11, 100);
    }

    public static void Bj(Activity activity, boolean z11, int i11) {
        Cj(activity, z11, i11, (String) null);
    }

    public static void Cj(Activity activity, boolean z11, int i11, String str) {
        Intent intent = new Intent(activity, SuperMarginChooseCurrencyActivity.class);
        intent.putExtra("EXTRA_IS_FROM", z11);
        intent.putExtra("transfer_coin_select", str);
        TransferChooseCurrencyActivity.startForResult(activity, intent, i11);
    }

    public static /* synthetic */ Boolean zj(boolean z11, MarginCurrency marginCurrency) {
        boolean z12 = true;
        if (!z11 && marginCurrency.getState() != 1) {
            z12 = false;
        }
        return Boolean.valueOf(z12);
    }

    public String getAccount() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL;
    }

    public Observable<List<MarginCurrency>> sj() {
        return d.g(true).flatMap(i.f3526b).filter(new e(getIntent().getBooleanExtra("EXTRA_IS_FROM", true))).toList();
    }

    /* renamed from: yj */
    public String rj(MarginCurrency marginCurrency) {
        return k.C().z(marginCurrency.getCurrency());
    }
}
