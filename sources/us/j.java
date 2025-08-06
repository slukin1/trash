package us;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.contract.R$color;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.w;

public final class j {
    public static String a(String str, Context context) {
        return String.format(context.getString(R$string.n_contract_index_trade_name), new Object[]{StringUtils.i(str)});
    }

    public static String b(String str, Context context, String str2) {
        String string = context.getString(R$string.n_contract_index_trade_name);
        return String.format(string, new Object[]{StringUtils.i(str) + StringUtils.i(str2)});
    }

    public static String c(Context context, String str, String str2) {
        return str + str2;
    }

    public static String d(Context context) {
        return context.getString(R$string.n_market_contract_index_trade_name_abbr);
    }

    public static SpannableStringBuilder e(String str, String str2, String str3, Context context) {
        SpannableStringBuilder spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(g(context, str));
        int i11 = R$color.global_main_text_color;
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i11)), 0, spannableStringBuilder2.length(), 33);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(context.getString(R$string.middle_point));
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i11)), 0, spannableStringBuilder3.length(), 33);
        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(str3);
        spannableStringBuilder4.append("X").append(spannableStringBuilder3);
        if ("buy".equalsIgnoreCase(str2)) {
            spannableStringBuilder = new SpannableStringBuilder(context.getString(R$string.contarct_position_more));
            if (w.l()) {
                int i12 = R$color.global_huobi_color;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i12)), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i12)), 0, spannableStringBuilder4.length(), 33);
            } else {
                int i13 = R$color.global_quotation_down_color;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i13)), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i13)), 0, spannableStringBuilder4.length(), 33);
            }
        } else {
            spannableStringBuilder = new SpannableStringBuilder(context.getString(R$string.contarct_position_empty));
            if (w.l()) {
                int i14 = R$color.global_quotation_down_color;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i14)), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i14)), 0, spannableStringBuilder4.length(), 33);
            } else {
                int i15 = R$color.global_huobi_color;
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i15)), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i15)), 0, spannableStringBuilder4.length(), 33);
            }
        }
        return spannableStringBuilder2.append(" ").append(spannableStringBuilder4).append(spannableStringBuilder);
    }

    public static String f(String str, Context context) {
        return String.format(context.getString(R$string.n_swap_trade_name), new Object[]{StringUtils.i(str)});
    }

    public static String g(Context context, String str) {
        if (AppLanguageHelper.getInstance().isHkChineseLanguage() || AppLanguageHelper.getInstance().isChineseLanguage()) {
            return i(str) + j(context);
        }
        return i(str) + " " + j(context);
    }

    public static String h(String str, Context context) {
        return String.format(context.getString(R$string.n_contract_swap_trade_name), new Object[]{StringUtils.i(str)});
    }

    public static String i(String str) {
        return str + "usd".toUpperCase();
    }

    public static String j(Context context) {
        return context.getString(R$string.n_market_contract_swap_trade_name);
    }

    public static String k(Context context) {
        return context.getString(R$string.n_market_contract_swap_trade_name_abbr);
    }

    public static String l(Context context, String str) {
        return i(str) + " " + j(context);
    }
}
