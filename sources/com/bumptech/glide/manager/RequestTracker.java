package com.bumptech.glide.manager;

import android.util.Log;
import com.bumptech.glide.request.c;
import f4.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class RequestTracker {

    /* renamed from: a  reason: collision with root package name */
    public final Set<c> f64150a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public final List<c> f64151b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public boolean f64152c;

    public boolean a(c cVar) {
        boolean z11 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = this.f64150a.remove(cVar);
        if (!this.f64151b.remove(cVar) && !remove) {
            z11 = false;
        }
        if (z11) {
            cVar.clear();
        }
        return z11;
    }

    public void b() {
        for (T a11 : i.j(this.f64150a)) {
            a(a11);
        }
        this.f64151b.clear();
    }

    public void c() {
        this.f64152c = true;
        for (T t11 : i.j(this.f64150a)) {
            if (t11.isRunning() || t11.isComplete()) {
                t11.clear();
                this.f64151b.add(t11);
            }
        }
    }

    public void d() {
        this.f64152c = true;
        for (T t11 : i.j(this.f64150a)) {
            if (t11.isRunning()) {
                t11.pause();
                this.f64151b.add(t11);
            }
        }
    }

    public void e() {
        for (T t11 : i.j(this.f64150a)) {
            if (!t11.isComplete() && !t11.e()) {
                t11.clear();
                if (!this.f64152c) {
                    t11.h();
                } else {
                    this.f64151b.add(t11);
                }
            }
        }
    }

    public void f() {
        this.f64152c = false;
        for (T t11 : i.j(this.f64150a)) {
            if (!t11.isComplete() && !t11.isRunning()) {
                t11.h();
            }
        }
        this.f64151b.clear();
    }

    public void g(c cVar) {
        this.f64150a.add(cVar);
        if (!this.f64152c) {
            cVar.h();
            return;
        }
        cVar.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f64151b.add(cVar);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f64150a.size() + ", isPaused=" + this.f64152c + "}";
    }
}
