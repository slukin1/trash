package rt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Func1;
import s9.a;

public final /* synthetic */ class m0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25848b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f25849c;

    public /* synthetic */ m0(d1 d1Var, TradeType tradeType) {
        this.f25848b = d1Var;
        this.f25849c = tradeType;
    }

    public final Object call(Object obj) {
        return this.f25848b.Q(this.f25849c, (a) obj);
    }
}
