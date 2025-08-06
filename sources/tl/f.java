package tl;

import com.huobi.homemarket.presenter.HomeMarketNewPresenter;
import java.util.Comparator;
import java.util.Map;

public final /* synthetic */ class f implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f29347b;

    public /* synthetic */ f(Map map) {
        this.f29347b = map;
    }

    public final int compare(Object obj, Object obj2) {
        return HomeMarketNewPresenter.Y1(this.f29347b, (String) obj, (String) obj2);
    }
}
