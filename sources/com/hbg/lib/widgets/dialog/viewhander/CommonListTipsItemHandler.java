package com.hbg.lib.widgets.dialog.viewhander;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ba.a;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.c;

public class CommonListTipsItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(a aVar, View view) {
        if (aVar.c() != null) {
            aVar.c().a(aVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ((TextView) e11.b(R$id.itemTv)).setText(aVar.e());
        ((ImageView) e11.b(R$id.itemIv)).setImageResource(aVar.d());
        cVar.itemView.setOnClickListener(new da.c(aVar));
    }

    public int getResId() {
        return R$layout.common_item_tips_dialog_item_layout;
    }
}
