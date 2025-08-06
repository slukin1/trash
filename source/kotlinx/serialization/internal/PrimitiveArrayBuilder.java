package kotlinx.serialization.internal;

public abstract class PrimitiveArrayBuilder<Array> {
    public static /* synthetic */ void c(PrimitiveArrayBuilder primitiveArrayBuilder, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = primitiveArrayBuilder.d() + 1;
            }
            primitiveArrayBuilder.b(i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: ensureCapacity");
    }

    public abstract Array a();

    public abstract void b(int i11);

    public abstract int d();
}
