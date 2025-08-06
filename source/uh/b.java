package uh;

import android.view.View;
import com.hbg.lib.common.utils.StringUtils;
import vh.d;

public final class b {
    public static void a(View view, String str) {
        if (view != null && !StringUtils.r(str)) {
            new vh.b(view.getContext(), str).showAsDropDown(view, 0, 10);
        }
    }

    public static void b(View view, String str, int i11) {
        if (view != null && !StringUtils.r(str)) {
            new vh.b(view.getContext(), str).f(view, i11);
        }
    }

    public static void c(View view, String str, int i11) {
        if (view != null && !StringUtils.r(str)) {
            new d(view.getContext(), str).f(view, i11);
        }
    }
}
