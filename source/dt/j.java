package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h2 f54060b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54061c;

    public /* synthetic */ j(h2 h2Var, TradeType tradeType) {
        this.f54060b = h2Var;
        this.f54061c = tradeType;
    }

    public final void call(Object obj) {
        this.f54060b.B2(this.f54061c, (BalanceQueryData) obj);
    }
}
