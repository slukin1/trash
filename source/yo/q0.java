package yo;

import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.huobi.account.entity.AccountType;
import dt.h2;
import rx.functions.Func1;

public final /* synthetic */ class q0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MapParamsBuilder f61945b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f61946c;

    public /* synthetic */ q0(MapParamsBuilder mapParamsBuilder, TradeType tradeType) {
        this.f61945b = mapParamsBuilder;
        this.f61946c = tradeType;
    }

    public final Object call(Object obj) {
        return this.f61945b.a("account-id", Long.valueOf(h2.t1().G1(this.f61946c, AccountType.spot.toString())));
    }
}
