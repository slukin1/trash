package rt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class b1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25813b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25814c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TradeType f25815d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f25816e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f25817f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f25818g;

    public /* synthetic */ b1(d1 d1Var, String str, TradeType tradeType, String str2, int i11, int i12) {
        this.f25813b = d1Var;
        this.f25814c = str;
        this.f25815d = tradeType;
        this.f25816e = str2;
        this.f25817f = i11;
        this.f25818g = i12;
    }

    public final void call(Object obj) {
        this.f25813b.d0(this.f25814c, this.f25815d, this.f25816e, this.f25817f, this.f25818g, (Long) obj);
    }
}
