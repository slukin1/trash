package com.hbg.lib.widgets.viewhandler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.bean.CommonDateSelectorItemBean;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import qa.a;
import s9.c;

public class CommonDateTabItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(CommonDateSelectorItemBean commonDateSelectorItemBean, View view) {
        commonDateSelectorItemBean.f();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, CommonDateSelectorItemBean commonDateSelectorItemBean, ViewGroup viewGroup) {
        int i12;
        Resources resources = cVar.itemView.getResources();
        TextView textView = (TextView) cVar.itemView;
        textView.setText(commonDateSelectorItemBean.d());
        boolean e11 = commonDateSelectorItemBean.e();
        textView.setSelected(e11);
        if (e11) {
            i12 = resources.getColor(R$color.baseColorMajorTheme100);
        } else {
            i12 = resources.getColor(R$color.baseColorPrimaryText);
        }
        textView.setTextColor(i12);
        textView.setOnClickListener(new a(commonDateSelectorItemBean));
    }

    public int getResId() {
        return R$layout.layout_common_date_tab_item;
    }
}
