package androidx.datastore.migrations;

import android.content.SharedPreferences;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\u0018\u00002\u00020\u0001J\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u001c\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Landroidx/datastore/migrations/b;", "", "", "", "a", "Landroid/content/SharedPreferences;", "Landroid/content/SharedPreferences;", "prefs", "", "b", "Ljava/util/Set;", "keySet", "datastore_release"}, k = 1, mv = {1, 5, 1})
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final SharedPreferences f8952a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f8953b;

    public final Map<String, Object> a() {
        Map<String, ?> all = this.f8952a.getAll();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : all.entrySet()) {
            String str = (String) next.getKey();
            Set<String> set = this.f8953b;
            if (set == null ? true : set.contains(str)) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt__MapsJVMKt.d(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Set) {
                value = CollectionsKt___CollectionsKt.N0((Iterable) value);
            }
            linkedHashMap2.put(key, value);
        }
        return linkedHashMap2;
    }
}
