package vh;

import android.view.View;
import com.huobi.asset.widget.AssetHeadView;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetHeadView f61029b;

    public /* synthetic */ f(AssetHeadView assetHeadView) {
        this.f61029b = assetHeadView;
    }

    public final void onClick(View view) {
        this.f61029b.y(view);
    }
}
