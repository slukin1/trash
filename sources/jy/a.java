package jy;

import android.content.Context;
import android.util.DisplayMetrics;

public class a {
    public static boolean a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }
}
