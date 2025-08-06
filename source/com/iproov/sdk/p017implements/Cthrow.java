package com.iproov.sdk.p017implements;

import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.iproov.sdk.implements.throw  reason: invalid class name and invalid package */
public class Cthrow {

    /* renamed from: do  reason: not valid java name */
    private Timer f950do;

    /* renamed from: com.iproov.sdk.implements.throw$do  reason: invalid class name */
    public class Cdo extends TimerTask {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Runnable f951do;

        public Cdo(Cthrow throwR, Runnable runnable) {
            this.f951do = runnable;
        }

        public void run() {
            Cimport.m1017do(this.f951do);
        }
    }

    /* renamed from: com.iproov.sdk.implements.throw$if  reason: invalid class name */
    public class Cif extends TimerTask {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Runnable f952do;

        public Cif(Cthrow throwR, Runnable runnable) {
            this.f952do = runnable;
        }

        public void run() {
            Cimport.m1017do(this.f952do);
        }
    }

    public Cthrow(long j11, boolean z11, Runnable runnable) {
        Timer timer = new Timer();
        this.f950do = timer;
        if (z11) {
            timer.schedule(new Cdo(this, runnable), j11, j11);
        } else {
            timer.schedule(new Cif(this, runnable), j11);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public void m1042do() {
        this.f950do.cancel();
    }
}
