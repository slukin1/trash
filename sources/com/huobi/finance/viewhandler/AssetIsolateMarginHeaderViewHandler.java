package com.huobi.finance.viewhandler;

import al.b;
import al.i;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import bl.d;
import com.hbg.module.asset.AssetModuleConfig;
import com.huobi.asset.feature.account.margin.subtype.AssetIsolateMarginFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import v9.c;

public class AssetIsolateMarginHeaderViewHandler extends AssetHeaderViewHandler<AssetIsolateMarginFragment.HeadViewData> {
    @SensorsDataInstrumented
    public static /* synthetic */ void f(View view) {
        AssetModuleConfig.a().x0(view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String b() {
        return "2";
    }

    /* renamed from: e */
    public void handleView(c cVar, int i11, AssetIsolateMarginFragment.HeadViewData headViewData, ViewGroup viewGroup) {
        super.handleView(cVar, i11, headViewData, viewGroup);
        this.f67577c.setRecordEntrance(d.f12559b);
        AssetHeadView<T> assetHeadView = this.f67577c;
        assetHeadView.f42421f.setText(b.a(assetHeadView.getContext(), 0));
        ArrayList arrayList = new ArrayList();
        arrayList.add(i.j((Activity) cVar.itemView.getContext(), "btc", "3"));
        arrayList.add(i.i((Activity) cVar.itemView.getContext(), false));
        this.f67577c.i(arrayList);
    }
}
