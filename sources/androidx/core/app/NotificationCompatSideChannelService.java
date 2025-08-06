package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

public abstract class NotificationCompatSideChannelService extends Service {

    public class a extends INotificationSideChannel.Stub {
        public a() {
        }

        public void cancel(String str, int i11, String str2) throws RemoteException {
            NotificationCompatSideChannelService.this.c(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.a(str, i11, str2);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void cancelAll(String str) {
            NotificationCompatSideChannelService.this.c(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.b(str);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }

        public void notify(String str, int i11, String str2, Notification notification) throws RemoteException {
            NotificationCompatSideChannelService.this.c(Binder.getCallingUid(), str);
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.d(str, i11, str2, notification);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public abstract void a(String str, int i11, String str2);

    public abstract void b(String str);

    public void c(int i11, String str) {
        String[] packagesForUid = getPackageManager().getPackagesForUid(i11);
        int length = packagesForUid.length;
        int i12 = 0;
        while (i12 < length) {
            if (!packagesForUid[i12].equals(str)) {
                i12++;
            } else {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i11 + " is not authorized for package " + str);
    }

    public abstract void d(String str, int i11, String str2, Notification notification);

    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL") || Build.VERSION.SDK_INT > 19) {
            return null;
        }
        return new a();
    }
}
