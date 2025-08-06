package pt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.OrderBeanDetails;
import com.huobi.tradenew.handler.FilledOrderHandler;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f53223b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderBeanDetails f53224c;

    public /* synthetic */ e(Context context, OrderBeanDetails orderBeanDetails) {
        this.f53223b = context;
        this.f53224c = orderBeanDetails;
    }

    public final void onClick(View view) {
        FilledOrderHandler.g(this.f53223b, this.f53224c, view);
    }
}
