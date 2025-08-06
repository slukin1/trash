package st;

import com.huobi.tradenew.presenter.TradeVerticalSpotPresenter;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class s0 implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotPresenter f29239b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f29240c;

    public /* synthetic */ s0(TradeVerticalSpotPresenter tradeVerticalSpotPresenter, Map map) {
        this.f29239b = tradeVerticalSpotPresenter;
        this.f29240c = map;
    }

    public final Object call(Object obj) {
        return this.f29239b.o3(this.f29240c, (Long) obj);
    }
}
