package qh;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset.feature.summary.AssetSummaryAccountItemView;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSummaryAccountItemView f53341b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BalanceProfitLossData.AccountBalance f53342c;

    public /* synthetic */ e(AssetSummaryAccountItemView assetSummaryAccountItemView, BalanceProfitLossData.AccountBalance accountBalance) {
        this.f53341b = assetSummaryAccountItemView;
        this.f53342c = accountBalance;
    }

    public final void onClick(View view) {
        this.f53341b.p(this.f53342c, view);
    }
}
