package com.huobi.finance.viewhandler;

import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.finance.bean.LoanOrderItem;
import com.huobi.finance.ui.RepayActivity;
import com.huobi.main.helper.MarginUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;

public class LoanOrderViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, LoanOrderItem loanOrderItem, ViewGroup viewGroup) {
        Resources resources = cVar.itemView.getResources();
        r e11 = cVar.e();
        TextView e12 = e11.e(R.id.loan_order_record_label);
        TextView e13 = e11.e(R.id.loan_order_record_repay);
        TextView e14 = e11.e(R.id.loan_order_record_total);
        TextView e15 = e11.e(R.id.loan_order_record_unreturned);
        TextView e16 = e11.e(R.id.loan_order_record_fee_label);
        TextView e17 = e11.e(R.id.loan_order_record_fee);
        e12.setText(k.C().z(loanOrderItem.getCurrency()));
        e14.setText(m.m(loanOrderItem.getLoanAmount(), PrecisionUtil.b(loanOrderItem.getCurrency())));
        e15.setText(m.m(loanOrderItem.getLoanBalance(), PrecisionUtil.s(loanOrderItem.getCurrency())));
        e17.setText(m.m(loanOrderItem.getInterestBalance(), PrecisionUtil.s(loanOrderItem.getCurrency())));
        if (!TextUtils.isEmpty(loanOrderItem.getInterestRate())) {
            e16.setText(String.format(resources.getString(R.string.loan_order_detail_fee), new Object[]{loanOrderItem.getReductedRatePercent()}));
        }
        e13.setClickable(true);
        e13.setTag(R.id.item_data, loanOrderItem);
        e13.setOnClickListener(this);
    }

    public int getResId() {
        return R.layout.item_loan_order_record;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        LoanOrderItem loanOrderItem = (LoanOrderItem) view.getTag(R.id.item_data);
        Intent intent = new Intent(view.getContext(), RepayActivity.class);
        intent.putExtra("repay_bean", loanOrderItem);
        view.getContext().startActivity(intent);
        MarginUtil.d(loanOrderItem.getSymbol());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
