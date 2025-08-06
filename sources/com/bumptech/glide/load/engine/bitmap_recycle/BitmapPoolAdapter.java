package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

public class BitmapPoolAdapter implements e {
    public void a(int i11) {
    }

    public void b() {
    }

    public void c(Bitmap bitmap) {
        bitmap.recycle();
    }

    public Bitmap d(int i11, int i12, Bitmap.Config config) {
        return Bitmap.createBitmap(i11, i12, config);
    }

    public Bitmap e(int i11, int i12, Bitmap.Config config) {
        return d(i11, i12, config);
    }
}
