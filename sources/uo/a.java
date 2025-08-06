package uo;

import android.content.Context;
import android.text.TextUtils;
import com.hbg.lib.contract.R$string;
import i6.m;
import java.math.BigDecimal;

public final class a {
    public static String a(String str, String str2) {
        BigDecimal divide = m.a(str).divide(m.a(str2), 32, 1);
        if (divide.compareTo(new BigDecimal("9999")) >= 0) {
            return "9,999";
        }
        if (divide.compareTo(BigDecimal.ONE) >= 0) {
            String plainString = divide.setScale(0, 1).toPlainString();
            return m.c(plainString, plainString);
        } else if (divide.compareTo(new BigDecimal("0.001")) > 0) {
            return divide.setScale(3, 1).stripTrailingZeros().toPlainString();
        } else {
            return "0.001";
        }
    }

    public static String b(String str, String str2, String str3, boolean z11, Context context) {
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str3) || m.a(str3).compareTo(BigDecimal.ZERO) == 0) {
                return "--";
            }
            if (!z11) {
                return String.format(a(str, str3), new Object[0]);
            }
            return String.format(context.getString(R$string.contract_lever), new Object[]{a(str, str3)});
        } else if (m.a(str2).compareTo(BigDecimal.ZERO) == 0) {
            return "--";
        } else {
            if (!z11) {
                return String.format(a(str, str2), new Object[0]);
            }
            return String.format(context.getString(R$string.contract_lever), new Object[]{a(str, str2)});
        }
    }
}
