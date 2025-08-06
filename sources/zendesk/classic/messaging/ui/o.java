package zendesk.classic.messaging.ui;

import android.view.View;
import zendesk.classic.messaging.ui.a0;

public class o<T, V extends View & a0<T>> {

    /* renamed from: a  reason: collision with root package name */
    public final String f62817a;

    /* renamed from: b  reason: collision with root package name */
    public final T f62818b;

    /* renamed from: c  reason: collision with root package name */
    public final int f62819c;

    /* renamed from: d  reason: collision with root package name */
    public final Class<V> f62820d;

    public o(String str, T t11, int i11, Class<V> cls) {
        this.f62817a = str;
        this.f62818b = t11;
        this.f62819c = i11;
        this.f62820d = cls;
    }

    public boolean a(o oVar) {
        return c().equals(oVar.c()) && oVar.f62818b.equals(this.f62818b);
    }

    public void b(V v11) {
        ((a0) v11).update(this.f62818b);
    }

    public String c() {
        return this.f62817a;
    }

    public int d() {
        return this.f62819c;
    }

    public Class<V> e() {
        return this.f62820d;
    }
}
