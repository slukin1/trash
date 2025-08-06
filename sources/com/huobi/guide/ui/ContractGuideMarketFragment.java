package com.huobi.guide.ui;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import pro.huobi.R;

public class ContractGuideMarketFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public boolean f72460l = false;

    public static ContractGuideMarketFragment Eh() {
        return new ContractGuideMarketFragment();
    }

    public void Fh(boolean z11) {
        this.f72460l = z11;
    }

    public void initViews() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) this.f67460i.b(R.id.atv_top_text);
        if (this.f72460l) {
            appCompatTextView.setText(getResources().getString(R.string.n_exchange_intro_market_c1));
        } else {
            appCompatTextView.setText(getResources().getString(R.string.n_contract_intro_market_c1));
        }
        String string = getContext().getResources().getString(R.string.n_contract_intro_market_c3);
        String format = String.format(getContext().getResources().getString(R.string.n_contract_intro_market_c2), new Object[]{string});
        int indexOf = format.indexOf(string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.baseColorPrimaryText)), indexOf, string.length() + indexOf, 17);
        ((AppCompatTextView) this.f67460i.b(R.id.atv_bottom_text)).setText(spannableStringBuilder);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_contract_guide_market, viewGroup, false);
    }
}
