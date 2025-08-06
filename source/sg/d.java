package sg;

import com.huobi.account.handler.SubscribeAllHandler;
import pg.c;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f66615b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ v9.c f66616c;

    public /* synthetic */ d(c cVar, v9.c cVar2) {
        this.f66615b = cVar;
        this.f66616c = cVar2;
    }

    public final void call(Object obj) {
        SubscribeAllHandler.d(this.f66615b, this.f66616c, (Void) obj);
    }
}
