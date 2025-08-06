package fn;

import c6.b;
import com.huobi.account.entity.HomeActivityEntityResponse;
import com.huobi.lite.LiteIndexInterfaceImpl;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LiteIndexInterfaceImpl f54704b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ b f54705c;

    public /* synthetic */ d(LiteIndexInterfaceImpl liteIndexInterfaceImpl, b bVar) {
        this.f54704b = liteIndexInterfaceImpl;
        this.f54705c = bVar;
    }

    public final void call(Object obj) {
        this.f54704b.i(this.f54705c, (HomeActivityEntityResponse) obj);
    }
}
