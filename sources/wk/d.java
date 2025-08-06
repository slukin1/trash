package wk;

import com.huobi.finance.bean.SwapDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61381b;

    public /* synthetic */ d(AssetDataCacheManager assetDataCacheManager) {
        this.f61381b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61381b.o1((SwapDataTotal) obj);
    }
}
