package vh;

import android.view.View;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetTotal;

public final /* synthetic */ class h implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetHeadView f61033b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseAssetTotal f61034c;

    public /* synthetic */ h(AssetHeadView assetHeadView, BaseAssetTotal baseAssetTotal) {
        this.f61033b = assetHeadView;
        this.f61034c = baseAssetTotal;
    }

    public final void onClick(View view) {
        this.f61033b.A(this.f61034c, view);
    }
}
