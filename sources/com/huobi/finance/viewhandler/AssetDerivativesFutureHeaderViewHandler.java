package com.huobi.finance.viewhandler;

import al.b;
import al.i;
import android.app.Activity;
import android.view.ViewGroup;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.account.future.subtype.AssetDerivativesFutureFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.bean.ContractDataTotal;
import java.util.ArrayList;
import v9.c;

public class AssetDerivativesFutureHeaderViewHandler extends AssetHeaderViewHandler<AssetDerivativesFutureFragment.HeadViewData> {
    public String b() {
        return "4";
    }

    /* renamed from: d */
    public void handleView(c cVar, int i11, AssetDerivativesFutureFragment.HeadViewData headViewData, ViewGroup viewGroup) {
        super.handleView(cVar, i11, headViewData, viewGroup);
        AssetHeadView<T> assetHeadView = this.f67577c;
        assetHeadView.f42421f.setText(b.a(assetHeadView.getContext(), 3));
        ContractDataTotal contractDataTotal = (ContractDataTotal) headViewData.c();
        String currency = (contractDataTotal == null || CollectionsUtils.b(contractDataTotal.getDetailInfos())) ? "btc" : ((BaseAssetInfo) contractDataTotal.getDetailInfos().get(0)).getCurrency();
        ArrayList arrayList = new ArrayList();
        Activity activity = (Activity) cVar.itemView.getContext();
        arrayList.add(i.l(activity, currency, "4", activity.getResources().getString(R$string.n_balance_contract_transfer), AssetAccountType.FUTURE));
        this.f67577c.i(arrayList);
    }
}
