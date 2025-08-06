package vh;

import android.content.res.Resources;
import android.view.View;
import com.huobi.asset.widget.AssetHeadView;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Resources f61027b;

    public /* synthetic */ e(Resources resources) {
        this.f61027b = resources;
    }

    public final void onClick(View view) {
        AssetHeadView.u(this.f61027b, view);
    }
}
