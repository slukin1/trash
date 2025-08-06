package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

public class MediatorLiveData<T> extends MutableLiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public SafeIterableMap<LiveData<?>, a<?>> f9925a = new SafeIterableMap<>();

    public static class a<V> implements z<V> {

        /* renamed from: b  reason: collision with root package name */
        public final LiveData<V> f9926b;

        /* renamed from: c  reason: collision with root package name */
        public final z<? super V> f9927c;

        /* renamed from: d  reason: collision with root package name */
        public int f9928d = -1;

        public a(LiveData<V> liveData, z<? super V> zVar) {
            this.f9926b = liveData;
            this.f9927c = zVar;
        }

        public void a() {
            this.f9926b.observeForever(this);
        }

        public void b() {
            this.f9926b.removeObserver(this);
        }

        public void onChanged(V v11) {
            if (this.f9928d != this.f9926b.getVersion()) {
                this.f9928d = this.f9926b.getVersion();
                this.f9927c.onChanged(v11);
            }
        }
    }

    public <S> void b(LiveData<S> liveData, z<? super S> zVar) {
        Objects.requireNonNull(liveData, "source cannot be null");
        a aVar = new a(liveData, zVar);
        a g11 = this.f9925a.g(liveData, aVar);
        if (g11 != null && g11.f9927c != zVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (g11 == null && hasActiveObservers()) {
            aVar.a();
        }
    }

    public <S> void c(LiveData<S> liveData) {
        a h11 = this.f9925a.h(liveData);
        if (h11 != null) {
            h11.b();
        }
    }

    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it2 = this.f9925a.iterator();
        while (it2.hasNext()) {
            ((a) it2.next().getValue()).a();
        }
    }

    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it2 = this.f9925a.iterator();
        while (it2.hasNext()) {
            ((a) it2.next().getValue()).b();
        }
    }
}
