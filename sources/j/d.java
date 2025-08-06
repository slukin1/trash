package j;

import android.content.Context;
import android.util.Log;
import androidx.biometric.R$string;

public class d {
    public static String a(Context context, int i11) {
        if (context == null) {
            return "";
        }
        if (i11 == 1) {
            return context.getString(R$string.fingerprint_error_hw_not_available);
        }
        if (i11 != 7) {
            switch (i11) {
                case 9:
                    break;
                case 10:
                    return context.getString(R$string.fingerprint_error_user_canceled);
                case 11:
                    return context.getString(R$string.fingerprint_error_no_fingerprints);
                case 12:
                    return context.getString(R$string.fingerprint_error_hw_not_present);
                default:
                    Log.e("BiometricUtils", "Unknown error code: " + i11);
                    return context.getString(R$string.default_error_msg);
            }
        }
        return context.getString(R$string.fingerprint_error_lockout);
    }

    public static boolean b(int i11) {
        switch (i11) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return true;
            default:
                return false;
        }
    }

    public static boolean c(int i11) {
        return i11 == 7 || i11 == 9;
    }
}
