package com.huobi.finance.viewhandler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.huobi.finance.bean.TransferOrderHistory;
import com.huobi.supermargin.ui.SuperLoanDetailActivity;
import com.huobi.supermargin.ui.SuperRepayDetailActivity;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import i6.r;
import pro.huobi.R;
import s9.c;

public class TransferOrderViewHandler implements c {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ v9.c f67631b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ TransferOrderHistory f67632c;

        public a(v9.c cVar, TransferOrderHistory transferOrderHistory) {
            this.f67631b = cVar;
            this.f67632c = transferOrderHistory;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            Context context = this.f67631b.itemView.getContext();
            String type = this.f67632c.getType();
            if (TransferOrderHistory.TYPE_SUPER_USER_REPAY.equals(type) || TransferOrderHistory.TYPE_SUPER_SYSTEM_REPAY.equals(type)) {
                context.startActivity(SuperRepayDetailActivity.fg(context, this.f67632c.getRepayId()));
            } else if (TransferOrderHistory.TYPE_SUPER_USER_LOAN_PAYOFF.equals(type) || TransferOrderHistory.TYPE_SUPER_USER_LOAN_NOT_PAYOFF.equals(type)) {
                context.startActivity(SuperLoanDetailActivity.fg(context, this.f67632c.getLoanId()));
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public final void b(TransferOrderHistory transferOrderHistory, TextView textView, TextView textView2, TextView textView3) {
        if (d(transferOrderHistory.getHistoryType())) {
            if (!TextUtils.isEmpty(transferOrderHistory.getDeductCurrency())) {
                textView.setText(m.m(transferOrderHistory.getAmount(), 10));
                if ("HT".equalsIgnoreCase(transferOrderHistory.getDeductCurrency())) {
                    textView2.setText(R.string.ht_deduct_return);
                } else if ("HTX".equalsIgnoreCase(transferOrderHistory.getDeductCurrency())) {
                    textView2.setText(R.string.balance_super_margin_histoay_deduct_currency_htx);
                } else if ("TRX".equalsIgnoreCase(transferOrderHistory.getDeductCurrency())) {
                    textView2.setText(R.string.balance_super_margin_histoay_deduct_currency_trx);
                } else if ("HBPOINT".equalsIgnoreCase(transferOrderHistory.getDeductCurrency())) {
                    textView2.setText(R.string.point_deduct_return);
                }
            }
            if (TransferOrderHistory.TYPE_SUPER_USER_LOAN_PAYOFF.equals(transferOrderHistory.getType()) || TransferOrderHistory.TYPE_SUPER_USER_LOAN_NOT_PAYOFF.equals(transferOrderHistory.getType())) {
                textView3.setText(R.string.user_loan);
            } else if (TransferOrderHistory.TYPE_SUPER_USER_REPAY.equals(transferOrderHistory.getType())) {
                textView3.setText(R.string.user_repay);
            } else if (TransferOrderHistory.TYPE_SUPER_SYSTEM_REPAY.equals(transferOrderHistory.getType())) {
                textView3.setText(R.string.system_repay);
            }
        }
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, TransferOrderHistory transferOrderHistory, ViewGroup viewGroup) {
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R.id.transfer_order_currency);
        TextView textView2 = (TextView) e11.b(R.id.tv_transfer_order_amount);
        TextView textView3 = (TextView) e11.b(R.id.tv_transfer_order_type);
        TextView textView4 = (TextView) e11.b(R.id.tv_transfer_order_date);
        TextView textView5 = (TextView) e11.b(R.id.transfer_order_system);
        if (!TextUtils.isEmpty(transferOrderHistory.getCurrency())) {
            textView.setText(k.C().z(transferOrderHistory.getCurrency()));
        }
        if (!TextUtils.isEmpty(transferOrderHistory.getAmount())) {
            textView2.setText(m.m(transferOrderHistory.getAmount(), PrecisionUtil.b(transferOrderHistory.getCurrency())));
        }
        if (!TextUtils.isEmpty(transferOrderHistory.getType())) {
            if (transferOrderHistory.getType().equals("margin-transfer-in")) {
                textView3.setText(R.string.n_transfer_to_isolated_margin);
            } else if (transferOrderHistory.getType().equals("margin-transfer-out")) {
                textView3.setText(R.string.n_transfer_from_isolate_margin);
            } else if (transferOrderHistory.getType().equals("apply-loan")) {
                textView3.setText(R.string.margin_records_type_loan);
            } else if (transferOrderHistory.getType().equals(TransferOrderHistory.TYPE_REPAY_INTEREST) || transferOrderHistory.getType().equals(TransferOrderHistory.TYPE_AUTO_REPAY_INTEREST)) {
                textView3.setText(R.string.margin_records_type_fees);
            } else if (transferOrderHistory.getType().equals(TransferOrderHistory.TYPE_REPAY_LOAN) || transferOrderHistory.getType().equals(TransferOrderHistory.TYPE_AUTO_APPLY_LOAN)) {
                textView3.setText(R.string.margin_records_type_repay);
            }
        }
        if (transferOrderHistory.getType().equals(TransferOrderHistory.TYPE_AUTO_REPAY_INTEREST) || transferOrderHistory.getType().equals(TransferOrderHistory.TYPE_AUTO_APPLY_LOAN)) {
            textView5.setVisibility(0);
        } else {
            textView5.setVisibility(4);
        }
        if (DateTimeUtils.E(transferOrderHistory.getCreatedat())) {
            textView4.setText(DateTimeUtils.h(transferOrderHistory.getCreatedat(), "HH:mm MM/dd"));
        } else {
            textView4.setText(DateTimeUtils.h(transferOrderHistory.getCreatedat(), "HH:mm MM/dd/yyyy "));
        }
        if (d(transferOrderHistory.getHistoryType())) {
            cVar.itemView.setOnClickListener(new a(cVar, transferOrderHistory));
        } else {
            cVar.itemView.setOnClickListener((View.OnClickListener) null);
        }
        b(transferOrderHistory, textView2, textView, textView3);
    }

    public final boolean d(String str) {
        if (str == null) {
            return false;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1778124681:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_SYSTEM_REPAY)) {
                    c11 = 0;
                    break;
                }
                break;
            case -1065863102:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_USER_LOAN_PAYOFF)) {
                    c11 = 1;
                    break;
                }
                break;
            case 501992723:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_USER_REPAY)) {
                    c11 = 2;
                    break;
                }
                break;
            case 1140042054:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_ALL)) {
                    c11 = 3;
                    break;
                }
                break;
            case 1254757926:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_USER_LOAN)) {
                    c11 = 4;
                    break;
                }
                break;
            case 1990917884:
                if (str.equals(TransferOrderHistory.TYPE_SUPER_USER_LOAN_NOT_PAYOFF)) {
                    c11 = 5;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    public int getResId() {
        return R.layout.transfer_history_item;
    }
}
