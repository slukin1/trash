package pt;

import android.view.View;
import com.huobi.trade.bean.DepthItem;
import com.huobi.tradenew.handler.DepthViewHandler;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DepthItem f53215b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f53216c;

    public /* synthetic */ b(DepthItem depthItem, int i11) {
        this.f53215b = depthItem;
        this.f53216c = i11;
    }

    public final void onClick(View view) {
        DepthViewHandler.d(this.f53215b, this.f53216c, view);
    }
}
