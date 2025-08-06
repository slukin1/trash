package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;

public abstract class zag {
    public final zad zaa;
    public int zab = 0;

    public zag(Uri uri, int i11) {
        this.zaa = new zad(uri);
        this.zab = i11;
    }

    public abstract void zaa(Drawable drawable, boolean z11, boolean z12, boolean z13);

    public final void zab(Context context, zak zak, boolean z11) {
        int i11 = this.zab;
        zaa(i11 != 0 ? context.getResources().getDrawable(i11) : null, z11, false, false);
    }

    public final void zac(Context context, Bitmap bitmap, boolean z11) {
        Asserts.checkNotNull(bitmap);
        zaa(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
