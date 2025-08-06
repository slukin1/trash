package bl;

import android.view.View;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.viewhandler.AssetTotalViewHandler;

public final /* synthetic */ class d2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetTotalViewHandler f12565b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseAssetTotal f12566c;

    public /* synthetic */ d2(AssetTotalViewHandler assetTotalViewHandler, BaseAssetTotal baseAssetTotal) {
        this.f12565b = assetTotalViewHandler;
        this.f12566c = baseAssetTotal;
    }

    public final void onClick(View view) {
        this.f12565b.j(this.f12566c, view);
    }
}
