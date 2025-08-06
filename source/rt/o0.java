package rt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Func1;
import s9.a;

public final /* synthetic */ class o0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25859b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f25860c;

    public /* synthetic */ o0(d1 d1Var, TradeType tradeType) {
        this.f25859b = d1Var;
        this.f25860c = tradeType;
    }

    public final Object call(Object obj) {
        return this.f25859b.S(this.f25860c, (a) obj);
    }
}
