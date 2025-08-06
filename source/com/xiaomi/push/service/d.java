package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import com.xiaomi.push.j;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static List<a> f52550a = new CopyOnWriteArrayList();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f52551a;

        /* renamed from: a  reason: collision with other field name */
        public final long f3384a;

        /* renamed from: a  reason: collision with other field name */
        public final String f3385a;

        /* renamed from: a  reason: collision with other field name */
        public final Notification.Action[] f3386a;

        public a(String str, long j11, int i11, Notification.Action[] actionArr) {
            this.f3385a = str;
            this.f3384a = j11;
            this.f52551a = i11;
            this.f3386a = actionArr;
        }
    }

    public static void a(Context context, StatusBarNotification statusBarNotification, int i11) {
        if (j.a(context) && i11 > 0 && statusBarNotification != null && Build.VERSION.SDK_INT >= 20) {
            a(new a(statusBarNotification.getKey(), SystemClock.elapsedRealtime(), i11, ag.a(statusBarNotification.getNotification())));
        }
    }

    private static void a(a aVar) {
        f52550a.add(aVar);
        a();
    }

    private static void a() {
        for (int size = f52550a.size() - 1; size >= 0; size--) {
            a aVar = f52550a.get(size);
            if (SystemClock.elapsedRealtime() - aVar.f3384a > 5000) {
                f52550a.remove(aVar);
            }
        }
        if (f52550a.size() > 10) {
            f52550a.remove(0);
        }
    }
}
