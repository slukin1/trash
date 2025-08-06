package com.xiaomi.push;

import java.util.concurrent.Callable;

public class bd<T> {

    /* renamed from: a  reason: collision with root package name */
    private final long f51424a;

    /* renamed from: b  reason: collision with root package name */
    private long f51425b;

    /* renamed from: c  reason: collision with root package name */
    private long f51426c;

    /* renamed from: d  reason: collision with root package name */
    private long f51427d;

    /* renamed from: e  reason: collision with root package name */
    private long f51428e;

    /* renamed from: f  reason: collision with root package name */
    private long f51429f;

    /* renamed from: g  reason: collision with root package name */
    private long f51430g;

    /* renamed from: h  reason: collision with root package name */
    private long f51431h;

    /* renamed from: i  reason: collision with root package name */
    private final long f51432i;

    public bd(long j11, long j12) {
        this.f51432i = j11 * 1000000;
        this.f51424a = j12;
    }

    public long a() {
        return this.f51426c;
    }

    public long b() {
        return this.f51427d;
    }

    public long c() {
        long j11 = this.f51429f;
        if (j11 > 0) {
            long j12 = this.f51428e;
            if (j12 > 0) {
                return j11 / j12;
            }
        }
        return 0;
    }

    public long d() {
        long j11 = this.f51431h;
        long j12 = this.f51430g;
        if (j11 > j12) {
            return j11 - j12;
        }
        return 0;
    }

    public T a(Callable<T> callable) {
        long j11 = this.f51425b;
        long j12 = this.f51432i;
        if (j11 > j12) {
            long j13 = (j11 / j12) * this.f51424a;
            this.f51425b = 0;
            if (j13 > 0) {
                try {
                    Thread.sleep(j13);
                } catch (Exception unused) {
                }
            }
        }
        long nanoTime = System.nanoTime();
        if (this.f51430g <= 0) {
            this.f51430g = nanoTime;
        }
        T t11 = null;
        try {
            t11 = callable.call();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        long nanoTime2 = System.nanoTime() - nanoTime;
        this.f51431h = System.nanoTime();
        this.f51428e++;
        if (this.f51426c < nanoTime2) {
            this.f51426c = nanoTime2;
        }
        if (nanoTime2 > 0) {
            this.f51429f += nanoTime2;
            long j14 = this.f51427d;
            if (j14 == 0 || j14 > nanoTime2) {
                this.f51427d = nanoTime2;
            }
        }
        this.f51425b += Math.max(nanoTime2, 0);
        return t11;
    }
}
