package xh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset2.index.component.AssetSummaryView;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class i implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSummaryView f61608b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f61609c;

    public /* synthetic */ i(AssetSummaryView assetSummaryView, List list) {
        this.f61608b = assetSummaryView;
        this.f61609c = list;
    }

    public final Object call(Object obj) {
        return this.f61608b.q(this.f61609c, (BalanceProfitLossData.AccountBalance) obj);
    }
}
