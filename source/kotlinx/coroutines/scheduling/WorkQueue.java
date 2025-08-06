package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.a;
import g10.g;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.j0;

public final class WorkQueue {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57495b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57496c;

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57497d;

    /* renamed from: e  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57498e;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicReferenceArray<Task> f57499a = new AtomicReferenceArray<>(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    static {
        Class<WorkQueue> cls = WorkQueue.class;
        f57495b = AtomicReferenceFieldUpdater.newUpdater(cls, Object.class, "lastScheduledTask");
        f57496c = AtomicIntegerFieldUpdater.newUpdater(cls, "producerIndex");
        f57497d = AtomicIntegerFieldUpdater.newUpdater(cls, "consumerIndex");
        f57498e = AtomicIntegerFieldUpdater.newUpdater(cls, "blockingTasksInBuffer");
    }

    public final Task a(Task task, boolean z11) {
        if (z11) {
            return b(task);
        }
        Task task2 = (Task) f57495b.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return b(task2);
    }

    public final Task b(Task task) {
        if (d() == 127) {
            return task;
        }
        boolean z11 = true;
        if (task.f57494c.b() != 1) {
            z11 = false;
        }
        if (z11) {
            f57498e.incrementAndGet(this);
        }
        int i11 = f57496c.get(this) & 127;
        while (this.f57499a.get(i11) != null) {
            Thread.yield();
        }
        this.f57499a.lazySet(i11, task);
        f57496c.incrementAndGet(this);
        return null;
    }

    public final void c(Task task) {
        if (task != null) {
            boolean z11 = false;
            if (task.f57494c.b() == 1) {
                int decrementAndGet = f57498e.decrementAndGet(this);
                if (j0.a()) {
                    if (decrementAndGet >= 0) {
                        z11 = true;
                    }
                    if (!z11) {
                        throw new AssertionError();
                    }
                }
            }
        }
    }

    public final int d() {
        return f57496c.get(this) - f57497d.get(this);
    }

    public final int e() {
        return f57495b.get(this) != null ? d() + 1 : d();
    }

    public final void f(GlobalQueue globalQueue) {
        Task task = (Task) f57495b.getAndSet(this, (Object) null);
        if (task != null) {
            globalQueue.a(task);
        }
        do {
        } while (j(globalQueue));
    }

    public final Task g() {
        Task task = (Task) f57495b.getAndSet(this, (Object) null);
        return task == null ? i() : task;
    }

    public final Task h() {
        return k(true);
    }

    public final Task i() {
        Task andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57497d;
            int i11 = atomicIntegerFieldUpdater.get(this);
            if (i11 - f57496c.get(this) == 0) {
                return null;
            }
            int i12 = i11 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i11, i11 + 1) && (andSet = this.f57499a.getAndSet(i12, (Object) null)) != null) {
                c(andSet);
                return andSet;
            }
        }
    }

    public final boolean j(GlobalQueue globalQueue) {
        Task i11 = i();
        if (i11 == null) {
            return false;
        }
        globalQueue.a(i11);
        return true;
    }

    public final Task k(boolean z11) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Task task;
        do {
            atomicReferenceFieldUpdater = f57495b;
            task = (Task) atomicReferenceFieldUpdater.get(this);
            if (task != null) {
                boolean z12 = true;
                if (task.f57494c.b() != 1) {
                    z12 = false;
                }
                if (z12 == z11) {
                }
            }
            int i11 = f57497d.get(this);
            int i12 = f57496c.get(this);
            while (i11 != i12) {
                if (z11 && f57498e.get(this) == 0) {
                    return null;
                }
                i12--;
                Task m11 = m(i12, z11);
                if (m11 != null) {
                    return m11;
                }
            }
            return null;
        } while (!a.a(atomicReferenceFieldUpdater, this, task, (Object) null));
        return task;
    }

    public final Task l(int i11) {
        int i12 = f57497d.get(this);
        int i13 = f57496c.get(this);
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        while (i12 != i13) {
            if (z11 && f57498e.get(this) == 0) {
                return null;
            }
            int i14 = i12 + 1;
            Task m11 = m(i12, z11);
            if (m11 != null) {
                return m11;
            }
            i12 = i14;
        }
        return null;
    }

    public final Task m(int i11, boolean z11) {
        int i12 = i11 & 127;
        Task task = this.f57499a.get(i12);
        if (task != null) {
            boolean z12 = true;
            if (task.f57494c.b() != 1) {
                z12 = false;
            }
            if (z12 == z11 && this.f57499a.compareAndSet(i12, task, (Object) null)) {
                if (z11) {
                    f57498e.decrementAndGet(this);
                }
                return task;
            }
        }
        return null;
    }

    public final long n(int i11, Ref$ObjectRef<Task> ref$ObjectRef) {
        T t11;
        if (i11 == 3) {
            t11 = i();
        } else {
            t11 = l(i11);
        }
        if (t11 == null) {
            return o(i11, ref$ObjectRef);
        }
        ref$ObjectRef.element = t11;
        return -1;
    }

    public final long o(int i11, Ref$ObjectRef<Task> ref$ObjectRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        T t11;
        do {
            atomicReferenceFieldUpdater = f57495b;
            t11 = (Task) atomicReferenceFieldUpdater.get(this);
            if (t11 == null) {
                return -2;
            }
            int i12 = 1;
            if (!(t11.f57494c.b() == 1)) {
                i12 = 2;
            }
            if ((i12 & i11) == 0) {
                return -2;
            }
            long a11 = g.f54786f.a() - t11.f57493b;
            long j11 = g.f54782b;
            if (a11 < j11) {
                return j11 - a11;
            }
        } while (!a.a(atomicReferenceFieldUpdater, this, t11, (Object) null));
        ref$ObjectRef.element = t11;
        return -1;
    }
}
