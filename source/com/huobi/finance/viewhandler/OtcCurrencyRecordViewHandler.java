package com.huobi.finance.viewhandler;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.finance.bean.OtcFinanceRecordItem;
import com.huobi.finance.ui.OtcCurrencyDetailOrderActivity;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;

public class OtcCurrencyRecordViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OtcFinanceRecordItem otcFinanceRecordItem, ViewGroup viewGroup) {
        boolean z11;
        String str;
        View view = cVar.itemView;
        view.setOnClickListener(this);
        r e11 = cVar.e();
        TextView e12 = e11.e(R.id.currency_record_label);
        TextView e13 = e11.e(R.id.currency_record_time);
        TextView e14 = e11.e(R.id.currency_record_status);
        TextView e15 = e11.e(R.id.currency_record_status_label);
        TextView e16 = e11.e(R.id.currency_record_amount);
        String c11 = OtcMarketPriceConfigUtil.c(otcFinanceRecordItem.getCoinId());
        MarketCoin.Coin h11 = OtcMarketPriceConfigUtil.h(otcFinanceRecordItem.getCoinId());
        if (h11 != null) {
            z11 = k.C().L(h11.getCoinCode());
        } else {
            z11 = false;
        }
        int i12 = 3;
        if (otcFinanceRecordItem.getLayoutType() == 1) {
            e12.setText(c11);
            e15.setText(R.string.otc_balance_finance_type);
            int type = otcFinanceRecordItem.getType();
            if (type == 5) {
                e14.setText(R.string.n_transfer_to_otc);
            } else if (type == 6) {
                e14.setText(R.string.n_transfer_from_otc);
            }
        } else {
            int type2 = otcFinanceRecordItem.getType();
            if (type2 == 2) {
                e12.setText(R.string.otc_balance_detail_sell);
            } else if (type2 == 3) {
                e12.setText(R.string.otc_balance_detail_buy);
            } else if (type2 == 5) {
                e12.setText(R.string.otc_balance_detail_in);
            } else if (type2 == 6) {
                e12.setText(R.string.otc_balance_detail_out);
            } else if (type2 == 7) {
                e12.setText(R.string.n_otc_balance_detail_deposit);
            } else if (type2 == 43) {
                e12.setText(R.string.otc_balance_detail_legal);
            } else if (type2 != 45) {
                e12.setText(R.string.currency_detail_system);
            } else {
                e12.setText(R.string.otc_balance_detail_fee);
            }
            e14.setText(R.string.currency_detail_status_completed);
        }
        if (DateTimeUtils.E(otcFinanceRecordItem.getGmtCreate())) {
            e13.setText(DateTimeUtils.h(otcFinanceRecordItem.getGmtCreate(), "HH:mm MM/dd"));
        } else {
            e13.setText(DateTimeUtils.h(otcFinanceRecordItem.getGmtCreate(), "HH:mm MM/dd/yyyy "));
        }
        try {
            if (!TextUtils.isEmpty(c11)) {
                if (z11) {
                    i12 = 2;
                } else {
                    i12 = PrecisionUtil.b(c11);
                }
            }
            str = m.m(otcFinanceRecordItem.getCashFreeFlow(), i12);
        } catch (Exception e17) {
            e17.printStackTrace();
            str = "--";
        }
        e16.setText(str);
        view.setTag(R.id.item_data, otcFinanceRecordItem);
    }

    public int getResId() {
        return R.layout.item_otc_currency_allrecord;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setClass(view.getContext(), OtcCurrencyDetailOrderActivity.class);
        intent.putExtra("otc_finance_record_item", (OtcFinanceRecordItem) view.getTag(R.id.item_data));
        view.getContext().startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
