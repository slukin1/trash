package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class z4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54226b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54227c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f54228d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f54229e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ TradeType f54230f;

    public /* synthetic */ z4(a5 a5Var, String str, int i11, int i12, TradeType tradeType) {
        this.f54226b = a5Var;
        this.f54227c = str;
        this.f54228d = i11;
        this.f54229e = i12;
        this.f54230f = tradeType;
    }

    public final void call(Object obj) {
        this.f54226b.b1(this.f54227c, this.f54228d, this.f54229e, this.f54230f, (Long) obj);
    }
}
