package nh;

import com.huobi.asset.feature.account.quant.AssetQuantFragment;
import com.huobi.finance.bean.BaseAssetTotal;
import rx.functions.Action1;

public final /* synthetic */ class e implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetQuantFragment f58542b;

    public /* synthetic */ e(AssetQuantFragment assetQuantFragment) {
        this.f58542b = assetQuantFragment;
    }

    public final void call(Object obj) {
        this.f58542b.Uh((BaseAssetTotal) obj);
    }
}
