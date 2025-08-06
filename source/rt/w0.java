package rt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class w0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25889b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f25890c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f25891d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f25892e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f25893f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f25894g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f25895h;

    public /* synthetic */ w0(d1 d1Var, TradeType tradeType, boolean z11, String str, String str2, int i11, int i12) {
        this.f25889b = d1Var;
        this.f25890c = tradeType;
        this.f25891d = z11;
        this.f25892e = str;
        this.f25893f = str2;
        this.f25894g = i11;
        this.f25895h = i12;
    }

    public final void call(Object obj) {
        this.f25889b.g0(this.f25890c, this.f25891d, this.f25892e, this.f25893f, this.f25894g, this.f25895h, (Long) obj);
    }
}
