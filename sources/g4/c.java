package g4;

public abstract class c {

    public static class b extends c {

        /* renamed from: a  reason: collision with root package name */
        public volatile boolean f66268a;

        public b() {
            super();
        }

        public void b(boolean z11) {
            this.f66268a = z11;
        }

        public void c() {
            if (this.f66268a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static c a() {
        return new b();
    }

    public abstract void b(boolean z11);

    public abstract void c();

    public c() {
    }
}
