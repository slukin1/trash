package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Action1;

public final /* synthetic */ class h implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h2 f54036b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54037c;

    public /* synthetic */ h(h2 h2Var, TradeType tradeType) {
        this.f54036b = h2Var;
        this.f54037c = tradeType;
    }

    public final void call(Object obj) {
        this.f54036b.K2(this.f54037c, (BalanceQueryData) obj);
    }
}
