package wk;

import com.huobi.finance.bean.C2CMarginBalanceDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import java.util.List;
import rx.functions.Func3;

public final /* synthetic */ class z implements Func3 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f61423b;

    public /* synthetic */ z(String str) {
        this.f61423b = str;
    }

    public final Object call(Object obj, Object obj2, Object obj3) {
        return AssetDataCacheManager.s1(this.f61423b, (List) obj, (C2CMarginBalanceDataTotal) obj2, (List) obj3);
    }
}
