package bt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.TimeTradeInfo;
import com.huobi.trade.handler.TimeOrderHandler;

public final /* synthetic */ class c2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12885b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TimeTradeInfo f12886c;

    public /* synthetic */ c2(Context context, TimeTradeInfo timeTradeInfo) {
        this.f12885b = context;
        this.f12886c = timeTradeInfo;
    }

    public final void onClick(View view) {
        TimeOrderHandler.f(this.f12885b, this.f12886c, view);
    }
}
