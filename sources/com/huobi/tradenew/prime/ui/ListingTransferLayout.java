package com.huobi.tradenew.prime.ui;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huobi.trade.prime.bean.PrimeAveragePosition;
import java.util.Locale;
import pro.huobi.R;

public class ListingTransferLayout extends PrimeLiteLayout {
    public ListingTransferLayout(Context context) {
        super(context);
    }

    public void O() {
        PrimeAveragePosition primeAveragePosition;
        if (this.F == null || (primeAveragePosition = this.G) == null) {
            TextView textView = this.f83032h;
            Locale locale = Locale.US;
            String string = getResources().getString(R.string.prime_trade_limit_amount_tip);
            textView.setText(String.format(locale, string, new Object[]{" -- " + this.D.toUpperCase(locale)}));
        } else if (primeAveragePosition.isQualify()) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            Locale locale2 = Locale.US;
            spannableStringBuilder.append(String.format(locale2, getResources().getString(R.string.prime_trade_limit_amount_tip), new Object[]{""}));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), R.color.baseColorPrimaryText)), 0, spannableStringBuilder.length(), 33);
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" " + this.E + " " + this.D.toUpperCase(locale2));
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(getContext(), getAmountColorRes())), 0, spannableStringBuilder2.length(), 33);
            this.f83032h.setText(spannableStringBuilder.append(spannableStringBuilder2));
        } else {
            TextView textView2 = this.f83032h;
            Locale locale3 = Locale.US;
            String string2 = getResources().getString(R.string.prime_trade_limit_amount_tip);
            textView2.setText(String.format(locale3, string2, new Object[]{" 0 " + this.D.toUpperCase(locale3)}));
        }
    }

    public int getLogoImgResId() {
        return R.drawable.listingtransfer;
    }

    public boolean t() {
        return false;
    }

    public ListingTransferLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ListingTransferLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
