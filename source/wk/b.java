package wk;

import com.huobi.finance.bean.SavingsDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class b implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61377b;

    public /* synthetic */ b(AssetDataCacheManager assetDataCacheManager) {
        this.f61377b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61377b.l1((SavingsDataTotal) obj);
    }
}
