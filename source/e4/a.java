package e4;

import android.content.Context;
import f4.i;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import n3.b;

public final class a implements b {

    /* renamed from: b  reason: collision with root package name */
    public final int f66219b;

    /* renamed from: c  reason: collision with root package name */
    public final b f66220c;

    public a(int i11, b bVar) {
        this.f66219b = i11;
        this.f66220c = bVar;
    }

    public static b a(Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.c(context));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f66219b != aVar.f66219b || !this.f66220c.equals(aVar.f66220c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return i.o(this.f66220c, this.f66219b);
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f66220c.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f66219b).array());
    }
}
