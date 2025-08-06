package sy;

import android.text.TextUtils;
import com.ta.a.e.h;
import uy.g;

public class b {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(vy.b.d(g.c(str.getBytes()), 2), "UTF-8");
        } catch (Exception e11) {
            h.d("", e11, new Object[0]);
            return "";
        }
    }
}
