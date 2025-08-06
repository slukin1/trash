package vh;

import android.content.Context;
import android.view.View;
import com.huobi.asset.widget.AssetLoadingPositionViewData;

public final /* synthetic */ class m implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61046b;

    public /* synthetic */ m(Context context) {
        this.f61046b = context;
    }

    public final void onClick(View view) {
        AssetLoadingPositionViewData.LoadingViewHandler.e(this.f61046b, view);
    }
}
