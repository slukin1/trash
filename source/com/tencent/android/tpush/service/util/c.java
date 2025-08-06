package com.tencent.android.tpush.service.util;

import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.util.CloudManager;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.baseapi.base.util.TTask;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f69845a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f69846b;

    public static int b(Context context) {
        NotificationManager notificationManager;
        try {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 26 && (notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)) != null) {
                boolean areNotificationsEnabled = notificationManager.areNotificationsEnabled();
                TLogger.d("NotificationsUtils", "OS >= 26, areNotificationsEnabled " + areNotificationsEnabled);
                if (areNotificationsEnabled) {
                    return 2;
                }
                return 1;
            } else if (i11 < 19) {
                return 4;
            } else {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                String packageName = context.getApplicationContext().getPackageName();
                int i12 = applicationInfo.uid;
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class});
                int intValue = ((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue();
                TLogger.d("NotificationsUtils", "SDK_INT >= 19, OP_POST_NOTIFICATION " + intValue);
                if (((Integer) method.invoke((AppOpsManager) context.getSystemService("appops"), new Object[]{Integer.valueOf(intValue), Integer.valueOf(i12), packageName})).intValue() == 0) {
                    return 2;
                }
                return 1;
            }
        } catch (Throwable th2) {
            TLogger.e("NotificationsUtils", th2.getMessage());
            return 4;
        }
    }

    public static List<a> c(Context context) {
        List<NotificationChannel> notificationChannels;
        if (context == null) {
            return null;
        }
        try {
            if (CloudManager.getInstance(context).disableCollData()) {
                TLogger.d("NotificationsUtils", "disable notification status");
                return null;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                boolean z11 = false;
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
                if (notificationManager != null) {
                    z11 = notificationManager.areNotificationsEnabled();
                }
                if (z11 && (notificationChannels = ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).getNotificationChannels()) != null && notificationChannels.size() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (NotificationChannel a11 : notificationChannels) {
                        a a12 = a(context, a11);
                        if (a12 != null) {
                            arrayList.add(a12);
                        }
                    }
                    return arrayList;
                }
            }
            return null;
        } catch (Throwable unused) {
        }
    }

    public static boolean a(Context context) {
        NotificationManager notificationManager;
        try {
            if (CloudManager.getInstance(context).disableCollData()) {
                TLogger.d("NotificationsUtils", "disable notification");
                return true;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 < 26 || (notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)) == null) {
                if (i11 >= 19) {
                    ApplicationInfo applicationInfo = context.getApplicationInfo();
                    String packageName = context.getApplicationContext().getPackageName();
                    int i12 = applicationInfo.uid;
                    Class<?> cls = Class.forName(AppOpsManager.class.getName());
                    Class cls2 = Integer.TYPE;
                    if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke((AppOpsManager) context.getSystemService("appops"), new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i12), packageName})).intValue() == 0) {
                        return true;
                    }
                    return false;
                }
                return true;
            }
            boolean areNotificationsEnabled = notificationManager.areNotificationsEnabled();
            TLogger.i("NotificationsUtils", "OS >= 26, areNotificationsEnabled " + areNotificationsEnabled);
            return areNotificationsEnabled;
        } catch (Throwable th2) {
            TLogger.e("NotificationsUtils", th2.getMessage());
        }
    }

    public static class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public int f69848a;

        /* renamed from: b  reason: collision with root package name */
        public String f69849b;

        /* renamed from: c  reason: collision with root package name */
        public String f69850c;

        public a(int i11, String str, String str2) {
            this.f69848a = i11;
            this.f69849b = str;
            this.f69850c = str2;
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("state", this.f69848a);
            jSONObject.put("id", this.f69849b);
            jSONObject.put("name", this.f69850c);
            return jSONObject;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            if (aVar == null) {
                return 1;
            }
            return (this.f69849b + this.f69850c + "").compareTo(aVar.f69849b + aVar.f69850c + "");
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(Context context, int i11, List<a> list) {
        try {
            TLogger.d("NotificationsUtils", "lastNtfStr:" + f69846b);
            if (f69846b != null) {
                if (!TextUtils.isEmpty(f69846b.trim())) {
                    String a11 = a(i11, list);
                    TLogger.d("NotificationsUtils", "currentNtfStr:" + a11);
                    return !TextUtils.equals(f69846b, a11);
                }
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    private static a a(Context context, NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        String group = notificationChannel.getGroup();
        CharSequence name = notificationChannel.getName();
        String id2 = notificationChannel.getId();
        return new a(a(context, group, id2), id2, name.toString());
    }

    private static int a(Context context, String str, String str2) {
        NotificationChannel notificationChannel;
        NotificationChannelGroup notificationChannelGroup;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if ((i11 < 28 || str == null || (notificationChannelGroup = notificationManager.getNotificationChannelGroup(str)) == null || !notificationChannelGroup.isBlocked()) && (notificationChannel = notificationManager.getNotificationChannel(str2)) != null) {
                return notificationChannel.getImportance();
            }
        }
        return 0;
    }

    public static String a(int i11, List<a> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            return Md5.md5(a(list) + i11 + "");
        }
        return i11 + "";
    }

    private static String a(List<a> list) {
        if (!(list == null || list.size() == 0)) {
            try {
                Collections.sort(list);
                StringBuffer stringBuffer = new StringBuffer();
                for (a next : list) {
                    if (next != null) {
                        stringBuffer.append(next.f69849b);
                        stringBuffer.append(next.f69850c);
                        stringBuffer.append(next.f69848a);
                    }
                }
                return stringBuffer.toString();
            } catch (Throwable unused) {
            }
        }
        return "";
    }

    public static String a(Context context, Uri uri) {
        List<NotificationChannel> notificationChannels;
        if (!(context == null || uri == null)) {
            try {
                if (!TextUtils.isEmpty(uri.toString())) {
                    if (Build.VERSION.SDK_INT >= 26 && (notificationChannels = ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).getNotificationChannels()) != null && notificationChannels.size() > 0) {
                        for (NotificationChannel next : notificationChannels) {
                            Uri sound = next.getSound();
                            if (sound != null && uri.toString().equals(sound.toString())) {
                                return next.getId();
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return null;
    }

    public static void a(final Context context, boolean z11) {
        if (context == null || !j.a(context, context.getPackageName(), false)) {
            Logger.w("NotificationsUtils", "app is background, context:" + context);
            return;
        }
        AnonymousClass1 r22 = new TTask() {
            public void TRun() {
                TLogger.d("NotificationsUtils", "onCheckNotification registerStatus: " + c.f69845a);
                if (c.f69845a == 1) {
                    List<a> c11 = c.c(context);
                    int b11 = c.b(context);
                    boolean a11 = c.b(context, b11, c11);
                    boolean isRegistered = XGApiConfig.isRegistered(context);
                    TLogger.d("NotificationsUtils", "onCheckNotification isRegistered: " + isRegistered + " ,ntfState:" + b11 + " , notificationStateChanged:" + a11);
                    if (!a11 || !XGApiConfig.isRegistered(context)) {
                        TLogger.d("NotificationsUtils", "notification not changed, or unRegistered");
                        return;
                    }
                    TLogger.i("NotificationsUtils", "notificationStateChanged was changed, registerPush again");
                    XGPushManager.registerPush(context);
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            CommonWorkingThread.getInstance().execute(r22);
        } else {
            r22.run();
        }
    }

    public static void a(String str) {
        TLogger.d("NotificationsUtils", "updateLastUploadMd5Str:" + f69846b + ",str:" + str);
        if (str == null) {
            TLogger.d("NotificationsUtils", "params was null, ingore!");
        }
        f69846b = str;
    }
}
