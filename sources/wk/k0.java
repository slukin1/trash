package wk;

import com.huobi.finance.bean.MarginBalanceDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class k0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61398b;

    public /* synthetic */ k0(AssetDataCacheManager assetDataCacheManager) {
        this.f61398b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61398b.w1((MarginBalanceDataTotal) obj);
    }
}
