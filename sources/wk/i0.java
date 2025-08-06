package wk;

import com.huobi.finance.bean.LegalDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class i0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61394b;

    public /* synthetic */ i0(AssetDataCacheManager assetDataCacheManager) {
        this.f61394b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61394b.d1((LegalDataTotal) obj);
    }
}
