package r6;

import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SmartRefreshPageSplitter f70509b;

    public /* synthetic */ d(SmartRefreshPageSplitter smartRefreshPageSplitter) {
        this.f70509b = smartRefreshPageSplitter;
    }

    public final void call(Object obj) {
        this.f70509b.v((APIStatusErrorException) obj);
    }
}
