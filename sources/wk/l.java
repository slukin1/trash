package wk;

import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class l implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61399b;

    public /* synthetic */ l(AssetDataCacheManager assetDataCacheManager) {
        this.f61399b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61399b.b1((BalanceDataTotal) obj);
    }
}
