package fn;

import c6.b;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.lite.LiteIndexInterfaceImpl;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteIndexInterfaceImpl f54702b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f54703c;

    public /* synthetic */ c(LiteIndexInterfaceImpl liteIndexInterfaceImpl, b bVar) {
        this.f54702b = liteIndexInterfaceImpl;
        this.f54703c = bVar;
    }

    public final void call(Object obj) {
        this.f54702b.j(this.f54703c, (APIStatusErrorException) obj);
    }
}
