package p0;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class m {

    /* renamed from: c  reason: collision with root package name */
    public static final Object f16324c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static String f16325d;

    /* renamed from: e  reason: collision with root package name */
    public static Set<String> f16326e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    public static final Object f16327f = new Object();

    /* renamed from: g  reason: collision with root package name */
    public static e f16328g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f16329a;

    /* renamed from: b  reason: collision with root package name */
    public final NotificationManager f16330b;

    public static class a {
        public static boolean a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        public static int b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    public static class b {
        public static void a(NotificationManager notificationManager, NotificationChannel notificationChannel) {
            notificationManager.createNotificationChannel(notificationChannel);
        }

        public static void b(NotificationManager notificationManager, NotificationChannelGroup notificationChannelGroup) {
            notificationManager.createNotificationChannelGroup(notificationChannelGroup);
        }

        public static void c(NotificationManager notificationManager, List<NotificationChannelGroup> list) {
            notificationManager.createNotificationChannelGroups(list);
        }

        public static void d(NotificationManager notificationManager, List<NotificationChannel> list) {
            notificationManager.createNotificationChannels(list);
        }

        public static void e(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannel(str);
        }

        public static void f(NotificationManager notificationManager, String str) {
            notificationManager.deleteNotificationChannelGroup(str);
        }

        public static String g(NotificationChannel notificationChannel) {
            return notificationChannel.getId();
        }

        public static String h(NotificationChannelGroup notificationChannelGroup) {
            return notificationChannelGroup.getId();
        }

        public static NotificationChannel i(NotificationManager notificationManager, String str) {
            return notificationManager.getNotificationChannel(str);
        }

        public static List<NotificationChannelGroup> j(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannelGroups();
        }

        public static List<NotificationChannel> k(NotificationManager notificationManager) {
            return notificationManager.getNotificationChannels();
        }
    }

    public static class c implements f {

        /* renamed from: a  reason: collision with root package name */
        public final String f16331a;

        /* renamed from: b  reason: collision with root package name */
        public final int f16332b;

        /* renamed from: c  reason: collision with root package name */
        public final String f16333c;

        /* renamed from: d  reason: collision with root package name */
        public final Notification f16334d;

        public c(String str, int i11, String str2, Notification notification) {
            this.f16331a = str;
            this.f16332b = i11;
            this.f16333c = str2;
            this.f16334d = notification;
        }

        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f16331a, this.f16332b, this.f16333c, this.f16334d);
        }

        public String toString() {
            return "NotifyTask[" + "packageName:" + this.f16331a + ", id:" + this.f16332b + ", tag:" + this.f16333c + "]";
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f16335a;

        /* renamed from: b  reason: collision with root package name */
        public final IBinder f16336b;

        public d(ComponentName componentName, IBinder iBinder) {
            this.f16335a = componentName;
            this.f16336b = iBinder;
        }
    }

    public static class e implements Handler.Callback, ServiceConnection {

        /* renamed from: b  reason: collision with root package name */
        public final Context f16337b;

        /* renamed from: c  reason: collision with root package name */
        public final HandlerThread f16338c;

        /* renamed from: d  reason: collision with root package name */
        public final Handler f16339d;

        /* renamed from: e  reason: collision with root package name */
        public final Map<ComponentName, a> f16340e = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        public Set<String> f16341f = new HashSet();

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ComponentName f16342a;

            /* renamed from: b  reason: collision with root package name */
            public boolean f16343b = false;

            /* renamed from: c  reason: collision with root package name */
            public INotificationSideChannel f16344c;

            /* renamed from: d  reason: collision with root package name */
            public ArrayDeque<f> f16345d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            public int f16346e = 0;

            public a(ComponentName componentName) {
                this.f16342a = componentName;
            }
        }

        public e(Context context) {
            this.f16337b = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f16338c = handlerThread;
            handlerThread.start();
            this.f16339d = new Handler(handlerThread.getLooper(), this);
        }

        public final boolean a(a aVar) {
            if (aVar.f16343b) {
                return true;
            }
            boolean bindService = this.f16337b.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f16342a), this, 33);
            aVar.f16343b = bindService;
            if (bindService) {
                aVar.f16346e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f16342a);
                this.f16337b.unbindService(this);
            }
            return aVar.f16343b;
        }

        public final void b(a aVar) {
            if (aVar.f16343b) {
                this.f16337b.unbindService(this);
                aVar.f16343b = false;
            }
            aVar.f16344c = null;
        }

        public final void c(f fVar) {
            j();
            for (a next : this.f16340e.values()) {
                next.f16345d.add(fVar);
                g(next);
            }
        }

        public final void d(ComponentName componentName) {
            a aVar = this.f16340e.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        public final void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f16340e.get(componentName);
            if (aVar != null) {
                aVar.f16344c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f16346e = 0;
                g(aVar);
            }
        }

        public final void f(ComponentName componentName) {
            a aVar = this.f16340e.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        public final void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f16342a + ", " + aVar.f16345d.size() + " queued tasks");
            }
            if (!aVar.f16345d.isEmpty()) {
                if (!a(aVar) || aVar.f16344c == null) {
                    i(aVar);
                    return;
                }
                while (true) {
                    f peek = aVar.f16345d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.a(aVar.f16344c);
                        aVar.f16345d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f16342a);
                        }
                    } catch (RemoteException e11) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f16342a, e11);
                    }
                }
                if (!aVar.f16345d.isEmpty()) {
                    i(aVar);
                }
            }
        }

        public void h(f fVar) {
            this.f16339d.obtainMessage(0, fVar).sendToTarget();
        }

        public boolean handleMessage(Message message) {
            int i11 = message.what;
            if (i11 == 0) {
                c((f) message.obj);
                return true;
            } else if (i11 == 1) {
                d dVar = (d) message.obj;
                e(dVar.f16335a, dVar.f16336b);
                return true;
            } else if (i11 == 2) {
                f((ComponentName) message.obj);
                return true;
            } else if (i11 != 3) {
                return false;
            } else {
                d((ComponentName) message.obj);
                return true;
            }
        }

        public final void i(a aVar) {
            if (!this.f16339d.hasMessages(3, aVar.f16342a)) {
                int i11 = aVar.f16346e + 1;
                aVar.f16346e = i11;
                if (i11 > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.f16345d.size() + " tasks to " + aVar.f16342a + " after " + aVar.f16346e + " retries");
                    aVar.f16345d.clear();
                    return;
                }
                int i12 = (1 << (i11 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i12 + " ms");
                }
                this.f16339d.sendMessageDelayed(this.f16339d.obtainMessage(3, aVar.f16342a), (long) i12);
            }
        }

        public final void j() {
            Set<String> e11 = m.e(this.f16337b);
            if (!e11.equals(this.f16341f)) {
                this.f16341f = e11;
                List<ResolveInfo> queryIntentServices = this.f16337b.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet = new HashSet<>();
                for (ResolveInfo next : queryIntentServices) {
                    if (e11.contains(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (next.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f16340e.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f16340e.put(componentName2, new a(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, a>> it2 = this.f16340e.entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry next2 = it2.next();
                    if (!hashSet.contains(next2.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + next2.getKey());
                        }
                        b((a) next2.getValue());
                        it2.remove();
                    }
                }
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f16339d.obtainMessage(1, new d(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f16339d.obtainMessage(2, componentName).sendToTarget();
        }
    }

    public interface f {
        void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    public m(Context context) {
        this.f16329a = context;
        this.f16330b = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    public static m d(Context context) {
        return new m(context);
    }

    public static Set<String> e(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f16324c) {
            if (string != null) {
                if (!string.equals(f16325d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String unflattenFromString : split) {
                        ComponentName unflattenFromString2 = ComponentName.unflattenFromString(unflattenFromString);
                        if (unflattenFromString2 != null) {
                            hashSet.add(unflattenFromString2.getPackageName());
                        }
                    }
                    f16326e = hashSet;
                    f16325d = string;
                }
            }
            set = f16326e;
        }
        return set;
    }

    public static boolean j(Notification notification) {
        Bundle k11 = NotificationCompat.k(notification);
        return k11 != null && k11.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            return a.a(this.f16330b);
        }
        if (i11 < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f16329a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f16329a.getApplicationInfo();
        String packageName = this.f16329a.getApplicationContext().getPackageName();
        int i12 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", new Class[]{cls2, cls2, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i12), packageName})).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            b.a(this.f16330b, notificationChannel);
        }
    }

    public void c(l lVar) {
        b(lVar.a());
    }

    public NotificationChannel f(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return b.i(this.f16330b, str);
        }
        return null;
    }

    public void g(int i11, Notification notification) {
        h((String) null, i11, notification);
    }

    public void h(String str, int i11, Notification notification) {
        if (j(notification)) {
            i(new c(this.f16329a.getPackageName(), i11, str, notification));
            this.f16330b.cancel(str, i11);
            return;
        }
        NotificationManager notificationManager = this.f16330b;
        notificationManager.notify(str, i11, notification);
        PushAutoTrackHelper.onNotify(notificationManager, str, i11, notification);
    }

    public final void i(f fVar) {
        synchronized (f16327f) {
            if (f16328g == null) {
                f16328g = new e(this.f16329a.getApplicationContext());
            }
            f16328g.h(fVar);
        }
    }
}
