package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class b4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f53994b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f53995c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f53996d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f53997e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f53998f;

    public /* synthetic */ b4(a5 a5Var, TradeType tradeType, String str, int i11, int i12) {
        this.f53994b = a5Var;
        this.f53995c = tradeType;
        this.f53996d = str;
        this.f53997e = i11;
        this.f53998f = i12;
    }

    public final void call(Object obj) {
        this.f53994b.Z0(this.f53995c, this.f53996d, this.f53997e, this.f53998f, (Long) obj);
    }
}
