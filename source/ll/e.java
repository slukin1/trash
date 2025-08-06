package ll;

import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import java.util.Comparator;

public final /* synthetic */ class e implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58029b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f58030c;

    public /* synthetic */ e(String str, boolean z11) {
        this.f58029b = str;
        this.f58030c = z11;
    }

    public final int compare(Object obj, Object obj2) {
        return j.p(this.f58029b, this.f58030c, (MarketSymbolPriceItem) obj, (MarketSymbolPriceItem) obj2);
    }
}
