package com.huobi.finance.viewhandler;

import al.b;
import al.i;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import bl.g;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$string;
import com.huobi.asset.feature.account.otc.AssetOtcFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import v9.c;

public class AssetOtcHeaderViewHandler extends AssetHeaderViewHandler<AssetOtcFragment.HeadViewData> {
    @SensorsDataInstrumented
    public static /* synthetic */ void f(View view) {
        AssetModuleConfig.a().o0(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String b() {
        return BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC;
    }

    /* renamed from: e */
    public void handleView(c cVar, int i11, AssetOtcFragment.HeadViewData headViewData, ViewGroup viewGroup) {
        super.handleView(cVar, i11, headViewData, viewGroup);
        this.f67577c.setRecordEntrance(g.f12589b);
        AssetHeadView<T> assetHeadView = this.f67577c;
        assetHeadView.f42421f.setText(b.a(assetHeadView.getContext(), 2));
        ArrayList arrayList = new ArrayList();
        Activity activity = (Activity) cVar.itemView.getContext();
        arrayList.add(i.k(activity, (String) null, "1", activity.getResources().getString(R$string.n_balance_margin_transfer)));
        arrayList.add(i.g((Activity) cVar.itemView.getContext()));
        this.f67577c.i(arrayList);
    }
}
