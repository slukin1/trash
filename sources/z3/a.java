package z3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.r;
import com.bumptech.glide.load.resource.bitmap.j;
import f4.h;

public class a implements c<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f66719a;

    public a(Resources resources) {
        this.f66719a = (Resources) h.d(resources);
    }

    public r<BitmapDrawable> a(r<Bitmap> rVar, Options options) {
        return j.c(this.f66719a, rVar);
    }
}
