package androidx.biometric;

import android.os.Build;
import androidx.biometric.BiometricPrompt;

public class b {
    public static String a(int i11) {
        if (i11 == 15) {
            return "BIOMETRIC_STRONG";
        }
        if (i11 == 255) {
            return "BIOMETRIC_WEAK";
        }
        if (i11 == 32768) {
            return "DEVICE_CREDENTIAL";
        }
        if (i11 != 32783) {
            return i11 != 33023 ? String.valueOf(i11) : "BIOMETRIC_WEAK | DEVICE_CREDENTIAL";
        }
        return "BIOMETRIC_STRONG | DEVICE_CREDENTIAL";
    }

    public static int b(BiometricPrompt.PromptInfo promptInfo, BiometricPrompt.b bVar) {
        if (promptInfo.a() != 0) {
            return promptInfo.a();
        }
        int i11 = bVar != null ? 15 : 255;
        return promptInfo.g() ? 32768 | i11 : i11;
    }

    public static boolean c(int i11) {
        return (i11 & 32768) != 0;
    }

    public static boolean d(int i11) {
        return (i11 & 32767) != 0;
    }

    public static boolean e(int i11) {
        if (i11 == 15 || i11 == 255) {
            return true;
        }
        if (i11 != 32768) {
            if (i11 != 32783) {
                return i11 == 33023 || i11 == 0;
            }
            int i12 = Build.VERSION.SDK_INT;
            return i12 < 28 || i12 > 29;
        } else if (Build.VERSION.SDK_INT >= 30) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean f(int i11) {
        return (i11 & 255) == 255;
    }
}
