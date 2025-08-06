package ph;

import com.huobi.asset.feature.base.AssetSubTypeBaseFragment;
import com.huobi.finance.bean.BaseAssetTotal;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSubTypeBaseFragment f53042b;

    public /* synthetic */ e(AssetSubTypeBaseFragment assetSubTypeBaseFragment) {
        this.f53042b = assetSubTypeBaseFragment;
    }

    public final void call(Object obj) {
        this.f53042b.Oh((BaseAssetTotal) obj);
    }
}
