package com.huobi.finance.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.z0;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import s9.c;
import vk.k;

public class AssetSortPopItemViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(k kVar, View view) {
        kVar.e();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, k kVar, ViewGroup viewGroup) {
        Context context = cVar.itemView.getContext();
        View b11 = cVar.e().b(R$id.sort_item_text_layout);
        TextView textView = (TextView) cVar.e().b(R$id.sort_item_text);
        if (kVar.d()) {
            textView.setTextColor(context.getResources().getColor(R$color.baseColorMajorTheme100));
            b11.setBackgroundColor(context.getResources().getColor(R$color.baseColorSeldomButtonClick));
        } else {
            textView.setTextColor(context.getResources().getColor(R$color.baseColorThreeLevelTextNew));
            b11.setBackgroundColor(context.getResources().getColor(R$color.baseColorContentBackground));
        }
        textView.setText(kVar.a());
        b11.setOnClickListener(new z0(kVar));
    }

    public int getResId() {
        return R$layout.item_asset_sort_pop_item;
    }
}
