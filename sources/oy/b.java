package oy;

public class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public long f37234b;

    /* renamed from: c  reason: collision with root package name */
    public Runnable f37235c = null;

    public b(Runnable runnable) {
        this.f37235c = runnable;
    }

    public void run() {
        try {
            Runnable runnable = this.f37235c;
            if (runnable != null) {
                runnable.run();
                this.f37235c = null;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public b(Runnable runnable, long j11) {
        this.f37235c = runnable;
        this.f37234b = j11;
    }
}
