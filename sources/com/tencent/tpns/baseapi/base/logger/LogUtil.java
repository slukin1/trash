package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.os.Environment;
import com.luck.picture.lib.permissions.PermissionConfig;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogUtil {
    public static String PATTERN_DATETIME_FILENAME = "yyyyMMdd_HHmm";

    /* renamed from: a  reason: collision with root package name */
    private static ThreadLocal<DateFormat> f49772a = new ThreadLocal<>();

    private static boolean a(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Throwable th2) {
            TBaseLogger.e("LogUtil", "checkPermission error", th2);
            return false;
        }
    }

    public static String formatDate(Date date, String str) {
        try {
            return a(str).format(date);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getTodayDateTimeForFilename() {
        return new SimpleDateFormat(PATTERN_DATETIME_FILENAME).format(new Date());
    }

    public static boolean isDaysAgo(Date date, int i11) {
        if (date == null) {
            return false;
        }
        try {
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(date.getTime());
            instance.add(5, -i11);
            return instance.after(instance2);
        } catch (Throwable th2) {
            TBaseLogger.e("LogUtil", "action -> isDaysAgo ", th2);
            return false;
        }
    }

    public static boolean isSDCardMounted(Context context) {
        String externalStorageState;
        if (context == null) {
            return false;
        }
        try {
            if (!a(context, PermissionConfig.WRITE_EXTERNAL_STORAGE) || (externalStorageState = Environment.getExternalStorageState()) == null || !externalStorageState.equals("mounted")) {
                return false;
            }
            return true;
        } catch (Throwable th2) {
            TBaseLogger.e("LogUtil", "isSDCardMounted", th2);
        }
    }

    public static Date parse(String str, String str2) {
        try {
            return a(str2).parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Date parseDateInFilename(String str) {
        try {
            return new SimpleDateFormat(PATTERN_DATETIME_FILENAME).parse(str);
        } catch (Throwable th2) {
            TBaseLogger.e("LogUtil", "parse filename datetime error - " + str, th2);
            return null;
        }
    }

    private static DateFormat a(String str) {
        DateFormat dateFormat = f49772a.get();
        if (dateFormat != null) {
            return dateFormat;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        f49772a.set(simpleDateFormat);
        return simpleDateFormat;
    }
}
