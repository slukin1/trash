package i6;

import android.os.Handler;
import android.os.HandlerThread;
import com.hbg.lib.network.pro.core.util.Period;
import java.util.Calendar;

public class q extends HandlerThread {

    /* renamed from: b  reason: collision with root package name */
    public final int f68183b = 100;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f68184c = 0;

    /* renamed from: d  reason: collision with root package name */
    public final long f68185d = Period.DAY_MILLS;

    /* renamed from: e  reason: collision with root package name */
    public long f68186e;

    /* renamed from: f  reason: collision with root package name */
    public c6.a f68187f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f68188g;

    /* renamed from: h  reason: collision with root package name */
    public final Runnable f68189h = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            long unused = q.this.f68184c = System.currentTimeMillis();
            q.this.f68188g.postDelayed(q.this.f68189h, 100);
            if (q.this.f68184c > q.this.f68186e) {
                q.f(q.this, Period.DAY_MILLS);
                if (q.this.f68187f != null) {
                    q.this.f68187f.a();
                }
            }
        }
    }

    public q(String str) {
        super(str);
    }

    public static /* synthetic */ long f(q qVar, long j11) {
        long j12 = qVar.f68186e + j11;
        qVar.f68186e = j12;
        return j12;
    }

    public void h(c6.a aVar) {
        this.f68187f = aVar;
    }

    public void onLooperPrepared() {
        super.onLooperPrepared();
        Calendar instance = Calendar.getInstance();
        instance.set(6, instance.get(6) + 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.f68186e = instance.getTimeInMillis();
        Handler handler = new Handler(getLooper());
        this.f68188g = handler;
        handler.post(this.f68189h);
    }
}
