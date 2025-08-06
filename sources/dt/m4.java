package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class m4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54103b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54104c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f54105d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54106e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f54107f;

    public /* synthetic */ m4(a5 a5Var, TradeType tradeType, String str, int i11, int i12) {
        this.f54103b = a5Var;
        this.f54104c = tradeType;
        this.f54105d = str;
        this.f54106e = i11;
        this.f54107f = i12;
    }

    public final void call(Object obj) {
        this.f54103b.B0(this.f54104c, this.f54105d, this.f54106e, this.f54107f, (Long) obj);
    }
}
