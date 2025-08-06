package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class h3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54040b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54041c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TradeType f54042d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f54043e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f54044f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f54045g;

    public /* synthetic */ h3(a5 a5Var, String str, TradeType tradeType, String str2, int i11, int i12) {
        this.f54040b = a5Var;
        this.f54041c = str;
        this.f54042d = tradeType;
        this.f54043e = str2;
        this.f54044f = i11;
        this.f54045g = i12;
    }

    public final void call(Object obj) {
        this.f54040b.f1(this.f54041c, this.f54042d, this.f54043e, this.f54044f, this.f54045g, (Long) obj);
    }
}
