package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ax;
import com.xiaomi.push.gl;
import com.xiaomi.push.i;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;

public class af {

    /* renamed from: a  reason: collision with root package name */
    private static Context f52443a;

    /* renamed from: a  reason: collision with other field name */
    private static Object f3323a;

    /* renamed from: a  reason: collision with other field name */
    private static WeakHashMap<Integer, af> f3324a = new WeakHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private static boolean f3325a;

    /* renamed from: a  reason: collision with other field name */
    private String f3326a;

    /* renamed from: b  reason: collision with root package name */
    private String f52444b;

    private af(String str) {
        this.f3326a = str;
    }

    public static String b(String str, String str2) {
        return a(a() ? "mipush|%s|%s" : "mipush_%s_%s", str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public Context m2978a() {
        return f52443a;
    }

    public String c(String str, String str2) {
        return a() ? str : str2;
    }

    public String toString() {
        return "NotificationManagerHelper{" + this.f3326a + "}";
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2979a() {
        return this.f3326a;
    }

    public static af a(Context context, String str) {
        a(context);
        int hashCode = str.hashCode();
        af afVar = f3324a.get(Integer.valueOf(hashCode));
        if (afVar != null) {
            return afVar;
        }
        af afVar2 = new af(str);
        f3324a.put(Integer.valueOf(hashCode), afVar2);
        return afVar2;
    }

    private String b(String str) {
        return b(this.f3326a, str);
    }

    public String b() {
        if (TextUtils.isEmpty(this.f52444b)) {
            this.f52444b = b("default");
        }
        return this.f52444b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public List<StatusBarNotification> m2983b() {
        StatusBarNotification[] statusBarNotificationArr;
        String str = this.f3326a;
        NotificationManager a11 = a();
        ArrayList arrayList = null;
        try {
            if (a()) {
                int a12 = i.a();
                if (a12 == -1) {
                    return null;
                }
                return (List) a(ax.a(f3323a, "getAppActiveNotifications", str, Integer.valueOf(a12)));
            }
            if (Build.VERSION.SDK_INT >= 23) {
                statusBarNotificationArr = a11.getActiveNotifications();
            } else {
                statusBarNotificationArr = a();
            }
            if (statusBarNotificationArr == null || statusBarNotificationArr.length <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (StatusBarNotification statusBarNotification : statusBarNotificationArr) {
                    if (str.equals(ag.c(statusBarNotification.getNotification()))) {
                        arrayList2.add(statusBarNotification);
                    }
                }
                return arrayList2;
            } catch (Throwable th2) {
                th = th2;
                arrayList = arrayList2;
                a("getActiveNotifications error " + th);
                return arrayList;
            }
        } catch (Throwable th3) {
            th = th3;
            a("getActiveNotifications error " + th);
            return arrayList;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2975a(Context context) {
        a(context);
        return a();
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String a11 = a("mipush|%s|%s", str2, "");
        return str.startsWith(a11) ? a("mipush_%s_%s", str2, str.replace(a11, "")) : str;
    }

    private static void a(Context context) {
        if (f52443a == null) {
            f52443a = context.getApplicationContext();
            NotificationManager a11 = a();
            Boolean bool = (Boolean) ax.a((Object) a11, "isSystemConditionProviderEnabled", "xmsf_fake_condition_provider_path");
            a("fwk is support.init:" + bool);
            boolean booleanValue = bool != null ? bool.booleanValue() : false;
            f3325a = booleanValue;
            if (booleanValue) {
                f3323a = ax.a((Object) a11, "getService", new Object[0]);
            }
        }
    }

    private static NotificationManager a() {
        return (NotificationManager) f52443a.getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static boolean m2974a() {
        if (j.a() && ah.a(f52443a).a(gl.NotificationBelongToAppSwitch.a(), true)) {
            return f3325a;
        }
        return false;
    }

    private static int a(String str) {
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        try {
            return f52443a.getPackageManager().getPackageUid(str, 0);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static Object a(List list) {
        return Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[]{List.class}).newInstance(new Object[]{list});
    }

    private static <T> T a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj.getClass().getMethod("getList", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return String.format(str, new Object[]{str2, str3});
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2982a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith(b(""));
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2980a(String str) {
        if (TextUtils.isEmpty(str)) {
            return b();
        }
        return j.a(a()) ? b(str) : str;
    }

    @TargetApi(26)
    public void a(NotificationChannel notificationChannel) {
        String str = this.f3326a;
        try {
            if (a()) {
                int a11 = a(str);
                if (a11 != -1) {
                    Object a12 = a(Arrays.asList(new NotificationChannel[]{notificationChannel}));
                    ax.b(f3323a, "createNotificationChannelsForPackage", str, Integer.valueOf(a11), a12);
                    return;
                }
                return;
            }
            a().createNotificationChannel(notificationChannel);
        } catch (Exception e11) {
            a("createNotificationChannel error" + e11);
        }
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public NotificationChannel m2977a(String str) {
        try {
            if (!a()) {
                return a().getNotificationChannel(str);
            }
            List<NotificationChannel> a11 = a();
            if (a11 == null) {
                return null;
            }
            for (NotificationChannel notificationChannel : a11) {
                if (str.equals(notificationChannel.getId())) {
                    return notificationChannel;
                }
            }
            return null;
        } catch (Exception e11) {
            a("getNotificationChannel error" + e11);
            return null;
        }
    }

    @TargetApi(26)
    /* renamed from: a  reason: collision with other method in class */
    public List<NotificationChannel> m2981a() {
        String str;
        String str2 = this.f3326a;
        List<NotificationChannel> list = null;
        try {
            if (a()) {
                int a11 = a(str2);
                if (a11 != -1) {
                    str = "mipush|%s|%s";
                    list = (List) a(ax.a(f3323a, "getNotificationChannelsForPackage", str2, Integer.valueOf(a11), Boolean.FALSE));
                } else {
                    str = null;
                }
            } else {
                list = a().getNotificationChannels();
                str = "mipush_%s_%s";
            }
            if (!j.a() || list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            String a12 = a(str, str2, "");
            for (NotificationChannel next : list) {
                if (next.getId().startsWith(a12)) {
                    arrayList.add(next);
                }
            }
            return arrayList;
        } catch (Exception e11) {
            a("getNotificationChannels error " + e11);
            return null;
        }
    }

    public void a(NotificationChannel notificationChannel, boolean z11) {
        String str = this.f3326a;
        if (z11) {
            try {
                int a11 = a(str);
                if (a11 != -1) {
                    ax.b(f3323a, "updateNotificationChannelForPackage", str, Integer.valueOf(a11), notificationChannel);
                }
            } catch (Exception e11) {
                a("updateNotificationChannel error " + e11);
            }
        } else {
            a(notificationChannel);
        }
    }

    public void a(int i11, Notification notification) {
        String str = this.f3326a;
        NotificationManager a11 = a();
        try {
            int i12 = Build.VERSION.SDK_INT;
            if (a()) {
                if (i12 >= 19) {
                    notification.extras.putString("xmsf_target_package", str);
                }
                if (i12 >= 29) {
                    a11.notifyAsPackage(str, (String) null, i11, notification);
                } else {
                    a11.notify(i11, notification);
                }
            } else {
                a11.notify(i11, notification);
            }
        } catch (Exception unused) {
        }
    }

    public void a(int i11) {
        String str = this.f3326a;
        try {
            if (a()) {
                int a11 = i.a();
                String packageName = a().getPackageName();
                if (Build.VERSION.SDK_INT >= 30) {
                    ax.b(f3323a, "cancelNotificationWithTag", str, packageName, null, Integer.valueOf(i11), Integer.valueOf(a11));
                } else {
                    ax.b(f3323a, "cancelNotificationWithTag", str, null, Integer.valueOf(i11), Integer.valueOf(a11));
                }
                a("cancel succ:" + i11);
                return;
            }
            a().cancel(i11);
        } catch (Exception e11) {
            a("cancel error" + e11);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private StatusBarNotification[] m2976a() {
        if (!j.a(a())) {
            return null;
        }
        try {
            String packageName = a().getPackageName();
            Object a11 = ax.a(f3323a, "getActiveNotifications", packageName);
            if (a11 instanceof StatusBarNotification[]) {
                return (StatusBarNotification[]) a11;
            }
            return null;
        } catch (Throwable th2) {
            a("getAllNotifications error " + th2);
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static void m2973a(String str) {
        b.a("NMHelper:" + str);
    }
}
