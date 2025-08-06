package kotlinx.coroutines.internal;

public final class o {
    public static final void a(int i11) {
        boolean z11 = true;
        if (i11 < 1) {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i11).toString());
        }
    }
}
