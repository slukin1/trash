package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Action1;

public final /* synthetic */ class o implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h2 f54115b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54116c;

    public /* synthetic */ o(h2 h2Var, TradeType tradeType) {
        this.f54115b = h2Var;
        this.f54116c = tradeType;
    }

    public final void call(Object obj) {
        this.f54115b.N2(this.f54116c, (BalanceQueryData) obj);
    }
}
