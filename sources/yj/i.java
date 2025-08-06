package yj;

import java.lang.ref.WeakReference;
import vj.a;

public abstract class i<T> implements a {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<T> f48119a;

    public i(T t11) {
        this.f48119a = new WeakReference<>(t11);
    }

    public abstract void a(T t11, Object obj);

    public void onCallback(Object obj) {
        WeakReference<T> weakReference = this.f48119a;
        if (weakReference != null && weakReference.get() != null) {
            a(this.f48119a.get(), obj);
        }
    }
}
