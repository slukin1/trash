package w0;

import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.iproov.sdk.bridge.OptionsBridge;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Field f16727a;

    /* renamed from: b  reason: collision with root package name */
    public static final WeakHashMap<Object, WeakReference<Object>> f16728b = new WeakHashMap<>();

    /* renamed from: w0.a$a  reason: collision with other inner class name */
    public static class C0107a {
        public static String a(LocationManager locationManager) {
            return locationManager.getGnssHardwareModelName();
        }

        public static int b(LocationManager locationManager) {
            return locationManager.getGnssYearOfHardware();
        }

        public static boolean c(LocationManager locationManager) {
            return locationManager.isLocationEnabled();
        }
    }

    public static boolean a(LocationManager locationManager) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            return C0107a.c(locationManager);
        }
        if (i11 <= 19) {
            try {
                if (f16727a == null) {
                    Field declaredField = LocationManager.class.getDeclaredField("mContext");
                    f16727a = declaredField;
                    declaredField.setAccessible(true);
                }
                Context context = (Context) f16727a.get(locationManager);
                if (context != null) {
                    if (i11 != 19) {
                        return !TextUtils.isEmpty(Settings.Secure.getString(context.getContentResolver(), "location_providers_allowed"));
                    }
                    if (Settings.Secure.getInt(context.getContentResolver(), "location_mode", 0) != 0) {
                        return true;
                    }
                    return false;
                }
            } catch (ClassCastException | IllegalAccessException | NoSuchFieldException | SecurityException unused) {
            }
        }
        if (locationManager.isProviderEnabled(OptionsBridge.NETWORK_KEY) || locationManager.isProviderEnabled("gps")) {
            return true;
        }
        return false;
    }
}
