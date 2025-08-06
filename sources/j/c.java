package j;

import android.content.Context;
import android.os.Build;
import androidx.biometric.R$array;

public class c {
    public static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 30) {
            return false;
        }
        return b(context, str, R$array.assume_strong_biometrics_models);
    }

    public static boolean b(Context context, String str, int i11) {
        if (str == null) {
            return false;
        }
        for (String equals : context.getResources().getStringArray(i11)) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(Context context, String str, int i11) {
        if (str == null) {
            return false;
        }
        for (String startsWith : context.getResources().getStringArray(i11)) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static boolean d(Context context, String str, int i11) {
        if (str == null) {
            return false;
        }
        for (String equalsIgnoreCase : context.getResources().getStringArray(i11)) {
            if (str.equalsIgnoreCase(equalsIgnoreCase)) {
                return true;
            }
        }
        return false;
    }

    public static boolean e(Context context, String str) {
        if (Build.VERSION.SDK_INT != 29) {
            return false;
        }
        return b(context, str, R$array.delay_showing_prompt_models);
    }

    public static boolean f(Context context, String str) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        return c(context, str, R$array.hide_fingerprint_instantly_prefixes);
    }

    public static boolean g(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT != 28) {
            return false;
        }
        if (d(context, str, R$array.crypto_fingerprint_fallback_vendors) || c(context, str2, R$array.crypto_fingerprint_fallback_prefixes)) {
            return true;
        }
        return false;
    }
}
