package io.noties.markwon.image;

import android.graphics.drawable.Drawable;
import yz.a;
import yz.b;

public abstract class AsyncDrawableLoader {
    public static AsyncDrawableLoader a() {
        return new b();
    }

    public abstract Drawable b(a aVar);
}
