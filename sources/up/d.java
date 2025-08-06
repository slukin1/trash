package up;

import android.widget.TextView;
import i6.m;

public final class d {
    public static String a(double d11) {
        if (Double.isNaN(d11)) {
            return "--";
        }
        return m.j(d11, 2, "--");
    }

    public static void b(TextView textView, String str, double d11) {
        textView.setText(String.format("%s %s", new Object[]{str, a(d11)}));
    }
}
