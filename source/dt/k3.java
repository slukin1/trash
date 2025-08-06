package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class k3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54079b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54080c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TradeType f54081d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f54082e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f54083f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f54084g;

    public /* synthetic */ k3(a5 a5Var, String str, TradeType tradeType, String str2, int i11, int i12) {
        this.f54079b = a5Var;
        this.f54080c = str;
        this.f54081d = tradeType;
        this.f54082e = str2;
        this.f54083f = i11;
        this.f54084g = i12;
    }

    public final void call(Object obj) {
        this.f54079b.d1(this.f54080c, this.f54081d, this.f54082e, this.f54083f, this.f54084g, (Long) obj);
    }
}
