package com.huobi.utils;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.util.w;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.math.BigDecimal;

public final class u0 {
    public static SpannableStringBuilder a(String str, Context context, int i11) {
        SpannableStringBuilder spannableStringBuilder;
        BigDecimal a11 = m.a(str);
        if ((str == null || !str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) && a11.compareTo(BigDecimal.ZERO) >= 0) {
            spannableStringBuilder = new SpannableStringBuilder("+" + str);
            if (w.l()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
            }
        } else {
            spannableStringBuilder = new SpannableStringBuilder(str);
            if (w.l()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder b(String str, Context context, int i11) {
        SpannableStringBuilder spannableStringBuilder;
        BigDecimal a11 = m.a(str);
        if ((str == null || !str.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) && a11.compareTo(BigDecimal.ZERO) >= 0) {
            spannableStringBuilder = new SpannableStringBuilder("+" + str + "%");
            if (w.l()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
            }
        } else {
            spannableStringBuilder = new SpannableStringBuilder(str + "%");
            if (w.l()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, spannableStringBuilder.length(), 33);
            } else {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, spannableStringBuilder.length(), 33);
            }
        }
        return spannableStringBuilder;
    }
}
