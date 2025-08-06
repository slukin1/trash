package xk;

import com.huobi.finance.model.subaccount.GridDataProvider;
import java.util.List;
import java.util.Map;
import rx.functions.Func3;

public final /* synthetic */ class d implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ GridDataProvider f61628b;

    public /* synthetic */ d(GridDataProvider gridDataProvider) {
        this.f61628b = gridDataProvider;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return this.f61628b.d((Map) obj, (List) obj2, (List) obj3);
    }
}
