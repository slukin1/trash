package wk;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import d7.a1;
import dt.h2;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class i implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f61392b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f61393c;

    public /* synthetic */ i(boolean z11, String str) {
        this.f61392b = z11;
        this.f61393c = str;
    }

    public final Object call(Object obj) {
        return Observable.zip(a1.v().Y(false, false), h2.t1().N1(TradeType.MARGIN, this.f61392b, false, this.f61393c), LegalCurrencyConfigUtil.X(true).timeout(5000, TimeUnit.MILLISECONDS).onErrorResumeNext(Observable.just(new ArrayList())), new a0(this.f61393c));
    }
}
