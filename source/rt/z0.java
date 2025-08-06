package rt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class z0 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25910b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25911c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f25912d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f25913e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ TradeType f25914f;

    public /* synthetic */ z0(d1 d1Var, String str, int i11, int i12, TradeType tradeType) {
        this.f25910b = d1Var;
        this.f25911c = str;
        this.f25912d = i11;
        this.f25913e = i12;
        this.f25914f = tradeType;
    }

    public final void call(Object obj) {
        this.f25910b.k0(this.f25911c, this.f25912d, this.f25913e, this.f25914f, (Long) obj);
    }
}
