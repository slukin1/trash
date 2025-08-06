package vy;

import android.os.Build;

public class c {
    public static boolean a() {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        String str = Build.VERSION.CODENAME;
        if (str.length() != 1 || str.charAt(0) < 'Q' || str.charAt(0) > 'Z') {
            return false;
        }
        return true;
    }
}
