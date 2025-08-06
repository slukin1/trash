package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.core.util.b;

public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    public final MediaSessionManager.RemoteUserInfo f10190a;

    public g(String str, int i11, int i12) {
        this.f10190a = new MediaSessionManager.RemoteUserInfo(str, i11, i12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        return this.f10190a.equals(((g) obj).f10190a);
    }

    public int hashCode() {
        return b.b(this.f10190a);
    }

    public g(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f10190a = remoteUserInfo;
    }
}
