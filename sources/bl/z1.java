package bl;

import android.view.View;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.viewhandler.AssetTotalBalanceViewHandler;

public final /* synthetic */ class z1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetTotalBalanceViewHandler f12807b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseAssetTotal f12808c;

    public /* synthetic */ z1(AssetTotalBalanceViewHandler assetTotalBalanceViewHandler, BaseAssetTotal baseAssetTotal) {
        this.f12807b = assetTotalBalanceViewHandler;
        this.f12808c = baseAssetTotal;
    }

    public final void onClick(View view) {
        this.f12807b.o(this.f12808c, view);
    }
}
