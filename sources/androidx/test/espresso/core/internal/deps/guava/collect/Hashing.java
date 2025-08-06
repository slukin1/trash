package androidx.test.espresso.core.internal.deps.guava.collect;

final class Hashing {
    public static int a(int i11) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i11) * -862048943), 15)) * 461845907);
    }

    public static int b(Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }
}
