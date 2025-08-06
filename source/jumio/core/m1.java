package jumio.core;

import android.view.Choreographer;
import com.jumio.commons.log.Log;
import com.jumio.core.performance.JDisplayListener;
import d10.l;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public abstract class m1 implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final long f56274a;

    /* renamed from: b  reason: collision with root package name */
    public final JDisplayListener f56275b;

    /* renamed from: c  reason: collision with root package name */
    public final ArrayList f56276c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public long f56277d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56278e = true;

    public m1(long j11, JDisplayListener jDisplayListener) {
        this.f56274a = j11;
        this.f56275b = jDisplayListener;
    }

    public abstract String a();

    public final void a(long j11) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f56276c);
        String a11 = a();
        String k02 = CollectionsKt___CollectionsKt.k0(arrayList, ", \n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
        Log.d(a11, "Publishing frame timing values " + k02);
        this.f56275b.onFramesSampled(arrayList);
        this.f56276c.clear();
        this.f56277d = j11;
    }

    public abstract void b();

    public final void doFrame(long j11) {
        boolean z11 = false;
        if (!this.f56278e) {
            this.f56278e = false;
            this.f56276c.clear();
            return;
        }
        if (this.f56277d == 0) {
            this.f56277d = j11;
        }
        if (j11 - this.f56277d > this.f56274a) {
            z11 = true;
        }
        if (z11) {
            String a11 = a();
            int size = this.f56276c.size();
            long convert = TimeUnit.MILLISECONDS.convert(j11 - this.f56277d, TimeUnit.NANOSECONDS);
            Log.d(a11, "Sampling finished with " + size + " frames, elapsed time was " + convert);
            a(j11);
        }
        this.f56276c.add(Long.valueOf(j11));
        b();
    }
}
