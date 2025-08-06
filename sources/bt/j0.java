package bt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.trade.handler.FilledOrderHandler;

public final /* synthetic */ class j0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12919b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderBeanDetails f12920c;

    public /* synthetic */ j0(Context context, OrderBeanDetails orderBeanDetails) {
        this.f12919b = context;
        this.f12920c = orderBeanDetails;
    }

    public final void onClick(View view) {
        FilledOrderHandler.g(this.f12919b, this.f12920c, view);
    }
}
