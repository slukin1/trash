package androidx.camera.video;

import android.net.Uri;
import java.util.Objects;

public final class h extends OutputResults {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f5962a;

    public h(Uri uri) {
        Objects.requireNonNull(uri, "Null outputUri");
        this.f5962a = uri;
    }

    public Uri a() {
        return this.f5962a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OutputResults) {
            return this.f5962a.equals(((OutputResults) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.f5962a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "OutputResults{outputUri=" + this.f5962a + "}";
    }
}
