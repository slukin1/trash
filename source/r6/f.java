package r6;

import com.hbg.lib.core.page.SmartRefreshPageSplitter;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class f implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SmartRefreshPageSplitter f70511b;

    public /* synthetic */ f(SmartRefreshPageSplitter smartRefreshPageSplitter) {
        this.f70511b = smartRefreshPageSplitter;
    }

    public final void call(Object obj) {
        this.f70511b.u((List) obj);
    }
}
