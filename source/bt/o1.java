package bt;

import android.view.View;
import android.widget.TextView;
import com.huobi.order.bean.OrderBean;
import com.huobi.trade.handler.OrderBeanViewHandler;

public final /* synthetic */ class o1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OrderBeanViewHandler f12950b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OrderBean f12951c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f12952d;

    public /* synthetic */ o1(OrderBeanViewHandler orderBeanViewHandler, OrderBean orderBean, TextView textView) {
        this.f12950b = orderBeanViewHandler;
        this.f12951c = orderBean;
        this.f12952d = textView;
    }

    public final void onClick(View view) {
        this.f12950b.f(this.f12951c, this.f12952d, view);
    }
}
