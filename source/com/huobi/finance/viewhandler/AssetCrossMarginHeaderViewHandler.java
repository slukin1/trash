package com.huobi.finance.viewhandler;

import al.b;
import al.i;
import android.app.Activity;
import android.view.ViewGroup;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.asset.feature.account.margin.subtype.AssetCrossMarginFragment;
import com.huobi.asset.widget.AssetHeadView;
import java.util.ArrayList;
import v9.c;

public class AssetCrossMarginHeaderViewHandler extends AssetHeaderViewHandler<AssetCrossMarginFragment.HeadViewData> {
    public String b() {
        return "3";
    }

    /* renamed from: d */
    public void handleView(c cVar, int i11, AssetCrossMarginFragment.HeadViewData headViewData, ViewGroup viewGroup) {
        super.handleView(cVar, i11, headViewData, viewGroup);
        AssetHeadView<T> assetHeadView = this.f67577c;
        assetHeadView.f42421f.setText(b.a(assetHeadView.getContext(), 4));
        ArrayList arrayList = new ArrayList();
        arrayList.add(i.j((Activity) cVar.itemView.getContext(), (String) null, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL));
        arrayList.add(i.i((Activity) cVar.itemView.getContext(), true));
        this.f67577c.i(arrayList);
    }
}
