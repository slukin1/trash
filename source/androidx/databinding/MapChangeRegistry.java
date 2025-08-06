package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableMap;

public class MapChangeRegistry extends CallbackRegistry<ObservableMap.OnMapChangedCallback, ObservableMap, Object> {

    /* renamed from: g  reason: collision with root package name */
    public static CallbackRegistry.NotifierCallback<ObservableMap.OnMapChangedCallback, ObservableMap, Object> f8860g = new a();

    public class a extends CallbackRegistry.NotifierCallback<ObservableMap.OnMapChangedCallback, ObservableMap, Object> {
        /* renamed from: b */
        public void a(ObservableMap.OnMapChangedCallback onMapChangedCallback, ObservableMap observableMap, int i11, Object obj) {
            onMapChangedCallback.d(observableMap, obj);
        }
    }

    public MapChangeRegistry() {
        super(f8860g);
    }
}
