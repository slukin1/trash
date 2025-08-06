package vg;

import com.huobi.account.viewhandler.AccountQuickHandler;
import com.huobi.index.bean.IndexFeatureItem;
import rx.functions.Action1;
import v9.c;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f61008b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndexFeatureItem f61009c;

    public /* synthetic */ a(c cVar, IndexFeatureItem indexFeatureItem) {
        this.f61008b = cVar;
        this.f61009c = indexFeatureItem;
    }

    public final void call(Object obj) {
        AccountQuickHandler.d(this.f61008b, this.f61009c, (Void) obj);
    }
}
