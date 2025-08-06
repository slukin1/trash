package com.tencent.tpns.baseapi.base;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import com.tencent.tpns.baseapi.base.util.Logger;

public class TPushAlarmManager {

    /* renamed from: a  reason: collision with root package name */
    private static TPushAlarmManager f49752a = new TPushAlarmManager();

    /* renamed from: b  reason: collision with root package name */
    private static AlarmManager f49753b = null;

    private TPushAlarmManager() {
    }

    private void a(int i11, long j11, PendingIntent pendingIntent) {
        Logger.d("TPushAlarmManager", "Alarm setExactAndAllowWhileIdle  delay: " + j11);
        try {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 31) {
                if (f49753b.canScheduleExactAlarms()) {
                    Logger.d("TPushAlarmManager", "Alarm scheule using setExactAndAllowWhileIdle, delay: " + j11);
                    f49753b.setExactAndAllowWhileIdle(i11, j11, pendingIntent);
                    return;
                }
                Logger.d("TPushAlarmManager", "ungrant SCHEDULE_EXACT_ALARM permission,  using set delay:" + j11);
                f49753b.set(i11, j11, pendingIntent);
            } else if (i12 >= 23) {
                f49753b.setExactAndAllowWhileIdle(i11, j11, pendingIntent);
            } else {
                f49753b.set(i11, j11, pendingIntent);
            }
        } catch (Throwable th2) {
            Logger.e("TPushAlarmManager", "Alarm scheule using set, error: " + j11, th2);
        }
    }

    private void b(int i11, long j11, PendingIntent pendingIntent) {
        Logger.d("TPushAlarmManager", "Alarm setExact  delay: " + j11);
        try {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 31) {
                if (f49753b.canScheduleExactAlarms()) {
                    Logger.d("TPushAlarmManager", "Alarm scheule using setExact, delay: " + j11);
                    f49753b.setExact(i11, j11, pendingIntent);
                    return;
                }
                Logger.d("TPushAlarmManager", "ungrant SCHEDULE_EXACT_ALARM permission,  use  set delay:" + j11);
                f49753b.set(i11, j11, pendingIntent);
            } else if (i12 >= 23) {
                f49753b.setExact(i11, j11, pendingIntent);
            } else {
                f49753b.set(i11, j11, pendingIntent);
            }
        } catch (Throwable th2) {
            Logger.e("TPushAlarmManager", "Alarm scheule using set, error: " + j11, th2);
        }
    }

    public static TPushAlarmManager getAlarmManager(Context context) {
        if (f49753b == null) {
            a(context);
        }
        return f49752a;
    }

    public void cancal(PendingIntent pendingIntent) {
        AlarmManager alarmManager = f49753b;
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void set(int i11, long j11, PendingIntent pendingIntent, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("set isPowerSaveMode:");
        sb2.append(z11);
        sb2.append(" , Build.VERSION.SDK_INT:");
        int i12 = Build.VERSION.SDK_INT;
        sb2.append(i12);
        Logger.d("TPushAlarmManager", sb2.toString());
        if (i12 >= 23 && !z11) {
            a(i11, j11, pendingIntent);
        } else if (i12 < 19 || z11) {
            try {
                Logger.d("TPushAlarmManager", "Alarm scheule using set, delay: " + j11);
                f49753b.set(i11, j11, pendingIntent);
            } catch (Throwable th2) {
                Logger.e("TPushAlarmManager", "Alarm scheule using set, error: " + j11, th2);
            }
        } else {
            b(i11, j11, pendingIntent);
        }
    }

    public void setRepeating(long j11, long j12, PendingIntent pendingIntent) {
        AlarmManager alarmManager = f49753b;
        if (alarmManager != null) {
            alarmManager.setRepeating(2, j11, j12, pendingIntent);
        }
    }

    private static synchronized void a(Context context) {
        synchronized (TPushAlarmManager.class) {
            if (f49753b == null && context != null) {
                f49753b = (AlarmManager) context.getSystemService("alarm");
            }
        }
    }
}
