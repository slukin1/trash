package a7;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.R$color;
import com.hbg.lib.data.symbol.TradeType;
import i6.m;
import java.math.BigDecimal;

public final class b {
    public static String a(String str, String str2, String str3, String str4, String str5, TradeType tradeType) {
        BigDecimal a11 = m.a(str);
        BigDecimal a12 = m.a(str2);
        BigDecimal a13 = m.a(str3);
        BigDecimal a14 = m.a(str4);
        if (TradeType.CONTRACT != tradeType && TradeType.SWAP != tradeType) {
            return a12.subtract(a11).multiply(a13).multiply(a14).toPlainString();
        }
        if (a12.compareTo(BigDecimal.ZERO) == 0 || a11.compareTo(BigDecimal.ZERO) == 0) {
            return str5;
        }
        return a13.divide(a11, 32, 1).subtract(a13.divide(a12, 32, 1)).multiply(a14).toPlainString();
    }

    public static String b(String str, String str2, String str3, String str4, TradeType tradeType) {
        BigDecimal a11 = m.a(str);
        BigDecimal divide = m.a(str2).divide(m.a("100"), 32, 1);
        BigDecimal a12 = m.a(str3);
        if (TradeType.CONTRACT == tradeType || TradeType.SWAP == tradeType) {
            if (a11.compareTo(BigDecimal.ZERO) == 0 || a12.compareTo(BigDecimal.ZERO) == 0) {
                return str4;
            }
            if (divide.compareTo(a12) >= 0) {
                return BigDecimal.ZERO.toPlainString();
            }
            return a11.divide(BigDecimal.ONE.subtract(divide.divide(a12, 32, 1)), 32, 1).toPlainString();
        } else if (a11.compareTo(BigDecimal.ZERO) == 0 || a12.compareTo(BigDecimal.ZERO) == 0) {
            return str4;
        } else {
            return BigDecimal.ONE.add(divide.divide(a12, 32, 1)).multiply(a11).toPlainString();
        }
    }

    public static String c(String str, String str2, String str3, String str4, String str5, TradeType tradeType) {
        BigDecimal a11 = m.a(str);
        BigDecimal a12 = m.a(str3);
        BigDecimal a13 = m.a(str4);
        BigDecimal a14 = m.a(str2);
        if (TradeType.CONTRACT != tradeType && TradeType.SWAP != tradeType) {
            return a11.subtract(a14).multiply(a12).multiply(a13).toPlainString();
        }
        if (a14.compareTo(BigDecimal.ZERO) == 0 || a11.compareTo(BigDecimal.ZERO) == 0) {
            return str5;
        }
        return a12.divide(a14, 32, 1).subtract(a12.divide(a11, 32, 1)).multiply(a13).toPlainString();
    }

    public static String d(String str, String str2, String str3, String str4, TradeType tradeType) {
        BigDecimal a11 = m.a(str);
        BigDecimal divide = m.a(str2).divide(m.a("100"), 32, 1);
        BigDecimal a12 = m.a(str3);
        if (TradeType.CONTRACT == tradeType || TradeType.SWAP == tradeType) {
            if (a11.compareTo(BigDecimal.ZERO) == 0 || a12.compareTo(BigDecimal.ZERO) == 0) {
                return str4;
            }
            return a11.divide(BigDecimal.ONE.add(divide.divide(a12, 32, 1)), 32, 1).toPlainString();
        } else if (a11.compareTo(BigDecimal.ZERO) == 0 || a12.compareTo(BigDecimal.ZERO) == 0) {
            return str4;
        } else {
            if (divide.abs().compareTo(a12) >= 0) {
                return BigDecimal.ZERO.toPlainString();
            }
            return BigDecimal.ONE.subtract(divide.divide(a12, 32, 1)).multiply(a11).toPlainString();
        }
    }

    public static SpannableStringBuilder e(String str, int i11, String str2, Context context) {
        BigDecimal a11 = m.a(str);
        String u11 = m.u(str, i11);
        if ("--".equals(str)) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("-- " + StringUtils.i(str2));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.baseColorSecondaryText)), 0, spannableStringBuilder.length(), 33);
            return spannableStringBuilder;
        } else if (a11.compareTo(BigDecimal.ZERO) > 0) {
            SpannableStringBuilder append = new SpannableStringBuilder("+").append(u11).append(" ").append(StringUtils.i(str2));
            if (w.l()) {
                append.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_huobi_color)), 0, append.length(), 33);
                return append;
            }
            append.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, com.hbg.lib.core.R$color.global_quotation_down_color)), 0, append.length(), 33);
            return append;
        } else if (a11.compareTo(BigDecimal.ZERO) == 0) {
            SpannableStringBuilder append2 = new SpannableStringBuilder(u11).append(" ").append(StringUtils.i(str2));
            append2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.baseColorPrimaryText)), 0, append2.length(), 33);
            return append2;
        } else {
            SpannableStringBuilder append3 = new SpannableStringBuilder(u11).append(" ").append(StringUtils.i(str2));
            if (w.l()) {
                append3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.global_quotation_down_color)), 0, append3.length(), 33);
                return append3;
            }
            append3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, com.hbg.lib.core.R$color.global_huobi_color)), 0, append3.length(), 33);
            return append3;
        }
    }
}
