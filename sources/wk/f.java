package wk;

import com.huobi.finance.model.AssetDataCacheManager;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class f implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f61386b;

    public /* synthetic */ f(boolean z11) {
        this.f61386b = z11;
    }

    public final Object call(Object obj) {
        return AssetDataCacheManager.g1(this.f61386b, (List) obj);
    }
}
