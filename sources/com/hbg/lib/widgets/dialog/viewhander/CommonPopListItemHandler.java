package com.hbg.lib.widgets.dialog.viewhander;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$font;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.dialog.bean.CommonPopListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import da.d;
import s9.c;

public class CommonPopListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(CommonPopListItem commonPopListItem, View view) {
        if (commonPopListItem.getCallback() != null) {
            commonPopListItem.getCallback().V6(commonPopListItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, CommonPopListItem commonPopListItem, ViewGroup viewGroup) {
        if (cVar != null && commonPopListItem != null) {
            TextView textView = (TextView) cVar.itemView;
            Context context = textView.getContext();
            textView.setText(commonPopListItem.getText());
            if (commonPopListItem.getCallback() == null || !commonPopListItem.getCallback().ic(commonPopListItem)) {
                textView.setTextColor(commonPopListItem.getUnCheckedTextColor(context));
                textView.setTypeface(ResourcesCompat.h(context, R$font.roboto_regular));
            } else {
                textView.setTextColor(commonPopListItem.getCheckedTextColor(context));
                textView.setTypeface(ResourcesCompat.h(context, R$font.roboto_medium));
            }
            if (commonPopListItem.getCallback() != null) {
                if (commonPopListItem.getCallback().ic(commonPopListItem)) {
                    textView.setBackgroundColor(context.getResources().getColor(R$color.baseColorInputBackground));
                } else {
                    textView.setBackgroundColor(0);
                }
            }
            textView.setOnClickListener(new d(commonPopListItem));
        }
    }

    public int getResId() {
        return R$layout.layout_common_pop_list_item;
    }
}
