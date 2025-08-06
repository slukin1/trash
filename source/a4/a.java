package a4;

import f4.i;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

public class a implements d {

    /* renamed from: a  reason: collision with root package name */
    public final Set<e> f63117a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public boolean f63118b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63119c;

    public void a(e eVar) {
        this.f63117a.remove(eVar);
    }

    public void b(e eVar) {
        this.f63117a.add(eVar);
        if (this.f63119c) {
            eVar.onDestroy();
        } else if (this.f63118b) {
            eVar.onStart();
        } else {
            eVar.onStop();
        }
    }

    public void c() {
        this.f63119c = true;
        for (T onDestroy : i.j(this.f63117a)) {
            onDestroy.onDestroy();
        }
    }

    public void d() {
        this.f63118b = true;
        for (T onStart : i.j(this.f63117a)) {
            onStart.onStart();
        }
    }

    public void e() {
        this.f63118b = false;
        for (T onStop : i.j(this.f63117a)) {
            onStop.onStop();
        }
    }
}
