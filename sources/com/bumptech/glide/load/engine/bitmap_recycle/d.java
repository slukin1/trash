package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.i;
import java.util.Queue;

public abstract class d<T extends i> {

    /* renamed from: a  reason: collision with root package name */
    public final Queue<T> f63765a = f4.i.f(20);

    public abstract T a();

    public T b() {
        T t11 = (i) this.f63765a.poll();
        return t11 == null ? a() : t11;
    }

    public void c(T t11) {
        if (this.f63765a.size() < 20) {
            this.f63765a.offer(t11);
        }
    }
}
