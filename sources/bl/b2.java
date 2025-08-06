package bl;

import android.view.View;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.viewhandler.AssetTotalViewHandler;

public final /* synthetic */ class b2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAssetTotal f12548b;

    public /* synthetic */ b2(BaseAssetTotal baseAssetTotal) {
        this.f12548b = baseAssetTotal;
    }

    public final void onClick(View view) {
        AssetTotalViewHandler.l(this.f12548b, view);
    }
}
