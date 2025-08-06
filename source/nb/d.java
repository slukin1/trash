package nb;

import com.hbg.lite.enums.OtcTradeMode;
import com.hbg.lite.enums.TradeSide;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class d implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f58316b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ OtcTradeMode f58317c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TradeSide f58318d;

    public /* synthetic */ d(g gVar, OtcTradeMode otcTradeMode, TradeSide tradeSide) {
        this.f58316b = gVar;
        this.f58317c = otcTradeMode;
        this.f58318d = tradeSide;
    }

    public final Object call(Object obj) {
        return this.f58316b.p(this.f58317c, this.f58318d, (List) obj);
    }
}
