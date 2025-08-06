package tl;

import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import com.huobi.homemarket.presenter.MarketCoinPresenter;
import java.util.Comparator;

public final /* synthetic */ class t implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ t f29364b = new t();

    public final int compare(Object obj, Object obj2) {
        return MarketCoinPresenter.F0((MarketSymbolPriceItem) obj, (MarketSymbolPriceItem) obj2);
    }
}
