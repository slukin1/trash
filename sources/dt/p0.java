package dt;

import com.huobi.account.entity.SubaccountQueryData;
import java.util.Set;
import rx.functions.Func1;

public final /* synthetic */ class p0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Set f54125b;

    public /* synthetic */ p0(Set set) {
        this.f54125b = set;
    }

    public final Object call(Object obj) {
        return Boolean.valueOf(this.f54125b.contains(((SubaccountQueryData) obj).getCurrency()));
    }
}
