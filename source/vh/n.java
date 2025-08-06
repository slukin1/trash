package vh;

import android.content.Context;
import android.view.View;
import com.huobi.asset.widget.AssetLoadingView;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61048b;

    public /* synthetic */ n(Context context) {
        this.f61048b = context;
    }

    public final void onClick(View view) {
        AssetLoadingView.f(this.f61048b, view);
    }
}
