package qk;

import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.index.core.controller.IndexCurrencyInfoController;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.huobi.contract.helper.ContractCurrencyUtils;
import java.util.List;
import rx.Observable;
import u6.g;

public final class h {
    public static Observable<Object> g() {
        return Observable.zip(ContractCurrencyUtils.g(false).onErrorReturn(e.f59961b).compose(RxJavaHelper.t((g) null)), SwapCurrencyInfoController.k().f(false).onErrorReturn(c.f59954b).compose(RxJavaHelper.t((g) null)), FutureContractInfoController.n().h(TradeType.LINEAR_SWAP, false).onErrorReturn(b.f59950b).compose(RxJavaHelper.t((g) null)), IndexCurrencyInfoController.k().g(false).onErrorReturn(f.f59964b).compose(RxJavaHelper.t((g) null)), FutureContractInfoController.n().s(false).onErrorReturn(d.f59959b).compose(RxJavaHelper.t((g) null)), g.f59967b);
    }

    public static /* synthetic */ List h(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List i(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List j(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List k(Throwable th2) {
        return null;
    }

    public static /* synthetic */ List l(Throwable th2) {
        return null;
    }

    public static /* synthetic */ Object m(List list, List list2, List list3, List list4, List list5) {
        return new Object();
    }
}
