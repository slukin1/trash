package wk;

import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61379b;

    public /* synthetic */ c(AssetDataCacheManager assetDataCacheManager) {
        this.f61379b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61379b.n1((SuperMarginDataTotal) obj);
    }
}
