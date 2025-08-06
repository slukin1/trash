package kotlinx.serialization.internal;

final class ClassValueReferences<T> extends ClassValue<MutableSoftReference<T>> {
    /* renamed from: a */
    public MutableSoftReference<T> computeValue(Class<?> cls) {
        return new MutableSoftReference<>();
    }
}
