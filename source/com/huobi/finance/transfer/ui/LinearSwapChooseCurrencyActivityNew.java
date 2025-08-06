package com.huobi.finance.transfer.ui;

import ad.i;
import android.app.Activity;
import android.content.Intent;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.linear.swap.controller.LinearSwapProductInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapProductInfo;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.finance.ui.TransferChooseCurrencyActivity;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashSet;
import java.util.List;
import pro.huobi.R;
import rx.Observable;
import rx.functions.Func1;
import yk.b;

public class LinearSwapChooseCurrencyActivityNew extends TransferChooseCurrencyActivity<LinearSwapProductInfo> {

    public class a implements Func1<LinearSwapProductInfo, Boolean> {

        /* renamed from: b  reason: collision with root package name */
        public HashSet<String> f46210b = new HashSet<>();

        public a() {
        }

        /* renamed from: a */
        public Boolean call(LinearSwapProductInfo linearSwapProductInfo) {
            String b11 = b(linearSwapProductInfo);
            if (this.f46210b.contains(b11)) {
                return Boolean.FALSE;
            }
            this.f46210b.add(b11);
            return Boolean.valueOf(!linearSwapProductInfo.getCurrency().equalsIgnoreCase("HT") && !linearSwapProductInfo.getCurrency().equalsIgnoreCase("HTX") && !linearSwapProductInfo.getCurrency().equalsIgnoreCase("HUSD") && !linearSwapProductInfo.getCurrency().equalsIgnoreCase("TRX"));
        }

        public final String b(LinearSwapProductInfo linearSwapProductInfo) {
            return String.format("%s_%s_%s_%s", new Object[]{linearSwapProductInfo.getSymbol(), linearSwapProductInfo.getCurrency(), linearSwapProductInfo.getUnderlyingCurrency(), ""});
        }
    }

    public static void Aj(Activity activity) {
        Intent intent = new Intent(activity, LinearSwapChooseCurrencyActivityNew.class);
        intent.putExtra("", "");
        TransferChooseCurrencyActivity.startForResult(activity, intent, 1001);
    }

    public static /* synthetic */ Integer zj(LinearSwapProductInfo linearSwapProductInfo, LinearSwapProductInfo linearSwapProductInfo2) {
        if ("usdt".equalsIgnoreCase(linearSwapProductInfo.getUnderlyingCurrency())) {
            return -3;
        }
        if ("usdt".equalsIgnoreCase(linearSwapProductInfo2.getUnderlyingCurrency())) {
            return 3;
        }
        if ("husd".equalsIgnoreCase(linearSwapProductInfo.getUnderlyingCurrency())) {
            return -2;
        }
        if ("husd".equalsIgnoreCase(linearSwapProductInfo2.getUnderlyingCurrency())) {
            return 2;
        }
        if ("usdt".equalsIgnoreCase(linearSwapProductInfo.getCurrency())) {
            return -1;
        }
        if ("usdt".equalsIgnoreCase(linearSwapProductInfo2.getCurrency())) {
            return 1;
        }
        return 0;
    }

    public String getAccount() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP;
    }

    public Observable<List<LinearSwapProductInfo>> sj() {
        return LinearSwapProductInfoController.o().j(true).flatMap(i.f3526b).filter(new a()).toSortedList(b.f61785b);
    }

    public void wj(String str) {
        Intent intent = new Intent();
        LinearSwapProductInfo linearSwapProductInfo = (LinearSwapProductInfo) qj(str);
        SymbolCurrencyEntity symbolCurrencyEntity = new SymbolCurrencyEntity();
        String underlyingCurrency = linearSwapProductInfo.getUnderlyingCurrency();
        String currency = linearSwapProductInfo.getCurrency();
        symbolCurrencyEntity.setBaseCurrency(underlyingCurrency);
        symbolCurrencyEntity.setQuoteCurrency(currency);
        symbolCurrencyEntity.setName(underlyingCurrency + Constants.ACCEPT_TIME_SEPARATOR_SERVER + currency);
        intent.putExtra("coin", symbolCurrencyEntity);
        intent.putExtra(com.tencent.android.tpush.common.Constants.FLAG_ACCOUNT, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP);
        intent.putExtra("IS_FROM", getIntent().getBooleanExtra("IS_FROM", false));
        setResult(-1, intent);
        finish();
    }

    /* renamed from: yj */
    public String rj(LinearSwapProductInfo linearSwapProductInfo) {
        if ("usdt".equalsIgnoreCase(linearSwapProductInfo.getUnderlyingCurrency())) {
            return getString(R.string.n_linear_swap_cross_account);
        }
        if ("husd".equalsIgnoreCase(linearSwapProductInfo.getUnderlyingCurrency()) && linearSwapProductInfo.getUnderlyingCurrency().equalsIgnoreCase(linearSwapProductInfo.getCurrency())) {
            return getString(R.string.n_linear_swap_cross_husd_account);
        }
        return linearSwapProductInfo.getUnderlyingCurrency() + "/" + linearSwapProductInfo.getCurrency();
    }
}
