package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class k extends a<ImageView> {

    /* renamed from: m  reason: collision with root package name */
    public Callback f30057m;

    public k(Picasso picasso, ImageView imageView, q qVar, int i11, int i12, int i13, Drawable drawable, String str, Object obj, Callback callback, boolean z11) {
        super(picasso, imageView, qVar, i11, i12, i13, drawable, str, obj, z11);
        this.f30057m = callback;
    }

    public void a() {
        super.a();
        if (this.f30057m != null) {
            this.f30057m = null;
        }
    }

    public void b(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap != null) {
            ImageView imageView = (ImageView) this.f29988c.get();
            if (imageView != null) {
                Picasso picasso = this.f29986a;
                Bitmap bitmap2 = bitmap;
                Picasso.LoadedFrom loadedFrom2 = loadedFrom;
                o.c(imageView, picasso.f29955e, bitmap2, loadedFrom2, this.f29989d, picasso.f29963m);
                Callback callback = this.f30057m;
                if (callback != null) {
                    callback.onSuccess();
                    return;
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void c(Exception exc) {
        ImageView imageView = (ImageView) this.f29988c.get();
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            }
            int i11 = this.f29992g;
            if (i11 != 0) {
                imageView.setImageResource(i11);
            } else {
                Drawable drawable2 = this.f29993h;
                if (drawable2 != null) {
                    imageView.setImageDrawable(drawable2);
                }
            }
            Callback callback = this.f30057m;
            if (callback != null) {
                callback.onError(exc);
            }
        }
    }
}
