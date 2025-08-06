package dk;

import android.view.View;
import com.huobi.edgeengine.model.NavModel;
import com.huobi.edgeengine.ui.EdgeEngineContainerActivity;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavModel f53795b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EdgeEngineContainerActivity f53796c;

    public /* synthetic */ b(NavModel navModel, EdgeEngineContainerActivity edgeEngineContainerActivity) {
        this.f53795b = navModel;
        this.f53796c = edgeEngineContainerActivity;
    }

    public final void onClick(View view) {
        EdgeEngineContainerActivity.Oh(this.f53795b, this.f53796c, view);
    }
}
