package y1;

import bolts.CancellationTokenSource;
import java.io.Closeable;

public class e implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final Object f16825b;

    /* renamed from: c  reason: collision with root package name */
    public CancellationTokenSource f16826c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f16827d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f16828e;

    public void close() {
        synchronized (this.f16825b) {
            if (!this.f16828e) {
                this.f16828e = true;
                this.f16826c.f(this);
                this.f16826c = null;
                this.f16827d = null;
            }
        }
    }
}
