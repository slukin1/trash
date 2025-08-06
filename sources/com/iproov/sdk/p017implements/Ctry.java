package com.iproov.sdk.p017implements;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: com.iproov.sdk.implements.try  reason: invalid class name and invalid package */
public class Ctry<T> extends Thread {

    /* renamed from: do  reason: not valid java name */
    private Cdo<T> f953do;

    /* renamed from: for  reason: not valid java name */
    private boolean f954for = true;

    /* renamed from: if  reason: not valid java name */
    private long f955if;

    /* renamed from: new  reason: not valid java name */
    private BlockingDeque<T> f956new = new LinkedBlockingDeque(1);

    /* renamed from: com.iproov.sdk.implements.try$do  reason: invalid class name */
    public interface Cdo<T> {
        /* renamed from: do  reason: not valid java name */
        void m1046do(T t11);
    }

    public Ctry(long j11, Cdo<T> doVar) {
        this.f955if = j11;
        this.f953do = doVar;
        start();
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized void m1045do(T t11) {
        this.f956new.clear();
        this.f956new.offer(t11);
    }

    public void run() {
        long j11 = 0;
        while (this.f954for) {
            try {
                Thread.sleep(j11);
                T take = this.f956new.take();
                if (this.f954for) {
                    this.f953do.m1046do(take);
                }
            } catch (InterruptedException unused) {
            }
            j11 = this.f955if;
        }
        this.f953do = null;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1044do(long j11) {
        this.f955if = j11;
        interrupt();
    }

    /* renamed from: do  reason: not valid java name */
    public void m1043do() {
        this.f954for = false;
        interrupt();
    }
}
