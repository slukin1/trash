package com.huobi.supermargin.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.finance.bean.TransferOrderHistory;
import com.huobi.main.helper.MarginUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import ns.a;
import pro.huobi.R;
import s9.c;

public class LoanNotPayOffViewHandler implements c, View.OnClickListener {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(TransferOrderHistory transferOrderHistory, View view) {
        MarginUtil.b(transferOrderHistory.getCurrency());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, TransferOrderHistory transferOrderHistory, ViewGroup viewGroup) {
        cVar.itemView.setOnClickListener(new a(transferOrderHistory));
        r e11 = cVar.e();
        TextView e12 = e11.e(R.id.loan_order_record_label);
        TextView e13 = e11.e(R.id.loan_order_record_repay);
        TextView e14 = e11.e(R.id.loan_order_record_total);
        TextView e15 = e11.e(R.id.loan_order_record_unreturned);
        TextView e16 = e11.e(R.id.loan_order_record_fee);
        e12.setText(k.C().z(transferOrderHistory.getCurrency()));
        e14.setText(m.m(transferOrderHistory.getAmount(), PrecisionUtil.b(transferOrderHistory.getCurrency())));
        e15.setText(m.m(transferOrderHistory.getPayableAmount(), PrecisionUtil.s(transferOrderHistory.getCurrency())));
        e16.setText(m.m(transferOrderHistory.getInterestAmount(), PrecisionUtil.s(transferOrderHistory.getCurrency())));
        e13.setClickable(true);
        e13.setTag(R.id.item_data, transferOrderHistory);
        e13.setOnClickListener(this);
    }

    public int getResId() {
        return R.layout.item_super_margin_loan_order_record;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        MarginUtil.b(((TransferOrderHistory) view.getTag(R.id.item_data)).getCurrency());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
