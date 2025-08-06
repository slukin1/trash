package yp;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.page.SmartRefreshPageSplitter;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SmartRefreshPageSplitter f61970b;

    public /* synthetic */ d(SmartRefreshPageSplitter smartRefreshPageSplitter) {
        this.f61970b = smartRefreshPageSplitter;
    }

    public final void call(Object obj) {
        this.f61970b.w((APIStatusErrorException) obj);
    }
}
