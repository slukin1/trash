package kotlinx.serialization.internal;

import java.lang.Enum;
import java.util.Arrays;
import kotlin.i;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;

public final class EnumSerializer<T extends Enum<T>> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T[] f57657a;

    /* renamed from: b  reason: collision with root package name */
    public f f57658b;

    /* renamed from: c  reason: collision with root package name */
    public final i f57659c;

    public EnumSerializer(String str, T[] tArr) {
        this.f57657a = tArr;
        this.f57659c = LazyKt__LazyJVMKt.a(new EnumSerializer$descriptor$2(this, str));
    }

    public final f c(String str) {
        EnumDescriptor enumDescriptor = new EnumDescriptor(str, this.f57657a.length);
        for (T name : this.f57657a) {
            PluginGeneratedSerialDescriptor.l(enumDescriptor, name.name(), false, 2, (Object) null);
        }
        return enumDescriptor;
    }

    /* renamed from: d */
    public T deserialize(c cVar) {
        int s11 = cVar.s(getDescriptor());
        boolean z11 = false;
        if (s11 >= 0 && s11 < this.f57657a.length) {
            z11 = true;
        }
        if (z11) {
            return this.f57657a[s11];
        }
        throw new SerializationException(s11 + " is not among valid " + getDescriptor().h() + " enum values, values size is " + this.f57657a.length);
    }

    /* renamed from: e */
    public void serialize(d dVar, T t11) {
        int Q = ArraysKt___ArraysKt.Q(this.f57657a, t11);
        if (Q != -1) {
            dVar.g(getDescriptor(), Q);
            return;
        }
        throw new SerializationException(t11 + " is not a valid enum " + getDescriptor().h() + ", must be one of " + Arrays.toString(this.f57657a));
    }

    public f getDescriptor() {
        return (f) this.f57659c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().h() + '>';
    }
}
