package zendesk.core;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sentry.q;
import com.zendesk.logger.Logger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mz.c;
import mz.f;

class DeviceInfo {
    private static final int BAD_VALUE = -1;
    private static final long BYTES_MULTIPLIER = 1024;
    private static final int EXPECTED_TOKEN_COUNT = 3;
    private static final String LOG_TAG = "DeviceInfo";
    private static final String PLATFORM_ANDROID = "Android";
    private final ActivityManager activityManager;
    private final Context context;

    public DeviceInfo(Context context2) {
        this.context = context2;
        this.activityManager = (ActivityManager) context2.getSystemService("activity");
    }

    private long getAvailableInternalDiskMemory() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
    }

    private int getBatteryLevel() {
        Intent registerReceiver = this.context.getApplicationContext().registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1);
        }
        return -1;
    }

    private String getBytesInMb(long j11) {
        return String.valueOf(j11 / 1048576);
    }

    public static Locale getCurrentLocale(Context context2) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context2.getResources().getConfiguration().getLocales().get(0);
        }
        return context2.getResources().getConfiguration().locale;
    }

    private long getDiskSize() {
        return getTotalInternalDiskSize();
    }

    private String getManufacturer() {
        String str = Build.MANUFACTURER;
        return "unknown".equals(str) || f.e(str) ? "" : str;
    }

    private String getOS() {
        String str = Build.VERSION.RELEASE;
        boolean z11 = "unknown".equals(str) || f.e(str);
        int i11 = Build.VERSION.SDK_INT;
        boolean z12 = i11 == 0;
        if (z11 && z12) {
            return "";
        }
        return String.format(Locale.US, "%s/%s", new Object[]{str, Integer.valueOf(i11)});
    }

    private long getTotalInternalDiskSize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
    }

    private long getTotalMemory() {
        Logger.b(LOG_TAG, "Using getTotalMemoryApi() to determine memory", new Object[0]);
        return getTotalMemoryApi();
    }

    private long getTotalMemoryApi() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    private long getUsedDiskSpace() {
        return getDiskSize() - getAvailableInternalDiskMemory();
    }

    private long getUsedMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        return getTotalMemory() - memoryInfo.availMem;
    }

    public Map<String, String> getInfo() {
        HashMap hashMap = new HashMap();
        String os2 = getOS();
        String model = getModel();
        long usedMemory = getUsedMemory();
        long totalMemory = getTotalMemory();
        long diskSize = getDiskSize();
        long usedDiskSpace = getUsedDiskSpace();
        int batteryLevel = getBatteryLevel();
        String locale = getLocale();
        String manufacturer = getManufacturer();
        if (!f.e(os2)) {
            hashMap.put(q.f30469g, os2);
        }
        if (!f.e(model)) {
            hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, model);
        }
        if (usedMemory != -1) {
            hashMap.put("memory_used", getBytesInMb(usedMemory));
        }
        if (totalMemory != -1) {
            hashMap.put("memory_total", getBytesInMb(totalMemory));
        }
        if (diskSize != -1) {
            hashMap.put("disk_total", getBytesInMb(diskSize));
        }
        if (usedDiskSpace != -1) {
            hashMap.put("disk_used", getBytesInMb(usedDiskSpace));
        }
        if (batteryLevel != -1) {
            hashMap.put("battery_level", String.valueOf(batteryLevel));
        }
        if (!f.e(locale)) {
            hashMap.put("sys_locale", locale);
        }
        if (!f.e(manufacturer)) {
            hashMap.put("manufacturer", manufacturer);
        }
        hashMap.put("platform", "Android");
        return hashMap;
    }

    public String getLocale() {
        return c.d(Locale.getDefault());
    }

    public String getModel() {
        String str = Build.MODEL;
        boolean z11 = "unknown".equals(str) || f.e(str);
        String str2 = Build.DEVICE;
        boolean z12 = "unknown".equals(str2) || f.e(str2);
        if (z11 && z12) {
            return "";
        }
        if (str.equals(str2)) {
            return str;
        }
        return String.format(Locale.US, "%s/%s", new Object[]{str, str2});
    }
}
