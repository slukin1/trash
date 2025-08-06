package androidx.databinding;

import java.util.Map;

public interface ObservableMap<K, V> extends Map<K, V> {

    public static abstract class OnMapChangedCallback<T extends ObservableMap<K, V>, K, V> {
        public abstract void d(T t11, K k11);
    }

    void b(OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback);

    void g(OnMapChangedCallback<? extends ObservableMap<K, V>, K, V> onMapChangedCallback);
}
