package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Action1;

public final /* synthetic */ class n implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h2 f54108b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54109c;

    public /* synthetic */ n(h2 h2Var, TradeType tradeType) {
        this.f54108b = h2Var;
        this.f54109c = tradeType;
    }

    public final void call(Object obj) {
        this.f54108b.H2(this.f54109c, (BalanceQueryData) obj);
    }
}
