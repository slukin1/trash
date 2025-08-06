package com.huobi.finance.bean;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.CurrencyFromCCFinanceRecordInfo;
import com.huobi.finance.viewhandler.CurrencyFromCCRecordViewHandler;
import java.io.Serializable;
import pro.huobi.R;
import s9.a;

public class CurrencyFromCCFinanceRecordItem implements a, Serializable, Cloneable {
    public static final int STATUS_DEPOSIT_CHARGE_FAILURE = 8;
    public static final int STATUS_DEPOSIT_CHARGE_FAILURE2 = 9;
    public static final int STATUS_DEPOSIT_CHARGE_SUCCESS = 5;
    public static final int STATUS_DEPOSIT_USER_CANCELED = 6;
    public static final int STATUS_DEPOSIT_USER_CANCELED2 = 7;
    public static final int STATUS_DEPOSIT_WAITING_PAYMENT = 1;
    public static final int STATUS_WITHDRAW_CANCELED = 10;
    public static final int STATUS_WITHDRAW_FAILURE = 8;
    public static final int STATUS_WITHDRAW_FAILURE2 = 9;
    public static final int STATUS_WITHDRAW_FAILURE3 = 11;
    public static final int STATUS_WITHDRAW_FAILURE4 = 12;
    public static final int STATUS_WITHDRAW_SUCCESS = 7;
    public static final int STATUS_WITHDRAW_WAITING_REVIEW = 1;
    public static final int TYPE_DEPOSIT = 1;
    public static final int TYPE_TRANSFER = 3;
    public static final int TYPE_WITHDRAW = 2;
    private static final long serialVersionUID = -1817698282201638982L;
    private CurrencyFromCCFinanceRecordInfo info;
    private CurrencyFromCCItemClickListener listener;

    public CurrencyFromCCFinanceRecordItem(CurrencyFromCCFinanceRecordInfo currencyFromCCFinanceRecordInfo) {
        this.info = currencyFromCCFinanceRecordInfo;
    }

    public CurrencyFromCCFinanceRecordInfo getInfo() {
        return this.info;
    }

    public CurrencyFromCCItemClickListener getListener() {
        return this.listener;
    }

    public String getStatusTextId(Context context) {
        if (this.info.getType() == 1) {
            int stateInt = this.info.getStateInt();
            if (stateInt == 1) {
                return context.getString(R.string.otc_order_detail_seller_waiting_pay_status_text);
            }
            switch (stateInt) {
                case 5:
                    return context.getString(R.string.n_currency_from_cc_deposit_success);
                case 6:
                case 7:
                    return context.getString(R.string.n_otc_trade_order_status_cancel);
                case 8:
                case 9:
                    return context.getString(R.string.n_currency_from_cc_deposit_failure);
                default:
                    return context.getString(R.string.currency_detail_status_processing);
            }
        } else if (this.info.getType() == 2) {
            int stateInt2 = this.info.getStateInt();
            if (stateInt2 == 1) {
                return context.getString(R.string.currency_detail_status_needcheck);
            }
            switch (stateInt2) {
                case 7:
                    return context.getString(R.string.n_currency_from_cc_withdraw_success);
                case 8:
                case 9:
                case 11:
                case 12:
                    return context.getString(R.string.n_currency_from_cc_withdraw_failure);
                case 10:
                    return context.getString(R.string.n_otc_trade_order_status_cancel);
                default:
                    return context.getString(R.string.currency_detail_status_processing);
            }
        } else if (TextUtils.equals(this.info.getState(), FinanceRecordItem.STATE_VALID)) {
            return context.getString(R.string.currency_detail_status_completed);
        } else {
            return context.getString(R.string.currency_detail_status_failed);
        }
    }

    public String getViewHandlerName() {
        return CurrencyFromCCRecordViewHandler.class.getName();
    }

    public void setListener(CurrencyFromCCItemClickListener currencyFromCCItemClickListener) {
        this.listener = currencyFromCCItemClickListener;
    }
}
