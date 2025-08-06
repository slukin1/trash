package gl;

import com.hbg.lib.data.symbol.TradeType;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class c implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeType f54844b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f54845c;

    public /* synthetic */ c(TradeType tradeType, String str) {
        this.f54844b = tradeType;
        this.f54845c = str;
    }

    public final Object call(Object obj) {
        return d.f(this.f54844b, this.f54845c, (List) obj);
    }
}
