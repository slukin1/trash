package com.huobi.finance.transfer.ui;

import android.app.Activity;
import android.content.Intent;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import java.util.List;
import rx.Observable;

public class OtcChooseCurrencyActivity extends TransferChooseCurrencyActivity<MarketCoin.Coin> {
    public static void yj(Activity activity) {
        zj(activity, (String) null);
    }

    public static void zj(Activity activity, String str) {
        Intent intent = new Intent(activity, OtcChooseCurrencyActivity.class);
        intent.putExtra("transfer_coin_select", str);
        TransferChooseCurrencyActivity.startForResult(activity, intent, 1001);
    }

    public String getAccount() {
        return "2";
    }

    public Observable<List<MarketCoin.Coin>> sj() {
        return OtcMarketPriceConfigUtil.f(true);
    }

    /* renamed from: xj */
    public String rj(MarketCoin.Coin coin) {
        return coin.getShortName();
    }
}
