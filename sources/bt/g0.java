package bt;

import android.view.View;
import com.huobi.trade.bean.DepthItem;
import com.huobi.trade.handler.DepthViewHandler;

public final /* synthetic */ class g0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DepthItem f12901b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12902c;

    public /* synthetic */ g0(DepthItem depthItem, int i11) {
        this.f12901b = depthItem;
        this.f12902c = i11;
    }

    public final void onClick(View view) {
        DepthViewHandler.d(this.f12901b, this.f12902c, view);
    }
}
