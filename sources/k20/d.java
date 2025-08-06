package k20;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.EventBusException;

public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final g f68219a = new g();

    /* renamed from: b  reason: collision with root package name */
    public final int f68220b;

    /* renamed from: c  reason: collision with root package name */
    public final EventBus f68221c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f68222d;

    public d(EventBus eventBus, Looper looper, int i11) {
        super(looper);
        this.f68221c = eventBus;
        this.f68220b = i11;
    }

    public void a(l lVar, Object obj) {
        f a11 = f.a(lVar, obj);
        synchronized (this) {
            this.f68219a.a(a11);
            if (!this.f68222d) {
                this.f68222d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                f b11 = this.f68219a.b();
                if (b11 == null) {
                    synchronized (this) {
                        b11 = this.f68219a.b();
                        if (b11 == null) {
                            this.f68222d = false;
                            this.f68222d = false;
                            return;
                        }
                    }
                }
                this.f68221c.g(b11);
            } while (SystemClock.uptimeMillis() - uptimeMillis < ((long) this.f68220b));
            if (sendMessage(obtainMessage())) {
                this.f68222d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } catch (Throwable th2) {
            this.f68222d = false;
            throw th2;
        }
    }
}
