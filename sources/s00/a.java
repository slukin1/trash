package s00;

import android.content.res.Resources;

public final class a {
    public static int a(int i11) {
        return i11 * ((int) Resources.getSystem().getDisplayMetrics().density);
    }
}
