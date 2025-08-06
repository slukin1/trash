package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Action1;

public final /* synthetic */ class k implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h2 f54073b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54074c;

    public /* synthetic */ k(h2 h2Var, TradeType tradeType) {
        this.f54073b = h2Var;
        this.f54074c = tradeType;
    }

    public final void call(Object obj) {
        this.f54073b.E2(this.f54074c, (BalanceQueryData) obj);
    }
}
