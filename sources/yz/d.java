package yz;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class d {
    public static Rect a(Drawable drawable) {
        return new Rect(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }
}
