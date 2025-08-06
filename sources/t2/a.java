package t2;

public abstract class a<T> implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public i<T> f16541b;

    public a(i<T> iVar) {
        this.f16541b = iVar;
    }

    public abstract T a();

    public void run() {
        try {
            this.f16541b.a(a());
        } catch (Throwable th2) {
            th2.printStackTrace();
            this.f16541b.a(th2);
        }
    }
}
