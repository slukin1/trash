package xk;

import com.huobi.finance.model.subaccount.MiningDataProvider;
import java.util.List;
import java.util.Map;
import rx.functions.Func4;

public final /* synthetic */ class m implements Func4 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MiningDataProvider f61637b;

    public /* synthetic */ m(MiningDataProvider miningDataProvider) {
        this.f61637b = miningDataProvider;
    }

    public final Object call(Object obj, Object obj2, Object obj3, Object obj4) {
        return this.f61637b.j((List) obj, (List) obj2, (List) obj3, (Map) obj4);
    }
}
