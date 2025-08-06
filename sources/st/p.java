package st;

import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.tradenew.presenter.TradeHorizontalSpotPresenter;
import java.util.Comparator;

public final /* synthetic */ class p implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ p f29232b = new p();

    public final int compare(Object obj, Object obj2) {
        return TradeHorizontalSpotPresenter.U2((SymbolBean) obj, (SymbolBean) obj2);
    }
}
