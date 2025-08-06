package kotlinx.serialization.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;

public final class f0<K, V> extends z0<K, V, Map<K, ? extends V>, HashMap<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    public final f f57713c;

    public f0(b<K> bVar, b<V> bVar2) {
        super(bVar, bVar2, (r) null);
        this.f57713c = new e0(bVar.getDescriptor(), bVar2.getDescriptor());
    }

    public f getDescriptor() {
        return this.f57713c;
    }

    /* renamed from: q */
    public HashMap<K, V> a() {
        return new HashMap<>();
    }

    /* renamed from: r */
    public int b(HashMap<K, V> hashMap) {
        return hashMap.size() * 2;
    }

    /* renamed from: s */
    public void c(HashMap<K, V> hashMap, int i11) {
    }

    /* renamed from: t */
    public Iterator<Map.Entry<K, V>> d(Map<K, ? extends V> map) {
        return map.entrySet().iterator();
    }

    /* renamed from: u */
    public int e(Map<K, ? extends V> map) {
        return map.size();
    }

    /* renamed from: v */
    public HashMap<K, V> k(Map<K, ? extends V> map) {
        HashMap<K, V> hashMap = map instanceof HashMap ? (HashMap) map : null;
        return hashMap == null ? new HashMap<>(map) : hashMap;
    }

    /* renamed from: w */
    public Map<K, V> l(HashMap<K, V> hashMap) {
        return hashMap;
    }
}
