package w3;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.r;

public final class c extends b<Drawable> {
    public c(Drawable drawable) {
        super(drawable);
    }

    public static r<Drawable> c(Drawable drawable) {
        if (drawable != null) {
            return new c(drawable);
        }
        return null;
    }

    public Class<Drawable> a() {
        return this.f66659b.getClass();
    }

    public int getSize() {
        return Math.max(1, this.f66659b.getIntrinsicWidth() * this.f66659b.getIntrinsicHeight() * 4);
    }

    public void recycle() {
    }
}
