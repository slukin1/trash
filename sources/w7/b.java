package w7;

import com.hbg.lib.network.hbg.c2c.C2CCurrencyProvider;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class b implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2CCurrencyProvider.a f61224b;

    public /* synthetic */ b(C2CCurrencyProvider.a aVar) {
        this.f61224b = aVar;
    }

    public final Object call(Object obj) {
        return C2CCurrencyProvider.n((List) obj, this.f61224b);
    }
}
