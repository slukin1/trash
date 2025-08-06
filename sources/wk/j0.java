package wk;

import com.huobi.finance.bean.LinearSwapDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class j0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61396b;

    public /* synthetic */ j0(AssetDataCacheManager assetDataCacheManager) {
        this.f61396b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61396b.e1((LinearSwapDataTotal) obj);
    }
}
