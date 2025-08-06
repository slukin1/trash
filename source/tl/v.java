package tl;

import com.hbg.lib.network.hbg.core.bean.MarketPlateDetail;
import com.huobi.homemarket.presenter.MarketDetailPlatePresenter;
import java.util.Comparator;

public final /* synthetic */ class v implements Comparator {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketDetailPlatePresenter f29366b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f29367c;

    public /* synthetic */ v(MarketDetailPlatePresenter marketDetailPlatePresenter, boolean z11) {
        this.f29366b = marketDetailPlatePresenter;
        this.f29367c = z11;
    }

    public final int compare(Object obj, Object obj2) {
        return this.f29366b.k0(this.f29367c, (MarketPlateDetail.CurrencyItem) obj, (MarketPlateDetail.CurrencyItem) obj2);
    }
}
