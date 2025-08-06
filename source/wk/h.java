package wk;

import com.huobi.finance.model.AssetDataCacheManager;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class h implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f61390b;

    public /* synthetic */ h(boolean z11) {
        this.f61390b = z11;
    }

    public final Object call(Object obj) {
        return AssetDataCacheManager.k1(this.f61390b, (List) obj);
    }
}
