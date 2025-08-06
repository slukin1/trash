package wk;

import com.huobi.finance.bean.OptionDataTotal;
import com.huobi.finance.model.AssetDataCacheManager;
import rx.functions.Action1;

public final /* synthetic */ class m0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61402b;

    public /* synthetic */ m0(AssetDataCacheManager assetDataCacheManager) {
        this.f61402b = assetDataCacheManager;
    }

    public final void call(Object obj) {
        this.f61402b.i1((OptionDataTotal) obj);
    }
}
