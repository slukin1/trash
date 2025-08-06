package com.iproov.sdk.p032throw;

/* renamed from: com.iproov.sdk.throw.for  reason: invalid class name and invalid package */
public abstract class Cfor<T> {

    /* renamed from: do  reason: not valid java name */
    private final long f2023do;

    /* renamed from: for  reason: not valid java name */
    public final T f2024for;

    /* renamed from: if  reason: not valid java name */
    public final T f2025if;

    /* renamed from: new  reason: not valid java name */
    private long f2026new = -1;

    public Cfor(long j11, T t11, T t12) {
        this.f2023do = j11;
        this.f2025if = t11;
        this.f2024for = t12;
    }

    /* renamed from: do  reason: not valid java name */
    public T m1901do() {
        if (this.f2026new == -1) {
            return this.f2025if;
        }
        return m1902do(((float) Math.min(System.currentTimeMillis() - this.f2026new, this.f2023do)) / ((float) this.f2023do));
    }

    /* renamed from: do  reason: not valid java name */
    public abstract T m1902do(float f11);

    /* renamed from: if  reason: not valid java name */
    public void m1903if() {
        this.f2026new = System.currentTimeMillis();
    }
}
