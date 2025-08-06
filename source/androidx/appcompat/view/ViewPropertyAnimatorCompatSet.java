package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.n0;
import androidx.core.view.o0;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<n0> f4010a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public long f4011b = -1;

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f4012c;

    /* renamed from: d  reason: collision with root package name */
    public o0 f4013d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f4014e;

    /* renamed from: f  reason: collision with root package name */
    public final ViewPropertyAnimatorListenerAdapter f4015f = new a();

    public class a extends ViewPropertyAnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4016a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f4017b = 0;

        public a() {
        }

        public void b(View view) {
            int i11 = this.f4017b + 1;
            this.f4017b = i11;
            if (i11 == ViewPropertyAnimatorCompatSet.this.f4010a.size()) {
                o0 o0Var = ViewPropertyAnimatorCompatSet.this.f4013d;
                if (o0Var != null) {
                    o0Var.b((View) null);
                }
                d();
            }
        }

        public void c(View view) {
            if (!this.f4016a) {
                this.f4016a = true;
                o0 o0Var = ViewPropertyAnimatorCompatSet.this.f4013d;
                if (o0Var != null) {
                    o0Var.c((View) null);
                }
            }
        }

        public void d() {
            this.f4017b = 0;
            this.f4016a = false;
            ViewPropertyAnimatorCompatSet.this.b();
        }
    }

    public void a() {
        if (this.f4014e) {
            Iterator<n0> it2 = this.f4010a.iterator();
            while (it2.hasNext()) {
                it2.next().c();
            }
            this.f4014e = false;
        }
    }

    public void b() {
        this.f4014e = false;
    }

    public ViewPropertyAnimatorCompatSet c(n0 n0Var) {
        if (!this.f4014e) {
            this.f4010a.add(n0Var);
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet d(n0 n0Var, n0 n0Var2) {
        this.f4010a.add(n0Var);
        n0Var2.l(n0Var.d());
        this.f4010a.add(n0Var2);
        return this;
    }

    public ViewPropertyAnimatorCompatSet e(long j11) {
        if (!this.f4014e) {
            this.f4011b = j11;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet f(Interpolator interpolator) {
        if (!this.f4014e) {
            this.f4012c = interpolator;
        }
        return this;
    }

    public ViewPropertyAnimatorCompatSet g(o0 o0Var) {
        if (!this.f4014e) {
            this.f4013d = o0Var;
        }
        return this;
    }

    public void h() {
        if (!this.f4014e) {
            Iterator<n0> it2 = this.f4010a.iterator();
            while (it2.hasNext()) {
                n0 next = it2.next();
                long j11 = this.f4011b;
                if (j11 >= 0) {
                    next.h(j11);
                }
                Interpolator interpolator = this.f4012c;
                if (interpolator != null) {
                    next.i(interpolator);
                }
                if (this.f4013d != null) {
                    next.j(this.f4015f);
                }
                next.n();
            }
            this.f4014e = true;
        }
    }
}
