package com.huobi.finance.transfer.ui;

import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.data.future.bean.FutureProductInfo;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import java.util.List;
import rx.Observable;

public class OptionChooseCurrencyActivity extends TransferChooseCurrencyActivity<FutureProductInfo> {
    public static void yj(Activity activity, String str, boolean z11) {
        Intent intent = new Intent(activity, OptionChooseCurrencyActivity.class);
        intent.putExtra("transfer_coin_select", str);
        intent.putExtra("JUST_SELECT_CURRENCY", z11);
        TransferChooseCurrencyActivity.startForResult(activity, intent, 1001);
    }

    public String getAccount() {
        return CouponReturn.TYPE_EXPERIENCE;
    }

    public Observable<List<FutureProductInfo>> sj() {
        return FutureProductInfoController.d().h(true);
    }

    /* renamed from: xj */
    public String rj(FutureProductInfo futureProductInfo) {
        return futureProductInfo.getSymbol();
    }
}
