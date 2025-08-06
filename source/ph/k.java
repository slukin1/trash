package ph;

import com.huobi.asset.feature.base.BaseAssetListFragment;
import com.huobi.finance.bean.BaseAssetTotal;
import rx.functions.Action1;

public final /* synthetic */ class k implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAssetListFragment f53048b;

    public /* synthetic */ k(BaseAssetListFragment baseAssetListFragment) {
        this.f53048b = baseAssetListFragment;
    }

    public final void call(Object obj) {
        this.f53048b.Xh((BaseAssetTotal) obj);
    }
}
