package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class j3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54065b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54066c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TradeType f54067d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f54068e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f54069f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f54070g;

    public /* synthetic */ j3(a5 a5Var, String str, TradeType tradeType, String str2, int i11, int i12) {
        this.f54065b = a5Var;
        this.f54066c = str;
        this.f54067d = tradeType;
        this.f54068e = str2;
        this.f54069f = i11;
        this.f54070g = i12;
    }

    public final void call(Object obj) {
        this.f54065b.J0(this.f54066c, this.f54067d, this.f54068e, this.f54069f, this.f54070g, (Long) obj);
    }
}
