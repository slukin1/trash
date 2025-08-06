package rt;

import com.hbg.lib.data.symbol.TradeType;
import rx.functions.Action1;

public final /* synthetic */ class a1 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d1 f25806b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f25807c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TradeType f25808d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f25809e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ int f25810f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ int f25811g;

    public /* synthetic */ a1(d1 d1Var, String str, TradeType tradeType, String str2, int i11, int i12) {
        this.f25806b = d1Var;
        this.f25807c = str;
        this.f25808d = tradeType;
        this.f25809e = str2;
        this.f25810f = i11;
        this.f25811g = i12;
    }

    public final void call(Object obj) {
        this.f25806b.m0(this.f25807c, this.f25808d, this.f25809e, this.f25810f, this.f25811g, (Long) obj);
    }
}
