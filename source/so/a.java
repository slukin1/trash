package so;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huobi.R$drawable;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;

public class a extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    public NotificationManager f84865a;

    public a(Context context) {
        super(context);
    }

    public final void a() {
        b().createNotificationChannel(new NotificationChannel("channel_1", "channel_name_1", 4));
    }

    public final NotificationManager b() {
        if (this.f84865a == null) {
            this.f84865a = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
        }
        return this.f84865a;
    }

    public final NotificationCompat.e c(String str, String str2, Intent intent) {
        NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle();
        bigPictureStyle.C("BigContentTitle");
        bigPictureStyle.D("SummaryText");
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.z(str);
        bigTextStyle.y(str2);
        NotificationCompat.e r11 = new NotificationCompat.e(getApplicationContext()).C(str).B(str2).X(R$drawable.icon).J(BitmapFactory.decodeResource(getResources(), R$drawable.icon)).c0(bigPictureStyle).r(true);
        if (intent != null) {
            Context applicationContext = getApplicationContext();
            PushAutoTrackHelper.hookIntentGetActivity(applicationContext, 0, intent, 134217728);
            PendingIntent activity = PendingIntent.getActivity(applicationContext, 0, intent, 134217728);
            PushAutoTrackHelper.hookPendingIntentGetActivity(activity, applicationContext, 0, intent, 134217728);
            r11.A(activity);
        }
        return r11;
    }

    public final Notification.Builder d(String str, String str2, Intent intent) {
        Notification.Builder autoCancel = new Notification.Builder(getApplicationContext(), "channel_1").setContentTitle(str).setContentText(str2).setSmallIcon(R$drawable.icon).setStyle(new Notification.BigTextStyle().bigText(str2).setBigContentTitle(str)).setNumber(1).setAutoCancel(true);
        if (intent != null) {
            Context applicationContext = getApplicationContext();
            PushAutoTrackHelper.hookIntentGetActivity(applicationContext, 0, intent, 134217728);
            PendingIntent activity = PendingIntent.getActivity(applicationContext, 0, intent, 134217728);
            PushAutoTrackHelper.hookPendingIntentGetActivity(activity, applicationContext, 0, intent, 134217728);
            autoCancel.setContentIntent(activity);
        }
        return autoCancel;
    }

    public void e(int i11, String str, String str2, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            a();
            Notification build = d(str, str2, intent).build();
            NotificationManager b11 = b();
            b11.notify(i11, build);
            PushAutoTrackHelper.onNotify(b11, i11, build);
            return;
        }
        Notification g11 = c(str, str2, intent).g();
        NotificationManager b12 = b();
        b12.notify(i11, g11);
        PushAutoTrackHelper.onNotify(b12, i11, g11);
    }
}
