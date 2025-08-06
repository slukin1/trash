package bt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.TimeTradeInfo;
import com.huobi.trade.handler.TimeOrderHandler;

public final /* synthetic */ class b2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12879b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TimeTradeInfo f12880c;

    public /* synthetic */ b2(Context context, TimeTradeInfo timeTradeInfo) {
        this.f12879b = context;
        this.f12880c = timeTradeInfo;
    }

    public final void onClick(View view) {
        TimeOrderHandler.h(this.f12879b, this.f12880c, view);
    }
}
