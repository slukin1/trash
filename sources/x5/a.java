package x5;

import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static int f66661c = 4;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<HandlerThread> f66662a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicInteger f66663b;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f66664a = new a();
    }

    public static a b() {
        return b.f66664a;
    }

    public int a() {
        return this.f66663b.getAndIncrement();
    }

    public Looper c(int i11) {
        int i12 = i11 % f66661c;
        if (i12 >= this.f66662a.size()) {
            HandlerThread handlerThread = new HandlerThread("FrameDecoderExecutor-" + i12);
            handlerThread.start();
            this.f66662a.add(handlerThread);
            Looper looper = handlerThread.getLooper();
            if (looper != null) {
                return looper;
            }
            return Looper.getMainLooper();
        } else if (this.f66662a.get(i12) == null) {
            return Looper.getMainLooper();
        } else {
            Looper looper2 = this.f66662a.get(i12).getLooper();
            if (looper2 != null) {
                return looper2;
            }
            return Looper.getMainLooper();
        }
    }

    public a() {
        this.f66662a = new ArrayList<>();
        this.f66663b = new AtomicInteger(0);
    }
}
