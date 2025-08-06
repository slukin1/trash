package il;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.R$color;
import com.hbg.lib.data.R$string;

public final class a {
    public static SpannableStringBuilder a(String str, String str2, Context context) {
        String str3;
        String str4;
        String str5;
        String str6;
        if (w.l()) {
            if ("tp".equalsIgnoreCase(str)) {
                if ("buy".equals(str2)) {
                    str6 = context.getString(R$string.n_contract_tp_buy);
                } else {
                    str6 = context.getString(R$string.n_contract_tp_sell);
                }
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str6);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.base_down_color)), 0, spannableStringBuilder.length(), 33);
                return spannableStringBuilder;
            }
            if ("buy".equals(str2)) {
                str5 = context.getString(R$string.n_contract_sl_buy);
            } else {
                str5 = context.getString(R$string.n_contract_sl_sell);
            }
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(str5);
            spannableStringBuilder2.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.base_up_color)), 0, spannableStringBuilder2.length(), 33);
            return spannableStringBuilder2;
        } else if ("SL".equalsIgnoreCase(str)) {
            if ("buy".equals(str2)) {
                str4 = context.getString(R$string.n_contract_sl_buy);
            } else {
                str4 = context.getString(R$string.n_contract_sl_sell);
            }
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(str4);
            spannableStringBuilder3.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.base_down_color)), 0, spannableStringBuilder3.length(), 33);
            return spannableStringBuilder3;
        } else {
            if ("buy".equals(str2)) {
                str3 = context.getString(R$string.n_contract_tp_buy);
            } else {
                str3 = context.getString(R$string.n_contract_tp_sell);
            }
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(str3);
            spannableStringBuilder4.setSpan(new ForegroundColorSpan(ContextCompat.getColor(context, R$color.base_up_color)), 0, spannableStringBuilder4.length(), 33);
            return spannableStringBuilder4;
        }
    }
}
