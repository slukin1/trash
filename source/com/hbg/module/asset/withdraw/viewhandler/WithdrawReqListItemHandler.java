package com.hbg.module.asset.withdraw.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cc.a;
import com.hbg.lib.widgets.CommonCheckBox;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.c;

public class WithdrawReqListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(a aVar, CommonCheckBox commonCheckBox, View view) {
        if (aVar.c() != null) {
            aVar.c().H7(aVar.d(), commonCheckBox);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        CommonCheckBox commonCheckBox = (CommonCheckBox) e11.b(R$id.id_withdraw_list_item_checkbox);
        ((TextView) e11.b(R$id.id_withdraw_list_item_tv)).setText(aVar.d().getContent());
        commonCheckBox.setChecked(aVar.c() != null && aVar.c().ce(aVar.d()));
        cVar.itemView.setOnClickListener(new ec.a(aVar, commonCheckBox));
    }

    public int getResId() {
        return R$layout.withdraw_info_req_list_item;
    }
}
