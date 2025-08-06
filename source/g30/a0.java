package g30;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import zendesk.classic.messaging.e;

public class a0 {

    /* renamed from: f  reason: collision with root package name */
    public static final long f60274f = TimeUnit.SECONDS.toMillis(3);

    /* renamed from: a  reason: collision with root package name */
    public final f f60275a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f60276b;

    /* renamed from: c  reason: collision with root package name */
    public final e f60277c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f60278d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f60279e = false;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ f f60280b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f60281c;

        public a(f fVar, e eVar) {
            this.f60280b = fVar;
            this.f60281c = eVar;
        }

        public void run() {
            this.f60280b.a(this.f60281c.o());
            a0.this.f60279e = false;
        }
    }

    public a0(f fVar, Handler handler, e eVar) {
        this.f60275a = fVar;
        this.f60276b = handler;
        this.f60277c = eVar;
        this.f60278d = new a(fVar, eVar);
    }

    public void a() {
        if (this.f60279e) {
            this.f60276b.removeCallbacks(this.f60278d);
            this.f60276b.postDelayed(this.f60278d, f60274f);
            return;
        }
        this.f60279e = true;
        this.f60275a.a(this.f60277c.n());
        this.f60276b.postDelayed(this.f60278d, f60274f);
    }
}
