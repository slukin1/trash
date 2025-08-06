package y0;

import android.os.Handler;
import android.os.Looper;

public class a {
    public static Handler a() {
        if (Looper.myLooper() == null) {
            return new Handler(Looper.getMainLooper());
        }
        return new Handler();
    }
}
