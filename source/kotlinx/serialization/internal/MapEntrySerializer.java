package kotlinx.serialization.internal;

import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;

public final class MapEntrySerializer<K, V> extends p0<K, V, Map.Entry<? extends K, ? extends V>> {

    /* renamed from: c  reason: collision with root package name */
    public final f f57660c;

    public static final class a<K, V> implements Map.Entry<K, V>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final K f57661b;

        /* renamed from: c  reason: collision with root package name */
        public final V f57662c;

        public a(K k11, V v11) {
            this.f57661b = k11;
            this.f57662c = v11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(getKey(), aVar.getKey()) && x.b(getValue(), aVar.getValue());
        }

        public K getKey() {
            return this.f57661b;
        }

        public V getValue() {
            return this.f57662c;
        }

        public int hashCode() {
            int i11 = 0;
            int hashCode = (getKey() == null ? 0 : getKey().hashCode()) * 31;
            if (getValue() != null) {
                i11 = getValue().hashCode();
            }
            return hashCode + i11;
        }

        public V setValue(V v11) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public String toString() {
            return "MapEntry(key=" + getKey() + ", value=" + getValue() + ')';
        }
    }

    public MapEntrySerializer(b<K> bVar, b<V> bVar2) {
        super(bVar, bVar2, (r) null);
        this.f57660c = SerialDescriptorsKt.c("kotlin.collections.Map.Entry", i.c.f57649a, new f[0], new MapEntrySerializer$descriptor$1(bVar, bVar2));
    }

    /* renamed from: d */
    public K a(Map.Entry<? extends K, ? extends V> entry) {
        return entry.getKey();
    }

    /* renamed from: e */
    public V b(Map.Entry<? extends K, ? extends V> entry) {
        return entry.getValue();
    }

    /* renamed from: f */
    public Map.Entry<K, V> c(K k11, V v11) {
        return new a(k11, v11);
    }

    public f getDescriptor() {
        return this.f57660c;
    }
}
