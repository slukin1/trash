package hb;

import com.hbg.lite.market.bean.MarketDetailBean;
import java.util.Comparator;

public final /* synthetic */ class a implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ a f54912b = new a();

    public final int compare(Object obj, Object obj2) {
        return Double.compare(((MarketDetailBean) obj).getDoublePrice(), ((MarketDetailBean) obj2).getDoublePrice());
    }
}
