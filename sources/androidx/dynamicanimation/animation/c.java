package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.b;
import j1.a;

public final class c extends b<c> {
    public SpringForce A = null;
    public float B = Float.MAX_VALUE;
    public boolean C = false;

    public <K> c(K k11, a<K> aVar) {
        super(k11, aVar);
    }

    public void m() {
        t();
        this.A.g((double) f());
        super.m();
    }

    public boolean o(long j11) {
        if (this.C) {
            float f11 = this.B;
            if (f11 != Float.MAX_VALUE) {
                this.A.e(f11);
                this.B = Float.MAX_VALUE;
            }
            this.f9355b = this.A.a();
            this.f9354a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j12 = j11 / 2;
            b.o h11 = this.A.h((double) this.f9355b, (double) this.f9354a, j12);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            b.o h12 = this.A.h((double) h11.f9366a, (double) h11.f9367b, j12);
            this.f9355b = h12.f9366a;
            this.f9354a = h12.f9367b;
        } else {
            b.o h13 = this.A.h((double) this.f9355b, (double) this.f9354a, j11);
            this.f9355b = h13.f9366a;
            this.f9354a = h13.f9367b;
        }
        float max = Math.max(this.f9355b, this.f9361h);
        this.f9355b = max;
        float min = Math.min(max, this.f9360g);
        this.f9355b = min;
        if (!s(min, this.f9354a)) {
            return false;
        }
        this.f9355b = this.A.a();
        this.f9354a = 0.0f;
        return true;
    }

    public void p(float f11) {
        if (g()) {
            this.B = f11;
            return;
        }
        if (this.A == null) {
            this.A = new SpringForce(f11);
        }
        this.A.e(f11);
        m();
    }

    public boolean q() {
        return this.A.f9315b > 0.0d;
    }

    public SpringForce r() {
        return this.A;
    }

    public boolean s(float f11, float f12) {
        return this.A.c(f11, f12);
    }

    public final void t() {
        SpringForce springForce = this.A;
        if (springForce != null) {
            double a11 = (double) springForce.a();
            if (a11 > ((double) this.f9360g)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
            } else if (a11 < ((double) this.f9361h)) {
                throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
            }
        } else {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
    }

    public c u(SpringForce springForce) {
        this.A = springForce;
        return this;
    }

    public void v() {
        if (!q()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        } else if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (this.f9359f) {
            this.C = true;
        }
    }

    public <K> c(K k11, a<K> aVar, float f11) {
        super(k11, aVar);
        this.A = new SpringForce(f11);
    }
}
