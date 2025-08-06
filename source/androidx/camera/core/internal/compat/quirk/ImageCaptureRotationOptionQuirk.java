package androidx.camera.core.internal.compat.quirk;

import android.os.Build;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirk;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.huawei.hms.android.SystemUtils;

public final class ImageCaptureRotationOptionQuirk implements Quirk {
    private static boolean isEmulator() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && !str.startsWith("unknown")) {
            String str2 = Build.MODEL;
            return str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Cuttlefish") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || (Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) || Build.PRODUCT.equals("google_sdk") || Build.HARDWARE.contains("ranchu");
        }
    }

    private static boolean isEmulatorAndApi21() {
        return isEmulator() && Build.VERSION.SDK_INT == 21;
    }

    private static boolean isHonor9X() {
        return SystemUtils.PRODUCT_HONOR.equalsIgnoreCase(Build.BRAND) && "STK-LX1".equalsIgnoreCase(Build.MODEL);
    }

    private static boolean isHuaweiMate20Lite() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "SNE-LX1".equalsIgnoreCase(Build.MODEL);
    }

    public static boolean load() {
        return isHuaweiMate20Lite() || isHonor9X() || isEmulatorAndApi21();
    }

    public boolean isSupported(Config.Option<?> option) {
        return option != CaptureConfig.OPTION_ROTATION;
    }
}
