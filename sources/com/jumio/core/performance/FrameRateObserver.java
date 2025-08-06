package com.jumio.core.performance;

import android.os.SystemClock;
import jumio.core.m1;
import jumio.core.t1;
import jumio.core.u2;

public final class FrameRateObserver {

    /* renamed from: a  reason: collision with root package name */
    public final m1 f39467a;

    public enum THREAD {
        MAIN,
        WORKER
    }

    public FrameRateObserver(long j11, JDisplayListener jDisplayListener, THREAD thread) {
        m1 m1Var;
        if (thread == THREAD.MAIN) {
            m1Var = new t1(j11, jDisplayListener);
        } else {
            m1Var = new u2(j11, jDisplayListener);
        }
        this.f39467a = m1Var;
    }

    public final void doFrame() {
        m1 m1Var = this.f39467a;
        if (m1Var instanceof u2) {
            m1Var.doFrame(SystemClock.elapsedRealtimeNanos());
        }
    }

    public final void start() {
        m1 m1Var = this.f39467a;
        m1Var.f56278e = true;
        m1Var.b();
    }

    public final void stop() {
        this.f39467a.f56278e = false;
    }
}
