package yh;

import com.huobi.asset2.index.component.banner.AssetBanner;
import java.util.List;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetBanner f61721b;

    public /* synthetic */ c(AssetBanner assetBanner) {
        this.f61721b = assetBanner;
    }

    public final void call(Object obj) {
        this.f61721b.e((List) obj);
    }
}
