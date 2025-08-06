package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Action1;

public final /* synthetic */ class i implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h2 f54048b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54049c;

    public /* synthetic */ i(h2 h2Var, TradeType tradeType) {
        this.f54048b = h2Var;
        this.f54049c = tradeType;
    }

    public final void call(Object obj) {
        this.f54048b.Q2(this.f54049c, (BalanceQueryData) obj);
    }
}
