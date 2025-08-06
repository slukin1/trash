package qh;

import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset.feature.summary.AssetSummaryFragment;
import rx.functions.Func1;

public final /* synthetic */ class l implements Func1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSummaryFragment f53355b;

    public /* synthetic */ l(AssetSummaryFragment assetSummaryFragment) {
        this.f53355b = assetSummaryFragment;
    }

    public final Object call(Object obj) {
        return this.f53355b.Wh((BalanceProfitLossData) obj);
    }
}
