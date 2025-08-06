package androidx.core.app;

import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f8302a = (IconCompat) versionedParcel.v(remoteActionCompat.f8302a, 1);
        remoteActionCompat.f8303b = versionedParcel.l(remoteActionCompat.f8303b, 2);
        remoteActionCompat.f8304c = versionedParcel.l(remoteActionCompat.f8304c, 3);
        remoteActionCompat.f8305d = (PendingIntent) versionedParcel.r(remoteActionCompat.f8305d, 4);
        remoteActionCompat.f8306e = versionedParcel.h(remoteActionCompat.f8306e, 5);
        remoteActionCompat.f8307f = versionedParcel.h(remoteActionCompat.f8307f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(remoteActionCompat.f8302a, 1);
        versionedParcel.D(remoteActionCompat.f8303b, 2);
        versionedParcel.D(remoteActionCompat.f8304c, 3);
        versionedParcel.H(remoteActionCompat.f8305d, 4);
        versionedParcel.z(remoteActionCompat.f8306e, 5);
        versionedParcel.z(remoteActionCompat.f8307f, 6);
    }
}
