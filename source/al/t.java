package al;

import android.text.TextUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import i6.m;
import java.math.BigDecimal;
import wk.p0;

public final class t {
    public static BigDecimal a(String str, String str2) {
        return b(str, str2, BigDecimal.ZERO);
    }

    public static BigDecimal b(String str, String str2, BigDecimal bigDecimal) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return BigDecimal.ZERO;
        }
        BigDecimal a11 = m.a(str2);
        BigDecimal bigDecimal2 = p0.c("btc", LegalCurrencyConfigUtil.T()).get(str);
        if (bigDecimal2 == null) {
            return bigDecimal;
        }
        return bigDecimal2.multiply(a11);
    }
}
