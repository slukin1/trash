package pt;

import android.view.View;
import android.widget.TextView;
import com.huobi.order.bean.OrderBean;
import com.huobi.tradenew.handler.OrderBeanViewHandler;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderBeanViewHandler f53225b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderBean f53226c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f53227d;

    public /* synthetic */ f(OrderBeanViewHandler orderBeanViewHandler, OrderBean orderBean, TextView textView) {
        this.f53225b = orderBeanViewHandler;
        this.f53226c = orderBean;
        this.f53227d = textView;
    }

    public final void onClick(View view) {
        this.f53225b.f(this.f53226c, this.f53227d, view);
    }
}
