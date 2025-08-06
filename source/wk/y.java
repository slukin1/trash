package wk;

import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import java.util.List;
import rx.functions.Func2;

public final /* synthetic */ class y implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f61421b;

    public /* synthetic */ y(String str) {
        this.f61421b = str;
    }

    public final Object call(Object obj, Object obj2) {
        return AssetDataCacheManager.x1(this.f61421b, (MarginBalanceDataTotal) obj, (List) obj2);
    }
}
