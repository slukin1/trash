package dk;

import android.view.View;
import com.huobi.edgeengine.model.NavModel;
import com.huobi.edgeengine.ui.EdgeEngineContainerActivity;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavModel f53793b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EdgeEngineContainerActivity f53794c;

    public /* synthetic */ a(NavModel navModel, EdgeEngineContainerActivity edgeEngineContainerActivity) {
        this.f53793b = navModel;
        this.f53794c = edgeEngineContainerActivity;
    }

    public final void onClick(View view) {
        EdgeEngineContainerActivity.Qh(this.f53793b, this.f53794c, view);
    }
}
