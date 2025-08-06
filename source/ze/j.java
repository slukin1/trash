package ze;

import android.content.Context;
import android.view.View;
import com.hbg.module.linear.swap.viewhandler.LinearSwapPositionOrderItemHandler;

public final /* synthetic */ class j implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f62149b;

    public /* synthetic */ j(Context context) {
        this.f62149b = context;
    }

    public final void onClick(View view) {
        LinearSwapPositionOrderItemHandler.t(this.f62149b, view);
    }
}
