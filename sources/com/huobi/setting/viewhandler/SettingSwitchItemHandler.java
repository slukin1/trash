package com.huobi.setting.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import hr.g;
import i6.r;
import pro.huobi.R;
import s9.c;

public class SettingSwitchItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, g gVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        CommonSwitchButton commonSwitchButton = (CommonSwitchButton) e11.b(R.id.id_setting_list_item_switch);
        ((TextView) e11.b(R.id.id_setting_list_item_title)).setText(gVar.d());
        commonSwitchButton.setTag(gVar);
        commonSwitchButton.setChecked(gVar.f());
        commonSwitchButton.setOnClickListener(this);
    }

    public int getResId() {
        return R.layout.layout_setting_list_item_swich;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view instanceof CommonSwitchButton) {
            CommonSwitchButton commonSwitchButton = (CommonSwitchButton) view;
            g gVar = (g) commonSwitchButton.getTag();
            if (!(gVar == null || gVar.c() == null)) {
                gVar.c().a(gVar, commonSwitchButton);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
