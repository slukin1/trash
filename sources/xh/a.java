package xh;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset2.index.component.AssetAccountListItemView;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetAccountListItemView f61599b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BalanceProfitLossData.AccountBalance f61600c;

    public /* synthetic */ a(AssetAccountListItemView assetAccountListItemView, BalanceProfitLossData.AccountBalance accountBalance) {
        this.f61599b = assetAccountListItemView;
        this.f61600c = accountBalance;
    }

    public final void onClick(View view) {
        this.f61599b.e(this.f61600c, view);
    }
}
