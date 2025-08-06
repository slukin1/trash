package wk;

import com.huobi.finance.bean.ContractDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class h0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61391b;

    public /* synthetic */ h0(AssetDataCacheManager assetDataCacheManager) {
        this.f61391b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61391b.c1((ContractDataTotal) obj);
    }
}
