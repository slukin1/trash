package hb;

import com.hbg.lite.market.bean.MarketDetailBean;
import java.util.Comparator;

public final /* synthetic */ class b implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ b f54913b = new b();

    public final int compare(Object obj, Object obj2) {
        return Double.compare(((MarketDetailBean) obj).getDoublePrice(), ((MarketDetailBean) obj2).getDoublePrice());
    }
}
