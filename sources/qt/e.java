package qt;

import android.text.TextUtils;
import i6.m;
import java.math.BigDecimal;

public final class e {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (m.a(str2).compareTo(BigDecimal.ZERO) > 0) {
            return str + "*(-" + str2 + ")";
        }
        return str + "*" + m.a(str2).abs();
    }
}
