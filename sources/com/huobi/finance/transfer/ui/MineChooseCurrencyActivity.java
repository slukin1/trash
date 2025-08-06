package com.huobi.finance.transfer.ui;

import ad.i;
import al.b0;
import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.network.hbg.core.bean.MineAccountItem;
import com.hbg.lib.network.hbg.core.bean.a;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import com.tencent.android.tpush.common.Constants;
import java.util.List;
import rx.Observable;

public class MineChooseCurrencyActivity extends TransferChooseCurrencyActivity<MineAccountItem> {
    public static void yj(Activity activity, String str) {
        Intent intent = new Intent(activity, MineChooseCurrencyActivity.class);
        intent.putExtra("transfer_coin_select", str);
        TransferChooseCurrencyActivity.startForResult(activity, intent, 1001);
    }

    public String getAccount() {
        return "9";
    }

    public Observable<List<MineAccountItem>> sj() {
        return b0.e(true).flatMap(i.f3526b).filter(a.f70274b).toList();
    }

    public void wj(String str) {
        Intent intent = new Intent();
        intent.putExtra("coin", ((MineAccountItem) qj(str)).getCurrency());
        intent.putExtra(Constants.FLAG_ACCOUNT, "9");
        setResult(-1, intent);
        finish();
    }

    /* renamed from: xj */
    public String rj(MineAccountItem mineAccountItem) {
        return mineAccountItem.getCurrency();
    }
}
