package ll;

import com.hbg.lib.common.utils.UtilCollections;
import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import java.util.List;

public final /* synthetic */ class c implements UtilCollections.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f58025a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f58026b;

    public /* synthetic */ c(List list, List list2) {
        this.f58025a = list;
        this.f58026b = list2;
    }

    public final void a(int i11, Object obj) {
        j.q(this.f58025a, this.f58026b, i11, (MarketSymbolPriceItem) obj);
    }
}
