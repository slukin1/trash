package com.bumptech.glide.manager;

import a4.e;
import c4.g;
import f4.i;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class TargetTracker implements e {

    /* renamed from: b  reason: collision with root package name */
    public final Set<g<?>> f64160b = Collections.newSetFromMap(new WeakHashMap());

    public void a() {
        this.f64160b.clear();
    }

    public List<g<?>> b() {
        return i.j(this.f64160b);
    }

    public void c(g<?> gVar) {
        this.f64160b.add(gVar);
    }

    public void d(g<?> gVar) {
        this.f64160b.remove(gVar);
    }

    public void onDestroy() {
        for (T onDestroy : i.j(this.f64160b)) {
            onDestroy.onDestroy();
        }
    }

    public void onStart() {
        for (T onStart : i.j(this.f64160b)) {
            onStart.onStart();
        }
    }

    public void onStop() {
        for (T onStop : i.j(this.f64160b)) {
            onStop.onStop();
        }
    }
}
