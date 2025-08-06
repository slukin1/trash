package fn;

import c6.b;
import com.huobi.lite.LiteIndexInterfaceImpl;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteIndexInterfaceImpl f54706b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f54707c;

    public /* synthetic */ e(LiteIndexInterfaceImpl liteIndexInterfaceImpl, b bVar) {
        this.f54706b = liteIndexInterfaceImpl;
        this.f54707c = bVar;
    }

    public final void call(Object obj) {
        this.f54706b.k(this.f54707c, (Throwable) obj);
    }
}
