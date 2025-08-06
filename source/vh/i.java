package vh;

import android.view.View;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetTotal;

public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetHeadView f61036b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BaseAssetTotal f61037c;

    public /* synthetic */ i(AssetHeadView assetHeadView, BaseAssetTotal baseAssetTotal) {
        this.f61036b = assetHeadView;
        this.f61037c = baseAssetTotal;
    }

    public final void onClick(View view) {
        this.f61036b.z(this.f61037c, view);
    }
}
