package wk;

import com.huobi.finance.model.AssetDataCacheManager;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class e implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetDataCacheManager f61383b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f61384c;

    public /* synthetic */ e(AssetDataCacheManager assetDataCacheManager, boolean z11) {
        this.f61383b = assetDataCacheManager;
        this.f61384c = z11;
    }

    public final Object call(Object obj) {
        return this.f61383b.m1(this.f61384c, (List) obj);
    }
}
