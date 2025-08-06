package com.huobi.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.R$color;
import i6.m;
import java.math.BigDecimal;

public final class n0 {
    public static CharSequence a(Context context, int i11, String str) {
        return b(context, i11, str, "", "");
    }

    public static CharSequence b(Context context, int i11, String str, String str2, String str3) {
        BigDecimal a11 = m.a(str);
        if (i11 == -1) {
            i11 = a11.scale();
        }
        String q11 = m.q(a11, i11);
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2 + "+" + q11 + "%" + str3);
            if (w.l()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
                return spannableStringBuilder;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
            return spannableStringBuilder;
        } else if (a11.compareTo(BigDecimal.ZERO) < 0) {
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str2 + q11 + "%" + str3);
            if (w.l()) {
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder2.length(), 33);
                return spannableStringBuilder2;
            }
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder2.length(), 33);
            return spannableStringBuilder2;
        } else {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(str2 + q11 + "%" + str3);
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_default_text_color)), 0, spannableStringBuilder3.length(), 33);
            return spannableStringBuilder3;
        }
    }
}
