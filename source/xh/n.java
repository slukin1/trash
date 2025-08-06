package xh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset2.index.component.AssetSummaryViewNew;
import java.util.List;
import rx.functions.Func1;

public final /* synthetic */ class n implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSummaryViewNew f61614b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f61615c;

    public /* synthetic */ n(AssetSummaryViewNew assetSummaryViewNew, List list) {
        this.f61614b = assetSummaryViewNew;
        this.f61615c = list;
    }

    public final Object call(Object obj) {
        return this.f61614b.s(this.f61615c, (BalanceProfitLossData.AccountBalance) obj);
    }
}
