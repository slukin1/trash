package jumio.core;

import android.view.Choreographer;
import com.jumio.core.performance.JDisplayListener;

public final class t1 extends m1 {
    public t1(long j11, JDisplayListener jDisplayListener) {
        super(j11, jDisplayListener);
    }

    public final String a() {
        return t1.class.getSimpleName();
    }

    public final void b() {
        Choreographer.getInstance().postFrameCallback(this);
    }
}
