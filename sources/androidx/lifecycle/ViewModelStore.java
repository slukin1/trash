package androidx.lifecycle;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ViewModelStore {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, ViewModel> f9973a = new LinkedHashMap();

    public final void a() {
        for (ViewModel clear : this.f9973a.values()) {
            clear.clear();
        }
        this.f9973a.clear();
    }

    public final ViewModel b(String str) {
        return this.f9973a.get(str);
    }

    public final Set<String> c() {
        return new HashSet(this.f9973a.keySet());
    }

    public final void d(String str, ViewModel viewModel) {
        ViewModel put = this.f9973a.put(str, viewModel);
        if (put != null) {
            put.onCleared();
        }
    }
}
