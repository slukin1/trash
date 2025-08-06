package i8;

import com.hbg.lib.network.linear.swap.core.bean.UnionSupportCurrency;
import rx.Observable;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ n f55026b = new n();

    public final Object call(Object obj) {
        return Observable.from(((UnionSupportCurrency) obj).getCurrencyList());
    }
}
