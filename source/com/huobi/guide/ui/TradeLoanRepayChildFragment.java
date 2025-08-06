package com.huobi.guide.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import pro.huobi.R;

public class TradeLoanRepayChildFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public TextView f72465l;

    public static TradeLoanRepayChildFragment Eh(int i11) {
        TradeLoanRepayChildFragment tradeLoanRepayChildFragment = new TradeLoanRepayChildFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_LOAN_REPAY_TYPE", i11);
        tradeLoanRepayChildFragment.setArguments(bundle);
        return tradeLoanRepayChildFragment;
    }

    public void afterInit() {
        super.afterInit();
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i11 = arguments.getInt("KEY_LOAN_REPAY_TYPE");
            if (i11 == 1) {
                this.f72465l.setText(getString(R.string.n_trade_margin_auto_borrow_instructions));
            } else if (i11 == 2) {
                this.f72465l.setText(getString(R.string.n_trade_margin_auto_repay_instructions));
            } else {
                this.f72465l.setText(getString(R.string.n_user_center_setting_theme_normal_instructions));
            }
        }
    }

    public void initViews() {
        this.f72465l = (TextView) this.f67460i.b(R.id.tv_content);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_trade_loan_repay_guide_child, viewGroup, false);
    }
}
