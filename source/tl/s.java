package tl;

import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import com.huobi.homemarket.presenter.MarketCoinPresenter;
import java.util.Comparator;

public final /* synthetic */ class s implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ s f29363b = new s();

    public final int compare(Object obj, Object obj2) {
        return MarketCoinPresenter.E0((MarketSymbolPriceItem) obj, (MarketSymbolPriceItem) obj2);
    }
}
