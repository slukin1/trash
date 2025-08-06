package dt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class i3 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a5 f54052b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54053c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TradeType f54054d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f54055e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f54056f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f54057g;

    public /* synthetic */ i3(a5 a5Var, String str, TradeType tradeType, String str2, int i11, int i12) {
        this.f54052b = a5Var;
        this.f54053c = str;
        this.f54054d = tradeType;
        this.f54055e = str2;
        this.f54056f = i11;
        this.f54057g = i12;
    }

    public final void call(Object obj) {
        this.f54052b.P0(this.f54053c, this.f54054d, this.f54055e, this.f54056f, this.f54057g, (Long) obj);
    }
}
