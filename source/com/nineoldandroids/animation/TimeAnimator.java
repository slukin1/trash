package com.nineoldandroids.animation;

public class TimeAnimator extends ValueAnimator {
    public a F;
    public long G = -1;

    public interface a {
        void a(TimeAnimator timeAnimator, long j11, long j12);
    }

    public void q(float f11) {
    }

    public boolean r(long j11) {
        long j12 = 0;
        if (this.f28264j == 0) {
            this.f28264j = 1;
            long j13 = this.f28258d;
            if (j13 < 0) {
                this.f28257c = j11;
            } else {
                this.f28257c = j11 - j13;
                this.f28258d = -1;
            }
        }
        a aVar = this.F;
        if (aVar == null) {
            return false;
        }
        long j14 = j11 - this.f28257c;
        long j15 = this.G;
        if (j15 >= 0) {
            j12 = j11 - j15;
        }
        this.G = j11;
        aVar.a(this, j14, j12);
        return false;
    }

    public void x() {
    }
}
