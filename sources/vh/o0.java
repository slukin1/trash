package vh;

import android.content.Context;
import android.view.View;
import com.huobi.asset.widget.LoadingViewData;

public final /* synthetic */ class o0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61051b;

    public /* synthetic */ o0(Context context) {
        this.f61051b = context;
    }

    public final void onClick(View view) {
        LoadingViewData.LoadingViewHandler.e(this.f61051b, view);
    }
}
