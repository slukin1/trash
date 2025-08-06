package dt;

import com.huobi.account.entity.SubaccountQueryData;
import java.util.Set;
import rx.functions.Func1;

public final /* synthetic */ class q0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f54131b;

    public /* synthetic */ q0(Set set) {
        this.f54131b = set;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(this.f54131b.contains(((SubaccountQueryData) obj).getCurrency()));
    }
}
