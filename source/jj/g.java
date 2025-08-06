package jj;

import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import com.huobi.currencyconfig.helper.StableCurrencyRateConfigImpl;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StableCurrencyRateConfigImpl f55955b;

    public /* synthetic */ g(StableCurrencyRateConfigImpl stableCurrencyRateConfigImpl) {
        this.f55955b = stableCurrencyRateConfigImpl;
    }

    public final Object call(Object obj) {
        return this.f55955b.m((StableCurrencyRateBean) obj);
    }
}
