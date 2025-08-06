package wk;

import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class a0 implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f61376b;

    public /* synthetic */ a0(String str) {
        this.f61376b = str;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return AssetDataCacheManager.u1(this.f61376b, (List) obj, (MarginBalanceDataTotal) obj2, (List) obj3);
    }
}
