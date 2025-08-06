package com.huobi.finance.transfer.ui;

import ad.i;
import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.swap.core.bean.ProductInfo;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import java.util.List;
import qs.a;
import rx.Observable;
import yk.f;

public class SwapChooseCurrencyActivity extends TransferChooseCurrencyActivity<ProductInfo> {
    public static void Aj(Activity activity, String str, boolean z11) {
        Intent intent = new Intent(activity, SwapChooseCurrencyActivity.class);
        intent.putExtra("JUST_SELECT_CURRENCY", z11);
        intent.putExtra("transfer_coin_select", str);
        TransferChooseCurrencyActivity.startForResult(activity, intent, 1001);
    }

    public static void Bj(Activity activity, boolean z11) {
        Aj(activity, (String) null, z11);
    }

    public static /* synthetic */ Boolean zj(ProductInfo productInfo) {
        boolean z11 = true;
        if (productInfo.getIsTrade() != 1) {
            z11 = false;
        }
        return Boolean.valueOf(z11);
    }

    public String getAccount() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP;
    }

    public Observable<List<ProductInfo>> sj() {
        return a.f84586a.f(true).flatMap(i.f3526b).filter(f.f61789b).toList();
    }

    /* renamed from: yj */
    public String rj(ProductInfo productInfo) {
        return productInfo.getSymbol();
    }
}
