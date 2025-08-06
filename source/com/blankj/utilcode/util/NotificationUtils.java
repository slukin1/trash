package com.blankj.utilcode.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.huawei.hms.push.constant.RemoteMessageConst;

public class NotificationUtils {

    public static class a {

        /* renamed from: b  reason: collision with root package name */
        public static final a f63358b = new a(Utils.a().getPackageName(), Utils.a().getPackageName(), 3);

        /* renamed from: a  reason: collision with root package name */
        public NotificationChannel f63359a;

        public a(String str, CharSequence charSequence, int i11) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f63359a = new NotificationChannel(str, charSequence, i11);
            }
        }

        public NotificationChannel b() {
            return this.f63359a;
        }
    }

    public static Notification a(a aVar, Utils.a<NotificationCompat.e> aVar2) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            ((NotificationManager) Utils.a().getSystemService(RemoteMessageConst.NOTIFICATION)).createNotificationChannel(aVar.b());
        }
        NotificationCompat.e eVar = new NotificationCompat.e(Utils.a());
        if (i11 >= 26) {
            eVar.v(aVar.f63359a.getId());
        }
        if (aVar2 != null) {
            aVar2.accept(eVar);
        }
        return eVar.g();
    }
}
