package bt;

import android.content.Context;
import android.view.View;
import com.huobi.order.bean.TimeTradeInfo;
import com.huobi.trade.handler.TimeOrderHandler;

public final /* synthetic */ class a2 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12874b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TimeTradeInfo f12875c;

    public /* synthetic */ a2(Context context, TimeTradeInfo timeTradeInfo) {
        this.f12874b = context;
        this.f12875c = timeTradeInfo;
    }

    public final void onClick(View view) {
        TimeOrderHandler.g(this.f12874b, this.f12875c, view);
    }
}
