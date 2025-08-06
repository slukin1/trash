package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;

public final class r0<K, V> extends z0<K, V, Map<K, ? extends V>, LinkedHashMap<K, V>> {

    /* renamed from: c  reason: collision with root package name */
    public final f f57762c;

    public r0(b<K> bVar, b<V> bVar2) {
        super(bVar, bVar2, (r) null);
        this.f57762c = new q0(bVar.getDescriptor(), bVar2.getDescriptor());
    }

    public f getDescriptor() {
        return this.f57762c;
    }

    /* renamed from: q */
    public LinkedHashMap<K, V> a() {
        return new LinkedHashMap<>();
    }

    /* renamed from: r */
    public int b(LinkedHashMap<K, V> linkedHashMap) {
        return linkedHashMap.size() * 2;
    }

    /* renamed from: s */
    public void c(LinkedHashMap<K, V> linkedHashMap, int i11) {
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
    public LinkedHashMap<K, V> k(Map<K, ? extends V> map) {
        LinkedHashMap<K, V> linkedHashMap = map instanceof LinkedHashMap ? (LinkedHashMap) map : null;
        return linkedHashMap == null ? new LinkedHashMap<>(map) : linkedHashMap;
    }

    /* renamed from: w */
    public Map<K, V> l(LinkedHashMap<K, V> linkedHashMap) {
        return linkedHashMap;
    }
}
