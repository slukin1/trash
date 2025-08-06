package jh;

import com.huobi.asset.feature.account.huobiearn.AssetHuobiEarnFragment;
import com.huobi.finance.bean.BaseAssetTotal;
import rx.functions.Action1;

public final /* synthetic */ class g implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetHuobiEarnFragment f55939b;

    public /* synthetic */ g(AssetHuobiEarnFragment assetHuobiEarnFragment) {
        this.f55939b = assetHuobiEarnFragment;
    }

    public final void call(Object obj) {
        this.f55939b.di((BaseAssetTotal) obj);
    }
}
