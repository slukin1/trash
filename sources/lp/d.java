package lp;

import com.hbg.lib.network.otc.core.bean.MarketPrice;
import com.huobi.otc.bean.MarketCoin;
import java.util.List;
import rx.Observable;

public interface d {
    List<MarketCoin.Coin> a();

    Observable<List<MarketPrice.Price>> b(boolean z11);

    Observable<List<MarketCoin.Coin>> c(boolean z11);
}
