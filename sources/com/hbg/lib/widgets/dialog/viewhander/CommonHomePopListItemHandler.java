package com.hbg.lib.widgets.dialog.viewhander;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.HomeCommonPopListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import da.b;
import s9.c;

public class CommonHomePopListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(HomeCommonPopListItem homeCommonPopListItem, View view) {
        if (homeCommonPopListItem.c() != null) {
            homeCommonPopListItem.c().a(homeCommonPopListItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, HomeCommonPopListItem homeCommonPopListItem, ViewGroup viewGroup) {
        if (cVar != null && homeCommonPopListItem != null) {
            TextView textView = (TextView) cVar.itemView.findViewById(R$id.common_home_pop_item_tips_text);
            cVar.itemView.findViewById(R$id.common_home_pop_item_layout).setOnClickListener(new b(homeCommonPopListItem));
            ((ImageView) cVar.itemView.findViewById(R$id.common_home_pop_item_icon)).setImageResource(homeCommonPopListItem.e());
            ((TextView) cVar.itemView.findViewById(R$id.common_home_pop_item_content_text)).setText(homeCommonPopListItem.d());
            if (homeCommonPopListItem.h()) {
                textView.setVisibility(0);
                textView.setText(homeCommonPopListItem.f());
                return;
            }
            textView.setVisibility(8);
        }
    }

    public int getResId() {
        return R$layout.layout_common_home_pop_list_item;
    }
}
