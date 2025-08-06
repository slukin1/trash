package dt;

import com.huobi.margin.entity.MarginBalanceQueryData;
import java.util.Map;
import java.util.Set;
import rx.functions.Action2;

public final /* synthetic */ class q implements Action2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f54130b;

    public /* synthetic */ q(Set set) {
        this.f54130b = set;
    }

    public final void call(Object obj, Object obj2) {
        h2.t3(this.f54130b, (Map) obj, (MarginBalanceQueryData) obj2);
    }
}
