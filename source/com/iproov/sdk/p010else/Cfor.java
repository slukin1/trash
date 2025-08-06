package com.iproov.sdk.p010else;

import com.iproov.sdk.logging.IPLog;
import com.iproov.sdk.p017implements.Cimport;
import com.iproov.sdk.utils.Cnew;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import wv.a;

/* renamed from: com.iproov.sdk.else.for  reason: invalid class name and invalid package */
public final class Cfor {

    /* renamed from: case  reason: not valid java name */
    private static final String f511case = ("🔦 " + Cfor.class.getSimpleName());

    /* renamed from: else  reason: not valid java name */
    private static long f512else = -1;

    /* renamed from: do  reason: not valid java name */
    private boolean f513do = false;

    /* renamed from: for  reason: not valid java name */
    private final Cdo f514for;

    /* renamed from: if  reason: not valid java name */
    private final List<Cdo> f515if;

    /* renamed from: new  reason: not valid java name */
    private final Cnew f516new;

    /* renamed from: try  reason: not valid java name */
    private final AtomicInteger f517try = new AtomicInteger(0);

    /* renamed from: com.iproov.sdk.else.for$do  reason: invalid class name */
    public interface Cdo {
        /* renamed from: do  reason: not valid java name */
        void m590do();

        /* renamed from: do  reason: not valid java name */
        void m591do(int i11, Cdo doVar, int i12);

        /* renamed from: if  reason: not valid java name */
        void m592if();
    }

    public Cfor(Cif ifVar, Cnew newR, Cdo doVar) {
        this.f516new = newR;
        this.f515if = ifVar.m594do(newR.f525new, newR.f527try);
        this.f514for = doVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: try  reason: not valid java name */
    public /* synthetic */ void m584try() {
        int i11 = 0;
        while (i11 < m586for() && !this.f513do) {
            try {
                Cdo doVar = this.f515if.get(i11);
                m583do();
                Objects.toString(doVar);
                int i12 = this.f517try.get();
                this.f514for.m591do(i11, doVar, i12);
                Thread.sleep((long) i12);
                if (i11 >= this.f516new.f522for) {
                    for (int i13 = 0; i13 < this.f516new.f524if; i13++) {
                        this.f514for.m592if();
                    }
                }
                i11++;
            } catch (InterruptedException unused) {
            }
        }
        this.f514for.m590do();
    }

    /* renamed from: do  reason: not valid java name */
    public void m585do(float f11, float f12) {
        double min = 1.0d / ((double) Math.min(f11, f12));
        Cnew newR = this.f516new;
        this.f517try.set((int) Cimport.m1012do(min * ((double) newR.f520do), (double) newR.f519case, (double) newR.f521else));
        Cnew newR2 = this.f516new;
        float f13 = newR2.f520do;
        int i11 = newR2.f519case;
        int i12 = newR2.f521else;
    }

    /* renamed from: for  reason: not valid java name */
    public int m586for() {
        return this.f515if.size();
    }

    /* renamed from: if  reason: not valid java name */
    public void m588if(float f11, float f12) {
        m585do(f11, f12);
        Cnew.m2282do("FlashingLoop", Cnew.Cfor.HIGH, (Runnable) new a(this)).start();
    }

    /* renamed from: new  reason: not valid java name */
    public int m589new() {
        int i11 = m586for();
        Cnew newR = this.f516new;
        return (i11 - newR.f522for) * newR.f524if;
    }

    /* renamed from: if  reason: not valid java name */
    public void m587if() {
        this.f513do = true;
    }

    /* renamed from: do  reason: not valid java name */
    private static void m583do() {
        long nanoTime = System.nanoTime();
        long j11 = (nanoTime - f512else) / 1000000;
        if (j11 >= 175) {
            f512else = nanoTime;
            return;
        }
        String str = "Maximum flash rate (175 ms) exceeded, flashing aborted (" + j11 + " ms)";
        IPLog.w(f511case, "Epilepsy warning! " + str);
        throw new IllegalStateException(str);
    }
}
