package androidx.media;

import android.media.session.MediaSessionManager;
import android.os.Build;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public f f10189a;

    public e(String str, int i11, int i12) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f10189a = new g(str, i11, i12);
        } else {
            this.f10189a = new h(str, i11, i12);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        return this.f10189a.equals(((e) obj).f10189a);
    }

    public int hashCode() {
        return this.f10189a.hashCode();
    }

    public e(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        this.f10189a = new g(remoteUserInfo);
    }
}
