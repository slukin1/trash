package wk;

import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import u6.g;
import v7.b;
import vk.x;

public class a1 implements SmartRefreshPageSplitter.c<x> {

    /* renamed from: a  reason: collision with root package name */
    public g f48070a;

    public a1(g gVar) {
        this.f48070a = gVar;
    }

    public static /* synthetic */ Observable h(HbgIntCodeResponse hbgIntCodeResponse) {
        if (hbgIntCodeResponse.isSuccess()) {
            return Observable.from((Iterable) hbgIntCodeResponse.getData());
        }
        return Observable.empty();
    }

    public Func1<? super x, ? extends Long> a() {
        return y0.f61422b;
    }

    public Observable<List<x>> c() {
        return f((Long) null);
    }

    public final Observable<List<x>> f(Long l11) {
        return b.a().getUsdtExchangeHistory(l11, 11L).b().flatMap(x0.f61420b).map(z0.f61424b).toList().compose(RxJavaHelper.t(this.f48070a));
    }

    /* renamed from: i */
    public Observable<List<x>> b(x xVar) {
        return f(Long.valueOf(xVar.c().getId()));
    }
}
