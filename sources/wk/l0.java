package wk;

import com.huobi.finance.bean.MineDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class l0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61400b;

    public /* synthetic */ l0(AssetDataCacheManager assetDataCacheManager) {
        this.f61400b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61400b.h1((MineDataTotal) obj);
    }
}
