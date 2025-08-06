package y3;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.a;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.resource.bitmap.c;
import java.security.MessageDigest;
import n3.g;

public class e implements g<c> {

    /* renamed from: b  reason: collision with root package name */
    public final g<Bitmap> f66687b;

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object, n3.g<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public e(n3.g<android.graphics.Bitmap> r1) {
        /*
            r0 = this;
            r0.<init>()
            java.lang.Object r1 = f4.h.d(r1)
            n3.g r1 = (n3.g) r1
            r0.f66687b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.e.<init>(n3.g):void");
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f66687b.equals(((e) obj).f66687b);
        }
        return false;
    }

    public int hashCode() {
        return this.f66687b.hashCode();
    }

    public r<c> transform(Context context, r<c> rVar, int i11, int i12) {
        c cVar = rVar.get();
        c cVar2 = new c(cVar.e(), a.d(context).g());
        r<Bitmap> transform = this.f66687b.transform(context, cVar2, i11, i12);
        if (!cVar2.equals(transform)) {
            cVar2.recycle();
        }
        cVar.m(this.f66687b, transform.get());
        return rVar;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        this.f66687b.updateDiskCacheKey(messageDigest);
    }
}
