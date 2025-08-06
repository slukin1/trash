package com.tencent.liteav.videobase.frame;

import android.os.SystemClock;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videobase.frame.j;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class a<T extends j> {

    /* renamed from: a  reason: collision with root package name */
    private static final long f22190a = TimeUnit.SECONDS.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    private final String f22191b = null;

    /* renamed from: c  reason: collision with root package name */
    private final Map<C0174a, Deque<T>> f22192c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f22193d = false;

    /* renamed from: e  reason: collision with root package name */
    private final com.tencent.liteav.base.b.a f22194e = new com.tencent.liteav.base.b.a(f22190a);

    /* renamed from: f  reason: collision with root package name */
    private final g<T> f22195f = new b(this);

    /* renamed from: com.tencent.liteav.videobase.frame.a$a  reason: collision with other inner class name */
    public interface C0174a {
    }

    public static /* synthetic */ void a(a aVar, j jVar) {
        if (jVar != null) {
            synchronized (aVar.f22192c) {
                if (aVar.f22193d) {
                    aVar.a(jVar);
                    return;
                }
                Deque b11 = aVar.b(aVar.b(jVar));
                jVar.updateLastUsedTimestamp(SystemClock.elapsedRealtime());
                b11.addFirst(jVar);
                aVar.c();
            }
        }
    }

    private void c() {
        j jVar;
        if (this.f22194e.a()) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            ArrayList<j> arrayList = new ArrayList<>();
            synchronized (this.f22192c) {
                Iterator<Deque<T>> it2 = this.f22192c.values().iterator();
                while (it2.hasNext()) {
                    Deque next = it2.next();
                    while (!next.isEmpty() && ((jVar = (j) next.peekLast()) == null || elapsedRealtime - jVar.getLastUsedTimestamp() >= f22190a)) {
                        next.pollLast();
                        arrayList.add(jVar);
                    }
                }
            }
            for (j a11 : arrayList) {
                a(a11);
            }
        }
    }

    public abstract T a(g<T> gVar, C0174a aVar);

    public abstract void a(T t11);

    public abstract C0174a b(T t11);

    public void b() {
        this.f22193d = true;
        a();
    }

    public void finalize() throws Throwable {
        super.finalize();
        if (!this.f22193d) {
            LiteavLog.e("FramePool", "%s must call destroy() before finalize()!\n%s", getClass().getName(), this.f22191b);
        }
    }

    private Deque<T> b(C0174a aVar) {
        Deque<T> deque = this.f22192c.get(aVar);
        if (deque != null) {
            return deque;
        }
        LinkedList linkedList = new LinkedList();
        this.f22192c.put(aVar, linkedList);
        return linkedList;
    }

    public final T a(C0174a aVar) {
        T t11;
        synchronized (this.f22192c) {
            Deque b11 = b(aVar);
            t11 = !b11.isEmpty() ? (j) b11.removeFirst() : null;
        }
        c();
        if (t11 == null) {
            t11 = a(this.f22195f, aVar);
        }
        if (t11.retain() != 1) {
            LiteavLog.e("FramePool", "invalid reference count for %s", t11);
        }
        return t11;
    }

    public void a() {
        ArrayList<j> arrayList = new ArrayList<>();
        synchronized (this.f22192c) {
            for (Deque<T> addAll : this.f22192c.values()) {
                arrayList.addAll(addAll);
            }
            this.f22192c.clear();
        }
        for (j a11 : arrayList) {
            a(a11);
        }
    }
}
