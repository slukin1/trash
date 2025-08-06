package w7;

import com.hbg.lib.network.hbg.c2c.C2CCurrencyProvider;
import com.hbg.lib.network.hbg.core.bean.C2CCurrencyBean;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2CCurrencyProvider.a f61223b;

    public /* synthetic */ a(C2CCurrencyProvider.a aVar) {
        this.f61223b = aVar;
    }

    public final int compare(Object obj, Object obj2) {
        return C2CCurrencyProvider.l(this.f61223b, (C2CCurrencyBean) obj, (C2CCurrencyBean) obj2);
    }
}
