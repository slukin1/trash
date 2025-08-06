package com.huobi.appupgrade.ui;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.widget.RemoteViews;
import bh.j;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.R$drawable;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import pro.huobi.R;

public class AppUpgradeNotificationView {

    /* renamed from: a  reason: collision with root package name */
    public final NotificationManager f42219a;

    /* renamed from: b  reason: collision with root package name */
    public int f42220b;

    /* renamed from: c  reason: collision with root package name */
    public Context f42221c;

    /* renamed from: d  reason: collision with root package name */
    public RemoteViews f42222d;

    /* renamed from: e  reason: collision with root package name */
    public Notification.Builder f42223e;

    public AppUpgradeNotificationView() {
        Application c11 = j.c();
        this.f42221c = c11;
        this.f42219a = (NotificationManager) c11.getSystemService(RemoteMessageConst.NOTIFICATION);
    }

    public void a() {
        if (this.f42223e != null) {
            this.f42219a.cancel(this.f42220b);
            this.f42223e = null;
        }
    }

    public void b() {
        this.f42220b = (int) SystemClock.uptimeMillis();
        this.f42222d = new RemoteViews(this.f42221c.getPackageName(), R.layout.notification_upgrade_app);
        this.f42223e = new Notification.Builder(this.f42221c).setSmallIcon(R.drawable.icon_download_default).setContent(this.f42222d).setWhen(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) {
            this.f42219a.createNotificationChannel(new NotificationChannel(this.f42221c.getPackageName(), this.f42221c.getPackageName(), 2));
            this.f42223e.setChannelId(this.f42221c.getPackageName());
        }
        this.f42222d.setImageViewResource(R.id.img_icon, R$drawable.icon);
        this.f42222d.setTextViewText(R.id.tv_content, this.f42221c.getResources().getString(R.string.upgrade_notification));
        this.f42222d.setTextViewText(R.id.tv_state, "0%");
        this.f42222d.setProgressBar(R.id.pb_download, 100, 0, false);
        this.f42222d.setViewVisibility(R.id.tv_sub_content, 8);
    }

    public void c() {
        a();
    }

    public void d(int i11) {
        RemoteViews remoteViews;
        if (this.f42223e != null && (remoteViews = this.f42222d) != null) {
            remoteViews.setProgressBar(R.id.pb_download, 100, i11, false);
            RemoteViews remoteViews2 = this.f42222d;
            remoteViews2.setTextViewText(R.id.tv_state, i11 + "%");
            NotificationManager notificationManager = this.f42219a;
            int i12 = this.f42220b;
            Notification notification = this.f42223e.getNotification();
            notificationManager.notify(i12, notification);
            PushAutoTrackHelper.onNotify(notificationManager, i12, notification);
        }
    }
}
