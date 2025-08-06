package t2;

public class k<T> extends g<T> {

    /* renamed from: d  reason: collision with root package name */
    public int f16559d;

    public k(b<T> bVar, int i11) {
        super(bVar);
        this.f16559d = i11;
    }

    public T a() {
        while (true) {
            try {
                return super.a();
            } catch (Throwable th2) {
                if (this.f16559d > 0) {
                    this.f16559d--;
                } else {
                    throw th2;
                }
            }
        }
    }
}
