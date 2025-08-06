package bl;

import com.huobi.asset.feature.account.spot.AssetSpotFragment;
import com.huobi.finance.ui.g7;
import com.huobi.finance.viewhandler.AssetSpotHeaderViewHandler;

public final /* synthetic */ class b1 implements g7.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AssetSpotFragment.a f12547a;

    public /* synthetic */ b1(AssetSpotFragment.a aVar) {
        this.f12547a = aVar;
    }

    public final void onSuccess() {
        AssetSpotHeaderViewHandler.D(this.f12547a);
    }
}
