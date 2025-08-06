package com.huobi.finance.viewhandler;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapFinancialRecord;
import com.huobi.finance.bean.FinanceRecordItem;
import com.xiaomi.mipush.sdk.Constants;
import d7.k;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;
import vk.t;

public class LinearSwapTransferOrderViewHandler implements c {
    public final String b(Resources resources, String str) {
        if ("usdt".equalsIgnoreCase(str)) {
            return resources.getString(R.string.n_linear_swap_cross_account);
        }
        if ("husd".equalsIgnoreCase(str)) {
            return resources.getString(R.string.n_linear_swap_cross_husd_account);
        }
        return str.replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "/");
    }

    public final String c(Resources resources, LinearSwapFinancialRecord.FinancialRecord financialRecord) {
        String moneyType = financialRecord.getMoneyType();
        moneyType.hashCode();
        char c11 = 65535;
        switch (moneyType.hashCode()) {
            case 1571:
                if (moneyType.equals("14")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1572:
                if (moneyType.equals("15")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1638:
                if (moneyType.equals(FinanceRecordItem.TYPE_FUTURE_LINEAR_SWAP_INNER)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (!TextUtils.isEmpty(financialRecord.getToMarginAccount())) {
                    return resources.getString(R.string.n_balance_pro_to_linear_swap_account);
                }
                break;
            case 1:
                if (financialRecord.getFromMarginAccount() != null && financialRecord.getFromMarginAccount().equalsIgnoreCase("HT")) {
                    return resources.getString(R.string.n_balance_linear_swap_usdt_to_pro);
                }
                Object[] objArr = new Object[1];
                objArr[0] = financialRecord.getFromMarginAccount() == null ? "" : financialRecord.getFromMarginAccount();
                return resources.getString(R.string.n_balance_linear_swap_usdt_to_pro_2, objArr);
            case 2:
                if (!TextUtils.isEmpty(financialRecord.getFromMarginAccount()) && !TextUtils.isEmpty(financialRecord.getToMarginAccount())) {
                    return resources.getString(R.string.n_balance_linear_swap_usdt_to_linear_swap, new Object[]{b(resources, financialRecord.getFromMarginAccount()), b(resources, financialRecord.getToMarginAccount())});
                }
        }
        return "--";
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, t tVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.transfer_order_currency);
        TextView textView2 = (TextView) e11.b(R.id.tv_transfer_order_amount);
        TextView textView3 = (TextView) e11.b(R.id.tv_transfer_order_type);
        TextView textView4 = (TextView) e11.b(R.id.tv_transfer_order_date);
        TextView textView5 = (TextView) e11.b(R.id.transfer_order_system);
        Resources resources = textView.getResources();
        LinearSwapFinancialRecord.FinancialRecord c11 = tVar.c();
        if (!TextUtils.isEmpty(c11.getAsset())) {
            textView.setText(k.C().z(c11.getAsset()));
        }
        if (!TextUtils.isEmpty(c11.getMoney())) {
            textView2.setText(m.m(c11.getMoney(), FuturePrecisionUtil.f(c11.getSymbol())));
        }
        textView3.setText(c(resources, c11));
        textView5.setVisibility(8);
        if (DateTimeUtils.E(c11.getCreatedAt())) {
            textView4.setText(DateTimeUtils.h(c11.getCreatedAt(), "HH:mm MM/dd"));
        } else {
            textView4.setText(DateTimeUtils.h(c11.getCreatedAt(), "HH:mm MM/dd/yyyy "));
        }
    }

    public int getResId() {
        return R.layout.transfer_history_item;
    }
}
