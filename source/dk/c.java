package dk;

import android.view.View;
import com.huobi.edgeengine.model.NavModel;
import com.huobi.edgeengine.ui.EdgeEngineContainerActivity;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavModel f53797b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EdgeEngineContainerActivity f53798c;

    public /* synthetic */ c(NavModel navModel, EdgeEngineContainerActivity edgeEngineContainerActivity) {
        this.f53797b = navModel;
        this.f53798c = edgeEngineContainerActivity;
    }

    public final void onClick(View view) {
        EdgeEngineContainerActivity.Rh(this.f53797b, this.f53798c, view);
    }
}
