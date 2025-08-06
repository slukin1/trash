package rt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class y0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25906c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f25907d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f25908e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ TradeType f25909f;

    public /* synthetic */ y0(d1 d1Var, String str, int i11, int i12, TradeType tradeType) {
        this.f25905b = d1Var;
        this.f25906c = str;
        this.f25907d = i11;
        this.f25908e = i12;
        this.f25909f = tradeType;
    }

    public final void call(Object obj) {
        this.f25905b.Z(this.f25906c, this.f25907d, this.f25908e, this.f25909f, (Long) obj);
    }
}
