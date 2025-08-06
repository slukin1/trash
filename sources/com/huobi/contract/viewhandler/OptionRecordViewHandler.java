package com.huobi.contract.viewhandler;

import a7.e;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bj.d;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.option.core.bean.OptionFinancialRecord;
import com.huobi.finance.ui.OptionDetailOrderActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import pro.huobi.R;
import s9.c;
import vk.u;

public class OptionRecordViewHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, u uVar, ViewGroup viewGroup) {
        String str;
        View view = cVar.itemView;
        r e11 = cVar.e();
        TextView e12 = e11.e(R.id.currency_record_time);
        TextView e13 = e11.e(R.id.currency_record_piece);
        TextView e14 = e11.e(R.id.currency_record_amount);
        TextView e15 = e11.e(R.id.currency_record_amount_label);
        OptionFinancialRecord c11 = uVar.c();
        String string = view.getResources().getString(R.string.currency_detail_contract_finance_money);
        boolean z11 = true;
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(c11.getCurrency()) ? "" : c11.getCurrency();
        e15.setText(String.format(string, objArr));
        c(e11, c11);
        int n11 = FuturePrecisionUtil.n(c11.getSymbol());
        String str2 = "--";
        if (TextUtils.isEmpty(c11.getMoney())) {
            str = str2;
        } else {
            str = m.m(c11.getMoney(), n11);
        }
        e14.setText(str);
        if (!TextUtils.isEmpty(c11.getAmount()) && m.a(c11.getAmount()).compareTo(BigDecimal.ZERO) != 0) {
            z11 = false;
        }
        if (!z11) {
            str2 = m.y(c11.getAmount(), 0);
        }
        e13.setText(str2);
        e12.setText(DateTimeUtils.C(c11.getCreatedAt()));
        view.setTag(c11);
        view.setOnClickListener(this);
    }

    public final void c(r rVar, OptionFinancialRecord optionFinancialRecord) {
        TextView e11 = rVar.e(R.id.currency_record_label);
        Context context = e11.getContext();
        Resources resources = e11.getResources();
        String string = resources.getString(d.f(d.g(optionFinancialRecord.getMoneyType())));
        String optionCode = optionFinancialRecord.getOptionCode();
        if (TextUtils.isEmpty(optionCode)) {
            e11.setText(string);
        } else if (optionCode.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            e11.setText(new SpannableStringBuilder(String.format("%s-", new Object[]{string})).append(e.z(optionFinancialRecord.getSymbol(), optionCode, context, resources.getColor(R.color.global_main_text_color))));
        } else {
            e11.setText(String.format("%s-%s", new Object[]{string, optionCode}));
        }
    }

    public int getResId() {
        return R.layout.item_option_all_record;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getTag() instanceof OptionFinancialRecord) {
            Intent intent = new Intent();
            intent.setClass(view.getContext(), OptionDetailOrderActivity.class);
            intent.putExtra("finance_record_item", (OptionFinancialRecord) view.getTag());
            view.getContext().startActivity(intent);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
