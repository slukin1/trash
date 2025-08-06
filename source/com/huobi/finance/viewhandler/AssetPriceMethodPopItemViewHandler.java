package com.huobi.finance.viewhandler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bl.y0;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Locale;
import s9.c;
import vk.j;

public class AssetPriceMethodPopItemViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(j jVar, View view) {
        jVar.d();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, j jVar, ViewGroup viewGroup) {
        Context context = cVar.itemView.getContext();
        View b11 = cVar.e().b(R$id.sort_item_text_layout);
        TextView textView = (TextView) cVar.e().b(R$id.sort_item_text);
        View b12 = cVar.e().b(R$id.iv_arrow);
        if (jVar.c()) {
            textView.setTextColor(context.getResources().getColor(R$color.baseColorMajorTheme100));
            b11.setBackgroundColor(context.getResources().getColor(R$color.baseColorSeldomButtonClick));
        } else {
            textView.setTextColor(context.getResources().getColor(R$color.baseColorThreeLevelTextNew));
            b11.setBackgroundColor(context.getResources().getColor(R$color.baseColorContentBackground));
        }
        if (TextUtils.equals(jVar.a(), context.getString(R$string.n_home_index_earn_more))) {
            b12.setVisibility(0);
        } else {
            b12.setVisibility(8);
        }
        if (!TextUtils.isEmpty(jVar.a())) {
            textView.setText(jVar.a().toUpperCase(Locale.US));
        } else {
            textView.setText("");
        }
        b11.setOnClickListener(new y0(jVar));
    }

    public int getResId() {
        return R$layout.item_asset_price_method_pop_item;
    }
}
