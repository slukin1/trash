package ej;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.contract.R$color;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.w;

public final class g {
    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("this_week".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_thisweek);
            }
            if ("next_week".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_nextweek);
            }
            if ("quarter".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_quarter);
            }
            if ("next_quarter".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_trade_next_quarter);
            }
        }
        return "";
    }

    public static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("this_week".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_thisweek_abbr);
            }
            if ("next_week".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_nextweek_abbr);
            }
            if ("quarter".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_quarter_abbr);
            }
            if ("next_quarter".equals(str)) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_trade_next_quarter_abbr);
            }
        }
        return "";
    }

    public static String c(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("CW")) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_thisweek);
            }
            if (str.contains("NW")) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_nextweek);
            }
            if (str.contains("CQ")) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_symbol_quarter);
            }
            if (str.contains("NQ")) {
                return BaseApplication.b().getResources().getString(R$string.n_market_contract_trade_next_quarter);
            }
        }
        return "";
    }

    public static String d(String str, String str2, int i11) {
        String str3;
        String str4;
        try {
            String c11 = c(str);
            if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
                str3 = "";
            } else {
                str3 = str2.substring(str2.length() - 4);
            }
            String f11 = f(str);
            if (i11 == 1) {
                str4 = f11 + "USD " + c11;
            } else {
                str4 = f11 + "USD " + c11 + str3;
            }
            return str4;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String e(Context context, String str, String str2, String str3) {
        String i11 = i(context, str);
        String substring = (TextUtils.isEmpty(str2) || str2.length() <= 4) ? "" : str2.substring(str2.length() - 4);
        if (AppLanguageHelper.getInstance().isHkChineseLanguage() || AppLanguageHelper.getInstance().isChineseLanguage()) {
            return i11 + substring;
        }
        return i11 + " " + substring;
    }

    public static String f(String str) {
        return (TextUtils.isEmpty(str) || !str.contains("_")) ? "" : str.split("_")[0];
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str) || str.length() <= 6) {
            return str;
        }
        return str.substring(0, str.length() - 6) + str.substring((str.length() - 6) + 2, str.length());
    }

    public static String h(String str, String str2, int i11) {
        String str3;
        try {
            String f11 = f(str);
            String c11 = c(str);
            if (TextUtils.isEmpty(str2) || str2.length() <= 4) {
                str3 = "";
            } else {
                str3 = str2.substring(str2.length() - 4);
            }
            String str4 = f11 + "usd".toUpperCase();
            if (!AppLanguageHelper.getInstance().isHkChineseLanguage() && !AppLanguageHelper.getInstance().isChineseLanguage()) {
                str4 = str4 + " ";
            }
            if (i11 == 2) {
                return str4 + c11;
            } else if (i11 == 3) {
                return str4 + str3;
            } else {
                return str4 + c11 + str3;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String i(Context context, String str) {
        return str + "usd".toUpperCase();
    }

    public static String j(Context context, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(a(str2));
        if (!TextUtils.isEmpty(str) && str.length() > 4) {
            sb2.append(str.substring(str.length() - 4));
        }
        return sb2.toString();
    }

    public static String k(Context context, String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str) && str.length() > 4) {
            sb2.append(str.substring(str.length() - 4));
        }
        sb2.append(b(str2));
        return sb2.toString();
    }

    public static String l(Context context, String str, String str2, String str3) {
        return i(context, str) + " " + j(context, str2, str3);
    }

    public static SpannableStringBuilder m(String str, String str2, String str3, String str4, String str5, Context context) {
        SpannableStringBuilder spannableStringBuilder;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(h(str5, str3, 2));
        int i11 = R$color.global_main_text_color;
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i11)), 0, spannableStringBuilder2.length(), 33);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(context.getString(R$string.middle_point));
        spannableStringBuilder3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, i11)), 0, spannableStringBuilder3.length(), 33);
        SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(str4);
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
}
