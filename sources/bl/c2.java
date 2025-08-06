package bl;

import android.view.View;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.viewhandler.AssetTotalViewHandler;

public final /* synthetic */ class c2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetTotalViewHandler f12556b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseAssetTotal f12557c;

    public /* synthetic */ c2(AssetTotalViewHandler assetTotalViewHandler, BaseAssetTotal baseAssetTotal) {
        this.f12556b = assetTotalViewHandler;
        this.f12557c = baseAssetTotal;
    }

    public final void onClick(View view) {
        this.f12556b.k(this.f12557c, view);
    }
}
