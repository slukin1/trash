package com.huobi.c2c.lend.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.network.hbg.core.bean.C2CLoanOrderBean;
import com.hbg.lib.widgets.CommonSwitchButton;
import com.huobi.c2c.lend.bean.C2CLendOrderHistoryItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.r;
import pro.huobi.R;
import ri.a;
import s9.c;

public class C2CLendOrderHistoryItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(C2CLendOrderHistoryItem c2CLendOrderHistoryItem, C2CLoanOrderBean c2CLoanOrderBean, CommonSwitchButton commonSwitchButton, View view) {
        if (c2CLendOrderHistoryItem.getCallback() != null) {
            c2CLendOrderHistoryItem.getCallback().f(c2CLoanOrderBean, commonSwitchButton);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, C2CLendOrderHistoryItem c2CLendOrderHistoryItem, ViewGroup viewGroup) {
        cVar.itemView.getResources();
        C2CLoanOrderBean c2CLoanOrderBean = c2CLendOrderHistoryItem.getC2CLoanOrderBean();
        r e11 = cVar.e();
        ViewUtil.m(e11.b(R.id.id_c2c_lend_order_item_divider), i11 != 0);
        TextView textView = (TextView) e11.b(R.id.id_c2c_lend_order_item_btn);
        View b11 = e11.b(R.id.id_c2c_lend_order_item_switch_botton_layout);
        CommonSwitchButton commonSwitchButton = (CommonSwitchButton) e11.b(R.id.id_c2c_lend_order_item_switch_botton);
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_title)).setText(k.C().z(c2CLoanOrderBean.getCurrency()));
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_time)).setText(c2CLendOrderHistoryItem.getDisplayDate());
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_total_amount)).setText(c2CLendOrderHistoryItem.getDisplayAmount());
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_period)).setText(c2CLendOrderHistoryItem.getDisplayTerm());
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_rate)).setText(c2CLendOrderHistoryItem.getDisplayInterestRate());
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_income)).setText(c2CLendOrderHistoryItem.getDisplayReturnedAmount());
        ((TextView) e11.b(R.id.id_c2c_lend_order_item_state_finish)).setText(c2CLendOrderHistoryItem.getDisplayFilledAmount());
        commonSwitchButton.b(c2CLoanOrderBean.isRenewOpen(), false);
        b11.setOnClickListener(new a(c2CLendOrderHistoryItem, c2CLoanOrderBean, commonSwitchButton));
    }

    public int getResId() {
        return R.layout.c2c_lend_order_history_item_layout;
    }
}
