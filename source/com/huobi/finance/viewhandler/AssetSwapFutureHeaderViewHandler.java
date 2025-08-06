package com.huobi.finance.viewhandler;

import al.b;
import al.i;
import android.app.Activity;
import android.view.ViewGroup;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.account.future.subtype.AssetSwapFutureFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.SwapDataTotal;
import java.util.ArrayList;
import v9.c;

public class AssetSwapFutureHeaderViewHandler extends AssetHeaderViewHandler<AssetSwapFutureFragment.HeadViewData> {
    public String b() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP;
    }

    /* renamed from: d */
    public void handleView(c cVar, int i11, AssetSwapFutureFragment.HeadViewData headViewData, ViewGroup viewGroup) {
        super.handleView(cVar, i11, headViewData, viewGroup);
        AssetHeadView<T> assetHeadView = this.f67577c;
        assetHeadView.f42421f.setText(b.a(assetHeadView.getContext(), 6));
        SwapDataTotal swapDataTotal = (SwapDataTotal) headViewData.c();
        String currency = (swapDataTotal == null || CollectionsUtils.b(swapDataTotal.getDetailInfos())) ? "btc" : ((BaseAssetInfo) swapDataTotal.getDetailInfos().get(0)).getCurrency();
        ArrayList arrayList = new ArrayList();
        Activity activity = (Activity) cVar.itemView.getContext();
        arrayList.add(i.l(activity, currency, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, activity.getResources().getString(R$string.n_balance_contract_transfer), AssetAccountType.FUTURE));
        this.f67577c.i(arrayList);
    }
}
