package com.huobi.finance.viewhandler;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.hbg.core.bean.CopyTradingAccountTransferRecord;
import i6.r;
import pro.huobi.R;
import s9.c;
import vk.m;

public class CopyTradingTransferOrderViewHandler implements c {
    public final String b(Resources resources, CopyTradingAccountTransferRecord.FinancialRecord financialRecord) {
        int type = financialRecord.getType();
        if (type == 1) {
            return resources.getString(R.string.n_transfer_record_future_to_follower);
        }
        if (type == 2) {
            return resources.getString(R.string.n_transfer_record_follower_to_future);
        }
        if (type == 3) {
            return resources.getString(R.string.transfer_spot_to_copy_trading);
        }
        if (type != 4) {
            return "--";
        }
        return resources.getString(R.string.transfer_copy_trading_to_spot);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, m mVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.tv_transfer_order_amount);
        TextView textView2 = (TextView) e11.b(R.id.tv_transfer_order_type);
        TextView textView3 = (TextView) e11.b(R.id.tv_transfer_order_date);
        TextView textView4 = (TextView) e11.b(R.id.transfer_order_system);
        Resources resources = textView.getResources();
        CopyTradingAccountTransferRecord.FinancialRecord c11 = mVar.c();
        String amount = c11.getAmount();
        if (!TextUtils.isEmpty(amount)) {
            textView.setText(i6.m.m(amount, FuturePrecisionUtil.f(c11.getCurrency())));
        }
        textView2.setText(b(resources, c11));
        textView4.setVisibility(8);
        if (DateTimeUtils.E(c11.getTime())) {
            textView3.setText(DateTimeUtils.h(c11.getTime(), "HH:mm MM/dd"));
        } else {
            textView3.setText(DateTimeUtils.h(c11.getTime(), "HH:mm MM/dd/yyyy "));
        }
    }

    public int getResId() {
        return R.layout.transfer_history_item;
    }
}
