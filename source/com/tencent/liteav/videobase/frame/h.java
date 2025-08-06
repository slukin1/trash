package com.tencent.liteav.videobase.frame;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.j;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public abstract class h<T extends j> {

    /* renamed from: a  reason: collision with root package name */
    public final Deque<T> f22210a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    public final Semaphore f22211b = new Semaphore(1);

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f22212c = false;

    /* renamed from: d  reason: collision with root package name */
    private final g<T> f22213d = new g<T>() {
        public final void a(T t11) {
            h.this.f22211b.release();
            synchronized (h.this) {
                if (!h.this.f22212c) {
                    h.this.f22210a.addFirst(t11);
                }
            }
        }
    };

    public final T a() throws InterruptedException {
        T t11;
        this.f22211b.acquire();
        synchronized (this) {
            if (!this.f22210a.isEmpty()) {
                t11 = (j) this.f22210a.removeFirst();
            } else {
                t11 = a(this.f22213d);
            }
        }
        if (t11.retain() != 1) {
            LiteavLog.e("LimitedFramePool", "invalid reference count for %s", t11);
        }
        return t11;
    }

    public abstract T a(g<T> gVar);
}
