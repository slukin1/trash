package com.huobi.contract.viewhandler;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bj.d;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.finance.bean.ContractRecordItem;
import com.huobi.finance.ui.ContractDetailOrderActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;
import vk.l;

public class ContractRecordViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, l lVar, ViewGroup viewGroup) {
        String str;
        View view = cVar.itemView;
        ContractRecordItem c11 = lVar.c();
        r e11 = cVar.e();
        TextView e12 = e11.e(R.id.currency_record_label);
        TextView e13 = e11.e(R.id.currency_record_time);
        TextView e14 = e11.e(R.id.currency_record_piece);
        TextView e15 = e11.e(R.id.currency_record_amount);
        TextView e16 = e11.e(R.id.currency_record_amount_label);
        String string = view.getResources().getString(d.f(d.g(c11.getMoneyType())));
        String string2 = view.getResources().getString(R.string.currency_detail_contract_finance_money);
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(c11.getSymbol()) ? "" : c11.getSymbol();
        e16.setText(String.format(string2, objArr));
        if (!TextUtils.isEmpty(c11.getContractCode())) {
            e12.setText(string + Constants.ACCEPT_TIME_SEPARATOR_SERVER + c11.getContractCode());
        } else {
            e12.setText(string);
        }
        int o11 = ContractCurrencyUtils.o(c11.getSymbol(), 8);
        String str2 = "--";
        if (TextUtils.isEmpty(c11.getMoney())) {
            str = str2;
        } else {
            str = m.m(c11.getMoney(), o11);
        }
        e15.setText(str);
        if (!TextUtils.isEmpty(c11.getAmount())) {
            str2 = m.y(c11.getAmount(), 0);
        }
        e14.setText(str2);
        if (DateTimeUtils.E(c11.getCreatedAt())) {
            e13.setText(DateTimeUtils.h(c11.getCreatedAt(), "HH:mm MM/dd"));
        } else {
            e13.setText(DateTimeUtils.h(c11.getCreatedAt(), "HH:mm MM/dd/yyyy "));
        }
        view.setTag(c11);
        view.setOnClickListener(this);
    }

    public int getResId() {
        return R.layout.item_contract_allrecord;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getTag() instanceof ContractRecordItem) {
            Intent intent = new Intent();
            intent.setClass(view.getContext(), ContractDetailOrderActivity.class);
            intent.putExtra("finance_record_item", (ContractRecordItem) view.getTag());
            view.getContext().startActivity(intent);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
