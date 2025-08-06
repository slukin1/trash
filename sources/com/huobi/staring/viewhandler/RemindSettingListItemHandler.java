package com.huobi.staring.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bs.b;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import es.k;
import i6.r;
import pro.huobi.R;
import s9.c;

public class RemindSettingListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(b bVar, CommonSwitchButton commonSwitchButton, View view) {
        if (bVar.c() != null) {
            bVar.c().a(bVar, commonSwitchButton);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        if (bVar != null) {
            r e11 = cVar.e();
            CommonSwitchButton commonSwitchButton = (CommonSwitchButton) e11.b(R.id.id_remind_setting_list_item_switchButton);
            View b11 = e11.b(R.id.id_remind_setting_list_item_switchButton_parent);
            ((TextView) e11.b(R.id.id_remind_setting_list_item_title)).setText(bVar.e());
            ((TextView) e11.b(R.id.id_remind_setting_list_item_desc)).setText(bVar.d());
            if (bVar.c() != null) {
                commonSwitchButton.setChecked(bVar.g());
            }
            b11.setOnClickListener(new k(bVar, commonSwitchButton));
        }
    }

    public int getResId() {
        return R.layout.staring_layout_remind_setting_list_item;
    }
}
