package wk;

import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;
import u6.g;
import v7.b;
import vk.q;

public class v0 implements SmartRefreshPageSplitter.c<q> {

    /* renamed from: a  reason: collision with root package name */
    public g f48079a;

    public v0(g gVar) {
        this.f48079a = gVar;
    }

    public static /* synthetic */ Observable h(HbgIntCodeResponse hbgIntCodeResponse) {
        if (hbgIntCodeResponse.isSuccess()) {
            return Observable.from((Iterable) hbgIntCodeResponse.getData());
        }
        return Observable.empty();
    }

    public Func1<? super q, ? extends Long> a() {
        return t0.f61414b;
    }

    public Observable<List<q>> c() {
        return f((Long) null);
    }

    public final Observable<List<q>> f(Long l11) {
        return b.a().getHtExchangeHistory(l11, 11L).b().flatMap(s0.f61412b).map(u0.f61416b).toList().compose(RxJavaHelper.t(this.f48079a));
    }

    /* renamed from: i */
    public Observable<List<q>> b(q qVar) {
        return f(Long.valueOf(qVar.c().getId()));
    }
}
