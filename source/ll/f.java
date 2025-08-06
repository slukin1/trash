package ll;

import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import java.util.Comparator;

public final /* synthetic */ class f implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58031b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58032c;

    public /* synthetic */ f(String str, boolean z11) {
        this.f58031b = str;
        this.f58032c = z11;
    }

    public final int compare(Object obj, Object obj2) {
        return j.r(this.f58031b, this.f58032c, (MarketSymbolPriceItem) obj, (MarketSymbolPriceItem) obj2);
    }
}
