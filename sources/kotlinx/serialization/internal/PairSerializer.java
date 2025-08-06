package kotlinx.serialization.internal;

import kotlin.Pair;
import kotlin.jvm.internal.r;
import kotlin.l;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.f;

public final class PairSerializer<K, V> extends p0<K, V, Pair<? extends K, ? extends V>> {

    /* renamed from: c  reason: collision with root package name */
    public final f f57667c;

    public PairSerializer(b<K> bVar, b<V> bVar2) {
        super(bVar, bVar2, (r) null);
        this.f57667c = SerialDescriptorsKt.b("kotlin.Pair", new f[0], new PairSerializer$descriptor$1(bVar, bVar2));
    }

    /* renamed from: d */
    public K a(Pair<? extends K, ? extends V> pair) {
        return pair.getFirst();
    }

    /* renamed from: e */
    public V b(Pair<? extends K, ? extends V> pair) {
        return pair.getSecond();
    }

    /* renamed from: f */
    public Pair<K, V> c(K k11, V v11) {
        return l.a(k11, v11);
    }

    public f getDescriptor() {
        return this.f57667c;
    }
}
