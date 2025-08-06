package y3;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.resource.bitmap.c;
import l3.a;
import n3.e;

public final class g implements e<a, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final com.bumptech.glide.load.engine.bitmap_recycle.e f66712a;

    public g(com.bumptech.glide.load.engine.bitmap_recycle.e eVar) {
        this.f66712a = eVar;
    }

    /* renamed from: c */
    public r<Bitmap> b(a aVar, int i11, int i12, Options options) {
        return c.c(aVar.e(), this.f66712a);
    }

    /* renamed from: d */
    public boolean a(a aVar, Options options) {
        return true;
    }
}
