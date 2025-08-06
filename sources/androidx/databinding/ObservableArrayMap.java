package androidx.databinding;

import androidx.collection.ArrayMap;
import androidx.databinding.ObservableMap;
import java.util.Collection;

public class ObservableArrayMap<K, V> extends ArrayMap<K, V> implements ObservableMap<K, V> {

    /* renamed from: j  reason: collision with root package name */
    public transient MapChangeRegistry f8864j;

    public void b(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        if (this.f8864j == null) {
            this.f8864j = new MapChangeRegistry();
        }
        this.f8864j.b(onMapChangedCallback);
    }

    public void clear() {
        if (!isEmpty()) {
            super.clear();
            s((Object) null);
        }
    }

    public void g(ObservableMap.OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback) {
        MapChangeRegistry mapChangeRegistry = this.f8864j;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.j(onMapChangedCallback);
        }
    }

    public V n(int i11) {
        Object l11 = l(i11);
        V n11 = super.n(i11);
        if (n11 != null) {
            s(l11);
        }
        return n11;
    }

    public V o(int i11, V v11) {
        Object l11 = l(i11);
        V o11 = super.o(i11, v11);
        s(l11);
        return o11;
    }

    public V put(K k11, V v11) {
        super.put(k11, v11);
        s(k11);
        return v11;
    }

    public boolean r(Collection<?> collection) {
        boolean z11 = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(l(size))) {
                n(size);
                z11 = true;
            }
        }
        return z11;
    }

    public final void s(Object obj) {
        MapChangeRegistry mapChangeRegistry = this.f8864j;
        if (mapChangeRegistry != null) {
            mapChangeRegistry.e(this, 0, obj);
        }
    }
}
