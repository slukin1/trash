package st;

import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.tradenew.presenter.TradeVerticalSpotPresenter;
import java.util.Comparator;

public final /* synthetic */ class k0 implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ k0 f29223b = new k0();

    public final int compare(Object obj, Object obj2) {
        return TradeVerticalSpotPresenter.t3((SymbolBean) obj, (SymbolBean) obj2);
    }
}
