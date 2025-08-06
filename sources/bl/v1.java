package bl;

import android.view.View;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.viewhandler.AssetTotalBalanceViewHandler;

public final /* synthetic */ class v1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAssetTotal f12769b;

    public /* synthetic */ v1(BaseAssetTotal baseAssetTotal) {
        this.f12769b = baseAssetTotal;
    }

    public final void onClick(View view) {
        AssetTotalBalanceViewHandler.p(this.f12769b, view);
    }
}
