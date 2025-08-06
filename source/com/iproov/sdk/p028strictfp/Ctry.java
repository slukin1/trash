package com.iproov.sdk.p028strictfp;

import com.iproov.sdk.utils.Cnew;
import d10.a;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;

/* renamed from: com.iproov.sdk.strictfp.try  reason: invalid class name and invalid package */
public final class Ctry {

    /* renamed from: do  reason: not valid java name */
    private final long f1971do;

    /* renamed from: for  reason: not valid java name */
    private final Object f1972for = new Object();

    /* renamed from: if  reason: not valid java name */
    private Timer f1973if;
    /* access modifiers changed from: private */

    /* renamed from: new  reason: not valid java name */
    public final ExecutorService f1974new = Cnew.m2283do("TimeoutProcessor", Cnew.Cfor.MEDIUM, Cnew.Cnew.RUN_TASK_ONLY_IF_IDLE);

    /* renamed from: com.iproov.sdk.strictfp.try$do  reason: invalid class name */
    public static final class Cdo extends TimerTask {

        /* renamed from: do  reason: not valid java name */
        public final /* synthetic */ Ctry f1975do;

        /* renamed from: if  reason: not valid java name */
        public final /* synthetic */ a<Unit> f1976if;

        /* renamed from: com.iproov.sdk.strictfp.try$do$do  reason: invalid class name */
        public /* synthetic */ class Cdo implements Runnable {

            /* renamed from: do  reason: not valid java name */
            public final /* synthetic */ a<Unit> f1977do;

            public Cdo(a<Unit> aVar) {
                this.f1977do = aVar;
            }

            public final void run() {
                this.f1977do.invoke();
            }
        }

        public Cdo(Ctry tryR, a<Unit> aVar) {
            this.f1975do = tryR;
            this.f1976if = aVar;
        }

        public void run() {
            this.f1975do.f1974new.execute(new Cdo(this.f1976if));
        }
    }

    public Ctry(long j11) {
        this.f1971do = j11;
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1850do(a<Unit> aVar) {
        synchronized (this.f1972for) {
            m1849do();
            Timer timer = new Timer();
            this.f1973if = timer;
            timer.schedule(new Cdo(this, aVar), this.f1971do);
            Unit unit = Unit.f56620a;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public final void m1849do() {
        synchronized (this.f1972for) {
            Timer timer = this.f1973if;
            if (timer != null) {
                timer.cancel();
                this.f1973if = null;
            }
            Unit unit = Unit.f56620a;
        }
    }
}
