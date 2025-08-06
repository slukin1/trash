package d7;

import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.main.ChainDataDiffTools;
import com.hbg.lib.data.main.CurrencyDataDiffTools;
import com.hbg.lib.data.main.SymbolDataDiffTools;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import rx.Observable;
import rx.schedulers.Schedulers;

public final class m {
    public static void c() {
        SymbolDataDiffTools.r().q(true);
        a1.v().Y(false, false).compose(RxJavaHelper.s()).subscribe(new BaseSubscriber());
        CurrencyDataDiffTools.r().q(true);
        ChainDataDiffTools.r().q(true);
        Observable.just("").map(l.f53515b).subscribeOn(Schedulers.io()).subscribe(new BaseSubscriber());
    }
}
