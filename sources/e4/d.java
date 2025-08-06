package e4;

import f4.h;
import java.security.MessageDigest;
import n3.b;

public final class d implements b {

    /* renamed from: b  reason: collision with root package name */
    public final Object f66223b;

    public d(Object obj) {
        this.f66223b = h.d(obj);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f66223b.equals(((d) obj).f66223b);
        }
        return false;
    }

    public int hashCode() {
        return this.f66223b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f66223b + '}';
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(this.f66223b.toString().getBytes(b.f66506a));
    }
}
