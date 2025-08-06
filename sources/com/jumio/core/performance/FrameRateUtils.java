package com.jumio.core.performance;

import android.content.Context;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.jumio.commons.log.Log;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class FrameRateUtils {
    public static final FrameRateUtils INSTANCE = new FrameRateUtils();

    public final boolean checkThresholdForFrameRate(long j11, long j12) {
        return j11 > j12;
    }

    public final boolean checkThresholdForFrameRate(long j11, long j12, float f11) {
        return checkThresholdForFrameRate(j12, (long) (((float) j11) * f11));
    }

    public final Display getDisplay(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            return context.getDisplay();
        }
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    public final long getFrameRate(Context context) {
        Display display = getDisplay(context);
        Long valueOf = display != null ? Long.valueOf((long) display.getRefreshRate()) : null;
        if (valueOf != null) {
            return valueOf.longValue();
        }
        Log.w("FrameRateUtils", "Could not determine frame rate for device, using default value of 60");
        return 60;
    }

    public final long getFrameRateFromSample(List<Long> list, long j11) {
        return ((long) list.size()) / TimeUnit.SECONDS.convert(j11, TimeUnit.NANOSECONDS);
    }
}
