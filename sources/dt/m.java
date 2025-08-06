package dt;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.account.entity.BalanceQueryData;
import rx.functions.Action1;

public final /* synthetic */ class m implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ h2 f54095b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54096c;

    public /* synthetic */ m(h2 h2Var, TradeType tradeType) {
        this.f54095b = h2Var;
        this.f54096c = tradeType;
    }

    public final void call(Object obj) {
        this.f54095b.y2(this.f54096c, (BalanceQueryData) obj);
    }
}
