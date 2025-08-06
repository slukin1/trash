package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.zai;
import com.google.android.gms.internal.base.zaj;
import java.lang.ref.WeakReference;

public final class zae extends zag {
    private final WeakReference<ImageView> zac;

    public zae(ImageView imageView, int i11) {
        super(Uri.EMPTY, i11);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference<>(imageView);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zae)) {
            return false;
        }
        ImageView imageView = (ImageView) this.zac.get();
        ImageView imageView2 = (ImageView) ((zae) obj).zac.get();
        return (imageView2 == null || imageView == null || !Objects.equal(imageView2, imageView)) ? false : true;
    }

    public final int hashCode() {
        return 0;
    }

    public final void zaa(Drawable drawable, boolean z11, boolean z12, boolean z13) {
        ImageView imageView = (ImageView) this.zac.get();
        if (imageView == null) {
            return;
        }
        if (z12 || z13 || !(imageView instanceof zaj)) {
            boolean z14 = false;
            if (!z12 && !z11) {
                z14 = true;
            }
            if (z14) {
                Drawable drawable2 = imageView.getDrawable();
                if (drawable2 == null) {
                    drawable2 = null;
                } else if (drawable2 instanceof zai) {
                    drawable2 = ((zai) drawable2).zaa();
                }
                drawable = new zai(drawable2, drawable);
            }
            imageView.setImageDrawable(drawable);
            if (imageView instanceof zaj) {
                zaj zaj = (zaj) imageView;
                throw null;
            } else if (drawable != null && z14) {
                ((zai) drawable).zab(250);
            }
        } else {
            zaj zaj2 = (zaj) imageView;
            throw null;
        }
    }

    public zae(ImageView imageView, Uri uri) {
        super(uri, 0);
        Asserts.checkNotNull(imageView);
        this.zac = new WeakReference<>(imageView);
    }
}
