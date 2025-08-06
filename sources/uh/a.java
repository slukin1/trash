package uh;

import android.text.TextUtils;
import com.hbg.lib.widgets.NumAnimTextView;
import com.hbg.lib.widgets.NumberAnimView;
import i6.m;

public final class a {
    public static void a(NumAnimTextView numAnimTextView, String str) {
        b(numAnimTextView, str, true);
    }

    public static void b(NumAnimTextView numAnimTextView, String str, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            numAnimTextView.setText("--");
        } else if (z11) {
            numAnimTextView.setNumber(m.a(str));
            numAnimTextView.j();
        } else if (m.a0(str)) {
            numAnimTextView.setNumber(m.a(str));
        } else {
            numAnimTextView.setText(str);
        }
    }

    public static void c(NumberAnimView numberAnimView, String str) {
        d(numberAnimView, str, true);
    }

    public static void d(NumberAnimView numberAnimView, String str, boolean z11) {
        if (TextUtils.isEmpty(str)) {
            numberAnimView.setText("--");
        } else if (z11) {
            numberAnimView.setNumber(m.a(str));
            numberAnimView.f();
        } else {
            numberAnimView.setText(str);
        }
    }
}
