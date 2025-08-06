package bt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.trade.handler.FilledOrderHandler;

public final /* synthetic */ class i0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12913b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderBeanDetails f12914c;

    public /* synthetic */ i0(Context context, OrderBeanDetails orderBeanDetails) {
        this.f12913b = context;
        this.f12914c = orderBeanDetails;
    }

    public final void onClick(View view) {
        FilledOrderHandler.h(this.f12913b, this.f12914c, view);
    }
}
