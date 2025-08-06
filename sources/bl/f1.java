package bl;

import android.view.View;
import com.huobi.asset.feature.account.spot.AssetSpotFragment;
import com.huobi.finance.viewhandler.AssetSpotHeaderViewHandler;

public final /* synthetic */ class f1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSpotHeaderViewHandler f12583b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AssetSpotFragment.a f12584c;

    public /* synthetic */ f1(AssetSpotHeaderViewHandler assetSpotHeaderViewHandler, AssetSpotFragment.a aVar) {
        this.f12583b = assetSpotHeaderViewHandler;
        this.f12584c = aVar;
    }

    public final void onClick(View view) {
        this.f12583b.E(this.f12584c, view);
    }
}
