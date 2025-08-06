package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.tencent.thumbplayer.tcmedia.core.common.TPMediaCodecProfileLevel;
import com.xiaomi.push.ax;
import com.xiaomi.push.gl;
import com.xiaomi.push.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@TargetApi(24)
class ad {

    /* renamed from: a  reason: collision with root package name */
    private static ad f52435a = new ad();

    /* renamed from: a  reason: collision with other field name */
    private SpannableString f3316a;

    public class a {

        /* renamed from: a  reason: collision with other field name */
        public List<b> f3317a;

        /* renamed from: b  reason: collision with root package name */
        public List<b> f52437b;

        private a() {
            this.f3317a = new ArrayList();
            this.f52437b = new ArrayList();
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public int f52438a;

        /* renamed from: a  reason: collision with other field name */
        public Notification f3318a;

        public b(int i11, Notification notification) {
            this.f52438a = i11;
            this.f3318a = notification;
        }

        public String toString() {
            return "id:" + this.f52438a;
        }
    }

    private ad() {
    }

    public static ad a() {
        return f52435a;
    }

    private boolean b(Context context) {
        return ah.a(context).a(gl.NotificationAutoGroupSwitch.a(), true);
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m2969a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    private boolean a(Context context) {
        if (b(context) && af.a(context)) {
            return ah.a(context).a(gl.LatestNotificationNotIntoGroupSwitch.a(), false);
        }
        return false;
    }

    private String b(Notification notification) {
        if (notification == null) {
            return null;
        }
        return b(notification) ? a(notification) : notification.getGroup();
    }

    /* renamed from: b  reason: collision with other method in class */
    private boolean m2971b(Notification notification) {
        Bundle bundle;
        if (notification == null || notification.getGroup() == null || (bundle = notification.extras) == null) {
            return false;
        }
        long j11 = bundle.getLong("push_src_group_time");
        String a11 = a(notification);
        return notification.getGroup().equals(String.format("pushmask_%s_%s", new Object[]{Long.valueOf(j11), a11}));
    }

    private String a(Notification notification) {
        Bundle bundle;
        if (notification == null || (bundle = notification.extras) == null) {
            return null;
        }
        return bundle.getString("push_src_group_name");
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m2970a(Notification notification) {
        if (notification == null) {
            return false;
        }
        Object a11 = ax.a((Object) notification, "isGroupSummary", (Object[]) null);
        if (a11 instanceof Boolean) {
            return ((Boolean) a11).booleanValue();
        }
        return false;
    }

    private void b(Context context, int i11, Notification notification) {
        String c11 = ag.c(notification);
        if (TextUtils.isEmpty(c11)) {
            com.xiaomi.channel.commonutils.logger.b.a("group restore not extract pkg from notification:" + i11);
            return;
        }
        af a11 = af.a(context, c11);
        List<StatusBarNotification> a12 = a(a11);
        if (a12 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("group restore not get notifications");
            return;
        }
        for (StatusBarNotification next : a12) {
            Notification notification2 = next.getNotification();
            if (!(notification2 == null || !b(notification2) || next.getId() == i11)) {
                Notification.Builder recoverBuilder = Notification.Builder.recoverBuilder(context, next.getNotification());
                recoverBuilder.setGroup(a(notification2));
                ag.a(recoverBuilder, a(notification2));
                a11.a(next.getId(), recoverBuilder.build());
                com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + next.getId());
            }
        }
    }

    public String a(Context context, Notification.Builder builder, String str) {
        if (!a() || !a(context)) {
            return str;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Bundle extras = builder.getExtras();
        extras.putString("push_src_group_name", str);
        extras.putLong("push_src_group_time", currentTimeMillis);
        return String.format("pushmask_%s_%s", new Object[]{Long.valueOf(currentTimeMillis), str});
    }

    public void a(Context context, int i11, Notification notification) {
        if (a()) {
            if (a(context)) {
                try {
                    b(context, i11, notification);
                } catch (Exception e11) {
                    com.xiaomi.channel.commonutils.logger.b.a("group notify handle restore error " + e11);
                }
            }
            if (b(context)) {
                try {
                    a(context, i11, notification, true);
                } catch (Exception e12) {
                    com.xiaomi.channel.commonutils.logger.b.a("group notify handle auto error " + e12);
                }
            }
        }
    }

    private void a(Context context, int i11, Notification notification, boolean z11) {
        Notification notification2;
        String c11 = ag.c(notification);
        if (TextUtils.isEmpty(c11)) {
            com.xiaomi.channel.commonutils.logger.b.a("group auto not extract pkg from notification:" + i11);
            return;
        }
        List<StatusBarNotification> a11 = a(af.a(context, c11));
        if (a11 == null) {
            com.xiaomi.channel.commonutils.logger.b.a("group auto not get notifications");
            return;
        }
        String b11 = b(notification);
        HashMap hashMap = new HashMap();
        for (StatusBarNotification next : a11) {
            if (!(next.getNotification() == null || next.getId() == i11)) {
                a((Map<String, a>) hashMap, next);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            if (!TextUtils.isEmpty(str)) {
                a aVar = (a) entry.getValue();
                if (z11 && str.equals(b11) && !b(notification)) {
                    b bVar = new b(i11, notification);
                    if (a(notification)) {
                        aVar.f52437b.add(bVar);
                    } else {
                        aVar.f3317a.add(bVar);
                    }
                }
                int size = aVar.f3317a.size();
                if (aVar.f52437b.size() <= 0) {
                    if (z11 && size >= 2) {
                        a(context, c11, str, aVar.f3317a.get(0).f3318a);
                    }
                } else if (size <= 0) {
                    a(context, c11, str);
                } else if (ah.a(context).a(gl.NotificationGroupUpdateTimeSwitch.a(), false) && (notification2 = aVar.f52437b.get(0).f3318a) != null) {
                    notification2.when = System.currentTimeMillis();
                    a(context, c11, str, notification2);
                }
            }
        }
    }

    private void a(Map<String, a> map, StatusBarNotification statusBarNotification) {
        String b11 = b(statusBarNotification.getNotification());
        a aVar = map.get(b11);
        if (aVar == null) {
            aVar = new a();
            map.put(b11, aVar);
        }
        b bVar = new b(statusBarNotification.getId(), statusBarNotification.getNotification());
        if (a(statusBarNotification.getNotification())) {
            aVar.f52437b.add(bVar);
        } else {
            aVar.f3317a.add(bVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private SpannableString m2968a(Context context, String str) {
        Resources resources;
        DisplayMetrics displayMetrics;
        int max;
        if (this.f3316a == null) {
            int i11 = 200;
            if (!(context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null || (max = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels)) <= 0)) {
                i11 = max / 16;
            }
            if (TextUtils.isEmpty(str)) {
                str = "新消息";
            }
            StringBuilder sb2 = new StringBuilder(str.length() + i11 + 12);
            sb2.append(str);
            for (int i12 = 0; i12 < i11; i12++) {
                sb2.append(' ');
            }
            sb2.append("GroupSummary");
            SpannableString spannableString = new SpannableString(sb2.toString());
            spannableString.setSpan(new ForegroundColorSpan(0), str.length(), sb2.length(), 33);
            this.f3316a = spannableString;
        }
        return this.f3316a;
    }

    private void a(Context context, String str, String str2, Notification notification) {
        Notification.Builder builder;
        try {
            if (TextUtils.isEmpty(str2)) {
                com.xiaomi.channel.commonutils.logger.b.a("group show summary group is null");
                return;
            }
            int a11 = ag.a(context, str);
            if (a11 == 0) {
                com.xiaomi.channel.commonutils.logger.b.a("group show summary not get icon from " + str);
                return;
            }
            af a12 = af.a(context, str);
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 26) {
                String c11 = a12.c(notification.getChannelId(), "groupSummary");
                NotificationChannel a13 = a12.a(c11);
                if ("groupSummary".equals(c11) && a13 == null) {
                    a12.a(new NotificationChannel(c11, "group_summary", 3));
                }
                builder = new Notification.Builder(context, c11);
            } else {
                builder = new Notification.Builder(context).setPriority(0).setDefaults(-1);
            }
            ag.a(builder, true);
            Notification build = builder.setContentTitle(a(context, "新消息")).setContentText("你有一条新消息").setSmallIcon(Icon.createWithResource(str, a11)).setAutoCancel(true).setGroup(str2).setGroupSummary(true).build();
            if (i11 >= 31) {
                build.contentIntent = a(context, str);
            }
            if (!j.c() && "com.xiaomi.xmsf".equals(context.getPackageName())) {
                ag.a(build, str);
            }
            int a14 = a(str, str2);
            a12.a(a14, build);
            com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + a14);
        } catch (Exception e11) {
            com.xiaomi.channel.commonutils.logger.b.a("group show summary error " + e11);
        }
    }

    private PendingIntent a(Context context, String str) {
        PendingIntent pendingIntent;
        if (context != null || !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    com.xiaomi.channel.commonutils.logger.b.a("pm must not be null in getting launch intent");
                    return null;
                }
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str);
                if (launchIntentForPackage == null) {
                    com.xiaomi.channel.commonutils.logger.b.a("targetIntent must not be null in getting launch intent");
                    return null;
                }
                launchIntentForPackage.addFlags(268435456);
                if (Build.VERSION.SDK_INT >= 31) {
                    pendingIntent = PendingIntent.getActivity(context, 0, launchIntentForPackage, TPMediaCodecProfileLevel.HEVCHighTierLevel62);
                } else {
                    pendingIntent = PendingIntent.getActivity(context, 0, launchIntentForPackage, 0);
                }
                return pendingIntent;
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.d("error occurred during getting launch pendingIntent. exception:" + th2);
                return null;
            }
        } else {
            com.xiaomi.channel.commonutils.logger.b.a("ctx or pkg must not be null in getting launch intent");
            return null;
        }
    }

    private void a(Context context, String str, String str2) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + str2);
        af.a(context, str).a(a(str, str2));
    }

    private int a(String str, String str2) {
        return ("GroupSummary" + str + str2).hashCode();
    }

    private List<StatusBarNotification> a(af afVar) {
        List<StatusBarNotification> b11 = afVar != null ? afVar.b() : null;
        if (b11 == null || b11.size() == 0) {
            return null;
        }
        return b11;
    }
}
