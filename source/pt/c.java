package pt;

import android.view.View;
import android.widget.TextView;
import com.hbg.lib.network.pro.core.bean.ExchangeOpenOrder;
import com.huobi.order.bean.ExchangeOpenOrderItem;
import com.huobi.tradenew.handler.ExchangeOpenOrderItemViewHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExchangeOpenOrderItemViewHandler f53217b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ExchangeOpenOrder f53218c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExchangeOpenOrderItem f53219d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TextView f53220e;

    public /* synthetic */ c(ExchangeOpenOrderItemViewHandler exchangeOpenOrderItemViewHandler, ExchangeOpenOrder exchangeOpenOrder, ExchangeOpenOrderItem exchangeOpenOrderItem, TextView textView) {
        this.f53217b = exchangeOpenOrderItemViewHandler;
        this.f53218c = exchangeOpenOrder;
        this.f53219d = exchangeOpenOrderItem;
        this.f53220e = textView;
    }

    public final void onClick(View view) {
        this.f53217b.f(this.f53218c, this.f53219d, this.f53220e, view);
    }
}
