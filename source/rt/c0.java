package rt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;
import yo.s0;

public final /* synthetic */ class c0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25820b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f25821c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f25822d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s0.e f25823e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f25824f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f25825g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f25826h;

    public /* synthetic */ c0(d1 d1Var, TradeType tradeType, String str, s0.e eVar, String str2, int i11, int i12) {
        this.f25820b = d1Var;
        this.f25821c = tradeType;
        this.f25822d = str;
        this.f25823e = eVar;
        this.f25824f = str2;
        this.f25825g = i11;
        this.f25826h = i12;
    }

    public final void call(Object obj) {
        this.f25820b.X(this.f25821c, this.f25822d, this.f25823e, this.f25824f, this.f25825g, this.f25826h, (Long) obj);
    }
}
