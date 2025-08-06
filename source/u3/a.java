package u3;

import com.bumptech.glide.load.engine.r;
import f4.h;

public class a<T> implements r<T> {

    /* renamed from: b  reason: collision with root package name */
    public final T f66654b;

    public a(T t11) {
        this.f66654b = h.d(t11);
    }

    public Class<T> a() {
        return this.f66654b.getClass();
    }

    public final T get() {
        return this.f66654b;
    }

    public final int getSize() {
        return 1;
    }

    public void recycle() {
    }
}
