package wk;

import com.huobi.finance.bean.C2CLendBalanceDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class w implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61418b;

    public /* synthetic */ w(AssetDataCacheManager assetDataCacheManager) {
        this.f61418b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61418b.r1((C2CLendBalanceDataTotal) obj);
    }
}
