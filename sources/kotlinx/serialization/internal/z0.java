package kotlinx.serialization.internal;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.a;
import kotlinx.serialization.encoding.d;

public abstract class z0<Key, Value, Collection, Builder extends Map<Key, Value>> extends a<Map.Entry<? extends Key, ? extends Value>, Collection, Builder> {

    /* renamed from: a  reason: collision with root package name */
    public final b<Key> f57803a;

    /* renamed from: b  reason: collision with root package name */
    public final b<Value> f57804b;

    public z0(b<Key> bVar, b<Value> bVar2) {
        super((r) null);
        this.f57803a = bVar;
        this.f57804b = bVar2;
    }

    public /* synthetic */ z0(b bVar, b bVar2, r rVar) {
        this(bVar, bVar2);
    }

    public abstract f getDescriptor();

    public final b<Key> m() {
        return this.f57803a;
    }

    public final b<Value> n() {
        return this.f57804b;
    }

    /* renamed from: o */
    public final void g(a aVar, Builder builder, int i11, int i12) {
        if (i12 >= 0) {
            kotlin.ranges.f n11 = RangesKt___RangesKt.n(RangesKt___RangesKt.o(0, i12 * 2), 2);
            int a11 = n11.a();
            int b11 = n11.b();
            int c11 = n11.c();
            if ((c11 > 0 && a11 <= b11) || (c11 < 0 && b11 <= a11)) {
                while (true) {
                    h(aVar, i11 + a11, builder, false);
                    if (a11 != b11) {
                        a11 += c11;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException("Size must be known in advance when using READ_ALL".toString());
        }
    }

    /* renamed from: p */
    public final void h(a aVar, int i11, Builder builder, boolean z11) {
        int i12;
        Value value;
        Object c11 = a.C0670a.c(aVar, getDescriptor(), i11, this.f57803a, (Object) null, 8, (Object) null);
        boolean z12 = true;
        if (z11) {
            i12 = aVar.w(getDescriptor());
            if (i12 != i11 + 1) {
                z12 = false;
            }
            if (!z12) {
                throw new IllegalArgumentException(("Value must follow key in a map, index for key: " + i11 + ", returned index for value: " + i12).toString());
            }
        } else {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (!builder.containsKey(c11) || (this.f57804b.getDescriptor().getKind() instanceof e)) {
            value = a.C0670a.c(aVar, getDescriptor(), i13, this.f57804b, (Object) null, 8, (Object) null);
        } else {
            value = aVar.p(getDescriptor(), i13, this.f57804b, MapsKt__MapsKt.i(builder, c11));
        }
        builder.put(c11, value);
    }

    public void serialize(d dVar, Collection collection) {
        int e11 = e(collection);
        f descriptor = getDescriptor();
        kotlinx.serialization.encoding.b z11 = dVar.z(descriptor, e11);
        Iterator d11 = d(collection);
        int i11 = 0;
        while (d11.hasNext()) {
            Map.Entry entry = (Map.Entry) d11.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            int i12 = i11 + 1;
            z11.F(getDescriptor(), i11, m(), key);
            z11.F(getDescriptor(), i12, n(), value);
            i11 = i12 + 1;
        }
        z11.c(descriptor);
    }
}
