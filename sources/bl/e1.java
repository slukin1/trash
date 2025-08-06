package bl;

import android.view.View;
import com.huobi.finance.viewhandler.AssetSpotHeaderViewHandler;

public final /* synthetic */ class e1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSpotHeaderViewHandler f12574b;

    public /* synthetic */ e1(AssetSpotHeaderViewHandler assetSpotHeaderViewHandler) {
        this.f12574b = assetSpotHeaderViewHandler;
    }

    public final void onClick(View view) {
        this.f12574b.y(view);
    }
}
