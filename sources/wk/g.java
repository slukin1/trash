package wk;

import com.huobi.finance.model.AssetDataCacheManager;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class g implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f61388b;

    public /* synthetic */ g(boolean z11) {
        this.f61388b = z11;
    }

    public final Object call(Object obj) {
        return AssetDataCacheManager.a1(this.f61388b, (List) obj);
    }
}
