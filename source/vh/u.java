package vh;

import android.content.Context;
import android.view.View;
import com.huobi.asset.widget.AssetPositionLoadingViewData;

public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61057b;

    public /* synthetic */ u(Context context) {
        this.f61057b = context;
    }

    public final void onClick(View view) {
        AssetPositionLoadingViewData.LoadingViewHandler.e(this.f61057b, view);
    }
}
