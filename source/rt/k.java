package rt;

import android.view.View;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.trade.bean.OrderPlaceBean;

public final /* synthetic */ class k implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ z f25841b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f25842c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ OrderPlaceBean f25843d;

    public /* synthetic */ k(z zVar, TradeType tradeType, OrderPlaceBean orderPlaceBean) {
        this.f25841b = zVar;
        this.f25842c = tradeType;
        this.f25843d = orderPlaceBean;
    }

    public final void onClick(View view) {
        this.f25841b.U(this.f25842c, this.f25843d, view);
    }
}
