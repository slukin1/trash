package uc;

import com.hbg.lib.data.symbol.TradeType;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class a implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeType f60564b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f60565c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f60566d;

    public /* synthetic */ a(TradeType tradeType, int i11, String str) {
        this.f60564b = tradeType;
        this.f60565c = i11;
        this.f60566d = str;
    }

    public final Object call(Object obj) {
        return b.c(this.f60564b, this.f60565c, this.f60566d, (List) obj);
    }
}
