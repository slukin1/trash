package zendesk.support;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.zendesk.logger.Logger;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import mz.c;
import mz.f;

class SupportSdkMetadata {
    private static final int BAD_VALUE = -1;
    private static final long BYTES_MULTIPLIER = 1024;
    private static final String DEVICE_INFO_API_VERSION = "device_api";
    private static final String DEVICE_INFO_BATTERY = "device_battery";
    private static final String DEVICE_INFO_DEVICE_NAME = "device_name";
    private static final String DEVICE_INFO_LOW_MEMORY = "device_low_memory";
    private static final String DEVICE_INFO_MANUFACTURER = "device_manufacturer";
    private static final String DEVICE_INFO_MODEL_TYPE = "device_model";
    private static final String DEVICE_INFO_OS_VERSION = "device_os";
    private static final String DEVICE_INFO_TOTAL_MEMORY = "device_total_memory";
    private static final String DEVICE_INFO_USED_MEMORY = "device_used_memory";
    private static final int EXPECTED_TOKEN_COUNT = 3;
    private static final String LOG_TAG = "SupportSdkMetadata";
    private final ActivityManager activityManager;
    private final Context context;

    public SupportSdkMetadata(Context context2) {
        this.context = context2;
        this.activityManager = (ActivityManager) context2.getSystemService("activity");
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

    private String getManufacturer() {
        String str = Build.MANUFACTURER;
        return "unknown".equals(str) || f.e(str) ? "" : str;
    }

    private String getModel() {
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

    private String getModelDeviceName() {
        return Build.DEVICE;
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

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005c A[SYNTHETIC, Splitter:B:17:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0089 A[Catch:{ NoSuchElementException -> 0x00a6, NumberFormatException -> 0x009d }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b2 A[SYNTHETIC, Splitter:B:34:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long getTotalMemoryCompat() {
        /*
            r8 = this;
            java.lang.String r0 = "Failed to close /proc/meminfo file stream: "
            java.lang.String r1 = "SupportSdkMetadata"
            r2 = 0
            r3 = 0
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x003c, all -> 0x0036 }
            java.io.FileReader r5 = new java.io.FileReader     // Catch:{ IOException -> 0x003c, all -> 0x0036 }
            java.lang.String r6 = "/proc/meminfo"
            r5.<init>(r6)     // Catch:{ IOException -> 0x003c, all -> 0x0036 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x003c, all -> 0x0036 }
            java.lang.String r3 = r4.readLine()     // Catch:{ IOException -> 0x0034 }
            r4.close()     // Catch:{ IOException -> 0x001a }
            goto L_0x007b
        L_0x001a:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r0 = r4.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.Object[] r5 = new java.lang.Object[r2]
            com.zendesk.logger.Logger.k(r1, r0, r4, r5)
            goto L_0x007b
        L_0x0034:
            r3 = move-exception
            goto L_0x0040
        L_0x0036:
            r4 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x00b0
        L_0x003c:
            r4 = move-exception
            r7 = r4
            r4 = r3
            r3 = r7
        L_0x0040:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r5.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r6 = "Failed to determine total memory from /proc/meminfo: "
            r5.append(r6)     // Catch:{ all -> 0x00af }
            java.lang.String r6 = r3.getMessage()     // Catch:{ all -> 0x00af }
            r5.append(r6)     // Catch:{ all -> 0x00af }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00af }
            java.lang.Object[] r6 = new java.lang.Object[r2]     // Catch:{ all -> 0x00af }
            com.zendesk.logger.Logger.c(r1, r5, r3, r6)     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x0079
            r4.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0079
        L_0x0060:
            r3 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = r3.getMessage()
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.Object[] r4 = new java.lang.Object[r2]
            com.zendesk.logger.Logger.k(r1, r0, r3, r4)
        L_0x0079:
            java.lang.String r3 = ""
        L_0x007b:
            java.util.StringTokenizer r0 = new java.util.StringTokenizer
            r0.<init>(r3)
            r3 = -1
            int r5 = r0.countTokens()     // Catch:{ NoSuchElementException -> 0x00a6, NumberFormatException -> 0x009d }
            r6 = 3
            if (r5 != r6) goto L_0x00ae
            r0.nextToken()     // Catch:{ NoSuchElementException -> 0x00a6, NumberFormatException -> 0x009d }
            java.lang.String r0 = r0.nextToken()     // Catch:{ NoSuchElementException -> 0x00a6, NumberFormatException -> 0x009d }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ NoSuchElementException -> 0x00a6, NumberFormatException -> 0x009d }
            long r0 = r0.longValue()     // Catch:{ NoSuchElementException -> 0x00a6, NumberFormatException -> 0x009d }
            r2 = 1024(0x400, double:5.06E-321)
            long r0 = r0 * r2
            r3 = r0
            goto L_0x00ae
        L_0x009d:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r5 = "Error reading memory size from proc/meminfo"
            com.zendesk.logger.Logger.c(r1, r5, r0, r2)
            goto L_0x00ae
        L_0x00a6:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r5 = "Error reading tokens from the /proc/meminfo"
            com.zendesk.logger.Logger.c(r1, r5, r0, r2)
        L_0x00ae:
            return r3
        L_0x00af:
            r3 = move-exception
        L_0x00b0:
            if (r4 == 0) goto L_0x00cf
            r4.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00cf
        L_0x00b6:
            r4 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r0 = r4.getMessage()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.zendesk.logger.Logger.k(r1, r0, r4, r2)
        L_0x00cf:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.support.SupportSdkMetadata.getTotalMemoryCompat():long");
    }

    private long getUsedMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        return getTotalMemory() - memoryInfo.availMem;
    }

    private int getVersionCode() {
        return Build.VERSION.SDK_INT;
    }

    private String getVersionName() {
        return Build.VERSION.RELEASE;
    }

    private boolean isLowMemory() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    public Map<String, String> getDeviceInfoAsMapForMetaData() {
        HashMap hashMap = new HashMap();
        hashMap.put(DEVICE_INFO_OS_VERSION, getVersionName());
        hashMap.put(DEVICE_INFO_API_VERSION, String.valueOf(getVersionCode()));
        hashMap.put("device_model", getModel());
        hashMap.put(DEVICE_INFO_DEVICE_NAME, getModelDeviceName());
        hashMap.put(DEVICE_INFO_MANUFACTURER, getManufacturer());
        hashMap.put(DEVICE_INFO_TOTAL_MEMORY, getBytesInMb(getTotalMemory()));
        hashMap.put(DEVICE_INFO_USED_MEMORY, getBytesInMb(getUsedMemory()));
        hashMap.put(DEVICE_INFO_LOW_MEMORY, String.valueOf(isLowMemory()));
        hashMap.put(DEVICE_INFO_BATTERY, String.valueOf(getBatteryLevel()));
        return hashMap;
    }

    public String getLocale() {
        return c.d(Locale.getDefault());
    }
}
