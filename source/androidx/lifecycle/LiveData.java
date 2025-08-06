package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {
    public static final Object NOT_SET = new Object();
    public static final int START_VERSION = -1;
    public int mActiveCount;
    private boolean mChangingActiveState;
    private volatile Object mData;
    public final Object mDataLock;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<z<? super T>, LiveData<T>.d> mObservers;
    public volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            Object obj;
            synchronized (LiveData.this.mDataLock) {
                obj = LiveData.this.mPendingData;
                LiveData.this.mPendingData = LiveData.NOT_SET;
            }
            LiveData.this.setValue(obj);
        }
    }

    public class b extends LiveData<T>.d {
        public b(z<? super T> zVar) {
            super(zVar);
        }

        public boolean d() {
            return true;
        }
    }

    public class c extends LiveData<T>.d implements r {

        /* renamed from: f  reason: collision with root package name */
        public final LifecycleOwner f9917f;

        public c(LifecycleOwner lifecycleOwner, z<? super T> zVar) {
            super(zVar);
            this.f9917f = lifecycleOwner;
        }

        public void b() {
            this.f9917f.getLifecycle().d(this);
        }

        public boolean c(LifecycleOwner lifecycleOwner) {
            return this.f9917f == lifecycleOwner;
        }

        public boolean d() {
            return this.f9917f.getLifecycle().b().isAtLeast(Lifecycle.State.STARTED);
        }

        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Lifecycle.State b11 = this.f9917f.getLifecycle().b();
            if (b11 == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.f9919b);
                return;
            }
            Lifecycle.State state = null;
            while (state != b11) {
                a(d());
                state = b11;
                b11 = this.f9917f.getLifecycle().b();
            }
        }
    }

    public abstract class d {

        /* renamed from: b  reason: collision with root package name */
        public final z<? super T> f9919b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9920c;

        /* renamed from: d  reason: collision with root package name */
        public int f9921d = -1;

        public d(z<? super T> zVar) {
            this.f9919b = zVar;
        }

        public void a(boolean z11) {
            if (z11 != this.f9920c) {
                this.f9920c = z11;
                LiveData.this.changeActiveCounter(z11 ? 1 : -1);
                if (this.f9920c) {
                    LiveData.this.dispatchingValue(this);
                }
            }
        }

        public void b() {
        }

        public boolean c(LifecycleOwner lifecycleOwner) {
            return false;
        }

        public abstract boolean d();
    }

    public LiveData(T t11) {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.mActiveCount = 0;
        this.mPendingData = NOT_SET;
        this.mPostValueRunnable = new a();
        this.mData = t11;
        this.mVersion = 0;
    }

    public static void assertMainThread(String str) {
        if (!i.a.e().b()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void considerNotify(LiveData<T>.d dVar) {
        if (dVar.f9920c) {
            if (!dVar.d()) {
                dVar.a(false);
                return;
            }
            int i11 = dVar.f9921d;
            int i12 = this.mVersion;
            if (i11 < i12) {
                dVar.f9921d = i12;
                dVar.f9919b.onChanged(this.mData);
            }
        }
    }

    public void changeActiveCounter(int i11) {
        int i12 = this.mActiveCount;
        this.mActiveCount = i11 + i12;
        if (!this.mChangingActiveState) {
            this.mChangingActiveState = true;
            while (true) {
                try {
                    int i13 = this.mActiveCount;
                    if (i12 != i13) {
                        boolean z11 = i12 == 0 && i13 > 0;
                        boolean z12 = i12 > 0 && i13 == 0;
                        if (z11) {
                            onActive();
                        } else if (z12) {
                            onInactive();
                        }
                        i12 = i13;
                    } else {
                        return;
                    }
                } finally {
                    this.mChangingActiveState = false;
                }
            }
        }
    }

    public void dispatchingValue(LiveData<T>.d dVar) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (dVar == null) {
                SafeIterableMap<K, V>.d c11 = this.mObservers.c();
                while (c11.hasNext()) {
                    considerNotify((d) ((Map.Entry) c11.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(dVar);
                dVar = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public T getValue() {
        T t11 = this.mData;
        if (t11 != NOT_SET) {
            return t11;
        }
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    public boolean hasObservers() {
        return this.mObservers.size() > 0;
    }

    public boolean isInitialized() {
        return this.mData != NOT_SET;
    }

    public void observe(LifecycleOwner lifecycleOwner, z<? super T> zVar) {
        assertMainThread("observe");
        if (lifecycleOwner.getLifecycle().b() != Lifecycle.State.DESTROYED) {
            c cVar = new c(lifecycleOwner, zVar);
            d g11 = this.mObservers.g(zVar, cVar);
            if (g11 != null && !g11.c(lifecycleOwner)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (g11 == null) {
                lifecycleOwner.getLifecycle().a(cVar);
            }
        }
    }

    public void observeForever(z<? super T> zVar) {
        assertMainThread("observeForever");
        b bVar = new b(zVar);
        d g11 = this.mObservers.g(zVar, bVar);
        if (g11 instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (g11 == null) {
            bVar.a(true);
        }
    }

    public void onActive() {
    }

    public void onInactive() {
    }

    public void postValue(T t11) {
        boolean z11;
        synchronized (this.mDataLock) {
            z11 = this.mPendingData == NOT_SET;
            this.mPendingData = t11;
        }
        if (z11) {
            i.a.e().c(this.mPostValueRunnable);
        }
    }

    public void removeObserver(z<? super T> zVar) {
        assertMainThread("removeObserver");
        d h11 = this.mObservers.h(zVar);
        if (h11 != null) {
            h11.b();
            h11.a(false);
        }
    }

    public void removeObservers(LifecycleOwner lifecycleOwner) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<z<? super T>, LiveData<T>.d>> it2 = this.mObservers.iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (((d) next.getValue()).c(lifecycleOwner)) {
                removeObserver((z) next.getKey());
            }
        }
    }

    public void setValue(T t11) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t11;
        dispatchingValue((LiveData<T>.d) null);
    }

    public LiveData() {
        this.mDataLock = new Object();
        this.mObservers = new SafeIterableMap<>();
        this.mActiveCount = 0;
        Object obj = NOT_SET;
        this.mPendingData = obj;
        this.mPostValueRunnable = new a();
        this.mData = obj;
        this.mVersion = -1;
    }
}
