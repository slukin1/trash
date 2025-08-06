package com.huobi.guide.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import java.util.Objects;
import pro.huobi.R;

public class ContractGuideOtherFragment extends EmptyMVPFragment {
    public static ContractGuideOtherFragment Eh(int i11) {
        ContractGuideOtherFragment contractGuideOtherFragment = new ContractGuideOtherFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tabIndex", i11);
        contractGuideOtherFragment.setArguments(bundle);
        return contractGuideOtherFragment;
    }

    public void initViews() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i11 = arguments.getInt("tabIndex", 2);
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.f67460i.b(R.id.contract_guide_other_text);
            if (i11 == 2) {
                Context context = getContext();
                Objects.requireNonNull(context);
                Context context2 = context;
                appCompatTextView.setText(context.getResources().getString(R.string.n_contract_intro_tpsl_content));
            } else if (i11 == 3) {
                Context context3 = getContext();
                Objects.requireNonNull(context3);
                Context context4 = context3;
                appCompatTextView.setText(context3.getResources().getString(R.string.n_contract_intro_plan_content));
            } else if (i11 == 4) {
                Context context5 = getContext();
                Objects.requireNonNull(context5);
                Context context6 = context5;
                appCompatTextView.setText(context5.getResources().getString(R.string.n_contract_intro_follow_content));
            } else if (i11 == 5) {
                Context context7 = getContext();
                Objects.requireNonNull(context7);
                Context context8 = context7;
                appCompatTextView.setText(context7.getResources().getString(R.string.n_contract_intro_time_weight_new_content));
            }
        }
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_contract_guide_other, viewGroup, false);
    }
}
