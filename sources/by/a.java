package by;

import android.util.Log;
import com.rodolfonavalon.shaperipplelibrary.ShapeRipple;

public class a {
    public static void a(String str) {
        if (ShapeRipple.DEBUG) {
            Log.d(ShapeRipple.TAG, str);
        }
    }

    public static void b(String str) {
        if (ShapeRipple.DEBUG) {
            Log.e(ShapeRipple.TAG, str);
        }
    }
}
