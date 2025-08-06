package oh;

import com.hbg.lib.network.hbg.core.bean.UsdtExchangeConfig;
import com.huobi.asset.feature.account.spot.AssetSpotFragment;
import rx.functions.Action1;

public final /* synthetic */ class a implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSpotFragment f58854b;

    public /* synthetic */ a(AssetSpotFragment assetSpotFragment) {
        this.f58854b = assetSpotFragment;
    }

    public final void call(Object obj) {
        this.f58854b.li((UsdtExchangeConfig) obj);
    }
}
