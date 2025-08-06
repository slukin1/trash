package kotlinx.coroutines;

public abstract class MainCoroutineDispatcher extends CoroutineDispatcher {
    public abstract MainCoroutineDispatcher G();

    public final String H() {
        MainCoroutineDispatcher mainCoroutineDispatcher;
        MainCoroutineDispatcher c11 = v0.c();
        if (this == c11) {
            return "Dispatchers.Main";
        }
        try {
            mainCoroutineDispatcher = c11.G();
        } catch (UnsupportedOperationException unused) {
            mainCoroutineDispatcher = null;
        }
        if (this == mainCoroutineDispatcher) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    public String toString() {
        String H = H();
        if (H != null) {
            return H;
        }
        return k0.a(this) + '@' + k0.b(this);
    }
}
