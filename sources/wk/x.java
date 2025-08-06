package wk;

import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import java.util.List;
import rx.functions.Func2;

public final /* synthetic */ class x implements Func2 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61419b;

    public /* synthetic */ x(AssetDataCacheManager assetDataCacheManager) {
        this.f61419b = assetDataCacheManager;
    }

    public final Object call(Object obj, Object obj2) {
        return this.f61419b.N((SuperMarginDataTotal) obj, (List) obj2);
    }
}
