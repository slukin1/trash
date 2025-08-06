package l;

import android.app.NotificationManager;
import android.os.Parcelable;

public class a {
    public static Parcelable[] a(NotificationManager notificationManager) {
        return notificationManager.getActiveNotifications();
    }
}
