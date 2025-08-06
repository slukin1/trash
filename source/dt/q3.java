package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class q3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54134b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54135c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54136d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54137e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f54138f;

    public /* synthetic */ q3(a5 a5Var, TradeType tradeType, String str, int i11, int i12) {
        this.f54134b = a5Var;
        this.f54135c = tradeType;
        this.f54136d = str;
        this.f54137e = i11;
        this.f54138f = i12;
    }

    public final void call(Object obj) {
        this.f54134b.o1(this.f54135c, this.f54136d, this.f54137e, this.f54138f, (Long) obj);
    }
}
