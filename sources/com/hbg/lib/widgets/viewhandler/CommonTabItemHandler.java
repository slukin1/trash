package com.hbg.lib.widgets.viewhandler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import qa.b;
import s9.c;
import y9.a;

public class CommonTabItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(a aVar, View view) {
        aVar.g();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        int i12;
        Resources resources = cVar.itemView.getResources();
        TextView textView = (TextView) cVar.itemView;
        textView.setText(aVar.d());
        boolean f11 = aVar.f();
        textView.setSelected(f11);
        if (f11) {
            i12 = resources.getColor(R$color.baseColorMajorTheme100);
        } else {
            i12 = resources.getColor(R$color.baseColorSecondaryTextNew);
        }
        textView.setTextColor(i12);
        textView.setOnClickListener(new b(aVar));
    }

    public int getResId() {
        return R$layout.layout_common_tab_item;
    }
}
