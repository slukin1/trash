package n3;

import android.content.Context;
import com.bumptech.glide.load.engine.r;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;

public class c<T> implements g<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Collection<? extends g<T>> f66507b;

    @SafeVarargs
    public c(g<T>... gVarArr) {
        if (gVarArr.length != 0) {
            this.f66507b = Arrays.asList(gVarArr);
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f66507b.equals(((c) obj).f66507b);
        }
        return false;
    }

    public int hashCode() {
        return this.f66507b.hashCode();
    }

    public r<T> transform(Context context, r<T> rVar, int i11, int i12) {
        r<T> rVar2 = rVar;
        for (g transform : this.f66507b) {
            r<T> transform2 = transform.transform(context, rVar2, i11, i12);
            if (rVar2 != null && !rVar2.equals(rVar) && !rVar2.equals(transform2)) {
                rVar2.recycle();
            }
            rVar2 = transform2;
        }
        return rVar2;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        for (g updateDiskCacheKey : this.f66507b) {
            updateDiskCacheKey.updateDiskCacheKey(messageDigest);
        }
    }

    public c(Collection<? extends g<T>> collection) {
        if (!collection.isEmpty()) {
            this.f66507b = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
