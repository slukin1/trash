package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.squareup.picasso.Picasso;

public final class w extends a<v> {
    public w(Picasso picasso, v vVar, q qVar, int i11, int i12, Drawable drawable, String str, Object obj, int i13) {
        super(picasso, vVar, qVar, i11, i12, i13, drawable, str, obj, false);
    }

    public void b(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
        if (bitmap != null) {
            v vVar = (v) k();
            if (vVar != null) {
                vVar.onBitmapLoaded(bitmap, loadedFrom);
                if (bitmap.isRecycled()) {
                    throw new IllegalStateException("Target callback must not recycle bitmap!");
                }
                return;
            }
            return;
        }
        throw new AssertionError(String.format("Attempted to complete action with no result!\n%s", new Object[]{this}));
    }

    public void c(Exception exc) {
        v vVar = (v) k();
        if (vVar == null) {
            return;
        }
        if (this.f29992g != 0) {
            vVar.onBitmapFailed(exc, this.f29986a.f29955e.getResources().getDrawable(this.f29992g));
        } else {
            vVar.onBitmapFailed(exc, this.f29993h);
        }
    }
}
