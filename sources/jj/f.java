package jj;

import com.huobi.currencyconfig.bean.StableCoinCreate;
import com.huobi.currencyconfig.bean.StableCoinHints;
import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import java.util.List;
import java.util.Map;
import rx.Observable;

public interface f {
    Observable<StableCoinCreate> a(Map<String, Object> map);

    Observable<List<StableCoinHints>> b(boolean z11);

    Observable<List<StableCurrencyRateBean.StableCurrencyBean>> c(boolean z11);

    List<StableCurrencyRateBean.StableCurrencyBean> d();

    Observable<String> e(String str);

    StableCurrencyRateBean.TradeCurrencyBean f();
}
