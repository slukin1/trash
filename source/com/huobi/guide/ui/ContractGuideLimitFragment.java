package com.huobi.guide.ui;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.core.ui.EmptyMVPFragment;
import dw.a;
import java.util.concurrent.TimeUnit;
import kl.b;
import kl.c;
import pro.huobi.R;
import rx.Observable;

public class ContractGuideLimitFragment extends EmptyMVPFragment {

    /* renamed from: l  reason: collision with root package name */
    public boolean f72459l = false;

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh(Void voidR) {
        Gh(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(Void voidR) {
        Gh(false);
    }

    public static ContractGuideLimitFragment Jh() {
        return new ContractGuideLimitFragment();
    }

    public final void Gh(boolean z11) {
        boolean z12 = z11;
        if (this.f72459l != z12) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) this.f67460i.b(R.id.atv_limit_buy);
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) this.f67460i.b(R.id.atv_limit_sell);
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.f67460i.b(R.id.aiv_contract_guide_pic);
            AppCompatTextView appCompatTextView3 = (AppCompatTextView) this.f67460i.b(R.id.atv_bottom_text);
            String string = getContext().getResources().getString(R.string.n_contract_intro_limit_c10);
            if (z12) {
                appCompatImageView.setImageResource(R.drawable.ic_contract_guide_limit_buy);
                String string2 = getContext().getResources().getString(R.string.n_contract_intro_limit_c9);
                String format = String.format(getContext().getResources().getString(R.string.n_contract_intro_limit_c7), new Object[]{string2, string});
                int indexOf = format.indexOf(string2);
                int indexOf2 = format.indexOf(string);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.baseColorPrimaryText)), indexOf, string2.length() + indexOf, 17);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.baseColorPrimaryText)), indexOf2, string.length() + indexOf2, 17);
                appCompatTextView3.setText(spannableStringBuilder);
                appCompatTextView.setTextColor(getContext().getResources().getColor(R.color.baseColorMajorTheme100));
                appCompatTextView.setBackgroundColor(getContext().getResources().getColor(R.color.baseColorMajorTheme006));
                appCompatTextView2.setTextColor(getContext().getResources().getColor(R.color.baseColorSecondaryTextNew));
                appCompatTextView2.setBackgroundColor(getContext().getResources().getColor(R.color.baseColorContentBackground));
            } else {
                appCompatImageView.setImageResource(R.drawable.ic_contract_guide_limit_sell);
                String string3 = getContext().getResources().getString(R.string.n_contract_intro_limit_c11);
                String format2 = String.format(getContext().getResources().getString(R.string.n_contract_intro_limit_c8), new Object[]{string, string3});
                int lastIndexOf = format2.lastIndexOf(string);
                int indexOf3 = format2.indexOf(string3);
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(format2);
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.baseColorPrimaryText)), lastIndexOf, string.length() + lastIndexOf, 17);
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.baseColorPrimaryText)), indexOf3, string3.length() + indexOf3, 17);
                appCompatTextView3.setText(spannableStringBuilder2);
                appCompatTextView2.setTextColor(getContext().getResources().getColor(R.color.baseColorMajorTheme100));
                appCompatTextView2.setBackgroundColor(getContext().getResources().getColor(R.color.baseColorMajorTheme006));
                appCompatTextView.setTextColor(getContext().getResources().getColor(R.color.baseColorSecondaryTextNew));
                appCompatTextView.setBackgroundColor(getContext().getResources().getColor(R.color.baseColorContentBackground));
            }
            this.f72459l = z12;
        }
    }

    public void initViews() {
        Gh(true);
        Observable<Void> a11 = a.a(this.f67460i.b(R.id.atv_limit_buy));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        a11.throttleFirst(1, timeUnit).subscribe(new c(this));
        a.a(this.f67460i.b(R.id.atv_limit_sell)).throttleFirst(1, timeUnit).subscribe(new b(this));
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.dialog_contract_guide_limit, viewGroup, false);
    }
}
