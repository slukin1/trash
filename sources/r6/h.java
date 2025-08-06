package r6;

import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import rx.Observable;

public final /* synthetic */ class h implements Observable.Transformer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SmartRefreshPageSplitter.a f70513b;

    public /* synthetic */ h(SmartRefreshPageSplitter.a aVar) {
        this.f70513b = aVar;
    }

    public final Object call(Object obj) {
        return this.f70513b.d((Observable) obj);
    }
}
