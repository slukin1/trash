package w3;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.n;
import com.bumptech.glide.load.engine.r;
import f4.h;
import y3.c;

public abstract class b<T extends Drawable> implements r<T>, n {

    /* renamed from: b  reason: collision with root package name */
    public final T f66659b;

    public b(T t11) {
        this.f66659b = (Drawable) h.d(t11);
    }

    /* renamed from: b */
    public final T get() {
        Drawable.ConstantState constantState = this.f66659b.getConstantState();
        if (constantState == null) {
            return this.f66659b;
        }
        return constantState.newDrawable();
    }

    public void initialize() {
        T t11 = this.f66659b;
        if (t11 instanceof BitmapDrawable) {
            ((BitmapDrawable) t11).getBitmap().prepareToDraw();
        } else if (t11 instanceof c) {
            ((c) t11).e().prepareToDraw();
        }
    }
}
