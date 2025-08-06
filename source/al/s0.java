package al;

import android.text.TextUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.o;
import com.hbg.lib.data.future.controller.FutureProductInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.c2c.C2CSymbolsProvider;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.MineAccountItem;
import com.hbg.lib.network.hbg.core.bean.MineCurrencyProvider;
import com.hbg.lib.network.linear.swap.controller.LinearSwapProductInfoController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapProductInfo;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.swap.core.bean.ProductInfo;
import com.huobi.contract.entity.ContractCoinInfo;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.finance.bean.SymbolCurrencyEntity;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import d7.a1;
import d7.c0;
import java.util.List;
import java.util.concurrent.TimeUnit;
import ks.d;
import qs.a;
import rx.Observable;
import u6.g;

public final class s0 {
    public static Observable<Boolean> b(g gVar, boolean z11) {
        Observable<R> observable;
        Observable<R> onErrorResumeNext = a1.v().Y(z11, false).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null));
        Observable<List<MarketCoin.Coin>> f11 = OtcMarketPriceConfigUtil.f(z11);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Observable<R> onErrorResumeNext2 = f11.timeout(5000, timeUnit).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null));
        if (o.h()) {
            observable = ContractCurrencyUtils.f(z11, "0").timeout(5000, timeUnit).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null));
        } else {
            observable = Observable.just(null);
        }
        Observable<R> onErrorResumeNext3 = a.f84586a.f(z11).timeout(5000, timeUnit).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null));
        Observable<R> onErrorResumeNext4 = LinearSwapProductInfoController.o().j(z11).timeout(5000, timeUnit).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null));
        Observable<R> onErrorResumeNext5 = FutureProductInfoController.d().h(z11).timeout(5000, timeUnit).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null));
        Observable<R> onErrorResumeNext6 = d.g(z11).timeout(5000, timeUnit).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null));
        Observable<R> onErrorResumeNext7 = C2CSymbolsProvider.c(z11).timeout(5000, timeUnit).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null));
        return Observable.zip(onErrorResumeNext, onErrorResumeNext2, observable, onErrorResumeNext3, onErrorResumeNext4, onErrorResumeNext5, onErrorResumeNext6, onErrorResumeNext7, b0.e(z11).timeout(5000, timeUnit).compose(RxJavaHelper.t(gVar)).onErrorResumeNext(Observable.just(null)), r0.f3598b);
    }

    public static boolean c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            boolean z11 = ("3".equals(str) || BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(str) || "8".equals(str)) && "1".equals(str2);
            boolean z12 = ("3".equals(str2) || BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL.equals(str2) || "8".equals(str2)) && "1".equals(str);
            if (z11 || z12) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(String str) {
        return (str == null || C2CSymbolsProvider.g(str) == null) ? false : true;
    }

    public static boolean e(String str) {
        List<ContractCoinInfo> d11;
        if (!o.h() || str == null || (d11 = ContractCurrencyUtils.d()) == null || d11.isEmpty()) {
            return false;
        }
        for (ContractCoinInfo next : d11) {
            if (next != null && str.equalsIgnoreCase(next.getSymbol())) {
                return true;
            }
        }
        return false;
    }

    public static boolean f(SymbolCurrencyEntity symbolCurrencyEntity) {
        List<LinearSwapProductInfo> i11;
        if (symbolCurrencyEntity == null || (i11 = LinearSwapProductInfoController.o().i()) == null || i11.isEmpty()) {
            return false;
        }
        for (LinearSwapProductInfo next : i11) {
            if (!(next == null || symbolCurrencyEntity.getBaseCurrency() == null || symbolCurrencyEntity.getQuoteCurrency() == null)) {
                if (symbolCurrencyEntity.getBaseCurrency().equalsIgnoreCase(next.getUnderlyingCurrency()) || symbolCurrencyEntity.getQuoteCurrency().equalsIgnoreCase(next.getCurrency())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean g(String str) {
        List<SymbolBean> Z;
        if (str == null || (Z = a1.v().Z(TradeType.MARGIN)) == null || Z.isEmpty()) {
            return false;
        }
        for (SymbolBean next : Z) {
            if (next != null && (str.equalsIgnoreCase(next.getSymbol()) || str.equalsIgnoreCase(next.getBaseCurrency()) || str.equalsIgnoreCase(next.getQuoteCurrency()))) {
                return true;
            }
        }
        return false;
    }

    public static boolean h(String str) {
        MineAccountItem queryMineAccountItem;
        if (str == null || (queryMineAccountItem = MineCurrencyProvider.queryMineAccountItem(str)) == null || !queryMineAccountItem.isTransferable()) {
            return false;
        }
        return true;
    }

    public static boolean i(String str) {
        return FutureProductInfoController.d().g(str) != null;
    }

    public static boolean j(String str) {
        return c0.d(str);
    }

    public static boolean k(String str) {
        List<MarketCoin.Coin> e11;
        if (str == null || (e11 = OtcMarketPriceConfigUtil.e()) == null || e11.isEmpty()) {
            return false;
        }
        for (MarketCoin.Coin next : e11) {
            if (next != null && str.equalsIgnoreCase(next.getCoinCode())) {
                return true;
            }
        }
        return false;
    }

    public static boolean l(String str) {
        List<ProductInfo> a11;
        if (str == null || (a11 = a.f84586a.a()) == null || a11.isEmpty()) {
            return false;
        }
        for (ProductInfo next : a11) {
            if (next != null && str.equalsIgnoreCase(next.getSymbol())) {
                return true;
            }
        }
        return false;
    }
}
