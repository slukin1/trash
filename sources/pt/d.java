package pt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.tradenew.handler.FilledOrderHandler;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f53221b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderBeanDetails f53222c;

    public /* synthetic */ d(Context context, OrderBeanDetails orderBeanDetails) {
        this.f53221b = context;
        this.f53222c = orderBeanDetails;
    }

    public final void onClick(View view) {
        FilledOrderHandler.h(this.f53221b, this.f53222c, view);
    }
}
