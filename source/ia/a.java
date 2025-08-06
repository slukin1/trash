package ia;

import android.graphics.Bitmap;
import java.lang.reflect.InvocationTargetException;

public class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? extends T> f76196a;

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap.Config f76197b;

    public a(Class<? extends T> cls) {
        this(cls, (Bitmap.Config) null);
    }

    public T make() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (this.f76197b == null) {
            return this.f76196a.newInstance();
        }
        return this.f76196a.getConstructor(new Class[]{Bitmap.Config.class}).newInstance(new Object[]{this.f76197b});
    }

    public a(Class<? extends T> cls, Bitmap.Config config) {
        this.f76196a = cls;
        this.f76197b = config;
    }
}
