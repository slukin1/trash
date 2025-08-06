package com.huobi.c2c.lend.viewhandler;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.CommonCheckBox;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import ri.e;
import s9.c;

public class C2CTermListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(oi.c cVar, View view) {
        if (cVar.c() != null) {
            cVar.c().a(cVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, oi.c cVar2, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Resources resources = cVar.itemView.getResources();
        ViewGroup viewGroup2 = (ViewGroup) e11.b(R.id.c2c_lend_rate_item);
        TextView textView = (TextView) e11.b(R.id.c2c_lend_term_item_tv);
        CommonCheckBox commonCheckBox = (CommonCheckBox) e11.b(R.id.c2c_lend_term_item_checkbox);
        textView.setText(cVar2.e());
        if (cVar2.f()) {
            commonCheckBox.setChecked(true);
            textView.setTextColor(resources.getColor(R.color.baseColorMajorTheme100));
        } else {
            textView.setTextColor(resources.getColor(R.color.baseColorSecondaryText));
            commonCheckBox.setChecked(false);
        }
        viewGroup2.setOnClickListener(new e(cVar2));
    }

    public int getResId() {
        return R.layout.c2c_lend_term_item;
    }
}
