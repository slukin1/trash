package com.huobi.setting.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hr.h;
import i6.r;
import pro.huobi.R;
import s9.c;

public class SettingTextItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, h hVar, ViewGroup viewGroup) {
        if (cVar != null && hVar != null) {
            r e11 = cVar.e();
            TextView textView = (TextView) e11.b(R.id.id_setting_list_item_title);
            TextView textView2 = (TextView) e11.b(R.id.id_setting_list_item_desc);
            cVar.itemView.setTag(hVar);
            cVar.itemView.setOnClickListener(this);
            h.a aVar = hVar.f84213c;
            if (aVar != null) {
                textView.setText(aVar.a(hVar.f84212b));
                textView2.setText(hVar.f84213c.D(hVar.f84212b));
            }
        }
    }

    public int getResId() {
        return R.layout.layout_setting_text_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        h.a aVar;
        h hVar = (h) view.getTag();
        if (!(hVar == null || (aVar = hVar.f84213c) == null)) {
            aVar.onItemClick(hVar.f84212b);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
