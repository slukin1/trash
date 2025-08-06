package q3;

import f4.h;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, C0723a> f66559a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final b f66560b = new b();

    /* renamed from: q3.a$a  reason: collision with other inner class name */
    public static class C0723a {

        /* renamed from: a  reason: collision with root package name */
        public final Lock f66561a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        public int f66562b;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<C0723a> f66563a = new ArrayDeque();

        public C0723a a() {
            C0723a poll;
            synchronized (this.f66563a) {
                poll = this.f66563a.poll();
            }
            return poll == null ? new C0723a() : poll;
        }

        public void b(C0723a aVar) {
            synchronized (this.f66563a) {
                if (this.f66563a.size() < 10) {
                    this.f66563a.offer(aVar);
                }
            }
        }
    }

    public void a(String str) {
        C0723a aVar;
        synchronized (this) {
            aVar = this.f66559a.get(str);
            if (aVar == null) {
                aVar = this.f66560b.a();
                this.f66559a.put(str, aVar);
            }
            aVar.f66562b++;
        }
        aVar.f66561a.lock();
    }

    public void b(String str) {
        C0723a aVar;
        synchronized (this) {
            aVar = (C0723a) h.d(this.f66559a.get(str));
            int i11 = aVar.f66562b;
            if (i11 >= 1) {
                int i12 = i11 - 1;
                aVar.f66562b = i12;
                if (i12 == 0) {
                    C0723a remove = this.f66559a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f66560b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f66562b);
            }
        }
        aVar.f66561a.unlock();
    }
}
