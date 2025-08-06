package androidx.camera.camera2.internal.compat.quirk;

import android.os.Build;
import android.util.Size;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Quirk;
import com.tencent.thumbplayer.tcmedia.api.TPErrorCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class ExcludedSupportedSizesQuirk implements Quirk {
    public static boolean i() {
        return "HUAWEI".equalsIgnoreCase(Build.BRAND) && "HWANE".equalsIgnoreCase(Build.DEVICE);
    }

    public static boolean j() {
        return "OnePlus".equalsIgnoreCase(Build.BRAND) && "OnePlus6".equalsIgnoreCase(Build.DEVICE);
    }

    public static boolean k() {
        return "OnePlus".equalsIgnoreCase(Build.BRAND) && "OnePlus6T".equalsIgnoreCase(Build.DEVICE);
    }

    public static boolean l() {
        String str = Build.BRAND;
        Locale locale = Locale.US;
        return "SAMSUNG".equalsIgnoreCase(str.toUpperCase(locale)) && "J7XELTE".equalsIgnoreCase(Build.DEVICE.toUpperCase(locale)) && Build.VERSION.SDK_INT >= 27;
    }

    public static boolean m() {
        String str = Build.BRAND;
        Locale locale = Locale.US;
        return "SAMSUNG".equalsIgnoreCase(str.toUpperCase(locale)) && "ON7XELTE".equalsIgnoreCase(Build.DEVICE.toUpperCase(locale)) && Build.VERSION.SDK_INT >= 27;
    }

    public static boolean n() {
        return j() || k() || i() || m() || l();
    }

    public List<Size> c(String str, int i11) {
        if (j()) {
            return e(str, i11);
        }
        if (k()) {
            return f(str, i11);
        }
        if (i()) {
            return d(str, i11, (Class<?>) null);
        }
        if (m()) {
            return h(str, i11, (Class<?>) null);
        }
        if (l()) {
            return g(str, i11, (Class<?>) null);
        }
        Logger.w("ExcludedSupportedSizesQuirk", "Cannot retrieve list of supported sizes to exclude on this device.");
        return Collections.emptyList();
    }

    public final List<Size> d(String str, int i11, Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && (i11 == 34 || i11 == 35 || cls != null)) {
            arrayList.add(new Size(720, 720));
            arrayList.add(new Size(400, 400));
        }
        return arrayList;
    }

    public final List<Size> e(String str, int i11) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && i11 == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY, 3000));
        }
        return arrayList;
    }

    public final List<Size> f(String str, int i11) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0") && i11 == 256) {
            arrayList.add(new Size(4160, 3120));
            arrayList.add(new Size(TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY, 3000));
        }
        return arrayList;
    }

    public final List<Size> g(String str, int i11, Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        if (str.equals("0")) {
            if (i11 == 34 || cls != null) {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            } else if (i11 == 35) {
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            }
        } else if (str.equals("1") && (i11 == 34 || i11 == 35 || cls != null)) {
            arrayList.add(new Size(2576, 1932));
            arrayList.add(new Size(2560, 1440));
            arrayList.add(new Size(1920, 1920));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(1920, 1080));
        }
        return arrayList;
    }

    public final List<Size> h(String str, int i11, Class<?> cls) {
        String str2 = str;
        int i12 = i11;
        ArrayList arrayList = new ArrayList();
        if (str2.equals("0")) {
            if (i12 == 34 || cls != null) {
                arrayList.add(new Size(4128, 3096));
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            } else if (i12 == 35) {
                arrayList.add(new Size(4128, 2322));
                arrayList.add(new Size(3088, 3088));
                arrayList.add(new Size(3264, 2448));
                arrayList.add(new Size(3264, 1836));
                arrayList.add(new Size(2048, 1536));
                arrayList.add(new Size(2048, 1152));
                arrayList.add(new Size(1920, 1080));
            }
        } else if (str2.equals("1") && (i12 == 34 || i12 == 35 || cls != null)) {
            arrayList.add(new Size(3264, 2448));
            arrayList.add(new Size(3264, 1836));
            arrayList.add(new Size(2448, 2448));
            arrayList.add(new Size(1920, 1920));
            arrayList.add(new Size(2048, 1536));
            arrayList.add(new Size(2048, 1152));
            arrayList.add(new Size(1920, 1080));
        }
        return arrayList;
    }
}
