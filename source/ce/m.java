package ce;

import com.hbg.module.kline.bean.MarketInfoTradesItem;
import com.hbg.module.kline.presenter.MarketInfoTradesPresenter;
import java.util.Comparator;

public final /* synthetic */ class m implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoTradesPresenter f13082b;

    public /* synthetic */ m(MarketInfoTradesPresenter marketInfoTradesPresenter) {
        this.f13082b = marketInfoTradesPresenter;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f13082b.w0((MarketInfoTradesItem) obj, (MarketInfoTradesItem) obj2);
    }
}
