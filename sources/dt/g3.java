package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class g3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54030c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f54031d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54032e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ TradeType f54033f;

    public /* synthetic */ g3(a5 a5Var, String str, int i11, int i12, TradeType tradeType) {
        this.f54029b = a5Var;
        this.f54030c = str;
        this.f54031d = i11;
        this.f54032e = i12;
        this.f54033f = tradeType;
    }

    public final void call(Object obj) {
        this.f54029b.I0(this.f54030c, this.f54031d, this.f54032e, this.f54033f, (Long) obj);
    }
}
