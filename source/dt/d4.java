package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Func1;
import s9.a;

public final /* synthetic */ class d4 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54010b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54011c;

    public /* synthetic */ d4(a5 a5Var, TradeType tradeType) {
        this.f54010b = a5Var;
        this.f54011c = tradeType;
    }

    public final Object call(Object obj) {
        return this.f54010b.u0(this.f54011c, (a) obj);
    }
}
