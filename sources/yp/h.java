package yp;

import com.huobi.page.SmartRefreshPageSplitter;
import rx.Observable;

public final /* synthetic */ class h implements Observable.Transformer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SmartRefreshPageSplitter.a f61974b;

    public /* synthetic */ h(SmartRefreshPageSplitter.a aVar) {
        this.f61974b = aVar;
    }

    public final Object call(Object obj) {
        return this.f61974b.d((Observable) obj);
    }
}
