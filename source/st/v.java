package st;

import com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter;
import java.util.Map;
import rx.functions.Func1;

public final /* synthetic */ class v implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeHorizontalSpotPresenter f29245b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f29246c;

    public /* synthetic */ v(TradeHorizontalSpotPresenter tradeHorizontalSpotPresenter, Map map) {
        this.f29245b = tradeHorizontalSpotPresenter;
        this.f29246c = map;
    }

    public final Object call(Object obj) {
        return this.f29245b.S2(this.f29246c, (Long) obj);
    }
}
