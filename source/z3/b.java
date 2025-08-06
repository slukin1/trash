package z3;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.r;
import y3.c;

public final class b implements c<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public final e f66720a;

    /* renamed from: b  reason: collision with root package name */
    public final c<Bitmap, byte[]> f66721b;

    /* renamed from: c  reason: collision with root package name */
    public final c<c, byte[]> f66722c;

    public b(e eVar, c<Bitmap, byte[]> cVar, c<c, byte[]> cVar2) {
        this.f66720a = eVar;
        this.f66721b = cVar;
        this.f66722c = cVar2;
    }

    public static r<c> b(r<Drawable> rVar) {
        return rVar;
    }

    public r<byte[]> a(r<Drawable> rVar, Options options) {
        Drawable drawable = rVar.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f66721b.a(com.bumptech.glide.load.resource.bitmap.c.c(((BitmapDrawable) drawable).getBitmap(), this.f66720a), options);
        }
        if (drawable instanceof c) {
            return this.f66722c.a(b(rVar), options);
        }
        return null;
    }
}
