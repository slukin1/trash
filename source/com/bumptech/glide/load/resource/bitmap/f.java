package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.load.engine.r;
import java.util.concurrent.locks.Lock;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final e f64092a = new a();

    public class a extends BitmapPoolAdapter {
        public void c(Bitmap bitmap) {
        }
    }

    public static r<Bitmap> a(e eVar, Drawable drawable, int i11, int i12) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z11 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(eVar, current, i11, i12);
            z11 = true;
        } else {
            bitmap = null;
        }
        if (!z11) {
            eVar = f64092a;
        }
        return c.c(bitmap, eVar);
    }

    public static Bitmap b(e eVar, Drawable drawable, int i11, int i12) {
        if (i11 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i12 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i11 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i12 = drawable.getIntrinsicHeight();
            }
            Lock i13 = o.i();
            i13.lock();
            Bitmap d11 = eVar.d(i11, i12, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(d11);
                drawable.setBounds(0, 0, i11, i12);
                drawable.draw(canvas);
                canvas.setBitmap((Bitmap) null);
                return d11;
            } finally {
                i13.unlock();
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
    }
}
