package we;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.z;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f26308a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final ConcurrentHashMap<String, a<?>> f26309b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap<String, CopyOnWriteArrayList<LifecycleOwner>> f26310c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static final ConcurrentHashMap<LifecycleOwner, CopyOnWriteArrayList<String>> f26311d = new ConcurrentHashMap<>();

    public static final class a<T> extends LiveData<T> {

        /* renamed from: a  reason: collision with root package name */
        public final String f26312a;

        /* renamed from: b  reason: collision with root package name */
        public T f26313b;

        /* renamed from: c  reason: collision with root package name */
        public int f26314c;

        public a(String str) {
            this.f26312a = str;
        }

        public static final void f(LifecycleOwner lifecycleOwner, LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                for (String str : b.f26308a.j(lifecycleOwner)) {
                    b bVar = b.f26308a;
                    bVar.k(str).remove(lifecycleOwner2);
                    if (bVar.k(str).isEmpty()) {
                        b.f26309b.remove(str);
                        b.f26310c.remove(str);
                    }
                }
                b.f26311d.remove(lifecycleOwner);
            }
        }

        public final T c() {
            return this.f26313b;
        }

        public final int d() {
            return this.f26314c;
        }

        public final void e(LifecycleOwner lifecycleOwner, z<? super T> zVar, boolean z11) {
            super.observe(lifecycleOwner, new C0232b(this, zVar, z11));
            b bVar = b.f26308a;
            bVar.i(this.f26312a, lifecycleOwner);
            if (!b.f26311d.containsKey(lifecycleOwner)) {
                lifecycleOwner.getLifecycle().a(new a(lifecycleOwner));
            }
            bVar.h(this.f26312a, lifecycleOwner);
        }

        public final void g(T t11) {
            postValue(t11);
        }

        public final void h(T t11) {
            setValue(t11);
        }

        public void observe(LifecycleOwner lifecycleOwner, z<? super T> zVar) {
            e(lifecycleOwner, zVar, false);
        }

        public void setValue(T t11) {
            this.f26314c++;
            super.setValue(t11);
        }
    }

    /* renamed from: we.b$b  reason: collision with other inner class name */
    public static final class C0232b<T> implements z<T> {

        /* renamed from: b  reason: collision with root package name */
        public final a<T> f26315b;

        /* renamed from: c  reason: collision with root package name */
        public final z<? super T> f26316c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f26317d;

        /* renamed from: e  reason: collision with root package name */
        public int f26318e;

        public C0232b(a<T> aVar, z<? super T> zVar, boolean z11) {
            this.f26315b = aVar;
            this.f26316c = zVar;
            this.f26317d = z11;
            this.f26318e = aVar.d();
        }

        public void onChanged(T t11) {
            if (this.f26318e < this.f26315b.d()) {
                this.f26318e = this.f26315b.d();
                this.f26316c.onChanged(t11);
            } else if (this.f26317d && this.f26315b.c() != null) {
                this.f26316c.onChanged(t11);
            }
        }
    }

    public static final <T> a<T> l(String str, Class<T> cls) {
        ConcurrentHashMap<String, a<?>> concurrentHashMap = f26309b;
        a<T> aVar = concurrentHashMap.get(str);
        if (aVar != null) {
            return aVar;
        }
        a<T> aVar2 = new a<>(str);
        concurrentHashMap.put(str, aVar2);
        return aVar2;
    }

    public static /* synthetic */ a m(String str, Class cls, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            cls = null;
        }
        return l(str, cls);
    }

    public final void h(String str, LifecycleOwner lifecycleOwner) {
        CopyOnWriteArrayList<String> j11 = j(lifecycleOwner);
        if (!j11.contains(str)) {
            j11.add(str);
        }
    }

    public final void i(String str, LifecycleOwner lifecycleOwner) {
        CopyOnWriteArrayList<LifecycleOwner> k11 = k(str);
        if (!k11.contains(lifecycleOwner)) {
            k11.add(lifecycleOwner);
        }
    }

    public final CopyOnWriteArrayList<String> j(LifecycleOwner lifecycleOwner) {
        ConcurrentHashMap<LifecycleOwner, CopyOnWriteArrayList<String>> concurrentHashMap = f26311d;
        CopyOnWriteArrayList<String> copyOnWriteArrayList = concurrentHashMap.get(lifecycleOwner);
        if (copyOnWriteArrayList != null) {
            return copyOnWriteArrayList;
        }
        CopyOnWriteArrayList<String> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        concurrentHashMap.put(lifecycleOwner, copyOnWriteArrayList2);
        return copyOnWriteArrayList2;
    }

    public final CopyOnWriteArrayList<LifecycleOwner> k(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<LifecycleOwner>> concurrentHashMap = f26310c;
        CopyOnWriteArrayList<LifecycleOwner> copyOnWriteArrayList = concurrentHashMap.get(str);
        if (copyOnWriteArrayList != null) {
            return copyOnWriteArrayList;
        }
        CopyOnWriteArrayList<LifecycleOwner> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
        concurrentHashMap.put(str, copyOnWriteArrayList2);
        return copyOnWriteArrayList2;
    }
}
