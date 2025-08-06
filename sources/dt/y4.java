package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class y4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54214b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TradeType f54215c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f54216d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f54217e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f54218f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f54219g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f54220h;

    public /* synthetic */ y4(a5 a5Var, TradeType tradeType, boolean z11, String str, String str2, int i11, int i12) {
        this.f54214b = a5Var;
        this.f54215c = tradeType;
        this.f54216d = z11;
        this.f54217e = str;
        this.f54218f = str2;
        this.f54219g = i11;
        this.f54220h = i12;
    }

    public final void call(Object obj) {
        this.f54214b.h1(this.f54215c, this.f54216d, this.f54217e, this.f54218f, this.f54219g, this.f54220h, (Long) obj);
    }
}
