package bt;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.network.pro.core.bean.ExchangeOpenOrder;
import com.huobi.order.bean.ExchangeOpenOrderItem;
import com.huobi.trade.handler.ExchangeOpenOrderItemViewHandler;

public final /* synthetic */ class h0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExchangeOpenOrderItemViewHandler f12906b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExchangeOpenOrder f12907c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExchangeOpenOrderItem f12908d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f12909e;

    public /* synthetic */ h0(ExchangeOpenOrderItemViewHandler exchangeOpenOrderItemViewHandler, ExchangeOpenOrder exchangeOpenOrder, ExchangeOpenOrderItem exchangeOpenOrderItem, TextView textView) {
        this.f12906b = exchangeOpenOrderItemViewHandler;
        this.f12907c = exchangeOpenOrder;
        this.f12908d = exchangeOpenOrderItem;
        this.f12909e = textView;
    }

    public final void onClick(View view) {
        this.f12906b.f(this.f12907c, this.f12908d, this.f12909e, view);
    }
}
